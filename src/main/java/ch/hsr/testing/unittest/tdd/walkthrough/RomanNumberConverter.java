package ch.hsr.testing.unittest.tdd.walkthrough;

public class RomanNumberConverter {
    public static String arabic2Roman(int arabic) {
        if (arabic > 1){
            return "II";
        } else {
            return "I";
        }
    }
}
