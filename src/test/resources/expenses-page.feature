
Feature: Expenses page feature

  As a potential homebuyer, I want to use the Expenses page of my bank's mortgage application.
  To provide information about my current living situation and expenses,
  so that I can move forward with the mortgage application process.


  Background: Common steps for all scenarios in Expenses page
    When the user enters valid information including email, password
    And clicks on the sign-in button
    And clicks on Mortgage Application button
    And fills out all the fields
    And fills out personal info
    Then the user is redirected to the expenses page

  @positive
  Scenario: the user should be able to select only one checkbox.
    Given the user is on the Expenses page
    When the user should have 2 checkboxes one for Rent and one for Own
    Then the user should be able to select only one checkbox.

  @positive
  Scenario:
    When the user selects Rent the Monthly Rental Payment field should be required
    Then must be a numeric input field that only allows positive numbers

    @bug
  Scenario:
    When the user selects Rent the Monthly Rental Payment field should be required
    And must be a numeric input field less then one
    Then the user should see an error message for input

   @positive
  Scenario:
    When the user selects Rent the Monthly Rental Payment field should be required
    Then the user should see an error message for empty input


   @bug
  Scenario:
    When the user selects Rent the Monthly Rental Payment field should be required
    And must be a not numeric input field
    Then the user should see an error message for not numeric input














