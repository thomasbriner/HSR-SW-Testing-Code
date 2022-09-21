package ch.hsr.testing.unittest.tdd.fizzbuzz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void normaleZahl() {
        String actual = FizzBuzz.processNumber(4);

        Assertions.assertThat(actual).isEqualTo("");
    }


    @Test
    void dreierReihe() {
        String actual = FizzBuzz.processNumber(6);

        Assertions.assertThat(actual).isEqualTo("Fizz");
    }

}
