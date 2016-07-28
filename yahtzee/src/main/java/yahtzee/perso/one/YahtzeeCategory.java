package yahtzee.perso.one;

enum YahtzeeCategory {
    ONES(1), THREES(3), TWOS(2), FOURS(4), FIVES(5), SIXES(6), PAIR(0), THREE_OF_A_KIND(0), FOUR_OF_A_KIND(0), YAHTZEE(0), CHANCE(0);

    private int number;

    YahtzeeCategory(int number) {

        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
