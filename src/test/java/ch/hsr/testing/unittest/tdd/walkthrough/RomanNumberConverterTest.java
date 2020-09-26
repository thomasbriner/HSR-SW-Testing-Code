package ch.hsr.testing.unittest.tdd.walkthrough;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

class RomanNumberConverterTest {

    private static List<Arguments> createInput() {
        return Arrays.asList(
                Arguments.of(1, "I"),
                Arguments.of(2, "II"),
                Arguments.of(3, "III"),
                Arguments.of(5, "V"),
                Arguments.of(7, "VII"),
                Arguments.of(10, "X"),
                Arguments.of(12, "XII"),
                Arguments.of(15, "XV")
        );
    }

    @ParameterizedTest(name = "{index}: {0} -> {1}")
    @MethodSource("createInput")
    void convertToRoman(int arabicNumber, String romanNumber) {
        Assertions.assertEquals(romanNumber, RomanNumberConverter.arabic2Roman(arabicNumber));
    }
}