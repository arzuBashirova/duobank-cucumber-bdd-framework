

Feature: As a potential homebuyer

  Background: User is logged in


    Given The user signs in and navigates to the Preapproval Details here

    When the user sees the email and password and enters info here
    Then the user should be able to sign into page here

  Scenario: User is on the preapproval details page

    When The user clicks on Dropdown menu of options for "Purpose of Loan" here
    Then it should contain options here
      | Purchase a Home |
      | Refinance |
      | Construction |

    When The user enters a dollar amount into "Estimated Purchase Price" field here
    Then The user should be able to enter a dollar amount with up to 2 decimal places and it should be required here

    When The user enters a dollar amount into "Down Payment Amount" field here
    Then The user should be able to enter a dollar amount with up to 2 decimal places and it's required here

    When The user enters a percent amount into "Down Payment Percentage" field here
    Then The user should be able to enter a dollar amount with up to 2 decimal places and it be automatically calculated here

    When The user enters amounts into purchase price and down payment fields here
    Then The "Your Loan Amount" field should be automatically updated here

    When the user enters their first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

    When the user selects "Yes" for the co-borrower question
    Then an additional section for co-borrower's information is displayed

    When the user enters the co-borrower's first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out again

    When the user reads the Privacy Policy and clicks the checkbox to accept the terms
   Then the checkbox is checked and the user can move forward to the next page of the application

    When the user clicks the "Next" button
    Then the user is directed to the next page of the loan application