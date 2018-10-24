package perso.woodyzuill;

import org.approvaltests.legacycode.Range;
import org.junit.Test;

import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

public class GildedRoseGoldenMasterTest {
    private static String call(String itemName, Integer quality, Integer sellIn) {
        Item item = new Item(itemName, sellIn, quality);
        GildedRose gildedRose = new GildedRose(new Item[]{item});
        gildedRose.updateQuality();
        return item.toString();
    }

    @Test
    public void golden_master() throws Exception {
        String[] itemNames = {
                "Potatoe",
                "Aged Brie",
                "Backstage passes to a TAFKAL80ETC concert",
                "Sulfuras, Hand of Ragnaros"
        };
        Integer[] qualities = Range.get(-1, 51);
        Integer[] sellIns = Range.get(-1, 15);
        verifyAllCombinations(
                GildedRoseGoldenMasterTest::call,
                itemNames,
                qualities,
                sellIns
                );
    }
}
