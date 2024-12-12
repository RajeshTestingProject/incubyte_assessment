package stepDefinitions;

import browser.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SignUpPage;
import utils.ConfigReader;

public class CreateAccountStepDef {
    private SignUpPage signUpPage= new SignUpPage(DriverFactory.getDriver());

    @Given("I open the Magento homepage")
    public void iOpenTheMagentoHomepage() {
        DriverFactory.getDriver().get(new ConfigReader().init_prop().getProperty("appUrl"));
    }

    @When("I click on the Create an Account button for new account creation")
    public void iClickOnTheCreateAnAccountButtonForNewAccountCreation() {
        signUpPage.clickCreateAccountButton();
    }
    @And("I enter valid details {string}, {string},{string} and {string} to create a new account")
    public void iEnterValidDetailsAndToCreateANewAccount(String firstName, String lastName, String email, String password) {
        signUpPage.enterDetails(firstName,lastName,email,password);
    }
    @And("I submit on Create an Account details button")
    public void iSubmitOnCreateAnAccountDetailsButton() {
        signUpPage.submitForm();
    }

    @Then("I should see a confirmation message that the account is created successfully")
    public void iShouldSeeAConfirmationMessageThatTheAccountIsCreatedSuccessfully() {
        signUpPage.isAccountCreated();
    }

    @And("I enter valid details {string}, {string} and the email {string},password {string} fields are empty")
    public void iEnterValidDetailsAndTheEmailPasswordAndFieldsAreEmpty(String fname, String lname, String email, String password) {
        signUpPage.enterRequiredDetails(fname,lname,email,password);
    }

    @Then("I should see an error message indicating missing fields")
    public void iShouldSeeAnErrorMessageIndicatingMissingFields() {
        signUpPage.verifyErrorMessages();
    }

    @And("I enter valid details {string}, {string} and enter an invalid email {string} and a valid password {string}")
    public void iEnterValidDetailsAndEnterAnInvalidEmailAndAValidPassword(String fname, String lname, String email, String password) {
        signUpPage.enterRequiredDetails(fname,lname,email,password);
    }

    @Then("I should see an error message indicating the invalid email format")
    public void iShouldSeeAnErrorMessageIndicatingTheInvalidEmailFormat() {
        signUpPage.verifyErrorMessages();
    }

    @And("I enter valid details fname {string}, lname {string}, email {string} and password {string}")
    public void iEnterValidDetailsFnameLnameEmailAndPassword(String fname, String lname, String email, String password) {
        signUpPage.enterRequiredDetails(fname,lname,email,password);
    }

    @And("I enter a mismatched confirm password {string}")
    public void iEnterAMismatchedConfirmPassword(String confPwd) {
        signUpPage.enterConfirmPassword(confPwd);
    }

    @Then("I should see an error message indicating the passwords do not match")
    public void iShouldSeeAnErrorMessageIndicatingThePasswordsDoNotMatch() {
        signUpPage.verifyErrorMessages();
    }

    @Then("I should see an error message indicating the email is already registered")
    public void iShouldSeeAnErrorMessageIndicatingTheEmailIsAlreadyRegistered() {
        signUpPage.verifyErrorMessageForAlreadyRegistedEmail();
    }



}


