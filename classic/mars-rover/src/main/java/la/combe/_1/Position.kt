package la.combe._1

data class Position(val orientation: Orientation, val coordinates: Coordinates) {
    fun apply(move: Move): Position {
        return Position(orientation = orientation, coordinates = updateCoordinates(move))
    }

    private fun updateCoordinates(move: Move): Coordinates {
        return when (move) {
            Move.FORWARD -> orientation.translate(coordinates)
        }
    }
}