@Character
Feature: Flight departure system

  Scenario: Specific flight code
    Given the flight EZY4567 is leaving today

  Scenario: Another flight code with fewer digits
    Given the flight C038 is leaving today

  Scenario: Complex flight code with more digits
    Given the flight BA01618 is leaving today
