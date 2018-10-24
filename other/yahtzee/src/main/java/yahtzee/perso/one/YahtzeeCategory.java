package yahtzee.perso.one;

enum YahtzeeCategory {
    ONES(1, null, null),
    TWOS(2, null, null),
    THREES(3, null, null),
    FOURS(4, null, null),
    FIVES(5, null, null),
    SIXES(6, null, null),
    PAIR(null, 2, null),
    THREE_OF_A_KIND(null, 3, null),
    FOUR_OF_A_KIND(null, 4, null),
    YAHTZEE(null, null, null),
    CHANCE(null, null, null),
    SMALL_STRAIGHT(null, null, 1),
    LARGE_STRAIGHT(null, null, 2);

    private Integer diceValue;
    private Integer numberOfDices;
    private Integer firstNumberOfStraight;

    YahtzeeCategory(Integer diceValue, Integer numberOfDices, Integer firstNumberOfStraight) {

        this.diceValue = diceValue;
        this.numberOfDices = numberOfDices;
        this.firstNumberOfStraight = firstNumberOfStraight;
    }

    boolean isMultipleOfAKind() {
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

    public Integer getFirstNumberOfStraight() {
        return firstNumberOfStraight;
    }

    public boolean isStraight() {
        return firstNumberOfStraight != null;
    }
}
