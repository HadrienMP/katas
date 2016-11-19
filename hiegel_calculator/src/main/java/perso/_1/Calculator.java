package perso._1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Calculator {
    int compute(String operations) {
        List<Integer> toAdd = getNumbersToAdd(operations);

        if (toAdd.size() == 1) {
            return toAdd.get(0);
        }

        if (areAddable(toAdd)) {
            return toAdd.get(0) +  toAdd.get(1);
        }

        throw new IntegerOverflowException();

    }

    private List<Integer> getNumbersToAdd(String operations) {
        return Arrays.stream(operations.split("\\+"))
                .filter(this::isANumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean isANumber(String s) {
        return s.matches("-?\\d+");
    }


    private boolean areAddable(List<Integer> values) {
        if (areAllPositive(values)) {
            return Integer.MAX_VALUE - values.get(0) > values.get(1);
        } else if (areAllNegative(values)) {
            return Integer.MIN_VALUE - values.get(0) < values.get(1);
        } else {
            return true;
        }
    }

    private boolean areAllPositive(List<Integer> values) {
        return values.get(0) > 0 && values.get(1) > 0;
    }

    private boolean areAllNegative(List<Integer> values) {
        return values.get(0) < 0 && values.get(1) < 0;
    }
}
