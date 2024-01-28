
Feature: Bank User login
  

  @tag1
  Scenario: Login to the Bank throgh web browser 
    Given user enter the bank url in browser
    And given valid username and password
    Then clicks on login button
    