package ch.hsr.testing.unittest.tdd.walkthrough;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RomanNumberConverterTest {

    @Test
    void convert1ToI() {
        Assertions.assertEquals("I", RomanNumberConverter.arabic2Roman(1));
    }

    @Test
    void convert2ToII() {
        Assertions.assertEquals("II", RomanNumberConverter.arabic2Roman(2));
    }

    @Test
    void convert3ToIII() {
        Assertions.assertEquals("III", RomanNumberConverter.arabic2Roman(3));
    }

    @Test
    void convert5ToV() {
        Assertions.assertEquals("V", RomanNumberConverter.arabic2Roman(5));
    }


}