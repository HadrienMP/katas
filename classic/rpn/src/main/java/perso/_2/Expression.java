package perso._2;

import static java.lang.Integer.parseInt;

@FunctionalInterface
public interface Expression {
    String solve();

    static Expression number(String number) {
        return () -> number;
    }

    static Expression addition(Expression first, Expression second) {
        return () -> String.valueOf(parseInt(first.solve()) + parseInt(second.solve()));
    }

    static Expression substraction(Expression first, Expression second) {
        return () -> String.valueOf(parseInt(first.solve()) - parseInt(second.solve()));
    }
}
