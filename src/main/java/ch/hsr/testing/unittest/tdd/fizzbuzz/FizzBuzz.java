package ch.hsr.testing.unittest.tdd.fizzbuzz;

public class FizzBuzz {

    public static final String FIZZ = "FIZZ";
    public static final String BUZZ = "BUZZ";

    public static String processNumber(int number) {
        if (number % 3 == 0) {
            return FIZZ;
        } else {
            return "";
        }
    }
}
