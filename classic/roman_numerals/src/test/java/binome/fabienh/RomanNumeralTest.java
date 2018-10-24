package binome.fabienh;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralTest {

    @Test
    public void should_print_I_for_one() {
        RomanNumeral romanNumeral = new RomanNumeral(1);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("I");
    }

    @Test
    public void should_print_II_for_two() {
        RomanNumeral romanNumeral = new RomanNumeral(2);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("II");
    }

    @Test
    public void should_print_III_for_three() {
        RomanNumeral romanNumeral = new RomanNumeral(3);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("III");
    }

    @Test
    public void should_print_V_for_five() {
        RomanNumeral romanNumeral = new RomanNumeral(5);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("V");
    }

    @Test
    public void should_print_X_for_ten() {
        RomanNumeral romanNumeral = new RomanNumeral(10);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("X");
    }

    @Test
    public void should_print_XX_for_twenty() {
        RomanNumeral romanNumeral = new RomanNumeral(20);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("XX");
    }

    @Test
    public void should_print_L_for_fifty() {
        RomanNumeral romanNumeral = new RomanNumeral(50);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("L");
    }

    @Test
    public void should_print_C_for_hundred() {
        RomanNumeral romanNumeral = new RomanNumeral(100);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("C");
    }

    @Test
    public void should_print_CC_for_two_hundred() {
        RomanNumeral romanNumeral = new RomanNumeral(200);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("CC");
    }

    @Test
    public void should_print_D_for_five_hundred() {
        RomanNumeral romanNumeral = new RomanNumeral(500);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("D");
    }

    @Test
    public void should_print_M_for_one_thousand() {
        RomanNumeral romanNumeral = new RomanNumeral(1_000);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("M");
    }

    @Test
    public void should_print_MM_for_two_thousand() {
        RomanNumeral romanNumeral = new RomanNumeral(2_000);

        String romanNumber = romanNumeral.toString();

        assertThat(romanNumber).isEqualTo("MM");
    }
}