package perso2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by had1men on 06/06/2016.
 */
public class FizzBuzzTest {

    @Test
    public void zero() {
        String result = FizzBuzz.toString(0);
        assertThat(result).isEqualTo("0");
    }

    @Test
    public void one() {
        String result = FizzBuzz.toString(1);
        assertThat(result).isEqualTo("1");
    }

    @Test
    public void three() {
        String result = FizzBuzz.toString(3);
        assertThat(result).isEqualTo("Fizz");
    }

    @Test
    public void six() {
        String result = FizzBuzz.toString(6);
        assertThat(result).isEqualTo("Fizz");
    }

    @Test
    public void five() {
        String result = FizzBuzz.toString(5);
        assertThat(result).isEqualTo("Buzz");
    }

    @Test
    public void ten() {
        String result = FizzBuzz.toString(10);
        assertThat(result).isEqualTo("Buzz");
    }

    @Test
    public void fifteen() {
        String result = FizzBuzz.toString(15);
        assertThat(result).isEqualTo("FizzBuzz");
    }

    @Test
    public void thirty() {
        String result = FizzBuzz.toString(30);
        assertThat(result).isEqualTo("FizzBuzz");
    }

    @Test
    public void negative() {
        String result = FizzBuzz.toString(-1);
        assertThat(result).isEqualTo("-1");
    }

    @Test
    public void negativeThree() {
        String result = FizzBuzz.toString(-3);
        assertThat(result).isEqualTo("Fizz");
    }

}