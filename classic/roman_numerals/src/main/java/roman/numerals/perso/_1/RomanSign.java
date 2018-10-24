package roman.numerals.perso._1;

import java.util.Arrays;
import java.util.List;

enum RomanSign {
    M (1000, false),
    D (500, false),
    C (100, true),
    L (50, false),
    X (10, true),
    V (5, false),
    I (1, true);

    private int number;
    private boolean substractible;

    RomanSign(int number, boolean substractible) {
        this.number = number;
        this.substractible = substractible;
    }

    public static List<RomanSign> fromBiggestToSmallest() {
        return Arrays.asList(values());
    }

    public boolean canPrefix(int toPrefix) {
        return this.getNumber() <= toPrefix;
    }

    public boolean canPrefixWithSubstraction(int value) {
        return 0 <= getLeftAfterSubstraction(value);
    }

    public int getLeftAfterSubstraction(int toPrefix) {
        return toPrefix - (this.getNumber() - nextSubstractible().getNumber());
    }

    public RomanSign nextSubstractible() {
        RomanSign tooBigToSubstract = M;
        return Arrays.stream(values())
                .filter(this::isNextSubstractible)
                .findFirst()
                .orElse(tooBigToSubstract);
    }

    private boolean isNextSubstractible(RomanSign romanSign) {
        return romanSign.getNumber() < this.getNumber() && romanSign.substractible;
    }

    public int getNumber() {
        return number;
    }
}
