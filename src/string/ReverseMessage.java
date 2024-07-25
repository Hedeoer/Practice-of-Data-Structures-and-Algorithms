package string;

import static org.junit.Assert.assertEquals;

public class ReverseMessage {
    /**
     * 示例 1：
     *
     * 输入: message = "the sky is blue"
     * 输出:"blue is sky the"
     * 示例 2：
     *
     * 输入: message = " hello world! "
     * 输出:"world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     *
     * 输入: message = "a good  example"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *
     * 作者：Krahets
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fulvr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param message
     * @return
     */

    public String reverseMessage(String message) {

        String[] split = message.trim().replaceAll("\\s+", " ").split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            result.append(split[i]);
            if(i>0){
                result.append(" ");
            }

        }
        return result.toString();
    }


}
