package stepDefinitions;

import browser.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;
import pageObjects.SignUpPage;
import utils.ConfigReader;

public class LoginStepDef {
   private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private SignUpPage signUpPage = new SignUpPage(DriverFactory.getDriver());

    @Then("I should be able to successfully create an account")
    public void iShouldBeAbleToCreateAccount() {
        assert signUpPage.isAccountCreated();
    }

    @Given("I open the Magento application page")
    public void iOpenTheMagentoapplicationpage() {
        DriverFactory.getDriver().get(new ConfigReader().init_prop().getProperty("appUrl"));
    }

    @When("I clicked on the Sign In link")
    public void iClickedOnTheSignInLink() {
        loginPage.clickSignInLink();
    }
    @When("I have entered a valid username {string} and password {string}")
    public void iHaveEnteredAValidUsernameAndPassword(String username, String password) {
        loginPage.enterCredentials(username,password);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginPage.submitLogin();
    }
    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToHomepage() {
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("homepage"));
    }
    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
       loginPage.verifyHomePage();
    }

    @And("I click on the logout button")
    public void iClickOnTheLogoutButton() {
        loginPage.appLogout();
    }

    @And("I enter {string} as the email and {string} as the password")
    public void iEnterAsTheEmailAndAsThePassword(String userId, String password) {
        loginPage.enterCredentials(userId,password);
    }

    @Then("I should be logged in and redirected to the account dashboard")
    public void iShouldBeLoggedInAndRedirectedToTheAccountDashboard() {
        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("homepage"));
    }

    @Then("I should see an error message incorrect log  in details")
    public void iShouldSeeAnErrorMessageIncorrectLogInDetails() {
        loginPage.isErrorMessageDisplayed();
    }

    @And("I have entered {string} as the email and {string} as the password")
    public void iHaveEnteredAsTheEmailAndAsThePassword(String email, String password) {
        loginPage.enterCredentials(email, password);
    }

}
