Feature: New Account functionality

  Background:
  Scenario: Login with valid credentials
    When the user logs in with "<username>" and "<password>"
    Then the Account Overview page is displayed

  Scenario: Checking Account
    When the user navigates to the Open New Account page
    And the user selects account type "CHECKING"
    And the user selects a valid existing account to transfer minimum balance
    And the user clicks on Open New Account button
    Then a new checking account should be created successfully
    And the user should see the new account number

  Scenario: Savings Account
    When the user navigates to the Open New Account page
    And the user selects account type "SAVINGS"
    And the user selects a valid existing account to transfer minimum balance
    And the user clicks on Open New Account button
    Then a new savings account should be created successfully
    And the user should see the new account number