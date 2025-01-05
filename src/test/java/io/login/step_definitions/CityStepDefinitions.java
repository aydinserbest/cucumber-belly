package io.login.step_definitions;

import io.cities.Destinations;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CityStepDefinitions {

    @ParameterType(".*")
    public List<Destinations> stringValues(String destinationList) {
        return Stream.of(destinationList.split(","))
                .map(city -> new Destinations(city.trim()))  // Her şehri ayrı bir Destination nesnesine dönüştürüyor
                .collect(Collectors.toList());
    }

    @Then("the available destinations should be {stringValues}")
    public void availableDestinations(List<Destinations> destinations) {
        for (Destinations destination : destinations) {
            System.out.println(destination.getCity());
        }
    }


}
