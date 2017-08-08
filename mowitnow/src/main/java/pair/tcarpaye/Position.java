package pair.tcarpaye;

public class Position {
    private Coordinates coordinates;

    public Position(int x, int y) {
        coordinates = new Coordinates(x, y);
    }

    private Position(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Position translate(Vector forwardVector) {
        return new Position(coordinates.add(forwardVector.getCoordinates()));
    }

    @Override
    public String toString() {
        return coordinates.toString();
    }
}
