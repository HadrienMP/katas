package perso1;

import java.math.BigDecimal;

class Money {

    private int inCents;

    Money(String inEuros) {
        this.inCents = toCents(inEuros);
    }

    private int toCents(String inEuros) {
        return new BigDecimal(inEuros).multiply(new BigDecimal(100)).intValue();
    }

    private Money(int inCents) {
        this.inCents = inCents;
    }

    boolean isLessOrEqualTo(Money cents) {
        return this.inCents <= cents.inCents;
    }

    Money difference(Money moneyInserted) {
        return new Money(Math.abs(this.inCents - moneyInserted.inCents));
    }

    @Override
    public String toString() {
        String result = String.valueOf((float) this.inCents / 100);
        if (isOneDigitNumber(result)) {
            result += "0";
        }
        return result;
    }

    private boolean isOneDigitNumber(String result) {
        return result.length() - (result.indexOf(".") + 1) == 1;
    }
}
