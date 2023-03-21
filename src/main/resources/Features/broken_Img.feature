#Author
#Date
#Description
@BrokenImgFeature
Feature: Feature to test login function

  @BrokenImgTest
  Scenario: Check broken img in the broken img page
    Given user navigate to the broken img page
    When user check the broken img
    And check title of the page
