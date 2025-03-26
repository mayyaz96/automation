package TestCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseSetup;
import pages.LoginPage;
import pages.PermissionsPage;
import pages.SignUpPage;
import pages.WalkthroughPage;
import utilities.ExtentReportsManager;

public class WalkThroughTest extends BaseSetup {
    private WalkthroughPage walkthroughPage;
    private ExtentReports extent;
    private ExtentTest test;
    private WebDriverWait wait;
    
    @BeforeSuite
    public void setupExtentReports() {
        extent = ExtentReportsManager.getExtentReports();
    }

    @BeforeClass
    public void setup() {
        driver = getDriver();  // Ensure driver is initialized

        if (driver == null) {
            throw new RuntimeException("❌ Driver is NULL! Ensure Appium server is running and driver is set up correctly.");
        }

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Initialize ExtentReports & create a test case
        extent = ExtentReportsManager.getExtentReports();
        test = extent.createTest("WalkthroughSwipe Test");

        // Initialize WalkthroughPage
        walkthroughPage = new WalkthroughPage(driver, wait);

        System.out.println("✅ Setup completed for Walkthrough Test.");
    }

    @Test(priority = 1)
    public void verifyFirstScreenDXLogoDisplayed() {
        test = extent.createTest("Verify DX Logo is Displayed");
        try {
            Assert.assertTrue(walkthroughPage.isDXLogoDisplayed(), "❌ DX Logo is NOT displayed!");
            test.pass("✅ DX Logo is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ DX Logo verification failed: " + e.getMessage());
            Assert.fail("DX Logo not found!", e);
        }
    }
    @Test(priority = 2)
    public void verifyFirstScreenSkipButton() {
        test = extent.createTest("Verify Skip Button");
        try {
            Assert.assertTrue(walkthroughPage.isSkipButtonClickable(), "❌ Skip button is NOT clickable!");
            Assert.assertEquals(walkthroughPage.getSkipButtonText(), "Skip", "❌ Skip button text mismatch!");
            test.pass("✅ Skip button is clickable and has correct text.");
        } catch (Exception e) {
            test.fail("❌ Skip button verification failed: " + e.getMessage());
            Assert.fail("Skip button issue!", e);
        }
    }
    @Test(priority = 3)
    public void verifyFirstScreenUpperText() {
        test = extent.createTest("Verify Upper Text");
        try {
            Assert.assertTrue(walkthroughPage.isUpperTextDisplayed(), "❌ Upper text is NOT displayed!");
            Assert.assertEquals(walkthroughPage.getUpperText(), "Emergency", "❌ Upper text mismatch!");
            test.pass("✅ Upper text is displayed and correct.");
        } catch (Exception e) {
            test.fail("❌ Upper text verification failed: " + e.getMessage());
            Assert.fail("Upper text issue!", e);
        }
    }
    @Test(priority = 4)
    public void verifyFirstScreenLowerText() {
        test = extent.createTest("Verify Lower Text");
        try {
            Assert.assertTrue(walkthroughPage.isLowerTextDisplayed(), "❌ Lower text is NOT displayed!");
            Assert.assertEquals(walkthroughPage.getLowerText(), 
                "Instantly connect with Global Rescue's operations team with the tap of a button for rapid assistance, ensuring immediate help when you need it most.",
                "❌ Lower text mismatch!");
            test.pass("✅ Lower text is displayed and correct.");
        } catch (Exception e) {
            test.fail("❌ Lower text verification failed: " + e.getMessage());
            Assert.fail("Lower text issue!", e);
        }
    }
    @Test(priority = 5)
    public void verifyFirstScreenFrameLayoutExists() {
        test = extent.createTest("Verify Frame Layout Exists");
        try {
            Assert.assertTrue(walkthroughPage.isFrameLayoutDisplayed(), "❌ Frame layout is NOT displayed!");
            test.pass("✅ Frame layout is displayed.");
        } catch (Exception e) {
            test.fail("❌ Frame layout verification failed: " + e.getMessage());
            Assert.fail("Frame layout not found!", e);
        }
    }
    @Test(priority = 6)
    public void verifyFirstScreenImageIsSwipeable() {
        test = extent.createTest("Verify Image is Swipeable");
        try {
            Assert.assertTrue(walkthroughPage.isImageSwipeable(), "❌ Image is NOT swipeable!");
            test.pass("✅ Image is swipeable.");
        } catch (Exception e) {
            test.fail("❌ Image swipeability verification failed: " + e.getMessage());
            Assert.fail("Image swipeability check failed!", e);
        }
    }

