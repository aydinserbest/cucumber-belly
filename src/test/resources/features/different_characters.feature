@different_characters
Feature: Different regex types

  Scenario: File path
    Given the file path is C:\Users\John\Documents

  Scenario: Phone number with 10 digits
      Given the phone number (123) 4567890 belongs to John

  Scenario: Email registration
      Given the email user@example.com is registered

  Scenario: Server is active
      Given the server with IP 192.168.0.1 is active

  Scenario: Server is active
      Given the server with IP 192.168.0.1 is active

  Scenario: Birthdate entry
      Given the birthdate is 15/08/1990

  Scenario: Account
      When I transfer $500 from my Savings Account into my Checking Account

