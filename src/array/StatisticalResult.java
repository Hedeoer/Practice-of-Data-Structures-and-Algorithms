package array;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Enclosed.class)
public class StatisticalResult {
    /**
     *
     * @param arrayA
     * @return
     * 为了深入了解这些生物群体的生态特征，你们进行了大量的实地观察和数据采集。
     * 数组 arrayA 记录了各个生物群体数量数据，其中 arrayA[i] 表示第 i 个生物群体的数量。
     * 请返回一个数组 arrayB，该数组为基于数组 arrayA 中的数据计算得出的结果，
     * 其中 arrayB[i] 表示将第 i 个生物群体的数量从总体中排除后的其他数量的乘积。

     * 示例 1：
     *
     * 输入：arrayA = [2, 4, 6, 8, 10]
     * 输出：[1920, 960, 640, 480, 384]
     *
     * 作者：Krahets
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7f04lg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */

    public int[] statisticalResult(int[] arrayA) {

        int mulity = 1;
        for (int i = 0; i < arrayA.length; i++) {
            mulity = mulity * arrayA[i];
        }
        int[] result = new int[arrayA.length];

        for (int k = 0; k < arrayA.length; k++) {
            // 处理存在0 元素的情况，避免除数为0
            if(arrayA[k] == 0){
                // 初始化k位置的结果为1，避免因为不初始化，基本数据类型的默认值是0，造成后续累乘结果都是0
                result[k] = 1;
                // 计算除了 0 元素之外的其他元素的乘积
                for (int n = 0; n < arrayA.length; n++) {
                    if(n != k) {
                        result[k] = result[k] * arrayA[n];
                    }
                }
            }else {
                result[k] = mulity / arrayA[k];
            }
        }
        return result;
    }

    public int[] statisticalResult2(int[] arrayA) {
        if(arrayA.length == 0   ) return new int[0];
        if(arrayA.length == 1   ) return new int[]{0};

        int[] result = new int[arrayA.length];
        int tmp = 1;
        // 计算对角线左侧的累计乘积
        result[0] = 1;
        for(int i = 1; i < arrayA.length; i++){
            result[i] = result[i - 1] * arrayA[i - 1];
        }

        // 计算对角线右侧的累计乘积并和对角线左侧的累计值一一对应相乘得到：排除某个元素的其他元素乘积
        for(int k = arrayA.length - 2; k >= 0; k--){
            tmp = tmp * arrayA[k + 1];
            result[k] = result[k] * tmp;
        }


        return result;
    }


    public static class StatisticalResultTest2 {

        private StatisticalResult statisticalResult = new StatisticalResult();

        @Test
        public void testEmptyArray() {
            int[] emptyArray = {};
            int[] expected = {};
            assertArrayEquals(expected, statisticalResult.statisticalResult2(emptyArray));
        }

        @Test
        public void testSingleElementArray() {
            int[] singleElementArray = {5};
            int[] expected = {0};
            assertArrayEquals(expected, statisticalResult.statisticalResult2(singleElementArray));
        }

        @Test
        public void testMultipleElementArray() {
            int[] array = {2, 2, 3, 4};
            int[] expected = {24, 24, 16, 12};
            assertArrayEquals(expected, statisticalResult.statisticalResult2(array));
        }

        @Test
        public void testArrayWithZero() {
            int[] arrayWithZero = {1, 2, 0, 4};
            int[] expected = {0, 0, 0, 0};
            assertArrayEquals(expected, statisticalResult.statisticalResult2(arrayWithZero));
        }

        @Test
        public void testNegativeNumbers() {
            int[] negativeNumbers = {-1, -2, -3};
            int[] expected = {6, 3, 2};
            assertArrayEquals(expected, statisticalResult.statisticalResult2(negativeNumbers));
        }


    }


    public static class StatisticalResultTest {

        private StatisticalResult statisticalResult = new StatisticalResult();

        @Test
        public void testStatisticalResult() {
            int[] arrayA = {2, 4, 6};
            int[] expectedResult = {24, 12, 8};
            assertArrayEquals(expectedResult, statisticalResult.statisticalResult(arrayA));
        }

        @Test
        public void testStatisticalResultWithZero() {
            int[] arrayA = {2, 0, 6};
            int[] expectedResult = {0, 12, 0};
            assertArrayEquals(expectedResult, statisticalResult.statisticalResult(arrayA));
        }

        @Test
        public void testStatisticalResultWithNegativeNumbers() {
            int[] arrayA = {-2, -4, -6};
            int[] expectedResult = {24, 12, 8};
            assertArrayEquals(expectedResult, statisticalResult.statisticalResult(arrayA));
        }

        @Test
        public void testStatisticalResultWithEmptyArray() {
            int[] arrayA = {};
            int[] expectedResult = {};
            assertArrayEquals(expectedResult, statisticalResult.statisticalResult(arrayA));
        }

        @Test(expected = ArithmeticException.class)
        public void testStatisticalResultWithDivideByZero() {
            int[] arrayA = {0, 0, 0};
            statisticalResult.statisticalResult(arrayA);
        }
    }
}
