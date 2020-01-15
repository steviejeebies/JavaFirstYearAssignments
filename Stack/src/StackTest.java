
public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);  // 3 is in position 0 of stack
        stack.push(6);  // 6 is in position 1 of stack
        stack.push(12); // 12 is in position 2 of stack
        stack.push(24); // 24 is in position 3 of stack

        System.out.println();

        System.out.println("To show peek() working, the next 3 lines should be 24:");
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        System.out.println("6 is in position " + stack.search(6));

        System.out.println("3 is currently at the bottom of the stack. "
                + "I will move 3 to the top of the stack...");

        stack.move(3);

        System.out.println("And finally I will peek to see that 3 is on the top "
                + "of the stack: " + stack.peek());

        System.out.println("Pop until none left in stack, then throw error:");

        boolean finished = false;
        while(!finished)
        {
            try
            {
                System.out.print(stack.pop());
            }
            catch(java.util.EmptyStackException e)
            {
                finished = true;
            }
        }
    }

}
