package wordwrap.perso.two;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextTest {

    @Test
    public void no_split() {
        Text text = new Text("abc");
        String wrapped = text.wrapWithMaxLength(10);
        assertThat(wrapped).isEqualTo("abc");
    }

    @Test
    public void no_split_2() {
        Text text = new Text("abcd");
        String wrapped = text.wrapWithMaxLength(10);
        assertThat(wrapped).isEqualTo("abcd");
    }

    @Test
    public void single_word_split() {
        Text text = new Text("abcd");
        String wrapped = text.wrapWithMaxLength(2);
        assertThat(wrapped).isEqualTo("ab\ncd");
    }

    @Test
    public void same_size() {
        Text text = new Text("abcd");
        String wrapped = text.wrapWithMaxLength(4);
        assertThat(wrapped).isEqualTo("abcd");
    }

    @Test
    public void single_word_two_split() {
        Text text = new Text("abcdef");
        String wrapped = text.wrapWithMaxLength(2);
        assertThat(wrapped).isEqualTo("ab\ncd\nef");
    }

    @Test
    public void two_words_split_before_space() {
        Text text = new Text("abcd ef");
        String wrapped = text.wrapWithMaxLength(4);
        assertThat(wrapped).isEqualTo("abcd\nef");
    }

    @Test
    public void two_words_split_after_space() {
        Text text = new Text("abcd ef");
        String wrapped = text.wrapWithMaxLength(5);
        assertThat(wrapped).isEqualTo("abcd\nef");
    }

    @Test
    public void two_words_split_after_space_2() {
        Text text = new Text("abcd ef");
        String wrapped = text.wrapWithMaxLength(6);
        assertThat(wrapped).isEqualTo("abcd\nef");
    }

    @Test
    public void two_words_space_not_split() {
        Text text = new Text("ab cd ef");
        String wrapped = text.wrapWithMaxLength(5);
        assertThat(wrapped).isEqualTo("ab cd\nef");
    }

    @Test
    public void space_split_and_long_word_after() {
        Text text = new Text("abcd efghijkl");
        String wrapped = text.wrapWithMaxLength(5);
        assertThat(wrapped).isEqualTo("abcd\nefghi\njkl");
    }
}