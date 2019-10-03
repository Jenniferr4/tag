package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.ItemComparator;
import org.improving.tag.items.UniqueItems;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public Inventory() {
        items.add(UniqueItems.EVERLASTING_GOBSTOPPER);
        items.add(UniqueItems.THE_UNFORGETTABLE_MUSHROOM);
        items.add(UniqueItems.THE_EGOO_WAFFLE);

    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);

    }

    public String getInventoryDisplay() {
        String displayString = "You have these Items:";
        return items.stream().sorted(new ItemComparator()).map(i ->"\n"+i).reduce(displayString, (answer, itemValue) -> answer+=itemValue);
}

    public Item getItem() {
        return items.get(3);
    }

}
