package ch.hsr.testing.unittest.tdd.fizzbuzz;

public class FizzBuzz {

    public static String processNumber(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        } else {
            return "";
        }
    }
}
