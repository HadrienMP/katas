package perso.woodyzuill.aging;

import perso.woodyzuill.GildedRose;
import perso.woodyzuill.Item;

public class Default implements AgingStrategy {

    @Override
    public Item age(Item item) {
        Item updated = GildedRose.clone(item);

        if (updated.quality > 0) {
            updated.quality = updated.quality - 1;
        }

        updated.sellIn = updated.sellIn - 1;

        if (updated.sellIn < 0) {
            if (updated.quality > 0) {
                updated.quality = updated.quality - 1;
            }
        }
        return updated;
    }
}
