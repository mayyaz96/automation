package TestCases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseSetup;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utilities.ExtentReportsManager;

public class ForgotPasswordTest extends BaseSetup {
    private WebDriverWait wait;
    private ForgotPasswordPage forgotPassword;
    private LoginPage loginPage;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    public void setUpTest() {
        extent = ExtentReportsManager.getExtentReports();  
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        forgotPassword = new ForgotPasswordPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
    }

    /*** UI Test Cases ***/
    @Test(priority = 1)
    public void enterValidEmailInForgotPassword() {
        test = extent.createTest("Enter Valid Email in Forgot Password");

        try {
            forgotPassword.testValidEmail();
            test.pass("✅ Successfully entered a valid email.");
        } catch (Exception e) {
            test.fail("❌ Failed to enter a valid email: " + e.getMessage());
            Assert.fail("Error while entering a valid email.", e);
        }
    }

    @Test(priority = 2)
    public void clickForgotPasswordButton() {
        test = extent.createTest("Click on Forgot Password Button");

        try {
            forgotPassword.ForgotPasswordButtonClick();
            test.pass("✅ Successfully clicked on the Forgot Password button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Forgot Password button: " + e.getMessage());
            Assert.fail("Error while clicking Forgot Password button.", e);
        }
    }

    @Test(priority = 3)
    public void clickSubmitButtonOnForgotPassword() {
        test = extent.createTest("Click on Submit Button for Forgot Password");

        try {
            forgotPassword.clickSubmitButton();
            test.pass("✅ Successfully clicked on the Submit button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Submit button: " + e.getMessage());
            Assert.fail("Error while clicking Submit button.", e);
        }
    }

    @Test(priority = 4)
    public void verifyResetPasswordConfirmationMessage() {
        test = extent.createTest("Verify Reset Password Confirmation Message");

        try {
            Assert.assertTrue(forgotPassword.isResetConfirmationDisplayed(),
                    "❌ Password reset confirmation message is not displayed.");
            test.pass("✅ Password reset confirmation message displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify password reset confirmation message: " + e.getMessage());
            Assert.fail("Error while verifying reset confirmation message.", e);
        }
    }
    @Test(priority = 5)
    public void verifyResetPasswordConfirmationMessageText() {
        test = extent.createTest("Verify Reset Password Confirmation Message");

        try {
            Assert.assertTrue(forgotPassword.isResetConfirmationTextVerified(),
                    "❌ Password reset confirmation message text is not displayed.");
            test.pass("✅ Password reset confirmation message displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify password reset confirmation message: " + e.getMessage());
            Assert.fail("Error while verifying reset confirmation message.", e);
        }
    }
    @Test(priority = 6)
    public void verifyTitleText() {
        test = extent.createTest("Verify Title Text");
        try {
            forgotPassword.ForgotPasswordButtonClick();
            Assert.assertTrue(forgotPassword.isTitleDisplayed(), "Title is not displayed");
            Assert.assertEquals(forgotPassword.getTitleText(), "Reset Password", "Title text is incorrect");
            test.pass("✅ Title is displayed correctly and matches expected value.");
        } catch (Exception e) {
            test.fail("❌ Title validation failed: " + e.getMessage());
            Assert.fail("Title validation error", e);
        }
    }

    @Test(priority = 7)
    public void verifyDescriptionTextLabel() {
        test = extent.createTest("Verify Description Text");
        try {
            Assert.assertTrue(forgotPassword.isDescriptionDisplayed(), "Description is not displayed");
            test.pass("✅ Description is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Description validation failed: " + e.getMessage());
            Assert.fail("Description validation error", e);
        }
    }
    
    @Test(priority = 8)
    public void verifyDescriptionText() {
        test = extent.createTest("Verify Description Text");
        try {
            Assert.assertTrue(forgotPassword.isDescriptionDisplayed(), "Description is not displayed");
            test.pass("✅ Description is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Description validation failed: " + e.getMessage());
            Assert.fail("Description validation error", e);
        }
    }
    @Test(priority = 9)
    public void verifyEmailLabel() {
        test = extent.createTest("Verify Email Label");
        try {
            Assert.assertTrue(forgotPassword.isEmailLabelDisplayed(), "Email label is missing");
            test.pass("✅ Email label is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Email label validation failed: " + e.getMessage());
            Assert.fail("Email label validation error", e);
        }
    }
    @Test(priority = 10)
    public void verifyEmailLabelText() {
        test = extent.createTest("Verify Email Label");
        try {
            Assert.assertTrue(forgotPassword.isEmailLabelDisplayed(), "Email label is missing");
            test.pass("✅ Email label is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Email label validation failed: " + e.getMessage());
            Assert.fail("Email label validation error", e);
        }
    }

