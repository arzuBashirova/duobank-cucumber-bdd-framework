Feature: Application tracking through DMA

  Background: Common steps for all scenarios here

    Given The user is on the logging page
    When User entering email and password
    Then User should be logged in
    And User navigates to the Application List page

    @firstNilu
  Scenario: User can view submitted applications
    Given The user is on the Application List page
    Then The user should see a table with columns for
      | Loan ID | Borrower Name | Loan Amount | Loan Details |
    And The table should display a maximum of 10 entries by default
    And The user can select the number of entries to show from a dropdown with options of 10, 25, 50, and 100
    And The user can enter a search term in the search field to filter the results based on the search term
    And The loan id should be an integer number
    And The borrower name should be displayed in the format of first name, last name
    And The loan amount should be displayed in US dollars and should be an integer
    And The loan details column should have a View Details button that should take the user to a page with loan details
    And The table should have sorting functionality for each column
    And Pagination should be available if the number of entries exceeds the selected "show entries" option

  @second
  Scenario: User can view loan details
    Given The user is on the Application List page
    When The user clicks on the View Details button for a specific loan
    Then The user should be taken to a page with loan details
    And The information displayed on the loan details page should match what the user entered previously
    And The user can navigate back to the Application Tracking page

  @third
  Scenario: User can sort the table by columns
    Given The user is on the Application List page
    When The user clicks on a column header
    Then The table should be sorted by that column in ascending order
    And When the user clicks on the same column header again
    Then The table should be sorted by that column in descending order

  @fourth
  Scenario: User can navigate to other pages using pagination
    Given The user is on the Application List page
    When The number of entries exceeds the selected "show entries" option
    Then The table should display pagination links to navigate to other pages