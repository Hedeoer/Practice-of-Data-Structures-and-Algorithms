package string;

import array.SpiralArray;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicPassword {
    public String dynamicPassword(String password, int target) {
        if(password == null || password.length() == 0){
            return "";
        }
        if(target < 0 || target > password.length()){
            return password;
        }
        StringBuilder res = new StringBuilder();
        for(int i = target; i < password.length(); i++)
            res.append(password.charAt(i));
        for(int i = 0; i < target; i++)
            res.append(password.charAt(i));
        return res.toString();




    }



/**
 * Transforms a given password by rotating it based on a specified target index.
 * This method shifts characters in the password to the left by the target amount,
 * wrapping around to the beginning of the string. The transformation is applied
 * in such a way that the character at the position of the target index moves to
 * the start of the resulting string, followed by the rest of the characters in
 * their original order.
 *
 * @param password The original password string to be transformed.
 * @param target The target index indicating the number of positions each character
 *               in the password should be shifted. The actual shift is calculated
 *               as (index + target) % password.length(), ensuring wrapping.
 * @return A new string representing the transformed password. If the target is
 *         beyond the bounds of the password length, the transformation wraps
 *         around, effectively rotating the password.
 */
public String dynamicPassword2(String password, int target) {
    StringBuilder builder = new StringBuilder();

    // 利用求余的方式巧妙地实现了循环移位
    for (int index = 0; index < target + password.length(); index++) {
        builder.append(password.charAt((index + target) % password.length()));
    }
    return builder.toString();
}
}
