package perso.woodyzuill.aging;

import perso.woodyzuill.GildedRose;
import perso.woodyzuill.Item;

public class BackStagePass implements AgingStrategy {

    @Override
    public Item age(Item item) {
        Item updated = GildedRose.clone(item);
        if (updated.quality < 50) {
            updated.quality = updated.quality + 1;

            if (updated.sellIn < 11) {
                if (updated.quality < 50) {
                    updated.quality = updated.quality + 1;
                }
            }

            if (updated.sellIn < 6) {
                if (updated.quality < 50) {
                    updated.quality = updated.quality + 1;
                }
            }
        }

        updated.sellIn = updated.sellIn - 1;

        if (updated.sellIn < 0) {
            updated.quality = 0;
        }
        return updated;
    }
}
