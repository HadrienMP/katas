package fr.hadrienmp.katas.mastermind;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MastermindSpec {

    @Test
    @Parameters({
            "V,R,0-0",
            "V,V,1-0",
            "R,R,1-0",
            "RV,RV,2-0",
            "RV,BV,1-0",
            "NV,BV,1-0",
            "NV,JV,1-0",
            "NB,JB,1-0",
            "NBV,JBJ,1-0",
            "RV,RJ,1-0",
            "RVJ,BRJ,1-0",
            "RVB,RVJ,2-0",
    })
    public void the_first_number_is_the_number_of_right_colors_at_the_right_place(String secret,
                                                                                  String candidate,
                                                                                  String expected) {
        Code secretCode = new Code(secret);
        Code candidateCode = new Code(candidate);

        long exactMatches = secretCode.countExactMatches(candidateCode);

        assertThat(exactMatches + "-0").isEqualTo(expected);
    }

}
