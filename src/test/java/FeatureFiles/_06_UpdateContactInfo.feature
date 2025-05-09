Feature: Update Contact Info

  Background:
    Given User is on the ParaBank Login Page
    When User login with valid credentials

  Scenario: Update Contact Info With Valid Contact İnfo
    And Navigate to the update contact info page
    And Update profile field with new valid data
    And Click the update profile button
    Then Profile Updated message should be visible appear

  Scenario: Update Contact Info With Invalid Contact İnfo
    And Navigate to the update contact info page
    And And Leave profile fields empty or enter invalid data
    And Click the update profile button
    Then is required message(s) should appear

