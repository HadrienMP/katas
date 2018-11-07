package la.combe._1

enum class Orientation(val translation: Translation) {
    NORTH(Translation.NORTH),
    EAST(Translation.EAST),
    SOUTH(Translation.SOUTH),
    WEST(Translation.WEST);

    fun translate(coordinates: Coordinates) = coordinates.apply(translation)
}