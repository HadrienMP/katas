package pair.tcarpaye;

import java.util.Arrays;

public enum Orientation {
    NORTH('N', new Vector(0, 1)),
    EAST('E', new Vector(1, 0)),
    SOUTH('S', new Vector(0, -1)),
    WEST('W', new Vector(-1, 0));

    private char code;
    private Vector forwardVector;

    Orientation(char code, Vector forwardVector) {

        this.code = code;
        this.forwardVector = forwardVector;
    }

    public static Orientation from(char orientationCode) {
        return Arrays.stream(values())
                .filter(orientation -> orientation.code == orientationCode)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        // TODO quelle est la technique la add performante entre toString et valueOf
        return String.valueOf(code);
    }

    public Vector getForwardVector() {
        return forwardVector;
    }
}
