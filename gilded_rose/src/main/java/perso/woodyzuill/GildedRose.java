package perso.woodyzuill;

import org.jetbrains.annotations.NotNull;
import perso.woodyzuill.aging.AgingStrategy;

import static java.util.Arrays.stream;

public class GildedRose {
    private Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        items = stream(items)
                .map(this::age)
                .toArray(Item[]::new);
    }

    private Item age(Item item) {
        Item agedItem = AgingStrategy.of(item.name).age(item);
        update(item, agedItem);
        return item;
    }

    private static void update(Item item, Item updated) {
        item.quality = updated.quality;
        item.sellIn = updated.sellIn;
    }

    @NotNull
    public static Item clone(Item item) {
        return new Item(item.name, item.sellIn, item.quality);
    }
}
