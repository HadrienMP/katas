package perso._2;

import perso._2.matrix.*;

import java.util.HashMap;
import java.util.Map;

class Generation2 {

    private final NeighbourAwareMatrix<Cell> cells;

    Generation2(String cells) {
        this(new MapMatrix<>(cells, Cell::new));
    }

    public Generation2(Map<Coordinate, Cell> cells) {
        this(new MapMatrix<>(cells));
    }

    public Generation2(Matrix<Cell> cells) {
        this(new NeighbourAwareMatrix<>(cells));
    }

    private Generation2(NeighbourAwareMatrix<Cell> cells) {
        this.cells = cells;
    }

    Generation2 next() {
        HashMap<Coordinate, Cell> newCells = new HashMap<>();

        for (Coordinate coordinate: cells.coordinates()) {
            if (cells.neighbours(coordinate).stream().filter(Cell::isAlive).count() == 3) {
                newCells.put(coordinate, Cell.ALIVE);
            } else {
                // FIXME: 16/10/17
                newCells.put(coordinate, cells.get(coordinate)
                        .orElseThrow(() -> new RuntimeException("Woops")));
            }
        }

        return new Generation2(newCells);
    }

    @Override
    public String toString() {
        // FIXME: 16/10/17
        return new PrintableMatrix<>(cells).print();
    }
}
