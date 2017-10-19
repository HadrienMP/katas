package perso._3;

import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@EqualsAndHashCode
class Coordinate {
    final int x;
    final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // TODO: 18/10/17 peut-être pas le meilleur endroit
    Stream<Coordinate> neighbours() {
        return neighbourDistances().stream().map(this::plus);
    }

    private List<Coordinate> neighbourDistances() {
        return distances()
                .flatMap(y -> distances().map(x -> new Coordinate(x, y)))
                .filter(coordinate -> !coordinate.equals(new Coordinate(0,0)))
                .collect(toList());
    }

    private Stream<Integer> distances() {
        return Stream.of(-1, 0, 1);
    }

    private Coordinate plus(Coordinate neighbour) {
        return new Coordinate(x + neighbour.x, y + neighbour.y);
    }
}
