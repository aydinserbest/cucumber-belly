Feature: Shopping Cart

    Scenario: Add items to the shopping cart and verify total quantity
        Given the following items are added to the shopping cart:
            | item   | quantity |
            | apple  | 3        |
            | banana | 2        |
            | orange | 5        |
        When I check the total quantity in the shopping cart
        Then the total quantity should be 10