package base.stack_and_queue;

import java.util.LinkedList;

public class Deque {
    public static void main(String[] args) {
        java.util.Deque<Integer> deque = new LinkedList<>();

        // 队尾添加元素
        deque.offerLast(1);
        // 队首添加元素
        deque.offerFirst(12);
        deque.offerFirst(13);
        System.out.println(deque);

        //队首删除元素 pollFirst， removeFirst, poll..和remove..方法的区别在于删除失败时返回null（poll）还是抛出异常（remove）
        deque.removeFirst();  // deque.pollFirst();
        System.out.println(deque);
        //队尾删除元素 pollLast， removeLast
        deque.removeLast(); // deque.pollLast();
        System.out.println(deque);


        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        // 队首查看元素 peekFist,
        System.out.println(deque.peekFirst());
        // 队尾查看元素 peekLast，
        System.out.println(deque.peekLast());

        // 查看队列的元素个数
        System.out.println(deque.size());

        // 判断队列是否为空
        System.out.println(deque.isEmpty());



    }
}
