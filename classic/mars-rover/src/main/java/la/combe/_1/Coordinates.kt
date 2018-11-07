package la.combe._1

data class Coordinates(val x: Int, val y: Int) {
    fun apply(translation: Translation) = Coordinates(x + translation.x, y + translation.y)
}