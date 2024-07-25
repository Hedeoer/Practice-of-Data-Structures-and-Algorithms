package array;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Enclosed.class)
public class SpiralArray {

    /**
     * 给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。
     *
     * 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。
     * 示例 1：
     *
     * 输入：array = [[1,2,3],[8,9,4],[7,6,5]]
     * 输出：[1,2,3,4,5,6,7,8,9]
     * 示例 2：
     *
     * 输入：array  = [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
     * 输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
     *
     * 作者：Krahets
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7flqdj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param array
     * @return
     */
    public int[] spiralArray(int[][] array) {

        /*
        * 1.两个方向索引数组 dr, dc
        * 2.标记数组的元素是否访问过的布尔类型数组 isVisited[][]
        * 3.存储最终遍历结果的list, result = new ArrayList<Integer>();
        * 4.遍历的起始位置， c = 0 , r = 0
        * 5.下一次遍历的位置 cr， cc ==》 array[cr][cc]
        * 6. 改变遍历方向的条件 cr >= 0 && cc >= 0 && cr < array.length && cc < array[0].length && !isVisited[cr][cc]
        * 7. 跳出循环的条件 array.length * array[0].length 次循环
        * 8. 最终返回 Arrays.toArray(result)
        * */


        ArrayList<Integer> result = new ArrayList<>();
        // 判断数组是否为空
        if( null == array || array.length == 0) {
            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        int cols = array[0].length;
        int rows = array.length;
        // 右，下， 左， 上
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        boolean[][] isVisited = new boolean[rows][cols];
        int c = 0 , r = 0;
        int di = 0;

        // 循环遍历矩阵元素次
        for (int i = 0; i < cols * rows; i++) {
            result.add(array[r][c]);
            isVisited[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];

            // 判断计算的cr，cc的位置元素是否可取（可取条件：行索引 cr 和列索引 cc均没有超过矩阵范围 并且 cr, cc位置上的元素没有被遍历添加到结果集中）
            // 注意 ： (!isVisited[cr][cc]) 需要放在条件的最后，避免数组越界
            if(  cr >= 0 && cc >= 0 && cr < rows && cc < cols && (!isVisited[cr][cc])  ){
                r = cr;
                c = cc;
            }else{
                // 改变遍历方向
                di = (di + 1) % 4; // 控制 di 范围 为 0,1,2,3 并且 每次加一控制遍历的方向
                r = r + dr[di];
                c = c + dc[di];
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] spiralArray2(int[][] array) {
        /*
        * 1. t, l, b, r分别定义矩阵的顶部， 左侧， 底部， 右侧; 初始化 t = 0; l = 0; b = array.length - 1; r = array[0].length - 1;
        * 2. 按照 顺时针方向遍历，每个方向上遍历完毕，需要判断是否到达矩阵边界，如果到达边界，退出循环
        *
        * */
        // 判断数组是否为空
        if(array.length == 0){
            return new int[]{};
        }
        // 分别定义上， 左， 下， 右边界值
        int t = 0, l = 0, b = array.length - 1, r = array[0].length - 1;
        // 构造结果数组
        int[] result = new int[(b + 1) * (r + 1)];

        int k = 0;
        while (true){
            // 1. 从左到右
            for(int i = l; i <= r; i++){
                result[k++] = array[t][i];
            }
            // 从左到右遍历后，需要从上到到下，从上到下之前需要判断上边界是否超过下边界，如果超过，意味着矩阵遍历完成了
            if( ++ t > b) break;


            // 2. 从上到下
            for(int i = t; i <= b; i++){
                result[k++] = array[i][r];
            }
            //从上到下遍历后，需要从右往左遍历， 从右往左遍历前需要判断左边界是否超过右边界，如果超过，意味着矩阵遍历完成了
            if( -- r < l) break;


            // 3. 从右往左
            for(int i = r; i >= l; i--){
                result[k++] = array[b][i];
            }
            // 从右往左遍历后，需要从下到上遍历，从下到上遍历前需要判断下边界是否超过上边界，如果超过，意味着矩阵遍历完成了
            if( -- b < t) break;


            // 4. 从下到上
            for(int i = b; i >= t; i--){
                result[k++] = array[i][l];
            }
            // 从下到上遍历后，需要从左往右遍历，从左往右遍历前需要判断左边界是否超过右边界，如果超过，意味着矩阵遍历完成了
            if( ++ l > r) break;

        }
        return  result;
    }


public static class SpiralArrayTest {

    private SpiralArray spiral = new SpiralArray();

    @Test
    public void testSpiralArrayExample() {
        int[][] array = {
            {1, 2, 3},
            {8, 9, 4},
            {7, 6, 5}
        };
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, spiral.spiralArray(array));
        assertArrayEquals(expected, spiral.spiralArray2(array));
    }

    @Test
    public void testSpiralArrayEmpty() {
        int[][] array = {};
        int[] expected = {};
        assertArrayEquals(expected, spiral.spiralArray(array));
        assertArrayEquals(expected, spiral.spiralArray2(array));

    }

    @Test
    public void testSpiralArrayOneRow() {
        int[][] array = {{1, 2, 3}};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, spiral.spiralArray(array));
        assertArrayEquals(expected, spiral.spiralArray2(array));

    }

    @Test
    public void testSpiralArrayOneColumn() {
        int[][] array = {{1}, {2}, {3}};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, spiral.spiralArray(array));
        assertArrayEquals(expected, spiral.spiralArray2(array));

    }

    @Test
    public void testSpiralArrayOddShape() {
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[] expected = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        assertArrayEquals(expected, spiral.spiralArray(array));
        assertArrayEquals(expected, spiral.spiralArray2(array));

    }

    @Test
    public void testSpiralArrayComplex() {
        int[][] array = {
            {1, 2, 3, 8},
            {9, 4, 5, 7},
            {6, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int[] expected = {1, 2, 3,  8, 7,  12, 16, 15, 14, 13, 6, 9, 4,5,11,10};
        assertArrayEquals(expected, spiral.spiralArray(array));
        assertArrayEquals(expected, spiral.spiralArray2(array));

    }
}


}
