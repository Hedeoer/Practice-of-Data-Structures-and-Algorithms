package array;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class FindRepeatDoucument {
    /**
     * 设备中存有 n 个文件，文件 id 记于数组 documents。若文件 id 相同，则定义为该文件存在副本。请返回任一存在副本的文件 id。
     * 示例 1：
     *
     * 输入：documents = [2, 5, 3, 0, 5, 0]
     * 输出：0 或 5

     *
     * 提示：
     *
     * 0 ≤ documents[i] ≤ n-1
     * 2 <= n <= 100000
     *
     * 作者：Krahets
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7f7g7v/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param documents
     * @return
     */


    public int findRepeatDocument(int[] documents) {
//        HashMap<Integer, Integer> timesMap = new HashMap<>();
//        int result = -1;
//        for (int document : documents) {
//            if (null != timesMap.put(document,1)) {
//                result = document;
//                return result;
//            }
//        }
//        return result;

        Set<Integer> hmap = new HashSet<>();
        for(int doc : documents) {
            if(hmap.contains(doc)) return doc;
            hmap.add(doc);
        }
        return -1;


    }


    public int findRepeatDocument2(int[] documents) {

        int result = -1;
        int inc = 0;
        int tmp = 0;
        while(inc < documents.length){
            // 数组索引和数组值相等，说明该元素在符合规则（索引值和元素值相等）的位置上，跳过
            if( inc == documents[inc]){
                ++inc;
                continue;
            }
            // 索引值和元素值不相等，但是通过元素值在数组中寻找documents[documents[inc]]，
            // documents[inc]与之相等说明该元素存在副本，返回该元素
            if(documents[inc] == documents[documents[inc]]){
                result = documents[inc];
                return result;
            }
            // 索引值和元素值不相等，通过元素值在数组中寻找documents[documents[inc]]也没有副本
            // 使用交换的方式将元素放在符合规则的位置上
            tmp = documents[inc];
            documents[inc] = documents[tmp];
            documents[tmp] = tmp;

        }
        return result;
    }


public static class FindRepeatDocumentTest {

    FindRepeatDoucument findRepeatDocument = new FindRepeatDoucument() ;


    @Test
    public void testFindRepeatDocument2() {
        int[] documents = {0, 1, 2, 3, 4, 4};

        assertEquals("Expected to find repeat document at index 4", 4, findRepeatDocument.findRepeatDocument2(documents));
    }

    @Test
    public void testFindRepeatDocument2WithNoRepeat() {
        int[] documents = {0, 1, 2, 3, 4, 5};
        assertEquals("Expected to not find any repeat document", -1, findRepeatDocument.findRepeatDocument2(documents));
    }

    @Test
    public void testFindRepeatDocument2WithMultipleRepeats() {
        int[] documents = {0, 1, 2, 3, 3, 4};
        assertEquals("Expected to find the first repeat document", 3, findRepeatDocument.findRepeatDocument2(documents));
    }

    @Test
    public void testFindRepeatDocument2WithSelfRepeat() {
        int[] documents = {0,2,4, 3, 3, 3};
        assertEquals("Expected to find self repeat document", 3, findRepeatDocument.findRepeatDocument2(documents));
    }

    @Test
    public void testFindRepeatDocument2WithEmptyArray() {
        int[] documents = {};
        assertEquals("Expected to not find any repeat document in an empty array", -1, findRepeatDocument.findRepeatDocument2(documents));
    }

    @Test
    public void testFindRepeatDocument2WithSingleElement() {
        int[] documents = {0};
        assertEquals("Expected to not find any repeat document in a single-element array", -1, findRepeatDocument.findRepeatDocument2(documents));
    }
}





public static class FindRepeatDoucumentTest {

    @Test
    public void testFindRepeatDocument() {
        FindRepeatDoucument findRepeatDoucument = new FindRepeatDoucument();
        int[] documents = {2, 5, 3, 0, 5, 0};
        int result = findRepeatDoucument.findRepeatDocument(documents);
        assertEquals("The repeat document should be 5", 5, result);
    }

    @Test
    public void testFindRepeatDocumentWithNoRepeat() {
        FindRepeatDoucument findRepeatDoucument = new FindRepeatDoucument();
        int[] documents = {1, 2, 3, 4, 5};
        int result = findRepeatDoucument.findRepeatDocument(documents);
        assertEquals("There should be no repeat document", -1, result);
    }

    @Test
    public void testFindRepeatDocumentWithMultipleRepeats() {
        FindRepeatDoucument findRepeatDoucument = new FindRepeatDoucument();
        int[] documents = {1, 2, 3, 2, 4, 3};
        int result = findRepeatDoucument.findRepeatDocument(documents);
        assertEquals("The first repeat document should be 2", 2, result);
    }

    @Test
    public void testFindRepeatDocumentWithEmptyArray() {
        FindRepeatDoucument findRepeatDoucument = new FindRepeatDoucument();
        int[] documents = {};
        int result = findRepeatDoucument.findRepeatDocument(documents);
        assertEquals("There should be no repeat in an empty array", -1, result);
    }

    @Test
    public void testFindRepeatDocumentWithAllSameElements() {
        FindRepeatDoucument findRepeatDoucument = new FindRepeatDoucument();
        int[] documents = {1, 1, 1, 1};
        int result = findRepeatDoucument.findRepeatDocument(documents);
        assertEquals("Any element is a repeat when all elements are the same", 1, result);
    }
}



}
