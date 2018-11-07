package la.combe._1

enum class Translation(val x: Int, val y: Int) {
    NORTH(0, 1),
    WEST(-1, 0),
    EAST(1, 0),
    SOUTH(0, -1)
}