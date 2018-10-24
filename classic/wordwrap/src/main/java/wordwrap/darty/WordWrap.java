package wordwrap.darty;

public class WordWrap {

    public static final String WORD_SEPARATOR = " ";
    public static final String LINE_SEPARATOR = "\n";

    public String wrap(String text, int lineSize) {

        if (lineSize >= text.length()) {
            return text;
        }

        if (text.contains(WORD_SEPARATOR)) {
            return text.replaceAll(WORD_SEPARATOR, LINE_SEPARATOR);
        }
        return text.substring(0, lineSize) + LINE_SEPARATOR + wrap(text.substring(lineSize), lineSize);
    }
}
