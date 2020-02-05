Feature: login

  Scenario Outline: login
    Given Open the Firefox and launch the application
    When Enter the Username <username> and Password <password>
    Then Click Login button
    Examples:
      | username                | password      |
      | smaric@smithmicro.com   |  Berlineta1!  |
      | 5                       |  55           |