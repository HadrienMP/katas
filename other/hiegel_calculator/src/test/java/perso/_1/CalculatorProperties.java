package perso._1;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assume;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class CalculatorProperties {

    private Calculator calculator = new Calculator();

    @Property
    public void opposite_signs_number_can_always_be_added(int first, int second) {
        Assume.assumeTrue((first < 0 && second > 0) || (first > 0 && second < 0));

        calculator.compute(first + "+" + second);

    }

    @Property
    public void should_return_the_number_when_it_is_without_operations(int value) {
        int result = calculator.compute("" + value);
        assertThat(result).isEqualTo(value);
    }
}
