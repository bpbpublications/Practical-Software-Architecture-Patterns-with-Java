Feature: Promotional Checkout Validations
  As a marketing manager
  I want discount vouchers to apply correctly at checkout
  So that we can run successful promotional campaigns

  # Demonstrating @ValueSource equivalents
  Scenario Outline: Processing invalid or expired vouchers
    Given my shopping cart total is $100.00
    When I apply the invalid voucher "<code>"
    Then the final checkout price should remain unchanged at $100.00

    Examples:
      | code       |
      | EXPIRED50  |
      | INVALID    |
      | UNKNOWN    |

  # Demonstrating @MethodSource equivalents
  Scenario Outline: Processing standard active discounts
    Given a valid voucher "<code>" exists
    And my shopping cart total is $<cart_total>
    When I apply the voucher "<code>"
    Then the final checkout price should be $<final_price>

    Examples:
      | code       | cart_total | final_price | notes                           |
      | SUMMER20   | 100.00     | 80.00       | Equivalence: Standard active 20%|
      | VIP-HALF   | 50.00      | 25.00       | Equivalence: Standard active 50%|

  # Demonstrating Edge Cases
  Scenario Outline: Processing extreme edge cases safely
    Given my shopping cart total is $<cart_total>
    When I apply the voucher "<code>"
    Then the system should handle the extreme boundary and return $<final_price>

    Examples:
      | code       | cart_total | final_price |
      | FREE100    | 9999.99    | 0.00        |
      | SUMMER20   | 0.00       | 0.00        |
