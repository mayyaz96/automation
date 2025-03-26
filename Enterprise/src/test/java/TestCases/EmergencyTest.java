package TestCases;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import base.BaseSetup;
import io.appium.java_client.android.AndroidDriver;
import pages.ContactGRpage;
import pages.EmergencyPage;
import utilities.ExtentReportsManager;

public class EmergencyTest extends BaseSetup {
    
    private ContactGRpage contactGRpage;
    private ExtentReports extent;
    private AndroidDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;
    private EmergencyPage emergencyPage;

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
        emergencyPage = new EmergencyPage(driver, wait);
    }
 //   @Test(priority = 1, dependsOnMethods = "TestCases.Configuration.SignIntoApp")
    @Test(priority = 1, description = "Press and Hold Emergency Button for 3.5 Seconds")
    public void testPressAndHoldEmergencyButton() {
        test = extent.createTest("Verify Press and Hold on Emergency Button");

        try {
            emergencyPage.pressAndHoldEmergencyButton();
            test.pass("✅ Successfully pressed and held the emergency button for 3.5 seconds.");
        } catch (Exception e) {
            test.fail("❌ Press and hold action failed: " + e.getMessage());
            Assert.fail("Press and hold emergency button test failed!", e);
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
            Assert.assertEquals(contactGRpage.getPageTitleText(), "Emergency", "❌ Page title text mismatch!");
            test.pass("✅ Page title text is correct: 'Contact Global Rescue'.");
        } catch (Exception e) {
            test.fail("❌ Page title text verification failed: " + e.getMessage());
            Assert.fail("Page title text verification test failed!", e);
        }
    }

    @Test(priority = 6, description = "Verify Emergency Notification Message is Displayed")
    public void verifyNotificationMessageDisplayed() {
        test = extent.createTest("Verify Emergency Notification Message Display");

        try {
            Assert.assertTrue(emergencyPage.isNotificationMessageDisplayed(), "❌ Notification message is NOT displayed!");
            test.pass("✅ Notification message is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Notification message verification failed: " + e.getMessage());
            Assert.fail("Notification message test failed!", e);
        }
    }
    @Test(priority = 7, description = "Verify Emergency Notification Message Text")
    public void verifyNotificationMessageText() {
        test = extent.createTest("Verify Emergency Notification Message Text");

        try {
            String expectedMessage = "Global Rescue's operations team will contact you shortly. This emergency notification was also sent to your organization emergency recipients.";
            Assert.assertEquals(emergencyPage.getNotificationMessageText(), expectedMessage, "❌ Notification message text mismatch!");
            test.pass("✅ Notification message text is correct.");
        } catch (Exception e) {
            test.fail("❌ Notification message text verification failed: " + e.getMessage());
            Assert.fail("Notification message text test failed!", e);
        }
    }
    @Test(priority = 8, description = "Verify Cancel Notification Button is Displayed")
    public void verifyCancelNotificationButtonDisplayed() {
        test = extent.createTest("Verify Cancel Notification Button Display");

        try {
            Assert.assertTrue(emergencyPage.isCancelNotificationButtonDisplayed(), "❌ Cancel Notification button is NOT displayed!");
            test.pass("✅ Cancel Notification button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Cancel Notification button verification failed: " + e.getMessage());
            Assert.fail("Cancel Notification button test failed!", e);
        }
    }

    
    @Test(priority = 9, description = "Verify Nature of Emergency Label is Displayed")
    public void verifyNatureOfEmergencyLabelDisplayed() {
        test = extent.createTest("Verify Nature of Emergency Label Display");

        try {
            Assert.assertTrue(emergencyPage.isNatureOfEmergencyLabelDisplayed(), "❌ 'Nature of Emergency' label is NOT displayed!");
            test.pass("✅ 'Nature of Emergency' label is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'Nature of Emergency' label verification failed: " + e.getMessage());
            Assert.fail("'Nature of Emergency' label test failed!", e);
        }
    }
    @Test(priority = 10, description = "Verify Nature of Emergency Label Text")
    public void verifyNatureOfEmergencyLabelText() {
        test = extent.createTest("Verify Nature of Emergency Label Text");

        try {
            Assert.assertEquals(emergencyPage.getNatureOfEmergencyLabelText(), "Nature of Emergency", "❌ 'Nature of Emergency' label text mismatch!");
            test.pass("✅ 'Nature of Emergency' label text is correct.");
        } catch (Exception e) {
            test.fail("❌ 'Nature of Emergency' label text verification failed: " + e.getMessage());
            Assert.fail("'Nature of Emergency' label text test failed!", e);
        }
    }
    @Test(priority = 11, description = "Verify Emergency Input Field is Displayed")
    public void verifyEmergencyInputFieldDisplayed() {
        test = extent.createTest("Verify Emergency Input Field Display");

        try {
            Assert.assertTrue(emergencyPage.isEmergencyInputFieldDisplayed(), "❌ Emergency input field is NOT displayed!");
            test.pass("✅ Emergency input field is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Emergency input field verification failed: " + e.getMessage());
            Assert.fail("Emergency input field test failed!", e);
        }
    }
    @Test(priority = 12, description = "Verify Emergency Input Field is Writable")
    public void verifyEmergencyInputFieldWritable() {
        test = extent.createTest("Verify Emergency Input Field Writeability");

        try {
            Assert.assertTrue(emergencyPage.isEmergencyInputFieldWritable(), "❌ Emergency input field is NOT writable!");
            test.pass("✅ Emergency input field is writable.");
        } catch (Exception e) {
            test.fail("❌ Emergency input field writeability verification failed: " + e.getMessage());
            Assert.fail("Emergency input field writeability test failed!", e);
        }
    }

    @Test(priority = 13, description = "Verify Emergency Input Field Placeholder")
    public void verifyEmergencyInputFieldPlaceholder() {
        test = extent.createTest("Verify Emergency Input Field Placeholder");

        try {
            String expectedPlaceholder = "Please state the nature of your emergency. If this is a life threatening emergency, please contact local emergency services immediately and then notify us.";
            Assert.assertEquals(emergencyPage.getEmergencyInputFieldPlaceholder(), expectedPlaceholder, "❌ Emergency input field placeholder text mismatch!");
            test.pass("✅ Emergency input field placeholder is correct.");
        } catch (Exception e) {
            test.fail("❌ Emergency input field placeholder verification failed: " + e.getMessage());
            Assert.fail("Emergency input field placeholder test failed!", e);
        }
    }
    @Test(priority = 14, description = "Verify Text Count Label")
    public void verifyTextCountLabel() {
        test = extent.createTest("Verify Text Count Label");

        try {
            Assert.assertTrue(emergencyPage.isTextCountLabelDisplayed(), "❌ Text Count Label is NOT displayed!");
            Assert.assertEquals(emergencyPage.getTextCountLabelText(), "0/400", "❌ Text Count Label text mismatch!");
            test.pass("✅ Text Count Label is displayed and text is correct.");
        } catch (Exception e) {
            test.fail("❌ Text Count Label verification failed: " + e.getMessage());
            Assert.fail("Text Count Label test failed!", e);
        }
    }
    @Test(priority = 15, description = "Verify Cancel Emergency Button is Displayed")
    public void verifyCancelEmergencyButtonDisplayed() {
        test = extent.createTest("Verify Cancel Emergency Button Display");

        try {
            Assert.assertTrue(emergencyPage.isCancelEmergencyButtonDisplayed(), "❌ Cancel Emergency button is NOT displayed!");
            test.pass("✅ Cancel Emergency button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Cancel Emergency button verification failed: " + e.getMessage());
            Assert.fail("Cancel Emergency button test failed!", e);
        }
    }

    @Test(priority = 16, description = "Verify Cancel Emergency Button is Clickable")
    public void verifyCancelEmergencyButtonClickable() {
        test = extent.createTest("Verify Cancel Emergency Button Clickable");

        try {
            Assert.assertTrue(emergencyPage.isCancelEmergencyButtonClickable(), "❌ Cancel Emergency button is NOT clickable!");
            test.pass("✅ Cancel Emergency button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Cancel Emergency button clickability verification failed: " + e.getMessage());
            Assert.fail("Cancel Emergency button clickability test failed!", e);
        }
    }
    @Test(priority = 17, description = "Verify Cancel Emergency Button Text")
    public void verifyCancelEmergencyButtonText() {
        test = extent.createTest("Verify Cancel Emergency Button Text");

        try {
            Assert.assertEquals(emergencyPage.getCancelEmergencyButtonText(), "Cancel Emergency", "❌ Cancel Emergency button text mismatch!");
            test.pass("✅ Cancel Emergency button text is correct.");
        } catch (Exception e) {
            test.fail("❌ Cancel Emergency button text verification failed: " + e.getMessage());
            Assert.fail("Cancel Emergency button text test failed!", e);
        }
    }
    @Test(priority = 18, description = "Verify Send Notification Button Text")
    public void verifySendNotificationButtonText() {
        test = extent.createTest("Verify Send Notification Button Text");

        try {
            Assert.assertEquals(emergencyPage.getSendNotificationButtonText(), "Send", "❌ Send Notification button text mismatch!");
            test.pass("✅ Send Notification button text is correct.");
        } catch (Exception e) {
            test.fail("❌ Send Notification button text verification failed: " + e.getMessage());
            Assert.fail("Send Notification button text test failed!", e);
        }
    }
    @Test(priority = 19, description = "Verify Auto Location Share Text")
    public void verifyAutoLocationShareText() {
        test = extent.createTest("Verify Auto Location Share Text");

        try {
            String expectedText = "Your location will be automatically shared with Global Rescue's operations team every 10 minutes for the first 1 hour, and then every 30 minutes for the next 6 hours.";
            Assert.assertEquals(emergencyPage.getAutoLocationShareText(), expectedText, "❌ Auto location share text mismatch!");
            test.pass("✅ Auto location share text is correct.");
        } catch (Exception e) {
            test.fail("❌ Auto location share text verification failed: " + e.getMessage());
            Assert.fail("Auto location share text test failed!", e);
        }
    }

    @Test(priority = 20, description = "Verify Emergency Recipients Message is Displayed")
    public void verifyEmergencyRecipientsMessageDisplayed() {
        test = extent.createTest("Verify Emergency Recipients Message Display");

        try {
            Assert.assertTrue(emergencyPage.isEmergencyRecipientsMessageDisplayed(), "❌ Emergency Recipients Message is NOT displayed!");
            test.pass("✅ Emergency Recipients Message is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Emergency Recipients Message verification failed: " + e.getMessage());
            Assert.fail("Emergency Recipients Message test failed!", e);
        }
    }

    @Test(priority = 21, description = "Verify See List of Recipients Button is Displayed")
    public void verifySeeListOfRecipientsButtonDisplayed() {
        test = extent.createTest("Verify See List of Recipients Button Display");

        try {
            Assert.assertTrue(emergencyPage.isSeeListOfRecipientsButtonDisplayed(), "❌ 'See List of Recipients' button is NOT displayed!");
            test.pass("✅ 'See List of Recipients' button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'See List of Recipients' button verification failed: " + e.getMessage());
            Assert.fail("'See List of Recipients' button test failed!", e);
        }
    }
    @Test(priority = 22, description = "Verify Clicking on See List of Recipients Button")
    public void verifyClickSeeListOfRecipientsButton() {
        test = extent.createTest("Verify Click on 'See List of Recipients' Button");

        try {
            emergencyPage.clickSeeListOfRecipientsButton();
            test.pass("✅ Successfully clicked on 'See List of Recipients' button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on 'See List of Recipients' button: " + e.getMessage());
            Assert.fail("'See List of Recipients' button click test failed!", e);
        }
    }

    @Test(priority = 23, description = "Verify Back Button is Displayed")
    public void verifyBackButtonDisplayedOnEmergencyRecipients() {
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
    @Test(priority = 24, description = "Verify Back Button Text")
    public void verifyBackButtonTextOnEmergencyRecipients() {
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
    
    @Test(priority = 26, description = "Verify Emergency Recipients Title is Displayed")
    public void verifyEmergencyRecipientsTitleDisplayed() {
        test = extent.createTest("Verify Emergency Recipients Title is Displayed");

        try {
            Assert.assertTrue(emergencyPage.isEmergencyRecipientsTitleDisplayed(), "❌ Emergency Recipients Title is NOT displayed!");
            test.pass("✅ Emergency Recipients Title is visible.");
        } catch (Exception e) {
            test.fail("❌ Emergency Recipients Title display verification failed: " + e.getMessage());
            Assert.fail("Emergency Recipients Title display test failed!", e);
        }
    }

    @Test(priority = 27, description = "Verify Emergency Recipients Title Text")
    public void verifyEmergencyRecipientsTitleText() {
        test = extent.createTest("Verify Emergency Recipients Title Text");

        try {
            String actualText = emergencyPage.getEmergencyRecipientsTitleText();
            Assert.assertEquals(actualText, "Emergency Recipients", "❌ Emergency Recipients Title text mismatch!");
            test.pass("✅ Emergency Recipients Title text is correct.");
        } catch (Exception e) {
            test.fail("❌ Emergency Recipients Title text verification failed: " + e.getMessage());
            Assert.fail("Emergency Recipients Title text test failed!", e);
        }
    }


    @Test(priority = 28, description = "Verify Emergency Notification Text Content")
    public void verifyEmergencyNotificationTextContent() {
        test = extent.createTest("Verify Emergency Notification Text Content");

        try {
            String expectedText = "List of people who will be notified when you press the emergency button.";
            Assert.assertEquals(emergencyPage.getEmergencyNotificationText(), expectedText, "❌ Emergency notification text mismatch!");
            test.pass("✅ Emergency notification text is correct.");
        } catch (Exception e) {
            test.fail("❌ Emergency notification text content verification failed: " + e.getMessage());
            Assert.fail("Emergency notification text content test failed!", e);
        }
    }
    @Test(priority = 29, description = "Verify Emergency List View is Displayed")
    public void verifyEmergencyListViewDisplayed() {
        test = extent.createTest("Verify Emergency List View Display");

        try {
            Assert.assertTrue(emergencyPage.isEmergencyListViewDisplayed(), "❌ Emergency list view is NOT displayed!");
            test.pass("✅ Emergency list view is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Emergency list view verification failed: " + e.getMessage());
            Assert.fail("Emergency list view test failed!", e);
        }
    }
    @Test(priority = 30, description = "Verify Contact Profile Image is Displayed")
    public void verifyContactProfileImageDisplayed() {
        test = extent.createTest("Verify Contact Profile Image Display");

        try {
            Assert.assertTrue(emergencyPage.isContactProfileImageDisplayed(), "❌ Contact profile image is NOT displayed!");
            test.pass("✅ Contact profile image is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Contact profile image verification failed: " + e.getMessage());
            Assert.fail("Contact profile image test failed!", e);
        }
    }
    @Test(priority = 31, description = "Verify Contact Name Initials are Displayed")
    public void verifyContactNameInitialsDisplayed() {
        test = extent.createTest("Verify Contact Name Initials Display");

        try {
            Assert.assertTrue(emergencyPage.isContactNameInitialsDisplayed(), "❌ Contact name initials are NOT displayed!");
            test.pass("✅ Contact name initials are displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Contact name initials verification failed: " + e.getMessage());
            Assert.fail("Contact name initials test failed!", e);
        }
    }
    @Test(priority = 32, description = "Verify Contact Name Text")
    public void verifyContactNameText() {
        test = extent.createTest("Verify Contact Name Text");

        try {
            String expectedText = "Global Rescue Operations";
            Assert.assertEquals(emergencyPage.getContactNameText(), expectedText, "❌ Contact name text mismatch!");
            test.pass("✅ Contact name text is correct.");
        } catch (Exception e) {
            test.fail("❌ Contact name text verification failed: " + e.getMessage());
            Assert.fail("Contact name text test failed!", e);
        }
    }
    @Test(priority = 33, description = "Verify Contact Email Text")
    public void verifyContactEmailText() {
        test = extent.createTest("Verify Contact Email Text");

        try {
            String expectedText = "grid2.nonprod@gridsystems.pk";
            Assert.assertEquals(emergencyPage.getContactEmailText(), expectedText, "❌ Contact email text mismatch!");
            test.pass("✅ Contact email text is correct.");
        } catch (Exception e) {
            test.fail("❌ Contact email text verification failed: " + e.getMessage());
            Assert.fail("Contact email text test failed!", e);
        }
    }
    @Test(priority = 34, description = "Verify Contact Phone Number")
    public void verifyContactPhoneNumber() {
        test = extent.createTest("Verify Contact Phone Number");

        try {
            String expectedText = "+1 (617) 459-4200";
            Assert.assertEquals(emergencyPage.getContactPhoneNumberText(), expectedText, "❌ Contact phone number mismatch!");
            test.pass("✅ Contact phone number is correct.");
        } catch (Exception e) {
            test.fail("❌ Contact phone number verification failed: " + e.getMessage());
            Assert.fail("Contact phone number test failed!", e);
        }
    }
    @Test(priority = 35, description = "Click on Back Button")
    public void clickBackButton() {
        test = extent.createTest("Click on Back Button");

        try {
            contactGRpage.clickBackButton();
            test.pass("✅ Successfully clicked on the Back Button.");
        } catch (Exception e) {
            test.fail("❌ Back Button click failed: " + e.getMessage());
            Assert.fail("Back Button test failed!", e);
        }
    }

    @Test(priority = 36, description = "Enter Emergency Text in Grid Comments")
    public void enterEmergencyText() {
        test = extent.createTest("Enter Emergency Text in Grid Comments");
        String expectedText = "This emergency is initiated by automation";
        
        try {
            // Enter the text in Grid Comments
            emergencyPage.enterEmergencyText(expectedText);
            
            test.pass("✅ Emergency text successfully entered.");
        } catch (Exception e) {
            test.fail("❌ Failed to enter emergency text: " + e.getMessage());
            Assert.fail("Emergency text entry test failed!", e);
        }
    }
    @Test(priority = 37, description = "Verify Entered Emergency Text in Grid Comments")
    public void verifyEmergencyText() {
        test = extent.createTest("Verify Entered Emergency Text in Grid Comments");
        String expectedText = "This emergency is initiated by automation";
       
        try {
            // Verify the entered text
            String actualText = emergencyPage.getEnteredEmergencyText();
            Assert.assertEquals(actualText, expectedText, "❌ Entered text does not match!");

            test.pass("✅ Emergency text successfully verified.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify emergency text: " + e.getMessage());
            Assert.fail("Emergency text verification test failed!", e);
        }
    }


    @Test(priority = 38, description = "Click on Send Button")
    public void clickSendButton() {
        test = extent.createTest("Click on Send Button");

        try {
            emergencyPage.clickSendButton();
           
            test.pass("✅ Successfully clicked on the Send button.");
        } catch (Exception e) {
            test.fail("❌ Send Button click failed: " + e.getMessage());
            Assert.fail("Send Button test failed!", e);
        }
    }


    /** ✅ **Test: Verify Sync Chat Button** */
    @Test(priority = 39, description = "Verify Sync Chat Button is Displayed")
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

  

    /** ✅ **Test: Verify Message Input Placeholder** */
    @Test(priority = 40, description = "Verify Message Input Placeholder")
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
    @Test(priority = 41, description = "Verify Send Message Button is Displayed")
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
   
    @Test(priority = 42, description = "Click on Attachment Button")
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
    @Test(priority = 43, description = "Verify Menu is Displayed")
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

    @Test(priority = 44, description = "Verify First Icon is Displayed")
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

    @Test(priority = 45, description = "Verify All Icons are Displayed")
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

    @Test(priority = 46, description = "Verify Gallery Text is Displayed")
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

    @Test(priority = 47, description = "Verify Document Text is Displayed")
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

    @Test(priority = 48, description = "Verify Camera Text is Displayed")
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
    @Test(priority = 49, description = "Click on the First ImageView Icon")
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
    @Test(priority = 50, description = "Click on the First RelativeLayout")
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
    @Test(priority = 51, description = "Click on FrameLayout Instance 16")
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
    @Test(priority = 52, description = "Verify Main Image is Visible")
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
    @Test(priority = 53, description = "Verify Caption Input Field is Visible")
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
    @Test(priority = 54, description = "Verify Caption Placeholder Text")
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
    @Test(priority = 55, description = "Verify Send Message Button is Visible")
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

    @Test(priority = 56, description = "Verify Close Button is Visible")
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
    @Test(priority = 57, description = "Click on Close Button")
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
    @Test(priority = 58, description = "Navigate Back to Image After Closing")
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
    @Test(priority = 59, description = "Send Image Message via Automation")
    public void sendImageMessage() {
        test = extent.createTest("Send Image Message via Automation");
        try {
            // Enter message text
            String message = "This image is sent by automation";
            contactGRpage.enterImageMessage(message);

            // Click send button
            contactGRpage.clickSendMessageButton();
           // WebPortal.imageAndTextVerification();
            test.pass("✅ Successfully sent image message: " + message);
        } catch (Exception e) {
            test.fail("❌ Failed to send image message: " + e.getMessage());
            Assert.fail("Sending image message test failed!", e);
        }
    }
   

    @Test(priority = 60, description = "Verify Image is Displayed")
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
    @Test(priority = 61, description = "Verify Image Caption Text")
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
    @Test(priority = 62, description = "Click on Attachment Button")
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
    @Test(priority = 63, description = "Click on Document Button")
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
    @Test(priority = 64, description = "Select a Specific PDF File")
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

    @Test(priority = 65, description = "Verify Main Image is Visible")
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
    @Test(priority = 66, description = "Verify Caption Input Field is Visible")
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
    @Test(priority = 67, description = "Verify Caption Placeholder Text")
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
    @Test(priority = 68, description = "Verify Send Message Button is Visible")
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

    @Test(priority = 69, description = "Verify Close Button is Visible")
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
   
    @Test(priority = 70, description = "Send Image Message via Automation")
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
    @Test(priority = 71, description = "Verify Image Caption Text")
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
    @Test(priority = 72, description = "Click on Attachment Button")
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
    @Test(priority = 73, description = "Click on the Camera Button")
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
    @Test(priority = 74, description = "Verify Smart Overlay View is Displayed")
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
    @Test(priority = 75, description = "Verify Close Icon is Displayed")
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
    @Test(priority = 76, description = "Verify Switch to Front Camera Button is Displayed")
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
    @Test(priority = 77, description = "Verify Shutter Button is Displayed")
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
    @Test(priority = 78, description = "Click on Shutter Button")
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
    @Test(priority = 79, description = "Verify Main Image is Visible")
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
    @Test(priority = 80, description = "Verify Caption Input Field is Visible")
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
    @Test(priority = 81, description = "Verify Caption Placeholder Text")
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
    @Test(priority = 82, description = "Verify Send Message Button is Visible")
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

    @Test(priority = 83, description = "Verify Close Button is Visible")
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
   
   
   
         
    @Test(priority = 85, description = "Enter Text in Message Field")
    public void enterTextInMessageField() {
       // test = extent.createTest("Enter Text in Message Field");

        try {
            String message = "This Camera Picture is sent by automation script";
            contactGRpage.enterMessageText(message);
          //  test.pass("✅ Successfully entered message: " + message);
        } catch (Exception e) {
          //  test.fail("❌ Failed to enter message: " + e.getMessage());
            Assert.fail("Message input test failed!", e);
        }
    }
    @Test(priority = 86, description = "Verify Image Caption Text")
    public void verifyCameraCaptionText() {
        test = extent.createTest("Verify Image Caption Text");
        try {
            String actualText = contactGRpage.getCameraImageCaptionText();
            Assert.assertEquals(actualText, "This Camera Picture is sent by automation script", "❌ Image caption text mismatch!");
            test.pass("✅ Image caption text is correct: 'This image is sent by automation'.");
        } catch (Exception e) {
            test.fail("❌ Image caption text verification failed: " + e.getMessage());
            Assert.fail("Image caption text verification failed!", e);
        }
    }
    @Test(priority = 87, description = "Click Send Message Button")
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

    
    

   

    @Test(priority = 90, description = "Verify Active Emergency Title is displayed")
    public void verifyActiveEmergencyTitle() {
        test = extent.createTest("Verify Active Emergency Title");

        try {
            Assert.assertTrue(emergencyPage.isTitleDisplayed(), "❌ Active Emergency title is NOT displayed!");
            test.pass("✅ Active Emergency title is displayed.");
        } catch (Exception e) {
            test.fail("❌ Active Emergency title verification failed: " + e.getMessage());
            Assert.fail("Active Emergency title verification test failed!", e);
        }
    }

    @Test(priority = 91, description = "Verify Sync Chat Button is displayed")
    public void verifySyncChatButtonDisplayedOnActiveEmergency() {
        test = extent.createTest("Verify Sync Chat Button Display");
        try {
            Assert.assertTrue(emergencyPage.isSyncChatButtonDisplayed(), "❌ Sync Chat button is NOT displayed!");
            test.pass("✅ Sync Chat button is displayed.");
        } catch (Exception e) {
            test.fail("❌ Sync Chat button display verification failed: " + e.getMessage());
            Assert.fail("Sync Chat button display verification test failed!", e);
        }
    }

    @Test(priority = 92, description = "Verify Sync Chat Button is clickable")
    public void verifySyncChatButtonClickable() {
        test = extent.createTest("Verify Sync Chat Button Clickability");
        try {
            Assert.assertTrue(emergencyPage.isSyncChatButtonClickable(), "❌ Sync Chat button is NOT clickable!");
            test.pass("✅ Sync Chat button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Sync Chat button clickability verification failed: " + e.getMessage());
            Assert.fail("Sync Chat button clickability verification test failed!", e);
        }
    }

    @Test(priority = 93, description = "Verify More Options Button is displayed")
    public void verifyMoreOptionsButtonDisplayed() {
        test = extent.createTest("Verify More Options Button Display");
        try {
            Assert.assertTrue(emergencyPage.isMoreOptionsButtonDisplayed(), "❌ More Options button is NOT displayed!");
            test.pass("✅ More Options button is displayed.");
        } catch (Exception e) {
            test.fail("❌ More Options button display verification failed: " + e.getMessage());
            Assert.fail("More Options button display verification test failed!", e);
        }
    }

    @Test(priority = 94, description = "Verify More Options Button is clickable")
    public void verifyMoreOptionsButtonClickable() {
        test = extent.createTest("Verify More Options Button Clickability");
        try {
            Assert.assertTrue(emergencyPage.isMoreOptionsButtonClickable(), "❌ More Options button is NOT clickable!");
            test.pass("✅ More Options button is clickable.");
        } catch (Exception e) {
            test.fail("❌ More Options button clickability verification failed: " + e.getMessage());
            Assert.fail("More Options button clickability verification test failed!", e);
        }
    }

    @Test(priority = 95, description = "Verify Cancel Emergency Button is displayed")
    public void verifyCancelEmergencyButtonDisplayedOnActiveEmergency() {
        test = extent.createTest("Verify Cancel Emergency Button Display");
        try {
            Assert.assertTrue(emergencyPage.isCancelEmergencyButtonDisplayed(), "❌ Cancel Emergency button is NOT displayed!");
            test.pass("✅ Cancel Emergency button is displayed.");
        } catch (Exception e) {
            test.fail("❌ Cancel Emergency button display verification failed: " + e.getMessage());
            Assert.fail("Cancel Emergency button display verification test failed!", e);
        }
    }

    @Test(priority = 96, description = "Verify Cancel Emergency Button is clickable")
    public void verifyCancelEmergencyButtonClickableOnActiveEmergency() {
        test = extent.createTest("Verify Cancel Emergency Button Clickability");
        try {
            Assert.assertTrue(emergencyPage.isCancelEmergencyButtonClickable(), "❌ Cancel Emergency button is NOT clickable!");
            test.pass("✅ Cancel Emergency button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Cancel Emergency button clickability verification failed: " + e.getMessage());
            Assert.fail("Cancel Emergency button clickability verification test failed!", e);
        }
    }

    @Test(priority = 97, description = "Verify Cancel Emergency Button text")
    public void verifyCancelEmergencyButtonTextOnActiveEmergency() {
        test = extent.createTest("Verify Cancel Emergency Button Text");
        try {
            Assert.assertEquals(emergencyPage.getCancelEmergencyButtonText(), "Cancel Emergency", "❌ Cancel Emergency button text mismatch!");
            test.pass("✅ Cancel Emergency button text is correct.");
        } catch (Exception e) {
            test.fail("❌ Cancel Emergency button text verification failed: " + e.getMessage());
            Assert.fail("Cancel Emergency button text verification test failed!", e);
        }
    }
    @Test(priority = 98, description = "Verify 'Cancel Emergency' Button is Displayed")
    public void verifyCancelEmergencyDisplayed() {
        test = extent.createTest("Verify 'Cancel Emergency' Button is Displayed");
        try {
            Assert.assertTrue(emergencyPage.isCancelEmergencyDisplayed(), "❌ 'Cancel Emergency' button is NOT displayed!");
            test.pass("✅ 'Cancel Emergency' button is displayed.");
        } catch (Exception e) {
            test.fail("❌ 'Cancel Emergency' button verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 99, description = "Verify 'Cancel Emergency' Button Text")
    public void verifyCancelEmergencyText() {
        test = extent.createTest("Verify 'Cancel Emergency' Button Text");
        try {
            Assert.assertEquals(emergencyPage.getCancelEmergencyText(), "Cancel Emergency", "❌ 'Cancel Emergency' button text mismatch!");
            test.pass("✅ 'Cancel Emergency' button text is correct.");
        } catch (Exception e) {
            test.fail("❌ 'Cancel Emergency' button text verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 100, description = "Verify 'Cancel Emergency' Button is Clickable")
    public void verifyCancelEmergencyClickable() {
        test = extent.createTest("Verify 'Cancel Emergency' Button is Clickable");
        try {
            Assert.assertTrue(emergencyPage.isCancelEmergencyClickable(), "❌ 'Cancel Emergency' button is NOT clickable!");
            test.pass("✅ 'Cancel Emergency' button is clickable.");
        } catch (Exception e) {
            test.fail("❌ 'Cancel Emergency' button clickability verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 101, description = "Verify 'Stop Location Sharing' Button is Displayed")
    public void verifyStopLocationSharingDisplayed() {
        test = extent.createTest("Verify 'Stop Location Sharing' Button is Displayed");
        try {
            Assert.assertTrue(emergencyPage.isStopLocationSharingDisplayed(), "❌ 'Stop Location Sharing' button is NOT displayed!");
            test.pass("✅ 'Stop Location Sharing' button is displayed.");
        } catch (Exception e) {
            test.fail("❌ 'Stop Location Sharing' button verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 102, description = "Verify 'Stop Location Sharing' Button Text")
    public void verifyStopLocationSharingText() {
        test = extent.createTest("Verify 'Stop Location Sharing' Button Text");
        try {
            Assert.assertEquals(emergencyPage.getStopLocationSharingText(), "Stop Location Sharing", "❌ 'Stop Location Sharing' button text mismatch!");
            test.pass("✅ 'Stop Location Sharing' button text is correct.");
        } catch (Exception e) {
            test.fail("❌ 'Stop Location Sharing' button text verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 103, description = "Verify 'Stop Location Sharing' Button is Clickable")
    public void verifyStopLocationSharingClickable() {
        test = extent.createTest("Verify 'Stop Location Sharing' Button is Clickable");
        try {
            Assert.assertTrue(emergencyPage.isStopLocationSharingClickable(), "❌ 'Stop Location Sharing' button is NOT clickable!");
            test.pass("✅ 'Stop Location Sharing' button is clickable.");
        } catch (Exception e) {
            test.fail("❌ 'Stop Location Sharing' button clickability verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }
    @Test(priority = 104, description = "Click on 'Stop Location Sharing' Button")
    public void clickStopLocationSharingButton() {
        test = extent.createTest("Click on 'Stop Location Sharing' Button");
        try {
            // Ensure the button is clickable before clicking
        	
            Assert.assertTrue(emergencyPage.isStopLocationSharingClickable(), "❌ 'Stop Location Sharing' button is NOT clickable!");

            // Click the button
            emergencyPage.clickStopLocationSharing();
            test.pass("✅ Successfully clicked on 'Stop Location Sharing' button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on 'Stop Location Sharing' button: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }
    @Test(priority = 105, description = "Verify 'Stop Location Sharing' Popup is Displayed")
    public void verifyStopLocationSharingPopup() {
        test = extent.createTest("Verify 'Stop Location Sharing' Popup is Displayed");
        try {
        	Thread.sleep(1000);
            Assert.assertTrue(emergencyPage.isStopLocationSharingPopupDisplayed(), "❌ 'Stop Location Sharing' popup is NOT displayed!");
            test.pass("✅ 'Stop Location Sharing' popup is displayed.");
        } catch (Exception e) {
            test.fail("❌ Popup verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 106, description = "Verify 'Stop Location Sharing' Popup Header")
    public void verifyStopLocationSharingHeader() {
        test = extent.createTest("Verify 'Stop Location Sharing' Popup Header");
        try {
            Assert.assertEquals(emergencyPage.getStopLocationSharingHeaderText(), "Stop Location Sharing", "❌ Header text mismatch!");
            test.pass("✅ Header text is correctly displayed.");
        } catch (Exception e) {
            test.fail("❌ Header text verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 107, description = "Verify Stop Location Sharing Instructions")
    public void verifyStopLocationSharingInstructions() {
        test = extent.createTest("Verify Stop Location Sharing Instructions");
        try {
        	Assert.assertTrue(emergencyPage.getStopLocationSharingInstructionText().startsWith("Your location is being shared with Global Rescue's operations team"), 
        		    "❌ Instructions text does not start with the expected phrase!");

            test.pass("✅ Instructions text is correctly displayed.");
        } catch (Exception e) {
            test.fail("❌ Instructions text verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 108, description = "Verify Stop Location Sharing Reason Header")
    public void verifyStopLocationSharingReasonHeader() {
        test = extent.createTest("Verify Stop Location Sharing Reason Header");
        try {
            Assert.assertEquals(emergencyPage.getStopLocationSharingReasonHeaderText(), "Are you sure you want to stop sharing your location?", "❌ Reason header text mismatch!");
            test.pass("✅ Reason header text is correctly displayed.");
        } catch (Exception e) {
            test.fail("❌ Reason header verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 109, description = "Verify Cancel Button on Stop Location Sharing Popup")
    public void verifyCancelStopSharingButton() {
        test = extent.createTest("Verify Cancel Button on Stop Location Sharing Popup");
        try {
            Assert.assertTrue(emergencyPage.isCancelStopSharingButtonClickable(), "❌ Cancel button is NOT clickable!");
            test.pass("✅ Cancel button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Cancel button verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 110, description = "Verify Confirm Stop Button on Stop Location Sharing Popup")
    public void verifyConfirmStopSharingButton() {
        test = extent.createTest("Verify Confirm Stop Button on Stop Location Sharing Popup");
        try {
            Assert.assertTrue(emergencyPage.isConfirmStopSharingButtonClickable(), "❌ Stop button is NOT clickable!");
            test.pass("✅ Stop button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Stop button verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }


    @Test(priority = 112, description = "Click Confirm Stop on Stop Location Sharing Popup")
    public void clickConfirmStopSharing() {
        test = extent.createTest("Click Confirm Stop on Stop Location Sharing Popup");
        try {
            emergencyPage.clickConfirmStopSharing();
            test.pass("✅ Successfully clicked 'Stop' on Stop Location Sharing Popup.");
        } catch (Exception e) {
            test.fail("❌ Failed to click 'Stop': " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }
   

    @Test(priority = 114, description = "Verify Notification Text for Stopping Location Sharing")
    public void verifyStopLocationSharingNotificationText() {
        test = extent.createTest("Verify Stop Location Sharing Notification Text");
        try {
            Assert.assertEquals(emergencyPage.getStopLocationSharingNotificationText(), "Your location sharing has been stopped.", "❌ Notification text mismatch!");
            test.pass("✅ Notification text is correct: 'Your location sharing has been stopped.'");
        } catch (Exception e) {
            test.fail("❌ Notification text verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 115, description = "Verify 'Cancel' Button on Stop Location Sharing Notification is Clickable")
    public void verifyStopLocationSharingCancelNotificationClickable() {
        test = extent.createTest("Verify 'Cancel' Button on Notification is Clickable");
        try {
            Assert.assertTrue(emergencyPage.isStopLocationSharingCancelNotificationClickable(), "❌ 'Cancel' button is NOT clickable!");
            test.pass("✅ 'Cancel' button on notification is clickable.");
        } catch (Exception e) {
            test.fail("❌ 'Cancel' button verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }
    @Test(priority = 116, description = "Verify 'Start Location Sharing' Button Text")
    public void verifyStartLocationSharingText() {
        test = extent.createTest("Verify 'Start Location Sharing' Button Text");
        try {
            Assert.assertEquals(emergencyPage.getStopLocationSharingText(), "Start Location Sharing", "❌ 'Stop Location Sharing' button text mismatch!");
            test.pass("✅ 'Start Location Sharing' button text is correct.");
        } catch (Exception e) {
            test.fail("❌ 'Start Location Sharing' button text verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }
    @Test(priority = 117, description = "Click on 'Start Location Sharing' Button")
    public void clickStartLocationSharingButton() {
        test = extent.createTest("Click on 'Stop Location Sharing' Button");
        try {
            // Ensure the button is clickable before clicking
        	
            Assert.assertTrue(emergencyPage.isStopLocationSharingClickable(), "❌ 'Start Location Sharing' button is NOT clickable!");

            // Click the button
            emergencyPage.clickStopLocationSharing();
            test.pass("✅ Successfully clicked on 'Start Location Sharing' button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on 'Start Location Sharing' button: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }
    @Test(priority = 118, description = "Verify 'Start Location Sharing' Popup is Displayed")
    public void verifyStartLocationSharingPopup() {
        test = extent.createTest("Verify 'Start Location Sharing' Popup is Displayed");
        try {
        	Thread.sleep(1000);
            Assert.assertTrue(emergencyPage.isStopLocationSharingPopupDisplayed(), "❌ 'Start Location Sharing' popup is NOT displayed!");
            test.pass("✅ 'Start Location Sharing' popup is displayed.");
        } catch (Exception e) {
            test.fail("❌ Popup verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

   
    @Test(priority = 119, description = "Verify Start Location Sharing Instructions")
    public void verifyStartLocationSharingInstructions() {
        test = extent.createTest("Verify Start Location Sharing Instructions");
        try {
            Assert.assertTrue(emergencyPage.getStopLocationSharingInstructionText().equals("Your location will be automatically shared with Global Rescue's operations team every 30 minutes for the next 6 hours."), "❌ Instructions text mismatch!");
            test.pass("✅ Instructions text is correctly displayed.");
        } catch (Exception e) {
            test.fail("❌ Instructions text verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 120, description = "Verify Start Location Sharing Reason Header")
    public void verifyStartLocationSharingReasonHeader() {
        test = extent.createTest("Verify Start Location Sharing Reason Header");
        try {
            Assert.assertEquals(emergencyPage.getStartLocationSharingReasonHeaderText(), "Start Location Sharing", "❌ Reason header text mismatch!");
            test.pass("✅ Reason header text is correctly displayed.");
        } catch (Exception e) {
            test.fail("❌ Reason header verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 121, description = "Verify Cancel Button on Start Location Sharing Popup")
    public void verifyCancelStartSharingButton() {
        test = extent.createTest("Verify Cancel Button on Start Location Sharing Popup");
        try {
            Assert.assertTrue(emergencyPage.isCancelStopSharingButtonClickable(), "❌ Cancel button is NOT clickable!");
            test.pass("✅ Cancel button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Cancel button verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 122, description = "Verify Confirm Stop Button on Stop Location Sharing Popup")
    public void verifyConfirmStartSharingButton() {
        test = extent.createTest("Verify Confirm Stop Button on Start Location Sharing Popup");
        try {
            Assert.assertTrue(emergencyPage.isConfirmStopSharingButtonClickable(), "❌ Start button is NOT clickable!");
            test.pass("✅ Start button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Start button verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }



    @Test(priority = 123, description = "Click Confirm Stop on Stop Location Sharing Popup")
    public void clickConfirmStartSharing() {
        test = extent.createTest("Click Confirm Stop on Stop Location Sharing Popup");
        try {
            emergencyPage.clickConfirmStopSharing();
            test.pass("✅ Successfully clicked 'Stop' on Stop Location Sharing Popup.");
        } catch (Exception e) {
            test.fail("❌ Failed to click 'Stop': " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }
    @Test(priority = 124, description = "Verify 'Your location sharing has been Start' Notification is Displayed")
    public void verifyStartLocationSharingNotification() {
        test = extent.createTest("Verify 'Your location sharing has been Start' Notification");
        try {
            Assert.assertTrue(emergencyPage.isStopLocationSharingNotificationDisplayed(), "❌ Notification is NOT displayed!");
            test.pass("✅ 'Your location sharing has started' notification is displayed.");
        } catch (Exception e) {
            test.fail("❌ Notification verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 125, description = "Verify Notification Text for Stopping Location Sharing")
    public void verifyStartLocationSharingNotificationText() {
        test = extent.createTest("Verify Stop Location Sharing Notification Text");
        try {
            Assert.assertEquals(emergencyPage.getStopLocationSharingNotificationText(), "Your location sharing has started.", "❌ Notification text mismatch!");
            test.pass("✅ Notification text is correct: 'Your location sharing has been stopped.'");
        } catch (Exception e) {
            test.fail("❌ Notification text verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }

    @Test(priority = 126, description = "Verify 'Cancel' Button on Start Location Sharing Notification is Clickable")
    public void verifyStartLocationSharingCancelNotificationClickable() {
        test = extent.createTest("Verify 'Cancel' Button on Notification is Clickable");
        try {
            Assert.assertTrue(emergencyPage.isStopLocationSharingCancelNotificationClickable(), "❌ 'Cancel' button is NOT clickable!");
            test.pass("✅ 'Cancel' button on notification is clickable.");
        } catch (Exception e) {
            test.fail("❌ 'Cancel' button verification failed: " + e.getMessage());
            Assert.fail("Test Failed!", e);
        }
    }
    @Test(priority = 127, description = "Cancel Emergency")
    public void cancelEmergency() {
        test = extent.createTest("Cancel Emergency");

        try {
        	Thread.sleep(3000);
            // Click on Cancel Emergency button
            emergencyPage.clickCancelEmergencyButton();
            test.pass("✅ Clicked on 'Cancel Emergency' button.");

            // Click on Cancellation Reason dropdown
            emergencyPage.clickCancellationReasonDropdown();
            test.pass("✅ Opened cancellation reason dropdown.");

            // Select 'Was testing the emergency feature'
            emergencyPage.selectCancellationReason("Was testing the emergency feature");
            test.pass("✅ Selected 'Was testing the emergency feature' as cancellation reason.");

            // Click on Yes button to confirm cancellation
            emergencyPage.clickYesButton();
            test.pass("✅ Emergency cancellation confirmed.");

        } catch (Exception e) {
            test.fail("❌ Emergency cancellation failed: " + e.getMessage());
            Assert.fail("Emergency cancellation test failed!", e);
        }
    }

  @Test(priority = 129, description = "Verify Image and Text on Web Portal")
  public void verifyImageAndText() {
      test = extent.createTest("Verify Image and Text on Web Portal"); // Create test in ExtentReports

      try {
    	  WebPortal webPortal = new WebPortal();
		//WebPortal.SelOpsPortal();
          // Call the WebPortal verification method
          webPortal.OpsPortalVerify();

          // Log success message and mark test as passed
          test.pass("✅ Image and text verification passed successfully.");

      } catch (Exception e) {
          // Log failure message, capture exception, and explicitly fail the test
          test.fail("❌ Image and text verification failed. Exception: " + e.getMessage());
          e.printStackTrace(); // Print error in the console
      }
  }

@Test(priority = 130, description = "Verify Emergency Title is Displayed")
public void verifyEmergencyTitleDisplayed() {
    test = extent.createTest("Verify Emergency Title is Displayed");

    try {
        Assert.assertTrue(emergencyPage.isEmergencyTitleDisplayed(), "❌ Emergency Title is NOT displayed!");
        test.pass("✅ Emergency Title is displayed successfully.");
    } catch (Exception e) {
        test.fail("❌ Emergency Title verification failed: " + e.getMessage());
        Assert.fail("Emergency Title verification test failed!", e);
    }
}
}



