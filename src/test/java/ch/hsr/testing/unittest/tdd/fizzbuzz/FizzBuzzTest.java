package ch.hsr.testing.unittest.tdd.fizzbuzz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FizzBuzzTest {


    @ParameterizedTest(name="Test {index}: {0} -> {1} ({2} ")
    @MethodSource("getTestInputData")
    void testDataDriven(int input, String fizzbuzz, String reason){
        String actual = FizzBuzz.processNumber(input);

        Assertions.assertThat(actual).isEqualTo(fizzbuzz);
    }

    public static Stream<Arguments> getTestInputData() {
        return Stream.of(
                Arguments.of(4,"","normal number"),
                Arguments.of(6,FizzBuzz.FIZZ,"dreierreihe")
        );
    }

}
