package base.stack_and_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StackByArray {
    private int[] stackPeek;
    // 实际的元素个数
    private int stkSize ;
    // 数组初始的长度
    private int defaultSize = 10;

    // 默认的扩容倍数
    private int ratio = 2;

    public StackByArray(){
        stackPeek = new int[defaultSize];
        stkSize = 0;
    }

    // 获取栈的长度
    public int size(){
        return stkSize;
    }

    // 获取栈顶元素
    public int peek(){
        return stackPeek[stkSize - 1];
    }

    // 实现push方法
    public void push(int value){
        // 数组可能需要扩容
        if (stkSize == stackPeek.length) {
            incr();
        }
        // 需要push的元素加入到数组中
        stackPeek[stkSize] = value;
        stkSize ++ ;
    }

    private void incr() {
        int[] newStackPeek = new int[stkSize * ratio];
        System.arraycopy(stackPeek,0, newStackPeek, 0, stkSize);
        // 扩容后的数组赋值给原数组
        stackPeek = newStackPeek;
    }

    // 实现pop方法
    public int pop(){

        // 对非法的pop操作进行异常处理
        if (0 == stkSize) {
            throw new ArrayIndexOutOfBoundsException("Index -1 out of bounds for length 0");
        }
        int popValue = stackPeek[stkSize - 1];
        stkSize--;
        return popValue;
    }
//
//    // 转变为列表
//    public ArrayList<Integer> toList(){
//
//        return Arrays.asList(stackPeek);
//    }
//


    @Nested
    class StackByArrayTest {
    private StackByArray stack;

    @BeforeEach
    void setUp() {
        stack = new StackByArray();
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
        int poppedValue = stack.pop();
        assertEquals(0, stack.size());
        assertEquals(1, poppedValue);
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
    void stackExpandsBeyondInitialCapacity() {
        for (int i = 0; i < 15; i++) {
            stack.push(i);
        }
        assertEquals(15, stack.size());
    }

    @Test
    void popOnEmptyStackThrowsException() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.pop());
        assertTrue(exception.getMessage().contains("Index -1 out of bounds for length 0"));
    }


}

}
