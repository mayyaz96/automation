package TestCases;

import base.BaseSetup;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.github.cdimascio.dotenv.Dotenv;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import pages.LoginPage;
import pages.ProfilePage;
import pages.SignUpPage;
import utilities.ExtentReportsManager;
import java.time.Duration;


import java.net.MalformedURLException;
import java.net.URL;



public class Profile extends BaseSetup {
	
    private WebDriverWait wait;
    private LoginPage loginPage;
    private ProfilePage profile;
    Dotenv dotenv = Dotenv.load();
    // ExtentReports objects
    private static ExtentReports extent;
    private static ExtentTest test;
    public SignUpPage signUpPage;
    

    
    
   
    
    @BeforeSuite
    public void setupExtentReports() {
        extent = ExtentReportsManager.getExtentReports();
    }

    @BeforeMethod
    public void setUpTest() {
        extent = ExtentReportsManager.getExtentReports();  
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        loginPage = new LoginPage(driver, wait);
        profile = new ProfilePage(driver, wait);
        signUpPage = new SignUpPage(driver, wait);
       
    }
        

    @Test(priority = 2)
    public void verifyProfilePageText() throws InterruptedException {
        test = extent.createTest("Profile View page data verification");
        try {

        	profile.clickSetings();
        	Thread.sleep(3000);
        	profile.clickIntroname();
        	Thread.sleep(3000);
        	
        	Assert.assertEquals(profile.getUsernameText(), "Automation User", "Title text is incorrect");
        	Assert.assertEquals(profile.getEmailText(), dotenv.get("EMAIL"), "Title text is incorrect");
        	Assert.assertEquals(profile.getPhoneText(), "92 3136129277", "Title text is incorrect");
        	Assert.assertEquals(profile.getGenderText(), "Male", "Title text is incorrect");
        	Assert.assertEquals(profile.getDOBText(), "April 23, 1993", "Title text is incorrect");
        	Assert.assertEquals(profile.getHomeText(), "Ban Chang, Rayong, Thailand", "Title text is incorrect");
	
      
        } catch (AssertionError e) {
            test.fail("Issue occured. Error: " + e.getMessage());
            throw e;
        }
    }