    @Test(priority = 7, description = "Verify that the walkthrough indicator is displayed")
    public void verifyFirstScreenWalkthroughIndicatorIsDisplayed() {
        test = extent.createTest("Verify Walkthrough Indicator Display");

        try {
            Assert.assertTrue(walkthroughPage.isIndicatorDisplayed(), "❌ Walkthrough indicator is NOT visible.");
            test.pass("✅ Walkthrough indicator is correctly displayed.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify walkthrough indicator: " + e.getMessage());
            Assert.fail("Walkthrough indicator verification failed!", e);
        }
    }
    @Test(priority = 8, description = "Verify that the walkthrough indicator is clickable")
    public void verifyFirstScreenWalkthroughIndicatorIsClickable() {
        test = extent.createTest("Verify Walkthrough Indicator Clickability");

        try {
            Assert.assertTrue(walkthroughPage.isIndicatorClickable(), "❌ Walkthrough indicator is NOT clickable.");
            test.pass("✅ Walkthrough indicator is clickable.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify walkthrough indicator clickability: " + e.getMessage());
            Assert.fail("Walkthrough indicator clickability verification failed!", e);
        }
    }


    @Test(priority = 9, description = "Swipe the first image in the Walkthrough screen")
    public void verifySwipeOnFirstImage() {
        test = extent.createTest("Verify Swipe Action on First Image");

        try {
            test.log(Status.INFO, "Initiating swipe action on the first walkthrough image.");

            // Perform the swipe action
            walkthroughPage.swipeLeft();

            test.pass("✅ Successfully swiped left on the first walkthrough image.");
        } catch (Exception e) {
            test.fail("❌ Swipe action failed due to exception: " + e.getMessage());
            Assert.fail("Swipe action on the first image was unsuccessful!", e);
        }
    }
    @Test(priority = 10)
    public void verifySecondScreenDXLogoDisplayed() {
        test = extent.createTest("Verify DX Logo is Displayed");
        try {
            Assert.assertTrue(walkthroughPage.isDXLogoDisplayed(), "❌ DX Logo is NOT displayed!");
            test.pass("✅ DX Logo is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ DX Logo verification failed: " + e.getMessage());
            Assert.fail("DX Logo not found!", e);
        }
    }
    @Test(priority =11)
    public void verifySecondScreenSkipButton() {
        test = extent.createTest("Verify Skip Button");
        try {
            Assert.assertTrue(walkthroughPage.isSkipButtonClickable(), "❌ Skip button is NOT clickable!");
            Assert.assertEquals(walkthroughPage.getSkipButtonText(), "Skip", "❌ Skip button text mismatch!");
            test.pass("✅ Skip button is clickable and has correct text.");
        } catch (Exception e) {
            test.fail("❌ Skip button verification failed: " + e.getMessage());
            Assert.fail("Skip button issue!", e);
        }
    }
    @Test(priority = 12)
    public void verifySecondScreenUpperText() {
        test = extent.createTest("Verify Upper Text");
        try {
            Assert.assertTrue(walkthroughPage.isUpperTextDisplayed(), "❌ Upper text is NOT displayed!");
            Assert.assertEquals(walkthroughPage.getUpperText(), "Events & Alerts", "❌ Upper text mismatch!");
            test.pass("✅ Upper text is displayed and correct.");
        } catch (Exception e) {
            test.fail("❌ Upper text verification failed: " + e.getMessage());
            Assert.fail("Upper text issue!", e);
        }
    }
    @Test(priority = 13)
    public void verifySecondScreenLowerText() {
        test = extent.createTest("Verify Lower Text");
        try {
            Assert.assertTrue(walkthroughPage.isLowerTextDisplayed(), "❌ Lower text is NOT displayed!");
            Assert.assertEquals(walkthroughPage.getLowerText(), 
            		"Stay informed of unfolding global events, ensuring you are well-versed in current happenings around the world.",
            				 "❌ Lower text mismatch!");
            test.pass("✅ Lower text is displayed and correct.");
        } catch (Exception e) {
            test.fail("❌ Lower text verification failed: " + e.getMessage());
            Assert.fail("Lower text issue!", e);
        }
    }
    @Test(priority = 14)
    public void verifySecondScreenFrameLayoutExists() {
        test = extent.createTest("Verify Frame Layout Exists");
        try {
            Assert.assertTrue(walkthroughPage.isFrameLayoutDisplayed(), "❌ Frame layout is NOT displayed!");
            test.pass("✅ Frame layout is displayed.");
        } catch (Exception e) {
            test.fail("❌ Frame layout verification failed: " + e.getMessage());
            Assert.fail("Frame layout not found!", e);
        }
    }
    @Test(priority = 15)
    public void verifySecondScreenImageIsSwipeable() {
        test = extent.createTest("Verify Image is Swipeable");
        try {
            Assert.assertTrue(walkthroughPage.isImageSwipeable(), "❌ Image is NOT swipeable!");
            test.pass("✅ Image is swipeable.");
        } catch (Exception e) {
            test.fail("❌ Image swipeability verification failed: " + e.getMessage());
            Assert.fail("Image swipeability check failed!", e);
        }
    }

