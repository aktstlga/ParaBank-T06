Feature:Money Transfer functionality

  Background:
    Given Navigate to ParaBank Site
    And Navigate to Register Site
    When Enter Signing Up Informations and click on Register button
    Then User should register and login successfully

  Scenario: transfer money to account
    Given Navigate to ParaBank Site
    When the user logs in with valid credentials
    And Click on a new open account
    Then Then transfer the money
