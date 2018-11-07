package la.combe._1

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.assertj.core.api.Assertions.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class MarsRoverSpec {
    /*
     * 10 x 10
     * FFRLFFLLRR
     */

    @Test
    fun a_rover_that_does_not_move_should_stay_in_its_initial_position() {
        val initialPosition = Position(Orientation.NORTH, Coordinates(2, 2))
        val marsRover = MarsRover(initialPosition)

        val position = marsRover.getPosition()

        assertThat(position).isEqualTo(initialPosition)
    }

    @Test
    @Parameters(*arrayOf("2,2", "2,3", "2,5", "3,5"))
    fun forward_north(initialX: Int, initialY: Int) {
        val initialPosition = Position(Orientation.NORTH, Coordinates(initialX, initialY))
        val marsRover = MarsRover(initialPosition)

        val position = marsRover.execute(Move.FORWARD).getPosition()

        assertThat(position).isEqualTo(Position(Orientation.NORTH, Coordinates(initialX, initialY + 1)))
    }

    @Test
    @Parameters(*arrayOf("2,2"))
    fun forward_east(initialX: Int, initialY: Int) {
        val initialPosition = Position(Orientation.EAST, Coordinates(initialX, initialY))
        val marsRover = MarsRover(initialPosition)

        val position = marsRover.execute(Move.FORWARD).getPosition()

        assertThat(position).isEqualTo(Position(Orientation.EAST, Coordinates(initialX + 1, initialY)))
    }

    @Test
    @Parameters(*arrayOf("2,2"))
    fun forward_south(initialX: Int, initialY: Int) {
        val initialPosition = Position(Orientation.SOUTH, Coordinates(initialX, initialY))
        val marsRover = MarsRover(initialPosition)

        val position = marsRover.execute(Move.FORWARD).getPosition()

        assertThat(position).isEqualTo(Position(Orientation.SOUTH, Coordinates(initialX, initialY - 1)))
    }

    @Test
    @Parameters(*arrayOf("2,2", "3,2", "5,2"))
    fun forward_west(initialX: Int, initialY: Int) {
        val initialPosition = Position(Orientation.WEST, Coordinates(initialX, initialY))
        val marsRover = MarsRover(initialPosition)

        val position = marsRover.execute(Move.FORWARD).getPosition()

        assertThat(position).isEqualTo(Position(Orientation.WEST, Coordinates(initialX - 1, initialY)))
    }

}

