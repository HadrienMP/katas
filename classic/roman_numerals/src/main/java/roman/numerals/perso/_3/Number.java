package roman.numerals.perso._3;

class Number {

    static String toRoman(int number) {
        if (number == 0) {
            return "";
        }

        RomanDigit firstDigit = RomanDigit.biggestDigitFitting(number);

        return firstDigit.getRoman() + toRoman(firstDigit.getRest(number));
    }
}
