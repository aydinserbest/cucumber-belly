package io.belly.skeleton.data_table_stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;

public class ShopppingListStepDefinitions {
    @Then("my shopping list should contain:")
    public void myShoppingListShouldContain(DataTable dataTable) {
        List<String> myShoppingItems = dataTable.asList();
        System.out.println(myShoppingItems.size());
        System.out.println(myShoppingItems.get(3));
        /*for (String item : myShoppingItems) {
            System.out.println(item);
        }*/
    }
    @Then("my shopping list should contains those lists:")
    public void myShoppingListShouldContains(DataTable dataTable) {
        List<List<String>> lists = dataTable.asLists();
        System.out.println(lists);
        System.out.println(lists.size());
        System.out.println(lists.get(0));

    }
    /*
    dataTable.asList() returns a List<String> of the values in the first column of the table.
    The table in the feature file is:
      | Onions   |
      | Potatoes |
      | Sausages |
      | Apples   |
      | Relish   |
      tabloda 1 sütün var,
      dataTable.asList() bu sütunu alıp List<String> e atıcak,
       bu sütündaki her satırın değerini alıp bir listeye atar.
      listenin 5 elementi olur
      myShoppingItems.get(3) => Apples



     */
}
