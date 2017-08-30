package perso._3;

import lombok.ToString;

@ToString
public class Number implements NumberExpression {

    private final int value;

    public Number(String string) {
        value = Integer.parseInt(string);
    }

    @Override
    public int process() {
        return value;
    }
}