    @Test(priority = 16, description = "Verify that the walkthrough indicator is displayed")
    public void verifySecondScreenWalkthroughIndicatorIsDisplayed() {
        test = extent.createTest("Verify Walkthrough Indicator Display");

        try {
            Assert.assertTrue(walkthroughPage.isIndicatorDisplayed(), "❌ Walkthrough indicator is NOT visible.");
            test.pass("✅ Walkthrough indicator is correctly displayed.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify walkthrough indicator: " + e.getMessage());
            Assert.fail("Walkthrough indicator verification failed!", e);
        }
    }
    @Test(priority = 17, description = "Verify that the walkthrough indicator is clickable")
    public void verifySecondScreenWalkthroughIndicatorIsClickable() {
        test = extent.createTest("Verify Walkthrough Indicator Clickability");

        try {
            Assert.assertTrue(walkthroughPage.isIndicatorClickable(), "❌ Walkthrough indicator is NOT clickable.");
            test.pass("✅ Walkthrough indicator is clickable.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify walkthrough indicator clickability: " + e.getMessage());
            Assert.fail("Walkthrough indicator clickability verification failed!", e);
        }
    }
    @Test(priority = 18, description = "Swipe the first image in the Walkthrough screen")
    public void verifySwipeOnSecondImage() {
        test = extent.createTest("Verify Swipe Action on First Image");

        try {
            test.log(Status.INFO, "Initiating swipe action on the first walkthrough image.");

            // Perform the swipe action
            walkthroughPage.swipeLeft();

            test.pass("✅ Successfully swiped left on the first walkthrough image.");
        } catch (Exception e) {
            test.fail("❌ Swipe action failed due to exception: " + e.getMessage());
            Assert.fail("Swipe action on the first image was unsuccessful!", e);
        }
    }
    @Test(priority = 19)
    public void verifyThirdScreenDXLogoDisplayed() {
        test = extent.createTest("Verify DX Logo is Displayed");
        try {
            Assert.assertTrue(walkthroughPage.isDXLogoDisplayed(), "❌ DX Logo is NOT displayed!");
            test.pass("✅ DX Logo is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ DX Logo verification failed: " + e.getMessage());
            Assert.fail("DX Logo not found!", e);
        }
    }
    @Test(priority = 20)
    public void verifyThirdScreenSkipButton() {
        test = extent.createTest("Verify Skip Button");
        try {
            Assert.assertTrue(walkthroughPage.isSkipButtonClickable(), "❌ Skip button is NOT clickable!");
            Assert.assertEquals(walkthroughPage.getSkipButtonText(), "Skip", "❌ Skip button text mismatch!");
            test.pass("✅ Skip button is clickable and has correct text.");
        } catch (Exception e) {
            test.fail("❌ Skip button verification failed: " + e.getMessage());
            Assert.fail("Skip button issue!", e);
        }
    }
    @Test(priority = 21)
    public void verifyThirdScreenUpperText() {
        test = extent.createTest("Verify Upper Text");
        try {
            Assert.assertTrue(walkthroughPage.isUpperTextDisplayed(), "❌ Upper text is NOT displayed!");
            Assert.assertEquals(walkthroughPage.getUpperText(), "Destination Reports", "❌ Upper text mismatch!");
            test.pass("✅ Upper text is displayed and correct.");
        } catch (Exception e) {
            test.fail("❌ Upper text verification failed: " + e.getMessage());
            Assert.fail("Upper text issue!", e);
        }
    }
    @Test(priority = 22)
    public void verifyThirdScreenLowerText() {
        test = extent.createTest("Verify Lower Text");
        try {
            Assert.assertTrue(walkthroughPage.isLowerTextDisplayed(), "❌ Lower text is NOT displayed!");
            Assert.assertEquals(walkthroughPage.getLowerText(), 
            		"Download comprehensive intelligence reports for up to 215 countries and territories on your device, even while on the go.",              
            				 "❌ Lower text mismatch!");
            test.pass("✅ Lower text is displayed and correct.");
        } catch (Exception e) {
            test.fail("❌ Lower text verification failed: " + e.getMessage());
            Assert.fail("Lower text issue!", e);
        }
    }
    @Test(priority = 23)
    public void verifyThirdScreenFrameLayoutExists() {
        test = extent.createTest("Verify Frame Layout Exists");
        try {
            Assert.assertTrue(walkthroughPage.isFrameLayoutDisplayed(), "❌ Frame layout is NOT displayed!");
            test.pass("✅ Frame layout is displayed.");
        } catch (Exception e) {
            test.fail("❌ Frame layout verification failed: " + e.getMessage());
            Assert.fail("Frame layout not found!", e);
        }
    }
    @Test(priority = 24)
    public void verifyThirdScreenImageIsSwipeable() {
        test = extent.createTest("Verify Image is Swipeable");
        try {
            Assert.assertTrue(walkthroughPage.isImageSwipeable(), "❌ Image is NOT swipeable!");
            test.pass("✅ Image is swipeable.");
        } catch (Exception e) {
            test.fail("❌ Image swipeability verification failed: " + e.getMessage());
            Assert.fail("Image swipeability check failed!", e);
        }
    }

