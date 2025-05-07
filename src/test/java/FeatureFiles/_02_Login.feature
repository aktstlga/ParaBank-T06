# src/test/java/FeatureFiles/_02_Login.feature

Feature: Login functionality

  @Positive
  Scenario Outline: Login with valid credentials
    Given the user navigates to ParaBank homepage
    When the user logs in with "<user>" and "<pass>"
    Then the Account Overview page is displayed
    And the user logs out

    Examples:
      | user | pass   |
      | brs  | 123456 |

  @Negative
  Scenario Outline: Login with invalid credentials
    Given the user navigates to ParaBank homepage
    When the user logs in with "<user>" and "<pass>"
    Then an authentication error message is shown

    Examples:
      | user | pass   |
      | sncr | 111111 |
