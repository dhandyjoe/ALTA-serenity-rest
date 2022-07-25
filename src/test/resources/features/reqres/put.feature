Feature: Put method request

  @regression
  Scenario Outline: Put update user
    Given Put update user with id "<id>" valid json file
    When Send request put update user
    Then Status coded should be 200
    And Response body should contain name "DhandyJoe-Updated" and "QA Engineer"
    And Put update user assert json validation
    Examples:
      |id   |
      |1    |
