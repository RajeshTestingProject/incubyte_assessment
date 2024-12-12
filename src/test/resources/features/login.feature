Feature: User login on Magento website

  Background:
    Given I open the Magento application page
    When I clicked on the Sign In link

  Scenario: Successful login with valid credentials
    When I have entered a valid username "kimber.border@gmail.com" and password "Password@14"
    And I click on the login button
    Then I should be logged in successfully
    And I click on the logout button

  Scenario: Login with incorrect password
    And I have entered "kimber.border@gmail.com" as the email and "WrongPassword1120" as the password
    And I click on the login button
    Then I should see an error message incorrect log  in details

  Scenario: Login with unregistered email
    And I have entered "dummyemail@gmail.com" as the email and "Password123" as the password
    And I click on the login button
    Then I should see an error message incorrect log  in details
