package wordwrap.failure1;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by HadrienMP on 07/06/2016.
 */
public class WordwrapTest {

    @Test
    public void empty_zero() {
        String wrapped = Wordwrap.wrap("", 0);
        Assertions.assertThat(wrapped).isEqualTo("");
    }

    @Test
    public void empty_10() {
        String wrapped = Wordwrap.wrap("", 10);
        Assertions.assertThat(wrapped).isEqualTo("");
    }

    @Test
    public void nospace_bigger() {
        String wrapped = Wordwrap.wrap("azerty", 10);
        Assertions.assertThat(wrapped).isEqualTo("azerty");
    }

    @Test
    public void nospace_bigger2() {
        String wrapped = Wordwrap.wrap("toto", 10);
        Assertions.assertThat(wrapped).isEqualTo("toto");
    }

    @Test
    // Should I have given any string rather than just "no space strings"
    public void nospace_bigger3() {
        String wrapped = Wordwrap.wrap("qdfqgf", 10);
        Assertions.assertThat(wrapped).isEqualTo("qdfqgf");
    }

    @Test
    public void space_lower_doable() {
        String wrapped = Wordwrap.wrap("aze rty", 5);
        Assertions.assertThat(wrapped).isEqualTo("aze\nrty");
    }

    @Test
    public void space_lower_doable2() {
        String wrapped = Wordwrap.wrap("azert y", 5);
        Assertions.assertThat(wrapped).isEqualTo("azert\ny");
    }

    @Test
    public void space_lower_doable3() {
        String wrapped = Wordwrap.wrap("te st", 2);
        Assertions.assertThat(wrapped).isEqualTo("te\nst");
    }

    @Test
    public void three_space_doable() {
        String wrapped = Wordwrap.wrap("test test test", 4);
        Assertions.assertThat(wrapped).isEqualTo("test\ntest\ntest");
    }

    @Test
    public void non_breaking_spaces() {
        String wrapped = Wordwrap.wrap("test test test", 9);
        Assertions.assertThat(wrapped).isEqualTo("test test\ntest");
    }

    @Test
    public void non_breaking_spaces_multilines() {
        String wrapped = Wordwrap.wrap("test test test test test test test test test test ", 9);
        Assertions.assertThat(wrapped).isEqualTo("test test\ntest test\ntest test\ntest test\ntest test");
    }

    @Test
    @Ignore
    // TODO test later
    public void nospace_lower() {
        String wrapped = Wordwrap.wrap("azerty", 2);
        Assertions.assertThat(wrapped).isEqualTo("az\nerty");
    }

    // TODO espaces autour
    // TODO null parameters
    // TODO 0 et chaine plus grande

    @Test
    @Ignore
    // TODO
    public void nospace_zero() {
        String wrapped = Wordwrap.wrap("dqkfqskjfqhsfhkqsjfqksjhfqsf", 0);
        Assertions.assertThat(wrapped).isEqualTo("");
    }

    // TODO test negative number
    // TODO test non zero number
}