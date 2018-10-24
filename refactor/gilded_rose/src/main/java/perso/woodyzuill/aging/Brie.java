package perso.woodyzuill.aging;

import perso.woodyzuill.Item;
import perso.woodyzuill.Quality;

public class Brie implements AgingStrategy {

    @Override
    public Item age(Item item) {
        Quality quality = new Quality(item.quality).increment();

        int sellIn = item.sellIn - 1;

        if (sellIn < 0) {
            quality = quality.increment();
        }
        return new Item(item.name, sellIn, quality.quality);
    }
}