    @Test(priority = 3)
    public void verifyEditProfileLabels() throws InterruptedException {
        test = extent.createTest("Edit Profile lables Verification");
        try {

        	profile.clickEditprofile();
        	Assert.assertTrue(signUpPage.isFirstNameFieldVisible(), "First Name field is not displayed.");
        	 Assert.assertTrue(signUpPage.isLastNameLabelVisible(), "Last Name label is not displayed.");
        	 Assert.assertTrue(signUpPage.isGenderLabelVisible(), "Gender label is not displayed.");
        	 Assert.assertTrue(signUpPage.isMaleRadioButtonVisible(), "Male radio button is not displayed.");
        	 Assert.assertTrue(signUpPage.isFemaleRadioButtonVisible(), "Female radio button is not displayed.");
        	 Assert.assertTrue(signUpPage.isDateOfBirthLabelVisible(), "Date of Birth label is not displayed.");
        	 Assert.assertTrue(signUpPage.isAddressLabelVisible(), "Address label is not displayed.");
        	 Assert.assertTrue(signUpPage.isHomeCityLabelVisible(), "❌ Home City label is NOT displayed.");
        	 Assert.assertTrue(signUpPage.isPhoneNumberLabelVisible(), "❌ Phone Number label is NOT displayed.");
      
        } catch (AssertionError e) {
            test.fail("Issue occured. Error: " + e.getMessage());
            throw e;
        }
    }
    @Test(priority = 4)
    public void verifyEditProfileValidations() throws InterruptedException {
        test = extent.createTest("Edit Profile Validations");
        try {
        	
        	signUpPage.enterFirstName("");
        	 signUpPage.enterLastName("");
        
        	 
        	 profile.clickSaveprofile();
        	 Thread.sleep(3000);
        	 Assert.assertEquals(profile.getNotificationtext(), "Please complete the form by filling the highlighted fields.", "Validation text is incorrect");
        	 
        	 signUpPage.enterFirstName("1");
        	 signUpPage.enterLastName("2");
        	 profile.clickSaveprofile();
        	 Thread.sleep(3000);
        	 
        	 Assert.assertEquals(profile.getNotificationtext(), "Length must not be less than 2 characters", "Validation text is incorrect");
        	 signUpPage.enterFirstName("@#$%*");// its saving it but it should not
        	 signUpPage.enterLastName("@#$%*");
        	 profile.clickSaveprofile();
        	 Thread.sleep(3000);
        	 
        	 profile.clickEditprofile();
        	 Thread.sleep(3000);
        	 signUpPage.enterFirstName("Length must not be less than 2 characters Length must not be less than 2 characters Length must not be less than 2 characters Length must not be less than 2 characters");
        	 profile.clickSaveprofile();
        	 Thread.sleep(3000);
        	 
        	 Assert.assertEquals(profile.getUsernameText(), "Length must not be less than 2 characters Len @#$%*", "Title text is incorrect");
        	 
        	 profile.clickEditprofile();
        	 Thread.sleep(3000);
        	 profile.clickFemale();
        	
        	//profile.clickHomecity();
        	//Thread.sleep(2000);
        	//signUpPage.enterHomeCity("Karachi, Sindh, Pakistan");
        	// profile.clickSaveprofile();
        	 
        	 signUpPage.enterPhoneNumber("12345");
        	 profile.clickSaveprofile();
        	 Thread.sleep(3000);
        	 Assert.assertEquals(profile.getNotificationtext(), "Phone Number is invalid", "Title text is incorrect");
        	 
        	
        	 profile.clickClosenotification();
        	 signUpPage.enterPhoneNumber("3136123456");
        	 profile.clickSaveprofile();
        	 Thread.sleep(3000);
        	 
        	 Assert.assertEquals(profile.getUsernameText(), "Length must not be less than 2 characters Len @#$%*", "Title text is incorrect");
         	Assert.assertEquals(profile.getEmailText(), dotenv.get("EMAIL"), "Title text is incorrect");
         	Assert.assertEquals(profile.getPhoneText(), "92 3136123456", "Title text is incorrect");
         	Assert.assertEquals(profile.getGenderText(), "Female", "Title text is incorrect");
         	Assert.assertEquals(profile.getDOBText(), "April 23, 1993", "Title text is incorrect");
         	Assert.assertEquals(profile.getHomeText(), "Ban Chang, Rayong, Thailand", "Title text is incorrect");
        	 
        	 
        	 
        } catch (AssertionError e) {
            test.fail("Issue occured. Error: " + e.getMessage());
            throw e;
        }
    }

    @Test(priority = 5)
    public void updateProfileSuccess() throws InterruptedException {
        test = extent.createTest("Update Profile Success Case");
        try {
        	
        	
        	 profile.clickEditprofile();
        	signUpPage.enterFirstName("Automation");
        	 signUpPage.enterLastName("User");
        
        	 profile.clickMale();
        	
        	 signUpPage.enterPhoneNumber("3136129277");
        	 profile.clickSaveprofile();
        	 Thread.sleep(3000);
        	 
        	 Assert.assertEquals(profile.getUsernameText(), "Automation User", "Title text is incorrect");
         	Assert.assertEquals(profile.getEmailText(), dotenv.get("EMAIL"), "Title text is incorrect");
         	Assert.assertEquals(profile.getPhoneText(), "92 3136129277", "Title text is incorrect");
         	Assert.assertEquals(profile.getGenderText(), "Male", "Title text is incorrect");
         	Assert.assertEquals(profile.getDOBText(), "April 23, 1993", "Title text is incorrect");
         	Assert.assertEquals(profile.getHomeText(), "Ban Chang, Rayong, Thailand", "Title text is incorrect");
        	 
         	profile.clickBack();
         	Thread.sleep(2000);
         	profile.clickBack();

        	 
        } catch (AssertionError e) {
            test.fail("Issue occured. Error: " + e.getMessage());
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
