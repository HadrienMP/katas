package perso._1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RpnTest {

    // TODO tester les formats illegaux
    // TODO tester concatenation de chiffres

    @Test
    @Parameters({
            // Simple addition
            "0 0 +, 0",
            "1 0 +, 1",
            "0 1 +, 1",

            // Simple others
            "3 1 -, 2",
            "3 2 *, 6",
            "3 2 *, 6",
            "1 3 /, 0",

            // Composition
            "1 3 + 2 +, " + (1 + 3 + 2),
            "2 1 3 + +, " + (1 + 3 + 2),
            "3 5 8 * 7 + *, " + (3 * ((5*8) + 7)),

            // Concatenation
            "3 5 8 7, 3 5 8 7",
            "3 5 8 * 7, 3 " + (5 * 8) + " 7",
    })
    public void rpn(String operations, String result) throws Exception {
        assertThat(new Rpn().execute(operations)).isEqualTo(result);
    }

}
