package la.combe._1

class MarsRover(private val position: Position) {
    fun getPosition() = position
    fun execute(move: Move): MarsRover {
        return MarsRover(position.apply(move))
    }
}