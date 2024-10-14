package io.belly.skeleton.data_table_stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class UsersStepDefinitions {

    @Given("these users exist:")
    public void theseUsersExist(DataTable dataTable) {

        Map<String, String> map = dataTable.asMap();
        System.out.println(map);
        /*List<Map<String, String>> maps = dataTable.asMaps();
        System.out.println(maps);*/

        //dataTable.asLists().forEach(System.out::println);
      /*  List<List<String>> users = dataTable.asLists();
        System.out.println(users.size());
        System.out.println(users);
        System.out.println(users.get(0));
        System.out.println(users.get(0).get(1));
        System.out.println(users.get(3).get(1));*/
        /*for (List<String> user : users) {
            System.out.println(user.get(0));*/
        //System.out.println(user.get(1));
        //System.out.println(user.get(2));
    }
}

