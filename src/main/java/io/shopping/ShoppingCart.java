package io.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ShoppingItem> items = new ArrayList<>();

    public void addItem(ShoppingItem item) {
        items.add(item);
    }

    public int calculateTotalQuantity() {
        return items.stream().mapToInt(ShoppingItem::getQuantity).sum();
    }

    public List<ShoppingItem> getItems() {
        return items;
    }
}
