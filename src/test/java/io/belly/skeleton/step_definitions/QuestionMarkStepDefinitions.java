package io.belly.skeleton.step_definitions;

import io.cucumber.java.en.Given;

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
}
