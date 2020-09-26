package ch.hsr.testing.unittest.tdd.walkthrough;

import java.util.Arrays;
import java.util.List;

public class RomanNumberConverter {

    private static List<RomanFigure> romanFigures = Arrays.asList(
            RomanFigure.I,
            RomanFigure.V,
            RomanFigure.X,
            RomanFigure.L
    );

    public static String arabic2Roman(int arabicNumber) {
        int index = getHighestFigureSmallerThan(arabicNumber);
        String roman = "";
        for (int i = 0; i < arabicNumber; i = i + romanFigures.get(index).getArabicNumber()) {
            roman += romanFigures.get(index).toString();
        }
        return roman;
    }

    private static int getHighestFigureSmallerThan(int arabicNumber) {
        for (int i = 0; i < romanFigures.size(); i++) {
            if (romanFigures.get(i).getArabicNumber() > arabicNumber) {
                return i - 1;
            }
        }
        return 0;
    }
}


enum RomanFigure {
    I(1),
    V(5),
    X(10),
    L(50);

    private int arabicNumber;

    RomanFigure(int arabicNumber) {
        this.arabicNumber = arabicNumber;
    }

    public int getArabicNumber() {
        return arabicNumber;
    }
}
