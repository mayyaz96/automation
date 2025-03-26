package TestCases;

import base.BaseSetup;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import pages.ConfigurationPage;
import pages.LoginPage;
import pages.WalkthroughPage;
import utilities.ExtentReportsManager;

import java.awt.Point;
import java.time.Duration;

import javax.sound.midi.Sequence;

public class Configuration extends BaseSetup {
	
    private WebDriverWait wait;
    private LoginPage loginPage;
    private ConfigurationPage configuration;
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
        configuration = new ConfigurationPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        walkthroughPage = new WalkthroughPage(driver, wait);
    }

    @Test(priority = 2)
    public void GotoSettings() {
        test = extent.createTest("Go to Settings");
        try {
        	  configuration.clickSettings();
              
        } catch (AssertionError e) {
            test.fail("Settings is not clicked. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3)
    public void verifyalltitletext() {
        test = extent.createTest("Verify Title Texts");
        try {
        	Assert.assertEquals(configuration.getTitleText(), "Configurations", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
        try {
        	Assert.assertEquals(configuration.getGpsFetchText(), "GPS Fetch Timeout", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
        try {
        	Assert.assertEquals(configuration.getMutetravelText(), "Mute Travel City Stay", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
        try {
        	Assert.assertEquals(configuration.getChangepassText(), "Change Password", "Title text is incorrect");
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
            test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
      
    }

    @Test(priority = 4)
    public void verifyMuteTravelCity() throws InterruptedException {
        test = extent.createTest("Verify Mute Travel City Stay");
        try {
            configuration.clickMuteTravel();
            test.pass("Mute Travel City is clicked.");
        } catch (AssertionError e) {
            test.fail("mute Travel City is not clicked.. Error: " + e.getMessage());
            throw e;
        }
        try {
        	
        	Thread.sleep(3000);
        	System.out.print("The status is: "+ configuration.getCheckedStatus());
        	
       
        	configuration.clickmutetoggle();
        	
        	configuration.selectnumber();
        	
        	
            test.pass("Title Text is displayed correctly.");
        } catch (AssertionError e) {
        	 test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }

        
    }

    @Test(priority = 5)
    public void VerifyChangePasswordText() throws InterruptedException {
        test = extent.createTest("Verify Change Password Texts");
        try {
        	configuration.clickCpass();
        	
        	Thread.sleep(3000);
        	
        	Assert.assertEquals(configuration.getChangePasspopText(), "Change Password", "Title text is incorrect");
        	Assert.assertEquals(configuration.getoldpassText(), "Old Password", "Title text is incorrect");
        	Assert.assertEquals(configuration.getNewPassText(), "New Password", "Title text is incorrect");
        	Assert.assertEquals(configuration.getConfirmpasstext(), "Confirm Password", "Title text is incorrect");
        	
        	
        } catch (AssertionError e) {
        	test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
        
        try {
        	configuration.clickUpdate();
        	Thread.sleep(3000);
        	Assert.assertEquals(configuration.getCompleteformText(), "Please complete the form by filling the highlighted fields.", "Title text is incorrect");
        
        	
        	
        } catch (AssertionError e) {
        	test.fail("Title text is not displayed. Error: " + e.getMessage());
            throw e;
        }
        
        
        
    }

    @Test(priority = 6)
    public void verifyChangePassword() throws InterruptedException {
        test = extent.createTest("Verify Change Password");
        try {
        	configuration.enterOldPass("Gridtest2");
        	configuration.enterNewPass("Gridtest2");
        	configuration.enterConfirmPass("Gridtest2");
        	configuration.clickUpdate();
        	Thread.sleep(3000);
        	Assert.assertEquals(configuration.getCompleteformText(), "Old Password is not correct.", "Title text is incorrect");
        	test.pass("Change Password working correctly.");
        } catch (AssertionError e) {
            test.fail("Change Password. Error: " + e.getMessage());
            throw e;
        }
        
        
        try {
        	configuration.enterOldPass("Gridtest1");
        	configuration.enterNewPass("Gridtest2");
        	configuration.enterConfirmPass("Gridtest3");
        	configuration.clickUpdate();
        	Thread.sleep(3000);
        	Assert.assertEquals(configuration.getCompleteformText(), "Password fields must match. Please try again.", "Title text is incorrect");
        	test.pass("Change Password working correctly.");
        } catch (AssertionError e) {
            test.fail("Change Password. Error: " + e.getMessage());
            throw e;
        }
        
        
        try {
        	configuration.enterOldPass("Gridtest1");
        	configuration.enterNewPass("Gridtest2");
        	configuration.enterConfirmPass("Gridtest2");
        	configuration.clickUpdate();
        	Thread.sleep(3000);
        	Assert.assertEquals(configuration.getSuccesstopText(), "Your password has been updated successfully.", "Title text is incorrect");
        	
  	
        	test.pass("Change Password working correctly.");
        } catch (AssertionError e) {
            test.fail("Change Password. Error: " + e.getMessage());
            throw e;
        }
        
        
    }

    @Test(priority = 7)
    public void verifyCorrectpasswordSuccess() throws InterruptedException {
        test = extent.createTest("Verify Help Page");
        try {
        	configuration.clickCpass();
        	Thread.sleep(3000);
        	configuration.enterOldPass("Gridtest2");
        	configuration.enterNewPass("Gridtest1");
        	configuration.enterConfirmPass("Gridtest1");
        	configuration.clickUpdate();
        	Thread.sleep(3000);
        	Assert.assertEquals(configuration.getSuccesstopText(), "Your password has been updated successfully.", "Title text is incorrect");

        	configuration.clickBack();

            test.pass("Password Changed correctly");
        } catch (AssertionError e) {
            test.fail("Password Change is not correctly, Error: " + e.getMessage());
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
