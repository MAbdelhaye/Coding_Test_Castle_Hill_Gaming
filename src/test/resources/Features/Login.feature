Feature: As a Swag Labs customer who is not locked out,
  			I need to be able to log in so
  			that I can purchase Sauce Labs merch

  @Test
  Scenario: Successful Login
    Given I am on the Sauce Demo Login Page
    When I fill the account information for account StandardUser into the "standard_user" field and the "secret_sauce" field
    And I click the Login Button
    Then I am redirected to the Sauce Demo Main Page
    And I verify the App Logo exists

  @Test
  Scenario: Failed Login
    Given I am on the Sauce Demo Login Page
    When I fill the account information for account LockedOutUser into the "locked_out_user" field and the "secret_sauce" field
    And I click the Login Button
    Then verify the Error Message contains the text "Sorry, this user has been banned."
