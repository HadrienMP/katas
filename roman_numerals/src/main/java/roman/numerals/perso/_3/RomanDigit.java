package roman.numerals.perso._3;

import java.util.Arrays;

enum RomanDigit {
    _1000(1000, "M"),
    _500(500, "D"),
    _100(100, "C"),
    _50(50, "L"),
    _40(40, "XL"),
    _10(10, "X"),
    _9(9, "IX"),
    _5(5, "V"),
    _4(4, "IV"),
    _1(1, "I");

    private final int arabic;
    private final String roman;

    RomanDigit(int arabic, String roman) {
        this.arabic = arabic;
        this.roman = roman;
    }

    public String getRoman() {
        return roman;
    }

    public static RomanDigit biggestDigitFitting(int number) {
        return Arrays.stream(values())
                .filter(digit -> digit.arabic <= number)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getRest(int number) {
        return number - arabic;
    }
}
