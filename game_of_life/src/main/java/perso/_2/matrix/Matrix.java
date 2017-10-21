package perso._2.matrix;

import java.util.Optional;

public interface Matrix<T> {
    int width();
    int height();
    Optional<T> get(Coordinate coordinate);
    Iterable<Coordinate> coordinates();
}
