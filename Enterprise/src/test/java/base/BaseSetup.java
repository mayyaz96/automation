package base;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;

public class BaseSetup {
    protected static AndroidDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("appium:deviceName", "FA7CG1A00416"); // Pixel 2
        // capabilities.setCapability("appium:deviceName", "1C241FDF6004JP");
         capabilities.setCapability("appium:deviceName", "1b82d904"); // Ali Device
        //capabilities.setCapability("appium:deviceName", "emulator-5554"); // Emulator
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:noReset", true);
        capabilities.setCapability("appium:newCommandTimeout", 400);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        System.out.println("Driver initialized.");

        // Initialize WebDriverWait after driver is set
       // wait = new WebDriverWait(driver, Duration.ofSeconds(500));
    }

    // ✅ Add this method to provide driver access in test classes
    public AndroidDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver session ended.");
        }
    }
}
