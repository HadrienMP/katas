package perso1;


import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by HadrienMP on 02/06/2016.
 */
public class FizzBuzzTest {

    @Test
    public void one() {
        String fizzbuzz = FizzBuzz.transform(1);
        assertThat(fizzbuzz).isEqualTo("1");
    }

    @Test
    public void two() {
        String fizzbuzz = FizzBuzz.transform(2);
        assertThat(fizzbuzz).isEqualTo("2");
    }

    // TODO test null
    // TODO test negative

    @Test
    public void four() {
        String fizzbuzz = FizzBuzz.transform(4);
        assertThat(fizzbuzz).isEqualTo("4");
    }

    @Test
    public void three() {
        String fizzbuzz = FizzBuzz.transform(3);
        assertThat(fizzbuzz).isEqualTo("Fizz");
    }

    @Test
    public void six() {
        String fizzbuzz = FizzBuzz.transform(6);
        assertThat(fizzbuzz).isEqualTo("Fizz");
    }

    @Test
    public void nine() {
        String fizzbuzz = FizzBuzz.transform(9);
        assertThat(fizzbuzz).isEqualTo("Fizz");
    }

    @Test
    public void five() {
        String fizzbuzz = FizzBuzz.transform(5);
        assertThat(fizzbuzz).isEqualTo("Buzz");
    }

    @Test
    public void ten() {
        String fizzbuzz = FizzBuzz.transform(10);
        assertThat(fizzbuzz).isEqualTo("Buzz");
    }

    @Test
    public void twenty() {
        String fizzbuzz = FizzBuzz.transform(20);
        assertThat(fizzbuzz).isEqualTo("Buzz");
    }

    @Test
    public void fifteen() {
        String fizzbuzz = FizzBuzz.transform(15);
        assertThat(fizzbuzz).isEqualTo("FizzBuzz");
    }

    @Test
    public void fizzbuzz2() {
        String fizzbuzz = FizzBuzz.transform(2*15);
        assertThat(fizzbuzz).isEqualTo("FizzBuzz");
    }

    @Test
    public void fizzbuzz3() {
        String fizzbuzz = FizzBuzz.transform(3*15);
        assertThat(fizzbuzz).isEqualTo("FizzBuzz");
    }
}