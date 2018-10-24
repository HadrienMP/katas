package perso._1;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeTest {
    @Test
    public void an_empty_world_remains_empty() throws Exception {
        Grid grid = new Grid(2, 2);

        Grid newGrid = grid.nextGeneration();

        assertThat(newGrid).isNotSameAs(grid);
        assertThat(newGrid).isEqualTo(grid);
    }

    @Test
    public void a_lonely_cell_dies() throws Exception {
        Cell alive = new Cell(0, 0);
        Grid empty = new Grid(2, 2);
        Grid gridWithCell = empty.place(alive);

        Grid supposedToBeEmpty = gridWithCell.nextGeneration();

        assertThat(supposedToBeEmpty).isNotSameAs(empty);
        assertThat(supposedToBeEmpty).isEqualTo(empty);
    }

    @Test
    public void when_all_cells_on_a_2_2_grid_are_alive_they_stay_alive() throws Exception {
        Grid empty = new Grid(2, 2);
        List<Cell> alive = Arrays.asList(
                new Cell(0, 0),new Cell(1, 0),
                new Cell(0, 1),new Cell(1, 1));
        Grid firstGeneration = empty.place(alive);

        Grid secondGeneration = firstGeneration.nextGeneration();

        assertThat(secondGeneration).isEqualTo(firstGeneration);
    }

    @Test
    public void when_() throws Exception {
        Grid empty = new Grid(3, 3);
        List<Cell> alive = range(0, 3).boxed()
                .flatMap(x -> range(0, 3).boxed().map(y -> new Cell(x, y)))
                .collect(Collectors.toList());
        Grid firstGeneration = empty.place(alive);

        Grid secondGeneration = firstGeneration.nextGeneration();

        Grid expectedSecondGeneration = empty.place(new Cell(1, 1));
        assertThat(secondGeneration).isEqualTo(expectedSecondGeneration);
    }

    @ToString
    @EqualsAndHashCode
    private class Grid {
        public Grid(int width, int height) {
        }

        public Grid nextGeneration() {
            return new Grid(0,0);
        }

        public Grid place(Cell alive) {
            return new Grid(0,0);
        }

        public Grid place(List<Cell> alive) {
            return new Grid(0,0);
        }
    }

    private class Cell {
        public Cell(int x, int y) {
        }
    }
}
