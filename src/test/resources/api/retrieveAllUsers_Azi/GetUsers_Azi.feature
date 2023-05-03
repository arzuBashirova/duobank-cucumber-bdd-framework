
Feature: GET /users As a user of the mortgage application,
  I want to be able to retrieve a list of all users of the application through an API endpoint
  so that I can perform analysis on the user data.


@api
Scenario:The API endpoint should be accessible through a HTTP GET request to '/users'.

  Given the request is authenticated with a valid API key
  When I send a "GET" request to the end point "/users"
  Then the response status code should be 200


  @api
  Scenario: The API endpoint should require authentication via API key. If API key is not provided,
  401 Unauthorized status code with error message should be displayed.

    Given the api key doesn't provide
    When I send a "GET" request to the end point "/users"
    Then 401 Unauthorized status code with error message should be displayed

    @api
    Scenario: The API endpoint should return a JSON response.
      Given the request made with valid API key
      When I send a "GET" request to the end point "/users" to get the all users data
      Then the "Content-type" header is set to "application/json"