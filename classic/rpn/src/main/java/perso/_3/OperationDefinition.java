package perso._3;

import java.util.Optional;
import java.util.function.BiFunction;

import static java.util.Arrays.stream;

public enum OperationDefinition {
    ADD         ("+", (f, s) -> f + s),
    MULTIPLY    ("*", (f, s) -> f * s),
    DIVIDE      ("/", (f, s) -> f / s),
    SUBTRACT    ("-", (f, s) -> f - s);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> operation;

    OperationDefinition(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Optional<OperationDefinition> from(String symbol) {
        return stream(values())
                .filter(od -> od.symbol.equals(symbol))
                .findFirst();
    }

    public Operation toOperation(NumberExpression first, NumberExpression second) {
        return new Operation(operation, first, second);
    }
}
