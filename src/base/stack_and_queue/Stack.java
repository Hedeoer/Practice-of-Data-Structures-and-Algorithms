package base.stack_and_queue;

public class Stack {
    public static void main(String[] args) {
        java.util.Stack<Integer> stacks = new java.util.Stack<>();

        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);


        System.out.println(stacks.peek());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.size());
    }
}
