package perso.woodyzuill.aging;

import perso.woodyzuill.Item;
import perso.woodyzuill.Quality;

public class Default implements AgingStrategy {

    @Override
    public Item age(Item item) {
        Quality quality = new Quality(item.quality).decrement();

        int sellIn = item.sellIn - 1;

        if (sellIn < 0) {
            quality = quality.decrement();
        }
        return new Item(item.name, sellIn, quality.quality);
    }
}
