package roman.numerals.perso._1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class NumberTestTest {

    public static Collection<Object[]> singleLetters() {
        return Arrays.asList(
                new Object[] { 1, "I" },
                new Object[] { 5, "V" },
                new Object[] { 10, "X" },
                new Object[] { 50, "L" },
                new Object[] { 100, "C" },
                new Object[] { 500, "D" },
                new Object[] { 1000, "M" }
        );
    }

    @Test
    @Parameters(method = "singleLetters")
    public void single_letters(int given, String expected) {
        check(given, expected);
    }

    public static Collection<Object[]> doubleLetters() {
        return Arrays.asList(
                new Object[] { 2, "II" },
                new Object[] { 20, "XX" },
                new Object[] { 200, "CC" },
                new Object[] { 2000, "MM" }
        );
    }

    @Test
    @Parameters(method = "doubleLetters")
    public void double_letters(int given, String expected) {
        check(given, expected);
    }

    public static Collection<Object[]> tripleLetters() {
        return Arrays.asList(
                new Object[] { 3, "III" },
                new Object[] { 30, "XXX" },
                new Object[] { 300, "CCC" },
                new Object[] { 3000, "MMM" }
        );
    }

    @Test
    @Parameters(method = "tripleLetters")
    public void triple_letters(int given, String expected) {
        check(given, expected);
    }

    public static Collection<Object[]> differentLettersAddition() {
        return Arrays.asList(
                new Object[] { 6, "VI" },
                new Object[] { 7, "VII" },
                new Object[] { 11, "XI" },
                new Object[] { 12, "XII" },
                new Object[] { 15, "XV" },
                new Object[] { 16, "XVI" },
                new Object[] { 26, "XXVI" }
        );
    }

    @Test
    @Parameters(method = "differentLettersAddition")
    public void different_letters_addition(int given, String expected) {
        check(given, expected);
    }

    public static Collection<Object[]> differentLettersSubstractionEasy() {
        return Arrays.asList(
                new Object[] { 4, "IV" },
                new Object[] { 9, "IX" },
                new Object[] { 19, "XIX" },
                new Object[] { 40, "XL" },
                new Object[] { 90, "XC" },
                new Object[] { 400, "CD" },
                new Object[] { 900, "CM" }
        );
    }

    @Test
    @Parameters(method = "differentLettersSubstractionEasy")
    public void different_letters_substraction_easy(int given, String expected) {
        check(given, expected);
    }

    public static Collection<Object[]> differentLettersSubstractionHarder() {
        return Arrays.asList(
            new Object[] { 45, "XLV" },
            new Object[] { 2999, "MMCMXCIX" }
        );
    }

    @Test
    @Parameters(method = "differentLettersSubstractionHarder")
    public void different_letters_substraction_harder(int given, String expected) {
        check(given, expected);
    }

    private void check(int given, String expected) {
        Number service = new Number(given);

        String romanNumber = service.toRomanNumeral();

        assertThat(romanNumber).isEqualTo(expected);
    }
}