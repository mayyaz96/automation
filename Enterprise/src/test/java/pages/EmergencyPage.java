package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.NoSuchElementException;

public class EmergencyPage {
    private AndroidDriver driver;
    private WebDriverWait wait;
    
    public EmergencyPage(AndroidDriver driver, WebDriverWait wait ) {
        this.driver = driver;
        this.wait = wait;
    }
    private By emergencyRecipientsTitle = By.id("com.globalrescue.enterprise:id/titleEmergencyNotifcation");
    // **Locators**

    private By notificationMessage = By.id("com.globalrescue.enterprise:id/notificationText");
    private By cancelNotificationButton = By.id("com.globalrescue.enterprise:id/errorCancelNotification");
    private By natureOfEmergencyLabel = By.id("com.globalrescue.enterprise:id/textView1");
    private By emergencyInputField = By.id("com.globalrescue.enterprise:id/gridComments");
    private By textCountLabel = By.id("com.globalrescue.enterprise:id/tvTextCount");
    private By emergencyButton = By.id("com.globalrescue.enterprise:id/bNewEmergency");
    private By cancelEmergencyButton = By.id("com.globalrescue.enterprise:id/btnCancelEmergency");
    private By sendNotificationButton = By.id("com.globalrescue.enterprise:id/sendNotificationOptional");
    private By autoLocationShareText = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/tvOptionalMessageFreqDuration']");
    private By emergencyRecipientsMessage = By.xpath("//android.widget.TextView[@text='This emergency notification was also sent to your organization emergency recipients.']");
    private By seeListOfRecipientsButton = By.xpath("//android.widget.TextView[@text='See list of emergency recipients']");
    private By emergencyNotificationText = By.id("com.globalrescue.enterprise:id/notificationText");
    private By emergencyListView = By.id("com.globalrescue.enterprise:id/emergencyListViewId");
    private By contactProfileImage = By.xpath("(//android.widget.ImageView[@resource-id='com.globalrescue.enterprise:id/shapeableImageView'])[1]");
    private By contactNameInitials = By.id("com.globalrescue.enterprise:id/name_initials_views");
    private By contactName = By.id("com.globalrescue.enterprise:id/tv_contact_name");
    private By contactEmail = By.id("com.globalrescue.enterprise:id/tv_contact_email");
    private By contactPhoneNumber = By.id("com.globalrescue.enterprise:id/tv_contact_phone");
    // **🔹 Locators (Encapsulated)**
    private By title = By.id("com.globalrescue.enterprise:id/title");
    private By syncChatButton = By.id("com.globalrescue.enterprise:id/btnSyncChat");
    private By stopLocationSharingButton = By.id("com.globalrescue.enterprise:id/btnStopLocationSharing");
 // **Popup Header - Stop Location Sharing**
    private By stopLocationSharingPopup = By.className("android.view.ViewGroup");
    private By stopLocationSharingHeader = By.id("com.globalrescue.enterprise:id/tv_header");
    private By stopLocationSharingInstructions = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/tvInstructions']");
    private By stopLocationSharingReasonHeader = By.id("com.globalrescue.enterprise:id/tv_header");
    private By cancelStopSharingButton = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/tv_btnCancel']");
    private By confirmStopSharingButton = By.id("com.globalrescue.enterprise:id/btnStop");
    // **Locators for Stop Location Sharing Notification**
    private By stopLocationSharingNotificationText = By.id("com.globalrescue.enterprise:id/notificationText");
    private By stopLocationSharingCancelNotification = By.id("com.globalrescue.enterprise:id/errorCancelNotification");
    private By customNotificationLayout = By.xpath("//android.widget.LinearLayout[@resource-id='com.globalrescue.enterprise:id/customNotificationLayout']/android.view.ViewGroup");
 // Locators
 // Locator for Emergency Title
    private By emergencyTitle = By.id("com.globalrescue.enterprise:id/tvEmergencyTitle");

