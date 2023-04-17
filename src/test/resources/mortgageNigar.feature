Feature:As a potential homebuyer, I want to use the Preapproval Details page of my bank's mortgage application
  to provide the necessary information to get pre-approved for a mortgage loan

  Background: Common steps for all scenarios in Preapproval Details page

    Given The user is on the Preapproval Details page


    Scenario: The "Source of Down Payment" field should have three options
      When user click source of Down Payment dropdown field
      Then drop-down menu should have options
        |Checking/Savings (most recent bank statement)   |
        |Equity on Pending Sale (executed sales contract)|
        |Other type of Down Payment                      |



      Scenario:The "Additional Funds Available" field should allow dollar amount
        When user checks Additional Funds Available field"
        Then user should enter a dollar amount with up to two decimal


  Scenario: Click "Next" button
    When user clicks Next button
    Then user should not proceed until all required fields are completed.

  @this
       Scenario: Sucessful completion
         When user filled all the required fields
         Then user should be directed to Personal Infomartion page
