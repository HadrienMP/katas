package pair.tcarpaye;

public class Mower {
    private final Orientation orientation;
    private Position position;

    public Mower(int x, int y, char orientationCode) {
        this.position = new Position(x, y);

        // TODO vérifier qu'une orientation pourrie renvoie une exception
        this.orientation = Orientation.from(orientationCode);
    }

    public void program(String command) {
        // TODO peut-être renommer en position.move(orientation)
        position = position.translate(orientation.getForwardVector());
    }

    @Override
    public String toString() {
        return position + " " + orientation;
    }


}
