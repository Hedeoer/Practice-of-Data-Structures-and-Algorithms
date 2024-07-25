package base.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxAltitude {

    /**
     * 输入：heights = [14,2,27,-5,28,13,39], limit = 3
     * 输出：[27,27,28,28,39]
     * 解释：
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [14 2 27] -5 28 13 39          27
     * 14 [2 27 -5] 28 13 39          27
     * 14 2 [27 -5 28] 13 39          28
     * 14 2 27 [-5 28 13] 39          28
     * 14 2 27 -5 [28 13 39]          39

     * 作者：Krahets
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fkc57/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param heights
     * @param limit
     * @return
     * 方法一：暴力搜索
     */
    public int[] maxAltitude(int[] heights, int limit) {
        // 检查输入参数的合法性
        if (heights == null || heights.length == 0 || limit <= 0) {
            return new int[]{};
        }

        // 初始化滑动窗口的起始和结束位置
        int windowStart = Math.min(limit - 1, heights.length - 1);
        int windowEnd = 0;
        int[] result = new int[heights.length - limit + 1];
        int resultIndex = 0;

        while (windowStart <= heights.length - 1) {
            // 寻找窗口内的最大值
            int maxValue = findMaxValueInWindow(heights, windowEnd, windowStart);

            // 存储最大值到结果数组
            result[resultIndex] = maxValue;
            resultIndex++;

            // 移动窗口
            windowEnd++;
            windowStart++;
        }

        return result;
    }


    /**
     * 方法二：单调队列
     * @param heights
     * @param limit
     * @return
     */
    public int[] maxAltitude1(int[] heights, int limit){
        if(heights.length == 0 || limit <= 0) return new int[]{};
        // 存储结果的数组
        int[] result = new int[heights.length - limit + 1];
        // 利用链表构建队列,此队列头部永远是滑动窗口的最大值
        Deque<Integer> deque = new LinkedList<>();

        // 遍历heights
        for (int i = 1 - limit, j= 0; j < heights.length; i++,j++){
            // 如果移动窗口时，滑出窗口的元素在队列中，即如果再次滑动窗口，窗口的最大可能发生改变，此时需要将队首的元素出队。
            // 只有 i > 0，最小为1， 即比较了一次，deque中出现了最大值，才可能将 deque.peekFirst() 和 heights[i - 1] 比较；否则deque.peekFirst()可能出现空指针
            if(i > 0 && heights[i - 1] == deque.peekFirst()){
                // 队首元素出队
                deque.removeFirst();
            }
            // 如果队尾元素小于将要滑入窗口的元素height[j]，将队列中小于height[j]的所有元素出队
            // 目的：需要只是每个窗口内的最大值，那么每滑入一个元素，出队比滑入元素小的所有元素，将减少每次的比较的次数
            while (!deque.isEmpty() && heights[j] >= deque.peekLast()) {
                deque.removeLast();
            }
            // 经过上面的流程，height[j]必为窗口最大值， 将height[j]加入队尾
            deque.addLast(  heights[j]);
            // 当形成完整的窗口时， 每滑入一个元素，将窗口的最大值存入结果数组中
            // 初始化 i= 1 - limit，i >= 0保证出现了一个limit长度的窗口，且窗口内的最大值出现，才将最大值存入结果数组中
            if (i >= 0) {
                result[i] = deque.peekFirst();
            }
        }

        return result;
    }




    /**
     * 在指定窗口内寻找最大值
     * @param heights 高度数组
     * @param windowStart 窗口开始索引
     * @param windowEnd 窗口结束索引
     * @return 窗口内的最大值
     */
    private int findMaxValueInWindow(int[] heights, int windowStart, int windowEnd) {
        int maxValue = heights[windowStart];
        for (int i = windowStart + 1; i <= windowEnd; i++) {
            if (heights[i] > maxValue) {
                maxValue = heights[i];
            }
        }
        return maxValue;
    }

}
