package perso._1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Rolls {

    private List<Integer> rolls;

    private Rolls(List<Integer> rolls) {
        this.rolls = rolls;
    }

    static Rolls roll(Integer... knockedPins) {
        return new Rolls(new ArrayList<>(Arrays.asList(knockedPins)));
    }

    Rolls andThen(Rolls rolls) {
        this.rolls.addAll(rolls.get());
        return this;
    }

    List<Integer> get() {
        return rolls;
    }

    Rolls times(int n) {
        return new Rolls(new ArrayList<>(Collections.nCopies(n, rolls.get(0))));
    }
}
