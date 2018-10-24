package perso._2.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NeighbourAwareMatrix<T> implements Matrix<T> {

    private Matrix<T> matrix;

    public NeighbourAwareMatrix(Matrix<T> matrix) {
        this.matrix = matrix;
    }

    public List<T> neighbours(Coordinate coordinate) {
        return translations().map(coordinate::translate)
                .map(this::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toList());
    }

    private Stream<Coordinate> translations() {
        Coordinate neutralTranslation = new Coordinate(0, 0);
        List<Integer> distances = Arrays.asList(-1, 0, 1);
        return distances.stream()
                .flatMap(x -> distances.stream().map(y -> new Coordinate(x, y)))
                .filter(coordinate -> !neutralTranslation.equals(coordinate));
    }

    @Override
    public int width() {
        return matrix.width();
    }

    @Override
    public int height() {
        return matrix.height();
    }

    @Override
    public Optional<T> get(Coordinate coordinate) {
        return matrix.get(coordinate);
    }

    @Override
    public Iterable<Coordinate> coordinates() {
        return matrix.coordinates();
    }
}
