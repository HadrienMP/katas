package binome.fabienh;

import java.util.Arrays;
import java.util.List;

public class RomanNumeral {
    private int normalNumber;

    public RomanNumeral(int normalNumber) {
        this.normalNumber = normalNumber;
    }

    @Override
    public String toString() {
        List<RomanDigit> fiveBoundedPacks = Arrays.asList(RomanDigit.FIVE, RomanDigit.FIFTY, RomanDigit.FIVE_HUNDRED);
        for (RomanDigit romanDigit : fiveBoundedPacks) {
            if (romanDigit.packs == normalNumber) {
                return romanDigit.representation;
            }
        }

        List<RomanDigit> packs = Arrays.asList(RomanDigit.THOUSAND, RomanDigit.HUNDRED, RomanDigit.TEN, RomanDigit.ONE);
        for (RomanDigit pack : packs) {
            if (pack.match(normalNumber)) {
                return getRomanDigits(pack);
            }
        }
        return null;
    }

    private String getRomanDigits(RomanDigit thousand) {
        int numberOfChars = normalNumber / thousand.packs;
        String romanString = "";
        for (int i = 0; i < numberOfChars; i++) {
            romanString += thousand.representation;
        }
        return romanString;
    }

    private enum RomanDigit {
        THOUSAND(1_000, "M"), FIVE_HUNDRED(500, "D"), HUNDRED(100, "C"), FIFTY(50, "L"), TEN(10, "X"), FIVE(5, "V"), ONE(1, "I");

        private int packs;
        private String representation;

        private RomanDigit(int packs, String representation) {
            this.packs = packs;
            this.representation = representation;
        }

        private boolean match(int normalNumber) {
            return normalNumber % packs == 0;
        }
    }
}