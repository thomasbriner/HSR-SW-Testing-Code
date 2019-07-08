package ch.hsr.testing.unittest.assertions.lotr;


import org.hamcrest.*;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static ch.hsr.testing.unittest.assertions.lotr.LotrActorsTest.ContainsOnlySpecifiedRacesMatcher.containsOnlySpecifiedRaces;
import static ch.hsr.testing.unittest.assertions.lotr.Race.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LotrActorsTest {

    private LotrActors lotrActors = new LotrActors();
    private TolkienCharacter frodo;
    private TolkienCharacter sauron;

    @BeforeEach
    void setup() {
        Optional<TolkienCharacter> frodoOpt = lotrActors.getCharactersByName("Frodo");
        Optional<TolkienCharacter> sauronOpt = lotrActors.getCharactersByName("Sauron");

        Assumptions.assumeTrue(frodoOpt.isPresent());
        Assumptions.assumeTrue(sauronOpt.isPresent());

        frodo = frodoOpt.get();
        sauron = sauronOpt.get();


    }

    // Explanation: https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
    @Test
    void useOldFashionedAssertions() {
        assertEquals("Frodo", frodo.getName());
        assertEquals(33, frodo.getAge());
    }


    // Tutorial: http://www.vogella.com/tutorials/Hamcrest/article.html
    @Test
    void useHamcrestMatchers() {
        MatcherAssert.assertThat(frodo.getName(), Matchers.equalTo("Frodo"));
        MatcherAssert.assertThat(frodo.getAge(), Matchers.equalTo(33));
    }

    // Overview: http://joel-costigliola.github.io/assertj/
    @Test
    void useAssertjMatchers() {

        org.assertj.core.api.Assertions
                .assertThat(lotrActors.getFellowshipOfTheRing())
                .hasSize(9)
                .contains(frodo)
                .doesNotContain(sauron);

        org.assertj.core.api.Assertions.assertThat(frodo.getName())
                .isNotEmpty()
                .startsWith("F")
                .isEqualTo("Frodo");
    }


    // Tutorial: http://www.baeldung.com/hamcrest-custom-matchers
    @Test
    void useCustomMatcher() {

        MatcherAssert.assertThat(lotrActors.getFellowshipOfTheRing(),
                containsOnlySpecifiedRaces(Arrays.asList(HOBBIT, DWARF, MAN, ELF, WIZARD)));

    }


    public static class ContainsOnlySpecifiedRacesMatcher
            extends TypeSafeMatcher<List<TolkienCharacter>> {

        List<Race> races;

        ContainsOnlySpecifiedRacesMatcher(List<Race> races) {
            this.races = races;
        }

        @Override
        protected boolean matchesSafely(List<TolkienCharacter> characters) {
            return characters.stream()
                    .allMatch(character -> races.contains(character.getRace()));
        }

        @Override
        public void describeTo(Description description) {
            description.appendText(" contains only characters of races " + races);
        }

        @Override
        protected void describeMismatchSafely(List<TolkienCharacter> characters, Description mismatchDescription) {
            Set<Race> undesiredRaces = characters.stream()
                    .filter(character -> !races.contains(character.getRace()))
                    .map(TolkienCharacter::getRace)
                    .collect(Collectors.toSet());
            mismatchDescription.appendText(" contains characters of additional race(s)").appendValue(undesiredRaces);
        }


        @Factory
        static Matcher<List<TolkienCharacter>> containsOnlySpecifiedRaces(List<Race> races) {
            return new ContainsOnlySpecifiedRacesMatcher(races);
        }

    }


}