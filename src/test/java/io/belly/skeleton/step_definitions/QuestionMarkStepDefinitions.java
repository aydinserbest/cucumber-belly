package io.belly.skeleton.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class QuestionMarkStepDefinitions {
    /*
     Scenario: I have a
    Given I have a cucumber in my basket
    When I have 256 cucumbers in my basket

    bu senaryo steplerini tek metotta yazalım:
     */
    @Given("^I have (a|\\d+) cucumber(s?) in my basket$")
    public void i_have_cucumber_in_my_basket() {
    }
    /*
    Step'lerde yakalanacak değerler parantez içinde tanımlanmalıdır
    (örneğin: (a|\\d+)).
    Opsiyonel kısımlar ise s? gibi bir yapıyla belirtilmelidir.
     */
    /*
    Values to be captured in steps should be defined within parentheses (e.g., (a|\\d+)).
    Optional parts should be written as s?
     */
    @Given("^I (?:have )?request to access the system$") // :have den sonra boşluk bırakırsak have kelimesi opsiyonel olur
    //boşluk bırakmazsak have kelimesi zorunlu olur
    public void i_have_request_to_access_the_system() {
    }
    @When("^I (?:visit|go to) the homepage$")
    public void i_go_to_the_homepage() {
    }
    @When("^(she|he) purchases a ticket$")
    public void she_purchases_a_ticket() {
    }
    /*


    @Given("^I have \\$(100|250) in my account$")
    public void i_have_in_my_account(int amount) {
    }

     */
    @When("^Tara (?:buys|has bought) a ticket$")
    public void tara_buys_a_ticket() {
    }
    @Then("(s)he has been a member/customer for {int} year(s)")
   // @Then("^(?:he|she) has been a (?:member|customer) for (\\d+) year(?:s?)$")
        //  alttaki örnekte, sondaki year(s?) ifadesindeki s opsiyonel olmuş olması gerekirken
        //  group capturing gibi algılanıyor ve parametre istiyor
        // ama üstlerde cucumber(s?) örneğinde opsiyonel kabul etmişti BU HATA NİYE??????
    //@Then("^(?:he|she) has been a (?:member|customer) for (\\d+) year(s?)$")
    public void she_has_been_a_member_for_5_years(int years) {
    }


}
