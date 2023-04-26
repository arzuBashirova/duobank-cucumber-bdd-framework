
Feature: Expenses page feature

  As a potential homebuyer, I want to use the Expenses page of my bank's mortgage application.
  To provide information about my current living situation and expenses,
  so that I can move forward with the mortgage application process.


  Background: Common steps for all scenarios in Expenses page
    When the user enters valid information including email, password 1
    And clicks on the sign-in button 1
    And clicks on Mortgage Application button 1
    And fills out all the fields 1
    And fills out personal info 1
    Then the user is redirected to the expenses page 1

  @positiveRent
  Scenario: the user should be able to select only one checkbox.
    Given the user is on the Expenses page 1
    When the user should have 2 checkboxes one for Rent and one for Own 1
    Then the user should be able to select only one checkbox. 1

  @positiveRent
  Scenario:
    When the user selects Rent the Monthly Rental Payment field should be required 1
    Then must be a numeric input field that only allows positive numbers 1

  @bugRent
  Scenario:
    When the user selects Rent the Monthly Rental Payment field should be required 1
    And must be a numeric input field less then one 1
    Then the user should see an error message for input 1

  @positiveRent
  Scenario:
    When the user selects Rent the Monthly Rental Payment field should be required 1
    Then the user should see an error message for empty input 1


  @bugRent
  Scenario:
    When the user selects Rent the Monthly Rental Payment field should be required 1
    And must be a not numeric input field 1
    Then the user should see an error message for not numeric input 1














