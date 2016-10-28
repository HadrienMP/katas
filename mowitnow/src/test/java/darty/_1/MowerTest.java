package darty._1;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerTest {
    @Test
    public void at_0_0_N_no_move() {
        Mower mower = new Mower(0, 0, Mower.Orientation.NORTH);
        assertThat(mower.toString()).isEqualTo("0 0 N");
    }
    @Test
    public void at_0_0_N_move_up() {
        Mower mower = new Mower(0, 0, Mower.Orientation.NORTH);

        mower.forward();

        assertThat(mower.toString()).isEqualTo("0 1 N");
    }


    @Test
    public void at_0_0_E_move_right() {
        Mower mower = new Mower(0, 0, Mower.Orientation.EAST);

        mower.forward();

        assertThat(mower.toString()).isEqualTo("1 0 E");
    }


    @Test
    public void at_1_1_W_move_left() {
        Mower mower = new Mower(1, 1, Mower.Orientation.WEST);

        mower.forward();

        assertThat(mower.toString()).isEqualTo("0 1 W");
    }

    @Test
    public void at_1_1_S_move_down() {
        Mower mower = new Mower(1, 1, Mower.Orientation.SOUTH);

        mower.forward();

        assertThat(mower.toString()).isEqualTo("1 0 S");
    }

    @Test(expected = NullPointerException.class)
    public void should_not_create_mower_without_orientation() {
        Mower mower = new Mower(1, 1, null);
    }

    @Test
    public void at_1_1_S_turn_left() {
        Mower mower = new Mower(1, 1, Mower.Orientation.SOUTH);

        mower.turnLeft();

        assertThat(mower.toString()).isEqualTo("1 1 E");
    }

    @Test
    public void at_1_1_E_turn_left() {
        Mower mower = new Mower(1, 1, Mower.Orientation.EAST);

        mower.turnLeft();

        assertThat(mower.toString()).isEqualTo("1 1 N");
    }

    @Test
    public void at_1_1_N_turn_left() {
        Mower mower = new Mower(1, 1, Mower.Orientation.NORTH);

        mower.turnLeft();

        assertThat(mower.toString()).isEqualTo("1 1 W");
    }

    @Test
    public void at_1_1_W_turn_left() {
        Mower mower = new Mower(1, 1, Mower.Orientation.WEST);

        mower.turnLeft();

        assertThat(mower.toString()).isEqualTo("1 1 S");
    }


    @Test
    public void at_1_1_S_turn_right() {
        Mower mower = new Mower(1, 1, Mower.Orientation.SOUTH);

        mower.turnRight();

        assertThat(mower.toString()).isEqualTo("1 1 W");
    }

    @Test
    public void at_1_1_E_turn_right() {
        Mower mower = new Mower(1, 1, Mower.Orientation.EAST);

        mower.turnRight();

        assertThat(mower.toString()).isEqualTo("1 1 S");
    }

    @Test
    public void at_1_1_N_turn_right() {
        Mower mower = new Mower(1, 1, Mower.Orientation.NORTH);

        mower.turnRight();

        assertThat(mower.toString()).isEqualTo("1 1 E");
    }

    @Test
    public void at_1_1_W_turn_right() {
        Mower mower = new Mower(1, 1, Mower.Orientation.WEST);

        mower.turnRight();

        assertThat(mower.toString()).isEqualTo("1 1 N");
    }
}