package perso1;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assume.assumeThat;

/**
 * Created by HadrienMP on 03/06/2016.
 */
@RunWith(JUnitQuickcheck.class)
public class FizzBuzzPBTest {

    @Property
    public void multiples_of_3_and_5_should_return_fizzbuzz(int multipleOf3And5) {
        assumeThat(multipleOf3And5 % 3, is(0)) ;
        assumeThat(multipleOf3And5 % 5, is(0)) ;

        String fizzbuzz = FizzBuzz.transform(multipleOf3And5);

        assertThat(fizzbuzz).isEqualTo("FizzBuzz");
    }

    @Property
    public void multiples_of_3_should_return_fizz(int multipleOf3) {
        assumeThat(multipleOf3 % 3, is(0)) ;
        assumeThat(multipleOf3 % 5, not(is(0))) ;

        String fizzbuzz = FizzBuzz.transform(multipleOf3);

        assertThat(fizzbuzz).isEqualTo("Fizz");
    }

    @Property
    public void multiples_of_5_should_return_buzz(int multipleOf5) {
        assumeThat(multipleOf5 % 5, is(0)) ;
        assumeThat(multipleOf5 % 3, not(is(0))) ;

        String fizzbuzz = FizzBuzz.transform(multipleOf5);

        assertThat(fizzbuzz).isEqualTo("Buzz");
    }

    @Property
    public void others_should_return_themselves(int defaultNumber) {
        assumeThat(defaultNumber % 3, not(is(0))) ;
        assumeThat(defaultNumber % 5, not(is(0))) ;

        String fizzbuzz = FizzBuzz.transform(defaultNumber);

        assertThat(fizzbuzz).isEqualTo(String.valueOf(defaultNumber));
    }
}