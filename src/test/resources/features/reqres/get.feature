Feature: Get method request

  @smoke @regression
  Scenario Outline: Get list user
    Given Get list user with parameter "<parameter>"
    When Send request get list user
    Then Status coded should be 200
    And Response body should contain "<firstName>" and "<lastName>"
    And Get list user assert json validation
    Examples:
      |parameter  | firstName | lastName  |
      |1          | George    | Bluth     |
      |2          | Michael   | Lawson    |

