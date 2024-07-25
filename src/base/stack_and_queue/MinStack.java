package base.stack_and_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 请你设计一个 最小栈 。它提供 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * -231 <= val <= 231 - 1
 * pop、top 和 getMin 操作总是在 非空栈 上调用
 * push、pop、top 和 getMin 最多被调用 3 * 104 次

 *
 * 作者：Krahets
 * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7f65om/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MinStack {

    Stack<Integer> A, B;
    /** initialize your data structure here. */
    public MinStack() {
    A= new Stack<Integer>();
    B = new Stack<Integer>();
    }

    public void push(int x) {
        A.add(x);
        if(B.isEmpty() || B.peek() >= x){
            B.add(x);
        }
    }

    public void pop() {
        if(A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {

        return A.peek();
    }

    public int getMin() {
        return B.peek();
    }

    /**
     * 使用链表实现最小栈的原理
     */
    class StackByList{
        LinkedList<Integer> A, B;
        /** initialize your data structure here. */
        public StackByList() {
            A= new LinkedList<Integer>();
            B = new LinkedList<Integer>();
        }

        public void push(int x) {
            A.addLast(x);
            if(B.isEmpty() || B.getLast() >= x){
                B.add(x);
            }
        }

        public void pop() {
            if(A.getLast().equals(B.getLast())){
                A.removeLast();
                B.removeLast();
            }else{
                A.removeLast();

            }
        }

        public int top() {

            return A.getLast();
        }

        public int getMin() {
            return B.getLast();
        }

    }


}
