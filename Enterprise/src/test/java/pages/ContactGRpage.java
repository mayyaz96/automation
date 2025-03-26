package pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ContactGRpage {
    
    private AndroidDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ContactGRpage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
 // 📌 Element for Attachment Button
 // Call Confirmation Dialog
    private By callDialogContainer = By.xpath("//android.view.ViewGroup");
    private By callDialogTitle = By.id("com.globalrescue.enterprise:id/titleDialog");
    private By callDialogMessage = By.id("com.globalrescue.enterprise:id/messageDialog");
    private By cancelButton = By.id("com.globalrescue.enterprise:id/continue_btn");
    private By callButton = By.id("com.globalrescue.enterprise:id/logout_btn");

    // Locators
    private By contactGRButton = By.id("com.globalrescue.enterprise:id/b_contact_GRs");
    private By pageTitle = By.id("com.globalrescue.enterprise:id/title"); // Assuming title ID
    private By backButton = By.id("com.globalrescue.enterprise:id/toolbar_back");
    // Locators
    private By syncChatButton = By.id("com.globalrescue.enterprise:id/btnSyncChat");
    private By callUsText = By.xpath("//android.widget.TextView[@text='Call Us']");
    private By callUsSection = By.id("com.globalrescue.enterprise:id/parentCall");
    private By callUsArrow = By.id("com.globalrescue.enterprise:id/arrow");
    private By callerLayout = By.xpath("//android.view.ViewGroup[@resource-id='com.globalrescue.enterprise:id/parent_caller_layout']");
    private By bottomLayout = By.xpath("//android.view.ViewGroup[@resource-id='com.globalrescue.enterprise:id/bottomLayout']");
    private By messageInputField = By.id("com.globalrescue.enterprise:id/text");
    private By attachmentButton = By.id("com.globalrescue.enterprise:id/btnAttachment");
    private By sendMessageButton = By.id("com.globalrescue.enterprise:id/b_send_message");
 // Smart Overlay View
    private By smartOverlayView = By.xpath("//android.widget.FrameLayout[@resource-id='com.google.android.GoogleCamera:id/smarts_overlay_view']");
    private By callFromOutsideButton = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/callFromOutside']");

    // Close Button
    private By CameraCloseButton = By.xpath("//android.widget.ImageButton[@content-desc='Close']");

    // Switch to Front Camera Button
    private By switchCameraButton = By.xpath("//android.widget.ImageButton[@content-desc='Switch to front camera']");

    // Shutter Button
    private By shutterButton = By.id("com.google.android.GoogleCamera:id/shutter_button");

 // 📌 Elements Declaration
    private By callButtonLayout = By.id("com.globalrescue.enterprise:id/call_button_layout");
    private By withinUsText = By.id("com.globalrescue.enterprise:id/textView12");
    private By callFromInsideUs = By.id("com.globalrescue.enterprise:id/callfromInside");
    private By outsideUsText = By.id("com.globalrescue.enterprise:id/textView14");
    private By callFromOutsideUs1 = By.id("com.globalrescue.enterprise:id/callFromOutside");
    private By callFromOutsideUs2 = By.id("com.globalrescue.enterprise:id/callFromOutside2");
 // 📌 Root Menu Layout
    private By menuRecyclerView = By.id("com.globalrescue.enterprise:id/rvMenu");
 // First ImageView Icon (Index 1)
 // First RelativeLayout Element (Instance 0)
    private By firstRelativeLayout = By.xpath("(//android.widget.RelativeLayout)[1]");
 // Close Button
    private By closeButton = By.id("com.globalrescue.enterprise:id/btnClose");

    // 📌 Icons inside the menu

 // 📌 Locating an element using AndroidUIAutomator
    private By firstIcon = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.globalrescue.enterprise:id/ivIcon\").instance(0)");
    private By allIcons = By.id("com.globalrescue.enterprise:id/ivIcon");
 // Main Image Element
    private By mainImage = By.id("com.globalrescue.enterprise:id/ivMainImage");
    private By mainDocumentImage = By.id("com.globalrescue.enterprise:id/ivDocumentMain");
    private By mainCameraImage = By.xpath("//android.widget.ImageView[@resource-id=\"com.globalrescue.enterprise:id/ivMainImage\"]");
    // Caption Input Field
    private By captionInputField = By.id("com.globalrescue.enterprise:id/text");
 // Close Button
 // "Call from Inside" Button
    private By callFromInsideButton = By.id("com.globalrescue.enterprise:id/callfromInside");

    // Send Button

    // 📌 Text Elements
    private By galleryBtn = By.xpath("//android.widget.ImageView[@resource-id='com.globalrescue.enterprise:id/ivIcon'])[1]");
    private By galleryText = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/tvTitle' and @text='Gallery']");
    private By documentText = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/tvTitle' and @text='Document']");
    private By cameraText = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/tvTitle' and @text='Camera']");
 // FrameLayout Element (Instance 16)
    private By frameLayoutInstance16 = By.xpath("(//android.widget.FrameLayout)[17]"); // XPath uses 1-based index, so 16th element is [17]
 // Locators
    private By callDialog = By.xpath("//android.view.ViewGroup");
    private By callFromOutside2 = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/callFromOutside2']");
 // Locators
    private By sentMessageText = By.id("com.globalrescue.enterprise:id/tvMessageContent");

    // Method to enter text in the message field
    public void enterMessageText(String message) {
        try {
            WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(messageInputField));
            messageField.clear();
            messageField.sendKeys(message);
            System.out.println("✅ Message entered: " + message);
        } catch (Exception e) {
            System.out.println("❌ Failed to enter message: " + e.getMessage());
            throw e;
        }
    }

    // Method to click on Send Message button
    

    // Method to verify if the sent message is displayed correctly
    public boolean isSentMessageDisplayed(String expectedMessage) {
        try {
            WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sentMessageText));
            String actualMessage = messageElement.getText().trim();
            System.out.println("🔍 Verifying sent message: " + actualMessage);
            return actualMessage.equals(expectedMessage);
        } catch (Exception e) {
            System.out.println("❌ Failed to verify sent message: " + e.getMessage());
            return false;
        }
    }

    public void clickCallFromOutside2() {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(callFromOutside2));
            element.click();
            System.out.println("✅ Successfully clicked on 'Call From Outside 2' button.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click on 'Call From Outside 2' button: " + e.getMessage());
            throw e;
        }
    }

    public boolean isCancelButtonDisplayed() {
        return isElementDisplayed(cancelButton);
    }
    public boolean isElementClickable(By locator) {
        try {
            return driver.findElement(locator).isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isElementDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getElementText(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText().trim();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean isCallDialogDisplayed() {
        return isElementDisplayed(callDialog);
    }
    public boolean isCancelButtonClickable() {
        return isElementClickable(cancelButton);
    }
   
    public boolean isCallButtonDisplayed() {
        return isElementDisplayed(callButton);
    }
    public boolean isCallDialogTitleDisplayed() {
        try {
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(callDialogTitle));
            return title.isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Call Dialog Title is NOT displayed: " + e.getMessage());
            return false;
        }
    }

    public String getCallDialogTitleText() {
        return driver.findElement(callDialogTitle).getText().trim();
    }
    public boolean isCallDialogMessageDisplayed() {
        try {
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(callDialogMessage));
            return message.isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Call Dialog Message is NOT displayed: " + e.getMessage());
            return false;
        }
    }
    

    public String getCancelButtonText() {
        return driver.findElement(cancelButton).getText().trim();
    }

    public void clickCancelButton() {
        try {
            if (isCancelButtonClickable()) {
                driver.findElement(cancelButton).click();
                System.out.println("✅ Clicked on Cancel button.");
            } else {
                System.out.println("❌ Cancel button is NOT clickable.");
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to click on Cancel button: " + e.getMessage());
            throw e;
        }
    }
    public boolean isCallButtonClickable() {
        try {
            WebElement callBtn = wait.until(ExpectedConditions.elementToBeClickable(callButton));
            return callBtn.isDisplayed() && callBtn.isEnabled();
        } catch (Exception e) {
            System.out.println("❌ Call button is NOT clickable: " + e.getMessage());
            return false;
        }
    }

    public String getCallButtonText() {
        return driver.findElement(callButton).getText().trim();
    }

    public void clickCallButton() {
        try {
            if (isCallButtonClickable()) {
                driver.findElement(callButton).click();
                System.out.println("✅ Clicked on Call button.");
            } else {
                System.out.println("❌ Call button is NOT clickable.");
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to click on Call button: " + e.getMessage());
            throw e;
        }
    }

    public String getCallDialogMessageText() {
        return driver.findElement(callDialogMessage).getText().trim();
    }

    public boolean isCallFromInsideButtonClickable() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(callFromInsideButton));
            return button.isDisplayed() && button.isEnabled();
        } catch (Exception e) {
            System.out.println("❌ 'Call from Inside' button is NOT clickable: " + e.getMessage());
            return false;
        }
    }

    public void clickCallFromInsideButton() {
        try {
            if (isCallFromInsideButtonClickable()) {
                driver.findElement(callFromInsideButton).click();
                System.out.println("✅ Successfully clicked on the 'Call from Inside' button.");
            } else {
                System.out.println("❌ 'Call from Inside' button is NOT clickable.");
            }
        } catch (Exception e) {
            System.out.println("❌ Failed to click on the 'Call from Inside' button: " + e.getMessage());
            throw e;
        }
    }

    public boolean isCloseButtonVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(closeButton)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Close Button is NOT visible: " + e.getMessage());
            return false;
        }
    }
    public boolean isSmartOverlayViewVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(smartOverlayView)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isCloseIconVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(CameraCloseButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isSwitchCameraButtonVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(switchCameraButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isShutterButtonVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(shutterButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickShutterButton() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(shutterButton));
            button.click();
            System.out.println("✅ Successfully clicked on the Shutter Button.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click on the Shutter Button: " + e.getMessage());
            throw e;
        }
    }

    public void openImageSelection() {
        try {
            clickAttachmentButton();
            clickFirstIcon();
            clickFirstRelativeLayout();
            clickFrameLayoutInstance16();

            System.out.println("✅ Successfully navigated back to the image.");
        } catch (Exception e) {
            System.out.println("❌ Failed to navigate back to the image: " + e.getMessage());
            throw e;
        }
    }


    public void clickCloseButton() {
        try {
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeButton));
            closeBtn.click();
            System.out.println("✅ Successfully clicked on the Close button.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click Close Button: " + e.getMessage());
            throw e;
        }
    }

    public boolean isMainImageVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(mainImage)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Main Image is NOT visible: " + e.getMessage());
            return false;
        }
    }
    public boolean isMainDocumentImageVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(mainDocumentImage)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Main Image is NOT visible: " + e.getMessage());
            return false;
        }
    }
    public boolean isMainCameraImageVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(mainCameraImage)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Main Image is NOT visible: " + e.getMessage());
            return false;
        }
    }
    public boolean isCaptionInputVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(captionInputField)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Caption Input Field is NOT visible: " + e.getMessage());
            return false;
        }
    }
    public void clickCameraButton() {
        try {
            // Wait for the camera button to be clickable
            WebElement cameraButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.widget.ImageView[@resource-id='com.globalrescue.enterprise:id/ivIcon'])[3]")
            ));

            // Click on the camera button
            cameraButton.click();

            System.out.println("✅ Successfully clicked on the Camera button.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click on the Camera button: " + e.getMessage());
            throw e;
        }
    }


    public String getCaptionPlaceholderText() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(captionInputField)).getText();
        } catch (Exception e) {
            System.out.println("❌ Could not retrieve Caption Placeholder Text: " + e.getMessage());
            return "";
        }
    }
    public boolean isSendMessageButtonVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(sendMessageButton)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Send Message Button is NOT visible: " + e.getMessage());
            return false;
        }
    }

    public void clickFrameLayoutInstance16() {
        try {
            WebElement frameLayout = wait.until(ExpectedConditions.elementToBeClickable(frameLayoutInstance16));
            frameLayout.click();
            System.out.println("✅ Successfully clicked on FrameLayout instance 16.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click on FrameLayout instance 16: " + e.getMessage());
            throw e;
        }
    }
    
    public void clickFirstRelativeLayout() {
        try {
            WebElement relativeLayout = wait.until(ExpectedConditions.elementToBeClickable(firstRelativeLayout));
            relativeLayout.click();
            System.out.println("✅ Successfully clicked on the first RelativeLayout.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click on the first RelativeLayout: " + e.getMessage());
            throw e;
        }
    }
    public void clickFirstIcon() {
        try {
            WebElement icon = wait.until(ExpectedConditions.elementToBeClickable(firstIcon));
            icon.click();
            System.out.println("✅ Successfully clicked on the first ImageView icon.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click on the first ImageView icon: " + e.getMessage());
            throw e;
        }
    }
    // 📌 Verify if menu is displayed
    public boolean isMenuDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(menuRecyclerView)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Menu not found: " + e.getMessage());
            return false;
        }
    }

    // 📌 Verify if icons exist
    public boolean isFirstIconDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(firstIcon)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ First icon not found: " + e.getMessage());
            return false;
        }
    }

    public boolean areAllIconsDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(allIcons)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Icons not found: " + e.getMessage());
            return false;
        }
    }

    // 📌 Verify if text labels exist
    public boolean isGalleryTextDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(galleryText)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ 'Gallery' text not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isDocumentTextDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(documentText)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ 'Document' text not found: " + e.getMessage());
            return false;
        }
    }

    public boolean isCameraTextDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(cameraText)).isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ 'Camera' text not found: " + e.getMessage());
            return false;
        }
    }

 // 📌 Method to verify Call Button Layout visibility
    public boolean isCallButtonLayoutDisplayed() {
        return driver.findElement(callButtonLayout).isDisplayed();
    }

    // 📌 Method to verify "Within US" label visibility
    public boolean isWithinUsTextDisplayed() {
        return driver.findElement(withinUsText).isDisplayed();
    }

    // 📌 Method to retrieve "Within US" text
    public String getWithinUsText() {
        return driver.findElement(withinUsText).getText().trim();
    }

    // 📌 Method to verify "Call From Inside US" visibility
    public boolean isCallFromInsideUsDisplayed() {
        return driver.findElement(callFromInsideUs).isDisplayed();
    }

    // 📌 Method to retrieve "Call From Inside US" number
    public String getCallFromInsideUsText() {
        return driver.findElement(callFromInsideUs).getText().trim();
    }

    // 📌 Method to verify "Outside US" label visibility
    public boolean isOutsideUsTextDisplayed() {
        return driver.findElement(outsideUsText).isDisplayed();
    }

    // 📌 Method to retrieve "Outside US" text
    public String getOutsideUsText() {
        return driver.findElement(outsideUsText).getText().trim();
    }

    // 📌 Method to verify "Call From Outside US" (First Number) visibility
    public boolean isCallFromOutsideUs1Displayed() {
        return driver.findElement(callFromOutsideUs1).isDisplayed();
    }

    // 📌 Method to retrieve "Call From Outside US" (First Number) text
    public String getCallFromOutsideUs1Text() {
        return driver.findElement(callFromOutsideUs1).getText().trim();
    }

    // 📌 Method to verify "Call From Outside US" (Second Number) visibility
    public boolean isCallFromOutsideUs2Displayed() {
        return driver.findElement(callFromOutsideUs2).isDisplayed();
    }

    // 📌 Method to retrieve "Call From Outside US" (Second Number) text
    public String getCallFromOutsideUs2Text() {
        return driver.findElement(callFromOutsideUs2).getText().trim();
    }
 // 📌 Method to click on the Attachment Button
    public void clickAttachmentButton() {
        try {
            WebElement attachBtn = wait.until(ExpectedConditions.elementToBeClickable(attachmentButton));
            attachBtn.click();
            System.out.println("✅ Attachment button clicked successfully.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click Attachment button: " + e.getMessage());
            throw e;
        }
    }
    public void enterImageMessage(String message) {
        try {
            WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/text")));
            messageField.sendKeys(message);
            System.out.println("✅ Entered text: " + message);
        } catch (Exception e) {
            System.out.println("❌ Failed to enter text in the message input field: " + e.getMessage());
            throw e;
        }
    }
    public void clickSendMessageButton() {
        try {
            WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.globalrescue.enterprise:id/b_send_message")));
            sendButton.click();
            System.out.println("✅ Clicked on the send message button.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click on the send message button: " + e.getMessage());
            throw e;
        }
    }
    public boolean isImageDisplayed() {
        try {
            WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/ivImage")));
            return imageElement.isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Image is NOT displayed: " + e.getMessage());
            return false;
        }
    }
    public void clickDocumentButton() {
        try {
            WebElement documentButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/tvTitle' and @text='Document']")
            ));
            documentButton.click();
            System.out.println("✅ Successfully clicked on the Document button.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click on the Document button: " + e.getMessage());
            throw e;
        }
    }
    public void selectSpecificPDF() {
        try {
            // Wait for the specific PDF file to be displayed
            WebElement specificPDF = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.documentsui:id/icon_thumb'])[2]")
            ));

            // Click on the specific PDF file
            specificPDF.click();

            System.out.println("✅ Successfully selected the specific PDF file.");
        } catch (Exception e) {
            System.out.println("❌ Failed to select the specific PDF file: " + e.getMessage());
            throw e;
        }
    }



    public String getImageCaptionText() {
        try {
            WebElement captionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.globalrescue.enterprise:id/tvMessage\" and @text=\"This image is sent by automation\"]")));
            return captionElement.getText().trim();
        } catch (Exception e) {
            System.out.println("❌ Failed to get image caption text: " + e.getMessage());
            return null;
        }
    }
    public String getDocumentImageCaptionText() {
        try {
            WebElement captionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.globalrescue.enterprise:id/tvMessage\" and @text=\"This Document is sent by automation\"]")));
            return captionElement.getText().trim();
        } catch (Exception e) {
            System.out.println("❌ Failed to get image caption text: " + e.getMessage());
            return null;
        }
    }
    public String getCameraImageCaptionText() {
        try {
            WebElement captionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@resource-id=\"com.globalrescue.enterprise:id/text\"]")));
            return captionElement.getText().trim();
        } catch (Exception e) {
            System.out.println("❌ Failed to get image caption text: " + e.getMessage());
            return null;
        }
    }
    // 📌 **Encapsulated Methods**
    public void clickArrowButton() {
        WebElement arrowButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.globalrescue.enterprise:id/arrow")));
        arrowButton.click();
    }

    /** ✅ Verify Back Button is Displayed */
    public boolean isBackButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(backButton)).isDisplayed();
    }

    /** ✅ Get Back Button Text */
    public String getBackButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(backButton)).getText();
    }
 // Locator for "Call from Outside" button

    // Method to click on "Call from Outside" button
    public void clickCallFromOutside() {
        try {
            WebElement callButton = wait.until(ExpectedConditions.elementToBeClickable(callFromOutsideButton));
            callButton.click();
            System.out.println("✅ Successfully clicked on 'Call from Outside' button.");
        } catch (Exception e) {
            System.out.println("❌ Failed to click on 'Call from Outside' button: " + e.getMessage());
            throw e;
        }
    }

 // Method to Click the Android Back Button
    public void pressAndroidBackButton() {
        try {
            driver.navigate().back();
            System.out.println("✅ Successfully pressed the Android Back button.");
        } catch (Exception e) {
            System.out.println("❌ Failed to press the Android Back button: " + e.getMessage());
            throw e;
        }
    }

    /** ✅ Verify Page Title is Displayed */
    public boolean isPageTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
    }

    /** ✅ Get Page Title Text */
    public String getPageTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    /** ✅ Verify Sync Chat Button is Displayed */
    public boolean isSyncChatButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(syncChatButton)).isDisplayed();
    }

    /** ✅ Verify Call Us Text is Displayed */
    public boolean isCallUsTextDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(callUsText)).isDisplayed();
    }

    /** ✅ Get Call Us Text */
    public String getCallUsText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(callUsText)).getText();
    }

    /** ✅ Verify Call Us Section is Displayed */
    public boolean isCallUsSectionDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(callUsSection)).isDisplayed();
    }

    /** ✅ Verify Call Us Arrow is Displayed */
    public boolean isCallUsArrowDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(callUsArrow)).isDisplayed();
    }

    /** ✅ Verify Caller Layout is Displayed */
    public boolean isCallerLayoutDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(callerLayout)).isDisplayed();
    }

    /** ✅ Verify Bottom Layout is Displayed */
    public boolean isBottomLayoutDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(bottomLayout)).isDisplayed();
    }

    /** ✅ Verify Message Input Field is Displayed */
    public boolean isMessageInputFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messageInputField)).isDisplayed();
    }

    /** ✅ Get Message Input Placeholder Text */
    public String getMessageInputPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(messageInputField)).getAttribute("text");
    }

    /** ✅ Verify Attachment Button is Displayed */
    public boolean isAttachmentButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(attachmentButton)).isDisplayed();
    }

    /** ✅ Verify Send Message Button is Displayed */
    public boolean isSendMessageButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(sendMessageButton)).isDisplayed();
    }
    // Encapsulated Methods
    
    /**
     * Clicks on the Contact GR button.
     */
    public void clickContactGRButton() {
        wait.until(ExpectedConditions.elementToBeClickable(contactGRButton)).click();
    }
    public void navigateToContactGR() {
        clickContactGRButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
    }
    /**
     * Checks if the Contact GR Page title is displayed.
     */
  
    

    /**
     * Clicks the Back button.
     */
    public void clickBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }
}
