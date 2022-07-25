Feature: Post method request

  @regression
  Scenario: Post register success
    Given Post register with valid json file
    When Send request post register user
    Then Status code should be 200
    And Response body should contain id 4 and token "QpwL5tke4Pnpja7X4"
    And Post register user assert json validation

  @regression
  Scenario: Post register unsuccess
    Given Post register with invalid json file
    When Send request post register user
    Then Status code should be 400
    And Response body should contain error "Missing password"
    And Post unsuccess register user assert json validation

  @regression
  Scenario: Post login success
    Given Post login with valid json file
    When Send request post login user
    Then Status code should be 200
    And Response body should contain token "QpwL5tke4Pnpja7X4"
    And Post success login user assert json validation

  @regression
  Scenario: Post login unsuccess
    Given Post login with invalid json file
    When Send request post login user
    Then Status code should be 400
    And Response body should contain error "Missing password"
    And Post unsuccess login user assert json validation