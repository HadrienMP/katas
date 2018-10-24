package perso._2.matrix;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Coordinate {
    public final int x;
    public final int y;

    Coordinate translate(Coordinate translation) {
        return translation;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }
}
