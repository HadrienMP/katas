package yahtzee.perso.one;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class YahtzeeTest {

    public static Collection<Object[]> parametersForYahtzee_should_return_the_correct_result() {
        return Arrays.asList(
                // No dice match number category
                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.SIXES, 0 },

                // One dice match number category
                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.ONES, 1 },
                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.TWOS, 2 },
                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.THREES, 3 },
                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.FOURS, 4 },
                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.FIVES, 5 },
                new Object[] { 1, 2, 3, 4, 6, YahtzeeCategory.SIXES, 6 },

                // Two dices match number category
                new Object[] { 1, 1, 3, 4, 5, YahtzeeCategory.ONES, 2 },
                new Object[] { 1, 2, 2, 4, 5, YahtzeeCategory.TWOS, 4 },
                new Object[] { 1, 2, 3, 3, 5, YahtzeeCategory.THREES, 6 },

                // Pairs
                new Object[] { 1, 1, 3, 4, 5, YahtzeeCategory.PAIR, 2 },
                new Object[] { 2, 2, 3, 4, 5, YahtzeeCategory.PAIR, 4 },
                new Object[] { 1, 3, 3, 4, 5, YahtzeeCategory.PAIR, 6 },
                new Object[] { 1, 2, 4, 4, 5, YahtzeeCategory.PAIR, 8 },
                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.PAIR, 0 },

                // Three of a kind
                new Object[] { 1, 1, 1, 4, 5, YahtzeeCategory.THREE_OF_A_KIND, 3 },
                new Object[] { 2, 2, 2, 4, 5, YahtzeeCategory.THREE_OF_A_KIND, 6 },
                new Object[] { 1, 3, 3, 3, 5, YahtzeeCategory.THREE_OF_A_KIND, 9 },
                new Object[] { 1, 2, 4, 4, 4, YahtzeeCategory.THREE_OF_A_KIND, 12 },
                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.THREE_OF_A_KIND, 0 },

                // Four of a kind
                new Object[] { 5, 5, 5, 4, 5, YahtzeeCategory.FOUR_OF_A_KIND, 20 },
                new Object[] { 1, 1, 1, 4, 1, YahtzeeCategory.FOUR_OF_A_KIND, 4 },
                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.FOUR_OF_A_KIND, 0 },

                // Yahtzee
                new Object[] { 5, 5, 5, 5, 5, YahtzeeCategory.YAHTZEE, 50 },
                new Object[] { 1, 5, 5, 5, 5, YahtzeeCategory.YAHTZEE, 0 },
                new Object[] { 6, 6, 6, 6, 6, YahtzeeCategory.YAHTZEE, 50 },

                // Chance
                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.CHANCE, 15 },
                new Object[] { 5, 5, 3, 2, 1, YahtzeeCategory.CHANCE, 16 },
                new Object[] { 3, 3, 3, 3, 3, YahtzeeCategory.CHANCE, 15 },

                // Small Straight
                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.SMALL_STRAIGHT, 15 },
                new Object[] { 3, 3, 3, 3, 3, YahtzeeCategory.SMALL_STRAIGHT, 0 },
                new Object[] { 5, 4, 3, 2, 1, YahtzeeCategory.SMALL_STRAIGHT, 15 }

                // Large Straight
//                new Object[] { 1, 2, 3, 4, 5, YahtzeeCategory.LARGE_STRAIGHT, 15 },
//                new Object[] { 3, 3, 3, 3, 3, YahtzeeCategory.LARGE_STRAIGHT, 0 },
//                new Object[] { 5, 4, 3, 2, 1, YahtzeeCategory.LARGE_STRAIGHT, 15 }
        );
    }

    @Test
    @Parameters
    public void yahtzee_should_return_the_correct_result(int dice1, int dice2, int dice3, int dice4, int dice5
            , YahtzeeCategory category, int result) {
        // GIVEN
        Yahtzee yahtzee = new Yahtzee(dice1, dice2, dice3, dice4, dice5);

        // WHEN
        int score = yahtzee.score(category);

        // THEN
        assertThat(score).isEqualTo(result);
    }



    // TODO tester quand il y a 1 seul chiffre sur tous les dés (combien de paires ? de trois ?)
    // TODO tester paires quand il y a 3 fois le chiffre (combien de paires ?)
    // TODO tester avec des valeurs <= 0
    // TODO tester avec des valeurs supérieures à 6
}