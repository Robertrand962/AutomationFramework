Feature: Application Login

  @Login


  Scenario Outline: Home page default login
    Given User is on AutomationPractice page
    When User click sign in.
    Then User logins using data from "<SheetName>" and <RowNumber>
    Then User is in Account page.
    Examples:
      | SheetName |  | RowNumber |
      | Login     |  | 0         |




