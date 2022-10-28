Feature: Create Account


  Scenario Outline: 2. Verify invalid email address error
    Given User is on AutomationPractice page
    When User click sign in.
    Then User submits invalid <email>
    Then User validates error <message>

    Examples:
      | email        |  | message                |
      | invalidEmail |  | Invalid email address. |

  Scenario Outline: Create Account Valid
    Given User is on AutomationPractice page
    When User click sign in.
    Then User submits valid <Email>

    Examples:
      | Email                    |
      | pitobertrand@hotmail.com |

  @CreateAccount

  Scenario Outline: 1. Automate User Registration process of e-commerce website
    Given User is on AutomationPractice page
    When User click sign in.
    Then User fills the email from given sheetname "<SheetName>" and rownumber <RowNumber>
    Then User is in create an account page.
    And User provides personal information and address information from given sheetname "<SheetName>" and rownumber <RowNumber>
    Then User submit personal information and create an account
    Then User validates that user is created
    Examples:
      | SheetName | RowNumber |
      | Hoja1     | 0         |


  Scenario Outline: 3. Verify error messages for mandatory fields
    Given User is on AutomationPractice page
    When User click sign in.
    Then User fills the email from given sheetname "<SheetName>" and rownumber <RowNumber>
    Then User leave mandatory fields blank and click Register button
    Then User verify that error has been displayed for the mandatory fields

    Examples:
      | SheetName | RowNumber |
      | Hoja1     | 2         |

  Scenario Outline: 4. Verify error messages for entering incorrect values in fields
    Given User is on AutomationPractice page
    When User click sign in.
    Then User fills the email from given sheetname "<SheetName>" and rownumber <RowNumber>
    Then User is in create an account page.
    Then User enter incorrect values in fields from given sheetname "<SheetName>" and rownumber <RowNumber>
    Then User verify that error messages for respective fields are displaying

    Examples:
      | SheetName     | RowNumber |
      | InvalidFields | 0         |