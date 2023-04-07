
@emp1
Feature: As a user applying for a mortgage loan, I want to provide my employment and income details to the bank, so that they can evaluate my eligibility for a loan.

  Background: common step
    When the user enters correct credentials
    Then the user navigates to the mortgage account dashboard
    And clicks on Mortgage Application button 1
    And fills out all the fields on preapprovals page
    And fills out personal info fields and expenses

    @containCheck
  Scenario: Verify page contain fields
    Given User on the Employment and Income page
    Then the page should contains following fields

      | EMPLOYER NAME |
      | POSITION      |
      | CITY          |
      | STATE         |
      | START DATE    |
      | END DATE      |