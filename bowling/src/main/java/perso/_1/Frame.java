package perso._1;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public enum Frame {
    STRIKE(3, 1),
    SPARE(3, 2),
    DEFAULT(2, 2);

    private final int numberOfRollsInFrame;
    final int nextFrameIndex;

    Frame(int numberOfRollsInFrame, int nextFrameIndex) {
        this.numberOfRollsInFrame = numberOfRollsInFrame;
        this.nextFrameIndex = nextFrameIndex;
    }

    public static Frame from(List<Integer> rolls) {
        if (isStrike(rolls)) {
            return STRIKE;
        } else if (isSpare(rolls)) {
            return SPARE;
        } else {
            return DEFAULT;
        }
    }

    private static boolean isStrike(List<Integer> rolls) {
        return rolls.get(0) == 10;
    }

    private static boolean isSpare(List<Integer> rolls) {
        return rolls.get(0) + rolls.get(1) == 10;
    }

    public int getScore(List<Integer> rolls) {
        int frameScore = 0;
        for (int i = 0; i < numberOfRollsInFrame; i++) {
            frameScore += rolls.get(i);
        }
        return frameScore;
    }

    @NotNull
    public List<Integer> getRestRolls(List<Integer> rolls) {
        return rolls.subList(this.nextFrameIndex, rolls.size());
    }
}
