Feature: Select Langauge
  Scenario Outline: Select language based on preference
    Given I am at home page
    When  I select language from dropdown as <language>
    Then  Verify that language change is reflected in url


    Examples:
      | language         |
      | Bahasa Indonesia |






