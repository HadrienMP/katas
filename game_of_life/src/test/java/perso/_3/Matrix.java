package perso._3;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

class Matrix {
    private final String[][] matrix;

    Matrix(String[][] matrix) {
        this.matrix = matrix;
    }

    List<String> neighbours(Coordinate coordinate) {
        return coordinate.neighbours()
                .map(this::cellAt)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());
    }

    private Optional<String> cellAt(Coordinate coordinate) {
        if (isIn(coordinate))
            return Optional.of(matrix[coordinate.y][coordinate.x]);
        else
            return Optional.empty();
    }

    private boolean isIn(Coordinate coordinate) {
        return 0 <= coordinate.y
                && coordinate.y < matrix.length
                && 0 <= coordinate.x
                && coordinate.x < matrix[coordinate.y].length;
    }

}
