Feature: Invoice Payment functionality

  Background:
    Given Navigate to ParaBank Site
    And Navigate to Register Site
    When Enter Signing Up Informations and click on Register button
    Then User should register and login successfully


  Scenario: Paying different types of invoices
    Given the user navigates to ParaBank homepage
    When the user logs in with valid credentials
    Then the Account Overview page is displayed
    And user notes the current account balace
    When Cliks billpay button
    Then User fills the invoice payment form
    When Success message should be displayed
    Then Click account overview button
    When User confirms that funds have been withdrawn from the account