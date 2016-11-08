import java.util.List;


public class GildedRose {

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            processItem(item);
        }
    }

    private void processItem(Item item) {
        if ("Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            return;
        }
        item.setSellIn(item.getSellIn() - 1);
        if ("Aged Brie".equals(item.getName())) {
            increaseQuality(item);
            if (item.getSellIn() < 0) {
                increaseQuality(item);
            }
            return;
        }
        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            increaseQuality(item);

            if (item.getSellIn() < 10) {
                increaseQuality(item);
            }

            if (item.getSellIn() < 5) {
                increaseQuality(item);
            }
            if (item.getSellIn() < 0) {
                item.setQuality(0);
            }
            return;
        }
        decreaseQuality(item);
        if (item.getSellIn() < 0) {
            decreaseQuality(item);
        }

    }

    private void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private List<Item> items;
}
