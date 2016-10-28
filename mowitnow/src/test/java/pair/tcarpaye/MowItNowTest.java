package pair.tcarpaye;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MowItNowTest {

    MowItNow mowItNow;

    @Test
    public void should_return_the_position_of_the_only_mower_when_facing_north() {

        Mower mower = new Mower(3, 1, 'N');
        mowItNow = init().addMower(mower).build();

        mowItNow.mow();

        assertThat(mowItNow.getMower(0).toString()).isEqualTo("3 1 N");
    }

    @Test
    public void should_return_the_position_of_the_only_mower_when_facing_south() {
        // Arrange
        Mower mower = new Mower(0, 0, 'S');
        mowItNow = init().addMower(mower).build();

        // Act
        mowItNow.mow();

        // Assert
        assertThat(mowItNow.getMower(0).toString()).isEqualTo("0 0 S");
    }

    @Test
    public void move_north_when_facing_north() {
        // Arrange
        Mower mower = new Mower(3, 1, 'N');
        mower.program("A");
        mowItNow = init().addMower(mower).build();

        // Act
        mowItNow.mow();

        // Assert
        assertThat(mowItNow.getMower(0).toString()).isEqualTo("3 2 N");
    }

    @Test
    public void move_east_when_facing_east() {
        // Arrange
        Mower mower = new Mower(1, 1, 'E');
        mowItNow = init().addMower(mower).build();
        mower.program("A");

        // Act
        mowItNow.mow();

        // Assert
        assertThat(mowItNow.getMower(0).toString()).isEqualTo("2 1 E");
    }

    @Test
    public void move_south_when_facing_south() {
        // Arrange
        Mower mower = new Mower(1, 1, 'S');
        mowItNow = init().addMower(mower).build();
        mower.program("A");

        // Act
        mowItNow.mow();

        // Assert
        assertThat(mowItNow.getMower(0).toString()).isEqualTo("1 0 S");
    }

    @Test
    public void move_west_when_facing_west() {
        // Arrange
        Mower mower = new Mower(1, 1, 'W');
        mowItNow = init().addMower(mower).build();
        mower.program("A");

        // Act
        mowItNow.mow();

        // Assert
        assertThat(mowItNow.getMower(0).toString()).isEqualTo("0 1 W");
    }

    private MowItNowBuilder init() {
        return new MowItNowBuilder().withFieldWidht(5).withFieldHeight(5);
    }

}
