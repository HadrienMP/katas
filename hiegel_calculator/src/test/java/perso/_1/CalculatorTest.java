package perso._1;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.CountedCompleter;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void _1_and_1_equals_2() {
        String operations = "1+1";
        Calculator calculator = new Calculator();

        int result = calculator.compute(operations);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void _1_and_2_equals_3() {
        String operations = "1+2";
        Calculator calculator = new Calculator();

        int result = calculator.compute(operations);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void _2_and_1_equals_3() {
        String operations = "2+1";
        Calculator calculator = new Calculator();

        int result = calculator.compute(operations);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void _18_and_1_equals_19() {
        String operations = "18+1";
        Calculator calculator = new Calculator();

        int result = calculator.compute(operations);

        assertThat(result).isEqualTo(19);
    }

    @Test
    public void _18_and_5454_equals_5472() {
        String operations = "18+5454";
        Calculator calculator = new Calculator();

        int result = calculator.compute(operations);

        assertThat(result).isEqualTo(5472);
    }

    @Test
    public void negative_numbers() {
        String operations = "18+-5454";
        Calculator calculator = new Calculator();

        int result = calculator.compute(operations);

        assertThat(result).isEqualTo(-5436);
    }

    @Test(expected = TooBigForTheCalculatorException.class)
    public void max_int_first_operand() {
        String operations = Integer.MAX_VALUE + "+1";
        Calculator calculator = new Calculator();

        calculator.compute(operations);
    }

    @Test(expected = TooBigForTheCalculatorException.class)
    public void max_int_second_operand() {
        String operations = "1+" + Integer.MAX_VALUE;
        Calculator calculator = new Calculator();

        calculator.compute(operations);
    }

    @Test(expected = TooBigForTheCalculatorException.class)
    public void max_int_simple() {
        String operations = Integer.MAX_VALUE - 1 + "+2";
        Calculator calculator = new Calculator();

        calculator.compute(operations);
    }

    @Test(expected = TooBigForTheCalculatorException.class)
    public void max_int_simple_other_operand() {
        String operations = "2+" + (Integer.MAX_VALUE - 1);
        Calculator calculator = new Calculator();

        calculator.compute(operations);
    }

    @Test(expected = TooBigForTheCalculatorException.class)
    public void max_int() {
        String operations = (Integer.MAX_VALUE -2) + "+" + (Integer.MAX_VALUE - 1);
        Calculator calculator = new Calculator();

        calculator.compute(operations);
    }

    @Test(expected = TooBigForTheCalculatorException.class)
    public void max_int_hard() {
        String operations = (Integer.MIN_VALUE + 2) + "+" + (Integer.MAX_VALUE - 1);
        Calculator calculator = new Calculator();

        calculator.compute(operations);
    }

}