
Feature: Shopping List
  @short_list
  Scenario: short list
    Then my shopping list should contain:
      | Onions   |
      | Potatoes |
      | Sausages |
      | Apples   |
      | Relish   |

  @yan_yana
  Scenario: short list
    Then my shopping list should contains those lists:
      | Onions   | Potatoes | Bananas  |newspaper|
      | Sausages | Apples   | Relish   |coke     |
      #| orange | water   | brood   |ginger       |

@long_list
  Scenario: Add items to shopping list
    Given the following items are in the shopping list
      | item  | quantity |
      | apple | 6        |
      | banana| 10       |
    When I add the following items to the shopping list
      | item  | quantity |
      | apple | 4        |
      | banana| 5       |
    Then the shopping list should contain the following items
      | item  | quantity |
      | apple | 10       |
      | banana| 15       |