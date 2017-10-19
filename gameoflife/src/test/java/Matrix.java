import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Matrix {
    private final List<List<String>> newLines;

    Matrix(String representation) {
        newLines = Stream.of(representation.split("\n"))
                .map(s -> Stream.of(s.split(""))
                        .collect(toList()))
                .collect(toList());
    }

    private String print() {
        return newLines.stream()
                .map(cells -> cells.stream()
                        .collect(joining()))
                .collect(joining("\n"));
    }
}
