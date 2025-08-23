import java.lang.Exception;

 class StackOverflow extends Exception {
     public String toString() {
         System.out.println("StackOverflow Exception");
         return "Stack Overflow Exception: The stack is full, cannot push more elements.";
     }
 }

    class StackUnderflow extends Exception
    {
        public String toString()
        {
            System.out.println("StackUnderflow Exception");
            return "Stack Underflow Exception: The stack is empty, cannot pop elements.";
        }
    }

    class Stack
    {
        private  int size;
        private int top= -1;
        private int stack[];

        public Stack(int size)
        {
            System.out.println("Stack constructor called with size: " + size);
            this.size = size;
            stack = new int[size];
        }

        public void push(int value) throws StackOverflow
        {
            if (top == size - 1)
                throw new StackOverflow();
            top++;
            stack[top] = value;
        }

        public int pop() throws StackUnderflow
        {
            int x =-1;
            if (top == -1)
                throw new StackUnderflow();
             x = stack[top];
            top--;
            return x;
        }
    }

    public class userdefinedException {
        public static void main(String[] args) {
            Stack stack = new Stack(5);

            try {
                stack.push(10);
                stack.push(20);
                stack.push(30);
                stack.push(40);
                stack.push(50);
                stack.push(60); // This will cause StackOverflow
            }catch (StackOverflow e) {
                System.out.println(e);
            }


            try {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop(); // This will cause StackUnderflow
            }
            catch (StackUnderflow e) {
                System.out.println(e);
            }
        }
        }




