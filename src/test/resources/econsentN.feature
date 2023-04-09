Feature:Consent to do business electronically

  Background: Common steps for all scenarios in Econsent page

    Given The user is on the Econsent page

@Nigar
  Scenario:User should see Agree Button
    Then user should see "Agree" button selected by default
    When user don't agree to the terms and conditions of the econsent
    Then the user should click Don't Agree button

@Nigar
Scenario:User clicks Don't Agree button
  When user selects the Don't Agree button
  Then user should be directed back to the main application

@Nigar
Scenario: User clicks Agree button
  When user selects Agree button
  Then user should proceed to next section

@Nigar
  Scenario: User doesn't select any button
    When user don't select any radio buttons
    Then user see an error message





