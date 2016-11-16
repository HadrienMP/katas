package perso._1;

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

}