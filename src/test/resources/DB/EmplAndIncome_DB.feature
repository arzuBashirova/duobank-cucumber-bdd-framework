@DB
Feature: Employment and income
  As a user of the Duobank Mortgage Application, I want my employment and income details to be
  securely stored in the database, so that I can easily provide and update this information through the
  Employment and Income page of the application.

  @EmpDB1
  Scenario: The database should have a table labeled “tbl_mortgage” that contains the following columns:
  employer_name, position, city, state, start_date, end_date, current_job, co_employer_name,
  co_position, co_city, co_state, co_start_date, co_end_date, co_current_job,
  gross_monthly_income, monthly_overtime, monthly_bonuses, monthly_commissions,
  monthly_dividends, c_gross_monthly_income, c_monthly_overtime, c_monthly_bonuses,
  c_monthly_commissions, c_monthly_dividends, add_belong, income_source, and amount.
    Given Database should contain the columns for Employments page
      |employer_name|
      |position|
      |city|
      |state|
      |start_date|
      |end_date|
      |current_job|
      |co_employer_name|
      |co_position|
      |co_city|
      |co_state|
      |co_start_date|
      |co_end_date|
      |co_current_job|
      |gross_monthly_income|
      |monthly_over_time|
      |monthly_bonuses|
      |monthly_commision|
      |monthly_dividents|
      |c_gross_monthly_income|
      |c_monthly_over_time|
      |c_monthly_bonuses|
      |c_monthly_commision|
      |c_monthly_dividents|
      |add_belong|
      |income_source|
      |amount|

  @EmpDB2
  Scenario: The "employer_name" and “gross_monthly_income” columns should be required and not empty.
    Given The database should have name and income values and not be null

    @EmpDB3
    Scenario:The fields should be mapped to their corresponding columns in the “tbl_mortagage” table
    in the database.
      Given The user filling out employment form
        | employer_name | gross_monthly_income |
        | Duotech2023   | 10000                |
