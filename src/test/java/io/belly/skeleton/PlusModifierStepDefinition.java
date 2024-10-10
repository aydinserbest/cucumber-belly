package io.belly.skeleton;

import io.cucumber.java.en.Given;

public class PlusModifierStepDefinition {
    @Given("^I have deposited \\$(\\d+) into my account")
    public void i_have_deposited_$_into_my_account(int amount) {
    }
    @Given("^I have withdrawn \\$(\\d+) from my account")
    public void i_have_withdraw_$_from_my_account(int amount) {
    }
    @Given(("^There are (\\d+) students in the class$"))
    public void there_are_students_in_the_class(int students) {
    }

}
