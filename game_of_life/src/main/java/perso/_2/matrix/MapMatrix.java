package perso._2.matrix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.toList;

public class MapMatrix<T> implements Matrix {

    private final Map<Coordinate, T> content;

    public MapMatrix(String cells, Function<String, T> toT) {
        this(toCells(cells, toT));
    }

    private static <T> Map<Coordinate, T> toCells(String representation, Function<String, T> toT) {
        // TODO: 15/10/17 OMG!!!!!!!!!!!!!!!!!!!

        List<List<String>> cells = stream(representation.split("\n"))
                .map(line -> asList(line.split("")))
                .collect(toList());


        Map<Coordinate, T> content = new HashMap<>();

        for (int y = 0; y < cells.size(); y++) {
            List<String> line = cells.get(y);
            for (int x = 0; x < line.size(); x++) {
                String cell = line.get(x);

                Coordinate coordinate = new Coordinate(x, y);
                T t = toT.apply(cell);

                content.put(coordinate, t);
            }
        }

        return content;
    }

    public MapMatrix(Map<Coordinate, T> content) {
        this.content = content;
    }


    @Override
    public int width() {
        return max(Coordinate::x) + 1;
    }

    @Override
    public int height() {
        return max(Coordinate::y) + 1;
    }

    private Integer max(Function<Coordinate, Integer> value) {
        return content.keySet()
                .stream()
                .map(value)
                .sorted(reverseOrder())
                .findFirst()
                .orElse(0);
    }

    @Override
    public Optional<T> get(Coordinate coordinate) {
        return Optional.ofNullable(content.get(coordinate));
    }

    @Override
    public Iterable<Coordinate> coordinates() {
        return content.keySet();
    }
}
