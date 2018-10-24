package perso._3;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static perso._3.Cell.ALIVE;
import static perso._3.Cell.DEAD;

@RunWith(JUnitParamsRunner.class)
public class CellSpec {

    @Test
    public void a_dead_cell_without_3_neighbours_becomes_alive() throws Exception {
        assertThat(DEAD.evolve(3)).isEqualTo(ALIVE);
    }

    @Test
    @Parameters({"0", "1", "2", "4", "5", "6", "7", "8"})
    public void a_dead_cell_stays_dead(int neighbours) throws Exception {
        assertThat(DEAD.evolve(neighbours)).isEqualTo(DEAD);
    }

    @Test
    @Parameters({"0", "1"})
    public void a_live_cell_with_less_than_2_neighbours_dies(int neighbours) throws Exception {
        assertThat(ALIVE.evolve(neighbours)).isEqualTo(DEAD);
    }

    @Test
    @Parameters({"2", "3"})
    public void a_live_cell_with_2_or_3_neighbours_stays_alive(int neighbours) throws Exception {
        assertThat(ALIVE.evolve(neighbours)).isEqualTo(ALIVE);
    }

    @Test
    @Parameters({"4", "5", "6", "7", "8"})
    public void a_live_cell_with_more_than_3_neighbours_dies(int neighbours) throws Exception {
        assertThat(ALIVE.evolve(neighbours)).isEqualTo(DEAD);
    }
}
