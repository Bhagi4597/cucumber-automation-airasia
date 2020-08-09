Feature: Check flight status

  Scenario Outline: check flight status
    Given on home page
    When  I click on the Flights status
    Then  I should be at the Flights status page
    And   Enter the flight number as <flight number>
    And   I click on find flights
    Then  I should be at status result page

    Examples:
      | flight number |
      | AK6117        |






