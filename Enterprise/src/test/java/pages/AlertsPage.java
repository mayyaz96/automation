package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AlertsPage {
	private AndroidDriver driver;
    private WebDriverWait wait;
    
    public AlertsPage(AndroidDriver driver, WebDriverWait wait) {
        if (driver == null) {
            throw new IllegalArgumentException("AndroidDriver cannot be null!");
        }
        this.driver = driver;
        this.wait = wait;
    }
    
 // Element Locators
    private String unreadCardId = "com.globalrescue.enterprise:id/event_item_card_unread_view";
    private String alertInfoIconId = "com.globalrescue.enterprise:id/eventAlertControllerInfoIcon";
    private String dialogTitleId = "com.globalrescue.enterprise:id/titleDialog";
    private String dialogMessageId = "com.globalrescue.enterprise:id/messageDialog";
    private String closeButtonId = "com.globalrescue.enterprise:id/closeButton";
    private By questionMark = By.id("com.globalrescue.enterprise:id/containerEventFilterIcons");
    
    
    
    public boolean isQuestionMarkIconDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(questionMark)).isDisplayed();

	}
    public boolean isElementPresent(String elementId) {
        try {
            return driver.findElement(By.id(elementId)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Verify if the unread event card exists
     */
    public boolean isUnreadEventCardPresent() {
        return isElementPresent(unreadCardId);
    }

    /**
     * Verify if the alert info icon exists and click on it
     */
    public void clickAlertInfoIcon() {
        if (isElementPresent(alertInfoIconId)) {
            driver.findElement(By.id(alertInfoIconId)).click();
        } else {
            throw new NoSuchElementException("❌ Alert Info Icon NOT found!");
        }
    }

    /**
     * Verify if the alert title is displayed and return text
     */
    public String getAlertDialogTitle() {
        if (isElementPresent(dialogTitleId)) {
            return driver.findElement(By.id(dialogTitleId)).getText();
        } else {
            throw new NoSuchElementException("❌ Alert Dialog Title NOT found!");
        }
    }

    /**
     * Verify if the alert message is displayed and return text
     */
    public String getAlertDialogMessage() {
        if (isElementPresent(dialogMessageId)) {
            return driver.findElement(By.id(dialogMessageId)).getText();
        } else {
            throw new NoSuchElementException("❌ Alert Dialog Message NOT found!");
        }
    }

    /**
     * Verify if the close button exists and click on it
     */
    public void clickCloseButton() {
        if (isElementPresent(closeButtonId)) {
            driver.findElement(By.id(closeButtonId)).click();
        } else {
            throw new NoSuchElementException("❌ Close Button NOT found or NOT clickable!");
        }
    }

}
