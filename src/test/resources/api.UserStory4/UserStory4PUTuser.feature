Feature: User Story 4 – PUT /user

  As a mortgage application user,
  I want to be able to update my personal information through an API endpoint,
  so that my information is accurate and up-to-date.



  Scenario: User should be able to update his personal information
    Given the request is authenticated with a valid API key
    And  And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "51"
    And the body is set to the following

     """
     {
     "username": "",
     "first_name": "",
     "last_name": "",
      "email": ""
     }
     """
    When I send a "PUT" request to the endpoint "/user".
    Then the response status code should be 200
    And The API endpoint updates the modified_at field in the database to reflect the date and time the user information was last modified.
    And The response time for a single user request should be less than 2000 ms.
    And the response body key "message" should be "User updated successfully"




  Scenario: Missing api key
    Given the request is not authenticated with a valid API key
    And  And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "51"
    And the body is set to the following

     """
     {
     "username": "",
     "first_name": "",
     "last_name": "",
      "email": ""
     }
     """
    When I send a "PUT" request to the endpoint "/user".
    Then the response status code should be 401
    And The API endpoint updates the modified_at field in the database to reflect the date and time the user information was last modified.
    And The response time for a single user request should be less than 1000 ms.
    And the response body key "message" should be "Invalid or missing API Key. Provide a valid api key with 'api_key' query parameter."


  Scenario: Invalid Id
    Given the request is authenticated with a valid API key
    And  And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "sss"
    And the body is set to the following

     """
     {
     "username": "",
     "first_name": "",
     "last_name": "",
      "email": ""
     }
     """
    When I send a "PUT" request to the endpoint "/user".
    Then the response status code should be 400
    And The API endpoint updates the modified_at field in the database to reflect the date and time the user information was last modified.
    And The response time for a single user request should be less than 1000 ms.
    And the response body key "message" should be "Invalid or missing ID"


  Scenario: Missing Body
    Given the request is authenticated with a valid API key
    And  And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "51"
    And the body is set to the following

     """
     {

     "last_name": "",
     "email": ""
     }
     """
    When I send a "PUT" request to the endpoint "/user".
    Then the response status code should be 422
    And The API endpoint updates the modified_at field in the database to reflect the date and time the user information was last modified.
    And The response time for a single user request should be less than 1000 ms.
    And the response body key "message" should be "Missing or Invalid Required Fields!"



  Scenario: Id doesn't exist
    Given the request is authenticated with a valid API key
    And  And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "51"
    And the body is set to the following

     """
     {
     "username": "",
     "first_name": "",
     "last_name": "",
      "email": ""
     }
     """
    When I send a "PUT" request to the endpoint "/user".
    Then the response status code should be 404
    And The API endpoint updates the modified_at field in the database to reflect the date and time the user information was last modified.
    And The response time for a single user request should be less than 1000 ms.
    And the response body key "message" should be "User not found"


