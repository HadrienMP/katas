package perso._3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

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
        String secondGeneration = new Generation(firstGeneration).evolve().print();

        assertThat(secondGeneration).isEqualTo(firstGeneration);
    }

    @Test
    public void a_world_with_a_single_cell_dies() throws Exception {
        String firstGeneration = "-*\n--";

        String secondGeneration = new Generation(firstGeneration).evolve().print();

        assertThat(secondGeneration).isEqualTo("--\n--");
    }

    // TODO: 18/10/17 propriete ?
    @Test
    public void a_2_2_square_of_cells_lives_forever() throws Exception {
        String firstGeneration = "----" + "\n" +
                                 "-**-" + "\n" +
                                 "-**-" + "\n" +
                                 "----";

        String secondGeneration = new Generation(firstGeneration).evolve().print();

        assertThat(secondGeneration).isEqualTo(firstGeneration);
    }

    @Test
    public void a_triangle_gives_birth_to_a_square() throws Exception {
        String firstGeneration = "*-" + "\n" +
                                 "**";

        String secondGeneration = new Generation(firstGeneration).evolve().print();

        assertThat(secondGeneration).isEqualTo(
                "**" + "\n" +
                "**"
        );
    }

    @Test
    public void cells_living_and_dying() throws Exception {
        String firstGeneration = "-*--" + "\n" +
                                 "-**-" + "\n" +
                                 "-**-" + "\n" +
                                 "----";

        String secondGeneration = new Generation(firstGeneration).evolve().print();

        assertThat(secondGeneration).isEqualTo(
                        "-**-" + "\n" +
                        "*---" + "\n" +
                        "-**-" + "\n" +
                        "----"
        );
    }
}
