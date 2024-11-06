package io.login.step_definitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DestinationSteps {
    @ParameterType(".*")
    public List<String> stringValues(String destinationList) {
        return Stream.of(destinationList.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Then("the available destinations should be {stringValues}")
    public void availableDestinations(List<String> destinations) {
        for (String destination : destinations) {
            System.out.println(destination);
        }
    }
}
