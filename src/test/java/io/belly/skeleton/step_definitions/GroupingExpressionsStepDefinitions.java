package io.belly.skeleton.step_definitions;

import io.cucumber.java.en.Given;

public class GroupingExpressionsStepDefinitions {
    //@Given("^the product code ([A-Z]{1,3}\\d{1,3}) has (\\d+) units in stock$")
    //@Given("^the product code (\\w+) has (\\d+) units in stock$")
    @Given("the product code {word} has {int} units in stock")
    public void theProductCodeHasUnitsInStock(String productCode, int unitsInStock) {
        System.out.println("The product code " + productCode + " has " + unitsInStock + " units in stock");
    }
    @Given("^the user (\\w+) is (\\d+) years old$")
    public void theUserIsYearsOld(String userName, int age) {
        System.out.println("The user " + userName + " is " + age + " years old");
    }
    //@Given("^the date is (\\d{2}-\\d{2}-\\d{4})$")
    @Given("the date is {int}-{int}-{int}")
    public void theDateIs(int day, int month, int year ) {
        System.out.println("The date is " + day + "_" + month + "_" + year);
    }
    //@Given("^the user (\\w+) has (\\d+) dollars$")
    @Given("the user {string} has {int} dollars")
    public void theUserHasDollars(String userName, int dollars) {
        System.out.println("The user " + userName + " has " + dollars + " dollars");
    }
    /*
    eğer step definitionda {string} kullandıysak, feature dosyasında " " içinde yazmalıyız
    Given the user "John" has 150 dollars
    @Given("the user {string} has {int} dollars")
    John'u " " içine almassak, hata alırız
     */
}
