package perso._3;

import lombok.ToString;

import java.util.function.BiFunction;

@ToString
public class Operation implements NumberExpression {

    private NumberExpression first;
    private NumberExpression second;
    private BiFunction<Integer, Integer, Integer> operation;

    public Operation(BiFunction<Integer, Integer, Integer> operation, NumberExpression first, NumberExpression second) {
        this.first = first;
        this.second = second;
        this.operation = operation;
    }

    @Override
    public int process() {
        return operation.apply(first.process(), second.process());
    }
}
