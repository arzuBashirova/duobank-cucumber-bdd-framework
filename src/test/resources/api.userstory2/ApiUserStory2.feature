Feature:  GET /user As a user of the mortgage application,
  I want to be able to retrieve a specific user's information by ID through an API endpoint.

  @get_user1
  Scenario: Retrieve user information by valid ID
    Given I have a valid API key
    When I send a GET request to "/user" with a valid user ID as a query parameter
    Then the response status code should be 200
    And the response Content-Type header should be "application/json"
    And the response body should contain the following fields:
      | id         | [valid user ID]   |
      | first_name| [user first name] |
      | last_name | [user last name]  |
      | email     | [user email]      |
      | created_at| [user created timestamp] |
      | modified_at| [user last modified timestamp] |
      | type      | [user type]       |
      | active    | [user active status] |

  @get_user2

  Scenario: Retrieve user information with invalid or missing ID
    Given I have a valid API key
    When I send a GET request to "/user" with an invalid or missing user ID as a query parameter
    Then response status code should be 400 or 404
    And the response Content-Type header should be "application/json"
    And the response body should contain an error message
