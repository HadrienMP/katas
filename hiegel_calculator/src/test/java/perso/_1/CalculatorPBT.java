package perso._1;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class CalculatorPBT {

    @Property
    public void should_add_any_two_numbers_in_a_string_containing_a_string_in_between(int firstNumber, int secondNumber) {
        String operations = firstNumber + "+" + secondNumber;
        Calculator calculator = new Calculator();

        int result = calculator.compute(operations);

        assertThat(result).isEqualTo(firstNumber + secondNumber);
    }
}
