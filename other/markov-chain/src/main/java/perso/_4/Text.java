package perso._4;

import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toMap;

class Text {
    private List<String> words;

    public Text(String text) {
        words = asList(text.split(" "));
    }

    public Map<String, Integer> statisticalRepartitionOfWordsFollowing(String word) {
        return statisticalRepartition(wordsFollowing(word));
    }

    private HashMap<String, Integer> statisticalRepartition(List<String> wordsFollowing) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : wordsFollowing) {
            Integer previousValue = map.getOrDefault(w, 0);
            int value = 100 / wordsFollowing.size() + previousValue;
            map.put(w, value);
        }
        return map;
    }

    private List<String> wordsFollowing(String word) {
        List<String> f = new ArrayList<>();
        for (int i = 1; i < words.size(); i++) {
            if (words.get(i - 1).equals(word)) {
                f.add(words.get(i));
            }
        }
        return f;
    }
}
