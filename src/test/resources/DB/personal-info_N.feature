@DB_Nigar
  Feature: As a user of Duobank Mortgage Application, I want to store the personal information of the borrower
    and co-borrower (if applicable) entered on the Personal Information page of the mortgage application form in the database.

#    Background: Common steps for all scenarios in Personal Information page
#
#      Given The user is on the Personal Information page of the mortgage application
@DB
      Scenario: Store the users personal information
        When user logins to the website
        Then user should click "Mortgage Application" button
        Then user should fill Preapproval Details info
        Then user should fill out borrower's and co-borrower's personal information
        Then databse should store borrower's and co-borroser's personal information


