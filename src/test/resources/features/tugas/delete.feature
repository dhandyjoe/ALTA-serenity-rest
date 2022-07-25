Feature: Delete method request

  @regression
  Scenario Outline: Delete user with invalid id
    Given Delete user with id "<id>"
    When Send request delete user
    Then Status code should be 204
    Examples:
      |id       |
      |asdas    |
      |qwe      |