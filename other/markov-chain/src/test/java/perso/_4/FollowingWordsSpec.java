package perso._4;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class FollowingWordsSpec {

    /*
     * la -> la: "" 100%
     * la li -> la: li 100%, li: "" 100%
     * la li la -> la: li 50% "" 50%, li: la 100%
     * la li la lo la li -> la: li 66 lo 33
     * la la la -> la: 100
     * '' -> ''
     *
     * Tactic : Words following one word
     */

    @Test
    @Parameters({
            "la li, la, li",
            "la lo, la, lo",
            "lu la lo, la, lo",
    })
    public void should_return_the_following_word_for_a_word_appearing_once(String text1,
                                                                           String searched,
                                                                           String expected) {
        Text text = new Text(text1);
        Map<String, Integer> wordsFollowing = text.statisticalRepartitionOfWordsFollowing(searched);
        assertThat(wordsFollowing).containsEntry(expected, 100);
    }
    // TODO: 08/09/18 la li la

    @Test
    public void different_words() {
        Text text = new Text("la li la lu");
        Map<String, Integer> wordsFollowing = text.statisticalRepartitionOfWordsFollowing("la");
        assertThat(wordsFollowing).containsEntry("li", 50);
    }

    @Test
    public void different_wordsasdasd() {
        Text text = new Text("la li la lu la li la li");
        Map<String, Integer> wordsFollowing = text.statisticalRepartitionOfWordsFollowing("la");
        assertThat(wordsFollowing).containsEntry("li", 75);
    }

    @Test
    public void should_be_empty_for_an_empty_text() {
        Text text = new Text("");
        Map<String, Integer> wordsFollowing = text.statisticalRepartitionOfWordsFollowing("la");
        assertThat(wordsFollowing).isEmpty();
    }

    @Test
    public void should_be_empty_for_a_word_not_appearing() {
        Text text = new Text("lu li lo");
        Map<String, Integer> wordsFollowing = text.statisticalRepartitionOfWordsFollowing("la");
        assertThat(wordsFollowing).isEmpty();
    }

    @Test
    public void should_be_empty_for_a_word_appearing_last() {
        Text text = new Text("lu li lo la");
        Map<String, Integer> wordsFollowing = text.statisticalRepartitionOfWordsFollowing("la");
        assertThat(wordsFollowing).isEmpty();
    }

    @Test
    public void should_be_empty_when_the_word_is_the_only_one() {
        Text text = new Text("la");
        Map<String, Integer> wordsFollowing = text.statisticalRepartitionOfWordsFollowing("la");
        assertThat(wordsFollowing).isEmpty();
    }

}
