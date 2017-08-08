package roman.numerals.perso._3;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {
    @Test
    public void _1() {
        String roman = Number.toRoman(1);
        assertThat(roman).isEqualTo("I");
    }

    @Test
    public void _2() {
        String roman = Number.toRoman(2);
        assertThat(roman).isEqualTo("II");
    }

    @Test
    public void _3() {
        String roman = Number.toRoman(3);
        assertThat(roman).isEqualTo("III");
    }

    @Test
    public void _4() {
        String roman = Number.toRoman(4);
        assertThat(roman).isEqualTo("IV");
    }

    @Test
    public void _5() {
        String roman = Number.toRoman(5);
        assertThat(roman).isEqualTo("V");
    }

    @Test
    public void _6() {
        String roman = Number.toRoman(6);
        assertThat(roman).isEqualTo("VI");
    }

    @Test
    public void _7() {
        String roman = Number.toRoman(7);
        assertThat(roman).isEqualTo("VII");
    }

    @Test
    public void _9() {
        String roman = Number.toRoman(9);
        assertThat(roman).isEqualTo("IX");
    }

    @Test
    public void _10() {
        String roman = Number.toRoman(10);
        assertThat(roman).isEqualTo("X");
    }

    @Test
    public void _11() {
        String roman = Number.toRoman(11);
        assertThat(roman).isEqualTo("XI");
    }

    // TODO 14

    @Test
    public void _15() {
        String roman = Number.toRoman(15);
        assertThat(roman).isEqualTo("XV");
    }

    @Test
    public void _16() {
        String roman = Number.toRoman(16);
        assertThat(roman).isEqualTo("XVI");
    }

    // TODO 19

    @Test
    public void _20() {
        String roman = Number.toRoman(20);
        assertThat(roman).isEqualTo("XX");
    }

    // TODO 40

    @Test
    public void _49() {
        String roman = Number.toRoman(49);
        assertThat(roman).isEqualTo("XLIX");
    }

    @Test
    public void _50() {
        String roman = Number.toRoman(50);
        assertThat(roman).isEqualTo("L");
    }

    @Test
    public void _60() {
        String roman = Number.toRoman(60);
        assertThat(roman).isEqualTo("LX");
    }

    // TODO 90

    @Test
    public void _100() {
        String roman = Number.toRoman(100);
        assertThat(roman).isEqualTo("C");
    }

    @Test
    public void _200() {
        String roman = Number.toRoman(200);
        assertThat(roman).isEqualTo("CC");
    }

    // TODO 400

    @Test
    public void _500() {
        String roman = Number.toRoman(500);
        assertThat(roman).isEqualTo("D");
    }

}
