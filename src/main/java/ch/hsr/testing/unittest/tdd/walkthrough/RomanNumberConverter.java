package ch.hsr.testing.unittest.tdd.walkthrough;

import java.util.Arrays;
import java.util.List;

public class RomanNumberConverter {

    private static List<RomanFigure> romanFigures = Arrays.asList(
            RomanFigure.I,
            RomanFigure.V,
            RomanFigure.X,
            RomanFigure.L,
            RomanFigure.C,
            RomanFigure.D,
            RomanFigure.M
    );

    public static String arabic2Roman(int arabicNumber) {
        if (arabicNumber == 0) {
            return "";
        }
        int indexHighestFigureSmaller = getHighestFigureSmallerThan(arabicNumber);
        RomanFigure highestFigureSmaller = romanFigures.get(indexHighestFigureSmaller);
        RomanFigure nextFigureGreater = romanFigures.get(indexHighestFigureSmaller + 1);
        RomanFigure figureForPrefix = romanFigures.get(indexHighestFigureSmaller).isUseAsPrefixForSubtration() ?
                romanFigures.get(indexHighestFigureSmaller) :
                romanFigures.get(indexHighestFigureSmaller - 1);
        String roman;
        int remainder;
        if (arabicNumber >= nextFigureGreater.getArabicNumber() - figureForPrefix.getArabicNumber()) {
            roman = figureForPrefix.toString() + nextFigureGreater.toString();
            remainder = arabicNumber - (nextFigureGreater.getArabicNumber() - figureForPrefix.getArabicNumber());
        } else {
            roman = highestFigureSmaller.toString();
            remainder = arabicNumber - highestFigureSmaller.getArabicNumber();
        }
        return roman + arabic2Roman(remainder);
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
    I(1, true),
    V(5, false),
    X(10, true),
    L(50, false),
    C(100, true),
    D(500, false),
    M(1000, true);

    private int arabicNumber;
    private boolean useAsPrefixForSubtration;

    RomanFigure(int arabicNumber, boolean useAsPrefixForSubtration) {
        this.arabicNumber = arabicNumber;
        this.useAsPrefixForSubtration = useAsPrefixForSubtration;
    }

    public int getArabicNumber() {
        return arabicNumber;
    }

    public boolean isUseAsPrefixForSubtration() {
        return useAsPrefixForSubtration;
    }
}
