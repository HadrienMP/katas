package darty._1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Mower {
    enum Orientation {
        NORTH("N"),
        SOUTH("S"),
        EAST("E"),
        WEST("W");

        private String code;

        private static  final List<Orientation> orientations = Arrays.asList(NORTH, EAST, SOUTH, WEST);


        Orientation(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }


    }

    private int x;
    private int y;
    private Orientation orientation;

    public Mower(int x, int y, Orientation orientation) {
        Objects.requireNonNull(orientation);
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void forward() {
        switch (orientation) {
            case WEST:
                x--;
                break;
            case EAST:
                x++;
                break;
            case SOUTH:
                y--;
                break;
            case NORTH:
            default:
                y++;
                break;
        }
    }

    public void turnLeft() {
        switch (orientation) {
            case SOUTH:
                orientation = Orientation.EAST;
                break;
            case EAST:
                orientation = Orientation.NORTH;
                break;
            case WEST:
                orientation = Orientation.SOUTH;
                break;
            case NORTH:
            default:
                orientation = Orientation.WEST;
                break;
        }
    }

    public void turnRight() {
        switch (orientation) {
            case SOUTH:
                orientation = Orientation.WEST;
                break;
            case EAST:
                orientation = Orientation.SOUTH;
                break;
            case WEST:
                orientation = Orientation.NORTH;
                break;
            case NORTH:
            default:
                orientation = Orientation.EAST;
                break;
        }
    }


    @Override
    public String toString() {
        return "" + x + " " + y + " " + orientation.toString();
    }
}
