package perso2;

/**
 * Created by HadrienMP on 06/06/2016.
 */
public class FizzBuzz {

    public static String toString(int number) {

        String result = "";

        if (isDivisibleBy(number, 3)) {
            result += "Fizz";
        }
        if (isDivisibleBy(number, 5)) {
            result += "Buzz";
        }
        if ("".equals(result)) {
            result += String.valueOf(number);
        }
        return result;
    }

    private static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0 && number != 0;
    }
}
