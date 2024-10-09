package io.belly.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankStepDefinitions {
    Account account = new Account();
    //@Given("I have ${int} in my account")
    @Given("^I have \\$(100|250) in my account$") // This is a regular expression because starts with ^ and ends with $
    // and in regular expression $ is a special character, so we need to escape it with backslash
    // ( ) is a group, it is a capturing group, it captures the value and passes it to the method
    //  and | is an OR operator, it is used to match either 100 or 250
    // 100|250 is a regular expression, it matches either 100 or 250
    // in cucumber expression, there is no or operator, so we use regular expression
    public void i_have_$_in_my_account(int balance) {
        account.setBalance(balance);
        System.out.println("I have " + balance + " in my account");
    }
    @When("I request ${int}") //this is cucumber expression, no need to use backslash to escape $
    public void i_request_$(int amount) {
        boolean success = account.withdraw(amount);
        if (!success) {
            System.out.println("Insufficient funds");
        }
        account.withdraw(amount);
        System.out.println("I request " + amount);

    }
    @Then("${int} should be dispensed")
    public void $_should_be_dispensed(int amount) {
        System.out.println(amount + " dispensed");
    }

}
