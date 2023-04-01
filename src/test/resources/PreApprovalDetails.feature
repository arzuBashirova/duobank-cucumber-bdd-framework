Feature: As a user, I want to use the Preapproval Details page of my bank's mortgage application, so that I can provide
  the information needed to get pre-approved for a mortgage loan.

  Background: Common steps for all scenarios in preapproval details page

    Given The user is on the preapproval details page

    @dropdowmTest
    Scenario: User navigates to preapproval details page to verify dropdown menu options

    When The user clicks on Dropdown menu of options for "Purpose of Loan"
    Then it should contain options
    | Purchase a Home |
    | Refinance |
    | Construction |

      @estPrice
    Scenario: User wants to enter dollar amount into "Estimated Purchase Price" field

    When The user enters a dollar amount into "Estimated Purchase Price" field
    Then The user should be able to enter a dollar amount with up to 2 decimal places and it should be required

    @downPayAmt
    Scenario: User wants to enter dollar amount into "Down Payment Amount" field

    When The user enters a dollar amount into "Down Payment Amount" field
    Then The user should be able to enter a dollar amount with up to 2 decimal places and it's required

    Scenario: User wants to enter percent amount into "Down Payment Percentage" field

    When The user enters a percent amount into "Down Payment Percentage" field
    Then The user should be able to enter a dollar amount with up to 2 decimal places and it be automatically calculated

    Scenario: "Your Loan Amount" should automatically be updated

    When The user enters amounts into purchase price and down payment fields
    Then The "Your Loan Amount" field should be automatically updated
