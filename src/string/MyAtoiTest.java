package string;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyAtoiTest {

    private final MyAtoi myAtoi = new MyAtoi();

    @Test
    void convertsPositiveNumber() {

        assertEquals(123, myAtoi.myAtoi("+00123@"));
    }

    @Test
    void convertsNegativeNumber() {
        assertEquals(-123, myAtoi.myAtoi("-123"));
    }

    @Test
    void ignoresLeadingZeros() {
        assertEquals(123, myAtoi.myAtoi("+000123"));
    }

    @Test
    void returnsZeroForNonNumericString() {
        assertEquals(0, myAtoi.myAtoi("abc"));
    }

    @Test
    void handlesMaxIntegerOverflow() {
        // 2147483647
        assertEquals(Integer.MAX_VALUE, myAtoi.myAtoi("2147483648"));
    }

    @Test
    void handlesMinIntegerUnderflow() {
        assertEquals(Integer.MIN_VALUE, myAtoi.myAtoi("-2147483649"));
    }

    @Test
    void returnsZeroForEmptyString() {
        assertEquals(0, myAtoi.myAtoi(""));
    }

    @Test
    void ignoresNonNumericCharactersAfterNumber() {
        assertEquals(123, myAtoi.myAtoi("123abc"));
    }

    @Test
    void returnsZeroForStringWithOnlyNonNumericCharacters() {
        assertEquals(0, myAtoi.myAtoi("abcde"));
    }

    @Test
    void handlesSpaceBeforeNumber() {
        assertEquals(123, myAtoi.myAtoi("   123"));
    }

    @Test
    void ignoresCharactersAfterSpace() {
        assertEquals(-2147483648, myAtoi.myAtoi("-6147483648"));
    }
}