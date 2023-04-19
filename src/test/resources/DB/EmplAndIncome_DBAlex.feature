@DB
Feature: As a user of the Duobank Mortgage Application,
  I want my employment and income details to be  securely stored in the database,
  so that I can easily provide and update this information through the  Employment and Income page of the application. Part2

  @Alex1

  Scenario: The "state" column should store two-letter abbreviations of US states
    Given Database should contain states abbreviations

  Scenario: Filling out form on the UI side with different choices of income
    Then User fills out the form with different income sources

  @db_only1
  Scenario: The "income_source" column should only contain any of the following: Alimony/Child Support,
  Social Security/Disability Income, Unemployment Benefits, Interest and Dividends, VA
  Compensation, Royalty Payments, and Other Types of Income
    Then Database income source table should have one the following
      |Alimony/Child Support            |
      |Social Security/Disability Income|
      |Unemployment Benefits            |
      |Interest and Dividends           |
      |VA Compensation                  |
      |Royalty Payments                 |
      |Other Types of Income            |

  @mapping1
  Scenario: Upon successful submission of the page information, the "Employment and income details"
  page form fields should be mapped to their corresponding columns in the “tbl_mortagage” table
  in the database.
    Given The user filling out employment form
      |employer_name   |position  |city       |state|start_date|gross_monthly_income|monthly_overtime|monthly_bonuses|monthly_commision|monthly_dividents|income_source        |amount|
      |Consulting LLC  |accountant|Arlington  |VA   |2016-02-02|5000                |100             |500            |200                |1000             |Other Types of Income|10000 |
    Then Database should have the entered by user information mapped accordingly
      |employer_name   |position  |city       |state|start_date|gross_monthly_income|monthly_overtime|monthly_bonuses|monthly_commision|monthly_dividents|income_source        |amount|
      |Consulting LLC  |accountant|Arlington  |VA   |2016-02-02|5000                |100             |500            |200                |1000             |Other Types of Income|10000 |