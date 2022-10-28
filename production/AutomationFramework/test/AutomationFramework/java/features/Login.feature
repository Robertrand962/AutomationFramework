Feature: Application Login

  @Login


  Scenario Outline: Home page default login
    Given User is on AutomationPractice page
    When User click sign in.
    Then User logins using data from "<SheetName>" and <RowNumber>
    Then User is in Account page.
    Examples:
      | SheetName |  | RowNumber |
      | Hoja1     |  | 0         |

  Scenario Outline: 5. 'Search Product' feature
    Given User is on AutomationPractice page
    Then User move cursor over Women link and click on sub menu T-Shirts
    Then User Get Text of the first product displayed on the page
    Then User Search the text from "<SheetName>" and <RowNumber> of the product displayed and click search button
    Then User validates that same product is displayed on searched page

    Examples:
      | SheetName   |  | RowNumber |
      | ProductName |  | 0         |

  Scenario Outline: 6. 'Buy Product' feature
    Given User is on AutomationPractice page
    When User click sign in.
    Then User logins using data from "<SheetName>" and <RowNumber>
    Then User move cursor over Women link and click on sub menu T-Shirts
    Then User move cursor hover the product and click on More button
    Then User increase quantity, select size L and select color
    Then User click add to cart button and proceed to check out button
    Then User complete the buy order process till payment
    Then User make sure that product is ordered
    Examples:
      | SheetName |  | RowNumber |
      | Hoja1     |  | 0         |


  Scenario: 7.1 Verify that 'Add to Wishlist' only works after login
    Given User is on AutomationPractice page
    Then User move cursor over Women link and click on sub menu T-Shirts
    Then User move cursor hover the product and click on Add to Wishlist
    Then User verify that error message is displayed

  Scenario Outline: 6. 'Buy Product' feature 2
    Given User is on AutomationPractice page
    When User click sign in.
    Then User logins using data from "<SheetName>" and <RowNumber>
    Then User move cursor over Women link and click on sub menu T-Shirts
    Then User move cursor hover the product and click on More button
    Then User verify quantity, select size M and select color
    Then User click add to cart button and proceed to check out button
    Then User change the quantity to two and Verify total price is correct
    Examples:
      | SheetName |  | RowNumber |
      | Hoja1     |  | 0         |



