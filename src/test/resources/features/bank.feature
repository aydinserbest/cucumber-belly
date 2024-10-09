
Feature: Bank application
  @Bank
  Scenario: Successful withdrawal from an account
    Given I have $100 in my account
    When I request $20
    Then $20 should be dispensed