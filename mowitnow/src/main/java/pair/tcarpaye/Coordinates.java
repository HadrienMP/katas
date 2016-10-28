package pair.tcarpaye;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public Coordinates add(Coordinates coordinates) {
        return new Coordinates(x + coordinates.x, y + coordinates.y);
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
