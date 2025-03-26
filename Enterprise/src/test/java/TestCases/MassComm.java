package TestCases;

import base.BaseSetup;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import pages.LoginPage;
import pages.MassCommPage;
import utilities.ExtentReportsManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;



public class MassComm extends BaseSetup {
	
    private WebDriverWait wait;
    private LoginPage loginPage;
    private MassCommPage masscomm;
  
    // ExtentReports objects
    private static ExtentReports extent;
    private static ExtentTest test;
    WebPortal webPortal = new WebPortal();

    
    
   
    
    @BeforeSuite
    public void setupExtentReports() {
        extent = ExtentReportsManager.getExtentReports();
    }

    @BeforeMethod
    public void setUpTest() {
        extent = ExtentReportsManager.getExtentReports();  
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        loginPage = new LoginPage(driver, wait);
        masscomm = new MassCommPage(driver, wait);
        
       
    }
        
//    @Test(priority = 1)
//    public void SignIntoApp() {
//        test = extent.createTest("Sign In to the app");
//        try {
//            loginPage.enterEmail("amehdi@globalrescue.com");
//            loginPage.clickNext();
//            boolean isPasswordFieldVisible = loginPage.isPasswordFieldVisible();
//            Assert.assertTrue(isPasswordFieldVisible, "Password field is not visible for valid email!");
//            test.pass("Password field is displayed correctly for valid email.");
//        } catch (AssertionError e) {
//            test.fail("Password field is not displayed for valid email. Error: " + e.getMessage());
//            throw e;
//        }
//        try {
//            loginPage.enterPassword("Gridtest1");
//            loginPage.clickLogin();
//            boolean isLoginSuccessful = loginPage.isLoginSuccessful();
//            Assert.assertTrue(isLoginSuccessful, "Login failed with valid credentials!");
//            test.pass("Login is successful with valid credentials.");
//        } catch (AssertionError e) {
//            test.fail("Login failed  with valid credentials. Error: " + e.getMessage());
//            throw e;
//        }
//    }

    @Test(priority = 2)
    public void PublishMasscomm() throws InterruptedException {
        test = extent.createTest("Publish a new MassComm");
        try {
   	
        	webPortal.MasscommPublish();
		

        } catch (AssertionError e) {
            test.fail("Failed: Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 3)
    public void VerifyMassComm() throws InterruptedException {
        test = extent.createTest("Verify Masscomm");
        try {
        	
        	
        	Thread.sleep(5000);
        	Assert.assertEquals(masscomm.gePopuptitleText(), "Automation Mobile Event - Beyond Limits: A Journey to Success", "Title text is incorrect");
        	
        	masscomm.clickViewButton();
        	Thread.sleep(4000);
        	
        	Assert.assertEquals(masscomm.getPagetitleText(), "Mass Communication", "Title text is incorrect");
        	
        	masscomm.clickAnswer();
        	Thread.sleep(2000);
        	
        	masscomm.clickSubmitAnswer();
        	Thread.sleep(2000);
        	Assert.assertEquals(masscomm.geAnswersuccessText(), "Your response has been submitted.", "Text is incorrect");
        	
        	masscomm.clickAnswerOk();
        	Thread.sleep(2000);
        	
        	masscomm.clickBack();
        	Thread.sleep(3000);
          	Assert.assertEquals(masscomm.getTitleText(), "Mass Communication", "Title text is incorrect");
        	Assert.assertEquals(masscomm.getSubText(), "View and respond to Mass Comm", "Sub Title text is incorrect");
       	
        	//masscomm.clickMassComm();
		

        } catch (AssertionError e) {
            test.fail("Failed: Error: " + e.getMessage());
            throw e;
        }
    }
    @Test(priority = 4)
    public void UnPublishMasscomm() throws InterruptedException {
        test = extent.createTest("UnPublish the created Masscomm");
        try {
   	
        	webPortal.MasscommUnPublish();
		

        } catch (AssertionError e) {
            test.fail("Failed: Error: " + e.getMessage());
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
