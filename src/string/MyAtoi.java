package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyAtoi {
    /*
 请你来实现一myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。

函数myAtoi(string s) 的算法如下：

读入字符串并丢弃无用的前导空格
检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
返回整数作为最终结果。
注意：

本题中的空白字符只包括空格字符 ' ' 。
除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。

作者：Krahets
链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7f8nad/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public int myAtoi2(String str) {
        // 1. 输入的字符串为空，返回0
        if (str == null || str.length() == 0) {
            return 0;
        }
        /*
         * 1. 去除前导空格
         * 2. 判断正负号
         * 3. 如何去除正整数前面的0，或者负整数前面的0
         * 4. 如何判断读取的字符为数字
         * 5. 当读取的字符不是数字时，对返回结果做处理 1) 超出int正整数范围 2) 超出int负整数范围，超出直接取最值
         * 6. 如何读取最终的数字并累计为整数，双列map吗？
         *
         * 2147483647
         * */

        // 1. 去除前导空白字符
        str = str.replaceAll("^\\s+", "");

        // 是否为负数
        boolean is_negative = str.startsWith("-");
        // 对1233类型正数处理
        if (!is_negative && !str.startsWith("+")) {
            // 对 123类型补充符号位
            str = "+" + str;
        }

        // 去除无用字符0，例如：-00002323，+0000231中的0字符
        str = str.replaceAll("^[-+]?0+|^[-+]", "");// 去除正整数前面的0，或者负整数前面的0
        // 结果，结果可能超出int范围，选用long
        long res = 0;
        // 首个非数字字符的位置
        int scope = 0;
        String reg = "\\d";
        for (int index = 0; index < str.toCharArray().length; index++) {
            if (String.valueOf(str.toCharArray()[index]).matches(reg)) {
                ++scope;
            } else {
                break;
            }
        }

        str = str.substring(0, scope);

        // map,key为权重，value为数字，key，value均有可能超出int范围，选用long
        HashMap<Long, Long> numbers = new HashMap<>();
        for (int index = 0; index < str.length(); index++) {
            Long value = Long.valueOf(str.charAt(str.length() - 1 - index) + "");
            Long key = Long.valueOf((int) Math.pow(10, index) + "");

            numbers.put(key, value);
        }

        // 遍历map，累计结果
        Set<Map.Entry<Long, Long>> entries = numbers.entrySet();
        for (Map.Entry<Long, Long> entry : entries) {
            res += (entry.getKey() * entry.getValue());
        }
        if (is_negative) {
            res = -res;
        }

        // 超出int范围，取最值
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) res;
        }

    }

    /**
     * Converts a string to a 32-bit signed integer (similar to the atoi function in C/C++).
     * <p>
     * The function first trims any leading and trailing whitespace from the input string.
     * It then checks if the first character is a '+' (positive) or '-' (negative) sign,
     * and sets the parsing direction accordingly. The function iterates over each character
     * of the string; if the character is a digit, it is added to the result. The loop breaks
     * when a non-digit character is encountered.
     * <p>
     * If the accumulated result exceeds the range of 32-bit signed integer, it is clamped
     * to the nearest boundary value (Integer.MAX_VALUE or Integer.MIN_VALUE).
     * <p>
     *
     * @param str The input string to convert.
     * @return The converted integer. If the input string does not contain any digits, returns 0.
     * If the result exceeds the 32-bit integer range, returns the nearest boundary value.
     */
    public int myAtoi(String str) {
        if (null == str || str.isEmpty()) return 0;

        long res = 0;
        boolean isNegative = false;
        int startIndex = 0;

        str = str.trim();
        if (str.startsWith("-") || str.startsWith("+")) {
            isNegative = str.startsWith("-");
            startIndex = 1;
        }

        for (int index = startIndex; index < str.length(); index++) {
            if (!Character.isDigit(str.charAt(index))) {
                break;
            } else {
                res = res * 10 + (str.charAt(index) - '0');
                if (isNegative && -res < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (!isNegative && res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return (int) (isNegative ? -res : res);
    }
}
