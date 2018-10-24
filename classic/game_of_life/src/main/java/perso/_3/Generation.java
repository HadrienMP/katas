package perso._3;

import perso._3.matrix.Coordinate;
import perso._3.matrix.Element;
import perso._3.matrix.Matrix;

import static perso._3.Cell.ALIVE;

class Generation {

    private final Matrix<Cell> cells;

    Generation(String matrix) {
        cells = Matrix.from(matrix).transform(Cell::from);
    }

    private Generation(Matrix<Cell> cells) {
        this.cells = cells;
    }

    Generation evolve() {

        Matrix<Cell> newCells = cells.clone();

        for (Element<Cell> element : cells) {
            newCells = newCells.update(evolve(element));
        }

        return new Generation(newCells);
    }

    private Element<Cell> evolve(Element<Cell> element) {
        Coordinate coordinate = element.coordinate;

        long neighbours = cells.neighbours(coordinate)
                .stream()
                .filter(c -> c == ALIVE)
                .count();

        Cell newCell = element.value.evolve(neighbours);
        return new Element<>(coordinate, newCell);
    }

    String print() {
        return cells.print();
    }
}
