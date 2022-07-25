Feature: Get method request

  @smoke
  Scenario Outline: Get single user
    Given Get single user with id "<id>"
    When Send request get single user
    Then Status coded should be 200
    And Response body single user should contain "<firstName>" and "<lastName>"
    And Get single user assert json validation
    Examples:
      |id  | firstName  | lastName  |
      |1   | George     | Bluth     |
      |2   | Janet      | Weaver    |

  @smoke
  Scenario Outline: Get single user not found
    Given Get single user with id "<id>"
    When Send request get single user
    Then Status coded should be 404
    Examples:
      |id   |
      |23   |

  @smoke
  Scenario Outline: Get list resource
    Given Get list resource
    When Send request get list resource
    Then Status coded should be 200
    And Response body resource should contain "<name>" and <year>
    And Get list resource assert json validation
    Examples:
      | name      | year  |
      | cerulean  | 2000  |

  @smoke
  Scenario: Get single resource
    Given Get single resource with id "1"
    When Send request get single resource
    Then Status coded should be 200
    And Get single resource assert json validation

  @smoke
  Scenario: Get single resource not found
    Given Get single resource with id "23"
    When Send request get single resource
    Then Status coded should be 404