    @Test(priority = 11)
    public void verifySubmitButtonEnabled() {
        test = extent.createTest("Verify Submit Button Enabled");
        try {
            Assert.assertTrue(forgotPassword.isSubmitButtonEnabled(), "Submit button should be enabled");
            test.pass("✅ Submit button is enabled.");
        } catch (Exception e) {
            test.fail("❌ Submit button validation failed: " + e.getMessage());
            Assert.fail("Submit button validation error", e);
        }
    }


    /*** Functional Test Cases ***/

    @Test(priority = 12)
    public void verifyEmailFieldEditable() {
        test = extent.createTest("Verify Email Field Editable");
        try {
            String testEmail = "test@example.com";
            forgotPassword.enterEmail(testEmail);
   
            Assert.assertEquals(forgotPassword.getEmailFieldText(), testEmail, "Email field is not editable");
            test.pass("✅ Email field is editable.");
        } catch (Exception e) {
            test.fail("❌ Email field validation failed: " + e.getMessage());
            Assert.fail("Email field validation error", e);
        }
    }

  

    /*** Negative Test Cases ***/

    @Test(priority = 13)
    public void verifyInvalidEmailFormat() {
        test = extent.createTest("Verify Invalid Email Format");
        try {
            forgotPassword.enterEmail("invalid-email");
            forgotPassword.clickSubmitButton();
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/notificationText")));
            Assert.assertEquals(errorMsg.getText(), "Email is not valid", "Incorrect validation message");
            test.pass("✅ Correct validation message displayed for invalid email format.");
        } catch (Exception e) {
            test.fail("❌ Invalid email format test failed: " + e.getMessage());
            Assert.fail("Invalid email format test error", e);
        }
    }

    @Test(priority = 14)
    public void verifyEmptyEmailField() {
        test = extent.createTest("Verify Empty Email Field");
        try {
            forgotPassword.enterEmail("");
            forgotPassword.clickSubmitButton();
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/notificationText")));
            Assert.assertEquals(errorMsg.getText(), "Please complete the form by filling the highlighted fields.", "Incorrect validation message");
            test.pass("✅ Correct validation message displayed for empty email field.");
        } catch (Exception e) {
            test.fail("❌ Empty email field test failed: " + e.getMessage());
            Assert.fail("Empty email field test error", e);
        }
    }

    @Test(priority = 15)
    public void verifyNonRegisteredEmail() {
        test = extent.createTest("Verify Non-Registered Email");
        try {
            forgotPassword.enterEmail("notfound@example.com");
            forgotPassword.clickSubmitButton();
            WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/notificationText")));
            Assert.assertEquals(errorMsg.getText(), "You have entered an incorrect email address.", "Incorrect validation message");
            test.pass("✅ Correct validation message displayed for non-registered email.");
        } catch (Exception e) {
            test.fail("❌ Non-registered email test failed: " + e.getMessage());
            Assert.fail("Non-registered email test error", e);
        }
    }
    @Test(priority = 16)
    public void validateBackButton() {
        test = extent.createTest("Validate Back Button Visibility");

        try {
            Assert.assertTrue(loginPage.isBackButtonDisplayed(), "Back button is not displayed");
            loginPage.pressBackButton();
            loginPage.pressBackButton();

            test.pass("Back button was successfully Displayed");
        } catch (Exception e) {
            test.fail("Back button validation failed due to: " + e.getMessage());
            Assert.fail("Test failed due to an exception: " + e);
        }
    }
   
   // pressBackButton

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(result.getName() + " passed.");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(result.getName() + " skipped.");
        }
        extent.flush();
    }

    @AfterSuite
    public void tearDownExtentReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
