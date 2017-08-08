package roman.numerals.perso._1;

import java.util.Iterator;

class Number {
    private int value;

    Number(int value) {
        this.value = value;
    }

    String toRomanNumeral() {
        if (value == 0) {
            return "";
        }

        String firstHalfOfString = "";
        int leftToTransform = value;

        Iterator<RomanSign> candidates = RomanSign.fromBiggestToSmallest().iterator();
        while (firstHalfOfString.isEmpty() && candidates.hasNext()) {
            RomanSign romanSign = candidates.next();

            if (romanSign.canPrefix(value)) {
                leftToTransform = this.value - romanSign.getNumber();
                firstHalfOfString = romanSign.name();
            } else if (romanSign.canPrefixWithSubstraction(value)) {
                leftToTransform = romanSign.getLeftAfterSubstraction(value);
                firstHalfOfString = romanSign.nextSubstractible().name() + romanSign.name();
            }
        }

        return firstHalfOfString + new Number(leftToTransform).toRomanNumeral();
    }

}
