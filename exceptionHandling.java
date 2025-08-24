// This program for revise exception handling concepts

import java.util.Scanner;


class Applicant {

        private String name;
        private String jobProfile;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJobProfile() {
            return jobProfile;
        }

        public void setJobProfile(String jobProfile) {
            this.jobProfile = jobProfile;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


    class InvalidNameException extends Exception {
        public InvalidNameException(String message) {
            super(message);
        }
    }

    class InvalidJobProfileException extends Exception {
        public InvalidJobProfileException(String message) {
            super(message);
        }
    }


    class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(String.valueOf(message));
        }
    }


    class Validator{

        // Validate name: it should not be null or empty
        public boolean validateName(String name){
            if (name != null && !name.isEmpty()) {
                return true;
            }
            return false;
        }

        // Validate job profile: it should be one of the allowed values
        public boolean validateJobProfile(String jobProfile){
            String[] validProfiles = {"Associate", "Clerk", "Executive", "Officer"};
            for (String profile : validProfiles) {
                if (profile.equalsIgnoreCase(jobProfile)) {
                    return true;
                }
            }
            return false;
        }

        // Validate age: it should be between 18 and 30
        public boolean validateAge(int age){
            if (!(age >= 18 && age <= 30)) {
                return false;
            }
            return true;
        }

        public void validate(Applicant applicant) throws InvalidNameException, InvalidJobProfileException, InvalidAgeException {
            if (!validateName(applicant.getName())) {
                throw new InvalidNameException("Invalid name");
            }
            if (!validateJobProfile(applicant.getJobProfile())) {
                throw new InvalidJobProfileException("Invalid job profile");
            }
            if (!validateAge(applicant.getAge())) {
                throw new InvalidAgeException("Invalid age");
            }
        }

    }

    public class exceptionHandling {
        public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            System.out.println("\u001B[31mNote: Want to leave? Type exit\u001B[0m");  // \u001B[31m → Starts red text.

                                                                                      // \u001B[0m → Resets the color back to default after the message.


            while (true) {

                try {
                    Applicant applicant = new Applicant();

                    System.out.print("Enter your name:");
                    applicant.setName(sc.nextLine());
                    if (applicant.getName().equalsIgnoreCase("exit")) {
                        System.out.println("Exiting the application.");
                        break;
                    }

                    System.out.print("Enter your job profile: ");
                    applicant.setJobProfile(sc.nextLine());

                    System.out.print("Enter your age: ");
                    applicant.setAge(sc.nextInt());
                    sc.nextLine(); // Consume the leftover newline

                    Validator validator = new Validator();

                    validator.validate(applicant);
                    System.out.println("Application submitted successfully!");
                } catch (InvalidNameException | InvalidJobProfileException | InvalidAgeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

