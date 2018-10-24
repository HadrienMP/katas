package perso._2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeTest {

    @Test
    public void when_all_cells_are_dead_they_stay_dead() throws Exception {
        String first = ".." + "\n" + "..";

        String second = new Generation(first)
                .next()
                .toString();

        assertThat(second).isEqualTo(first);
    }
    @Test
    public void a_single_cell_dies_alone() throws Exception {
        String first = ".*." + "\n" + "...";

        String second = new Generation(first)
                .next()
                .toString();

        assertThat(second).isEqualTo("..." + "\n" + "...");
    }
    @Test
    public void a_2_by_2_square_lives_forever() throws Exception {
        String first = "**" + "\n"
                     + "**";

        String second = new Generation(first)
                .next()
                .toString();

        assertThat(second).isEqualTo(first);
    }
}
