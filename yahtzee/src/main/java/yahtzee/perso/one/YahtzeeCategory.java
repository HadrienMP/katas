package yahtzee.perso.one;

enum YahtzeeCategory {
    ONES(1, null),
    TWOS(2, null),
    THREES(3, null),
    FOURS(4, null),
    FIVES(5, null),
    SIXES(6, null),
    PAIR(null, 2),
    THREE_OF_A_KIND(null, 3),
    FOUR_OF_A_KIND(null, 4),
    YAHTZEE(null, null),
    CHANCE(null, null),
    SMALL_STRAIGHT(null, null),
    LARGE_STRAIGHT(null, null);

    private Integer diceValue;
    private Integer numberOfDices;

    YahtzeeCategory(Integer diceValue, Integer numberOfDices) {

        this.diceValue = diceValue;
        this.numberOfDices = numberOfDices;
    }

    boolean isMultipleDice() {
        return this.getNumberOfDices() != null;
    }

    public boolean isSingleNumber() {
        return getDiceValue() != null;
    }

    public Integer getDiceValue() {
        return diceValue;
    }

    public Integer getNumberOfDices() {
        return numberOfDices;
    }
}
