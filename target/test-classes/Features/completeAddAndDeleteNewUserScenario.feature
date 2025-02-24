
Feature: User Management in OrangeHRM

  Scenario Outline: Navigate to Admin Page
    Given I log in with username "<username>" and password "<password>"
    When I navigate to the Admin tab
    Then I should be on the Admin page

  Examples:
    | username | password  |
    | Admin    | admin123  |

  Scenario Outline: Add a new user and verify the record count increases
    Given I am on the Admin page
    When I get the initial number of records
    And I click on the add button
    And I select a user role
    And I select user status
    And I fill in the required fields with employee name "<employeeName>", password "<password>", new username "<newUserName>", and user password "<userPassword>"
    And I save the user details
    Then the number of records should increase by 1

  Examples:
    | employeeName | password  | newUserName | userPassword |
    | Emily Jones  | admin123  | Admin3      | admin123     |

  Scenario Outline: Search for and delete the new user
    Given I am on the Admin page
    When I get the current number of records
    And I search for the user "<searchTarget>"
    And I delete the user
    And I refresh the page
    Then the number of records should decrease by 1

  Examples:
    | searchTarget |
    | Admin3       |
