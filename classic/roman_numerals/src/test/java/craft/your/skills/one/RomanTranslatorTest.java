package craft.your.skills.one;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class RomanTranslatorTest {

    private RomanTranslator romanTranslator;

    @Before
    public void setUp() {
        romanTranslator = new RomanTranslator();
    }


    @Test
    @Parameters({"1,I", "2,II"})
    public void testConvertWhenParamIsUn(int number, String i) {
        Assertions.assertThat(romanTranslator.convert(number)).isEqualTo(i);
    }

    @Test
    public void testConvertWhenParamIsTrois() {
        testConvertWhenParamIsUn(3, "III");
    }

    @Test
    public void testConvertWhenParamIsCinq() {
        testConvertWhenParamIsUn(5, "V");
    }

    @Test
    public void testConvertWhenParamIsSix() {
        testConvertWhenParamIsUn(6, "VI");
    }

    @Test
    public void testConvertWhenParamIsSept() {
        testConvertWhenParamIsUn(7, "VII");
    }

    @Test
    public void testConvertWhenParamIsDix() {
        testConvertWhenParamIsUn(10, "X");
    }

    @Test
    public void testConvertWhenParamIs50() {
        testConvertWhenParamIsUn(50, "L");
    }
    @Test
    public void testConvertWhenParamIs4() {
        testConvertWhenParamIsUn(4, "IV");
    }
}
