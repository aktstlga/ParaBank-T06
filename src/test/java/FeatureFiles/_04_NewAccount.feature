Feature: New Account functionality

  Background:
    Given the user logs in with credentials from config

  Scenario: Checking Account
    When the user navigates to the New Account page
    And the user selects account type "CHECKING"
    And the user selects a valid existing account to transfer minimum balance
    And the user clicks on Open New Account button
    Then a new checking account should be created successfully
    And the user should see the new account number

  Scenario: Savings Account
    When the user navigates to the New Account page
    And the user selects account type "SAVINGS"
    And the user selects a valid existing account to transfer minimum balance
    And the user clicks on Open New Account button
    Then a new savings account should be created successfully
    And the user should see the new account number