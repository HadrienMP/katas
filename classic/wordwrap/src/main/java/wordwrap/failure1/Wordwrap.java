package wordwrap.failure1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HadrienMP on 07/06/2016.
 */
public class Wordwrap {
    public static String wrap(String toWrap, int limit) {

        String[] parts = toWrap.split(" ");
        List<String> lines = new ArrayList<>();
        String line = "";
        for (String part : parts) {
            String separator = line.length() == 0 ? "" : " ";

            if (line.length() + separator.length() + part.length() > limit) {
                lines.add(line);
                line = "";
            }
            separator = line.length() == 0 ? "" : " ";
            line += separator + part;
        }
        if (!"".equals(line))
            lines.add(line);

        return String.join("\n", lines);
    }

    private static String replaceByLineFeedAt(String toAlter, int index) {
        return toAlter.substring(0, index) + "\n" + toAlter.substring(index + 1, toAlter.length());
    }
}
