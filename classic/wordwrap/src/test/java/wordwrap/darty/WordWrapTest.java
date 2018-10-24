package wordwrap.darty;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class WordWrapTest {

    private WordWrap wordWrap = new WordWrap();

    @Test
    public void shouldReturnEmptyWhenTextToWrapIsEmpty() {
        // Arrange
        String text = "";
        int lineSize = 0;

        // Act
        String wrappedText = wordWrap.wrap(text, lineSize);

        // Assert
        Assertions.assertThat(wrappedText).isEqualTo("");
    }

    @Test
    public void singleWord() {
        // Arrange
        String text = "word";
        int lineSize = 4;

        // Act
        String wrappedText = wordWrap.wrap(text, lineSize);

        // Assert
        Assertions.assertThat(wrappedText).isEqualTo("word");
    }


    @Test
    public void singleWordSplitted() {
        // Arrange
        String text = "word";
        int lineSize = 2;

        // Act
        String wrappedText = wordWrap.wrap(text, lineSize);

        // Assert
        Assertions.assertThat(wrappedText).isEqualTo("wo\nrd");
    }


    @Test
    public void singleWordSeveralLines() {
        // Arrange
        String text = "abc";
        int lineSize = 1;

        // Act
        String wrappedText = wordWrap.wrap(text, lineSize);

        // Assert
        Assertions.assertThat(wrappedText).isEqualTo("a\nb\nc");
    }

    @Test
    public void twoWordSeveralLines() {
        // Arrange
        String text = "a b";
        int lineSize = 1;

        // Act
        String wrappedText = wordWrap.wrap(text, lineSize);

        // Assert
        Assertions.assertThat(wrappedText).isEqualTo("a\nb");
    }

    @Test
    public void twoWordOneSpaceOneLine() {
        // Arrange
        String text = "a b";
        int lineSize = 3;

        // Act
        String wrappedText = wordWrap.wrap(text, lineSize);

        // Assert
        Assertions.assertThat(wrappedText).isEqualTo("a b");
    }

    @Test
    public void twoWordsOneSpaceSplitted() {
        // Arrange
        String text = "a c";
        int lineSize = 1;

        // Act
        String wrappedText = wordWrap.wrap(text, lineSize);

        // Assert
        Assertions.assertThat(wrappedText).isEqualTo("a\nc");
    }

    @Test
    public void threeWordsSpaced() {
        // Arrange
        String text = "a b c";
        int lineSize = 3;

        // Act
        String wrappedText = wordWrap.wrap(text, lineSize);

        // Assert
        Assertions.assertThat(wrappedText).isEqualTo("a b\nc");
    }

    //@Test
    public void twoWordsAndSpace() {
        // Arrange
        String text = "ab c"; int lineSize = 1;

        // Act
        String wrappedText = wordWrap.wrap(text, lineSize);

        // Assert
        Assertions.assertThat(wrappedText).isEqualTo("a\nb\nc");
    }

}