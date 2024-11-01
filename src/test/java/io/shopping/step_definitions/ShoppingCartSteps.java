package io.shopping.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.shopping.ShoppingCart;
import io.shopping.ShoppingCartService;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartSteps {
    private ShoppingCart shoppingCart = new ShoppingCart();
    private ShoppingCartService shoppingCartService = new ShoppingCartService(shoppingCart);
    private int totalQuantity;

    @Given("the following items are added to the shopping cart:")
    public void the_following_items_are_added_to_the_shopping_cart(DataTable dataTable) {
        List<Map<String, String>> items = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : items) {
            String itemName = row.get("item");
            int quantity = Integer.parseInt(row.get("quantity"));
            shoppingCartService.addItemToCart(itemName, quantity);
        }
    }

    @When("I check the total quantity in the shopping cart")
    public void i_check_the_total_quantity_in_the_shopping_cart() {
        totalQuantity = shoppingCartService.getTotalQuantity();
    }

    @Then("the total quantity should be {int}")
    public void the_total_quantity_should_be(int expectedTotalQuantity) {
        assertEquals(expectedTotalQuantity, totalQuantity);
    }
}
