package string;

import org.junit.jupiter.api.Test;
import string.PathEncryption;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathEncryptionTest {

    private final PathEncryption pathEncryption = new PathEncryption();

    @Test
    void encryptsSingleWordPath() {
        assertEquals("a", pathEncryption.pathEncryption("a"));
    }

    @Test
    void replacesDotWithSpaceInPath() {
        assertEquals("a aef qerf bb", pathEncryption.pathEncryption("a.aef.qerf.bb"));
    }

    @Test
    void handlesPathWithMultipleConsecutiveDots() {
        assertEquals("a  aef  qerf bb", pathEncryption.pathEncryption("a..aef..qerf.bb"));
    }

    @Test
    void returnsEmptyStringForEmptyPath() {
        assertEquals("", pathEncryption.pathEncryption(""));
    }

    @Test
    void handlesPathWithOnlyDots() {
        assertEquals("   ", pathEncryption.pathEncryption("..."));
    }

    @Test
    void encryptsPathWithLeadingAndTrailingDots() {
        assertEquals(" a aef qerf bb ", pathEncryption.pathEncryption(".a.aef.qerf.bb."));
    }
}