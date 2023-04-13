

@emp1
Feature: As a user applying for a mortgage loan, I want to provide my employment and income details to the bank, so that they can evaluate my eligibility for a loan.

  Background: common step
    When the user signin for sprint
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

  @nameFieldRequired
  Scenario: EMPLOYER NAME should be a required input field.
    When  User left the Employer Name field blank
    Then name field should be required

  Scenario: STATE should be as dropdown list with all 50 US states
    Then State dropdown should have 52 States


  Scenario: The checkbox labeled "This is my current job" should be unchecked by default.
    Then checkbox should be unchecked by default


  Scenario: The section should have a "Clear" option that displays a warning pop-up about clearing the information
    When user clicks clear button Employment and Income page
    Then clear option should display


  Scenario: The "Clear" option should only clear the information in that section, not any other sections.
    When user clicks clear button Employment and Income page
    And accept the popup message
    Then in that section information should be deleted not another pages


  @sc_outline
  Scenario Outline: Login with valid credentials Employment and Income page

    Then User enter username "<name>" , position "<position>" , city "<city>" ,  state "<state>" and start date "<startDate>"

    Examples:
      | name           | position   | city      | state       | startDate |
      | duotech2023    | duotech    | Trumbull  | Connecticut | 11111999  |
      | johnnycash2023 | johnnycash | Greenwich | Florida     | 11111999  |
      | stevejobs2023  | stevejobs  | New York  | New York    | 11111999  |
  @last
  Scenario Outline: Login with invalid credentials Employment and Income page

    Then User enter iusername "<name>" , iposition "<position>" , icity "<city>" ,  istate "<state>" and istart date "<startDate>"

    Examples:
      | name           | position                                                                                 | city      | state       | startDate |
      | anne cordellia | 1                                                                                        | Trumbull  | Connecticut | 0  |
      | JM             | positionpositionpositionpositionpositionpositionpositionpositionpositionpositionposition | Greenwich | Florida     | 0000000000  |
      | 2023           | n6                                                                                       | New       | York        | 11111999  |

  @last
  Scenario: The "Add another employer" button should let the user add a new
  section for another employer's information.
    When user clicks on add new employer button
    Then user should be able to add new information

  @last
  Scenario: Verify page contain fields2
    When user clicks on add new employer button
    Then the page should contains same as first page fields

  @last
  Scenario: The section should have a "Clear" option that displays a warning pop-up about clearing the information2
    When user clicks clear button second employer Employment and Income page
    Then clear popup should display
    And accept the popup message
    Then in that second employer information should be deleted not another pages

  @last
  Scenario: The user should be able to remove a section using the "Remove"
  option.
    When user clicks Remove button
    Then user clicks the yes new section must be deleted










