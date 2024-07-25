package base.stack_and_queue;

import java.util.LinkedList;

public class CQueue {

    LinkedList<Integer> A, B;
    public CQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.add(value);
    }

    public int deleteHead() {
        if (!B.isEmpty()) {
            return B.removeLast();
        }
        if (A.isEmpty()) {
            return -1;
        }
        while (!A.isEmpty()) {
            B.add(A.removeLast());
        }
        return B.removeLast();
    }
}
