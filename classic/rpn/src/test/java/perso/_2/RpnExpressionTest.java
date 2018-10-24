package perso._2;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RpnExpressionTest {

    @Test
    @Parameters({
            "0, 0",
            "1, 1",
            "1 2, 1 2",
            "1 2 +, 3",
            "2 3 +, 5",
            "1 2 3 + +, 6",
            "1 2 + 3 +, 6",
            "1 2 3 +, 1 5",
            "1 2 + 3 4 +, 3 7",
            "1 3 -, -2",
    })
    public void rpn(String stringOperations, String result) throws Exception {
        Expression expression = new RpnExpression(stringOperations);
        String actual = expression.solve();
        assertThat(actual).isEqualTo(result);
    }
}
