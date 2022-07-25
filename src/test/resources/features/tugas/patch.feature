Feature: Patch method request

  @regression
  Scenario Outline: Patch update user
    Given Patch update user with id "<id>" valid json file
    When Send request patch update user
    Then Status coded should be 200
    And Response body should contain name "DhandyJoe-Updated" and "QA Engineer"
    And Patch update user assert json validation
    Examples:
      |id   |
      |1    |
