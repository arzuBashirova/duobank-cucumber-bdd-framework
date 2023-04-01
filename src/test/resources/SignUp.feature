
Feature: Sign up for a mortgage application account

  As a potential user and customer, I should be able to use the Sign Up page and create an account to use the DuoBank Mortgage Application services.


  Scenario: User wants to sign up for an account
    Given the user is on the registration page of the mortgage application website
    When the user enters their First Name, Last Name, Email Address, and Password
    And all input fields have been filled out correctly
    Then the Sign Up button should be clickable
    When the user clicks the Sign Up button
    Then a new account is created for the user
    And the user is redirected to the Sign In page
    And the message "Welcome Back!" is displayed

  Scenario: User enters invalid input
    Given the user is on the registration page of the mortgage application website
    When the user enters invalid input into any of the input fields
    Then the Sign Up button should remain disabled
    And error messages should be displayed for the invalid input fields

  Scenario: User enters existing email address
    Given the user is on the registration page of the mortgage application website
    And there is an existing account with the email address the user is trying to use
    When the user enters the existing email address
    Then the Sign Up button should remain disabledAnd an error message "This email already used" should be displayed

  Scenario: User already has an account
    Given the user is on the registration page of the mortgage application website
    And the user already has an account
    When the user clicks the "Already have an account? Sign in" link
    Then the user is redirected to the Sign In page.

