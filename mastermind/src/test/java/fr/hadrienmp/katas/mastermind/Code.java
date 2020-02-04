package fr.hadrienmp.katas.mastermind;

import static java.util.stream.IntStream.range;

public class Code {
    private final String value;

    public Code(String value) {
        this.value = value;
    }

    long countExactMatches(Code candidate) {
        return range(0, candidate.numberOfColors())
                .filter(colorIndex -> candidate.colorAt(colorIndex) == colorAt(colorIndex))
                .count();
    }

    private int numberOfColors() {
        return value.length();
    }

    private char colorAt(int colorIndex) {
        return value.charAt(colorIndex);
    }

}
