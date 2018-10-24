package perso._2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Cell {
    public static final Cell ALIVE = new Cell("*");

    public final String value;

    @Override
    public String toString() {
        return value;
    }

    public boolean isAlive() {
        return this == ALIVE;
    }
}
