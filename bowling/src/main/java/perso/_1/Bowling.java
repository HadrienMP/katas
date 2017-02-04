package perso._1;

import java.util.List;

class Bowling {
    final int score;

    Bowling(List<Integer> rolls) {
        Frame frame = Frame.from(rolls);
        int rest = getRest(rolls, frame);
        this.score = frame.getScore(rolls) + rest;
    }

    private static int getRest(List<Integer> rolls, Frame frame) {
        if (isLastFrame(rolls)) {
            return 0;
        } else {
            return new Bowling(frame.getRestRolls(rolls)).score;
        }
    }

    private static boolean isLastFrame(List<Integer> rolls) {
        return rolls.size() <= 3;
    }
}
