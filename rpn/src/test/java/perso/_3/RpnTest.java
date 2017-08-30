package perso._3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RpnTest {

    @Test
    @Parameters({
            "1 2 +, 3",
            "3 2 +, 5",
            "3 2 -, 1",
            "3 2 *, 6",
            "6 2 /, 3",
            "1 5 + 3 /, " + (1+5)/3,
            "6 4 1 - /, " + 6/(4-1),
            "1 2 + 3 4 +, 3 7",
    })
    public void should_process_rpn_operations(String expression, String expectedResult) {
        StringExpression rpnExpression = new RpnExpression(expression);
        String actual = rpnExpression.process();
        assertThat(actual).isEqualTo(expectedResult);
    }
}
