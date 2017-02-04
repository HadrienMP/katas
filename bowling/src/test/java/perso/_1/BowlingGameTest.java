package perso._1;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static perso._1.Rolls.*;

public class BowlingGameTest {

    @Test
    public void worst_game_ever() {
        List<Integer> rolls = roll(0).times(20).get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo(0);
    }

    @Test
    public void one_roll() {
        List<Integer> rolls = roll(1).andThen(roll(0).times(19)).get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo(1);
    }

    @Test
    public void two_rolls() {
        List<Integer> rolls = roll(1, 5)
                .andThen(roll(0).times(18))
                .get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo(6);
    }

    @Test
    public void three_rolls() {
        List<Integer> rolls = roll(1, 5, 9)
                .andThen(roll(0).times(17))
                .get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo(1 + 5 + 9);
    }

    @Test
    public void spare() {
        List<Integer> rolls = roll(1, 9)
                .andThen(roll(5, 0))
                .andThen(roll(0).times(16))
                .get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo(1 + 9 + 5*2);
    }

    @Test
    public void strike() {
        List<Integer> rolls = roll(10, 5)
                .andThen(roll(2, 0))
                .andThen(roll(0).times(15))
                .get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo(10 + 5*2 + 2*2);
    }

    @Test
    public void full_game_no_special_frame() {
        List<Integer> rolls = roll(6).times(20).get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo(6*20);
    }

    @Test
    public void two_spares() {
        List<Integer> rolls = roll(1, 9)
                .andThen(roll(9, 1, 2))
                .andThen(roll(0).times(15))
                .get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo((1 + 9 + 9) + (9 + 1 + 2) + 2);
    }

    @Test
    public void three_strikes() {
        List<Integer> rolls = roll(10, 10, 10)
                .andThen(roll(0).times(17))
                .get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo((10 * 3) + (10 * 2) + 10);
    }

    @Test
    public void spare_in_last_frame() {
        List<Integer> rolls = roll(0).times(18)
                .andThen(roll(1, 9, 5))
                .get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo(1 + 9 + 5);
    }

    @Test
    public void strike_in_last_frame() {
        List<Integer> rolls = roll(0).times(18)
                .andThen(roll(10, 1, 2))
                .get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo(10 + 1 + 2);
    }

    @Test
    public void perfect_game() {
        List<Integer> rolls = roll(10).times(12).get();

        BowlingGame bowlingGame = new BowlingGame(rolls);

        assertThat(bowlingGame.score).isEqualTo(300);
    }
}
