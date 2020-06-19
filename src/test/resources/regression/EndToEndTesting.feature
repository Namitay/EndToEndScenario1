Feature: End to end feature


  Scenario Outline: Create an order as a existing user

    Given I navigate to url
    When I click on login link from nav bar
    Then  I should be navigated to login page
    When I enter user name "<email>"
    And   I enter password "<password>"
    And    I click on login button
    Then  I should be logged in successfully
    When  I add item in to the cart
    And   I go to the cart
    And   I click on terms of service
    And   I checkout as a existing user
    Then   I click on continue
    When I click on continue second again
    And I click on credit card
    And I click on continue again third time
    And  I select credit card
    And  I enter cardholder name "<name>"
    And  I enter a card number "<number>"
    And  I select a month
    And  I select a year
    And I enter a card code "<code>"
    And I click on continue fourth time
    And I click on confirm
    Then I should see the order confirmation message

    Examples:
    |email|password|name|number|code|
    |ny@gmail.com|timh123|Namita Yelwande|4111111111111111|494|