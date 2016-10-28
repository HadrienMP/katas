package pair.tcarpaye;

public class Mower {
    private int x;
    private int y;
    private final Orientation orientation;

    public Mower(int x, int y, char orientationCode) {
        this.x = x;
        this.y = y;

        // TODO vérifier qu'une orientation pourrie renvoie une exception
        this.orientation = Orientation.from(orientationCode);
    }

    public void program(String command) {
        if (isFacingEast()) {
            moveEast();
        } else if (isFacingSouth()) {
            moveSouth();
        } else if (isFacingWest()) {
            moveWest();
        } else {
            moveNorth();
        }
    }

    private boolean isFacingEast() {
        return orientation == Orientation.EAST;
    }

    private boolean isFacingSouth() {
        return orientation == Orientation.SOUTH;
    }

    private void moveSouth() {
        y--;
    }

    private boolean isFacingWest() {
        return orientation == Orientation.WEST;
    }

    private void moveWest() {
        x--;
    }

    private void moveEast() {
        x++;
    }

    private void moveNorth() {
        y++;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }


}
