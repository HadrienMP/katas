package perso._1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @Parameters({
            // Two operands
            "1+2, 3",
            "2+1, 3",
            "18+5454, 5472",
            "1+-2, -1",
            "-2+1, -1",

            Integer.MAX_VALUE + "+0, " + Integer.MAX_VALUE,
            "0+" + Integer.MAX_VALUE + ", " + Integer.MAX_VALUE,
            Integer.MIN_VALUE + "+0, " + Integer.MIN_VALUE,
            "0+" + Integer.MIN_VALUE + ", " + Integer.MIN_VALUE,

            // Three operands
            "1+1+1, 3",
    })
    public void should_be_able_to_add(String operations, int expectedResult) {
        int result = calculator.compute(operations);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test(expected = IntegerOverflowException.class)
    @Parameters({
            // Both positive
            Integer.MAX_VALUE + "+1",
            "1+" + Integer.MAX_VALUE,
            // Both negative
            Integer.MIN_VALUE + "+-1",
            "-1+" + Integer.MIN_VALUE,
            // Three operands
            "1+1+" + Integer.MAX_VALUE,
    })
    public void should_not_be_able_to_add_numbers_when_result_rolls_over_the_integer_max_values(String operations) {
        calculator.compute(operations);
    }

    @Parameters({"", "    ", "blabla"})
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_an_exception_for_operations_not_respecting_the_add_pattern(String operations) {
        calculator.compute(operations);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_an_exception_for_a_null_string() {
        calculator.compute(null);
    }
}