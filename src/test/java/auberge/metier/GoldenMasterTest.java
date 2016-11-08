package auberge.metier;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class GoldenMasterTest {

    @Test
    public void regressions_test() throws Exception {
        List<Item> legacyItems = makeItems();
        GildedRoseLegacy legacy = new GildedRoseLegacy(legacyItems);
        List<Item> newItems = makeItems();
        GildedRose gildedRose = new GildedRose(newItems);

        for (int i = 0; i < 100; i++) {
            legacy.updateQuality();
            gildedRose.updateQuality();
            for (int j = 0; j < legacyItems.size(); j++) {
                Item legacyItem = legacyItems.get(j);
                Item newItem = newItems.get(j);
                assertEquals(legacyItem.getName(),newItem.getName());
                assertEquals(legacyItem.getQuality(),newItem.getQuality());
                assertEquals(legacyItem.getSellIn(),newItem.getSellIn());
            }
        }
    }

    private List<Item> makeItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        return items;
    }
}
