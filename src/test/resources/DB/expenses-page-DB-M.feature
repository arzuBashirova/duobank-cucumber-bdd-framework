@DB
Feature: Expenses page DB feature

  The database schema should have tbl_mortagage table that can store user information  related to their living situation and expenses
  such as rent_own_status, monthly_rental_payment, first_mortagage_total_payment.




  @DB_only
  Scenario: The database schema should have tbl_mortagage table that can store user information
    When  I send a request to retrieve user information from tbl_mortagage table
    Then It should be the following column names

      | rent_own_status               |
      | monthly_rental_payment        |
      | first_mortagage_total_payment |

















