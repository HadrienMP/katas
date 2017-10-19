package perso._3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Matrix<T> {
    private final List<List<T>> matrix;

    Matrix(T[][] matrix) {
        this(Stream.of(matrix)
                .map(Arrays::asList)
                .collect(toList()));
    }

    Matrix(List<List<T>> matrix) {
        this.matrix = matrix;
    }

    List<T> neighbours(Coordinate coordinate) {
        return coordinate.neighbours()
                .map(this::cellAt)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());
    }

    <N> Matrix<N> transform(BiFunction<T,Coordinate ,N> transformer) {
        return null;
    }

    Optional<T> cellAt(Coordinate coordinate) {
        if (isIn(coordinate))
            return Optional.of(matrix.get(coordinate.y).get(coordinate.x));
        else
            return Optional.empty();
    }

    private boolean isIn(Coordinate coordinate) {
        return 0 <= coordinate.y
                && coordinate.y < matrix.size()
                && 0 <= coordinate.x
                && coordinate.x < matrix.get(coordinate.y).size();
    }
}
