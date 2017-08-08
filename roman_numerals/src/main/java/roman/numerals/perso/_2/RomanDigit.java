package roman.numerals.perso._2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

enum RomanDigit {
    ONE("I"),
    FOUR("IV"),
    FIVE("V"),
    NINE("IX"),
    TEN("X"),
    FOURTY("XL"),
    FIFTY("L"),
    NINETY("XC"),
    HUNDRED("C"),
    FOUR_HUNDRED("CD"),
    FIVE_HUNDRED("D"),
    NINE_HUNDRED("CM"),
    THOUSAND("M");

    private String representation;

    RomanDigit(String representation) {
        this.representation = representation;
    }

    public String plus(RomanDigit otherDigit) {
        return representation + otherDigit.representation;
    }

    public String times(int multiplicator) {
        return IntStream.range(0, multiplicator)
                .mapToObj(i -> representation)
                .collect(Collectors.joining());
    }

    public String toString() {
        return representation;
    }
}
