package perso._1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Calculator {
    int compute(String operations) {
        List<Integer> toAdd = getNumbersToAdd(operations);

        if (areAddable(toAdd)) {
            return toAdd.get(0) +  toAdd.get(1);
        }

        throw new TooBigForTheCalculatorException();

    }

    private List<Integer> getNumbersToAdd(String operations) {
        return Arrays.stream(operations.split("\\+"))
                .filter(s -> s.matches("-?\\d+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean areAddable(List<Integer> values) {
        return Integer.MAX_VALUE - values.get(0) >= values.get(1);
    }
}
