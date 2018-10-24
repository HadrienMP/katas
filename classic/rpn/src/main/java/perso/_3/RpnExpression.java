package perso._3;

import java.util.Stack;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class RpnExpression implements StringExpression {

    private Stack<NumberExpression> expressions = new Stack<>();

    RpnExpression(String stringExpression) {
        String[] parts = stringExpression.split(" ");

        for (String part : parts) {
            NumberExpression expression = OperationDefinition.from(part)
                    .map(this::toExpression)
                    .orElseGet(() -> new Number(part));

            expressions.push(expression);
        }
    }

    private NumberExpression toExpression(OperationDefinition od) {
        NumberExpression second = expressions.pop();
        NumberExpression first = expressions.pop();
        return od.toOperation(first, second);
    }

    @Override
    public String process() {
        return expressions.stream()
                .map(NumberExpression::process)
                .map(String::valueOf)
                .collect(joining(" "));
    }

}
