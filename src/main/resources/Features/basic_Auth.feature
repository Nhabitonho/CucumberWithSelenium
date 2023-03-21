#Author
#Date
#Description
@AuthFeature
Feature: Feature to test login function

  @AuthTest
  Scenario: Check log in is successful in the Basic auth page
    Given user navigate to the Basic auth page
    When user enters the valid username and password
    Then user is logged in and directed to the Basic auth page
