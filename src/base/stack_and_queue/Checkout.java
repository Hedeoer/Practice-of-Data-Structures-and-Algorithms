package base.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请设计一个自助结账系统，该系统需要通过一个队列来模拟顾客通过购物车的结算过程，需要实现的功能有：
 *
 * get_max()：获取结算商品中的最高价格，如果队列为空，则返回 -1
 * add(value)：将价格为 value 的商品加入待结算商品队列的尾部
 * remove()：移除第一个待结算的商品价格，如果队列为空，则返回 -1
 * 注意，为保证该系统运转高效性，以上函数的均摊时间复杂度均为 O(1)
 *
 * 作者：Krahets
 * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fg4x5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Checkout {
    /*
    * 问题分析
    * 1. 如何获取购物车中的商品的最高价格，并且O(1)时间复杂度
    * 2. 移除结算商品同时是否需要考虑购物车的最高商品最高价格，考虑，如何维护最值？
    * */
    // 使用链表实现队列
    // 购物车商品价格队列
    Queue<Integer> queue;
    // "单调不增队列"
    Deque<Integer> maxQueue;
    public Checkout() {
        // 初始化购物车商品
        queue = new LinkedList<Integer>();
        maxQueue = new LinkedList<Integer>();
    }

    public int get_max() {
        // 单调不增队列不为空，队首即为最大值
        return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
    }

    public void add(int value) {
        // 维护单调不增队列maxDeque,保证maxDeque的队首总是购物车中的商品最大值
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.removeLast();

        }
        // 加入结算商品
        queue.add(value);
        // 添加到单调不增队列
        maxQueue.add(value);
    }

    public int remove() {
        // 计算商品为空，则返回-1
        if(queue.isEmpty()) return -1;

        //如果结算商品和单调不增队列的队首相等，则移除单调不增队列的队首
        if(queue.peek().equals(maxQueue.peekFirst())){
            maxQueue.removeFirst();
        }
        // 移除结算商品
        return queue.remove();
    }

    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peekFirst());
    }
}
