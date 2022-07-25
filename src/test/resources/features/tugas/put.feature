Feature: Put method request

  @regression
  Scenario Outline: Put update user with name key only
    Given Put update user with id "<id>" name key only json file
    When Send request put update user
    Then Status coded should be 200
    And Response body should contain name "DhandyJoe-Updated"
    And Put update user assert name key only json validation
    Examples:
      |id   |
      |1    |

  @regression
  Scenario Outline: Put update user with job key only
    Given Put update user with id "<id>" job key only json file
    When Send request put update user
    Then Status coded should be 200
    And Response body should contain job "QA Engineer"
    And Put update user assert job key only json validation
    Examples:
      |id   |
      |1    |

