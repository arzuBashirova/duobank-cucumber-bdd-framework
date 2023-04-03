Feature: As a user, I want to use the Preapproval Details page of my bank's mortgage application, so that I can provide
  the information needed to get pre-approved for a mortgage loan.

  Background: User is logged in


    Given The user signs in and navigates to the Preapproval Details page

    When the user sees the email and password and enters it
    Then the user should be able to sign in


  Scenario: User is on the preapproval details page

   # When The user is on the sign in page
  #  Then the user should be able to sign in using their username and password

    When The user clicks on Dropdown menu of options for "Purpose of Loan"
    Then it should contain options
      | Purchase a Home |
      | Refinance |
      | Construction |

    When The user enters a dollar amount into "Estimated Purchase Price" field
    Then The user should be able to enter a dollar amount with up to 2 decimal places and it should be required

    When The user enters a dollar amount into "Down Payment Amount" field
    Then The user should be able to enter a dollar amount with up to 2 decimal places and it's required

    When The user enters a percent amount into "Down Payment Percentage" field
    Then The user should be able to enter a dollar amount with up to 2 decimal places and it be automatically calculated

    When The user enters amounts into purchase price and down payment fields
    Then The "Your Loan Amount" field should be automatically updated
