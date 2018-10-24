package perso._1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    //--------------------------------------------------------------------------
    // BASICS
    //--------------------------------------------------------------------------

    @Test
    public void should_return_the_number_when_it_is_alone_in_the_operations() {
        String operations = "1";
        int result = calculator.compute(operations);
        assertThat(result).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_an_exception_when_the_number_is_bigger_than_the_integer_max_values() {
        String operations = MAX_VALUE + "0";
        should_throw_an_exception_when_trying_to_add_something_else_than_numbers(operations);
    }

    @Parameters({"", "    ", "blabla"})
    @Test(expected = IllegalArgumentException.class)
    public void should_throw_an_exception_for_operations_not_respecting_the_add_pattern(String operations) {
        should_throw_an_exception_when_trying_to_add_something_else_than_numbers(operations);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_an_exception_for_a_null_string() {
        should_throw_an_exception_when_trying_to_add_something_else_than_numbers(null);
    }


    //--------------------------------------------------------------------------
    // ADD
    //--------------------------------------------------------------------------

    @Test
    @Parameters({
            // Two operands
            "1+2, 3",
            "2+1, 3",
            "18+5454, 5472",
            "1+-2, -1",
            "-2+1, -1",

            MAX_VALUE + "+0, " + MAX_VALUE,
            "0+" + MAX_VALUE + ", " + MAX_VALUE,
            MIN_VALUE + "+0, " + MIN_VALUE,
            "0+" + MIN_VALUE + ", " + MIN_VALUE,

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
            MAX_VALUE + "+1",
            "1+" + MAX_VALUE,
            // Both negative
            MIN_VALUE + "+-1",
            "-1+" + MIN_VALUE,
            // Three operands
            "1+1+" + MAX_VALUE,
            "-1+-1+" + MIN_VALUE,
    })
    public void should_not_be_able_to_add_numbers_when_result_rolls_over_the_integer_max_values(String operations) {
        should_throw_an_exception_when_trying_to_add_something_else_than_numbers(operations);
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters({
            "toto+toto",
            "1+toto",
    })
    public void should_throw_an_exception_when_trying_to_add_something_else_than_numbers(String operations) {
        calculator.compute(operations);
    }

    //--------------------------------------------------------------------------
    // SUBSTRACT
    //--------------------------------------------------------------------------

    @Test
    @Parameters({
        "1-1, 0",
        "-1-1, -2",
    })
    public void should_be_able_to_substract(String operations, int expectedResult) {
        int result = calculator.compute(operations);
        assertThat(result).isEqualTo(expectedResult);
    }

    //--------------------------------------------------------------------------
    // MULTIPLY
    //--------------------------------------------------------------------------


    @Test
    @Parameters({
            "1*1, 1",
            "2*2, 4",
            "18*5454, 98172",
            "1*-2, -2",
            "-2*1, -2",
            MAX_VALUE + "*1, " + MAX_VALUE,
            MAX_VALUE / 2 + "*2, " + (MAX_VALUE - 1),
            MIN_VALUE + "*1, " + MIN_VALUE,
            MIN_VALUE / 2 + "*2, " + MIN_VALUE,
    })
    public void should_be_able_to_multiply(String operations, int expectedResult) {
        int result = calculator.compute(operations);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test(expected = IntegerOverflowException.class)
    @Parameters({
            // Both positive
            (MAX_VALUE / 2 + 1) + "*2",
            "2*" + (MAX_VALUE / 2 + 1),
            MAX_VALUE + "*2",
            "2*" + MAX_VALUE,

            // Positive negative
            (MIN_VALUE / 2 - 1) + "*2",
            "2*" + (MIN_VALUE / 2 - 1),
            MIN_VALUE + "*-2",
            "-2*" + MIN_VALUE,

            // Both negative
            (MIN_VALUE / 2 - 1) + "*-2",

//            "1+" + Integer.MAX_VALUE,
//            // Both negative
//            Integer.MIN_VALUE + "+-1",
//            "-1+" + Integer.MIN_VALUE,
//            // Three operands
//            "1+1+" + Integer.MAX_VALUE,
//            "-1+-1+-" + Integer.MIN_VALUE,
    })
    public void should_not_be_able_to_multiply_numbers_when_result_rolls_over_the_integer_max_values(String operations) {
        calculator.compute(operations);
    }

}