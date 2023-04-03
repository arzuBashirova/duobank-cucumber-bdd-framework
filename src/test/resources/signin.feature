

Feature: As a user, I want to be able to sign in to my mortgage account, so that I can access my account information and perform necessary actions.

  Background: Common steps for all scenarios in sign in page

    Given The user is on the Sign in page

  Scenario: User navigate to Sign In page

    When The user navigates to the sign in page
    Then the user should be greeted with a welcome message
    Then The sign in page should have two input fields
    Then One for email address and the other for password


  Scenario: User left email and password fields blank

    When The user left the fields blank
    Then the user should not be able to submit
    When the user left the email field blank only
    Then the user should not be able to submit without email
    When the user left the password field blank only
    Then the user should not be able to submit without password

    @invalidData
  Scenario: User enter invalid email

    When the user enters an invalid email address
    And clicks on the sign in button
    Then the user should see an error message for email
    And the sign-up process should not proceed





