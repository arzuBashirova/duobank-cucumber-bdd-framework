Feature: Econsent Page
  As a mortgage loan applicant, I want to consent to do business electronically so that I can receive and sign
  the necessary disclosures related to my loan application. I need to be able to enter my first and last name and
  email address, and I want to be able to easily indicate whether or not I agree to the terms and conditions.


  Background: Common steps for all scenarios
  Filling out application
    Given The user signs in and navigates to the Preapproval Details page
    When the user sees the email and password and enters it
    Then the user should be able to sign in
    And clicks on Mortgage Application button 1
    And fills out all the fields on preapprovals page
    And fills out personal info fields and expenses

  @first
  Scenario: User agrees to eConsent
    Given the user is on the eConsent page
    When the user fills the form with random data  including first name, last name and email
    And fills out the eConsent form with random data
    And clicks on the "I Agree" button
    And clicks on the "Next" button
    Then the user is redirected to the next page

  @second
  Scenario: User doesn't agree to eConsent
    Given the user is on the eConsent page
    When the user clicks on the eConsent button
    And fills out the eConsent form with random data
    And clicks on the "I don't Agree" button
    And clicks on the "Next" button
    Then an alert message should be displayed







