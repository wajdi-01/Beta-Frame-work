
  Feature: BETA Login to the application

    @TestOne
    Scenario: Successful Login
      Given the user is on the login page
      When the user enters valid username  and password
      And clicks the login button
     Then the user should be redirected to the dashboard

    @TestTow
     Scenario: Failed Login
      Given the user is on the login page
      When the user enters invalid username  and password
      And clicks the login button
      Then an error message should be displayed

