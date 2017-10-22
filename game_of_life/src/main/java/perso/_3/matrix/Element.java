package perso._3.matrix;

public class Element<T> {
    public final Coordinate coordinate;
    public final T value;

    public Element(Coordinate coordinate, T value) {
        this.coordinate = coordinate;
        this.value = value;
    }
}
