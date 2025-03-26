package TestCases;

import base.BaseSetup;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import pages.HelpPage;
import pages.LoginPage;
import pages.WalkthroughPage;
import utilities.ExtentReportsManager;

import java.time.Duration;

public class Help extends BaseSetup {
	
    private WebDriverWait wait;
    private LoginPage loginPage;
    private HelpPage help;
    private WalkthroughPage walkthroughPage;
    // ExtentReports objects
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setupExtentReports() {
        extent = ExtentReportsManager.getExtentReports();
    }

    @BeforeMethod
    public void setUpTest() {
        extent = ExtentReportsManager.getExtentReports();  
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        help = new HelpPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        walkthroughPage = new WalkthroughPage(driver, wait);
    }


    @Test(priority = 2)
    public void GotoSettings() {
        test = extent.createTest("Go to Settings");
        try {
        	  help.clickSettings();
              
        } catch (AssertionError e) {
            test.fail("Settings is not clicked. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3)
    public void verifyalltitletext() {
        test = extent.createTest("Verify Title Texts");
        try {
        	Assert.assertEquals(help.getTitleText(), "Help", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
        try {
        	Assert.assertEquals(help.getPoliciesText(), "Policies and Agreements", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
        try {
        	Assert.assertEquals(help.getEmergencyRecipientsText(), "Emergency Recipients", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
        try {
        	Assert.assertEquals(help.getWalkthroughText(), "App Feature Walkthrough", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
        try {
        	Assert.assertEquals(help.getHelpText(), "Help", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
        try {
        	Assert.assertEquals(help.getVersionText(), "Version", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 4)
    public void verifyPolicies() throws InterruptedException {
        test = extent.createTest("Verify Policies and Agreements");
        try {
            help.clickPolicies();
            test.pass("Policies and Agreements is clicked.");
        } catch (AssertionError e) {
            test.fail("Policies and Agreements is not clicked.. Error: " + e.getMessage());
            throw e;
        }
        try {
        	Assert.assertEquals(help.getEulaText(), "End User License Agreement", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
        	 test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
       
        try {
        	Assert.assertEquals(help.getPrivacyText(), "Privacy Policy", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
        	 test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
    
        try {
        	help.clickEula();
        	Thread.sleep(15000);
        	Assert.assertEquals(help.getEnduserpageText(), "Mobile Application End User License Agreement", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
        	 test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
    
        try {
        	help.clickBack();
        	Thread.sleep(3000);
        	help.clickPrivacy();
        	Thread.sleep(15000);
        	Assert.assertEquals(help.getPrivacypolicyText(), "Privacy Policy", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
        	 test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
    
 
        
    }

    @Test(priority = 5)
    public void verifyEmergencyRecipients() throws InterruptedException {
        test = extent.createTest("Verify Emergency Recipients");
        try {
        	help.clickBack();
        	help.clickBack();
        	help.clickEmergencyRecipients();
        	Thread.sleep(3000);
        	Assert.assertEquals(help.getEmergencynoteText(), "List of people who will be notified when you press the emergency button.", "Title text is incorrect");
        	Assert.assertEquals(help.getopsText(), "Global Rescue Operations", "Title text is incorrect");
        } catch (AssertionError e) {
        	test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 6)
    public void verifyApWalkthrough() throws InterruptedException {
        test = extent.createTest("Verify App WalkhThrough");
        try {
        	help.clickBack();
            help.clickWalkthrough();
        	Thread.sleep(3000);
        	Assert.assertEquals(help.getWalktitle(), "Emergency", "Title text is incorrect");
        	Assert.assertEquals(help.getWalkText(), "Instantly connect with Global Rescue's operations team with the tap of a button for rapid assistance, ensuring immediate help when you need it most.", "Title text is incorrect");
        	walkthroughPage.swipeLeft();
        	Assert.assertEquals(help.getWalktitle(), "Events & Alerts", "Title text is incorrect");
        	Assert.assertEquals(help.getWalkText(), "Stay informed of unfolding global events, ensuring you are well-versed in current happenings around the world.", "Title text is incorrect");
        	walkthroughPage.swipeLeft();
        	Assert.assertEquals(help.getWalktitle(), "Destination Reports", "Title text is incorrect");
        	Assert.assertEquals(help.getWalkText(), "Download comprehensive intelligence reports for up to 215 countries and territories on your device, even while on the go.", "Title text is incorrect");
        	walkthroughPage.swipeLeft();
        	Assert.assertEquals(help.getWalktitle(), "Check-Ins", "Title text is incorrect");
        	Assert.assertEquals(help.getWalkText(), "Leave breadcrumbs for immediate contact from security personnel in case of emergency, ensuring safety.", "Title text is incorrect");
        	walkthroughPage.swipeLeft();
        	Assert.assertEquals(help.getWalktitle(), "Contact Global Rescue", "Title text is incorrect");
        	Assert.assertEquals(help.getWalkText(), "Maintain open communication with Global Rescue operations center through live chat 24/7/365 for timely updates for emergencies.", "Title text is incorrect");
        	walkthroughPage.swipeLeft();
        	test.pass("Walkthrough screen working correctly.");
        } catch (AssertionError e) {
            test.fail("Walkthrough screen. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 7)
    public void verifyHelpPage() throws InterruptedException {
        test = extent.createTest("Verify Help Page");
        try {
            help.clickhelp();
            Thread.sleep(5000);
            Assert.assertEquals(help.getHelpPagetext(), "Global Rescue GRID App Help", "Title text is incorrect");
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.context("NATIVE_APP");
            help.clickBack();

            test.pass("Help page is displayed correctly");
        } catch (AssertionError e) {
            test.fail("Help page is not displayed correctly, Error: " + e.getMessage());
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
