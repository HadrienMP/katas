package perso.woodyzuill.aging;

import org.jetbrains.annotations.NotNull;
import perso.woodyzuill.GildedRose;
import perso.woodyzuill.Item;

public class Brie implements AgingStrategy {
    @NotNull
    public static Item brie(Item item) {
        Item updated = GildedRose.clone(item);
        if (updated.quality < 50) {
            updated.quality = updated.quality + 1;
        }

        updated.sellIn = updated.sellIn - 1;

        if (updated.sellIn < 0) {
            if (updated.quality < 50) {
                updated.quality = updated.quality + 1;
            }
        }
        return updated;
    }

    @Override
    public Item age(Item item) {
        return brie(item);
    }
}
