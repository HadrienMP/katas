package yahtzee.perso.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static yahtzee.perso.one.YahtzeeCategory.*;

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

        if (category == CHANCE) {
            return diceResults.stream().mapToInt(x -> x).sum();
        }

        List<Integer> diceResultsDesc = diceResults.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        if (Arrays.asList(PAIR, THREE_OF_A_KIND, FOUR_OF_A_KIND).contains(category)) {

            int numberOfSameDicesToFind = 0;
            if (category == PAIR) {
                numberOfSameDicesToFind = 2;
            }
            if (category == THREE_OF_A_KIND) {
                numberOfSameDicesToFind = 3;
            }
            if (category == FOUR_OF_A_KIND) {
                numberOfSameDicesToFind = 4;
            }

            for (int i = numberOfSameDicesToFind - 1; i < diceResultsDesc.size(); i++) {
                boolean sameNumbers = true;
                for (int j = 1; j < numberOfSameDicesToFind; j++) {
                    sameNumbers &= diceResultsDesc.get(i) == diceResultsDesc.get(i - j);
                }
                if (sameNumbers) {
                    return diceResultsDesc.get(i) * numberOfSameDicesToFind;
                }
            }
            return 0;
        }

        return diceResults.stream()
                .filter(dice -> dice == category.getNumber())
                .mapToInt(x -> x)
                .sum();
    }

    private boolean isYahtzee() {
        return new HashSet<>(diceResults).size() == 1;
    }
}
