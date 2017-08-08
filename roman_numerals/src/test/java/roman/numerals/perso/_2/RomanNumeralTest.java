package roman.numerals.perso._2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralTest {

    @Test
    public void one() {
        String roman = new Number(1).toRoman();
        assertThat(roman).isEqualTo("I");
    }

    @Test
    public void two() {
        String roman = new Number(2).toRoman();
        assertThat(roman).isEqualTo("II");
    }

    @Test
    public void three() {
        String roman = new Number(3).toRoman();
        assertThat(roman).isEqualTo("III");
    }

    @Test
    public void four() {
        String roman = new Number(4).toRoman();
        assertThat(roman).isEqualTo("IV");
    }

    @Test
    public void five() {
        String roman = new Number(5).toRoman();
        assertThat(roman).isEqualTo("V");
    }

    @Test
    public void six() {
        String roman = new Number(6).toRoman();
        assertThat(roman).isEqualTo("VI");
    }

    @Test
    public void nine() {
        String roman = new Number(9).toRoman();
        assertThat(roman).isEqualTo("IX");
    }

    @Test
    public void ten() {
        String roman = new Number(10).toRoman();
        assertThat(roman).isEqualTo("X");
    }

    @Test
    public void eleven() {
        String roman = new Number(11).toRoman();
        assertThat(roman).isEqualTo("XI");
    }

    @Test
    public void fourteen() {
        String roman = new Number(14).toRoman();
        assertThat(roman).isEqualTo("XIV");
    }

    @Test
    public void fifteen() {
        String roman = new Number(15).toRoman();
        assertThat(roman).isEqualTo("XV");
    }

    @Test
    public void sixteen() {
        String roman = new Number(16).toRoman();
        assertThat(roman).isEqualTo("XVI");
    }

    @Test
    public void ninteen() {
        String roman = new Number(19).toRoman();
        assertThat(roman).isEqualTo("XIX");
    }

    @Test
    public void twenty() {
        String roman = new Number(20).toRoman();
        assertThat(roman).isEqualTo("XX");
    }

    @Test
    public void fourty() {
        String roman = new Number(40).toRoman();
        assertThat(roman).isEqualTo("XL");
    }

    @Test
    public void fourty_nine() {
        String roman = new Number(49).toRoman();
        assertThat(roman).isEqualTo("XLIX");
    }

    @Test
    public void fifty() {
        String roman = new Number(50).toRoman();
        assertThat(roman).isEqualTo("L");
    }

    @Test
    public void seventy_six() {
        String roman = new Number(76).toRoman();
        assertThat(roman).isEqualTo("LXXVI");
    }

    @Test
    public void ninety() {
        String roman = new Number(90).toRoman();
        assertThat(roman).isEqualTo("XC");
    }

    @Test
    public void ninety_nine() {
        String roman = new Number(99).toRoman();
        assertThat(roman).isEqualTo("XCIX");
    }

    @Test
    public void hundred() {
        String roman = new Number(100).toRoman();
        assertThat(roman).isEqualTo("C");
    }

    @Test
    public void four_hundred() {
        String roman = new Number(400).toRoman();
        assertThat(roman).isEqualTo("CD");
    }

    @Test
    public void four_hundred_ninety_nine() {
        String roman = new Number(499).toRoman();
        assertThat(roman).isEqualTo("CDXCIX");
    }

    @Test
    public void five_hundred() {
        String roman = new Number(500).toRoman();
        assertThat(roman).isEqualTo("D");
    }

    @Test
    public void nine_hundred() {
        String roman = new Number(900).toRoman();
        assertThat(roman).isEqualTo("CM");
    }

    @Test
    public void nine_hundred_fourty_nine() {
        String roman = new Number(949).toRoman();
        assertThat(roman).isEqualTo("CMXLIX");
    }

    @Test
    public void a_thousand() {
        String roman = new Number(1_000).toRoman();
        assertThat(roman).isEqualTo("M");
    }

    @Test
    public void three_thousand_nine_hundred_ninety_nine() {
        String roman = new Number(3_999).toRoman();
        assertThat(roman).isEqualTo("MMMCMXCIX");
    }

}