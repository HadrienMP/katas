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
                new Object[] { 1, 2, 3, 3, 5, YahtzeeCategory.THREES, 6 }
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

    // TODO tester avec des valeurs <= 0
    // TODO tester avec des valeurs supérieures à 6
}