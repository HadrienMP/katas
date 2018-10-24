package perso.kotlin

import io.kotlintest.specs.FlatSpec

class FizzBuzzTests : FlatSpec() {
    init {
        "transform" should "return 1 for 1" {
            transform(1) shouldBe "1"
        }
        "transform" should "return 2 for 2" {
            transform(2) shouldBe "2"
        }
        "transform" should "return Fizz for 3" {
            transform(3) shouldBe "Fizz"
        }
        "transform" should "return Buzz for 5" {
            transform(5) shouldBe "Buzz"
        }
        "transform" should "return FizzBuzz for 15" {
            transform(15) shouldBe "FizzBuzz"
        }
    }
}

