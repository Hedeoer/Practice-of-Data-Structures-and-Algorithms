package base.stack_and_queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateBookSequences {
    /**
     * 现在图书馆有一堆图书需要放入书架，并且图书馆的书架是一种特殊的数据结构，只能按照 一定 的顺序 放入 和 拿取 书籍。
     *
     * 给定一个表示图书放入顺序的整数序列 putIn，请判断序列 takeOut 是否为按照正确的顺序拿取书籍的操作序列。你可以假设放入书架的所有书籍编号都不相同。
     * 示例 1：
     * 输入：putIn = [6,7,8,9,10,11], takeOut = [9,11,10,8,7,6]
     * 输出：true
     * 解释：我们可以按以下操作放入并拿取书籍：
     * push(6), push(7), push(8), push(9), pop() -> 9,
     * push(10), push(11),pop() -> 11,pop() -> 10, pop() -> 8, pop() -> 7, pop() -> 6
     *
     * 示例 2：
     * 输入：putIn = [6,7,8,9,10,11], takeOut = [11,9,8,10,6,7]
     * 输出：false
     * 解释：6 不能在 7 之前取出。
     *
     * 作者：Krahets
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7f6f91/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param putIn
     * @param takeOut
     * @return
     */
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {

        /*
        *最终的效果：按照takeOut的顺序拿取书籍，最终putIn的元素为空，返回true，表示是合理的放入和拿取顺序；否则返回false
        * */
        if(putIn.length != takeOut.length) return false;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : putIn) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == takeOut[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();


    }


    @Nested
    class ValidateBookSequencesTest {
        private ValidateBookSequences validator;

        @BeforeEach
        void setUp() {
            validator = new ValidateBookSequences();
        }

        @Test
        void validSequenceReturnsTrue() {
            int[] putIn = {6, 7, 8, 9, 10, 11};
            int[] takeOut = {9, 11, 10, 8, 7, 6};
            assertTrue(validator.validateBookSequences(putIn, takeOut));
        }

        @Test
        void invalidSequenceReturnsFalse() {
            int[] putIn = {6, 7, 8, 9, 10, 11};
            int[] takeOut = {11, 9, 8, 10, 6, 7};
            assertFalse(validator.validateBookSequences(putIn, takeOut));
        }

        @Test
        void emptyPutInAndTakeOutReturnsTrue() {
            int[] putIn = {};
            int[] takeOut = {};
            assertTrue(validator.validateBookSequences(putIn, takeOut));
        }

        @Test
        void takeOutLongerThanPutInReturnsFalse() {
            int[] putIn = {6, 7, 8};
            int[] takeOut = {8, 7, 6, 5};
            assertFalse(validator.validateBookSequences(putIn, takeOut));
        }

        @Test
        void putInLongerThanTakeOutReturnsFalse() {
            int[] putIn = {6, 7, 8, 9};
            int[] takeOut = {8, 7, 6};
            assertFalse(validator.validateBookSequences(putIn, takeOut));
        }

        @Test
        void takeOutWithNonExistingBooksReturnsFalse() {
            int[] putIn = {6, 7, 8};
            int[] takeOut = {8, 7, 10};
            assertFalse(validator.validateBookSequences(putIn, takeOut));
        }
    }
}
