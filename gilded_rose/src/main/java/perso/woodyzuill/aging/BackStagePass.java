package perso.woodyzuill.aging;

import perso.woodyzuill.Item;
import perso.woodyzuill.Quality;

public class BackStagePass implements AgingStrategy {

    @Override
    public Item age(Item item) {
        Quality quality = updateQuality(item);

        int sellIn = item.sellIn - 1;

        if (sellIn < 0) {
            quality = Quality.ZERO;
        }

        return new Item(item.name, sellIn, quality.quality);
    }

    public Quality updateQuality(Item item) {
        Quality quality = new Quality(item.quality).increment();

        if (item.sellIn <= 10) {
            quality = quality.increment();
        }

        if (item.sellIn <= 5) {
            quality = quality.increment();
        }
        return quality;
    }

}
