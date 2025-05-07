Feature: Login functionality for ParaBank

  Background:
    Given the user navigates to ParaBank homepage

  @Positive
  Scenario: Login with valid credentials
    When the user logs in with "<username>" and "<password>"
    Then the Account Overview page is displayed

  @Negative
  Scenario: Login with invalid credentials
    When the user logs in with "<username>" and "<password>"
    Then an authentication error message is shown
