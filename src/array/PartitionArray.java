package array;

import org.junit.Test;

import java.util.Arrays;

public class PartitionArray {
    /**
     * 根据训练动作数组重新规划训练计划，将所有奇数动作提前到偶数动作之前。
     *
     * @param actions 原始的训练动作数组，每个元素代表一个动作的编号。
     * @return 新的训练计划数组，满足所有奇数动作在偶数动作之前。
     */
    public int[] trainingPlan(int[] actions) {
        /**
         * 教练使用整数数组 actions 记录一系列核心肌群训练项目编号。为增强训练趣味性，需要将所有奇数编号训练项目调整至偶数编号训练项目之前。请将调整后的训练项目编号以 数组 形式返回
         *
         * 输入：actions = [1,2,3,4,5]
         * 输出：[1,3,5,2,4]
         * 解释：为正确答案之一
         *
         * 作者：Krahets
         * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fwfti/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */

        // 计算原始数组长度
        int len = actions.length;
        // 初始化奇数动作的索引位置
        int oddIndex = 0;
        // 统计原始数组中奇数动作的数量
        int oddNums = 0;

        // 遍历原始数组，统计奇数动作的数量
        for (int i = 0; i < len; i++) {
            if (actions[i] % 2 != 0)
                ++oddNums;
        }

        // 初始化结果数组，用于存放重新规划后的训练计划
        int[] result = new int[len];

        // 从后向前遍历原始数组，根据奇偶性将动作放入结果数组的不同位置
        while (len > 0) {
            if (actions[len - 1] % 2 != 0) {
                // 如果当前动作是奇数，放入结果数组的奇数索引位置
                // 从头存放奇数
                result[oddIndex] = actions[len - 1];
                ++oddIndex;
            } else {
                // 如果当前动作是偶数，放入结果数组的偶数索引位置
                // 从中间开始存放偶数
                result[oddNums] = actions[len - 1];
                ++oddNums;
            }
            --len;
        }
        // 返回重新规划后的训练计划
        return result;
    }


    /**
     * 对给定的动作数组进行重排，确保所有奇数动作都位于偶数索引上，所有偶数动作都位于奇数索引上。
     *
     * @param actions 表示需要进行排序的动作数组，数组中的元素为整数。
     * @return 返回重新排序后的数组，满足所有奇数位于奇数索引，所有偶数位于偶数索引。
     */
    public int[] trainingPlan2(int[] actions) {
        /* 初始化奇数索引和偶数索引 */
        int oddIndex = 0;
        int evenIndex = actions.length - 1;

        /* 当奇数索引小于偶数索引时，进行循环交换 */
        while (oddIndex < evenIndex) {
            /* 寻找第一个偶数索引 */
            while (oddIndex < evenIndex && actions[oddIndex] % 2 == 1) {
                oddIndex++;
            }
            /* 寻找第一个奇数索引 */
            while (oddIndex < evenIndex && actions[evenIndex] % 2 == 0) {
                evenIndex--;
            }
            /* 如果奇数索引仍然小于偶数索引，则交换这两个索引处的元素 */
            if (oddIndex < evenIndex) {
                int temp = actions[oddIndex];
                actions[oddIndex] = actions[evenIndex];
                actions[evenIndex] = temp;
            }
        }
        /* 返回重新排序后的数组 */
        return actions;
    }

    @Test
    public void testTrainingPlanOddFirst() {
        PartitionArray partitionArray = new PartitionArray();
        int[] actions = {1, 2, 3, 4, 5};


        System.out.println(Arrays.toString(partitionArray.trainingPlan2(actions)));
    }
}
