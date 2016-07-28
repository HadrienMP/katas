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
                new Object[] { 1, 2, 4, 4, 5, YahtzeeCategory.PAIR, 8 }
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

    @Test
    public void three_of_a_kind_of_ones() {
        // GIVEN
        Yahtzee yahtzee = new Yahtzee(1, 1, 1, 3, 4);

        // WHEN
        int score = yahtzee.score(YahtzeeCategory.THREE_OF_A_KIND);

        // THEN
        assertThat(score).isEqualTo(3);
    }

    @Test
    public void three_of_a_kind_of_twos() {
        // GIVEN
        Yahtzee yahtzee = new Yahtzee(2, 2, 2, 3, 4);

        // WHEN
        int score = yahtzee.score(YahtzeeCategory.THREE_OF_A_KIND);

        // THEN
        assertThat(score).isEqualTo(6);
    }

    @Test
    public void three_of_a_kind_of_threes() {
        // GIVEN
        Yahtzee yahtzee = new Yahtzee(4, 3, 3, 3, 4);

        // WHEN
        int score = yahtzee.score(YahtzeeCategory.THREE_OF_A_KIND);

        // THEN
        assertThat(score).isEqualTo(9);
    }



    // TODO tester quand il y a 1 seul chiffre sur tous les dés (combien de paires ? de trois ?)
    // TODO tester paires quand il y a 3 fois le chiffre (combien de paires ?)
    // TODO tester avec des valeurs <= 0
    // TODO tester avec des valeurs supérieures à 6
}