    @Test(priority = 25, description = "Verify that the walkthrough indicator is displayed")
    public void verifyThirdScreenWalkthroughIndicatorIsDisplayed() {
        test = extent.createTest("Verify Walkthrough Indicator Display");

        try {
            Assert.assertTrue(walkthroughPage.isIndicatorDisplayed(), "❌ Walkthrough indicator is NOT visible.");
            test.pass("✅ Walkthrough indicator is correctly displayed.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify walkthrough indicator: " + e.getMessage());
            Assert.fail("Walkthrough indicator verification failed!", e);
        }
    }
    @Test(priority = 26, description = "Verify that the walkthrough indicator is clickable")
    public void verifyThirdScreenWalkthroughIndicatorIsClickable() {
        test = extent.createTest("Verify Walkthrough Indicator Clickability");

        try {
            Assert.assertTrue(walkthroughPage.isIndicatorClickable(), "❌ Walkthrough indicator is NOT clickable.");
            test.pass("✅ Walkthrough indicator is clickable.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify walkthrough indicator clickability: " + e.getMessage());
            Assert.fail("Walkthrough indicator clickability verification failed!", e);
        }
    }


    @Test(priority = 27, description = "Swipe the first image in the Walkthrough screen")
    public void verifySwipeOnThirdImage() {
        test = extent.createTest("Verify Swipe Action on First Image");

        try {
            test.log(Status.INFO, "Initiating swipe action on the first walkthrough image.");

            // Perform the swipe action
            walkthroughPage.swipeLeft();

            test.pass("✅ Successfully swiped left on the first walkthrough image.");
        } catch (Exception e) {
            test.fail("❌ Swipe action failed due to exception: " + e.getMessage());
            Assert.fail("Swipe action on the first image was unsuccessful!", e);
        }
    }
    @Test(priority = 28)
    public void verify4thScreenDXLogoDisplayed() {
        test = extent.createTest("Verify DX Logo is Displayed");
        try {
            Assert.assertTrue(walkthroughPage.isDXLogoDisplayed(), "❌ DX Logo is NOT displayed!");
            test.pass("✅ DX Logo is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ DX Logo verification failed: " + e.getMessage());
            Assert.fail("DX Logo not found!", e);
        }
    }
    @Test(priority = 29)
    public void verify4thScreenSkipButton() {
        test = extent.createTest("Verify Skip Button");
        try {
            Assert.assertTrue(walkthroughPage.isSkipButtonClickable(), "❌ Skip button is NOT clickable!");
            Assert.assertEquals(walkthroughPage.getSkipButtonText(), "Skip", "❌ Skip button text mismatch!");
            test.pass("✅ Skip button is clickable and has correct text.");
        } catch (Exception e) {
            test.fail("❌ Skip button verification failed: " + e.getMessage());
            Assert.fail("Skip button issue!", e);
        }
    }
    @Test(priority = 30)
    public void verify4thScreenUpperText() {
        test = extent.createTest("Verify Upper Text");
        try {
            Assert.assertTrue(walkthroughPage.isUpperTextDisplayed(), "❌ Upper text is NOT displayed!");
            Assert.assertEquals(walkthroughPage.getUpperText(), "Check-Ins", "❌ Upper text mismatch!");
            test.pass("✅ Upper text is displayed and correct.");
        } catch (Exception e) {
            test.fail("❌ Upper text verification failed: " + e.getMessage());
            Assert.fail("Upper text issue!", e);
        }
    }
    @Test(priority = 31)
    public void verify4thScreenLowerText() {
        test = extent.createTest("Verify Lower Text");
        try {
            Assert.assertTrue(walkthroughPage.isLowerTextDisplayed(), "❌ Lower text is NOT displayed!");
            Assert.assertEquals(walkthroughPage.getLowerText(), 
            		"Leave breadcrumbs for immediate contact from security personnel in case of emergency, ensuring safety.",
            		"❌ Lower text mismatch!");
            test.pass("✅ Lower text is displayed and correct.");
        } catch (Exception e) {
            test.fail("❌ Lower text verification failed: " + e.getMessage());
            Assert.fail("Lower text issue!", e);
        }
    }
    @Test(priority = 32)
    public void verify4thScreenFrameLayoutExists() {
        test = extent.createTest("Verify Frame Layout Exists");
        try {
            Assert.assertTrue(walkthroughPage.isFrameLayoutDisplayed(), "❌ Frame layout is NOT displayed!");
            test.pass("✅ Frame layout is displayed.");
        } catch (Exception e) {
            test.fail("❌ Frame layout verification failed: " + e.getMessage());
            Assert.fail("Frame layout not found!", e);
        }
    }
    @Test(priority = 33)
    public void verify4thScreenImageIsSwipeable() {
        test = extent.createTest("Verify Image is Swipeable");
        try {
            Assert.assertTrue(walkthroughPage.isImageSwipeable(), "❌ Image is NOT swipeable!");
            test.pass("✅ Image is swipeable.");
        } catch (Exception e) {
            test.fail("❌ Image swipeability verification failed: " + e.getMessage());
            Assert.fail("Image swipeability check failed!", e);
        }
    }

