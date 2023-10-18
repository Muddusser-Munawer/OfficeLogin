Feature: Feature to test Sauce Demo Website

Scenario: Validate Saucedemo website is working
  Given user open a browser
  And user is on saucedemo page
  When user enter username and password field
  And Hit Login Button
  Then User navigate to Homepage
  And Select Filters Options
  Then add products to the cart
  And  remove products to the cart
