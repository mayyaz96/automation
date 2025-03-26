package TestCases;
import commonPages.CommonFunctions;
import io.appium.java_client.android.AndroidDriver;

// For TestNG assertions

import org.testng.annotations.Test;
import base.BaseSetup;
import pages.LoginPage;
import pages.PermissionsPage;
import pages.SignUpPage;
import utilities.AppiumUtils;
import utilities.ExtentReportsManager;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class SignUpTest extends BaseSetup {
	public LoginPage loginPage;
	public SignUpPage signUpPage;
	private WebDriverWait wait;
	private ExtentReports extent;
	private ExtentTest test;
	private PermissionsPage permissionsPage;
	private String randomEamil;

	@BeforeSuite
	public void setupExtentReports() {
		extent = ExtentReportsManager.getExtentReports();
	}
	public SignUpTest(AndroidDriver driver, WebDriverWait wait, ExtentReports extent) {
        this.driver = driver;
        this.wait = wait;
        this.extent = extent;
        this.signUpPage = new SignUpPage(driver, wait); 

    }
	@BeforeClass
	public void setup() {
	    extent = ExtentReportsManager.getExtentReports();

		// Initialize wait and SignUpPage
		loginPage = new LoginPage(null, wait);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		loginPage = new LoginPage(driver, wait);
		signUpPage = new SignUpPage(driver, wait);
		permissionsPage = new PermissionsPage(driver, wait); // Initialize permissionsPage
		System.out.println("Setup completed for SignUpTest.");
	}

//	@Test(priority = 1)
//	public void installAndLaunchApp() {
//	    test = extent.createTest("Install and Launch App");
//	    try {
//	        AppiumUtils.installAndLaunchApp(driver, "C:\\Users\\amehdi\\Downloads\\grid-enterprise-app-debug.apk", "com.globalrescue.enterprise");
//	        test.pass("✅ App installed and launched successfully.");
//	        System.out.println("[INFO] App installed and launched successfully.");
//	    } catch (Exception e) {
//	        test.fail("❌ Failed to install and launch app. Error: " + e.getMessage());
//	        System.err.println("[ERROR] Failed to install and launch app: " + e.getMessage());
//	        e.printStackTrace();
//	        Assert.fail("App installation and launch failed.", e);
//	    }
//	}
//
	 
	//@Test(priority = 2)
	public void Logout() {
	    test = extent.createTest("Logout");
	    try {
	    	signUpPage.clickSetttings();
	    	signUpPage.clicklogout();
	    	signUpPage.clicklogoutpopup();
	    	
	    } catch (Exception e) {
	        test.fail("❌ Failed to logout. Error: " + e.getMessage());
	        System.err.println("[ERROR] Failed to logout: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("logout failed.", e);
	    }
	}

	@Test(priority = 3)
	public void validateRegisterNow() {
	    test = extent.createTest("Validate Register Now Button Exists");
	    try {
	        Assert.assertTrue(loginPage.isRegisterNowButtonDisplayed(), "Register Now button does not exist.");
	        test.pass("✅ Register Now button exists on the page.");
	        System.out.println("[INFO] Register Now button exists.");
	    } catch (Exception e) {
	        test.fail("❌ Failed to validate Register Now button. Error: " + e.getMessage());
	        System.err.println("[ERROR] Failed to validate Register Now button: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Register Now button validation failed.", e);
	    }
	}

	@Test(priority = 4)
	public void clickRegisterNow() {
	    test = extent.createTest("Click Register Now");
	    try {
	        WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(loginPage.RegisterNowButton));
	        registerButton.click();
	        test.pass("✅ Register Now button clicked successfully.");
	        System.out.println("[INFO] Register Now button clicked.");
	    } catch (Exception e) {
	        test.fail("❌ Failed to click Register Now button. Error: " + e.getMessage());
	        System.err.println("[ERROR] Failed to click Register Now button: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Register Now button click failed.", e);
	    }
	}

	@Test(priority = 5)
	public void validateHeadingExists() {
	    test = extent.createTest("Validate Heading Exists");
	    try {
	        Assert.assertTrue(signUpPage.isHeadingVisible(), "Heading does not exist.");
	        test.pass("✅ Heading exists on the page.");
	        System.out.println("[INFO] Heading exists.");
	    } catch (Exception e) {
	        test.fail("❌ Failed to validate heading existence. Error: " + e.getMessage());
	        System.err.println("[ERROR] Failed to validate heading existence: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Heading validation failed.", e);
	    }
	}

	@Test(priority = 6)
	public void validateEmailLabelExists() {
	    test = extent.createTest("Validate Email Label Exists");
	    try {
	        Assert.assertTrue(signUpPage.isEmailLabelVisible(), "Email label does not exist.");
	        test.pass("✅ Email label exists on the page.");
	        System.out.println("[INFO] Email label exists.");
	    } catch (Exception e) {
	        test.fail("❌ Failed to validate Email label existence. Error: " + e.getMessage());
	        System.err.println("[ERROR] Failed to validate Email label existence: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Email label validation failed.", e);
	    }
	}

	@Test(priority = 7)
	public void validateEmailPlaceholderExists() {
	    test = extent.createTest("Validate Email Placeholder Exists");
	    try {
	        Assert.assertTrue(signUpPage.isEmailPlaceholderVisible(), "Email placeholder does not exist.");
	        test.pass("✅ Email placeholder exists on the page.");
	        System.out.println("[INFO] Email placeholder exists.");
	    } catch (Exception e) {
	        test.fail("❌ Failed to validate Email placeholder existence. Error: " + e.getMessage());
	        System.err.println("[ERROR] Failed to validate Email placeholder: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Email placeholder validation failed.", e);
	    }
	}

	@Test(priority = 8)
	public void validateAlreadyHaveAccountLabelExists() {
	    test = extent.createTest("Validate Already Have Account Label Exists");
	    try {
	        Assert.assertTrue(signUpPage.isAlreadyHaveAccountTextVisible(), "Already Have Account Label does not exist.");
	        test.pass("✅ Already Have Account Label exists on the page.");
	        System.out.println("[INFO] Already Have Account Label exists.");
	    } catch (Exception e) {
	        test.fail("❌ Failed to validate Already Have Account Label. Error: " + e.getMessage());
	        System.err.println("[ERROR] Failed to validate Already Have Account Label: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Already Have Account Label validation failed.", e);
	    }
	}

	@Test(priority = 9)
	public void verifyAlreadyHaveAccountText() {
	    test = extent.createTest("Verify Already Have Account Text");
	    try {
	        String actualText = signUpPage.getAlreadyHaveAccountText();
	        Assert.assertEquals(actualText, "Already have an account?", "Already Have Account text is incorrect.");
	        test.pass("✅ Already Have Account text matches the expected value.");
	        System.out.println("[INFO] Already Have Account text matches.");
	    } catch (Exception e) {
	        test.fail("❌ Failed to verify Already Have Account text. Error: " + e.getMessage());
	        System.err.println("[ERROR] Failed to verify Already Have Account text: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Already Have Account text verification failed.", e);
	    }
	}

	@Test(priority = 10)
	public void validateLoginHereTextExists() {
	    test = extent.createTest("Validate Login Here Label Exists");
	    try {
	        Assert.assertTrue(signUpPage.isLoginHereTextVisible(), "Login Here Label does not exist.");
	        test.pass("✅ Login Here Label exists on the page.");
	        System.out.println("[INFO] Login Here Label exists.");
	    } catch (Exception e) {
	        test.fail("❌ Failed to validate Login Here Label. Error: " + e.getMessage());
	        System.err.println("[ERROR] Failed to validate Login Here Label: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Login Here Label validation failed.", e);
	    }
	}

	@Test(priority = 11)
	public void verifyLoginHereText() {
	    test = extent.createTest("Verify Login Here Text");
	    try {
	        String actualText = signUpPage.getLoginHereText();
	        Assert.assertEquals(actualText, "Login Here", "Login Here text is incorrect.");
	        test.pass("✅ Login Here text matches the expected value.");
	        System.out.println("[INFO] Login Here text verified successfully.");
	    } catch (AssertionError e) {
	        test.fail("❌ Failed to verify Login Here text. Error: " + e.getMessage());
	        System.err.println("[ERROR] Login Here text verification failed: " + e.getMessage());
	        throw e; // Ensures the test fails properly
	    } catch (Exception e) {
	        test.fail("❌ Unexpected error while verifying Login Here text: " + e.getMessage());
	        System.err.println("[ERROR] Unexpected error in Login Here text verification: " + e.getMessage());
	        e.printStackTrace();
	        throw new RuntimeException("Unexpected exception during Login Here text verification.", e);
	    }
	}

	@Test(priority = 12)
	public void verifyRegisterNewHeadingLabel() {
	    test = extent.createTest("Verify Heading Label \"Register new account\"");
	    try {
	        Assert.assertTrue(signUpPage.isRegisterHeadingVisible(), "Heading Label is not visible.");
	        test.pass("✅ Heading Label Exists.");
	        System.out.println("[INFO] Register New Account Heading Label is visible.");
	    } catch (AssertionError e) {
	        test.fail("❌ Failed to verify Heading Label: " + e.getMessage());
	        System.err.println("[ERROR] Register New Account Heading Label validation failed: " + e.getMessage());
	        throw e;
	    } catch (Exception e) {
	        test.fail("❌ Unexpected error while verifying Heading Label: " + e.getMessage());
	        System.err.println("[ERROR] Unexpected error in Register New Account Heading Label validation: " + e.getMessage());
	        e.printStackTrace();
	        throw new RuntimeException("Unexpected exception during Heading Label verification.", e);
	    }
	}

	@Test(priority = 13)
	public void verifyRegisterNewHeadingText() {
	    test = extent.createTest("Verify Heading Text \"Register new account\"");
	    try {
	        String actualText = signUpPage.getRegisterHeadingText();
	        Assert.assertEquals(actualText, "Register new account", "Heading text is incorrect.");
	        test.pass("✅ Heading text matches the expected value.");
	        System.out.println("[INFO] Register New Account Heading Text is correct.");
	    } catch (AssertionError e) {
	        test.fail("❌ Failed to verify Heading text: " + e.getMessage());
	        System.err.println("[ERROR] Register New Account Heading text verification failed: " + e.getMessage());
	        throw e;
	    } catch (Exception e) {
	        test.fail("❌ Unexpected error while verifying Heading text: " + e.getMessage());
	        System.err.println("[ERROR] Unexpected error in Register New Account Heading text verification: " + e.getMessage());
	        e.printStackTrace();
	        throw new RuntimeException("Unexpected exception during Heading text verification.", e);
	    }
	}

	@Test(priority = 16)
	public void enterRandomValidEmail() {
	    test = extent.createTest("Enter Random Valid Email");
	    try {
	        randomEamil = CommonFunctions.generateRandomEmail();
	        signUpPage.enterEmail(randomEamil);
	        signUpPage.clickNext();
	        test.pass("✅ Random email entered successfully: " + randomEamil);
	        System.out.println("[INFO] Entered random valid email: " + randomEamil);
	    } catch (Exception e) {
	        test.fail("❌ Failed to enter Random email: " + e.getMessage());
	        System.err.println("[ERROR] Error entering random email: " + e.getMessage());
	        e.printStackTrace();
	        throw new RuntimeException("Unexpected exception while entering random email.", e);
	    }
	}

	@Test(priority = 18)
	public void validateBackButtonExists() {
	    test = extent.createTest("Validate Back Button Presence");
	    try {
	        Assert.assertTrue(loginPage.isBackButtonDisplayed(), "Back button is not displayed on the page.");
	        test.pass("✅ Back button is present on the page.");
	        System.out.println("[INFO] Back button is displayed.");
	    } catch (AssertionError e) {
	        test.fail("❌ Back button validation failed: " + e.getMessage());
	        System.err.println("[ERROR] Back button validation failed: " + e.getMessage());
	        throw e;
	    } catch (Exception e) {
	        test.fail("❌ Unexpected error occurred while validating Back button: " + e.getMessage());
	        System.err.println("[ERROR] Unexpected error in Back button validation: " + e.getMessage());
	        e.printStackTrace();
	        throw new RuntimeException("Unexpected exception during Back button validation.", e);
	    }
	}

	@Test(priority = 19)
	public void verifyBackButtonText() {
	    test = extent.createTest("Verify Back Button Text");
	    try {
	        String actualText = signUpPage.getBackButtonText();
	        Assert.assertEquals(actualText, "Back", "Back button text is incorrect.");
	        test.pass("✅ Back button text matches the expected value.");
	        System.out.println("[INFO] Back button text verified.");
	    } catch (AssertionError e) {
	        test.fail("❌ Failed to validate Back button text: " + e.getMessage());
	        System.err.println("[ERROR] Back button text verification failed: " + e.getMessage());
	        throw e;
	    } catch (Exception e) {
	        test.fail("❌ Unexpected error occurred: " + e.getMessage());
	        System.err.println("[ERROR] Unexpected error in Back button text verification: " + e.getMessage());
	        e.printStackTrace();
	        throw new RuntimeException("Unexpected exception during Back button text verification.", e);
	    }
	}

	@Test(priority = 20)
	public void validateCompanyCodeLabelExists() {
	    test = extent.createTest("Validate Company Code Label Exists");
	    try {
	        Assert.assertTrue(signUpPage.isCompanyCodeLabelVisible(), "Company Code label does not exist.");
	        test.pass("✅ Company Code label exists on the page.");
	        System.out.println("[INFO] Company Code label is visible.");
	    } catch (AssertionError e) {
	        test.fail("❌ Failed to validate Company Code label existence: " + e.getMessage());
	        System.err.println("[ERROR] Company Code label verification failed: " + e.getMessage());
	        throw e;
	    } catch (Exception e) {
	        test.fail("❌ Unexpected error occurred: " + e.getMessage());
	        System.err.println("[ERROR] Unexpected error in Company Code label verification: " + e.getMessage());
	        e.printStackTrace();
	        throw new RuntimeException("Unexpected exception during Company Code label verification.", e);
	    }
	}

	@Test(priority = 21)
    public void validateCompanyCodePlaceholderExists() {
        test = extent.createTest("Validate Company Code Placeholder Exists");
        try {
            Assert.assertTrue(signUpPage.isCompanyCodePlaceholderVisible(), "Company Code placeholder does not exist.");
            test.pass("Company Code placeholder exists on the page.");
        } catch (AssertionError e) {
            test.fail("Company Code placeholder validation failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("Unexpected error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 22)
    public void verifyCompanyCodeLabelText() {
        test = extent.createTest("Verify Company Code Label Text");
        try {
            String actualText = signUpPage.getCompanyCodeLabelText();
            Assert.assertEquals(actualText, "Company Code", "Company Code label text is incorrect.");
            test.pass("Company Code label text matches the expected value.");
        } catch (AssertionError e) {
            test.fail("Company Code label text verification failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("Unexpected error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 23)
    public void verifyCompanyCodePlaceholderText() {
        test = extent.createTest("Verify Company Code Placeholder Text");
        try {
            String actualPlaceholder = signUpPage.getcompanyCodePlaceholderAttribute();
            Assert.assertEquals(actualPlaceholder, "Enter company code", "Company Code placeholder text is incorrect.");
            test.pass("Company Code placeholder text matches the expected value.");
        } catch (AssertionError e) {
            test.fail("Company Code placeholder text verification failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("Unexpected error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 24)
    public void validateContinueButtonExists() {
        test = extent.createTest("Validate Continue Button Exists");
        try {
            Assert.assertTrue(signUpPage.isContinueButtonVisible(), "Continue button does not exist.");
            test.pass("Continue button exists on the page.");
        } catch (AssertionError e) {
            test.fail("Continue button validation failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("Unexpected error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 25)
    public void verifyContinueButtonText() {
        test = extent.createTest("Verify Continue Button Text");
        try {
            String actualText = signUpPage.getContinueButtonText();
            Assert.assertEquals(actualText, "Continue", "Continue button text is incorrect.");
            test.pass("Continue button text matches the expected value.");
        } catch (AssertionError e) {
            test.fail("Continue button text verification failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("Unexpected error occurred: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 26)
    public void clickNextAndHandleCompanyCode() {
        test = extent.createTest("Click Next And Handle Company Code");
        try {
            signUpPage.clickNextAndHandleCompanyCode();
            test.pass("Successfully clicked Next and handled company code.");
        } catch (Exception e) {
            test.fail("Failed to handle company code: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 27)
    public void verifyTitleExists() throws InterruptedException {
        test = extent.createTest("Verify Title Exists");
        try {
            Thread.sleep(1000);
            SignUpPage.closeKeyboardIfOpen(driver);
            Assert.assertTrue(signUpPage.isSelfRegisterTitleVisible(), "Title is not displayed");
            test.pass("Title exists on the page");
        } catch (AssertionError e) {
            test.fail("Title verification failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 28)
    public void verifyEmailLabelExists() {
        test = extent.createTest("Verify Email Label Exists");
        try {
            Assert.assertTrue(signUpPage.isEmailLabelVisible(), "Email label is not displayed");
            test.pass("Email label exists on the page");
        } catch (AssertionError e) {
            test.fail("Email label verification failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 29)
    public void verifyEmailFieldExists() {
        test = extent.createTest("Verify Email Field Exists");
        try {
            Assert.assertTrue(signUpPage.isEmailTextFieldVisible(), "Email field is not displayed");
            test.pass("Email field exists on the page");
        } catch (AssertionError e) {
            test.fail("Email field verification failed: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 30)
    public void verifyFirstNameLabelExists() {
        test = extent.createTest("Verify First Name Label Exists");
        try {
            Assert.assertTrue(signUpPage.isFirstNameLabelVisible(), "First Name label is not displayed");
            test.pass("First Name label exists on the page");
        } catch (AssertionError e) {
            test.fail("First Name label verification failed: " + e.getMessage());
            throw e;
        }
    }
    @Test(priority = 31)
    public void verifyFirstNameFieldExists() {
        test = extent.createTest("Verify First Name Field Exists");
        try {
            Assert.assertTrue(signUpPage.isFirstNameFieldVisible(), "First Name field is not displayed.");
            test.pass("✅ First Name field is visible on the page.");
        } catch (AssertionError e) {
            test.fail("❌ Assertion Failed: First Name field is not displayed.");
            System.err.println("ERROR: First Name field verification failed. Expected: Visible | Actual: Not Visible");
            throw e;
        } catch (Exception e) {
            test.fail("⚠️ Unexpected Error: An exception occurred while verifying the First Name field.");
            System.err.println("EXCEPTION: " + e.getMessage());
            throw new RuntimeException("Unexpected exception during First Name field validation.", e);
        }
    }

    @Test(priority = 32)
    public void verifyLastNameLabelExists() {
        test = extent.createTest("Verify Last Name Label Exists");
        try {
            Assert.assertTrue(signUpPage.isLastNameLabelVisible(), "Last Name label is not displayed.");
            test.pass("✅ Last Name label is visible on the page.");
        } catch (AssertionError e) {
            test.fail("❌ Assertion Failed: Last Name label is not displayed.");
            System.err.println("ERROR: Last Name label verification failed. Expected: Visible | Actual: Not Visible");
            throw e;
        } catch (Exception e) {
            test.fail("⚠️ Unexpected Error: An exception occurred while verifying the Last Name label.");
            System.err.println("EXCEPTION: " + e.getMessage());
            throw new RuntimeException("Unexpected exception during Last Name label validation.", e);
        }
    }

    @Test(priority = 33)
    public void verifyLastNameFieldExists() {
        test = extent.createTest("Verify Last Name Field Exists");
        try {
            Assert.assertTrue(signUpPage.isLastNameFieldVisible(), "Last Name field is not displayed.");
            test.pass("✅ Last Name field is visible on the page.");
        } catch (AssertionError e) {
            test.fail("❌ Assertion Failed: Last Name field is not displayed.");
            System.err.println("ERROR: Last Name field verification failed. Expected: Visible | Actual: Not Visible");
            throw e;
        } catch (Exception e) {
            test.fail("⚠️ Unexpected Error: An exception occurred while verifying the Last Name field.");
            System.err.println("EXCEPTION: " + e.getMessage());
            throw new RuntimeException("Unexpected exception during Last Name field validation.", e);
        }
    }

    @Test(priority = 34)
    public void verifyGenderLabelExists() {
        test = extent.createTest("Verify Gender Label Exists");
        try {
            Assert.assertTrue(signUpPage.isGenderLabelVisible(), "Gender label is not displayed.");
            test.pass("✅ Gender label is visible on the page.");
        } catch (AssertionError e) {
            test.fail("❌ Assertion Failed: Gender label is not displayed.");
            System.err.println("ERROR: Gender label verification failed. Expected: Visible | Actual: Not Visible");
            throw e;
        } catch (Exception e) {
            test.fail("⚠️ Unexpected Error: An exception occurred while verifying the Gender label.");
            System.err.println("EXCEPTION: " + e.getMessage());
            throw new RuntimeException("Unexpected exception during Gender label validation.", e);
        }
    }

    @Test(priority = 35)
    public void verifyMaleRadioButtonExists() {
        test = extent.createTest("Verify Male Radio Button Exists");
        try {
            Assert.assertTrue(signUpPage.isMaleRadioButtonVisible(), "Male radio button is not displayed.");
            test.pass("✅ Male radio button is visible on the page.");
        } catch (AssertionError e) {
            test.fail("❌ Assertion Failed: Male radio button is not displayed.");
            System.err.println("ERROR: Male radio button verification failed. Expected: Visible | Actual: Not Visible");
            throw e;
        } catch (Exception e) {
            test.fail("⚠️ Unexpected Error: An exception occurred while verifying the Male radio button.");
            System.err.println("EXCEPTION: " + e.getMessage());
            throw new RuntimeException("Unexpected exception during Male radio button validation.", e);
        }
    }

    @Test(priority = 36)
    public void verifyFemaleRadioButtonExists() {
        test = extent.createTest("Verify Female Radio Button Exists");
        try {
            Assert.assertTrue(signUpPage.isFemaleRadioButtonVisible(), "Female radio button is not displayed.");
            test.pass("✅ Female radio button is visible on the page.");
        } catch (AssertionError e) {
            test.fail("❌ Assertion Failed: Female radio button is not displayed.");
            System.err.println("ERROR: Female radio button verification failed. Expected: Visible | Actual: Not Visible");
            throw e;
        } catch (Exception e) {
            test.fail("⚠️ Unexpected Error: An exception occurred while verifying the Female radio button.");
            System.err.println("EXCEPTION: " + e.getMessage());
            throw new RuntimeException("Unexpected exception during Female radio button validation.", e);
        }
    }

    @Test(priority = 37)
    public void verifyDateOfBirthLabelExists() {
        test = extent.createTest("Verify Date of Birth Label Exists");
        try {
            Assert.assertTrue(signUpPage.isDateOfBirthLabelVisible(), "Date of Birth label is not displayed.");
            test.pass("✅ Date of Birth label is visible on the page.");
        } catch (AssertionError e) {
            test.fail("❌ Assertion Failed: Date of Birth label is not displayed.");
            System.err.println("ERROR: Date of Birth label verification failed. Expected: Visible | Actual: Not Visible");
            throw e;
        } catch (Exception e) {
            test.fail("⚠️ Unexpected Error: An exception occurred while verifying the Date of Birth label.");
            System.err.println("EXCEPTION: " + e.getMessage());
            throw new RuntimeException("Unexpected exception during Date of Birth label validation.", e);
        }
    }

    @Test(priority = 38)
    public void verifyDateOfBirthFieldExists() {
        test = extent.createTest("Verify Date of Birth Field Exists");
        try {
            Assert.assertTrue(signUpPage.isDateOfBirthFieldVisible(), "Date of Birth field is not displayed.");
            test.pass("✅ Date of Birth field is visible on the page.");
        } catch (AssertionError e) {
            test.fail("❌ Assertion Failed: Date of Birth field is not displayed.");
            System.err.println("ERROR: Date of Birth field verification failed. Expected: Visible | Actual: Not Visible");
            throw e;
        } catch (Exception e) {
            test.fail("⚠️ Unexpected Error: An exception occurred while verifying the Date of Birth field.");
            System.err.println("EXCEPTION: " + e.getMessage());
            throw new RuntimeException("Unexpected exception during Date of Birth field validation.", e);
        }
    }

    @Test(priority = 39)
    public void verifyAddressLabelExists() {
        test = extent.createTest("Verify Address Label Exists");
        try {
            Assert.assertTrue(signUpPage.isAddressLabelVisible(), "Address label is not displayed.");
            test.pass("✅ Address label is visible on the page.");
        } catch (AssertionError e) {
            test.fail("❌ Assertion Failed: Address label is not displayed.");
            System.err.println("ERROR: Address label verification failed. Expected: Visible | Actual: Not Visible");
            throw e;
        } catch (Exception e) {
            test.fail("⚠️ Unexpected Error: An exception occurred while verifying the Address label.");
            System.err.println("EXCEPTION: " + e.getMessage());
            throw new RuntimeException("Unexpected exception during Address label validation.", e);
        }
    }

    @Test(priority = 40)
    public void verifyAddressFieldExists() {
        test = extent.createTest("Verify Address Field Exists");
        try {
            Assert.assertTrue(signUpPage.isAddressFieldVisible(), "Address field is not displayed.");
            test.pass("✅ Address field is visible on the page.");
        } catch (AssertionError e) {
            test.fail("❌ Assertion Failed: Address field is not displayed.");
            System.err.println("ERROR: Address field verification failed. Expected: Visible | Actual: Not Visible");
            throw e;
        } catch (Exception e) {
            test.fail("⚠️ Unexpected Error: An exception occurred while verifying the Address field.");
            System.err.println("EXCEPTION: " + e.getMessage());
            throw new RuntimeException("Unexpected exception during Address field validation.", e);
        }
    }

    @Test(priority = 41)
    public void verifyHomeCityLabelExists() {
        test = extent.createTest("Verify Home City Label Exists");
        
        try {
            Assert.assertTrue(signUpPage.isHomeCityLabelVisible(), 
                    "❌ Home City label is NOT displayed.");
            test.pass("✅ Home City label is correctly displayed.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Home City label verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        } catch (Exception e) {
            String unexpectedError = "❗ Unexpected error while verifying Home City label: " + e.getMessage();
            System.out.println(unexpectedError);
            test.fail(unexpectedError);
            throw new RuntimeException("Unexpected exception in Home City label validation.", e);
        }
    }

    @Test(priority = 42)
    public void verifyHomeCityFieldExists() {
        test = extent.createTest("Verify Home City Field Exists");
        
        try {
            Assert.assertTrue(signUpPage.isHomeCityFieldVisible(), 
                    "❌ Home City field is NOT displayed.");
            test.pass("✅ Home City field is correctly displayed.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Home City field verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        } catch (Exception e) {
            String unexpectedError = "❗ Unexpected error while verifying Home City field: " + e.getMessage();
            System.out.println(unexpectedError);
            test.fail(unexpectedError);
            throw new RuntimeException("Unexpected exception in Home City field validation.", e);
        }
    }

    @Test(priority = 43)
    public void verifyPhoneNumberLabelExists() {
        test = extent.createTest("Verify Phone Number Label Exists");
        
        try {
            Assert.assertTrue(signUpPage.isPhoneNumberLabelVisible(), 
                    "❌ Phone Number label is NOT displayed.");
            test.pass("✅ Phone Number label is correctly displayed.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Phone Number label verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        } catch (Exception e) {
            String unexpectedError = "❗ Unexpected error while verifying Phone Number label: " + e.getMessage();
            System.out.println(unexpectedError);
            test.fail(unexpectedError);
            throw new RuntimeException("Unexpected exception in Phone Number label validation.", e);
        }
    }

    @Test(priority = 44)
    public void verifyPhoneNumberFieldExists() {
        test = extent.createTest("Verify Phone Number Field Exists");
        
        try {
            SignUpPage.closeKeyboardIfOpen(driver);
            signUpPage.swipeUp();
            
            Assert.assertTrue(signUpPage.isPhoneNumberFieldVisible(), 
                    "❌ Phone Number field is NOT displayed.");
            test.pass("✅ Phone Number field is correctly displayed.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Phone Number field verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        } catch (Exception e) {
            String unexpectedError = "❗ Unexpected error while verifying Phone Number field: " + e.getMessage();
            System.out.println(unexpectedError);
            test.fail(unexpectedError);
            throw new RuntimeException("Unexpected exception in Phone Number field validation.", e);
        }
    }

    @Test(priority = 45)
    public void verifyRegisterButtonExists() {
        test = extent.createTest("Verify Register Button Exists");
        
        try {
            Assert.assertTrue(signUpPage.isRegisterButtonVisible(), 
                    "❌ Register button is NOT displayed.");
            test.pass("✅ Register button is correctly displayed.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Register button verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        } catch (Exception e) {
            String unexpectedError = "❗ Unexpected error while verifying Register button: " + e.getMessage();
            System.out.println(unexpectedError);
            test.fail(unexpectedError);
            throw new RuntimeException("Unexpected exception in Register button validation.", e);
        }
    }

    @Test(priority = 46)
    public void verifySelfRegistrationTitleText() {
        test = extent.createTest("Verify Title Text");
        
        try {
            String expectedText = "Self Registration";
            String actualText = signUpPage.getSelfRegistrationTitleText();
            
            Assert.assertEquals(actualText, expectedText, 
                    "❌ Title text does NOT match. Expected: '" + expectedText + "', but found: '" + actualText + "'.");
            test.pass("✅ Title text is correctly displayed: '" + expectedText + "'.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Title text verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        } catch (Exception e) {
            String unexpectedError = "❗ Unexpected error while verifying title text: " + e.getMessage();
            System.out.println(unexpectedError);
            test.fail(unexpectedError);
            throw new RuntimeException("Unexpected exception in title text validation.", e);
        }
    }

    @Test(priority = 47)
    public void verifyEmailLabelTextOnRegistrationForm() {
        test = extent.createTest("Verify Email Label Text");
        
        try {
            String expectedText = "Email";
            String actualText = signUpPage.getEmailLabelText();
            
            Assert.assertEquals(actualText, expectedText, 
                    "❌ Email label text does NOT match. Expected: '" + expectedText + "', but found: '" + actualText + "'.");
            test.pass("✅ Email label text is correctly displayed: '" + expectedText + "'.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Email label text verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        } catch (Exception e) {
            String unexpectedError = "❗ Unexpected error while verifying Email label text: " + e.getMessage();
            System.out.println(unexpectedError);
            test.fail(unexpectedError);
            throw new RuntimeException("Unexpected exception in Email label text validation.", e);
        }
    }

    @Test(priority = 48)
    public void verifyFirstNameLabelText() {
        test = extent.createTest("Verify First Name Label Text");
        
        try {
            String expectedText = "First Name";
            String actualText = signUpPage.getFirstNameLabelText();
            
            Assert.assertEquals(actualText, expectedText, 
                    "❌ First Name label text does NOT match. Expected: '" + expectedText + "', but found: '" + actualText + "'.");
            test.pass("✅ First Name label text is correctly displayed: '" + expectedText + "'.");
        } catch (AssertionError e) {
            String errorMessage = "❌ First Name label text verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 49)
    public void verifyLastNameLabelText() {
        test = extent.createTest("Verify Last Name Label Text");
        
        try {
            String expectedText = "Last Name";
            String actualText = signUpPage.getLastNameLabelText();
            
            Assert.assertEquals(actualText, expectedText, 
                    "❌ Last Name label text does NOT match. Expected: '" + expectedText + "', but found: '" + actualText + "'.");
            test.pass("✅ Last Name label text is correctly displayed: '" + expectedText + "'.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Last Name label text verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }
    @Test(priority = 50)
    public void verifyGenderLabelText() {
        test = extent.createTest("Verify Gender Label Text");
        try {
            String expectedText = "Gender";
            String actualText = signUpPage.getGenderLabelText();
            
            Assert.assertEquals(actualText, expectedText, 
                    "❌ Gender label text does NOT match. Expected: '" + expectedText + "', but found: '" + actualText + "'.");
            test.pass("✅ Gender label text is correct: '" + expectedText + "'.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Gender label text verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 51)
    public void verifyDateOfBirthLabelText() {
        test = extent.createTest("Verify Date of Birth Label Text");
        try {
            String expectedText = "Date of Birth";
            String actualText = signUpPage.getDateOfBirthLabelText();
            
            Assert.assertEquals(actualText, expectedText, 
                    "❌ Date of Birth label text does NOT match. Expected: '" + expectedText + "', but found: '" + actualText + "'.");
            test.pass("✅ Date of Birth label text is correct: '" + expectedText + "'.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Date of Birth label text verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 52)
    public void verifyAddressLabelText() {
        test = extent.createTest("Verify Address Label Text");
        try {
            String expectedText = "Address";
            String actualText = signUpPage.getAddressLabelText();
            
            Assert.assertEquals(actualText, expectedText, 
                    "❌ Address label text does NOT match. Expected: '" + expectedText + "', but found: '" + actualText + "'.");
            test.pass("✅ Address label text is correct: '" + expectedText + "'.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Address label text verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 53)
    public void verifyHomeCityLabelText() {
        test = extent.createTest("Verify Home City Label Text");
        try {
            String expectedText = "Home City";
            String actualText = signUpPage.getHomeCityLabelText();
            
            Assert.assertEquals(actualText, expectedText, 
                    "❌ Home City label text does NOT match. Expected: '" + expectedText + "', but found: '" + actualText + "'.");
            test.pass("✅ Home City label text is correct: '" + expectedText + "'.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Home City label text verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 54)
    public void verifyPhoneNumberLabelText() {
        test = extent.createTest("Verify Phone Number Label Text");
        try {
            String expectedText = "Phone Number";
            String actualText = signUpPage.getPhoneNumberLabelText();
            
            Assert.assertEquals(actualText, expectedText, 
                    "❌ Phone Number label text does NOT match. Expected: '" + expectedText + "', but found: '" + actualText + "'.");
            test.pass("✅ Phone Number label text is correct: '" + expectedText + "'.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Phone Number label text verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 55)
    public void verifyEmailFieldIsClickable() {
        test = extent.createTest("Verify Email Field Is Clickable");
        try {
            Assert.assertTrue(signUpPage.isTextFieldClickable(), 
                    "❌ Email field is NOT clickable.");
            test.pass("✅ Email field is clickable.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Email field clickability verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }
    @Test(priority = 56)
    public void verifyFirstNameFieldIsClickable() {
        test = extent.createTest("Verify First Name Field Is Clickable");
        try {
            Assert.assertTrue(signUpPage.isFirstNameFieldClickable(), 
                    "❌ First Name field is NOT clickable.");
            test.pass("✅ First Name field is clickable.");
        } catch (AssertionError e) {
            String errorMessage = "❌ First Name field clickability verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 57)
    public void verifyLastNameFieldIsClickable() {
        test = extent.createTest("Verify Last Name Field Is Clickable");
        try {
            Assert.assertTrue(signUpPage.isLastNameFieldClickable(), 
                    "❌ Last Name field is NOT clickable.");
            test.pass("✅ Last Name field is clickable.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Last Name field clickability verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 58)
    public void verifyDOBFieldIsClickable() {
        test = extent.createTest("Verify Date of Birth Field Is Clickable");
        try {
            Assert.assertTrue(signUpPage.isDOBFieldClickable(), 
                    "❌ Date of Birth field is NOT clickable.");
            test.pass("✅ Date of Birth field is clickable.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Date of Birth field clickability verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 59)
    public void verifyAddressFieldIsClickable() {
        test = extent.createTest("Verify Address Field Is Clickable");
        try {
            Assert.assertTrue(signUpPage.isAddressFieldClickable(), 
                    "❌ Address field is NOT clickable.");
            test.pass("✅ Address field is clickable.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Address field clickability verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 60)
    public void verifyHomeCityFieldIsClickable() {
        test = extent.createTest("Verify Home City Field Is Clickable");
        try {
            Assert.assertTrue(signUpPage.isHomeCityFieldClickable(), 
                    "❌ Home City field is NOT clickable.");
            test.pass("✅ Home City field is clickable.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Home City field clickability verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 61)
    public void verifyPhoneNumberFieldIsClickable() {
        test = extent.createTest("Verify Phone Number Field Is Clickable");
        try {
            Assert.assertTrue(signUpPage.isPhoneNumberFieldClickable(), 
                    "❌ Phone Number field is NOT clickable.");
            test.pass("✅ Phone Number field is clickable.");
        } catch (AssertionError e) {
            String errorMessage = "❌ Phone Number field clickability verification failed: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    // ✅ POSITIVE TEST CASES

    @Test(priority = 62)
    public void enterFirstName() {
        test = extent.createTest("Enter First Name");
        try {
            signUpPage.enterFirstName("John");
            test.pass("✅ First name 'John' entered successfully.");
            System.out.println("✅ First name 'John' entered successfully.");
        } catch (Exception e) {
            String errorMessage = "❌ Failed to enter first name: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 63)
    public void enterLastName() {
        test = extent.createTest("Enter Last Name");
        try {
            signUpPage.enterLastName("Doe");
            test.pass("✅ Last name 'Doe' entered successfully.");
            System.out.println("✅ Last name 'Doe' entered successfully.");
        } catch (Exception e) {
            String errorMessage = "❌ Failed to enter last name: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 64)
    public void enterHomeCity() {
        test = extent.createTest("Enter Home City");
        try {
            signUpPage.enterHomeCity("Islamabad");
            test.pass("✅ Home city 'Islamabad' entered successfully.");
            System.out.println("✅ Home city 'Islamabad' entered successfully.");
        } catch (Exception e) {
            String errorMessage = "❌ Failed to enter home city: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 65)
    public void enterPhoneNumber() {
        test = extent.createTest("Enter Phone Number");
        try {
            signUpPage.swipeUp();
            signUpPage.enterPhoneNumber("12312312312");
            test.pass("✅ Phone number '12312312312' entered successfully.");
            System.out.println("✅ Phone number '12312312312' entered successfully.");
        } catch (Exception e) {
            String errorMessage = "❌ Failed to enter phone number: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }
    
    @Test(priority = 66)
    public void pressRegisterButton() {
        test = extent.createTest("Press Register Button");
        try {
            signUpPage.clickRegisterButton();
            test.pass("✅ Register button clicked successfully.");
            System.out.println("✅ Register button clicked successfully.");
        } catch (Exception e) {
            String errorMessage = "❌ Failed to click Register button: " + e.getMessage();
            System.out.println(errorMessage);
            test.fail(errorMessage);
            throw e;
        }
    }

    @Test(priority = 67)
    public boolean verifySignUpProcess() {
        test = extent.createTest("Verify Sign-Up Form Submission and Navigation to Login Screen");
        try {
            // Validate if the user is navigated to the Login screen
            if (!loginPage.isSignInHeadingDisplayed()) {
                test.fail("❌ Login screen is not displayed after sign-up.");
                return false;
            }
            test.pass("✅ User successfully navigated to the Login screen.");

            // Validate if the success message is displayed
            if (!loginPage.isBackenedErrorDisplayed()) {
                test.fail("❌ Success message is not displayed.");
                return false;
            }
            test.pass("✅ Success message is displayed after sign-up.");

            // Define expected messages
            String expectedMessage1 = "Your request has been successfully submitted. You can now access your account by logging in. If you have additional questions, contact Global Rescue at +1 (617) 459-4200 or email memberservices@globalrescue.com";
            String expectedMessage2 = "Signup form submitted successfully. Your signup request is pending for approval from your company/account administrator";

            // Validate displayed message
            if (!loginPage.ErrorText(expectedMessage1) && !loginPage.ErrorText(expectedMessage2)) {
                test.fail("❌ Displayed success message does not match expected messages.");
                return false;
            }
            test.pass("✅ Correct success message is displayed.");
            return true;
        } catch (Exception e) {
            test.fail("❌ Exception encountered during Sign-Up verification: " + e.getMessage());
            return false;
        }
    }


    @Test(priority = 68)
    public void againGoToSignUpForm() throws Exception {
        test = extent.createTest("Again Set Up SignUp Form");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.RegisterNowButton)).click();
            randomEamil = CommonFunctions.generateRandomEmail();
            signUpPage.enterEmail(randomEamil);
            signUpPage.clickNext();
            signUpPage.clickNextAndHandleCompanyCode();
            Thread.sleep(1000);
            SignUpPage.closeKeyboardIfOpen(driver);
        } catch (Exception e) {
            test.fail("❌ Failed to set up Sign-Up Form: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 69)
    public void leaveFirstNameEmpty() {
        test = extent.createTest("Leave First Name Empty");
        try {
            signUpPage.enterFirstName("");
            signUpPage.enterLastName("Doe");
            signUpPage.enterHomeCity("New York");
            signUpPage.swipeUp();
            signUpPage.enterPhoneNumber("12312312312");
            signUpPage.clickRegisterButton();

            Assert.assertTrue(loginPage.isErrorDisplayed(), "❌ Error message not displayed for empty first name.");
            test.pass("✅ Error message displayed for empty first name.");
        } catch (AssertionError e) {
            test.fail("❌ Validation failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("❌ An unexpected error occurred: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 70)
    public void firstNameEmptyErrorText() {
        test = extent.createTest("Verify the error text if First Name is empty");
        try {
            Assert.assertTrue(loginPage.ErrorText("Please complete the form by filling the highlighted fields."),
                    "❌ Incorrect error message displayed.");
            test.pass("✅ Correct error message displayed: 'Please complete the form by filling the highlighted fields.'");
        } catch (Exception e) {
            test.fail("❌ Exception occurred while verifying the error text: " + e.getMessage());
            throw e;
        }

        try {
            loginPage.closeErrorBanner();
        } catch (TimeoutException e) {
            System.out.println("⚠️ Error banner not found: " + e.getMessage());
        }
    }

    @Test(priority = 71)
    public void leaveLastNameEmpty() {
        test = extent.createTest("Leave Last Name Empty");
        try {
            signUpPage.enterFirstName("John");
            signUpPage.enterLastName("");
            signUpPage.enterHomeCity("New York");
            signUpPage.swipeUp();
            signUpPage.enterPhoneNumber("12312312312");
            signUpPage.clickRegisterButton();

            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message not displayed for empty last name.");
            test.pass("✅ Error message displayed for empty last name.");
        } catch (AssertionError e) {
            test.fail("❌ Error validation failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("❌ An unexpected error occurred: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 72)
    public void lastNameEmptyErrorText() {
        test = extent.createTest("Verify error text when Last Name is empty");
        try {
            Assert.assertTrue(loginPage.ErrorText("Please complete the form by filling the highlighted fields."),
                              "Error message did not match the expected text.");
            test.pass("✅ Correct error message displayed: 'Please complete the form by filling the highlighted fields.'");
        } catch (Exception e) {
            test.fail("❌ Exception while verifying error text: " + e.getMessage());
            throw e;
        }
        try {
            loginPage.closeErrorBanner();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 73)
    public void InvalidPhoneNumber() {
        test = extent.createTest("Verify error message for invalid phone number");
        try {
            signUpPage.enterFirstName("John");
            signUpPage.enterLastName("Doe");
            signUpPage.enterHomeCity("New York");
            signUpPage.swipeUp();
            signUpPage.enterPhoneNumber("1234567890");  // Invalid phone number
            signUpPage.clickRegisterButton();

            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message not displayed for invalid phone number.");
            test.pass("✅ Error message displayed for invalid phone number.");
        } catch (AssertionError e) {
            test.fail("❌ Failed to validate error message for invalid phone number: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("❌ An unexpected error occurred: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 74)
    public void InvalidPhoneNumberErrorText() {
        test = extent.createTest("Verify error message text for invalid Phone Number");
        try {
            Assert.assertTrue(loginPage.ErrorText("Phone Number is invalid"), 
                              "Error message did not match expected text.");
            test.pass("✅ Correct error message displayed: 'Phone Number is invalid'");
        } catch (Exception e) {
            test.fail("❌ Exception while verifying error text: " + e.getMessage());
            throw e;
        }
        try {
            loginPage.closeErrorBanner();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
    @Test(priority = 75)
    public void leaveHomeCityEmpty() {
        test = extent.createTest("Leave Home City Empty");
        try {
            signUpPage.enterFirstName("John");
            signUpPage.enterLastName("Doe");
            signUpPage.swipeUp();
            signUpPage.enterPhoneNumber("1234567890");
            signUpPage.enterHomeCity("");
            signUpPage.clickRegisterButton();

            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message not displayed for empty home city.");
            test.pass("✅ Error message displayed for empty home city.");
        } catch (Exception e) {
            test.fail("❌ Failed to validate empty home city field: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 76)
    public void HomeEmptyErrorText() {
        test = extent.createTest("Verify the error text if Home City is empty");
        try {
            Assert.assertTrue(loginPage.ErrorText("Please complete the form by filling the highlighted fields."),
                              "Error message did not match the expected text.");
            test.pass("✅ Correct error text displayed: 'Please complete the form by filling the highlighted fields.'");
        } catch (Exception e) {
            test.fail("❌ Exception while verifying error text: " + e.getMessage());
            throw e;
        }
        try {
            loginPage.closeErrorBanner();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 77)
    public void leavePhoneNumberEmpty() {
        test = extent.createTest("Leave Phone Number Empty");
        try {
            signUpPage.enterFirstName("John");
            signUpPage.enterLastName("Doe");
            signUpPage.enterHomeCity("New York");
            signUpPage.swipeUp();
            signUpPage.enterPhoneNumber("");
            signUpPage.clickRegisterButton();

            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message not displayed for empty phone number.");
            test.pass("✅ Error message displayed for empty phone number.");
        } catch (Exception e) {
            test.fail("❌ Failed to validate empty phone number field: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 78)
    public void PhoneNumberEmptyErrorText() throws TimeoutException {
        test = extent.createTest("Verify the error text if Phone Number is empty");
        try {
            Assert.assertTrue(loginPage.ErrorText("Please complete the form by filling the highlighted fields."),
                              "Error message did not match expected text.");
            test.pass("✅ Correct error text displayed: 'Please complete the form by filling the highlighted fields.'");
        } catch (Exception e) {
            test.fail("❌ Exception while verifying error text: " + e.getMessage());
            throw e;
        }
        try {
            loginPage.closeErrorBanner();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 79)
    public void fillAllCompulsoryFieldsWithInvalidPhoneNumber() {
        test = extent.createTest("Fill All Compulsory Fields with Invalid Phone Number");
        try {
            signUpPage.enterFirstName("John");
            signUpPage.enterLastName("Doe");
            signUpPage.enterHomeCity("New York");
            signUpPage.swipeUp();
            signUpPage.enterPhoneNumber("111111111"); // Invalid phone number
            signUpPage.clickRegisterButton();

            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message not displayed for invalid phone number.");
            test.pass("✅ Error message displayed for invalid phone number.");
        } catch (Exception e) {
            test.fail("❌ Failed to validate invalid phone number field: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 80)
    public void enterSpecialCharactersInFields() {
        test = extent.createTest("Enter Special Characters in Fields");
        try {
            signUpPage.enterFirstName("@@@###");
            signUpPage.enterLastName("$$$%%%");
            signUpPage.enterHomeCity("***&&&");
            signUpPage.swipeUp();
            signUpPage.enterPhoneNumber("12312312312");
            signUpPage.clickRegisterButton();

            boolean isSignUpSuccessful = verifySignUpProcess();
            Assert.assertTrue(isSignUpSuccessful, "Sign-up verification failed with special characters.");
            test.pass("✅ System correctly handled special characters.");
        } catch (Exception e) {
            test.fail("❌ Failed to validate special characters input: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 81)
    public void validateRegisterWithLeadingAndTrailingSpaces() throws Exception {
        test = extent.createTest("Validate Register with Leading and Trailing Spaces");
        try {
            againGoToSignUpForm();
            SignUpPage.closeKeyboardIfOpen(driver);

            signUpPage.enterFirstName(" John ");
            signUpPage.enterLastName(" Doe ");
            signUpPage.enterHomeCity(" New York ");
            signUpPage.swipeUp();
            signUpPage.enterPhoneNumber("      12312312312 ");
            signUpPage.clickRegisterButton();

            boolean isSignUpSuccessful = verifySignUpProcess();
            Assert.assertTrue(isSignUpSuccessful, "Sign-up verification failed with leading and trailing spaces.");
            test.pass("✅ System correctly handled leading and trailing spaces.");
        } catch (Exception e) {
            test.fail("❌ Failed to register with leading and trailing spaces: " + e.getMessage());
            throw e;
        }
    }
   

	@AfterClass
	public void tearDown() {
		test = extent.createTest("TearDown", "Tearing down after the tests.");
		try {
			if (driver != null) {
				driver.quit();
				test.info("Driver session ended successfully.");
			}
		} catch (Exception e) {
			test.fail("Failed to quit the driver: " + e.getMessage());
		}
		extent.flush(); // Write the results to the report
	}
}
