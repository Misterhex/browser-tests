Feature: Login

  Scenario Outline: Login to Acqo
    Given I am on Acqo login page
    When I enter <username> and <password> in the form
    Then I enter <twoFactorCode> code on the mfa screen
    Then I am redirected to the dashboard page

  Examples:
    |  username             |  password     |  twoFactorCode    |
    |  user@acuocpty.com    |  @Password1   |  123456           |
