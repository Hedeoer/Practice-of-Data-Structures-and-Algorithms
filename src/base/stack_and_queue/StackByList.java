package base.stack_and_queue;

import common.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackByList {
    private ListNode stackPeek; // 将头节点作为栈顶

    private int stkSize = 0; // 栈的长度

    // 获取栈的长度
    public int size(){
        return stkSize;
    }

    // 获取栈顶元素
    public int peek(){
        return stackPeek.getVal();
    }

    // 实现push方法
    public void push(int value){

        ListNode node = new ListNode(value);
        node.next = stackPeek;
        stackPeek = node;
        stkSize++;
    }

    // 实现pop方法
    public int pop(){
        int popValue = stackPeek.getVal();
        stackPeek = stackPeek.next;
        stkSize--;
        return popValue;
    }

    // 转变为数组'
    public int[] toArray(){
        int[] result = new int[stkSize];
        ListNode tmp;
        tmp  = stackPeek;

        for (int index = 0; index < stkSize; index++) {
            result[index] = tmp.getVal();
            tmp = tmp.next;
        }
    return result;
    }


    @Nested
    class StackByListTest {
    private StackByList stack;

    @BeforeEach
    void setUp() {
        stack = new StackByList();
    }

    @Test
    void isEmptyWhenNew() {
        assertEquals(0, stack.size());
    }

    @Test
    void pushIncreasesSize() {
        stack.push(1);
        assertEquals(1, stack.size());
    }

    @Test
    void popDecreasesSize() {
        stack.push(1);
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void peekReturnsLastPushedValue() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    void popReturnsLastPushedValue() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
    }

    @Test
    void popFollowedByPeekReturnsPreviousValue() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertEquals(1, stack.peek());
    }

    @Test
    void toArrayReturnsCorrectSequence() {
        stack.push(1);
        stack.push(2);
        assertArrayEquals(new int[]{2, 1}, stack.toArray());
    }

    @Test
    void popOnEmptyStackThrowsException() {
        assertThrows(NullPointerException.class, () -> stack.pop());
    }

    @Test
    void peekOnEmptyStackThrowsException() {
        assertThrows(NullPointerException.class, () -> stack.peek());
    }
}


}
