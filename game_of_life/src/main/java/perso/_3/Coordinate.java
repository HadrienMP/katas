package perso._3;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

@EqualsAndHashCode
class Coordinate {
    private static final List<Coordinate> NEIGHBOURS = asList(
            new Coordinate(-1, -1), new Coordinate(0, -1), new Coordinate(1, -1),
            new Coordinate(-1,  0),                        new Coordinate(1,  0),
            new Coordinate(-1,  1), new Coordinate(0,  1), new Coordinate(1,  1)
    );

    final int x;
    final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // TODO: 18/10/17 peut-être pas le meilleur endroit
    Stream<Coordinate> neighbours() {
        return NEIGHBOURS.stream().map(this::plus);
    }

    private Coordinate plus(Coordinate other) {
        return new Coordinate(x + other.x, y + other.y);
    }
}
