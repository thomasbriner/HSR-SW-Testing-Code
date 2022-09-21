package ch.hsr.testing.unittest.tdd.fizzbuzz;

public class FizzBuzz {

    public static final String FIZZ = "FIZZ";
    public static final String BUZZ = "BUZZ";

    public static String processNumber(int number) {
        StringBuilder result = new StringBuilder();
        if (number % 3 == 0) {
            result.append(FIZZ);
        }
        if (number % 5 == 0) {
           result.append(BUZZ);
        }
        return result.toString();
    }
}