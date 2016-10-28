package pair.tcarpaye;

public class Vector {
    private Coordinates coordinates;

    public Vector(int x, int y) {
        coordinates = new Coordinates(x, y);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}
