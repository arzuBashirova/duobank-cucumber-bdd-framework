
@SignInTesting
Feature: As a user, I want to be able to sign in to my mortgage account, so that I can access my account information and perform necessary actions.

  Background: Common steps for all scenarios in sign in page

    Given The user is on the Sign in page

  Scenario: User navigate to Sign In page
    When The user navigates to the sign in page
    Then the user should be greeted with a welcome message
    Then The sign in page should have two input fields
    Then One for email address and the other for password


  @blankEmail
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

  @maskedPassword
  Scenario: User enter password field  and password should be masked and not show the entered characters.
    When the user enters a password into password field
    Then password should be masked

  @disabledButton
  Scenario: The sign in button should be disabled until both the email address and password fields are filled with valid values.
    When the user doesn't fill fields
    Then the sign in button should be disabled

  @signIn
  Scenario: Upon clicking the sign in button, the application should verify the user's credentials and if they are correct, redirect the user to the mortgage account dashboard.
    When the user enters correct credentials
    Then the user navigates to the mortgage account dashboard

  @enterIncorrectEmail
  Scenario: User enters incorrect credentials
    When the user enters incorrect credentials
    Then the application should display an error message “Login Failed”

  @noAccountYet
  Scenario: User doesn't have an account and wants to create one
    When the user doesn't have an account
    And the sign in page should have a "Don't have an account?" text
    Then the sign in page should have a "Sign up" link






