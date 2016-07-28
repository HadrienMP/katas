package yahtzee.perso.one;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> diceResultsDesc = diceResults.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        if (category == YahtzeeCategory.THREE_OF_A_KIND || category == YahtzeeCategory.PAIR) {

            int numberOfSameDicesToFind = 1;
            if (category == YahtzeeCategory.PAIR) {
                numberOfSameDicesToFind = 2;
            }
            if (category == YahtzeeCategory.THREE_OF_A_KIND) {
                numberOfSameDicesToFind = 3;
            }

            for (int i = numberOfSameDicesToFind - 1; i < diceResultsDesc.size(); i++) {
                boolean match = true;
                for (int j = 1; j < numberOfSameDicesToFind; j++) {
                    match &= diceResultsDesc.get(i) == diceResultsDesc.get(i - j);
                }
                if (match) {
                    return diceResultsDesc.get(i) * numberOfSameDicesToFind;
                }
            }
            return -1;
        }

        return diceResults.stream()
                .filter(dice -> dice == category.getNumber())
                .mapToInt(x -> x)
                .sum();
    }
}
