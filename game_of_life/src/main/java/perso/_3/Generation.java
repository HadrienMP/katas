package perso._3;

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

        return new Element<>(coordinate, element.value.evolve(neighbours));
    }

    String print() {
        return cells.print();
    }
}
