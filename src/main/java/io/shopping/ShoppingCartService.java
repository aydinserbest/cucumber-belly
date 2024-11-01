package io.shopping;

public class ShoppingCartService {
    private ShoppingCart shoppingCart;

    public ShoppingCartService(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addItemToCart(String itemName, int quantity) {
        ShoppingItem item = new ShoppingItem(itemName, quantity);
        shoppingCart.addItem(item);
    }

    public int getTotalQuantity() {
        return shoppingCart.calculateTotalQuantity();
    }
}
