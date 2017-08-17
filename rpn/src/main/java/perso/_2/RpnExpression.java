package perso._2;

import java.util.Stack;

import static java.util.stream.Collectors.joining;
import static perso._2.Expression.*;

public class RpnExpression implements Expression {
    private static final String SEPARATOR = " ";
    private Stack<Expression> expressions = new Stack<>();

    RpnExpression(String operations) {
        String[] parts = operations.split(SEPARATOR);
        for (String part: parts) {
            expressions.push(from(part));
        }
    }

    private Expression from(String part) {
        switch (part) {
            case "+":
                Expression second = expressions.pop();
                Expression first = expressions.pop();
                return addition(first, second);
            case "-":
                second = expressions.pop();
                first = expressions.pop();
                return substraction(first, second);
            default:
                return number(part);
        }
    }

    public String solve() {
        return expressions.stream()
                .map(Expression::solve)
                .collect(joining(SEPARATOR));
    }
}
