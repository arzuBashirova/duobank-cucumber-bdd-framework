Feature: As a user, I want to be use the Credit Report page of DMA to allow my bank to verify my loan eligibility.

  Background: User is logged in to DMA

  @testMohina

    Scenario: User is able to navigate to the Credit Report page

    Given The user is logged in and able to navigate through the pages to get to the Credit Report page
      When The user is signed in, they are able to navigate through the pages
        Then The user is able to get to the Credit Report page


      When the user is on the required page and chooses yes
      Then a third party website will open in a new tab

      When the user chooses no
      Then no third party website is opened