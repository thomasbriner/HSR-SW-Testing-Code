package ch.hsr.testing.unittest.tdd.fizzbuzz;

import java.util.List;

public class FizzBuzz {

    public static final String FIZZ = "FIZZ";
    public static final String BUZZ = "BUZZ";

    private static final List<Tuple> REACTIONS = List.of(new Tuple(3, FIZZ), new Tuple(5, BUZZ));


    public static String processNumber(int number) {
        StringBuilder result = new StringBuilder();
        REACTIONS.forEach(tuple -> {
            if (shouldReact(number, tuple.getTrigger())) {
                result.append(tuple.getReaction());
            }
        });
        return result.toString();
    }


    private static boolean shouldReact(int number, int trigger) {
        return number % trigger == 0 || Integer.toString(number).contains(Integer.toString(trigger));
    }

    private static class Tuple {
        private final int trigger;
        private final String reaction;

        public Tuple(int trigger, String reaction) {
            this.trigger = trigger;
            this.reaction = reaction;
        }

        public int getTrigger() {
            return trigger;
        }

        public String getReaction() {
            return reaction;
        }
    }
}
