package ch.hsr.testing.unittest.helloworld;

public class StringLengthAppender {

    public StringLengthAppender() {
        System.out.println("Constructor of CuT");
    }

    public String append(String input) {
        return input + "(Length of string: " + input.length() + " characters)";
    }

}
