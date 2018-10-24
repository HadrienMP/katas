package darty;

public class Item {

    public static final String CONJURED = "Conjured Mana Cake";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int QUALITY_MAX = 50;
    public static final int QUALITY_SULFURAS = 80;

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    void updateQuality() {
        naiveUpdateQuality(this);
        enforceBoundaries(this);
    }

    private static void naiveUpdateQuality(Item item) {

        switch (item.name) {
            case SULFURAS:
                item.quality = QUALITY_SULFURAS;
                break;
            case BACKSTAGE_PASS:

                if (item.sellIn < 5) item.quality += 3;
                else if (item.sellIn < 10) item.quality += 2;
                else item.quality += 1;

                if (isPerime(item)) item.quality = 0;

                break;
            case AGED_BRIE:
                item.quality += 1;

                if (isPerime(item)) item.quality += 1;
                break;
            case CONJURED:
                item.quality -= 2;

                if (isPerime(item)) item.quality -= 2;
                break;
            default:
                // produits standards (ne se bonifient)
                item.quality -= 1;

                if (isPerime(item)) item.quality -= 1;
        }
    }

    private static boolean isPerime(Item item) {
        return item.sellIn < 0;
    }

    private static void enforceBoundaries(Item item) {
        if (item.quality < 0) item.quality = 0;
        if (item.quality > QUALITY_MAX && !SULFURAS.equals(item.name)) item.quality = QUALITY_MAX;
    }

    public static void decreaseSellInDate(Item item) {
        if (!SULFURAS.equals(item.name)) item.sellIn -= 1;
    }
}