package array;
import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

@RunWith(Enclosed.class)
public class CombineFile {

    /**
     *

     * @param target
     * @return
     *
     * 待传输文件被切分成多个部分，按照原排列顺序，每部分文件编号均为一个 正整数（至少含有两个文件）。传输要求为：连续文件编号总和为接收方指定数字 target 的所有文件。
     * 请返回所有符合该要求的文件传输组合列表。
     *
     * 注意，返回时需遵循以下规则：
     *
     * 每种组合按照文件编号 升序 排列；
     * 不同组合按照第一个文件编号 升序 排列。
     *
     *
     * 示例 1：
     *
     * 输入：target = 12
     * 输出：[[3, 4, 5]]
     * 解释：在上述示例中，存在一个连续正整数序列的和为 12，为 [3, 4, 5]。
     * 示例 2：
     *
     * 输入：target = 18
     * 输出：[[3,4,5,6],[5,6,7]]
     * 解释：在上述示例中，存在两个连续正整数序列的和分别为 18，分别为 [3, 4, 5, 6] 和 [5, 6, 7]。
     *
     * 作者：Krahets
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fdcue/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[][] fileCombination(int target) {

        int i = 1, j = 2, s = 3;
        ArrayList<int[]> list = new ArrayList<>();

        while (i < j) {
            if(s == target){
                // 构建组合
                int[] res = new int[j - i + 1];
                for(int k =i; k <= j; k++){
                    res[k - i] = k;
                }
                list.add(res);

                s = s - i;
                i++;


            }else  if(s < target){
                j++;
                s = s + j;
            }else{
                s = s - i;
                i++;
            }
        }


        return list.toArray(new int[0][]);
    }

    public static class CombineFileTest {

        @Test
        public void testFileCombinationWithTarget12() {
            CombineFile combineFile = new CombineFile();
            int[][] expected = {{3, 4, 5}};
            Assert.assertArrayEquals(expected, combineFile.fileCombination(12));
        }

        @Test
        public void testFileCombinationWithTarget18() {
            CombineFile combineFile = new CombineFile();
            int[][] expected = {{3, 4, 5, 6}, {5, 6, 7}};
            Assert.assertArrayEquals(expected, combineFile.fileCombination(18));
        }

        @Test
        public void testFileCombinationWithTarget1() {
            CombineFile combineFile = new CombineFile();
            // Since the target is 1, and the numbers used are at least 2,
            // there should be no combinations.
            int[][] expected = {};
            Assert.assertArrayEquals(expected, combineFile.fileCombination(1));
        }

        @Test
        public void testFileCombinationWithTarget20() {
            CombineFile combineFile = new CombineFile();
            // The target 20 can be achieved by two different combinations: {4,5,6,7} and {6,7,8}
            int[][] expected = {{4, 5, 6, 7}, {6, 7, 8}};
            for (int[] ints : combineFile.fileCombination(200000)) {
                for (int anInt : ints) {
                    System.out.print(anInt + ",");
                }
                System.out.println();
            }
//            Assert.assertArrayEquals(expected,);
        }

        @Test
        public void testFileCombinationWithLargeTarget() {
            CombineFile combineFile = new CombineFile();
            // A larger target to test the loop's termination and correctness under higher values.
            int[][] expected = {{9, 10, 11, 12, 13}, {11, 12, 13, 14}, {13, 14, 15}};
            Assert.assertArrayEquals(expected, combineFile.fileCombination(50));
        }

        @Test
        public void testFileCombinationWithZeroTarget() {
            CombineFile combineFile = new CombineFile();
            // Target of 0 is not possible as the smallest file number starts from 1.
            int[][] expected = {};
            Assert.assertArrayEquals(expected, combineFile.fileCombination(0));
        }
    }

}
