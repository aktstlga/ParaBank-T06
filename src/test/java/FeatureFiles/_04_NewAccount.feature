@Smoke @Regression @Accounts
Feature: New Account functionality

  Background:
    Given Navigate to ParaBank Site
    And Navigate to Register Site
    When Enter Signing Up Informations and click on Register button
    Then User should register and login successfully

  Scenario: Checking Account
    Given the user navigates to ParaBank homepage
    When the user logs in with valid credentials
    Then the Account Overview page is displayed
    When the user navigates to the New Account page
    And the user selects account type "CHECKING"
    And the user selects a valid existing account to transfer minimum balance
    And the user clicks on Open New Account button
    Then a new checking account should be created successfully
    And the user should see the new account number

  Scenario: Savings Account
    Given the user navigates to ParaBank homepage
    When the user logs in with valid credentials
    Then the Account Overview page is displayed
    When the user navigates to the New Account page
    And the user selects account type "SAVINGS"
    And the user selects a valid existing account to transfer minimum balance
    And the user clicks on Open New Account button
    Then a new savings account should be created successfully
    And the user should see the new account number