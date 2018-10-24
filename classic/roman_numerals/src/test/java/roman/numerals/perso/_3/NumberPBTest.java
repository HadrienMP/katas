package roman.numerals.perso._3;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class NumberPBTest {

    @Property
    public void no_more_than_3_of_any_symbol(@InRange(minInt = 0, maxInt = 4000) int number) {
        String roman = Number.toRoman(number);

        for (RomanDigit digit: RomanDigit.values()) {
            Matcher matcher = Pattern.compile(digit.getRoman() + "+").matcher(roman);

            if (matcher.matches()) {
                assertThat(matcher.group().length()).isLessThanOrEqualTo(3);
            }
        }
    }
}
