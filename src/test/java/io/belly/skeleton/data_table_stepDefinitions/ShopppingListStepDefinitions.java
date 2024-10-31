package io.belly.skeleton.data_table_stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

import java.util.List;

public class ShopppingListStepDefinitions {
    @Then("my shopping list should contain:")
    public void myShoppingListShouldContain(DataTable dataTable) {
        List<String> myShoppingItems = dataTable.asList();
        System.out.println(myShoppingItems.size());
        System.out.println(myShoppingItems);
        System.out.println(myShoppingItems.get(3));
        /*for (String item : myShoppingItems) {
            System.out.println(item);
        }*/


    }
    @Then("my shopping list should contains those lists:")
    public void myShoppingListShouldContains(DataTable dataTable) {
        //List<List<String>> lists = dataTable.asLists();
        List<String> list = dataTable.asList();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.getFirst());

        /*
        tabloyu aldığımızda ilk satır, başlıklar ise mesela, genelde öyle olur
        Pratikte, başlıkları genellikle atlayarak veri satırlarıyla çalışılır.
        Bu yüzden, başlıkları almak istemeyebiliriz.
        dataTable.asLists().get(0) => ilk satırı alır
        dataTable.asLists().subList(1, dataTable.asLists().size()) => ilk satırı atlayarak geri kalan satırları alır
        
        */

       //// List<List<String>> dataWithoutHeaders = lists.subList(1, lists.size());//ilk satırı atlayarak geri kalan satırları alır
        //System.out.println(dataWithoutHeaders);


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
       bu sütündaki her satırın değerini alıp tek bir listeye atar.
      listenin 5 elementi olur
      myShoppingItems.get(3) => Apples


     */
    /*
    birden fazla column varsa, returns a List<List<String>> of the values in the table.
     | Onions   | Potatoes | Bananas  |newspaper|
      | Sausages | Apples   | Relish   |coke     |
      | orange | water   | brood   |ginger       |

      birden fazla column varsa,her bir satırın değerlerini alıp bir listeye atar.
      üstteki örnekte, 4 column ve 3 row var

      her satır list olucağı için lists'in 3 elementi olur,
        her bir elementte 4 eleman olur.

        dataTable.asLists() => [[Onions, Potatoes, Bananas,newspaper], [Sausages, Apples, Relish,coke], [orange, water, brood,ginger]]
        lists.size() => 3
        lists.get(0) => [Onions, Potatoes, Bananas,newspaper]
        lists.get(1) => [Sausages, Apples, Relish,coke]
        lists.get(2) => [orange, water, brood,ginger]


     */


}
