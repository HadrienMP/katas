package perso._3.matrix;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Neighbours {
    private static final List<Coordinate> NEIGHBOURS = asList(
            new Coordinate(-1, -1), new Coordinate(0, -1), new Coordinate(1, -1),
            new Coordinate(-1,  0),                        new Coordinate(1,  0),
            new Coordinate(-1,  1), new Coordinate(0,  1), new Coordinate(1,  1)
    );

    private Coordinate coordinate;

    Neighbours(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Stream<Coordinate> stream() {
        return neighbours().stream();
    }

    private List<Coordinate> neighbours() {
        return NEIGHBOURS.stream()
                .map(coordinate::plus)
                .collect(toList());
    }
}
