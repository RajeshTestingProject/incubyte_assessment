Feature: Account creation on Magento website

  Background:
    Given I open the Magento homepage
    When I click on the Create an Account button for new account creation

  Scenario Outline: Successful account creation with valid details
    And I enter valid details "<FirstName>", "<LastName>","<Email>" and "<Password>" to create a new account
    And I submit on Create an Account details button
    Then I should see a confirmation message that the account is created successfully
    Examples:
      | FirstName |  | LastName |  | Email                   |  | Password    |
      | Kimber    |  | Border   |  | kimber.border@gmail.com |  | Password@14 |

  Scenario Outline: Account creation with missing required fields
    And I enter valid details "<FirstName>", "<LastName>" and the email "<Email>",password "<Password>" fields are empty
    And I submit on Create an Account details button
    Then I should see an error message indicating missing fields
    Examples:
      | FirstName |  | LastName |  | Email |  | Password |
      | Demo      |  | DemoTest |  |       |  |          |

  Scenario: Account creation with invalid email format
    And I enter valid details "testFName", "testLName" and enter an invalid email "testname@com" and a valid password "Testuser@123"
    And I submit on Create an Account details button
    Then I should see an error message indicating the invalid email format

   Scenario: Account creation with mismatched passwords
    And I enter valid details fname "testFName", lname "testLName", email "testname@gmail.com" and password "Testuser@123"
    And I enter a mismatched confirm password "Password1120"
    And I submit on Create an Account details button
    Then I should see an error message indicating the passwords do not match

  Scenario: Account creation with already registered email
    And I enter valid details fname "testFName", lname "testLName", email "kimber.border@gmail.com" and password "Password@14"
    And I submit on Create an Account details button
    Then I should see an error message indicating the email is already registered
