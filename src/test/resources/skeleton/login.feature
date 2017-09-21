Feature: login

  Scenario: login successfully
    Given I am on the login page
    When enter a valid username and password
    Then i am redirected to the dashboard page
