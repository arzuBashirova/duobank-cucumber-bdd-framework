

Feature: As a user, I want to be able to sign in to my mortgage account, so that I can access my account information and perform necessary actions.

  Background: Common steps for all scenarios in sign up page

    Given The user is on the Sign in page

  Scenario: Navigate to Sign In page

    When The user navigates to the sign in page
    Then the user should be greeted with a welcome message
    Then The sign in page should have two input fields
    Then One for email address and the other for password

