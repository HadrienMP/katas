package perso._2;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.join;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Generation {
    private static final String ALIVE = "*";
    private static final String DEAD = ".";

    private List<List<String>> cells;
    private int width;
    private int height;

    Generation(String cells) {
        this(stream(cells.split("\n"))
                .map(line -> asList(line.split("")))
                .collect(toList()));
    }

    private Generation(List<List<String>> cells) {
        // TODO: 15/10/17 voir comment doit se comporter une liste vide
        this.cells = cells;
        height = cells.size();
        width = cells.get(0).size();
    }

    Generation next() {

        List<List<String>> newCells = new ArrayList<>();
        for (int y = 0; y < height; y++) {

            List<String> newLine = new ArrayList<>();

            for (int x = 0; x < width; x++) {
                Coordinate coord = new Coordinate(x, y);
                String newCell = newCellAt(coord);
                newLine.add(newCell);
            }

            newCells.add(newLine);
        }

        return new Generation(newCells);
    }

    @NotNull
    private String newCellAt(Coordinate coord) {
        String newCell;
        if (neighbours(coord) == 3) {
            newCell = ALIVE;
        } else {
            newCell = DEAD;
        }
        return newCell;
    }

    // TODO: 15/10/17 class coordinates ?
    private long neighbours(Coordinate current) {
        return translations().map(current::translate)
                .filter(neighbour -> !neighbour.equals(current))
                // TODO: 15/10/17 voir avec le beetween de yegor
                .filter(neighbour -> 0 <= neighbour.x && neighbour.x <= width)
                .filter(neighbour -> 0 <= neighbour.y && neighbour.y <= height)
                // TODO: 15/10/17 null safety ?
                .filter(neighbour -> cellAt(neighbour).equals(ALIVE))
                .count();
    }

    private Stream<Coordinate> translations() {
        List<Integer> distances = Arrays.asList(-1, 0, 1);
        return distances.stream().flatMap(x -> distances.stream().map(y -> new Coordinate(x, y)));
    }

    private String cellAt(Coordinate coordinate) {
        return cells.get(coordinate.y).get(coordinate.x);
    }

    @Override
    public String toString() {
        return cells.stream()
                .map(line -> join("", line))
                .collect(joining("\n"));
    }

    @AllArgsConstructor
    @EqualsAndHashCode
    private static class Coordinate {
        public final int x;
        public final int y;

        Coordinate translate(Coordinate translation) {
            return translation;
        }
    }
}
