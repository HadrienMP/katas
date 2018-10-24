package perso.woodyzuill;

import java.util.stream.Stream;

public enum ItemName {
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    OTHER("");

    final String name;

    ItemName(String name) {
        this.name = name;
    }

    public static ItemName from(String name) {
        return Stream.of(values())
                     .filter(itemName -> itemName.name.equals(name))
                     .findFirst()
                     .orElse(OTHER);
    }
}
