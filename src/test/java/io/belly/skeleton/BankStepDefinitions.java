package io.belly.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankStepDefinitions {
    Account account = new Account();
    @Given("I have ${int} in my account")
    public void i_have_$_in_my_account(int balance) {
        account.setBalance(balance);
        System.out.println("I have " + balance + " in my account");
    }
    @When("I request ${int}")
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
