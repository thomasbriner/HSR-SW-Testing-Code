package ch.hsr.testing.unittest.tdd.walkthrough;

public class RomanNumberConverter {
    public static String arabic2Roman(int arabic) {
        String roman = "";
        for (int i = 0; i < arabic; i++) {
            roman += "I";
        }
        return roman;
    }
}
