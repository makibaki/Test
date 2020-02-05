Feature: file

  Scenario Outline: a few cukes
    Given Open the Firefox and launch the application
    When I wait <arg1> hour
    Then my belly should growl
    Examples:
      | arg1 | cukes |
      | 1    |  42   |
      | 5    |  55   |