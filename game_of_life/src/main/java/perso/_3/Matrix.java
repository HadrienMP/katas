package perso._3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Matrix<T> implements Cloneable, Iterable<Element<T>> {
    private final List<List<T>> matrix;

    static Matrix<String> from(String representation) {
        return new Matrix<>(Stream.of(representation.split("\n"))
                .map(line -> asList(line.split("")))
                .collect(toList()));
    }

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
                .stream()
                .map(this::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());
    }

    <N> Matrix<N> transform(Function<T, N> transformer) {

        List<List<N>> matrix = this.matrix
                .stream()
                .map(line -> line.stream()
                        .map(transformer)
                        .collect(toList()))
                .collect(toList());

        return new Matrix<>(matrix);
    }

    Optional<T> get(Coordinate coordinate) {
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

    Matrix<T> set(Coordinate coordinate, T value) {
        Matrix<T> matrix = clone();
        matrix.matrix
                .get(coordinate.y)
                .set(coordinate.x, value);
        return matrix;
    }

    @Override
    protected Matrix<T> clone() {
        return transform(Function.identity());
    }

    String print() {
        return matrix.stream()
                .map(cells -> cells.stream()
                        .map(Object::toString)
                        .collect(joining()))
                .collect(joining("\n"));
    }

    @Override
    public Iterator<Element<T>> iterator() {
        List<Element<T>> elements = new ArrayList<>();
        for (int y = 0; y < matrix.size(); y++) {
            List<T> line = matrix.get(y);
            for (int x = 0; x < line.size(); x++) {
                Coordinate coordinate = new Coordinate(x, y);
                Element<T> element = new Element<>(coordinate, line.get(x));
                elements.add(element);
            }
        }
        return elements.iterator();
    }

    Matrix<T> update(Element<T> element) {
        Matrix<T> matrix = clone();
        matrix.matrix
                .get(element.coordinate.y)
                .set(element.coordinate.x, element.value);
        return matrix;
    }
}
