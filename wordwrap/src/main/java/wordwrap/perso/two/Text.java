package wordwrap.perso.two;

import java.util.Optional;

public class Text {
    private String content;

    public Text(String content) {

        this.content = content;
    }

    public String wrapWithMaxLength(int lineSize) {
        if (splitNotNeeded(lineSize)) {
            return content;
        }

        Optional<Integer> splittableSpaceIndex = findSplittableSpace(lineSize);
        int lineEndIndex = splittableSpaceIndex.orElse(lineSize);

        int nextLineStartIndex = lineSize;
        if (splittableSpaceIndex.isPresent()) {
            nextLineStartIndex = lineEndIndex + 1;
        }

        String nextLines = content.substring(nextLineStartIndex);
        return content.substring(0, lineEndIndex) + "\n" + new Text(nextLines).wrapWithMaxLength(lineSize);
    }

    private boolean splitNotNeeded(int lineSize) {
        return content.length() <= lineSize;
    }

    private Optional<Integer> findSplittableSpace(int lineSize) {
        int spaceSplitIndex = content.substring(0, lineSize + 1).lastIndexOf(" ");

        return isSpaceNotFound(spaceSplitIndex) ? Optional.empty() : Optional.of(spaceSplitIndex);
    }

    private boolean isSpaceNotFound(int spaceSplitIndex) {
        return spaceSplitIndex == -1;
    }
}
