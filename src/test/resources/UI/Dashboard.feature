

  Feature: Dashboard feature

    As a user who has applied for a mortgage with a bank, I want to be able to access the dashboard page of the bank's mortgage application system so that I can view my account information, apply for a new mortgage, and view a list of my previous mortgage applications.

    Scenario: User clicks on the DuoBank logo
      Given the user is on the Mortgage Application page
      When the user clicks on DuoBank logo
      Then the user is redirected to the main page of DuoBank


    Scenario: User clicks on profile picture
      Given the user is on the main page
      When clicks on profile picture on top right corner of the page
      And the user clicks on "Logout" link
      Then the user is redirected out the system to the sign in page


