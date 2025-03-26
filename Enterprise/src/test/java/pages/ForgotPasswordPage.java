package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.github.cdimascio.dotenv.Dotenv;

import io.appium.java_client.android.AndroidDriver;

public class ForgotPasswordPage {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPage loginpage;
    Dotenv dotenv = Dotenv.load();
    // Constructor
    public ForgotPasswordPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        loginpage = new LoginPage(driver, wait);
        PageFactory.initElements(driver, this);
    }
    private String ResetConfirmationMessageText = "We've sent a password reset link to the email address you provided. If you don't see it, please check your spam/junk folders.";
    // Locators using PageFactory
    @FindBy(id = "com.globalrescue.enterprise:id/toolbar_back")
    private WebElement backButton;

    @FindBy(id = "com.globalrescue.enterprise:id/title")
    private WebElement title;

    @FindBy(id = "com.globalrescue.enterprise:id/desc")
    private WebElement description;

    @FindBy(xpath = "//android.widget.TextView[@text='Email']")
    private WebElement emailLabel;

    @FindBy(id = "com.globalrescue.enterprise:id/resetEmail")
    private WebElement emailField;

    @FindBy(id = "com.globalrescue.enterprise:id/resetButton")
    private WebElement submitButton;

    @FindBy(id = "com.globalrescue.enterprise:id/forget_password")
    private WebElement forgotPasswordButton;
    
    private By ForgotPasswordButton = By.id("com.globalrescue.enterprise:id/forget_password");
    
    public String getEmailFieldText() {
        try {
        	return wait.until(ExpectedConditions.visibilityOf(emailField)).getText();
              
        } catch (Exception e) {
            return "";
        }
    }

    // ✅ Verify Back Button
    public boolean isBackButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(backButton)).isDisplayed();
    }

    public void clickBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }

    // ✅ Verify Title
    public boolean isTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(title)).isDisplayed();
    }

    public String getTitleText() {
        return title.getText();
    }

    // ✅ Verify Description
    public boolean isDescriptionDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(description)).isDisplayed();
    }

    public String getDescriptionText() {
        return description.getText();
    }

    // ✅ Verify Email Label
    public boolean isEmailLabelDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(emailLabel)).isDisplayed();
    }

    // ✅ Verify Email Field
    public boolean isEmailFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(emailField)).isDisplayed();
    }

    public String getEmailFieldPlaceholder() {
        return emailField.getAttribute("hint"); // Placeholder text
    }

    public String getPreFilledEmail() {
        return emailField.getText();
    }

    public boolean isEmailPrefilled(String expectedEmail) {
        return getPreFilledEmail().equals(expectedEmail);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    // ✅ Verify Submit Button
    public boolean isSubmitButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(submitButton)).isDisplayed();
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton.isEnabled();
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    // ✅ Click Forgot Password Button
    public void clickForgotPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordButton)).click();
    }

    // ✅ Test Valid Email Flow
    public void testValidEmail() {
        loginpage.enterEmail(dotenv.get("EMAIL"));
        loginpage.clickNext();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginpage.isPasswordFieldVisible(), "Password field is not visible!");
        softAssert.assertAll();    }
    public void ForgotPasswordButtonClick() {
    	wait.until(ExpectedConditions.elementToBeClickable(ForgotPasswordButton)).click();
    }
    public void ResetEmailTextFieled(String ResetEmail) {
    	wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(ResetEmail);
    }

    public boolean isResetConfirmationDisplayed() {
        try {
            WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.globalrescue.enterprise:id/notificationText")));
            return notificationMessage.isDisplayed();
        } catch (Exception e) {
            return false; // Return false if the element is not found
        }
    }

    public boolean isResetConfirmationTextVerified() {
        try {
            WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.globalrescue.enterprise:id/notificationText")));
            
            String actualText = notificationMessage.getText();
            String expectedText = ResetConfirmationMessageText;

            return actualText.equals(expectedText);
        } catch (Exception e) {
            return false; // Return false if the element is not found or text does not match
        }
    }


    
    

}
