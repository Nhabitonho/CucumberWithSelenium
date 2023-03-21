#Author
#Date
#Description
@SmokeFeature
Feature: Feature to test login function

  @SmokeTest
  Scenario Outline: Check log in is successful in the form auth page
    Given user navigate to the form auth page
    When user enters the valid "<username>" and "<password>"
    And clicks on login button
    Then user is logged in and directed to the form auth page
    When user click logout button
    Then user is logout the form auth page
    Examples:
      | username   | password             |
      | tomsmith   | SuperSecretPassword! |
      | tomsmith1  | SuperSecretPassword! |


  @RegressionTest
  Scenario Outline: Check log in is successful in the form auth page
    Given user navigate to the form auth page
    When user enters the valid "<username>" and "<password>"
    And clicks on login button
    Then user is logged in and directed to the form auth page

    Examples:
      | username   | password             |
      | tomsmith   | SuperSecretPassword! |
      | tomsmith1  | SuperSecretPassword! |
