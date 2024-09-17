package ch.hsr.testing.unittest.whitebox;

import org.junit.jupiter.api.Test;

class RomanNumberConverterForWhiteboxTestingTest {

    @Test
    void convertNumber3() {
        org.junit.jupiter.api.Assertions.assertEquals(
                "III",
                RomanNumberConverterForWhiteboxTesting.convertToRoman(3));
    }


    @Test
    void convertNumber1() {
        org.junit.jupiter.api.Assertions.assertEquals(
                "I",
                RomanNumberConverterForWhiteboxTesting.convertToRoman(1));
    }


    @Test
    void convertNumber0() {
        org.junit.jupiter.api.Assertions.assertEquals(
                "",
                RomanNumberConverterForWhiteboxTesting.convertToRoman(0));
    }


    @Test
    void convertNumber910() {
        org.junit.jupiter.api.Assertions.assertEquals(
                "CMX",
                RomanNumberConverterForWhiteboxTesting.convertToRoman(910));
    }

}