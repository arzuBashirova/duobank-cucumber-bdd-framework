@DB_Nigar
  Feature: As a user of Duobank Mortgage Application, I want to store the personal information of the borrower
    and co-borrower (if applicable) entered on the Personal Information page of the mortgage application form in the database.


      Scenario: Store the users personal information
        When user logins to the website
        Then user should click "Mortgage Application" button
        Then user should fill Preapproval Details info
        Then user should fill out borrower's and co-borrower's personal information
        Then database should store borrower's personal information

    Scenario: Store the users personal information
      When user logins to the website
      Then user should click "Mortgage Application" button
      Then user should fill Preapproval Details info
      Then user should fill out borrower's and co-borrower's personal information
      Then database should store co-borrower's personal information


  Scenario: Table in db should have columns
  When users added personal information
  Then database should have columns

  |apply_co_borrower|
  |b_firstName      |
  |b_middleName     |
  |b_lastName       |
  |b_suffix         |
  |b_email          |
  |b_dob            |
  |b_ssn            |
  |b_marital        |
  |b_cell           |
  |b_home           |

    Scenario: Table in db should have columns
      When users added pre-approval details
      Then database columns should indicate that
        | id                   |
        | realtor_status       |
        | realtor_info         |
        | loan_officer_status  |
        | purpose_loan         |
        | est_purchase_price   |
        | down_payment         |
        | down_payment_percent |
        | total_loan_amount    |
        | src_down_payment      |
        | add_fund_available   |


    @DB
   Scenario: Coborrowers info should match
      When user logins to the website
      Then user should click "Mortgage Application" button
      Then user should fill Preapproval Details info
      Then user should fill out coborrower's information
  | c_firstName| c_lastName |c_email          |c_dob      |c_ssn       |
   |Coco        | Chanel     |chanel@gmail.com | 06/28/1989| 123-45-8796|

  Then the user can see the entered details in the following corresponding columns of the tbl_mortagage table
    | c_firstName| c_lastName   |c_email          |c_dob      |c_ssn       |
    |Coco        |  Chanel     |chanel@gmail.com | 06/28/1989| 123-45-8796|

      And the name "Coco" should be cleaned up in the database

