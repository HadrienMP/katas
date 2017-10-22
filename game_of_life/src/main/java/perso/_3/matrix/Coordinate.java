package perso._3.matrix;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

@EqualsAndHashCode
public class Coordinate {
    final int x;
    final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Coordinate plus(Coordinate other) {
        return new Coordinate(x + other.x, y + other.y);
    }
}
