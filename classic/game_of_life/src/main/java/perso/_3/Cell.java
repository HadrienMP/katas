package perso._3;

import java.util.stream.Stream;

enum Cell {
    DEAD("-"),
    ALIVE("*");

    private final String state;

    Cell(String state) {
        this.state = state;
    }

    Cell evolve(long numberOfNeighbours) {
        if (numberOfNeighbours == 3) {
            return ALIVE;
        } else if (numberOfNeighbours < 2 || numberOfNeighbours > 3) {
            return DEAD;
        } else {
            return this;
        }
    }

    public static Cell from(String state) {
        return Stream.of(values())
                .filter(cell -> cell.state.equals(state))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(state + " is not a legal cell value"));
    }

    @Override
    public String toString() {
        return state;
    }
}
