
Feature: alpha test
  @TestThree
  Scenario: Failure login
    Given the user is on the login page
    When the user enters invalid username  and password
    And clicks on the login button
    Then The error message should be displayed, indicating a failed login