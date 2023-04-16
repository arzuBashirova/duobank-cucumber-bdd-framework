@DB
Feature: Expenses page DB feature

  The database schema should have tbl_mortagage table that can store user information  related to their living situation and expenses
  such as rent_own_status, monthly_rental_payment, first_mortagage_total_payment.




  @db_only
  Scenario: The database schema should have tbl_mortagage table that can store user information
    When  I send a request to retrieve information from tbl_mortagage table
    Then It should be the following column names

      | rent_own_status               |
      | monthly_rental_payment        |
      | first_mortagage_total_payment |

  @db_only
  Scenario: The rent_own_status column should only allow two values, Rent and Own.
    When  I send a request to retrieve rent_own_status column details from tbl_mortagage table
    Then It should have the following details

      | Rent |
      | Own  |
#      | My  |

  @db_only
  Scenario: The monthly_rental_payment field should only allow positive numeric values.
    When  I send a request to retrieve monthly_rental_payment column details from tbl_mortagage table
    Then It should have the following details for monthly_rental_payment column



  @db_only
  Scenario: The first_mortgage_total_payment field should only allow positive numeric values.
    When  I send a request to retrieve first_mortgage_total_payment column details from tbl_mortagage table
    Then It should have the following details for first_mortgage_total_payment column




















