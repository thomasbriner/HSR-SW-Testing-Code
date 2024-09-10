package ch.hsr.testing.unittest.helloworld;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class QuicksorterTest {


    @Test
    public void sortUnsortedList() {
        // arrange
        List<Integer> unsorted = Arrays.asList(7, 1, -6, 342);
        Quicksorter quicksorter = new Quicksorter();

        // act
        List<Integer> actual = quicksorter.quicksort(unsorted);

        // assert mit JUnit Bordmitteln
        Assertions.assertNotNull(actual);

        // gibt wenig hilfreiche Fehlermeldung
        Assertions.assertTrue(actual.get(0) == -6);
        Assertions.assertEquals(actual.get(0), -6);

        Assertions.assertEquals(Arrays.asList(-6, 1, 7, 342), actual);


        // assert mit Hamcrest
        MatcherAssert.assertThat(actual, Matchers.is(Matchers.not(Matchers.nullValue())));
        // mit static imports wird es lesbarer
        MatcherAssert.assertThat(actual, is(not(nullValue())));
        MatcherAssert.assertThat(actual, is(equalTo(Arrays.asList(-6, 1, 7, 342))));

        // assert mit Assertj
        org.assertj.core.api.Assertions.assertThat(actual.get(1))
                .isNotNull()
                .isEqualTo(1);
    }
}