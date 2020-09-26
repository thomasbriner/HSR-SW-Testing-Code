package ch.hsr.testing.unittest.tdd.walkthrough;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RomanNumberConverterTest {

    @Test
    void convert1ToI() {
        Assertions.assertEquals("I", RomanNumberConverter.arabic2Roman(1));
    }
}