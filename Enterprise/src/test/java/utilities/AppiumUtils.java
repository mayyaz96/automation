package utilities;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils {

    public static void installAndLaunchApp(AndroidDriver driver, String appPath, String packageName) throws Exception {
        try {
            if (!driver.isAppInstalled(packageName)) {
                driver.installApp(appPath);
                System.out.println("App installed successfully.");
            }
            resetApp(driver, packageName);
        } catch (Exception e) {
            System.err.println("Error during app installation or launch: " + e.getMessage());
            throw e;  // Rethrow the exception after logging it.
        }
    }

    private static void resetApp(AndroidDriver driver, String packageName) {
        try {
            if (driver.isAppInstalled(packageName)) {
                driver.terminateApp(packageName);
                driver.executeScript("mobile: shell", Map.of("command", "pm clear " + packageName));
                driver.activateApp(packageName);
                System.out.println("App reset and relaunched successfully.");
            }
        } catch (Exception e) {
            System.err.println("Error during app reset: " + e.getMessage());
        }
    }

    public static boolean isElementVisible(AndroidDriver driver, String elementLocator, String locatorType) {
        try {
            WebElement element = null;

            // Select locator type
            switch (locatorType.toLowerCase()) {
                case "xpath":
                    element = driver.findElement(By.xpath(elementLocator));
                    break;
                case "id":
                    element = driver.findElement(By.id(elementLocator));
                    break;
                case "css":
                    element = driver.findElement(By.cssSelector(elementLocator));
                    break;
                case "classname":
                    element = driver.findElement(By.className(elementLocator));
                    break;
                default:
                    System.out.println("Unsupported locator type: " + locatorType);
            }

            return element != null && element.isDisplayed();  // Check visibility
        } catch (Exception e) {
            System.err.println("Error while checking element visibility: " + e.getMessage());
            return false;  // Return false if any error occurs
        }
    }
    
}
