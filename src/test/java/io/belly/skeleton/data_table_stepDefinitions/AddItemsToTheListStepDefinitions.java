package io.belly.skeleton.data_table_stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

public class AddItemsToTheListStepDefinitions {
    private List<List<String>> shoppingItems = new ArrayList<>();
    @Given("the following items are in the shopping list")
    public void theFollowingItemsAreInTheShoppingList(DataTable dataTable) {
        shoppingItems = dataTable.asLists();
    }
    @When("I add the following items to the shopping list")
    public void iAddTheFollowingItemsToTheShoppingList(DataTable dataTable) {
        List<List<String>> shoppingItems = dataTable.asLists();
        List<List<String>> dataWithoutHeaders = shoppingItems.subList(1, shoppingItems.size());
        System.out.println(dataWithoutHeaders); //[[apple, 5], [banana, 10]]
        System.out.println(dataWithoutHeaders.getFirst()); //[apple, 5]
        System.out.println(dataWithoutHeaders.getFirst().getFirst()); //apple

        for (List<String> row: dataWithoutHeaders) {
            System.out.println("The item: " + row.get(0) + " has quantity: " + row.get(1));
        }
    }
}
