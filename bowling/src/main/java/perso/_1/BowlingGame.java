package perso._1;

import java.util.Collections;
import java.util.List;

class BowlingGame {
    private static final int MAX_NUMBER_OF_ROLLS_PER_FRAME = 3;

    final int score;

    BowlingGame(List<Integer> rolls) {
        this.score = getScore(rolls);
    }

    private static int getScore(List<Integer> rolls) {
        if (rolls.isEmpty()) {
            return 0;
        }
        FrameType frameType = FrameType.from(rolls);
        int frameScore = getFrameScore(rolls, frameType);
        int remainingRollsScore = getScore(getRemainingRolls(rolls, frameType));
        return frameScore + remainingRollsScore;
    }

    private static int getFrameScore(List<Integer> rolls, FrameType frameType) {
        int frameScore = 0;
        for (int i = 0; i < frameType.numberOfRollsInFrame; i++) {
            frameScore += rolls.get(i);
        }
        return frameScore;
    }

    private static List<Integer> getRemainingRolls(List<Integer> rolls, FrameType frameType) {
        if (isLastFrame(rolls)) {
            return Collections.emptyList();
        } else {
            return rolls.subList(frameType.nextFrameIndex, rolls.size());
        }
    }

    private static boolean isLastFrame(List<Integer> rolls) {
        return rolls.size() <= MAX_NUMBER_OF_ROLLS_PER_FRAME;
    }
}
