import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

import static java.lang.Integer.parseInt;

class Rpn {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<String, BiFunction<Integer, Integer, Integer>>() {{
        put("+", (Integer first, Integer second) -> first + second);
        put("-", (Integer first, Integer second) -> first - second);
        put("*", (Integer first, Integer second) -> first * second);
        put("/", (Integer first, Integer second) -> first / second);
    }};

    // TODO: 07/08/17 tester les operations illegales
    // TODO: 07/08/17 tester la division par 0

    String execute(String operations_string) {
        Stack<String> operations = new Stack<>();
        for (String part : operations_string.split(" ")) {
            operations.add(part);
            if (isOperation(part)) {
                operations = processLast(operations);
            }
        }
        return String.join(" ", operations);
    }

    private Stack<String> processLast(Stack<String> operations) {

        String operation = operations.pop();
        Integer second = parseInt(operations.pop());
        Integer first = parseInt(operations.pop());

        Integer result = OPERATIONS.get(operation).apply(first, second);
        operations.add(String.valueOf(result));

        return operations;
    }

    private boolean isOperation(String part) {
        return OPERATIONS.containsKey(part);
    }

}
