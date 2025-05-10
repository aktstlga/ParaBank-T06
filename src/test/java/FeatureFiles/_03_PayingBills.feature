@Smoke @Regression @Payment
Feature: Invoice Payment functionality

  Background:
    Given Navigate to ParaBank Site
    And Navigate to Register Site
    When Enter Signing Up Informations and click on Register button
    Then User should register and login successfully


  Scenario: Paying different types of invoices
    Given The user navigates to ParaBank homepage
    When The user logs in with valid credentials
    Then The Account Overview page is displayed
    And The User notes the current account balance
    When Clicks billpay button
    Then The User fills the invoice payment form
    And Success message should be displayed
    When Verifies against user invoice
    Then Clicks account overview button
    And The User looks at last account activity
    When The User confirms that funds have been withdrawn from the account