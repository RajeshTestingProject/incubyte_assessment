package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SignUpPage{
        private WebDriver driver;

        // Define web elements using PageFactory annotations
        @FindBy(linkText = "Create an Account")
        WebElement createAccountButton;

        @FindBy(xpath = "//input[@id='firstname']")
        WebElement firstNameField;

        @FindBy(css = "#lastname")
        WebElement lastNameField;

        @FindBy(xpath = "//input[@id='email_address']")
        WebElement emailField;

        @FindBy(xpath = "//input[@id='password']")
        WebElement passwordField;

        @FindBy(xpath = "//input[@id='password-confirmation']")
        WebElement confirmPasswordField;

        @FindBy(xpath = "//button[@title='Create an Account']")
        WebElement submitButton;

        @FindBy(xpath = "//div[@class='message-success success message']")
        WebElement successMessage;

        @FindAll(@FindBy(xpath = "//div[contains(@class,'mage-error')]"))
        List<WebElement> errorMessages;
        @FindBy(xpath = "//div[contains(@data-bind,'parent.prepareMessageForHtml')]")
        WebElement gblErrorMessage;

        // Constructor to initialize elements using PageFactory
        public SignUpPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this); // Initialize the PageFactory elements
        }

        public void clickCreateAccountButton() {
            createAccountButton.click();
        }

        public void enterDetails(String firstName, String lastName, String email, String password) {
            firstNameField.sendKeys(firstName);
            lastNameField.sendKeys(lastName);
            emailField.sendKeys(email);
            passwordField.sendKeys(password);
            confirmPasswordField.sendKeys(password);
        }
    public void enterRequiredDetails(String firstName, String lastName, String email, String password) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confmPwd){
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confmPwd);
    }
        public void submitForm() {
            submitButton.click();
        }

        public boolean isAccountCreated() {
            if(successMessage.getText().trim().contains("Thank you for registering with Main Website Store.")){
                Assert.assertTrue(true,"Thank you for registering with Main Website Store.");
            }else{
                Assert.fail("Account not created!");
            }
            return driver.getCurrentUrl().contains("account");
        }

        public void verifyErrorMessages(){
            if(errorMessages.size()>0){
                Assert.assertTrue(true,errorMessages.get(0).getText());
            }else{
                Assert.fail("No Error Messages!!");
            }
        }
    public void verifyErrorMessageForAlreadyRegistedEmail(){
            if(gblErrorMessage.getText().trim().contains("There is already an account with this email address"))
        Assert.assertTrue(true,"There is already an account with this email address!");
         }
    }


