package io.belly.skeleton.step_definitions;

import io.belly.skeleton.Belly;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BellyStepDefinitions {
    Belly belly = new Belly();

    @Given("I have {int} cukes in my belly")
    public void I_have_cukes_in_my_belly(int cukes) {
        belly.eat(cukes);
    }

    @When("I wait {int} hour")
    public void I_wait_hour(int hours) {
        // Zaman simülasyonu veya bekleme mantığı
        System.out.println("Waiting for " + hours + " hour(s).");
    }

    @Then("my belly should growl")
    public void my_belly_should_growl() {
        // Growl metodu tetiklenmeli veya sonuç kontrol edilmeli
        System.out.println("Belly growls!");
    }
}
