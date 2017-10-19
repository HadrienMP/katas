import scala.util.parsing.combinator.testing.Str;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Generation {
    // TODO HMP extraire un objet matrix
//    private final List<List<String>> lines;
//    private final Matrix matrix;
//
//    Generation(String representation) {
//        this(new Matrix(representation));
//    }
//
//    private Generation(List<List<String>> lines) {
//        this.lines = lines;
//    }
//
//    Generation next() {
//        List<List<String>> newLines = new ArrayList<>();
//
//        for (int y = 0; y < lines.size(); y++) {
//
//            List<String> line = lines.get(y);
//            List<String> newLine = new ArrayList<>();
//
//            for (int x = 0; x < line.size(); x++) {
//                // trouver les voisins
//                // filtrer les voisins vivants
//                // si 3 on garde la cellule sinon on remplace par
//
//                String cell = line.get(x);
//                if ("*".equals(cell)) {
//                    newLine.add("-");
//                } else {
//                    newLine.add(cell);
//                }
//
//            }
//
//            newLines.add(newLine);
//        }
//
//        return new Generation(newLines);
//    }
//
//    String print() {
//        return print(lines);
//    }

}
