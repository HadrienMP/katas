package perso._3;

class Element<T> {
    final Coordinate coordinate;
    final T value;

    Element(Coordinate coordinate, T value) {
        this.coordinate = coordinate;
        this.value = value;
    }
}