    @Test(priority = 34, description = "Verify that the walkthrough indicator is displayed")
    public void verify4thScreenWalkthroughIndicatorIsDisplayed() {
        test = extent.createTest("Verify Walkthrough Indicator Display");

        try {
            Assert.assertTrue(walkthroughPage.isIndicatorDisplayed(), "❌ Walkthrough indicator is NOT visible.");
            test.pass("✅ Walkthrough indicator is correctly displayed.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify walkthrough indicator: " + e.getMessage());
            Assert.fail("Walkthrough indicator verification failed!", e);
        }
    }
    @Test(priority = 35, description = "Verify that the walkthrough indicator is clickable")
    public void verify4thScreenWalkthroughIndicatorIsClickable() {
        test = extent.createTest("Verify Walkthrough Indicator Clickability");

        try {
            Assert.assertTrue(walkthroughPage.isIndicatorClickable(), "❌ Walkthrough indicator is NOT clickable.");
            test.pass("✅ Walkthrough indicator is clickable.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify walkthrough indicator clickability: " + e.getMessage());
            Assert.fail("Walkthrough indicator clickability verification failed!", e);
        }
    }


    @Test(priority = 36, description = "Swipe the first image in the Walkthrough screen")
    public void verifySwipeOnFourthImage() {
        test = extent.createTest("Verify Swipe Action on First Image");

        try {
            test.log(Status.INFO, "Initiating swipe action on the first walkthrough image.");

            // Perform the swipe action
            walkthroughPage.swipeLeft();

            test.pass("✅ Successfully swiped left on the first walkthrough image.");
        } catch (Exception e) {
            test.fail("❌ Swipe action failed due to exception: " + e.getMessage());
            Assert.fail("Swipe action on the first image was unsuccessful!", e);
        }
    }
    @Test(priority = 37)
    public void verify5thScreenDXLogoDisplayed() {
        test = extent.createTest("Verify DX Logo is Displayed");
        try {
            Assert.assertTrue(walkthroughPage.isDXLogoDisplayed(), "❌ DX Logo is NOT displayed!");
            test.pass("✅ DX Logo is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ DX Logo verification failed: " + e.getMessage());
            Assert.fail("DX Logo not found!", e);
        }
    }
    @Test(priority = 38)
    public void verify5thScreenSkipButton() {
        test = extent.createTest("Verify Skip Button");
        try {
            Assert.assertTrue(walkthroughPage.isSkipButtonClickable(), "❌ Skip button is NOT clickable!");
            Assert.assertEquals(walkthroughPage.getSkipButtonText(), "Skip", "❌ Skip button text mismatch!");
            test.pass("✅ Skip button is clickable and has correct text.");
        } catch (Exception e) {
            test.fail("❌ Skip button verification failed: " + e.getMessage());
            Assert.fail("Skip button issue!", e);
        }
    }
    @Test(priority = 39)
    public void verify5thScreenUpperText() {
        test = extent.createTest("Verify Upper Text");
        try {
            Assert.assertTrue(walkthroughPage.isUpperTextDisplayed(), "❌ Upper text is NOT displayed!");
            Assert.assertEquals(walkthroughPage.getUpperText(), "Contact Global Rescue", "❌ Upper text mismatch!");
            test.pass("✅ Upper text is displayed and correct.");
        } catch (Exception e) {
            test.fail("❌ Upper text verification failed: " + e.getMessage());
            Assert.fail("Upper text issue!", e);
        }
    }
    @Test(priority = 40)
    public void verify5thScreenLowerText() {
        test = extent.createTest("Verify Lower Text");
        try {
            Assert.assertTrue(walkthroughPage.isLowerTextDisplayed(), "❌ Lower text is NOT displayed!");
            Assert.assertEquals(walkthroughPage.getLowerText(), 
            		"Maintain open communication with Global Rescue operations center through live chat 24/7/365 for timely updates for emergencies.",
            		"❌ Lower text mismatch!");
            test.pass("✅ Lower text is displayed and correct.");
        } catch (Exception e) {
            test.fail("❌ Lower text verification failed: " + e.getMessage());
            Assert.fail("Lower text issue!", e);
        }
    }
    @Test(priority = 41)
    public void verify5thScreenFrameLayoutExists() {
        test = extent.createTest("Verify Frame Layout Exists");
        try {
            Assert.assertTrue(walkthroughPage.isFrameLayoutDisplayed(), "❌ Frame layout is NOT displayed!");
            test.pass("✅ Frame layout is displayed.");
        } catch (Exception e) {
            test.fail("❌ Frame layout verification failed: " + e.getMessage());
            Assert.fail("Frame layout not found!", e);
        }
    }
    @Test(priority = 42)
    public void verify5thScreenImageIsSwipeable() {
        test = extent.createTest("Verify Image is Swipeable");
        try {
            Assert.assertTrue(walkthroughPage.isImageSwipeable(), "❌ Image is NOT swipeable!");
            test.pass("✅ Image is swipeable.");
        } catch (Exception e) {
            test.fail("❌ Image swipeability verification failed: " + e.getMessage());
            Assert.fail("Image swipeability check failed!", e);
        }
    }

