@DMA-10
Feature: provide-information-about-expenses

  As a potential homebuyer, I want to use the Expenses page of my bank's mortgage application to provide information about my current living situation and expenses so that I can move forward with the mortgage application process.



  Background: Common steps for all scenarios in sign up page

    Given The user is on the Sign in page

  Scenario: Navigate to Sign In page

    When The user navigates to the sign in page
    Then the user should be greeted with a welcome message
    Then The sign in page should have two input fields
    Then One for email address and the other for password