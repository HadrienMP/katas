package yahtzee.perso.one;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static yahtzee.perso.one.YahtzeeCategory.CHANCE;
import static yahtzee.perso.one.YahtzeeCategory.YAHTZEE;

class Yahtzee {
    private List<Integer> diceValues = new ArrayList<>();

    Yahtzee(int dice1, int dice2, int dice3, int dice4, int dice5) {
        diceValues.add(dice1);
        diceValues.add(dice2);
        diceValues.add(dice3);
        diceValues.add(dice4);
        diceValues.add(dice5);
        diceValues.sort(Comparator.naturalOrder());
    }

    int score(YahtzeeCategory category) {

        int score = 0;

        if (category == YAHTZEE && isYahtzee()) {
            score = 50;
        } else if (category.isMultipleOfAKind()) {
            score = getMultipleOfAKindScore(category);
        } else if (isScoreSumOfDices(category)) {
            score = getSumScore(category);
        }

        return score;
    }

    private int getMultipleOfAKindScore(YahtzeeCategory category) {
        int score = 0;

        List<Integer> diceValuesDesc = diceValues.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (int i = category.getNumberOfDices() - 1; i < diceValuesDesc.size(); i++) {
            boolean sameNumbers = true;
            for (int j = 1; j < category.getNumberOfDices(); j++) {
                sameNumbers &= diceValuesDesc.get(i).equals(diceValuesDesc.get(i - j));
            }
            if (sameNumbers) {
                score = diceValuesDesc.get(i) * category.getNumberOfDices();
                break;
            }
        }
        return score;
    }

    private boolean isScoreSumOfDices(YahtzeeCategory category) {

        boolean straight = category.isStraight();
        if (straight) {
            for (int i = 0; i < diceValues.size(); i++) {
                straight &= diceValues.get(i) == i + category.getFirstNumberOfStraight();
            }
        }

        return category == CHANCE || category.isSingleNumber() || straight;
    }

    private int getSumScore(YahtzeeCategory category) {
        Predicate<Integer> diceFilter = dice -> true;

        if (category.isSingleNumber()) {
            diceFilter = dice -> dice.equals(category.getDiceValue());
        }

        return diceValues.stream().filter(diceFilter).mapToInt(x -> x).sum();
    }

    private boolean isYahtzee() {
        return new HashSet<>(diceValues).size() == 1;
    }
}
