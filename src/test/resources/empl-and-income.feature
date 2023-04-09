
Feature: Empl And Income

  As a user applying for a mortgage loan, I want to provide my employment and income details to the bank,
  so that they can evaluate my eligibility for a loan.


  Background: Common steps for all scenarios in Expenses page
    When the user enters valid information including email, password
    And clicks on the sign-in button
    And clicks on Mortgage Application button
    And fills out all the fields
    And fills out personal info
    And the user is redirected to the expenses page
    And the user selects Rent the Monthly Rental Payment field should be required
    And must be a numeric input field that only allows positive numbers


  @fields
    Scenario:
      When the user is redirected to the Employment and Income page
      Then the user should see fields
        | GROSS MONTHLY INCOME          |
        | MONTHLY OVERTIME              |
        | MONTHLY BONUSES               |
        | MONTHLY COMMISSIONS           |
        | MONTHLY DIVIDENTS/INTEREST    |
        | Borrower Total Monthly Income |

    @passInfo
    Scenario Outline:
      When the user is redirected to the Employment and Income page
      And the user enters employer name
      And the user enters info as "<GrossMonthIncome>" and "<MonthOvertime>" and "<MonthBonuses>" and "<MonthComm>" and "<MonthDivi>"
      Then the user clicks next button

    Examples:
      | GrossMonthIncome | MonthOvertime | MonthBonuses | MonthComm | MonthDivi |
      | 120                         | 12099                         | 43432                      | 4222                            | 232323                      |
#      | 120434                      | 1209932                       | 43432212                   | 4222121                         | 2323231212                  |
#      | 12012121                    | 1                             | 4343212                    | 422212                          | 232323                      |
#      | 120                         | 12099                         | 43432                      | 4222                            | 232323                      |
#      | String                      | asa                           | sdasd                      | asdasd                          | asdasd                      |
#      | 0                           | 0                             |                            | 0                               | 0                           |
#      | 120121211313213123123213213 | 12312312312312321312312312321 | 23424234823432423423423423 | 1232132132131231231232131231231 | 213123123123123123123123123 |
#      | -120                        | -12099                        | -43432                     | -4222                           | -232323                     |


  Scenario:
    When the user is redirected to the Employment and Income page
    And the user enters employer name
    Then GROSS MONTHLY INCOME should be a required input field.


  Scenario Outline:
    When the user is redirected to the Employment and Income page
    And the user enters employer name
    And the user enters info as "<GrossMonthIncome>" and "<MonthOvertime>" and "<MonthBonuses>" and "<MonthComm>" and "<MonthDivi>"
    Then the Borrower Total Monthly Income field should be automatically calculated based on the "<GrossMonthIncome>" and "<MonthOvertime>" and "<MonthBonuses>" and "<MonthComm>" and "<MonthDivi>".

    Examples:
      | GrossMonthIncome | MonthOvertime | MonthBonuses | MonthComm | MonthDivi |
      | 100              | 100           | 100          | 100       | 100       |


  Scenario:
    When the user is redirected to the Employment and Income page
    Then Additional Gross Monthly Income section should contain three sets of INCOME SOURCE dropdowns and Amount fields.

  @working
  Scenario:
    When the user is redirected to the Employment and Income page
    Then INCOME SOURCE dropdown should have Alimony Child Support, Social Security Disability Income, Unemployment Benefits, Interest and Dividends, VA Compensation, Royalty Payments and Other Types of Income options.

















