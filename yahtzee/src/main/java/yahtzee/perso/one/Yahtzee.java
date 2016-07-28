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

        if (category == YahtzeeCategory.PAIR) {
            for (int i = 1; i < diceResultsDesc.size(); i++) {
                if (diceResultsDesc.get(i) == diceResultsDesc.get(i-1)) {
                    return diceResultsDesc.get(i) * 2;
                }
            }
            return category.getNumber();
        }
        if (category == YahtzeeCategory.THREE_OF_A_KIND) {
            for (int i = 2; i < diceResultsDesc.size(); i++) {
                if (diceResultsDesc.get(i) == diceResultsDesc.get(i-1) && diceResultsDesc.get(i) == diceResultsDesc.get(i-2)) {
                    return diceResultsDesc.get(i) * 3;
                }
            }
            return category.getNumber();
        }

        return diceResults.stream()
                .filter(dice -> dice == category.getNumber())
                .mapToInt(x -> x)
                .sum();
    }
}
