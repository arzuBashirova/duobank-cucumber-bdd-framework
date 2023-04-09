Feature: Econsent Page
  As a mortgage loan applicant, I want to consent to do business electronically so that I can receive and sign
  the necessary disclosures related to my loan application. I need to be able to enter my first and last name and
  email address.


  Background: Common steps for all scenarios
  Filling out application
    Given the user is on the eConsent page

  @first
  Scenario: User enters valid first name, last name and email address
    When the user fills the form with random data  including first name, last name and email
    Then the value boxes for first and last names should be filled

  @second
    Scenario: User enters invalid first name, last name and email address
        When the user fills the form with random data  including first name, last name and email
        Then the value boxes for first and last names should be blank
