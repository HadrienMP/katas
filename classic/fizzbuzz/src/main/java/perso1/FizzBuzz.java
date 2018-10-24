package perso1;

/**
 * Created by HadrienMP on 02/06/2016.
 */
public class FizzBuzz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final int FIZZ_NUMBER = 3;
    public static final int BUZZ_NUMBER = 5;

    public static String transform(int i) {
        if (i%(FIZZ_NUMBER * BUZZ_NUMBER)==0) {
            return FIZZ + BUZZ;
        }
        if (i%BUZZ_NUMBER==0) {
            return BUZZ;
        }
        if (i% FIZZ_NUMBER ==0) {
            return FIZZ;
        }
        return String.valueOf(i);
    }
}
