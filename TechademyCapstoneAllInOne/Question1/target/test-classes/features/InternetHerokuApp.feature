Feature: Testing Internet HerokuApp functionalities
  Background:
    Given I launch the HerokuApp website

  Scenario: Verify Title and Navigate Pages
    Then I verify the page title is "The Internet"

  Scenario: Verify A/B Testing Page
    When I click on AB Testing link
    Then I verify the text on the page is "A/B Test Variation 1"
    And I navigate back to Home page

  Scenario: Select Dropdown Option
    When I click on Dropdown link
    And I select "Option 1" from the dropdown
    Then I verify "Option 1" is selected

  Scenario: Verify Frames Page Links
    When I click on Frames link
    Then I verify the "Nested Frames" link is present
    Then I verify the "iFrame" link is present
