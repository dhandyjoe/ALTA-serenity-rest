Feature: Put method request

  @regression
  Scenario Outline: Put update user with name key only
    Given Put update user with id "<id>" invalid json file
    When Send request put update user
    Then Status coded should be 200
    And Response body should contain name "DhandyJoe-Updated"
    And Put update user assert invalid json validation
    Examples:
      |id   |
      |1    |
