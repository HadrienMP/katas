package perso._1;

import java.util.List;

public enum FrameType {

    STRIKE(3, 1),
    SPARE(3, 2),
    DEFAULT(2, 2);

    final int numberOfRollsInFrame;
    final int nextFrameIndex;

    FrameType(int numberOfRollsInFrame, int nextFrameIndex) {
        this.numberOfRollsInFrame = numberOfRollsInFrame;
        this.nextFrameIndex = nextFrameIndex;
    }

    public static FrameType from(List<Integer> rolls) {
        if (isStrike(rolls)) {
            return STRIKE;
        }
        if (isSpare(rolls)) {
            return SPARE;
        }
        return DEFAULT;
    }

    private static boolean isStrike(List<Integer> rolls) {
        return rolls.get(0) == 10;
    }

    private static boolean isSpare(List<Integer> rolls) {
        return rolls.get(0) + rolls.get(1) == 10;
    }
}
