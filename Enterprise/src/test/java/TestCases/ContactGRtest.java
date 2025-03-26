package TestCases;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import base.BaseSetup;
import io.appium.java_client.android.AndroidDriver;
import pages.ContactGRpage;
import pages.DestinationReportPage;
import utilities.ExtentReportsManager;

public class ContactGRtest extends BaseSetup {
    
    private ContactGRpage contactGRpage;
    private ExtentReports extent;
    private AndroidDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    @BeforeSuite
    public void setupExtentReports() {
        extent = ExtentReportsManager.getExtentReports(); // Ensures a valid ExtentReports instance
        if (extent == null) {
            throw new RuntimeException("❌ ExtentReports instance is null. Check ExtentReportsManager.");
        }
    }

    @BeforeClass
    public void setup() {
        driver = getDriver(); // Ensure driver is initialized
        if (driver == null) {
            throw new RuntimeException("❌ Driver is NULL! Ensure Appium server is running.");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        contactGRpage = new ContactGRpage(driver, wait); // Assuming contactGRpage needs driver & wait
    }

    @Test(priority = 1, description = "Verify Clicking on Contact GR Page Navigates Successfully")
    public void verifyContactGRNavigation() {
        test = extent.createTest("Verify Contact GR Page Navigation");
        try {
            contactGRpage.navigateToContactGR();
            Assert.assertTrue(contactGRpage.isPageTitleDisplayed(), "❌ Contact GR page title is NOT displayed!");
            test.pass("✅ Successfully navigated to Contact GR page.");
        } catch (Exception e) {
            test.fail("❌ Contact GR page navigation failed: " + e.getMessage());
            Assert.fail("Contact GR navigation test failed!", e);
        }
    }
    /** ✅ **Test: Verify Back Button Display** */
    @Test(priority = 2, description = "Verify Back Button is Displayed")
    public void verifyBackButtonDisplayed() {
        test = extent.createTest("Verify Back Button is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isBackButtonDisplayed(), "❌ Back button is NOT displayed!");
            test.pass("✅ Back button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Back button verification failed: " + e.getMessage());
            Assert.fail("Back button verification test failed!", e);
        }
    }

    /** ✅ **Test: Verify Back Button Text** */
    @Test(priority = 3, description = "Verify Back Button Text")
    public void verifyBackButtonText() {
        test = extent.createTest("Verify Back Button Text");
        try {
            Assert.assertEquals(contactGRpage.getBackButtonText(), "Back", "❌ Back button text mismatch!");
            test.pass("✅ Back button text is correct: 'Back'.");
        } catch (Exception e) {
            test.fail("❌ Back button text verification failed: " + e.getMessage());
            Assert.fail("Back button text verification test failed!", e);
        }
    }

    /** ✅ **Test: Verify Page Title Display** */
    @Test(priority = 4, description = "Verify Page Title is Displayed")
    public void verifyPageTitleDisplayed() {
        test = extent.createTest("Verify Page Title is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isPageTitleDisplayed(), "❌ Page title is NOT displayed!");
            test.pass("✅ Page title is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Page title verification failed: " + e.getMessage());
            Assert.fail("Page title verification test failed!", e);
        }
    }

    /** ✅ **Test: Verify Page Title Text** */
    @Test(priority = 5, description = "Verify Page Title Text")
    public void verifyPageTitleText() {
        test = extent.createTest("Verify Page Title Text");
        try {
            Assert.assertEquals(contactGRpage.getPageTitleText(), "Contact Global Rescue", "❌ Page title text mismatch!");
            test.pass("✅ Page title text is correct: 'Contact Global Rescue'.");
        } catch (Exception e) {
            test.fail("❌ Page title text verification failed: " + e.getMessage());
            Assert.fail("Page title text verification test failed!", e);
        }
    }

    /** ✅ **Test: Verify Sync Chat Button** */
    @Test(priority = 6, description = "Verify Sync Chat Button is Displayed")
    public void verifySyncChatButtonDisplayed() {
        test = extent.createTest("Verify Sync Chat Button is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isSyncChatButtonDisplayed(), "❌ Sync Chat button is NOT displayed!");
            test.pass("✅ Sync Chat button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Sync Chat button verification failed: " + e.getMessage());
            Assert.fail("Sync Chat button verification test failed!", e);
        }
    }

    /** ✅ **Test: Verify Call Us Section Display** */
    @Test(priority = 7, description = "Verify Call Us Section is Displayed")
    public void verifyCallUsSectionDisplayed() {
        test = extent.createTest("Verify Call Us Section is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallUsSectionDisplayed(), "❌ Call Us section is NOT displayed!");
            test.pass("✅ Call Us section is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Call Us section verification failed: " + e.getMessage());
            Assert.fail("Call Us section verification test failed!", e);
        }
    }

    /** ✅ **Test: Verify Message Input Placeholder** */
    @Test(priority = 8, description = "Verify Message Input Placeholder")
    public void verifyMessageInputPlaceholder() {
        test = extent.createTest("Verify Message Input Placeholder");
        try {
            Assert.assertEquals(contactGRpage.getMessageInputPlaceholder(), "Enter your message here…", "❌ Message input placeholder text mismatch!");
            test.pass("✅ Message input placeholder text is correct.");
        } catch (Exception e) {
            test.fail("❌ Message input placeholder verification failed: " + e.getMessage());
            Assert.fail("Message input placeholder verification test failed!", e);
        }
    }

    /** ✅ **Test: Verify Send Message Button** */
    @Test(priority = 9, description = "Verify Send Message Button is Displayed")
    public void verifySendMessageButtonDisplayed() {
        test = extent.createTest("Verify Send Message Button is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isSendMessageButtonDisplayed(), "❌ Send Message button is NOT displayed!");
            test.pass("✅ Send Message button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Send Message button verification failed: " + e.getMessage());
            Assert.fail("Send Message button verification test failed!", e);
        }
    }
    @Test(priority = 10, description = "Click on Arrow Button in Contact Global Rescue Page")
    public void clickArrowButton() {
        test = extent.createTest("Click on Arrow Button in Contact Global Rescue Page");
        
        try {
            contactGRpage.clickArrowButton(); // Perform click action
            test.pass("✅ Successfully clicked on the arrow button.");
        } catch (Exception e) {
            test.fail("❌ Clicking on arrow button failed: " + e.getMessage());
            Assert.fail("Arrow button click test failed!", e);
        }
    }
 // 📌 Test to verify Call Button Layout visibility
    @Test(priority = 11, description = "Verify Call Button Layout is Displayed")
    public void verifyCallButtonLayoutDisplayed() {
        test = extent.createTest("Verify Call Button Layout Visibility");
        try {
            Assert.assertTrue(contactGRpage.isCallButtonLayoutDisplayed(), "❌ Call Button Layout is NOT displayed!");
            test.pass("✅ Call Button Layout is displayed.");
        } catch (Exception e) {
            test.fail("❌ Call Button Layout verification failed: " + e.getMessage());
            Assert.fail("Call Button Layout verification test failed!", e);
        }
    }

    // 📌 Test to verify "Within US" label visibility
    @Test(priority = 12, description = "Verify 'Within US' Label is Displayed")
    public void verifyWithinUsTextDisplayed() {
        test = extent.createTest("Verify 'Within US' Label Visibility");
        try {
            Assert.assertTrue(contactGRpage.isWithinUsTextDisplayed(), "❌ 'Within US' label is NOT displayed!");
            test.pass("✅ 'Within US' label is displayed.");
        } catch (Exception e) {
            test.fail("❌ 'Within US' label verification failed: " + e.getMessage());
            Assert.fail("'Within US' label verification test failed!", e);
        }
    }

    // 📌 Test to verify "Within US" label text
    @Test(priority = 13, description = "Verify 'Within US' Label Text")
    public void verifyWithinUsText() {
        test = extent.createTest("Verify 'Within US' Label Text");
        try {
            Assert.assertEquals(contactGRpage.getWithinUsText(), "Within US", "❌ 'Within US' text mismatch!");
            test.pass("✅ 'Within US' text is correct.");
        } catch (Exception e) {
            test.fail("❌ 'Within US' text verification failed: " + e.getMessage());
            Assert.fail("'Within US' text verification test failed!", e);
        }
    }

    // 📌 Test to verify "Call From Inside US" visibility
    @Test(priority = 14, description = "Verify 'Call From Inside US' Number is Displayed")
    public void verifyCallFromInsideUsDisplayed() {
        test = extent.createTest("Verify 'Call From Inside US' Number Visibility");
        try {
            Assert.assertTrue(contactGRpage.isCallFromInsideUsDisplayed(), "❌ 'Call From Inside US' number is NOT displayed!");
            test.pass("✅ 'Call From Inside US' number is displayed.");
        } catch (Exception e) {
            test.fail("❌ 'Call From Inside US' verification failed: " + e.getMessage());
            Assert.fail("'Call From Inside US' verification test failed!", e);
        }
    }

    // 📌 Test to verify "Call From Inside US" text
    @Test(priority = 15, description = "Verify 'Call From Inside US' Number Text")
    public void verifyCallFromInsideUsText() {
        test = extent.createTest("Verify 'Call From Inside US' Number Text");
        try {
            Assert.assertEquals(contactGRpage.getCallFromInsideUsText(), "(800) 381-9754", "❌ 'Call From Inside US' number mismatch!");
            test.pass("✅ 'Call From Inside US' number is correct.");
        } catch (Exception e) {
            test.fail("❌ 'Call From Inside US' number verification failed: " + e.getMessage());
            Assert.fail("'Call From Inside US' number verification test failed!", e);
        }
    }

    // 📌 Test to verify "Outside US" label visibility
    @Test(priority = 16, description = "Verify 'Outside US' Label is Displayed")
    public void verifyOutsideUsTextDisplayed() {
        test = extent.createTest("Verify 'Outside US' Label Visibility");
        try {
            Assert.assertTrue(contactGRpage.isOutsideUsTextDisplayed(), "❌ 'Outside US' label is NOT displayed!");
            test.pass("✅ 'Outside US' label is displayed.");
        } catch (Exception e) {
            test.fail("❌ 'Outside US' label verification failed: " + e.getMessage());
            Assert.fail("'Outside US' label verification test failed!", e);
        }
    }

    // 📌 Test to verify "Outside US" label text
    @Test(priority = 17, description = "Verify 'Outside US' Label Text")
    public void verifyOutsideUsText() {
        test = extent.createTest("Verify 'Outside US' Label Text");
        try {
            Assert.assertEquals(contactGRpage.getOutsideUsText(), "Outside US", "❌ 'Outside US' text mismatch!");
            test.pass("✅ 'Outside US' text is correct.");
        } catch (Exception e) {
            test.fail("❌ 'Outside US' text verification failed: " + e.getMessage());
            Assert.fail("'Outside US' text verification test failed!", e);
        }
    }

    // 📌 Test to verify "Call From Outside US" (First Number) visibility
    @Test(priority = 18, description = "Verify 'Call From Outside US' First Number is Displayed")
    public void verifyCallFromOutsideUs1Displayed() {
        test = extent.createTest("Verify 'Call From Outside US' First Number Visibility");
        try {
            Assert.assertTrue(contactGRpage.isCallFromOutsideUs1Displayed(), "❌ 'Call From Outside US' first number is NOT displayed!");
            test.pass("✅ 'Call From Outside US' first number is displayed.");
        } catch (Exception e) {
            test.fail("❌ 'Call From Outside US' first number verification failed: " + e.getMessage());
            Assert.fail("'Call From Outside US' first number verification test failed!", e);
        }
    }
    
    @Test(priority = 19, description = "Click on Attachment Button")
    public void clickOnAttachmentButton() {
        test = extent.createTest("Click on Attachment Button");
        try {
            contactGRpage.clickAttachmentButton();
            test.pass("✅ Successfully clicked on the Attachment Button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Attachment Button: " + e.getMessage());
            Assert.fail("Attachment button click test failed!", e);
        }
    }
    @Test(priority = 20, description = "Verify Menu is Displayed")
    public void verifyMenuDisplayed() {
        test = extent.createTest("Verify Menu is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isMenuDisplayed(), "❌ Menu is NOT displayed!");
            test.pass("✅ Menu is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Menu verification failed: " + e.getMessage());
            Assert.fail("Menu verification test failed!", e);
        }
    }

    @Test(priority = 21, description = "Verify First Icon is Displayed")
    public void verifyFirstIconDisplayed() {
        test = extent.createTest("Verify First Icon is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isFirstIconDisplayed(), "❌ First icon is NOT displayed!");
            test.pass("✅ First icon is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ First icon verification failed: " + e.getMessage());
            Assert.fail("First icon verification test failed!", e);
        }
    }

    @Test(priority = 22, description = "Verify All Icons are Displayed")
    public void verifyAllIconsDisplayed() {
        test = extent.createTest("Verify All Icons are Displayed");
        try {
            Assert.assertTrue(contactGRpage.areAllIconsDisplayed(), "❌ Icons are NOT displayed!");
            test.pass("✅ All icons are displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Icons verification failed: " + e.getMessage());
            Assert.fail("Icons verification test failed!", e);
        }
    }

    @Test(priority = 23, description = "Verify Gallery Text is Displayed")
    public void verifyGalleryTextDisplayed() {
        test = extent.createTest("Verify Gallery Text is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isGalleryTextDisplayed(), "❌ 'Gallery' text is NOT displayed!");
            test.pass("✅ 'Gallery' text is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'Gallery' text verification failed: " + e.getMessage());
            Assert.fail("'Gallery' text verification test failed!", e);
        }
    }

    @Test(priority = 24, description = "Verify Document Text is Displayed")
    public void verifyDocumentTextDisplayed() {
        test = extent.createTest("Verify Document Text is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isDocumentTextDisplayed(), "❌ 'Document' text is NOT displayed!");
            test.pass("✅ 'Document' text is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'Document' text verification failed: " + e.getMessage());
            Assert.fail("'Document' text verification test failed!", e);
        }
    }

    @Test(priority = 25, description = "Verify Camera Text is Displayed")
    public void verifyCameraTextDisplayed() {
        test = extent.createTest("Verify Camera Text is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCameraTextDisplayed(), "❌ 'Camera' text is NOT displayed!");
            test.pass("✅ 'Camera' text is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'Camera' text verification failed: " + e.getMessage());
            Assert.fail("'Camera' text verification test failed!", e);
        }
    }
    @Test(priority = 26, description = "Click on the First ImageView Icon")
    public void clickFirstImageViewIcon() {
        test = extent.createTest("Click on the First ImageView Icon");

        try {
            contactGRpage.clickFirstIcon();
            test.pass("✅ Successfully clicked on the first ImageView icon.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on the first ImageView icon: " + e.getMessage());
            Assert.fail("Clicking first ImageView icon test failed!", e);
        }
    }
    @Test(priority = 27, description = "Click on the First RelativeLayout")
    public void clickFirstRelativeLayout() {
        test = extent.createTest("Click on the First RelativeLayout");

        try {
            contactGRpage.clickFirstRelativeLayout();
            test.pass("✅ Successfully clicked on the first RelativeLayout.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on the first RelativeLayout: " + e.getMessage());
            Assert.fail("Clicking first RelativeLayout test failed!", e);
        }
    }
    @Test(priority = 28, description = "Click on FrameLayout Instance 16")
    public void clickFrameLayoutInstance16() {
        test = extent.createTest("Click on FrameLayout Instance 16");

        try {
            contactGRpage.clickFrameLayoutInstance16();
            test.pass("✅ Successfully clicked on FrameLayout instance 16.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on FrameLayout instance 16: " + e.getMessage());
            Assert.fail("Clicking FrameLayout instance 16 test failed!", e);
        }
    }
    @Test(priority = 29, description = "Verify Main Image is Visible")
    public void verifyMainImageVisibility() {
        test = extent.createTest("Verify Main Image is Visible");

        try {
            Assert.assertTrue(contactGRpage.isMainImageVisible(), "❌ Main Image is NOT visible!");
            test.pass("✅ Main Image is visible.");
        } catch (Exception e) {
            test.fail("❌ Main Image verification failed: " + e.getMessage());
            Assert.fail("Main Image visibility test failed!", e);
        }
    }
    @Test(priority = 30, description = "Verify Caption Input Field is Visible")
    public void verifyCaptionInputVisibility() {
        test = extent.createTest("Verify Caption Input Field is Visible");

        try {
            Assert.assertTrue(contactGRpage.isCaptionInputVisible(), "❌ Caption Input Field is NOT visible!");
            test.pass("✅ Caption Input Field is visible.");
        } catch (Exception e) {
            test.fail("❌ Caption Input Field verification failed: " + e.getMessage());
            Assert.fail("Caption Input Field visibility test failed!", e);
        }
    }
    @Test(priority = 31, description = "Verify Caption Placeholder Text")
    public void verifyCaptionPlaceholderText() {
        test = extent.createTest("Verify Caption Placeholder Text");

        try {
            String expectedText = "Add a caption here...";
            String actualText = contactGRpage.getCaptionPlaceholderText();
            Assert.assertEquals(actualText, expectedText, "❌ Caption placeholder text mismatch!");
            test.pass("✅ Caption placeholder text is correct: " + expectedText);
        } catch (Exception e) {
            test.fail("❌ Caption placeholder text verification failed: " + e.getMessage());
            Assert.fail("Caption placeholder text verification test failed!", e);
        }
    }
    @Test(priority = 32, description = "Verify Send Message Button is Visible")
    public void verifySendMessageButtonVisibility() {
        test = extent.createTest("Verify Send Message Button is Visible");

        try {
            Assert.assertTrue(contactGRpage.isSendMessageButtonVisible(), "❌ Send Message Button is NOT visible!");
            test.pass("✅ Send Message Button is visible.");
        } catch (Exception e) {
            test.fail("❌ Send Message Button verification failed: " + e.getMessage());
            Assert.fail("Send Message Button visibility test failed!", e);
        }
    }

    @Test(priority = 33, description = "Verify Close Button is Visible")
    public void verifyCloseButtonVisibility() {
        test = extent.createTest("Verify Close Button is Visible");

        try {
            Assert.assertTrue(contactGRpage.isCloseButtonVisible(), "❌ Close Button is NOT visible!");
            test.pass("✅ Close Button is visible.");
        } catch (Exception e) {
            test.fail("❌ Close Button verification failed: " + e.getMessage());
            Assert.fail("Close Button visibility test failed!", e);
        }
    }
    @Test(priority = 34, description = "Click on Close Button")
    public void clickCloseButton() {
        test = extent.createTest("Click on Close Button");
        try {
            contactGRpage.clickCloseButton();
            test.pass("✅ Successfully clicked on the Close button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Close Button: " + e.getMessage());
            Assert.fail("Clicking Close Button test failed!", e);
        }
    }
    @Test(priority = 35, description = "Navigate Back to Image After Closing")
    public void navigateBackToImage() {
        test = extent.createTest("Navigate Back to Image After Closing");
        try {
            contactGRpage.openImageSelection();
            test.pass("✅ Successfully navigated back to the image after closing.");
        } catch (Exception e) {
            test.fail("❌ Failed to navigate back to the image: " + e.getMessage());
            Assert.fail("Navigating back to image test failed!", e);
        }
    }
    @Test(priority = 36, description = "Send Image Message via Automation")
    public void sendImageMessage() {
        test = extent.createTest("Send Image Message via Automation");
        try {
            // Enter message text
            String message = "This image is sent by automation";
            contactGRpage.enterImageMessage(message);

            // Click send button
            contactGRpage.clickSendMessageButton();

            test.pass("✅ Successfully sent image message: " + message);
        } catch (Exception e) {
            test.fail("❌ Failed to send image message: " + e.getMessage());
            Assert.fail("Sending image message test failed!", e);
        }
    }
    @Test(priority = 37, description = "Verify Image is Displayed")
    public void verifyImageDisplayed() {
        test = extent.createTest("Verify Image is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isImageDisplayed(), "❌ Image is NOT displayed!");
            test.pass("✅ Image is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Image verification failed: " + e.getMessage());
            Assert.fail("Image display verification failed!", e);
        }
    }
    @Test(priority = 38, description = "Verify Image Caption Text")
    public void verifyImageCaptionText() {
        test = extent.createTest("Verify Image Caption Text");
        try {
            String actualText = contactGRpage.getImageCaptionText();
            Assert.assertEquals(actualText, "This image is sent by automation", "❌ Image caption text mismatch!");
            test.pass("✅ Image caption text is correct: 'This image is sent by automation'.");
        } catch (Exception e) {
            test.fail("❌ Image caption text verification failed: " + e.getMessage());
            Assert.fail("Image caption text verification failed!", e);
        }
    }
    @Test(priority = 39, description = "Click on Attachment Button")
    public void clickAttachment() {
        test = extent.createTest("Click on Attachment Button");

        try {
            contactGRpage.clickAttachmentButton();
            test.pass("✅ Successfully clicked on the Attachment button.");
        } catch (Exception e) {
            test.fail("❌ Clicking on Attachment button failed: " + e.getMessage());
            Assert.fail("Attachment button click failed!", e);
        }
    }
    @Test(priority = 40, description = "Click on Document Button")
    public void clickDocument() {
        test = extent.createTest("Click on Document Button");

        try {
            contactGRpage.clickDocumentButton();
            test.pass("✅ Successfully clicked on the Document button.");
        } catch (Exception e) {
            test.fail("❌ Clicking on Document button failed: " + e.getMessage());
            Assert.fail("Document button click failed!", e);
        }
    }
    @Test(priority = 41, description = "Select a Specific PDF File")
    public void selectSpecificPDFFile() {
        test = extent.createTest("Select a Specific PDF File");

        try {
            contactGRpage.selectSpecificPDF();
            test.pass("✅ Successfully selected the specific PDF file.");
        } catch (Exception e) {
            test.fail("❌ Selecting the specific PDF file failed: " + e.getMessage());
            Assert.fail("Specific PDF file selection failed!", e);
        }
    }

    @Test(priority = 42, description = "Verify Main Image is Visible")
    public void verifyDocumentMainImageVisibility() {
        test = extent.createTest("Verify Main Image is Visible");

        try {
            Assert.assertTrue(contactGRpage.isMainDocumentImageVisible(), "❌ Main Image is NOT visible!");
            test.pass("✅ Main Image is visible.");
        } catch (Exception e) {
            test.fail("❌ Main Image verification failed: " + e.getMessage());
            Assert.fail("Main Image visibility test failed!", e);
        }
    }
    @Test(priority = 43, description = "Verify Caption Input Field is Visible")
    public void verifyDocumentCaptionInputVisibility() {
        test = extent.createTest("Verify Caption Input Field is Visible");

        try {
            Assert.assertTrue(contactGRpage.isCaptionInputVisible(), "❌ Caption Input Field is NOT visible!");
            test.pass("✅ Caption Input Field is visible.");
        } catch (Exception e) {
            test.fail("❌ Caption Input Field verification failed: " + e.getMessage());
            Assert.fail("Caption Input Field visibility test failed!", e);
        }
    }
    @Test(priority = 44, description = "Verify Caption Placeholder Text")
    public void verifyDocumentCaptionPlaceholderText() {
        test = extent.createTest("Verify Caption Placeholder Text");

        try {
            String expectedText = "Add a caption here...";
            String actualText = contactGRpage.getCaptionPlaceholderText();
            Assert.assertEquals(actualText, expectedText, "❌ Caption placeholder text mismatch!");
            test.pass("✅ Caption placeholder text is correct: " + expectedText);
        } catch (Exception e) {
            test.fail("❌ Caption placeholder text verification failed: " + e.getMessage());
            Assert.fail("Caption placeholder text verification test failed!", e);
        }
    }
    @Test(priority = 45, description = "Verify Send Message Button is Visible")
    public void verifyDocumentSendMessageButtonVisibility() {
        test = extent.createTest("Verify Send Message Button is Visible");

        try {
            Assert.assertTrue(contactGRpage.isSendMessageButtonVisible(), "❌ Send Message Button is NOT visible!");
            test.pass("✅ Send Message Button is visible.");
        } catch (Exception e) {
            test.fail("❌ Send Message Button verification failed: " + e.getMessage());
            Assert.fail("Send Message Button visibility test failed!", e);
        }
    }

    @Test(priority = 46, description = "Verify Close Button is Visible")
    public void verifyDocumentCloseButtonVisibility() {
        test = extent.createTest("Verify Close Button is Visible");

        try {
            Assert.assertTrue(contactGRpage.isCloseButtonVisible(), "❌ Close Button is NOT visible!");
            test.pass("✅ Close Button is visible.");
        } catch (Exception e) {
            test.fail("❌ Close Button verification failed: " + e.getMessage());
            Assert.fail("Close Button visibility test failed!", e);
        }
    }
   
    @Test(priority = 47, description = "Send Image Message via Automation")
    public void sendDocumentImageMessage() {
        test = extent.createTest("Send Image Message via Automation");
        try {
            // Enter message text
            String message = "This Document is sent by automation";
            contactGRpage.enterImageMessage(message);

            // Click send button
            contactGRpage.clickSendMessageButton();

            test.pass("✅ Successfully sent image message: " + message);
        } catch (Exception e) {
            test.fail("❌ Failed to send image message: " + e.getMessage());
            Assert.fail("Sending image message test failed!", e);
        }
    }
    @Test(priority = 48, description = "Verify Image Caption Text")
    public void verifyDocumentCaptionText() {
        test = extent.createTest("Verify Image Caption Text");
        try {
            String actualText = contactGRpage.getDocumentImageCaptionText();
            Assert.assertEquals(actualText, "This Document is sent by automation", "❌ Image caption text mismatch!");
            test.pass("✅ Image caption text is correct: 'This image is sent by automation'.");
        } catch (Exception e) {
            test.fail("❌ Image caption text verification failed: " + e.getMessage());
            Assert.fail("Image caption text verification failed!", e);
        }
    }
    @Test(priority = 49, description = "Click on Attachment Button")
    public void clickAttachmentButton() {
        test = extent.createTest("Click on Attachment Button");

        try {
            contactGRpage.clickAttachmentButton();
            test.pass("✅ Successfully clicked on the Attachment button.");
        } catch (Exception e) {
            test.fail("❌ Clicking on Attachment button failed: " + e.getMessage());
            Assert.fail("Attachment button click failed!", e);
        }
    }
    @Test(priority = 50, description = "Click on the Camera Button")
    public void clickOnCameraButton() {
        test = extent.createTest("Click on the Camera Button");

        try {
            contactGRpage.clickCameraButton();
            test.pass("✅ Successfully clicked on the Camera button.");
        } catch (Exception e) {
            test.fail("❌ Clicking on the Camera button failed: " + e.getMessage());
            Assert.fail("Camera button click test failed!", e);
        }
    }
    @Test(priority = 51, description = "Verify Smart Overlay View is Displayed")
    public void verifySmartOverlayViewDisplayed() {
        test = extent.createTest("Verify Smart Overlay View is Displayed");

        try {
            Assert.assertTrue(contactGRpage.isSmartOverlayViewVisible(), "❌ Smart Overlay View is NOT displayed!");
            test.pass("✅ Smart Overlay View is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Smart Overlay View verification failed: " + e.getMessage());
            Assert.fail("Smart Overlay View test failed!", e);
        }
    }
    @Test(priority = 52, description = "Verify Close Icon is Displayed")
    public void verifyCloseIconDisplayed() {
        test = extent.createTest("Verify Close Icon is Displayed");

        try {
            Assert.assertTrue(contactGRpage.isCloseIconVisible(), "❌ Close icon is NOT displayed!");
            test.pass("✅ Close icon is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Close icon verification failed: " + e.getMessage());
            Assert.fail("Close icon test failed!", e);
        }
    }
    @Test(priority = 53, description = "Verify Switch to Front Camera Button is Displayed")
    public void verifySwitchCameraButtonDisplayed() {
        test = extent.createTest("Verify Switch to Front Camera Button is Displayed");

        try {
            Assert.assertTrue(contactGRpage.isSwitchCameraButtonVisible(), "❌ Switch to Front Camera Button is NOT displayed!");
            test.pass("✅ Switch to Front Camera Button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Switch to Front Camera Button verification failed: " + e.getMessage());
            Assert.fail("Switch to Front Camera Button test failed!", e);
        }
    }
    @Test(priority = 54, description = "Verify Shutter Button is Displayed")
    public void verifyShutterButtonDisplayed() {
        test = extent.createTest("Verify Shutter Button is Displayed");

        try {
            Assert.assertTrue(contactGRpage.isShutterButtonVisible(), "❌ Shutter Button is NOT displayed!");
            test.pass("✅ Shutter Button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Shutter Button verification failed: " + e.getMessage());
            Assert.fail("Shutter Button test failed!", e);
        }
    }
    @Test(priority = 55, description = "Click on Shutter Button")
    public void clickOnShutterButtonTwice() {
        test = extent.createTest("Click on Shutter Button");

        try {
            contactGRpage.clickShutterButton();
            contactGRpage.clickShutterButton();
            test.pass("✅ Successfully clicked on the Shutter Button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on the Shutter Button: " + e.getMessage());
            Assert.fail("Shutter Button click test failed!", e);
        }
    }
    @Test(priority = 56, description = "Verify Main Image is Visible")
    public void verifyCameraMainImageVisibility() {
        test = extent.createTest("Verify Main Image is Visible");

        try {
            Assert.assertTrue(contactGRpage.isMainCameraImageVisible(), "❌ Main Image is NOT visible!");
            test.pass("✅ Main Image is visible.");
        } catch (Exception e) {
            test.fail("❌ Main Image verification failed: " + e.getMessage());
            Assert.fail("Main Image visibility test failed!", e);
        }
    }
    @Test(priority = 57, description = "Verify Caption Input Field is Visible")
    public void verifyCameraCaptionInputVisibility() {
        test = extent.createTest("Verify Caption Input Field is Visible");

        try {
            Assert.assertTrue(contactGRpage.isCaptionInputVisible(), "❌ Caption Input Field is NOT visible!");
            test.pass("✅ Caption Input Field is visible.");
        } catch (Exception e) {
            test.fail("❌ Caption Input Field verification failed: " + e.getMessage());
            Assert.fail("Caption Input Field visibility test failed!", e);
        }
    }
    @Test(priority = 58, description = "Verify Caption Placeholder Text")
    public void verifyCameraCaptionPlaceholderText() {
        test = extent.createTest("Verify Caption Placeholder Text");

        try {
            String expectedText = "Add a caption here...";
            String actualText = contactGRpage.getCaptionPlaceholderText();
            Assert.assertEquals(actualText, expectedText, "❌ Caption placeholder text mismatch!");
            test.pass("✅ Caption placeholder text is correct: " + expectedText);
        } catch (Exception e) {
            test.fail("❌ Caption placeholder text verification failed: " + e.getMessage());
            Assert.fail("Caption placeholder text verification test failed!", e);
        }
    }
    @Test(priority = 59, description = "Verify Send Message Button is Visible")
    public void verifyCameraSendMessageButtonVisibility() {
        test = extent.createTest("Verify Send Message Button is Visible");

        try {
            Assert.assertTrue(contactGRpage.isSendMessageButtonVisible(), "❌ Send Message Button is NOT visible!");
            test.pass("✅ Send Message Button is visible.");
        } catch (Exception e) {
            test.fail("❌ Send Message Button verification failed: " + e.getMessage());
            Assert.fail("Send Message Button visibility test failed!", e);
        }
    }

    @Test(priority = 60, description = "Verify Close Button is Visible")
    public void verifyCameraCloseButtonVisibility() {
        test = extent.createTest("Verify Close Button is Visible");

        try {
            Assert.assertTrue(contactGRpage.isCloseButtonVisible(), "❌ Close Button is NOT visible!");
            test.pass("✅ Close Button is visible.");
        } catch (Exception e) {
            test.fail("❌ Close Button verification failed: " + e.getMessage());
            Assert.fail("Close Button visibility test failed!", e);
        }
    }
   
    @Test(priority = 61, description = "Send Image Message via Automation")
    public void sendCameraImageMessage() {
        test = extent.createTest("Send Image Message via Automation");
        try {
            // Enter message text
            String message = "This Document is sent by automation";
            contactGRpage.enterImageMessage(message);

            // Click send button
            contactGRpage.clickSendMessageButton();

            test.pass("✅ Successfully sent image message: " + message);
        } catch (Exception e) {
            test.fail("❌ Failed to send image message: " + e.getMessage());
            Assert.fail("Sending image message test failed!", e);
        }
    }
    @Test(priority = 62, description = "Verify Image Caption Text")
    public void verifyCameraCaptionText() {
        test = extent.createTest("Verify Image Caption Text");
        try {
            String actualText = contactGRpage.getDocumentImageCaptionText();
            Assert.assertEquals(actualText, "This Document is sent by automation", "❌ Image caption text mismatch!");
            test.pass("✅ Image caption text is correct: 'This image is sent by automation'.");
        } catch (Exception e) {
            test.fail("❌ Image caption text verification failed: " + e.getMessage());
            Assert.fail("Image caption text verification failed!", e);
        }
    }
    @Test(priority = 63, description = "Verify and Click 'Call from Inside' Button")
    public void verifyAndClickCallFromInsideButton() {
        test = extent.createTest("Verify and Click 'Call from Inside' Button");

        try {
            Assert.assertTrue(contactGRpage.isCallFromInsideButtonClickable(), "❌ 'Call from Inside' button is NOT clickable!");
            test.pass("✅ 'Call from Inside' button is clickable.");

            // Click the button
            contactGRpage.clickCallFromInsideButton();
            test.pass("✅ Successfully clicked on the 'Call from Inside' button.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify or click 'Call from Inside' button: " + e.getMessage());
            Assert.fail("'Call from Inside' button verification or click test failed!", e);
        }
    }
    @Test(priority = 64, description = "Verify Call Global Rescue Dialog is Displayed")
    public void verifyCallDialogIsDisplayed() {
        test = extent.createTest("Verify Call Global Rescue Dialog is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallDialogDisplayed(), "❌ Call Dialog is NOT displayed!");
            test.pass("✅ Call Dialog is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog verification failed: " + e.getMessage());
            Assert.fail("Call Dialog verification test failed!", e);
        }
    }

    @Test(priority = 65, description = "Verify Call Global Rescue Dialog Title is Displayed")
    public void verifyCallDialogTitleIsDisplayed() {
        test = extent.createTest("Verify Call Global Rescue Dialog Title is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallDialogTitleDisplayed(), "❌ Call Dialog Title is NOT displayed!");
            test.pass("✅ Call Dialog Title is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Title verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Title verification test failed!", e);
        }
    }

    @Test(priority = 66, description = "Verify Call Global Rescue Dialog Title Text")
    public void verifyCallDialogTitleText() {
        test = extent.createTest("Verify Call Global Rescue Dialog Title Text");
        try {
            Assert.assertEquals(contactGRpage.getCallDialogTitleText(), "Call Global Rescue", "❌ Call Dialog Title text mismatch!");
            test.pass("✅ Call Dialog Title text is correct.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Title text verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Title text verification test failed!", e);
        }
    }

    @Test(priority = 67, description = "Verify Call Global Rescue Dialog Message is Displayed")
    public void verifyCallDialogMessageIsDisplayed() {
        test = extent.createTest("Verify Call Global Rescue Dialog Message is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallDialogMessageDisplayed(), "❌ Call Dialog Message is NOT displayed!");
            test.pass("✅ Call Dialog Message is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Message verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Message verification test failed!", e);
        }
    }

    @Test(priority = 68, description = "Verify Call Global Rescue Dialog Message Text")
    public void verifyCallDialogMessageText() {
        test = extent.createTest("Verify Call Global Rescue Dialog Message Text");
        try {
            Assert.assertEquals(contactGRpage.getCallDialogMessageText(), "Standard call charges may apply according to your wireless service provider.", "❌ Call Dialog Message text mismatch!");
            test.pass("✅ Call Dialog Message text is correct.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Message text verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Message text verification test failed!", e);
        }
    }

    @Test(priority = 69, description = "Verify Cancel Button is Displayed")
    public void verifyCancelButtonIsDisplayed() {
        test = extent.createTest("Verify Cancel Button is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCancelButtonDisplayed(), "❌ Cancel button is NOT displayed!");
            test.pass("✅ Cancel button is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Cancel button verification failed: " + e.getMessage());
            Assert.fail("Cancel button verification test failed!", e);
        }
    }

    @Test(priority = 70, description = "Verify Cancel Button is Clickable")
    public void verifyCancelButtonIsClickable() {
        test = extent.createTest("Verify Cancel Button is Clickable");
        try {
            Assert.assertTrue(contactGRpage.isCancelButtonClickable(), "❌ Cancel button is NOT clickable!");
            test.pass("✅ Cancel button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Cancel button clickability verification failed: " + e.getMessage());
            Assert.fail("Cancel button clickability verification test failed!", e);
        }
    }

    @Test(priority = 71, description = "Verify Cancel Button Text")
    public void verifyCancelButtonText() {
        test = extent.createTest("Verify Cancel Button Text");
        try {
            Assert.assertEquals(contactGRpage.getCancelButtonText(), "Cancel", "❌ Cancel button text mismatch!");
            test.pass("✅ Cancel button text is correct.");
        } catch (Exception e) {
            test.fail("❌ Cancel button text verification failed: " + e.getMessage());
            Assert.fail("Cancel button text verification test failed!", e);
        }
    }

    @Test(priority = 72, description = "Verify Call Button is Displayed")
    public void verifyCallButtonIsDisplayed() {
        test = extent.createTest("Verify Call Button is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallButtonDisplayed(), "❌ Call button is NOT displayed!");
            test.pass("✅ Call button is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call button verification failed: " + e.getMessage());
            Assert.fail("Call button verification test failed!", e);
        }
    }

    @Test(priority = 73, description = "Verify Call Button is Clickable")
    public void verifyCallButtonIsClickable() {
        test = extent.createTest("Verify Call Button is Clickable");
        try {
            Assert.assertTrue(contactGRpage.isCallButtonClickable(), "❌ Call button is NOT clickable!");
            test.pass("✅ Call button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Call button clickability verification failed: " + e.getMessage());
            Assert.fail("Call button clickability verification test failed!", e);
        }
    }

    @Test(priority = 74, description = "Verify Call Button Text")
    public void verifyCallButtonText() {
        test = extent.createTest("Verify Call Button Text");
        try {
            Assert.assertEquals(contactGRpage.getCallButtonText(), "Call", "❌ Call button text mismatch!");
            test.pass("✅ Call button text is correct.");
        } catch (Exception e) {
            test.fail("❌ Call button text verification failed: " + e.getMessage());
            Assert.fail("Call button text verification test failed!", e);
        }
    }

    @Test(priority = 75, description = "Click on Cancel Button in Call Dialog")
    public void clickCancelButton() {
        test = extent.createTest("Click on Cancel Button in Call Dialog");
        try {
            contactGRpage.clickCancelButton();
            test.pass("✅ Successfully clicked on Cancel button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Cancel button: " + e.getMessage());
            Assert.fail("Cancel button click test failed!", e);
        }
    }
    @Test(priority = 76, description = "Verify and Click 'Call from Inside' Button")
    public void AgainClickCallFromInsideButton() {
        test = extent.createTest("Verify and Click 'Call from Inside' Button");

        try {
            Assert.assertTrue(contactGRpage.isCallFromInsideButtonClickable(), "❌ 'Call from Inside' button is NOT clickable!");
            test.pass("✅ 'Call from Inside' button is clickable.");

            // Click the button
            contactGRpage.clickCallFromInsideButton();
            test.pass("✅ Successfully clicked on the 'Call from Inside' button.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify or click 'Call from Inside' button: " + e.getMessage());
            Assert.fail("'Call from Inside' button verification or click test failed!", e);
        }
    }
    @Test(priority = 77, description = "Click on Call Button in Call Dialog")
    public void clickCallButton() {
        test = extent.createTest("Click on Call Button in Call Dialog");
        try {
            contactGRpage.clickCallButton();
            test.pass("✅ Successfully clicked on Call button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Call button: " + e.getMessage());
            Assert.fail("Call button click test failed!", e);
        }
    }
    @Test(priority = 78, description = "Press Android Back Button")
    public void pressAndroidBackButtonTest() {
        test = extent.createTest("Press Android Back Button");
        try {
            contactGRpage.pressAndroidBackButton();
            test.pass("✅ Successfully pressed the Android Back button.");
        } catch (Exception e) {
            test.fail("❌ Failed to press the Android Back button: " + e.getMessage());
            Assert.fail("Android Back button press test failed!", e);
        }
    }
    @Test(priority = 79, description = "Click on 'Call from Outside' Button")
    public void clickCallFromOutsideTest() {
        test = extent.createTest("Click on 'Call from Outside' Button");
        try {
            contactGRpage.clickCallFromOutside();
            test.pass("✅ Successfully clicked on 'Call from Outside' button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on 'Call from Outside' button: " + e.getMessage());
            Assert.fail("'Call from Outside' button click test failed!", e);
        }
    }
    @Test(priority = 80, description = "Verify Call Global Rescue Dialog is Displayed")
    public void CallDialogIsDisplayedForOutsideUS() {
        test = extent.createTest("Verify Call Global Rescue Dialog is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallDialogDisplayed(), "❌ Call Dialog is NOT displayed!");
            test.pass("✅ Call Dialog is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog verification failed: " + e.getMessage());
            Assert.fail("Call Dialog verification test failed!", e);
        }
    }

    @Test(priority = 81, description = "Verify Call Global Rescue Dialog Title is Displayed")
    public void verifyCallDialogTitleIsDisplayedForOutsideUS() {
        test = extent.createTest("Verify Call Global Rescue Dialog Title is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallDialogTitleDisplayed(), "❌ Call Dialog Title is NOT displayed!");
            test.pass("✅ Call Dialog Title is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Title verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Title verification test failed!", e);
        }
    }

    @Test(priority = 82, description = "Verify Call Global Rescue Dialog Title Text")
    public void verifyCallDialogTitleTextForOutsideUS() {
        test = extent.createTest("Verify Call Global Rescue Dialog Title Text");
        try {
            Assert.assertEquals(contactGRpage.getCallDialogTitleText(), "Call Global Rescue", "❌ Call Dialog Title text mismatch!");
            test.pass("✅ Call Dialog Title text is correct.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Title text verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Title text verification test failed!", e);
        }
    }

    @Test(priority = 83, description = "Verify Call Global Rescue Dialog Message is Displayed")
    public void verifyCallDialogMessageIsDisplayedForOutsideUS() {
        test = extent.createTest("Verify Call Global Rescue Dialog Message is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallDialogMessageDisplayed(), "❌ Call Dialog Message is NOT displayed!");
            test.pass("✅ Call Dialog Message is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Message verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Message verification test failed!", e);
        }
    }

    @Test(priority = 84, description = "Verify Call Global Rescue Dialog Message Text")
    public void verifyCallDialogMessageTextForOutsideUS() {
        test = extent.createTest("Verify Call Global Rescue Dialog Message Text");
        try {
            Assert.assertEquals(contactGRpage.getCallDialogMessageText(), "Standard call charges may apply according to your wireless service provider.", "❌ Call Dialog Message text mismatch!");
            test.pass("✅ Call Dialog Message text is correct.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Message text verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Message text verification test failed!", e);
        }
    }

    @Test(priority = 85, description = "Verify Cancel Button is Displayed")
    public void verifyCancelButtonIsDisplayedForOutsideUS() {
        test = extent.createTest("Verify Cancel Button is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCancelButtonDisplayed(), "❌ Cancel button is NOT displayed!");
            test.pass("✅ Cancel button is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Cancel button verification failed: " + e.getMessage());
            Assert.fail("Cancel button verification test failed!", e);
        }
    }

    @Test(priority = 86, description = "Verify Cancel Button is Clickable")
    public void verifyCancelButtonIsClickableForOutsideUS() {
        test = extent.createTest("Verify Cancel Button is Clickable");
        try {
            Assert.assertTrue(contactGRpage.isCancelButtonClickable(), "❌ Cancel button is NOT clickable!");
            test.pass("✅ Cancel button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Cancel button clickability verification failed: " + e.getMessage());
            Assert.fail("Cancel button clickability verification test failed!", e);
        }
    }

    @Test(priority = 87, description = "Verify Cancel Button Text")
    public void verifyCancelButtonTextForOutsideUS() {
        test = extent.createTest("Verify Cancel Button Text");
        try {
            Assert.assertEquals(contactGRpage.getCancelButtonText(), "Cancel", "❌ Cancel button text mismatch!");
            test.pass("✅ Cancel button text is correct.");
        } catch (Exception e) {
            test.fail("❌ Cancel button text verification failed: " + e.getMessage());
            Assert.fail("Cancel button text verification test failed!", e);
        }
    }

    @Test(priority = 88, description = "Verify Call Button is Displayed")
    public void verifyCallButtonIsDisplayedForOutsideUS() {
        test = extent.createTest("Verify Call Button is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallButtonDisplayed(), "❌ Call button is NOT displayed!");
            test.pass("✅ Call button is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call button verification failed: " + e.getMessage());
            Assert.fail("Call button verification test failed!", e);
        }
    }

    @Test(priority = 89, description = "Verify Call Button is Clickable")
    public void verifyCallButtonIsClickableForOutsideUS() {
        test = extent.createTest("Verify Call Button is Clickable");
        try {
            Assert.assertTrue(contactGRpage.isCallButtonClickable(), "❌ Call button is NOT clickable!");
            test.pass("✅ Call button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Call button clickability verification failed: " + e.getMessage());
            Assert.fail("Call button clickability verification test failed!", e);
        }
    }

    @Test(priority = 90, description = "Verify Call Button Text")
    public void verifyCallButtonTextForOutsideUS() {
        test = extent.createTest("Verify Call Button Text");
        try {
            Assert.assertEquals(contactGRpage.getCallButtonText(), "Call", "❌ Call button text mismatch!");
            test.pass("✅ Call button text is correct.");
        } catch (Exception e) {
            test.fail("❌ Call button text verification failed: " + e.getMessage());
            Assert.fail("Call button text verification test failed!", e);
        }
    }
    @Test(priority = 91, description = "Click on Call Button in Call Dialog")
    public void clickCallButtonForOutsideUS() {
        test = extent.createTest("Click on Call Button in Call Dialog");
        try {
            contactGRpage.clickCallButton();
            test.pass("✅ Successfully clicked on Call button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Call button: " + e.getMessage());
            Assert.fail("Call button click test failed!", e);
        }
    }
    @Test(priority = 92, description = "Press Android Back Button")
    public void pressAndroidBackButton() {
        test = extent.createTest("Press Android Back Button");
        try {
            contactGRpage.pressAndroidBackButton();
            test.pass("✅ Successfully pressed the Android Back button.");
        } catch (Exception e) {
            test.fail("❌ Failed to press the Android Back button: " + e.getMessage());
            Assert.fail("Android Back button press test failed!", e);
        }
    }
    @Test(priority = 93, description = "Click on 'Call From Outside 2' Button")
    public void clickCallFromOutside2Button() {
        test = extent.createTest("Click on 'Call From Outside 2' Button");

        try {
            contactGRpage.clickCallFromOutside2();
            test.pass("✅ Successfully clicked on 'Call From Outside 2' button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on 'Call From Outside 2' button: " + e.getMessage());
            Assert.fail("Clicking on 'Call From Outside 2' button test failed!", e);
        }
    }

    @Test(priority = 94, description = "Verify Call Global Rescue Dialog is Displayed")
    public void verifyCallDialogIsDisplayedForOutsideUS2() {
        test = extent.createTest("Verify Call Global Rescue Dialog is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallDialogDisplayed(), "❌ Call Dialog is NOT displayed!");
            test.pass("✅ Call Dialog is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog verification failed: " + e.getMessage());
            Assert.fail("Call Dialog verification test failed!", e);
        }
    }

    @Test(priority = 95, description = "Verify Call Global Rescue Dialog Title is Displayed")
    public void verifyCallDialogTitleIsDisplayedForOutsideUS2() {
        test = extent.createTest("Verify Call Global Rescue Dialog Title is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallDialogTitleDisplayed(), "❌ Call Dialog Title is NOT displayed!");
            test.pass("✅ Call Dialog Title is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Title verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Title verification test failed!", e);
        }
    }

    @Test(priority = 96, description = "Verify Call Global Rescue Dialog Title Text")
    public void verifyCallDialogTitleTextForOutsideUS2() {
        test = extent.createTest("Verify Call Global Rescue Dialog Title Text");
        try {
            Assert.assertEquals(contactGRpage.getCallDialogTitleText(), "Call Global Rescue", "❌ Call Dialog Title text mismatch!");
            test.pass("✅ Call Dialog Title text is correct.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Title text verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Title text verification test failed!", e);
        }
    }

    @Test(priority = 97, description = "Verify Call Global Rescue Dialog Message is Displayed")
    public void verifyCallDialogMessageIsDisplayedForOutsideUS2() {
        test = extent.createTest("Verify Call Global Rescue Dialog Message is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallDialogMessageDisplayed(), "❌ Call Dialog Message is NOT displayed!");
            test.pass("✅ Call Dialog Message is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Message verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Message verification test failed!", e);
        }
    }

    @Test(priority = 98, description = "Verify Call Global Rescue Dialog Message Text")
    public void verifyCallDialogMessageTextForOutsideUS2() {
        test = extent.createTest("Verify Call Global Rescue Dialog Message Text");
        try {
            Assert.assertEquals(contactGRpage.getCallDialogMessageText(), "Standard call charges may apply according to your wireless service provider.", "❌ Call Dialog Message text mismatch!");
            test.pass("✅ Call Dialog Message text is correct.");
        } catch (Exception e) {
            test.fail("❌ Call Dialog Message text verification failed: " + e.getMessage());
            Assert.fail("Call Dialog Message text verification test failed!", e);
        }
    }

    @Test(priority = 99, description = "Verify Cancel Button is Displayed")
    public void verifyCancelButtonIsDisplayedForOutsideUS2() {
        test = extent.createTest("Verify Cancel Button is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCancelButtonDisplayed(), "❌ Cancel button is NOT displayed!");
            test.pass("✅ Cancel button is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Cancel button verification failed: " + e.getMessage());
            Assert.fail("Cancel button verification test failed!", e);
        }
    }

    @Test(priority = 100, description = "Verify Cancel Button is Clickable")
    public void verifyCancelButtonIsClickableForOutsideUS2() {
        test = extent.createTest("Verify Cancel Button is Clickable");
        try {
            Assert.assertTrue(contactGRpage.isCancelButtonClickable(), "❌ Cancel button is NOT clickable!");
            test.pass("✅ Cancel button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Cancel button clickability verification failed: " + e.getMessage());
            Assert.fail("Cancel button clickability verification test failed!", e);
        }
    }

    @Test(priority = 101, description = "Verify Cancel Button Text")
    public void verifyCancelButtonTextForOutsideUS2() {
        test = extent.createTest("Verify Cancel Button Text");
        try {
            Assert.assertEquals(contactGRpage.getCancelButtonText(), "Cancel", "❌ Cancel button text mismatch!");
            test.pass("✅ Cancel button text is correct.");
        } catch (Exception e) {
            test.fail("❌ Cancel button text verification failed: " + e.getMessage());
            Assert.fail("Cancel button text verification test failed!", e);
        }
    }

    @Test(priority = 102, description = "Verify Call Button is Displayed")
    public void verifyCallButtonIsDisplayedForOutsideUS2() {
        test = extent.createTest("Verify Call Button is Displayed");
        try {
            Assert.assertTrue(contactGRpage.isCallButtonDisplayed(), "❌ Call button is NOT displayed!");
            test.pass("✅ Call button is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Call button verification failed: " + e.getMessage());
            Assert.fail("Call button verification test failed!", e);
        }
    }

    @Test(priority = 103, description = "Verify Call Button is Clickable")
    public void verifyCallButtonIsClickableForOutsideUS2() {
        test = extent.createTest("Verify Call Button is Clickable");
        try {
            Assert.assertTrue(contactGRpage.isCallButtonClickable(), "❌ Call button is NOT clickable!");
            test.pass("✅ Call button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Call button clickability verification failed: " + e.getMessage());
            Assert.fail("Call button clickability verification test failed!", e);
        }
    }

    @Test(priority = 104, description = "Verify Call Button Text")
    public void verifyCallButtonTextForOutsideUS2() {
        test = extent.createTest("Verify Call Button Text");
        try {
            Assert.assertEquals(contactGRpage.getCallButtonText(), "Call", "❌ Call button text mismatch!");
            test.pass("✅ Call button text is correct.");
        } catch (Exception e) {
            test.fail("❌ Call button text verification failed: " + e.getMessage());
            Assert.fail("Call button text verification test failed!", e);
        }
    }
    @Test(priority = 105, description = "Click on Call Button in Call Dialog")
    public void clickCallButtonForOutsideUS2() {
        test = extent.createTest("Click on Call Button in Call Dialog");
        try {
            contactGRpage.clickCallButton();
            test.pass("✅ Successfully clicked on Call button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Call button: " + e.getMessage());
            Assert.fail("Call button click test failed!", e);
        }
    }
    @Test(priority = 106, description = "Press Android Back Button")
    public void pressAndroidBackButton2() {
        test = extent.createTest("Press Android Back Button");
        try {
            contactGRpage.pressAndroidBackButton();
            test.pass("✅ Successfully pressed the Android Back button.");
        } catch (Exception e) {
            test.fail("❌ Failed to press the Android Back button: " + e.getMessage());
            Assert.fail("Android Back button press test failed!", e);
        }
    }
    @Test(priority = 107, description = "Enter Text in Message Field")
    public void enterTextInMessageField() {
        test = extent.createTest("Enter Text in Message Field");

        try {
            String message = "This text is sent by automation script";
            contactGRpage.enterMessageText(message);
            test.pass("✅ Successfully entered message: " + message);
        } catch (Exception e) {
            test.fail("❌ Failed to enter message: " + e.getMessage());
            Assert.fail("Message input test failed!", e);
        }
    }

    @Test(priority = 108, description = "Click Send Message Button")
    public void clickSendMessage() {
        test = extent.createTest("Click Send Message Button");

        try {
            contactGRpage.clickSendMessageButton();
            test.pass("✅ Successfully clicked on Send Message button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Send Message button: " + e.getMessage());
            Assert.fail("Send Message button test failed!", e);
        }
    }

    @Test(priority = 109, description = "Verify Sent Message is Displayed")
    public void verifySentMessage() {
        test = extent.createTest("Verify Sent Message is Displayed");

        try {
        	Thread.sleep(2000);
            String expectedMessage = "This text is sent by automation script";
            Assert.assertTrue(contactGRpage.isSentMessageDisplayed(expectedMessage), "❌ Sent message text mismatch!");
            test.pass("✅ Sent message is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Sent message verification failed: " + e.getMessage());
            Assert.fail("Sent message verification test failed!", e);
        }
    }
    @Test(priority = 109, description = "Verify Sent Message is Displayed")
    public void OpsPortalForContactGRVerify() {
        test = extent.createTest("Ops Portal For ContactGR Verify");

        try {
        	
        	DestinationReportPage destinationReportPage = new DestinationReportPage(driver, wait);
        	destinationReportPage.clickBackButton();
        	WebPortal webPortal = new WebPortal();
        	webPortal.OpsPortalForContactGRVerify();
            test.pass("✅ Contact GR verifeid successfully");
        } catch (Exception e) {
            test.fail("❌ Sent message verification failed: " + e.getMessage());
            Assert.fail("Sent message verification test failed!", e);
        }
    }

}