    @Test(priority = 43, description = "Verify that the walkthrough indicator is displayed")
    public void verify5thScreenWalkthroughIndicatorIsDisplayed() {
        test = extent.createTest("Verify Walkthrough Indicator Display");

        try {
            Assert.assertTrue(walkthroughPage.isIndicatorDisplayed(), "❌ Walkthrough indicator is NOT visible.");
            test.pass("✅ Walkthrough indicator is correctly displayed.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify walkthrough indicator: " + e.getMessage());
            Assert.fail("Walkthrough indicator verification failed!", e);
        }
    }
    @Test(priority = 44, description = "Verify that the walkthrough indicator is clickable")
    public void verify5thScreenWalkthroughIndicatorIsClickable() {
        test = extent.createTest("Verify Walkthrough Indicator Clickability");

        try {
            Assert.assertTrue(walkthroughPage.isIndicatorClickable(), "❌ Walkthrough indicator is NOT clickable.");
            test.pass("✅ Walkthrough indicator is clickable.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify walkthrough indicator clickability: " + e.getMessage());
            Assert.fail("Walkthrough indicator clickability verification failed!", e);
        }
    }


    @Test(priority = 45, description = "Swipe the first image in the Walkthrough screen")
    public void verifySwipeOn5thImage() {
        test = extent.createTest("Verify Swipe Action on First Image");

        try {
            test.log(Status.INFO, "Initiating swipe action on the first walkthrough image.");

            // Perform the swipe action
            walkthroughPage.swipeLeft();

            test.pass("✅ Successfully swiped left on the first walkthrough image.");
        } catch (Exception e) {
            test.fail("❌ Swipe action failed due to exception: " + e.getMessage());
            Assert.fail("Swipe action on the first image was unsuccessful!", e);
        }
    }

    // This method will be called after the tests to flush the report
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            test.log(Status.INFO, "Skipping driver quit to preserve session.");
            // Do NOT quit driver here if you have multiple test cases in the same session.
        }
        extent.flush(); // Write the report results
    }

}
