package pageObjects;

import dev.failsafe.internal.util.Assert;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Define web elements using PageFactory annotations
    @FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
    WebElement signInLink;
    @FindBy(css = "#email")
    WebElement emailField;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
    WebElement passwordField;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//button[@id='send2']")
    WebElement loginButton;

    @FindBy(css = ".error-msg")
    WebElement errorMessage;

    @FindBy(xpath = "//div[@class='panel header']//button[@type='button']")
    WebElement logoutTaggle;

    @FindBy(xpath = "//a[normalize-space()='Sign Out']")
    WebElement logoutLink;

    @FindBy(xpath = "//div[contains(@data-bind,'parent.prepareMessageForHtml')]")
    WebElement loginErrorMessage;

    // Constructor to initialize elements using PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize the PageFactory elements
    }

    public void clickSignInLink(){
        signInLink.click();
    }
    public void enterCredentials(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void submitLogin() {
        loginButton.click();
    }

    public void verifyHomePage(){
        if(driver.getTitle().trim().contains("Home Page")){
            System.out.println("Verified home page Successfully!");
        }else{
            System.out.println("Login Failed!");
        }
    }
    public boolean isErrorMessageDisplayed() {

        return loginErrorMessage.isDisplayed();
    }

    public void appLogout(){
        logoutTaggle.click();
        logoutLink.click();
    }
}
