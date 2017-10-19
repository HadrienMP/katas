package perso._3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
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

        String[] lines = generation.split("\n");
        List<List<String>> newLines = new ArrayList<>();

        for (String line: lines) {

            String[] cells = line.split("");
            List<String> newLine = new ArrayList<>();

            for (String cell: cells) {

                if ("*".equals(cell)) {
                    newLine.add("-");
                } else {
                    newLine.add(cell);
                }
            }

            newLines.add(newLine);
        }

        return print(newLines);
    }

    private String print(List<List<String>> newLines) {
        return newLines.stream()
                .map(cells -> cells.stream().collect(joining()))
                .collect(joining("\n"));
    }
}
