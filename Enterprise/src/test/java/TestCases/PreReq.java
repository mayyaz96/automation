package TestCases;
//import commonPages.CommonFunctions; 

import io.appium.java_client.android.AndroidDriver;
// For TestNG assertions
import io.github.cdimascio.dotenv.Dotenv;
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

public class PreReq extends BaseSetup {
	public LoginPage loginPage;
	public SignUpPage signUpPage;
	private WebDriverWait wait;
	private ExtentReports extent;
	private ExtentTest test;
	private PermissionsPage permissionsPage;
	private String randomEamil;
	Dotenv dotenv = Dotenv.load();

	@BeforeSuite
	public void setupExtentReports() {
		extent = ExtentReportsManager.getExtentReports();
	}
	
	public PreReq(ExtentReports extent, WebDriverWait wait, AndroidDriver driver) {
		this.extent = extent;
		this.wait = wait;
		this.driver = driver;
		this.loginPage = new LoginPage(driver, wait);
	}
	
	@BeforeClass
	public void setup() {

		// Initialize wait and SignUpPage
		loginPage = new LoginPage(null, wait);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		loginPage = new LoginPage(driver, wait);
		signUpPage = new SignUpPage(driver, wait);
		permissionsPage = new PermissionsPage(driver, wait); // Initialize permissionsPage
	}

	@Test(priority = 1)
	public void installAndLaunchApp() {
	    test = extent.createTest("Install and Launch App");
	    try {
	    	
	    	
	        if (driver.isAppInstalled("com.globalrescue.enterprise")) {
	            System.out.println("App is already installed!");
	            
	            driver.removeApp("com.globalrescue.enterprise");
	            System.out.println("App Removed!");
	        } 
	    
		//driver.close();
	    	
	    	
	        AppiumUtils.installAndLaunchApp(driver, "F:\\apk file\\grid-enterprise-app-without-Chucker.apk", "com.globalrescue.enterprise");
	        test.pass("✅ App installed and launched successfully.");
	        System.out.println("[INFO] App installed and launched successfully.");
	    } catch (Exception e) {
	        test.fail("❌ Failed to install and launch app. Error: " + e.getMessage());
	        System.err.println("[ERROR] Failed to install and launch app: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("App installation and launch failed.", e);
	    }
	}
	
	@Test(priority = 2)
	public void AcceptPermissions() {
	    test = extent.createTest("Accept Permissions in App");
	    try {
	        permissionsPage.allowAllPermissions();
	        test.pass("✅ Permissions granted successfully.");
	        System.out.println("[INFO] Permissions granted successfully.");
	    } catch (Exception e) {
	        test.fail("❌ Failed to grant permissions. Error: " + e.getMessage());
	        System.err.println("[ERROR] Failed to grant permissions: " + e.getMessage());
	        e.printStackTrace();
	        Assert.fail("Permission handling failed.", e);
	    }
	}

	@Test(priority = 3)
	public void SignIn() {
	    test = extent.createTest("Sign in to the App");
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
	    password();
        
	}
	
	public void password() {
		 try {
	            loginPage.enterPassword(dotenv.get("PASSWORD"));
	            loginPage.clickLogin();
	            boolean isLoginSuccessful = loginPage.isLoginSuccessful();
	            Assert.assertTrue(isLoginSuccessful, "Login failed with valid credentials!");
	            test.pass("Login is successful with valid credentials.");
	        } catch (AssertionError e) {
	            test.fail("Login failed  with valid credentials. Error: " + e.getMessage());
	            throw e;
	        }
	}
	@Test(priority = 4)
	public void CityStayUserSignIn() {
	    test = extent.createTest("Sign in to the App");
	    try {
            loginPage.enterEmail(dotenv.get("CityStayEMAIL"));
            loginPage.clickNext();
            boolean isPasswordFieldVisible = loginPage.isPasswordFieldVisible();
            Assert.assertTrue(isPasswordFieldVisible, "Password field is not visible for valid email!");
            test.pass("Password field is displayed correctly for valid email.");
        } catch (AssertionError e) {
            test.fail("Password field is not displayed for valid email. Error: " + e.getMessage());
            throw e;
        }
	    password();
        
	}
	
//	@Test(priority = 4)
//	public void test() {
//	    test = extent.createTest("Env Test");
//	    try {
//	    	
//	    	
//	    	 
////	         
////	         String deviceName = dotenv.get("DEVICE_NAME");
////	         
////	         System.out.println(deviceName);
//          
//        } catch (AssertionError e) {
//            test.fail("Password field is not displayed for valid email. Error: " + e.getMessage());
//            throw e;
//        }
//        
//        
//	}
//   

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
