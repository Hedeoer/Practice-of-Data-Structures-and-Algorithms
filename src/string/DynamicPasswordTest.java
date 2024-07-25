package string;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicPasswordTest {

    private final DynamicPassword dynamicPassword = new DynamicPassword();

    @Test
    void returnsEmptyStringForNullPassword() {
        assertEquals("", dynamicPassword.dynamicPassword(null, 5));
    }

    @Test
    void returnsEmptyStringForEmptyPassword() {
        assertEquals("", dynamicPassword.dynamicPassword("", 5));
    }

    @Test
    void returnsOriginalPasswordForNegativeTarget() {
        assertEquals("password", dynamicPassword.dynamicPassword("password", -1));
    }

    @Test
    void returnsOriginalPasswordForTargetBeyondLength() {
        assertEquals("password", dynamicPassword.dynamicPassword("password", 9));
    }

    @Test
    void rearrangesPasswordBasedOnTarget() {
        assertEquals("wordpass", dynamicPassword.dynamicPassword("password", 4));
    }

    @Test
    void handlesPasswordWithSpecialCharacters() {
        assertEquals("@!$wordpass", dynamicPassword.dynamicPassword("pass@!$word", 4));
    }

    @Test
    void returnsOriginalPasswordForTargetZero() {
        assertEquals("password", dynamicPassword.dynamicPassword("password", 0));
    }

    @Test
    void returnsOriginalPasswordForTargetEqualToLength() {
        assertEquals("password", dynamicPassword.dynamicPassword("password", 8));
    }
}