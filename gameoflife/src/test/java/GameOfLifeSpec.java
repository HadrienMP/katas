import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class GameOfLifeSpec {

    // TODO HMP ceci est peut-être une propriété
    @Test
    @Parameters({
            "--\n--",
            "---\n---"
    })
    public void dead_cells_stay_dead(String deadCells) throws Exception {
        String secondGeneration = new Generation(deadCells)
                .next()
                .print();
        assertThat(secondGeneration).isEqualTo(deadCells);
    }

    @Test
    public void a_single_cell_dies_alone() throws Exception {
        String firstGeneration = "-*\n--";
        String secondGeneration = new Generation(firstGeneration).next().print();
        assertThat(secondGeneration).isEqualTo("--\n--");
    }

    // TODO HMP peut-être une propriété ici
//    @Test
    public void a_square_of_cell_lives_forever() throws Exception {
        String firstGeneration = "----" + "\n"
                               + "-**-" + "\n"
                               + "-**-" + "\n"
                               + "----";
        String secondGeneration = new Generation(firstGeneration).next().print();
        assertThat(secondGeneration).isEqualTo(firstGeneration);
    }

    // TODO HMP enforce borders

}
