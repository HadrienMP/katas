package perso._1;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

class Calculator {

    public static final String NUMBER_REGEX = "-?\\d+";
    public static final String OPERATIONS_REGEX = "[*+-]";

    int compute(String operations) {

        if (areLegal(operations)) {
            throw new IllegalArgumentException();
        }

        String addOperations = replaceSubstractionsByAdditions(operations);

        Stream<Integer> integerStream = Arrays.stream(addOperations.split("[*+]"))
                .filter(this::isANumber)
                .map(Integer::parseInt);

        if (operations.contains("*")) {
            return integerStream.reduce(1, this::multiply);
        }

        return integerStream.reduce(0, this::add);
    }

    private boolean areLegal(String operations) {
        return operations == null || !operations.matches("(" + NUMBER_REGEX + OPERATIONS_REGEX + ")*" + NUMBER_REGEX);
    }

    private String replaceSubstractionsByAdditions(String operations) {
        return operations.replace("-", "+-");
    }

    private boolean isANumber(String s) {
        return s.matches(NUMBER_REGEX);
    }

    private int multiply(Integer integer, Integer integer2) {
        // TODO tester multiplication par 0 qui ne doit pas planter ici
        if (areMultipliable(integer, integer2)) {
            return integer * integer2;
        }

        throw new IntegerOverflowException();
    }

    private boolean areMultipliable(Integer integer, Integer integer2) {
        // TODO tester avec les valeurs extremes dans les multiplications
        if (areOfSameSign(integer, integer2)) {
            return MAX_VALUE / Math.abs(integer) >= Math.abs(integer2);
        } else {
            return MIN_VALUE / Math.abs(integer) <= -Math.abs(integer2) || (integer == MIN_VALUE && integer2 == 1);
        }
    }

    private boolean areOfSameSign(Integer integer, Integer integer2) {
        return integer < 0 && integer2 < 0 || integer > 0 && integer2 > 0;
    }

    private int add(Integer first, Integer second) {
        if (areAddable(first, second)) {
            return first + second;
        }

        throw new IntegerOverflowException();
    }

    private boolean areAddable(Integer first, Integer second) {
        if (first > 0 && second > 0) {
            return MAX_VALUE - first > second;
        } else if (first < 0 && second < 0) {
            return MIN_VALUE - first < second;
        } else {
            return true;
        }
    }

}
