package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;

public class PermissionsPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public PermissionsPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By continueButton = By.id("com.globalrescue.enterprise:id/continue_btn");
    private By callPermissionButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
    private By locationPermissionButton = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private By cameraPermissionButton = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private By notificationsPermissionButton = By.id("com.android.permissioncontroller:id/permission_allow_button");

    public void allowAllPermissions() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(callPermissionButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(locationPermissionButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cameraPermissionButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(notificationsPermissionButton)).click();
    }
}
