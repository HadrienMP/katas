package roman.numerals.perso._2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static roman.numerals.perso._2.RomanDigit.*;

class Number {

    private int value;

    Number(int value) {
        this.value = value;
    }

    String toRoman() {

        return toRomanOnesString(value)
                .replace(ONE.times(5),                      FIVE.toString())
                .replace(ONE.times(4),                      FOUR.toString())
                .replace(FIVE.plus(FIVE),                   TEN.toString())
                .replace(FIVE.plus(FOUR),                   NINE.toString())
                .replace(TEN.times(5),                      FIFTY.toString())
                .replace(TEN.times(4),                      FOURTY.toString())
                .replace(FIFTY.plus(FIFTY),                 HUNDRED.toString())
                .replace(FIFTY.plus(FOURTY),                NINETY.toString())
                .replace(HUNDRED.times(5),                  FIVE_HUNDRED.toString())
                .replace(HUNDRED.times(4),                  FOUR_HUNDRED.toString())
                .replace(FIVE_HUNDRED.plus(FIVE_HUNDRED),   THOUSAND.toString())
                .replace(FIVE_HUNDRED.plus(FOUR_HUNDRED),   NINE_HUNDRED.toString());
    }

    private static String toRomanOnesString(int value) {
        return IntStream.range(0, value)
                    .mapToObj(i -> ONE.toString())
                    .collect(Collectors.joining());
    }
}
