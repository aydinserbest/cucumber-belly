package io.belly.skeleton;

import io.cucumber.java.en.Given;

public class CharacterStepDefinition {
    //@Given("^the flight ([A-Z]{1,3}\\d{3,6}) is leaving today$")
    @Given("^the flight (\\w+) is leaving today$") // \\w+, hem harfleri hem de rakamları (ve alt çizgiyi) yakalar
    public void theFlightIsLeavingToday(String flightNumber) {
        System.out.println("The flight " + flightNumber + " is leaving today");
    }
    /*
    \\d+  \\w+
    +: Bu karakterin bir veya daha fazla kez tekrarlanabileceğini belirtir.
     */

}
