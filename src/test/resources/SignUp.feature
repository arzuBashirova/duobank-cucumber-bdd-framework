Feature: Sign up for a mortgage application account

  As a potential user and customer, I should be able to use the Sign Up page and create an account to use the DuoBank Mortgage Application services.

  @Scenario1
  Scenario: User wants to sign up for an account
    Given the user is on the registration page of the mortgage application website
    When the user enters their First Name, Last Name, Email Address, and Password
    And all input fields have been filled out correctly
    When the Sign Up is clickable
    Then the new account is created and the user is redirected to the Sign In page
    Then the message "Welcome Back!" is displayed

  @Scenario2
  Scenario: User enters invalid input
    Given the user is on the registration page of the mortgage application website
    When the user enters invalid input into any of the input fields
    Then the Sign Up button should remain disabled
    And error messages should be displayed for the invalid input fields

  @Scenario3
  Scenario: User enters existing email address
    Given the user is on the registration page of the mortgage application website
    And there is an existing account with the email address the user is trying to use
    When the user enters the existing email address
    Then the Sign Up button should remain disabled
    And an error message "This email already used" should be displayed

  @Scenario4
  Scenario: User already has an account
    Given the user is on the registration page of the mortgage application website
    And the user already has an account
    When the user clicks the "Already have an account? Sign in" link
    Then the user is redirected to the Sign In page.