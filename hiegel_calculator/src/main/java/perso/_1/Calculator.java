package perso._1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Calculator {

    int compute(String operations) {
        if (operations == null) {
            throw new IllegalArgumentException();
        }

        String addOperations = replaceSubstractionsByAdditions(operations);
        List<Integer> toAdd = getNumbersToAdd(addOperations);

        if (toAdd.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return toAdd.stream().reduce(0, this::add);
    }

    private List<Integer> getNumbersToAdd(String addOperations) {
        return Arrays.stream(addOperations.split("\\+"))
                .filter(this::isANumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String replaceSubstractionsByAdditions(String operations) {
        return operations.replace("-", "+-");
    }

    private boolean isANumber(String s) {
        return s.matches("-?\\d+");
    }

    private int add(Integer first, Integer second) {
        if (areAddable(first, second)) {
            return first + second;
        }

        throw new IntegerOverflowException();
    }


    private boolean areAddable(Integer first, Integer second) {
        if (first > 0 && second > 0) {
            return Integer.MAX_VALUE - first > second;
        } else if (first < 0 && second < 0) {
            return Integer.MIN_VALUE - first < second;
        } else {
            return true;
        }
    }

}
