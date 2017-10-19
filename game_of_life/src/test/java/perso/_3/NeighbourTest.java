package perso._3;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NeighbourTest {

    // TODO: 18/10/17 propriété taille jamais supérieure à 8

    @Test
    public void a_single_cell_doesnt_have_neighbours() throws Exception {
        String[][] rawMatrix = {{""}};
        Matrix matrix = new Matrix(rawMatrix);
        Coordinate element = new Coordinate(0, 0);

        List<String> neighbours = matrix.neighbours(element);

        assertThat(neighbours).isEmpty();
    }

    @Test
    public void right_neighbour() throws Exception {
        String[][] rawMatrix = {{"a", "b"}};
        Matrix matrix = new Matrix(rawMatrix);
        Coordinate element = new Coordinate(0, 0);

        List<String> neighbours = matrix.neighbours(element);

        assertThat(neighbours).containsOnly("b");
    }

    @Test
    public void left_neighbour() throws Exception {
        String[][] rawMatrix = {{"a", "b"}};
        Matrix matrix = new Matrix(rawMatrix);
        Coordinate element = new Coordinate(1, 0);

        List<String> neighbours = matrix.neighbours(element);

        assertThat(neighbours).containsOnly("a");
    }

    @Test
    public void left_and_right_neighbour() throws Exception {
        String[][] rawMatrix = {{"a", "b", "c"}};
        Matrix matrix = new Matrix(rawMatrix);
        Coordinate element = new Coordinate(1, 0);

        List<String> neighbours = matrix.neighbours(element);

        assertThat(neighbours).containsOnly("a", "c");
    }

    @Test
    public void top_neighbour() throws Exception {
        String[][] rawMatrix = {{"a"},
                                {"b"}};
        Matrix matrix = new Matrix(rawMatrix);
        Coordinate element = new Coordinate(0, 1);

        List<String> neighbours = matrix.neighbours(element);

        assertThat(neighbours).containsOnly("a");
    }

    @Test
    public void bottom_neighbour() throws Exception {
        String[][] rawMatrix = {{"a"},
                                {"b"}};
        Matrix matrix = new Matrix(rawMatrix);
        Coordinate element = new Coordinate(0, 0);

        List<String> neighbours = matrix.neighbours(element);

        assertThat(neighbours).containsOnly("b");
    }

    @Test
    public void all_neighbours() throws Exception {
        String[][] rawMatrix = {{"a", "b", "c"},
                                {"d", "e", "f"},
                                {"g", "h", "i"}};
        Matrix matrix = new Matrix(rawMatrix);
        Coordinate element = new Coordinate(1, 1);

        List<String> neighbours = matrix.neighbours(element);

        String[] expectedNeighbours = Stream.of(rawMatrix)
                .flatMap(Stream::of)
                .filter(s -> !"e".equals(s))
                .toArray(String[]::new);
        assertThat(neighbours).containsOnly(expectedNeighbours);
    }

    // TODO: 18/10/17 tester avec une matrice illégale

}
