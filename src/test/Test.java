package test;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {

        PriorityQueue<Integer> p = new PriorityQueue<>((x,y)->(y-x));
        p.add(1);
        p.add(2);
        p.add(3);
        while (!p.isEmpty()) {
            System.out.println(p.poll());
        }
        System.out.println(p.size());
    }
}
