package string;


import java.util.Arrays;

public class PathEncryption {

    /**
     * 假定一段路径记作字符串 path，其中以 "." 作为分隔符。现需将路径加密，加密方法为将 path 中的分隔符替换为空格 " "，请返回加密后的字符串。

     * 示例 1：
     *
     * 输入：path = "a.aef.qerf.bb"
     *
     * 输出："a aef qerf bb"
     *
     * 作者：Krahets
     * 链接：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fitwt/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param path
     * @return
     */
    public String pathEncryption(String path) {

        char[] chars = path.toCharArray();
        for (int index = 0; index < chars.length; index++) {
            if(chars[index] == '.'){
                chars[index] = ' ';
            }
        }
        return new String(chars);

    }

    public String pathEncryption1(String path) {
    StringBuilder encryptedPath = new StringBuilder();
    for (char c : path.toCharArray()) {
        if (c == '.') {
            encryptedPath.append(' ');
        } else {
            encryptedPath.append(c);
        }
    }
    return encryptedPath.toString();
}

}



