package ch.hsr.testing.unittest.tdd.romannumbers;

import org.junit.jupiter.api.Test;

class RomanNumberConverterForWhiteboxTestingTest {

    @Test
    void convertNumber3() {
        org.junit.jupiter.api.Assertions.assertEquals(
                "III",
                RomanNumberConverterForWhiteboxTesting.convertToRoman(3));
    }



}