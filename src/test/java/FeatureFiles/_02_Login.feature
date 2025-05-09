# src/test/java/FeatureFiles/_02_Login.feature

Feature: Login functionality

  Background:
    Given Navigate to ParaBank Site
    And Navigate to Register Site
    When Enter Signing Up Informations and click on Register button
    Then User should register and login successfully

  @Positive
  Scenario: Login with valid credentials
    Given the user navigates to ParaBank homepage
    When the user logs in with valid credentials
    Then the Account Overview page is displayed
    And the user logs out


  @Negative
  Scenario: Login with invalid credentials
    Given the user navigates to ParaBank homepage
    When the user logs in with invalid credentials
    Then an authentication error message is shown