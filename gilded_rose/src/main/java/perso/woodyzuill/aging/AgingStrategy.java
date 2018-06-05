package perso.woodyzuill.aging;

import org.jetbrains.annotations.NotNull;
import perso.woodyzuill.Item;

@FunctionalInterface
public interface AgingStrategy {

    @NotNull
    static AgingStrategy of(String itemName) {
        // TODO use some kind of open close mechanism
        if ("Sulfuras, Hand of Ragnaros".equals(itemName)) {
            return new Sulfuras();
        } else if ("Aged Brie".equals(itemName)) {
            return new Brie();
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(itemName)) {
            return new BackStagePass();
        } else {
            return new Default();
        }
    }

    Item age(Item item);
}
