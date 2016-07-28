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
    private List<Integer> diceResults = new ArrayList<>();

    Yahtzee(int dice1, int dice2, int dice3, int dice4, int dice5) {
        diceResults.add(dice1);
        diceResults.add(dice2);
        diceResults.add(dice3);
        diceResults.add(dice4);
        diceResults.add(dice5);
    }

    int score(YahtzeeCategory category) {

        if (category == YAHTZEE && isYahtzee()) {
            return 50;
        }

        if (category.isMultipleDice()) {

            List<Integer> diceResultsDesc = diceResults.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

            for (int i = category.getNumberOfDices() - 1; i < diceResultsDesc.size(); i++) {
                boolean sameNumbers = true;
                for (int j = 1; j < category.getNumberOfDices(); j++) {
                    sameNumbers &= diceResultsDesc.get(i) == diceResultsDesc.get(i - j);
                }
                if (sameNumbers) {
                    return diceResultsDesc.get(i) * category.getNumberOfDices();
                }
            }
        }

        if (category == CHANCE || category.isSingleNumber()) {

            Predicate<Integer> dicesToConsider = dice -> true;
            if (category.isSingleNumber()) {
                dicesToConsider = dice -> dice == category.getDiceValue();
            }

            return diceResults.stream().filter(dicesToConsider).mapToInt(x -> x).sum();
        }

        return 0;
    }

    private boolean isYahtzee() {
        return new HashSet<>(diceResults).size() == 1;
    }
}
