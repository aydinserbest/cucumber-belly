package io.shopping;

public class ShoppingItem {
    private String itemName;
    private int quantity;

    public ShoppingItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }
}
