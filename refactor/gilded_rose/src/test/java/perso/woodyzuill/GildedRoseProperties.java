package perso.woodyzuill;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assume.assumeThat;

//@RunWith(JUnitQuickcheck.class)
public class GildedRoseProperties {
//    @Property
    public void an_item_quality_should_not_be_higher_than_50(
            @From(ItemNameGenerator.class) ItemName itemName,
            int sellIn,
            int quality) {
        assumeThat(itemName.name, not(equalTo("Sulfuras, Hand of Ragnaros")));

        Item item = new Item(itemName.name, sellIn, quality);
        GildedRose gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        Assertions.assertThat(item.quality).isLessThan(50);
    }
}
