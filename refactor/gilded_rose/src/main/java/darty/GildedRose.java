package darty;

/**
 * Created by HadrienMP on 02/06/2016.
 */
public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            Item.decreaseSellInDate(item);
            item.updateQuality();
        }
    }
}
