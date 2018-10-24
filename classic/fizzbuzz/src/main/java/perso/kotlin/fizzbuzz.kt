package perso.kotlin

fun transform(number : Int): String {
    when {
        number % 3 == 0 -> return "Fizz"
        number % 5 == 0 -> return "Buzz"
        number % 15 == 0 -> return "FizzBuzz"
        else -> return number.toString()
    }
}