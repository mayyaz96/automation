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
import pages.ContactYourOrganizationPage;
import pages.DestinationReportPage;
import pages.HelpPage;
import utilities.ExtentReportsManager;
import java.time.Duration;


import java.net.MalformedURLException;
import java.net.URL;



public class ContactYourOrganization extends BaseSetup {
	
    private WebDriverWait wait;
    private LoginPage loginPage;
    private ContactYourOrganizationPage CYO;
  
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
        CYO = new ContactYourOrganizationPage(driver, wait);
        
       
    }
       

    @Test(priority = 2)
    public void verifyContactYourOrganization() throws InterruptedException {
        test = extent.createTest("Contact Your Organization");
        try {

        	
       	Assert.assertEquals(CYO.getTitleText(), "Contact Your Organization", "Title text is incorrect");
        	Assert.assertEquals(CYO.getSubText(), "Message with your organization's internal point of contact", "Title text is incorrect");
       	
        	CYO.clickContactyourorganization();
       	Assert.assertEquals(CYO.getEnterMessageText(), "Enter your message here…", "Title text is incorrect");
        	CYO.clickBack();
        
        	
        	webPortal.MessageTraveler();
			Thread.sleep(4000);
			
        	CYO.Checknotificationtext();
        	Thread.sleep(4000);
        	Assert.assertEquals(CYO.getMessageText(), "Hello! How are you.", "Title text is incorrect");
        	
        	CYO.clickBack();
        	
//        	CYO.SendMessage();
//        	CYO.clickSendButton();
        	//System.out.println("Texts all:  " + CYO.getMessageText());

        } catch (AssertionError e) {
            test.fail("Text is incorrect. Error: " + e.getMessage());
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
