package perso._2.matrix;

import java.util.Optional;

public class PrintableMatrix<T> implements Matrix<T> {

    private Matrix<T> matrix;

    public PrintableMatrix(Matrix<T> matrix) {
        this.matrix = matrix;
    }


    public String print() {

        StringBuilder stringBuilder = new StringBuilder();

        for (int y = 0; y < height(); y++) {
            for (int x = 0; x < width(); x++) {
                stringBuilder.append(stringAt(x, y));
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().trim();
    }

    private String stringAt(int x, int y) {
        Coordinate coordinate = new Coordinate(x, y);
        return matrix.get(coordinate)
                .map(Object::toString)
                .orElseThrow(() -> new RuntimeException("No cell at " + coordinate));
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
