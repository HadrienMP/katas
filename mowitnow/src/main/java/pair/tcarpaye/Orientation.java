package pair.tcarpaye;

import java.util.Arrays;

public enum Orientation {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private char code;

    Orientation(char code) {

        this.code = code;
    }

    public static Orientation from(char orientationCode) {
        return Arrays.stream(values())
                .filter(orientation -> orientation.code == orientationCode)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        // TODO quelle est la technique la plus performante entre toString et valueOf
        return String.valueOf(code);
    }
}
