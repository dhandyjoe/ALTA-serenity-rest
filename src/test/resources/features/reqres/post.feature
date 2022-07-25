Feature: Post method request

  @regression
  Scenario: Post create user
    Given Post create new user with valid json file
    When Send request post create user
    Then Status code should be 201 Created
    And Response body should contain name "DhandyJoe" and "QA Engineer"
    And Post create user assert json validation