package perso._3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GameOfLifeSpec {

    // TODO: 18/10/17 propriete ?
    @Test
    @Parameters({
            "--\n--",
            "---\n---",
    })
    public void a_dead_world_stays_dead(String firstGeneration) throws Exception {
        String secondGeneration = evolve(firstGeneration);
        assertThat(secondGeneration).isEqualTo(firstGeneration);
    }

    @Test
    public void a_world_with_a_single_cell_dies() throws Exception {
        String firstGeneration = "-*\n--";
        String secondGeneration = evolve(firstGeneration);
        assertThat(secondGeneration).isEqualTo("--\n--");
    }

    // TODO: 18/10/17 propriete ?
//    @Test
    public void a_2_2_square_of_cells_lives_forever() throws Exception {
        String firstGeneration = "----" + "\n" +
                                 "-**-" + "\n" +
                                 "-**-" + "\n" +
                                 "----";
        String secondGeneration = evolve(firstGeneration);
        assertThat(secondGeneration).isEqualTo(firstGeneration);
    }

    private String evolve(String generation) {

        List<List<String>> matrix = Stream.of(generation.split("\n"))
                .map(line -> asList(line.split("")))
                .collect(toList());

        // TODO HMP voir pour rassembler ces deux lignes (le transform est une ligne moche)
        Matrix<String> strings = new Matrix<>(matrix);
//        Matrix<Cell> cells = strings.transform((value, coordinate) -> Cell.from(value));
        // TODO HMP voir pour faire un objet new NeighbourDensity(cells) (le transform est une ligne moche)
//        Matrix<Long> neighbourDensity = cells.transform((value, coordinate) -> neighbours(cells, coordinate));



        List<List<String>> newMatrix = new ArrayList<>();

        for (int y = 0; y < matrix.size(); y++) {
            List<String> line = matrix.get(y);
            List<String> newLine = new ArrayList<>();
            for (int x = 0; x < line.size(); x++) {

                strings.cellAt(new Coordinate(x, y))
                        .map(cell -> "-");

                String cell = line.get(x);

                if ("*".equals(cell)) {
                    newLine.add("-");
                } else {
                    newLine.add(cell);
                }
            }

            newMatrix.add(newLine);
        }

        return print(newMatrix);
    }

    private long neighbours(Matrix<Cell> cells, Coordinate coordinate) {
        return cells.neighbours(coordinate).stream().filter(cell -> cell == Cell.ALIVE).count();
    }

    private String print(List<List<String>> newLines) {
        return newLines.stream()
                .map(cells -> cells.stream().collect(joining()))
                .collect(joining("\n"));
    }
}
