package TestCases;

import base.BaseSetup;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.github.cdimascio.dotenv.Dotenv;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import utilities.ExtentReportsManager;

import java.time.Duration;

public class LoginTest extends BaseSetup {
    private WebDriverWait wait;
    private LoginPage loginPage;
    Dotenv dotenv = Dotenv.load();
    // ExtentReports objects
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setupExtentReports() {
        extent = ExtentReportsManager.getExtentReports();
    }

    @BeforeMethod
    public void setUpTest() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        loginPage = new LoginPage(driver, wait);
    }
    @Test(priority = 1)
    public void verifySignInHeading() {
        test = extent.createTest("Verify Sign-In Heading");
        try {
            boolean isDisplayed = loginPage.isSignInHeadingDisplayed();
            Assert.assertTrue(isDisplayed, "Sign in heading is not displayed!");
            test.pass("Sign in heading is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Sign in heading is not displayed. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 2)
    public void verifyEmailLabel() {
        test = extent.createTest("Verify Email Label");
        try {
            boolean isDisplayed = loginPage.isEmailLabelDisplayed();
            Assert.assertTrue(isDisplayed, "Email label is not displayed!");
            test.pass("Email label is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Email label is not displayed. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3)
    public void verifyNextButton() {
        test = extent.createTest("Verify Next Button");
        try {
            boolean isDisplayed = loginPage.isNextButtonDisplayed();
            Assert.assertTrue(isDisplayed, "Next button is not displayed!");
            test.pass("Next button is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Next button is not displayed. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 4)
    public void verifyDontHaveAccountText() {
        test = extent.createTest("Verify 'Don't Have Account' Text");
        try {
            boolean isDisplayed = loginPage.isDontHaveAccountTextDisplayed();
            Assert.assertTrue(isDisplayed, "Don't have an account text is missing!");
            test.pass("'Don't Have Account' text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("'Don't Have Account' text is missing. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 5)
    public void verifyRegisterNowButton() {
        test = extent.createTest("Verify Register Now Button");
        try {
            boolean isDisplayed = loginPage.isRegisterNowButtonDisplayed();
            Assert.assertTrue(isDisplayed, "Register Now button is not displayed!");
            test.pass("Register Now button is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Register Now button is not displayed. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 6)
    public void verifyGlobalRescueText() {
        test = extent.createTest("Verify Global Rescue Text");
        try {
            boolean isDisplayed = loginPage.isGlobalRescueTextDisplayed();
            Assert.assertTrue(isDisplayed, "Global Rescue text is missing!");
            test.pass("Global Rescue text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Global Rescue text is missing. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 7)
    public void verifyLearnMoreText() {
        test = extent.createTest("Verify Learn More Text");
        try {
            boolean isCorrect = loginPage.isLearnMoreTextCorrect();
            Assert.assertTrue(isCorrect, "Learn More text is incorrect!");
            test.pass("Learn More text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Learn More text verification failed. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 8)
    public void verifyLearnMoreLink() {
        test = extent.createTest("Verify Learn More Link");
        try {
            boolean isCorrect = loginPage.isLearnMoreLinkCorrect();
            Assert.assertTrue(isCorrect, "Learn More link did not navigate to the correct URL!");
            test.pass("Learn More link navigated to the correct URL.");
        } catch (AssertionError e) {
            test.fail("Learn More link verification failed. Error: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("Unexpected error while verifying Learn More link: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                driver.context("NATIVE_APP");
                System.out.println("Successfully navigated back to the app.");
            } catch (Exception e) {
                System.out.println("Warning: Failed to switch back to the native app - " + e.getMessage());
            }
        }
    }


    @Test(priority = 9)
    public void verifyEmailPlaceholder() {
        test = extent.createTest("Verify Email Placeholder");
        try {
            boolean isCorrect = loginPage.verifyEmailPlaceholder();
            Assert.assertTrue(isCorrect, "Email placeholder text is incorrect!");
            test.pass("Email placeholder is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Email placeholder text is incorrect. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 10)
    public void verifyTermsOfServiceText() {
        test = extent.createTest("Verify Terms of Service Text");
        try {
            boolean isCorrect = loginPage.verifyTermsOfServiceText();
            Assert.assertTrue(isCorrect, "Terms of Service text is incorrect!");
            test.pass("Terms of Service text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Terms of Service text is incorrect. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 11)
    public void verifyTermsOfServiceLink() {
        test = extent.createTest("Verify Terms of Service Link");
        try {
        	Thread.sleep(2000);
            boolean isCorrect = loginPage.verifyTermsOfServiceLink();
            
            Assert.assertTrue(isCorrect, "Terms of Service link is incorrect!");
            test.pass("Terms of Service link is displayed correctly.");
        } catch (Exception e) {
            test.fail("Unexpected error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
       
    }


    @Test(priority = 12)
    public void verifyPrivacyPolicyText() {
        test = extent.createTest("Verify Privacy Policy Text");
        try {
            boolean isCorrect = loginPage.verifyPrivacyPolicyText();
            Assert.assertTrue(isCorrect, "Privacy Policy text is incorrect!");
            test.pass("Privacy Policy text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Privacy Policy text is incorrect. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 13)
    public void verifyPrivacyPolicyLink() {
        test = extent.createTest("Verify Privacy Policy Link");
        try {
            boolean isCorrect = loginPage.verifyPrivacyPolicyLink();
            Assert.assertTrue(isCorrect, "Privacy Policy link is incorrect!");
            test.pass("Privacy Policy link is displayed correctly.");
        
        } catch (Exception e) {
            test.fail("Unexpected error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    @Test(priority = 14)
    public void verifyCopyrightText() {
        test = extent.createTest("Verify Copyright Text");

        try {
            boolean isCorrect = loginPage.verifyCopyrightText();
            Assert.assertTrue(isCorrect, "❌ Copyright text does not match expected value!");
            test.pass("✅ Copyright text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("❌ Copyright text verification failed. Error: " + e.getMessage());
            throw e;
        }
    }


    @Test(priority = 15)
    public void testEmptyEmailErrorBanner() {
        test = extent.createTest("Test Empty Email Error Banner");
        try {
            loginPage.enterEmail("");
            loginPage.clickNext();
            boolean isErrorDisplayed = loginPage.isErrorDisplayed();
            Assert.assertTrue(isErrorDisplayed, "Error message not displayed for empty email!");
            test.pass("Error message is displayed correctly for empty email.");
        } catch (AssertionError e) {
            test.fail("Error message is not displayed for empty email. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 16)
    public void testEmptyEmailErrorText() {
        test = extent.createTest("Test Empty Email Error Text");
        try {
            boolean isCorrect = loginPage.ErrorText(LoginPage.EmptyEmailErrorText);
            Assert.assertTrue(isCorrect, "Error message text is not correct as expected!");
            test.pass("Error message text is correct as expected.");
        } catch (AssertionError e) {
            test.fail("Error message text is incorrect. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 17)
    public void testInvalidEmailErrorBanner() {
        test = extent.createTest("Test Invalid Email Format");
        try {
            loginPage.enterEmail("userexample.com");
            loginPage.clickNext();
            boolean isErrorDisplayed = loginPage.isErrorDisplayed();
            Assert.assertTrue(isErrorDisplayed, "Error Banner is not displayed for invalid email format!");
            test.pass("Error Banner is displayed correctly for invalid email format.");
        } catch (AssertionError e) {
            test.fail("Error Banner is not displayed for invalid email format. Error: " + e.getMessage());
            throw e;
        }
    }
    @Test(priority = 18)
    public void testInvalidEmailFormatErrorText() {
        test = extent.createTest("Test Invalid Email Format");
        try {
            boolean isErrorText = loginPage.ErrorText(loginPage.InvalidEmailErrorText);
            Assert.assertTrue(isErrorText, "Error Banner Text is incorrect");
            test.pass("Error Banner Text is correct");
        } catch (AssertionError e) {
            test.fail("Error Banner Text is incorrect for invalid email format. Error: " + e.getMessage());
            throw e;
        }
    }
    @Test(priority = 19)
    public void testNonRegisteredEmail() {
        test = extent.createTest("Test Non-Registered Email");
        try {
            loginPage.enterEmail("nonRegistered@domain.com");
            loginPage.clickNext();
            boolean isErrorDisplayed = loginPage.isBackenedErrorDisplayed();
            Assert.assertTrue(isErrorDisplayed, "Error message not displayed for non-registered email!");
            test.pass("Error message is displayed correctly for non-registered email.");
        } catch (AssertionError e) {
            test.fail("Error message is not displayed for non-registered email. Error: " + e.getMessage());
            throw e;
        }
    }
    
    @Test(priority = 20)
    public void testNonRegisteredEmailErrorText() {
        test = extent.createTest("Test Non-Registered Email Error Text");
        try {
            boolean isErrorDisplayed = loginPage.ErrorText(LoginPage.NonRegisterEmailErrorText);
            Assert.assertTrue(isErrorDisplayed, "Incorrect error message text is displayed for non-registered email");
            test.pass("Correct error message text is displayed for non-registered email");
        } catch (AssertionError e) {
            test.fail("Incorrect error message text is displayed for non-registered email. Error: " + e.getMessage());
            throw e;
        }
    }
    
    @Test(priority = 21)
    public void testValidEmail() {
        test = extent.createTest("Test Valid Email");
        try {
            loginPage.enterEmail(dotenv.get("EMAIL"));
            loginPage.clickNext();
            boolean isPasswordFieldVisible = loginPage.isPasswordFieldVisible();
            Assert.assertTrue(isPasswordFieldVisible, "Password field is not visible for valid email!");
            test.pass("Password field is displayed correctly for valid email.");
        } catch (AssertionError e) {
            test.fail("Password field is not displayed for valid email. Error: " + e.getMessage());
            throw e;
        }
    }
// password screen
    @Test(priority = 22)
    public void testUserImage() {
    	test = extent.createTest("Test User Image");
        try {
            boolean isDisplayed = loginPage.isUserImageDisplayed();
            Assert.assertTrue(isDisplayed, "User image should be displayed.");
            test.pass("User image is displayed.");
        } catch (Exception e) {
            test.fail("Exception while checking user image visibility: " + e.getMessage());
            Assert.fail("Exception while checking user image visibility", e);
        }
    }

    
    @Test(priority = 23)
    public void isBackButtonDisplayed() {
    	test = extent.createTest("verify that Back button is displayed or not");
    	try {
    		boolean BackButton = loginPage.isBackButtonDisplayed();
    		Assert.assertTrue(BackButton, "Back button is not Displayed");
    		test.pass("Back button is displayed");
    	}
    	catch(Exception e) {
    		test.fail("Back button visibility error" + e.getMessage());
    		Assert.fail("Back button visibility error" + e);
    		
    	}
    }

    @Test (priority = 24)
    public void testEmailFieldVisible() {
    	test = extent.createTest("Verify email field is displayed");
    	try {
    		boolean isEmailFieldDisplayed = loginPage.isEmailAvatarFieldDisplayed();
    		Assert.assertTrue(isEmailFieldDisplayed, "Email field should be displayed.");
    		test.pass("Back button is displayed");
    	}
    	catch(Exception e) {
    		test.fail("Back button visibility error" + e.getMessage());
    		Assert.fail("Exception while checking email field visibility ", e);
    		
    	}
    }
    @Test(priority = 25, description = "Verify email field is non-editable.")
    public void testEmailFieldNonEditable() {
    	test = extent.createTest("Verify email field is non-editable");
        try {
            boolean isEmailFieldNonEditable = loginPage.isEmailFieldNonEditable();
            Assert.assertTrue(isEmailFieldNonEditable, "Email field should be non-editable.");
            test.pass("Email field is non-editable");
        } catch (Exception e) {
        	test.fail("Back button visibility error" + e.getMessage());
            Assert.fail("Exception while checking email editability", e);
        }
    }

    @Test(priority = 26, description = "Verify password label is displayed.")
    public void testPasswordLabel() {
    	test = extent.createTest("Verify password label is displayed");
        try {
            boolean isPasswordLabelDisplayed = loginPage.isPasswordLabelDisplayed();
            Assert.assertTrue(isPasswordLabelDisplayed, "Password label should be displayed.");
            test.pass("Password label is displayed.");
        } catch (Exception e) {
        	test.fail("Back button visibility error" + e.getMessage());
            Assert.fail("Exception while checking password label visibility", e);
        }
    }

    @Test(priority = 27, description = "Verify password field placeholder text.")
    public void testPasswordFieldPlaceholder() {
    	test = extent.createTest("Verify password label is displayed");
        try {
            String placeholder = loginPage.getPasswordFieldPlaceholder();
            Assert.assertEquals(placeholder, "Enter your password", "Password placeholder text should match.");
            test.pass("Password label is displayed.");
        } catch (Exception e) {
        	test.fail("Back button visibility error" + e.getMessage());
            Assert.fail("Exception while checking password placeholder text", e);
        }
    }

    @Test(priority = 28, description = "Verify Remember Me checkbox is displayed and clickable.")
    public void testRememberMeCheckbox() {
    	test = extent.createTest("Verify password label is displayed");
        try {
            boolean isCheckboxDisplayed = loginPage.isRememberMeCheckboxDisplayed();
            test.pass("Password label is displayed.");
            Assert.assertTrue(isCheckboxDisplayed, "Remember Me checkbox should be displayed.");
            
            
        } catch (Exception e) {
        	test.fail("Back button visibility error" + e.getMessage());
            Assert.fail("Exception while checking Remember Me checkbox visibility or clickability", e);
        }
    }

    
    @Test(priority = 29)
    public void testEmptyPassword() {
        test = extent.createTest("Test Empty Password");
        try {
            loginPage.enterPassword("");
            loginPage.clickLogin();
            boolean isErrorDisplayed = loginPage.isErrorDisplayed();
            Assert.assertTrue(isErrorDisplayed, "Error message not displayed for empty password!");
            test.pass("Error message is displayed correctly for empty password.");
        } catch (AssertionError e) {
            test.fail("Error message is not displayed for empty password. Error: " + e.getMessage());
            throw e;
        }
    }
    @Test(priority = 30)
    public void testEmptyPasswordErrorText() {
        test = extent.createTest("Test Empty Password Error Text");
        try {
            boolean isErrorDisplayed = loginPage.ErrorText(LoginPage.EmptyPasswordErrorText);
            Assert.assertTrue(isErrorDisplayed, "Error message not displayed for empty password!");
            test.pass("Error message is displayed correctly for empty password.");
        } catch (AssertionError e) {
            test.fail("Error message is not displayed for empty password. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 31)
    public void testInvalidPassword() {
        test = extent.createTest("Test Invalid Password");
        try {
            loginPage.enterPassword("wrongPassword");
            loginPage.clickLogin();
            boolean isErrorDisplayed = loginPage.isErrorDisplayed();
            Assert.assertTrue(isErrorDisplayed, "Error message not displayed for invalid password!");
            test.pass("Error message is displayed correctly for invalid password.");
        } catch (AssertionError e) {
            test.fail("Error message is not displayed for invalid password. Error: " + e.getMessage());
            throw e;
        }
    }
   @Test(priority = 32)
    public void testInvalidPasswordText() {
        test = extent.createTest("Test Invalid Password");
        try {
            loginPage.enterPassword("wrongPassword");
            loginPage.clickLogin();
            boolean isErrorDisplayed = loginPage.ErrorText(LoginPage.wrongPasswordErrorText);
            Assert.assertTrue(isErrorDisplayed, "Error message not displayed for invalid password!");
            test.pass("Error message is displayed correctly for invalid password.");
        } catch (AssertionError e) {
            test.fail("Error message is not displayed for invalid password. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 33)
    public void testPasswordMasking() {
        test = extent.createTest("Test Password Masking");
        try {
            loginPage.enterPassword("password123");
            boolean isPasswordMasked = loginPage.isPasswordMasked();
            Assert.assertTrue(isPasswordMasked, "Password is not masked!");
            test.pass("Password masking is working correctly.");
        } catch (AssertionError e) {
            test.fail("Password is not masked. Error: " + e.getMessage());
            throw e;
        }
    }
    @Test(priority = 34, description = "Verify Scroll Layout is Displayed")
    public void verifyScrollLayoutDisplayed() {
        test = extent.createTest("Verify Scroll Layout");

        try {
            Assert.assertTrue(loginPage.isScrollLayoutDisplayed(), "❌ Scroll Layout is NOT displayed.");
            test.pass("✅ Scroll Layout is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Scroll Layout verification failed: " + e.getMessage());
            Assert.fail("Scroll Layout verification failed!", e);
        }
    }

    @Test(priority = 35, description = "Verify 'Don't know your password?' Text is Displayed")
    public void verifyForgotPasswordTextDisplayed() {
        test = extent.createTest("Verify 'Don't know your password?' Text");

        try {
            Assert.assertTrue(loginPage.isForgotPasswordTextDisplayed(), "❌ Forgot Password text is NOT displayed.");
            test.pass("✅ 'Don't know your password?' text is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Forgot Password text verification failed: " + e.getMessage());
            Assert.fail("Forgot Password text verification failed!", e);
        }
    }

    @Test(priority = 36, description = "Verify 'Reset it here.' Button is Displayed")
    public void verifyResetPasswordButtonDisplayed() {
        test = extent.createTest("Verify 'Reset it here.' Button");

        try {
            Assert.assertTrue(loginPage.isResetPasswordButtonDisplayed(), "❌ Reset Password Button is NOT displayed.");
            test.pass("✅ 'Reset it here.' Button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Reset Password Button verification failed: " + e.getMessage());
            Assert.fail("Reset Password Button verification failed!", e);
        }
    }

    @Test(priority = 37, description = "Verify View Group Container is Displayed")
    public void verifyViewGroupContainerDisplayed() {
        test = extent.createTest("Verify View Group Container");

        try {
            Assert.assertTrue(loginPage.isViewGroupContainerDisplayed(), "❌ View Group Container is NOT displayed.");
            test.pass("✅ View Group Container is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ View Group Container verification failed: " + e.getMessage());
            Assert.fail("View Group Container verification failed!", e);
        }
    }

    
    
    
    @Test(priority = 38)
    public void verifySignInHeadingOnPasswordScreen() {
        test = extent.createTest("Verify Sign-In Heading");
        try {
            boolean isDisplayed = loginPage.isSignInHeadingDisplayed();
            Assert.assertTrue(isDisplayed, "Sign in heading is not displayed!");
            test.pass("Sign in heading is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Sign in heading is not displayed. Error: " + e.getMessage());
            throw e;
        }
    }
    
    @Test(priority = 39)
    public void verifyGlobalRescueTextOnPasswordScreen() {
        test = extent.createTest("Verify Global Rescue Text");
        try {
            boolean isDisplayed = loginPage.isGlobalRescueTextDisplayed();
            Assert.assertTrue(isDisplayed, "Global Rescue text is missing!");
            test.pass("Global Rescue text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Global Rescue text is missing. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 40)
    public void verifyLearnMoreTextOnPasswordScreen() {
        test = extent.createTest("Verify Learn More Text");
        try {
            boolean isCorrect = loginPage.isLearnMoreTextCorrect();
            Assert.assertTrue(isCorrect, "Learn More text is incorrect!");
            test.pass("Learn More text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Learn More text verification failed. Error: " + e.getMessage());
            throw e;
        }
    }

    
    @Test(priority = 42)
    public void verifyTermsOfServiceTextOnPasswordScreen() {
        test = extent.createTest("Verify Terms of Service Text");
        try {
            boolean isCorrect = loginPage.verifyTermsOfServiceText();
            Assert.assertTrue(isCorrect, "Terms of Service text is incorrect!");
            test.pass("Terms of Service text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Terms of Service text is incorrect. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 43)
    public void verifyTermsOfServiceLinkOnPasswordScreen() {
        test = extent.createTest("Verify Terms of Service Link");
        try {
            boolean isCorrect = loginPage.verifyTermsOfServiceLink();
            Assert.assertTrue(isCorrect, "Terms of Service link is incorrect!");
            test.pass("Terms of Service link is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Terms of Service link verification failed. Error: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("Unexpected error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        } 
    }


    @Test(priority = 44)
    public void verifyPrivacyPolicyTextOnPasswordScreen() {
        test = extent.createTest("Verify Privacy Policy Text");
        try {
            boolean isCorrect = loginPage.verifyPrivacyPolicyText();
            Assert.assertTrue(isCorrect, "Privacy Policy text is incorrect!");
            test.pass("Privacy Policy text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Privacy Policy text is incorrect. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 45)
    public void verifyPrivacyPolicyLinkOnPasswordScreen() {
        test = extent.createTest("Verify Privacy Policy Link");
        try {
            boolean isCorrect = loginPage.verifyPrivacyPolicyLink();
            Assert.assertTrue(isCorrect, "Privacy Policy link is incorrect!");
            test.pass("Privacy Policy link is displayed correctly.");
  
        } catch (Exception e) {
            test.fail("Unexpected error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    @Test(priority = 46)
    public void verifyCopyrightTextOnPasswordScreen() {
        test = extent.createTest("Verify Copyright Text");

        try {
            boolean isCorrect = loginPage.verifyCopyrightText();
            Assert.assertTrue(isCorrect, "❌ Copyright text does not match expected value!");
            test.pass("✅ Copyright text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("❌ Copyright text verification failed. Error: " + e.getMessage());
            throw e;
        }
    }
    
    

    @Test(priority = 48, description = "Click on 'Remember Me' Checkbox")
    public void clickRememberMeCheckbox() {
        test = extent.createTest("Click on 'Remember Me' Checkbox");

        try {
        	Thread.sleep(2000);
        	loginPage.clickRememberMeCheckbox();
            test.pass("✅ Successfully clicked on 'Remember Me' checkbox.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on 'Remember Me' checkbox: " + e.getMessage());
            Assert.fail("Click action failed for 'Remember Me' checkbox!", e);
        }
    }


    @Test(priority = 47)
    public void testValidPasswordOnPasswordScreen() {
        test = extent.createTest("Test Valid Password");
        try {
            loginPage.enterPassword(dotenv.get("PASSWORD"));
            loginPage.enterPassword("Gridtest1");
            loginPage.clickLogin();
            //boolean isLoginSuccessful = loginPage.isLoginSuccessful();
            //Assert.assertTrue(isLoginSuccessful, "Login failed with valid credentials!");
            test.pass("Login is successful with valid credentials.");
        } catch (AssertionError e) {
            test.fail("Login failed  with valid credentials. Error: " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        // Capture test status
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(result.getName() + " passed.");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(result.getName() + " skipped.");
        }
        extent.flush();  // Ensure the report is updated after each test
    }

    @AfterSuite
    public void tearDownExtentReports() {
        if (extent != null) {
            extent.flush(); // Write the report to file
        }
    }
}