    // Method to check if Emergency Title is displayed
    public boolean isEmergencyTitleDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emergencyTitle)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    private By cancellationReasonDropdown = By.id("com.globalrescue.enterprise:id/spQuantityRange");
    private By testingEmergencyOption = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/tv_tinted_spinner' and @text='Was testing the emergency feature']");
    private By yesButton = By.id("com.globalrescue.enterprise:id/btnYes");

    // Click on Cancel Emergency Button
    public void clickCancelEmergencyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelEmergencyButton)).click();
    }

    // Click on Cancellation Reason Dropdown
    public void clickCancellationReasonDropdown() {
        wait.until(ExpectedConditions.elementToBeClickable(cancellationReasonDropdown)).click();
    }

    // Select "Was testing the emergency feature" option
    public void selectCancellationReason(String reason) {
        wait.until(ExpectedConditions.elementToBeClickable(testingEmergencyOption)).click();
    }

    // Click on Yes button to confirm cancellation
    public void clickYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
    }
    // **🔹 Methods to Interact with Elements**
    // **Methods to Verify Buttons**
    public boolean isCancelEmergencyDisplayed() {
        return driver.findElement(cancelEmergencyButton).isDisplayed();
    }
    // **Check if 'Your location sharing has been stopped' Notification is Displayed**
    public boolean isStopLocationSharingNotificationDisplayed() throws InterruptedException {
    	Thread.sleep(2000);
        return driver.findElement(By.id("com.globalrescue.enterprise:id/notificationText")).isDisplayed();
    }
    public boolean isCustomNotificationLayoutDisplayed() {
        try {
            return driver.findElement(customNotificationLayout).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    // **Get Notification Text**
    public String getStopLocationSharingNotificationText() throws InterruptedException {
    	Thread.sleep(2000);
        return driver.findElement(stopLocationSharingNotificationText).getText();
    }

    // **Check if 'Cancel' Button on Notification is Clickable**
    public boolean isStopLocationSharingCancelNotificationClickable() throws InterruptedException {
    	Thread.sleep(2000);
        return driver.findElement(stopLocationSharingCancelNotification).isEnabled();
    }

    // **Click on 'Cancel' Button to Dismiss Notification**
    public void clickStopLocationSharingCancelNotification() {
        driver.findElement(stopLocationSharingCancelNotification).click();
    }

 // **Verify Popup is Displayed**
    public boolean isStopLocationSharingPopupDisplayed() {
        return driver.findElement(stopLocationSharingPopup).isDisplayed();
    }

    // **Verify Header Text**
    public String getStopLocationSharingHeaderText() {
        return driver.findElement(stopLocationSharingHeader).getText();
    }

    // **Verify Instruction Text**
    public String getStopLocationSharingInstructionText() {
    	//System.out.print(driver.findElement(stopLocationSharingInstructions).getText());
        return driver.findElement(stopLocationSharingInstructions).getText();
    }

    // **Verify Reason Header Text**
    public String getStopLocationSharingReasonHeaderText() {
    	//System.out.print(driver.findElement(stopLocationSharingNotificationText).getText());

        return driver.findElement(By.id("com.globalrescue.enterprise:id/tvReasonHeader")).getText();
        
    }
    public String getStartLocationSharingReasonHeaderText() {
    	//System.out.print(driver.findElement(stopLocationSharingNotificationText).getText());

        return driver.findElement(By.id("com.globalrescue.enterprise:id/tv_header")).getText();
        
    }

    // **Verify Cancel Button is Clickable**
    public boolean isCancelStopSharingButtonClickable() {
        return driver.findElement(cancelStopSharingButton).isEnabled();
    }

    // **Verify Confirm Stop Button is Clickable**
    public boolean isConfirmStopSharingButtonClickable() {
        return driver.findElement(confirmStopSharingButton).isEnabled();
    }

    // **Click Cancel Button**
    public void clickCancelStopSharing() {
        driver.findElement(cancelStopSharingButton).click();
    }

    // **Click Confirm Stop Button**
    public void clickConfirmStopSharing() {
        driver.findElement(confirmStopSharingButton).click();
    }
    public boolean isStopLocationSharingDisplayed() {
        return driver.findElement(stopLocationSharingButton).isDisplayed();
    }

    // **Methods to Verify Button Text**
    public String getCancelEmergencyText() {
        return driver.findElement(cancelEmergencyButton).getText();
    }
 

    public String getStopLocationSharingText() {
        return driver.findElement(stopLocationSharingButton).getText();
    }

    // **Methods to Verify Buttons Are Clickable**
    public boolean isCancelEmergencyClickable() {
        return driver.findElement(cancelEmergencyButton).isEnabled();
    }

    public boolean isStopLocationSharingClickable() {
        return driver.findElement(stopLocationSharingButton).isEnabled();
    }

    // **Click Actions**
    public void clickCancelEmergency() {
        driver.findElement(cancelEmergencyButton).click();
    }

    public void clickStopLocationSharing() {
        driver.findElement(stopLocationSharingButton).click();
    }
    public boolean isTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).isDisplayed();
    }

    public String getTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public boolean isSyncChatButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(syncChatButton)).isDisplayed();
    }

    public boolean isSyncChatButtonClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(syncChatButton)).isEnabled();
    }

    public boolean isMoreOptionsButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/btnMoreOptions"))).isDisplayed();
    }

    public boolean isMoreOptionsButtonClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(By.id("com.globalrescue.enterprise:id/btnMoreOptions"))).isEnabled();
    }
 
    public boolean isStopLocationSharingButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(stopLocationSharingButton)).isDisplayed();
    }

    public boolean isStopLocationSharingButtonClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(stopLocationSharingButton)).isEnabled();
    }

    public String getStopLocationSharingButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(stopLocationSharingButton)).getText();
    }
    /** ✅ Verify Emergency Recipients Title is Displayed */
    public boolean isEmergencyRecipientsTitleDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emergencyRecipientsTitle)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Emergency Recipients Title is NOT displayed: " + e.getMessage());
            return false;
        }
    }

    /** ✅ Get Emergency Recipients Title Text */
    public String getEmergencyRecipientsTitleText() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emergencyRecipientsTitle)).getText();
        } catch (Exception e) {
            System.out.println("❌ Failed to retrieve Emergency Recipients Title text: " + e.getMessage());
            return "";
        }
    }

    /** ✅ Check if Emergency Notification Text is Displayed */
    public boolean isEmergencyNotificationTextDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emergencyNotificationText)).isDisplayed();
    }
 // Locator for Grid Comments Input Field

    // Locator for Send Button

    /** ✅ Enter Emergency Text in Grid Comments */
    public void enterEmergencyText(String text) {
        try {
            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(emergencyInputField));
            inputField.clear();  // Ensure field is empty before entering text
            inputField.sendKeys(text);
            System.out.println("✅ Successfully entered emergency text: " + text);
        } catch (Exception e) {
            System.out.println("❌ Failed to enter text in Grid Comments: " + e.getMessage());
            throw e;
        }
    }

    /** ✅ Get Entered Text from Grid Comments */
    public String getEnteredEmergencyText() {
        try {
            WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(emergencyInputField));
            return inputField.getText();
        } catch (Exception e) {
            System.out.println("❌ Failed to retrieve text from Grid Comments: " + e.getMessage());
            throw e;
        }
    }

    /** ✅ Click on Send Button */
    public void clickSendButton() {
        try {
            WebElement sendBtn = wait.until(ExpectedConditions.elementToBeClickable(sendNotificationButton));
            sendBtn.click();
            System.out.println("✅ Successfully clicked on Send button.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click Send button: " + e.getMessage());
            throw e;
        }
    }

    /** ✅ Get Emergency Notification Text */
    public String getEmergencyNotificationText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emergencyNotificationText)).getText();
    }

    /** ✅ Check if Emergency List View is Displayed */
    public boolean isEmergencyListViewDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emergencyListView)).isDisplayed();
    }

    /** ✅ Check if Contact Profile Image is Displayed */
    public boolean isContactProfileImageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactProfileImage)).isDisplayed();
    }

    /** ✅ Check if Contact Name Initials are Displayed */
    public boolean isContactNameInitialsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactNameInitials)).isDisplayed();
    }

    /** ✅ Get Contact Name */
    public String getContactNameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactName)).getText();
    }

    /** ✅ Get Contact Email */
    public String getContactEmailText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactEmail)).getText();
    }

    /** ✅ Get Contact Phone Number */
    public String getContactPhoneNumberText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactPhoneNumber)).getText();
    }
    public void pressAndHoldEmergencyButton() {
    	try {
        WebElement element = driver.findElement(emergencyButton);
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).pause(Duration.ofSeconds(4)).release().perform();
        System.out.println("✅ Successfully pressed and held the emergency button for 3.5 seconds.");
    } catch (Exception e) {
        System.out.println("❌ Failed to press and hold the emergency button: " + e.getMessage());
        throw e;
    	}
    }
    // Methods to verify visibility of elements
    public boolean isNotificationMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(notificationMessage)).isDisplayed();
    }

    public String getNotificationMessageText() {
        return driver.findElement(notificationMessage).getText();
    }

    public boolean isCancelNotificationButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cancelNotificationButton)).isDisplayed();
    }

    public boolean isNatureOfEmergencyLabelDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(natureOfEmergencyLabel)).isDisplayed();
    }

    public String getNatureOfEmergencyLabelText() {
        return driver.findElement(natureOfEmergencyLabel).getText();
    }

    public boolean isEmergencyInputFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emergencyInputField)).isDisplayed();
    }

    public boolean isEmergencyInputFieldWritable() {
        WebElement inputField = driver.findElement(emergencyInputField);
        return inputField.isEnabled() && inputField.isDisplayed();
    }

    public String getEmergencyInputFieldPlaceholder() {
        return driver.findElement(emergencyInputField).getAttribute("hint"); // Fetching placeholder text
    }

    public boolean isTextCountLabelDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textCountLabel)).isDisplayed();
    }

    public String getTextCountLabelText() {
        return driver.findElement(textCountLabel).getText();
    }

    // Cancel Emergency Button
    public boolean isCancelEmergencyButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cancelEmergencyButton)).isDisplayed();
    }

    public boolean isCancelEmergencyButtonClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(cancelEmergencyButton)).isDisplayed();
    }

    public String getCancelEmergencyButtonText() {
        return driver.findElement(cancelEmergencyButton).getText();
    }

    // Send Notification Button
    public boolean isSendNotificationButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sendNotificationButton)).isDisplayed();
    }

    public String getSendNotificationButtonText() {
        return driver.findElement(sendNotificationButton).getText();
    }

    // Auto Location Share Text
    public boolean isAutoLocationShareTextDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(autoLocationShareText)).isDisplayed();
    }

    public String getAutoLocationShareText() {
        return driver.findElement(autoLocationShareText).getText();
    }

    // Emergency Recipients Message
    public boolean isEmergencyRecipientsMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emergencyRecipientsMessage)).isDisplayed();
    }

    public String getEmergencyRecipientsMessageText() {
        return driver.findElement(emergencyRecipientsMessage).getText();
    }

    // See List of Recipients Button
    public boolean isSeeListOfRecipientsButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(seeListOfRecipientsButton)).isDisplayed();
    }

    public boolean isSeeListOfRecipientsButtonClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(seeListOfRecipientsButton)).isDisplayed();
    }

    public String getSeeListOfRecipientsButtonText() {
        return driver.findElement(seeListOfRecipientsButton).getText();
    }

    public void clickSeeListOfRecipientsButton() {
        driver.findElement(seeListOfRecipientsButton).click();
    }
    private By homeCityField = By.id("com.globalrescue.enterprise:id/homeCity");
    public void enterHomeCity(String cityName) {
        WebElement cityField = driver.findElement(homeCityField);
        cityField.clear();
        cityField.sendKeys(cityName);
    }
}
