package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.BaseSetup;
import io.appium.java_client.AppiumBy;
import io.github.cdimascio.dotenv.Dotenv;
import pages.CheckInPage;
import pages.LoginPage;
import pages.SignUpPage;
import TestCases.SignUpTest;
import utilities.ExtentReportsManager;

public class CheckInTest extends BaseSetup {
    private CheckInPage checkInPage;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setup() {
        checkInPage = new CheckInPage(getDriver());
        extent = ExtentReportsManager.getExtentReports();
    }
    

    @Test(priority = 1, description = "Click on Check-In Button")
    public void clickCheckInButton() {
        test = extent.createTest("Click on Check-In Button");
        try {
            checkInPage.clickCheckIn();
            test.pass("✅ Clicked on the Check-In button successfully.");
        } catch (Exception e) {
            test.fail("❌ Click on Check-In button failed: " + e.getMessage());
            Assert.fail("Check-In button click test failed!", e);
        }
    }

    @Test(priority = 2, description = "Verify Check-In Page Title is Displayed")
    public void verifyCheckInPageTitleIsDisplayed() {
        test = extent.createTest("Verify Check-In Page Title Display");
        try {
            Assert.assertTrue(checkInPage.isPageTitleDisplayed(), "❌ Check-In page title is NOT displayed!");
            test.pass("✅ Check-In page title is displayed.");
        } catch (Exception e) {
            test.fail("❌ Check-In page title verification failed: " + e.getMessage());
            Assert.fail("Check-In page title verification failed!", e);
        }
    }

    @Test(priority = 3, description = "Verify Check-In Page Title Text")
    public void verifyCheckInPageTitleText() {
        test = extent.createTest("Verify Check-In Page Title Text");
        try {
            Assert.assertEquals(checkInPage.getPageTitleText(), "Check-In", "❌ Check-In page title text mismatch!");
            test.pass("✅ Check-In page title text is correct.");
        } catch (Exception e) {
            test.fail("❌ Check-In page title text verification failed: " + e.getMessage());
            Assert.fail("Check-In page title text verification failed!", e);
        }
    }


    @Test(priority = 4, description = "Verify Latitude is Displayed on Check-In Page")
    public void verifyLatitudeDisplayed() {
        test = extent.createTest("Verify Latitude Display");
        try {
            Assert.assertTrue(checkInPage.isLatitudeDisplayed(), "❌ Latitude is NOT displayed!");
            test.pass("✅ Latitude is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Latitude verification failed: " + e.getMessage());
            Assert.fail("Latitude verification test failed!", e);
        }
    }

    @Test(priority = 5, description = "Verify Longitude is Displayed on Check-In Page")
    public void verifyLongitudeDisplayed() {
        test = extent.createTest("Verify Longitude Display");
        try {
            Assert.assertTrue(checkInPage.isLongitudeDisplayed(), "❌ Longitude is NOT displayed!");
            test.pass("✅ Longitude is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Longitude verification failed: " + e.getMessage());
            Assert.fail("Longitude verification test failed!", e);
        }
    }


    @Test(priority = 6, description = "Verify Accuracy Image is Displayed on Check-In Page")
    public void verifyAccuracyImageDisplayed() {
        test = extent.createTest("Verify Accuracy Image Display");
        try {
            Assert.assertTrue(checkInPage.isAccuracyImageDisplayed(), "❌ Accuracy image is NOT displayed!");
            test.pass("✅ Accuracy image is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Accuracy image verification failed: " + e.getMessage());
            Assert.fail("Accuracy image verification test failed!", e);
        }
    }

    @Test(priority = 7, description = "Verify Accuracy Text is Displayed on Check-In Page")
    public void verifyAccuracyTextDisplayed() {
        test = extent.createTest("Verify Accuracy Text Display");
        try {
            Assert.assertTrue(checkInPage.isAccuracyTextDisplayed(), "❌ Accuracy text is NOT displayed!");
            test.pass("✅ Accuracy text is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Accuracy text verification failed: " + e.getMessage());
            Assert.fail("Accuracy text verification test failed!", e);
        }
    }


    @Test(priority = 8, description = "Verify Nearby Places Section is Displayed")
    public void verifyNearbyPlacesSectionDisplayed() {
        test = extent.createTest("Verify Nearby Places Section Display");
        try {
            Assert.assertTrue(checkInPage.isNearbyPlacesDisplayed(), "❌ Nearby Places section is NOT displayed!");
            test.pass("✅ Nearby Places section is visible.");
        } catch (Exception e) {
            test.fail("❌ Nearby Places section visibility check failed: " + e.getMessage());
            Assert.fail("Nearby Places section display test failed!", e);
        }
    }

    @Test(priority = 9, description = "Verify Nearby Places Section Contains Correct Text")
    public void verifyNearbyPlacesText() {
        test = extent.createTest("Verify Nearby Places Text");
        try {
            Assert.assertEquals(checkInPage.getNearbyPlacesText(), "Nearby Places", "❌ Nearby Places text does not match!");
            test.pass("✅ Nearby Places text is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Nearby Places text verification failed: " + e.getMessage());
            Assert.fail("Nearby Places text verification test failed!", e);
        }
    }


    @Test(priority = 10, description = "Verify Map Address Display")
    public void verifyMapAddressDisplay() {
        test = extent.createTest("Verify Map Address Display");
        try {
            Assert.assertTrue(checkInPage.isMapAddressDisplayed(), "❌ Map address is NOT displayed!");
            test.pass("✅ Map address is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Map address verification failed: " + e.getMessage());
            Assert.fail("Map address verification test failed!", e);
        }
    }

    @Test(priority = 11, description = "Verify Optional Message Button Display")
    public void verifyOptionalMessageButtonDisplay() {
        test = extent.createTest("Verify Optional Message Button Display");
        try {
            Assert.assertTrue(checkInPage.isOptionalMessageButtonDisplayed(), "❌ Optional message button is NOT displayed!");
            test.pass("✅ Optional message button is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Optional message button verification failed: " + e.getMessage());
            Assert.fail("Optional message button verification test failed!", e);
        }
    }
    @Test(priority = 12, description = "Verify Back Button is Clickable")
    public void verifyBackButtonClickable() {
        test = extent.createTest("Verify Back Button Clickable");
        try {
            Assert.assertTrue(checkInPage.isBackButtonClickable(), "❌ Back button is NOT clickable!");
            test.pass("✅ Back button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Back button verification failed: " + e.getMessage());
            Assert.fail("Back button clickable verification test failed!", e);
        }
    }
    @Test(priority = 13, description = "Verify Click on Nearby Places")
    public void verifyClickNearbyPlaces() {
        test = extent.createTest("Verify Click on Nearby Places");
        try {
            checkInPage.clickNearbyPlaces();
            test.pass("✅ Successfully clicked on Nearby Places.");
        } catch (Exception e) {
            test.fail("❌ Click on Nearby Places failed: " + e.getMessage());
            Assert.fail("Nearby Places click verification test failed!", e);
        }
    }
    @Test(priority = 14, description = "Verify Nearby Places Modal is Displayed")
    public void verifyNearbyPlacesModalDisplayed() {
        test = extent.createTest("Verify Nearby Places Modal Display");
        try {
            Assert.assertTrue(checkInPage.isNearbyPlacesModalDisplayed(), "❌ Nearby Places modal is NOT displayed!");
            test.pass("✅ Nearby Places modal is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Nearby Places modal verification failed: " + e.getMessage());
            Assert.fail("Nearby Places modal test failed!", e);
        }
    }
    @Test(priority = 15, description = "Verify Nearby Places Header is Displayed")
    public void verifyNearbyPlacesHeader() {
        test = extent.createTest("Verify Nearby Places Header");
        try {
            Assert.assertTrue(checkInPage.isNearbyPlacesHeaderDisplayed(), "❌ Nearby Places header is NOT displayed!");
            test.pass("✅ Nearby Places header is displayed.");
        } catch (Exception e) {
            test.fail("❌ Nearby Places header verification failed: " + e.getMessage());
            Assert.fail("Nearby Places header test failed!", e);
        }
    }

    @Test(priority = 16, description = "Verify Places Recycler View is Displayed")
    public void verifyPlacesRecyclerView() {
        test = extent.createTest("Verify Places Recycler View");
        try {
            Assert.assertTrue(checkInPage.isPlacesRecyclerViewDisplayed(), "❌ Places Recycler View is NOT displayed!");
            test.pass("✅ Places Recycler View is displayed.");
        } catch (Exception e) {
            test.fail("❌ Places Recycler View verification failed: " + e.getMessage());
            Assert.fail("Places Recycler View test failed!", e);
        }
    }

    @Test(priority = 17, description = "Verify Address View is Displayed")
    public void verifyAddressView() {
        test = extent.createTest("Verify Address View");
        try {
            Assert.assertTrue(checkInPage.isAddressViewDisplayed(), "❌ Address View is NOT displayed!");
            test.pass("✅ Address View is displayed.");
        } catch (Exception e) {
            test.fail("❌ Address View verification failed: " + e.getMessage());
            Assert.fail("Address View test failed!", e);
        }
    }

    @Test(priority = 18, description = "Verify Address Text View is Displayed")
    public void verifyAddressTextView() {
        test = extent.createTest("Verify Address Text View");
        try {
            Assert.assertTrue(checkInPage.isAddressTextViewDisplayed(), "❌ Address Text View is NOT displayed!");
            test.pass("✅ Address Text View is displayed.");
        } catch (Exception e) {
            test.fail("❌ Address Text View verification failed: " + e.getMessage());
            Assert.fail("Address Text View test failed!", e);
        }
    }

    @Test(priority = 19, description = "Verify Mile View is Displayed")
    public void verifyMileView() {
        test = extent.createTest("Verify Mile View");
        try {
            Assert.assertTrue(checkInPage.isMileViewDisplayed(), "❌ Mile View is NOT displayed!");
            test.pass("✅ Mile View is displayed.");
        } catch (Exception e) {
            test.fail("❌ Mile View verification failed: " + e.getMessage());
            Assert.fail("Mile View test failed!", e);
        }
    }
    @Test(priority = 20, description = "Verify Close Button is Displayed and Clickable")
    public void verifyCloseButton() {
        test = extent.createTest("Verify Close Button");
        try {
            Assert.assertTrue(checkInPage.isCloseButtonDisplayed(), "❌ Close Button is NOT displayed!");
            test.pass("✅ Close Button is displayed.");
        } catch (Exception e) {
            test.fail("❌ Close Button verification failed: " + e.getMessage());
            Assert.fail("Close Button test failed!", e);
        }
    }

    @Test(priority = 21, description = "Click on Close Button in Nearby Places")
    public void clickOnCloseButton() {
        test = extent.createTest("Click on Close Button");
        try {
            checkInPage.clickCloseButton();
            test.pass("✅ Successfully clicked on the Close button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Close button: " + e.getMessage());
            Assert.fail("Click on Close button test failed!", e);
        }
    }
    @Test(priority = 22, description = "Verify 'Add Message' Button is Displayed")
    public void verifyAddMessageButtonDisplayed() {
        test = extent.createTest("Verify 'Add Message' Button Display");
        try {
            Assert.assertTrue(checkInPage.isAddMessageButtonDisplayed(), "❌ 'Add Message' button is NOT displayed!");
            test.pass("✅ 'Add Message' button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'Add Message' button verification failed: " + e.getMessage());
            Assert.fail("'Add Message' button test failed!", e);
        }
    }

    @Test(priority = 23, description = "Click on 'Add Message' Button")
    public void clickOnAddMessageButton() {
        test = extent.createTest("Click on 'Add Message' Button");
        try {
            checkInPage.clickAddMessageButton();
            test.pass("✅ Successfully clicked on the 'Add Message' button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on 'Add Message' button: " + e.getMessage());
            Assert.fail("Click on 'Add Message' button test failed!", e);
        }
    }

    @Test(priority = 24, description = "Close the Keyboard if Open")
    public void verifyAndCloseKeyboard() {
        test = extent.createTest("Verify and Close Keyboard");
        try {
            checkInPage.closeKeyboardIfOpen();
            test.pass("✅ Successfully closed the keyboard if it was open.");
        } catch (Exception e) {
            test.fail("❌ Failed to close the keyboard: " + e.getMessage());
            Assert.fail("Close keyboard test failed!", e);
        }
    }
    @Test(priority = 25, description = "Verify Check-In Message Page Title is Displayed")
    public void verifyCheckInMessageTitleDisplayed() {
        test = extent.createTest("Verify Check-In Message Title is Displayed");
        try {
            Assert.assertTrue(checkInPage.isCheckInMessageTitleDisplayed(), "❌ Check-In Message title is NOT displayed!");
            test.pass("✅ Check-In Message title is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Check-In Message title visibility verification failed: " + e.getMessage());
            Assert.fail("Check-In Message title visibility verification test failed!", e);
        }
    }
    @Test(priority = 26, description = "Verify Text of Check-In Message Page Title")
    public void verifyCheckInMessageTitleText() {
        test = extent.createTest("Verify Check-In Message Title Text");
        try {
            Assert.assertEquals(checkInPage.getCheckInMessageTitleText(), "Check-In Message", "❌ Check-In Message title text mismatch!");
            test.pass("✅ Check-In Message title text is correct.");
        } catch (Exception e) {
            test.fail("❌ Check-In Message title text verification failed: " + e.getMessage());
            Assert.fail("Check-In Message title text verification test failed!", e);
        }
    }

    
    @Test(priority = 26, description = "Verify Back Button Presence on Check-In Message Page")
    public void verifyBackButtonPresenceOnCheckInMessagePage() {
        test = extent.createTest("Verify Back Button Presence on Check-In Message Page");
        try {
            Assert.assertTrue(checkInPage.isBackButtonDisplayed(), "❌ Back button is NOT displayed on Check-In Message Page!");
            test.pass("✅ Back button is displayed on Check-In Message Page.");
        } catch (Exception e) {
            test.fail("❌ Back button verification failed: " + e.getMessage());
            Assert.fail("Back button verification test failed!", e);
        }
    }
    @Test(priority = 27, description = "Verify Message Label is Displayed on Check-In Message Page")
    public void verifyMessageLabelDisplayed() {
        test = extent.createTest("Verify Message Label is Displayed");
        try {
            Assert.assertTrue(checkInPage.isMessageLabelDisplayed(), "❌ 'Message' label is NOT displayed!");
            test.pass("✅ 'Message' label is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'Message' label visibility verification failed: " + e.getMessage());
            Assert.fail("Message label visibility verification test failed!", e);
        }
    }
    @Test(priority = 28, description = "Verify Text of Message Label on Check-In Message Page")
    public void verifyMessageLabelText() {
        test = extent.createTest("Verify Message Label Text");
        try {
            Assert.assertEquals(checkInPage.getMessageLabelText(), "Message", "❌ 'Message' label text mismatch!");
            test.pass("✅ 'Message' label text is correct.");
        } catch (Exception e) {
            test.fail("❌ 'Message' label text verification failed: " + e.getMessage());
            Assert.fail("Message label text verification test failed!", e);
        }
    }

    @Test(priority = 29, description = "Verify (Optional) Label is Displayed")
    public void verifyOptionalLabelDisplayed() {
        test = extent.createTest("Verify (Optional) Label is Displayed");
        try {
            Assert.assertTrue(checkInPage.isOptionalLabelDisplayed(), "❌ '(Optional)' label is NOT displayed!");
            test.pass("✅ '(Optional)' label is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ '(Optional)' label visibility verification failed: " + e.getMessage());
            Assert.fail("(Optional) label visibility verification test failed!", e);
        }
    }
    @Test(priority = 30, description = "Verify Text of (Optional) Label")
    public void verifyOptionalLabelText() {
        test = extent.createTest("Verify (Optional) Label Text");
        try {
            Assert.assertEquals(checkInPage.getOptionalLabelText(), "(optional)", "❌ '(Optional)' label text mismatch!");
            test.pass("✅ '(Optional)' label text is correct.");
        } catch (Exception e) {
            test.fail("❌ '(Optional)' label text verification failed: " + e.getMessage());
            Assert.fail("(Optional) label text verification test failed!", e);
        }
    }

    @Test(priority = 31, description = "Verify Message Input Field is Displayed")
    public void verifyMessageInputFieldDisplayed() {
        test = extent.createTest("Verify Message Input Field is Displayed");
        try {
            Assert.assertTrue(checkInPage.isMessageInputFieldDisplayed(), "❌ Message input field is NOT displayed!");
            test.pass("✅ Message input field is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Message input field visibility verification failed: " + e.getMessage());
            Assert.fail("Message input field visibility verification test failed!", e);
        }
    }
    @Test(priority = 32, description = "Verify Message Input Field Placeholder Text")
    public void verifyMessageInputPlaceholderText() {
        test = extent.createTest("Verify Message Input Field Placeholder Text");
        try {
            Assert.assertEquals(checkInPage.getMessageInputPlaceholder(), 
                "Enter your message here or tap on a choice below for quick fill.", 
                "❌ Message input placeholder text mismatch!");
            test.pass("✅ Message input field placeholder text is correct.");
        } catch (Exception e) {
            test.fail("❌ Message input field placeholder text verification failed: " + e.getMessage());
            Assert.fail("Message input field placeholder text verification test failed!", e);
        }
    }

    @Test(priority = 33, description = "Verify Suggestions Label")
    public void verifySuggestionsLabel() {
        test = extent.createTest("Verify Suggestions Label");
        try {
            Assert.assertTrue(checkInPage.isSuggestionsLabelDisplayed(), "❌ 'Suggestions' label is NOT displayed!");
            Assert.assertEquals(checkInPage.getSuggestionsLabelText(), "Suggestions", "❌ 'Suggestions' label text mismatch!");
            test.pass("✅ 'Suggestions' label is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ 'Suggestions' label verification failed: " + e.getMessage());
            Assert.fail("Suggestions label verification test failed!", e);
        }
    }
    @Test(priority = 34, description = "Verify 'Arrived Safely at This Location' Suggestion is Displayed")
    public void verifyArrivedSafelySuggestionDisplayed() {
        test = extent.createTest("Verify 'Arrived Safely at This Location' Suggestion is Displayed");
        try {
            Assert.assertTrue(checkInPage.isArrivedSafelySuggestionDisplayed(), 
                "❌ 'Arrived Safely at This Location' suggestion is NOT displayed!");
            test.pass("✅ 'Arrived Safely at This Location' suggestion is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'Arrived Safely at This Location' suggestion visibility verification failed: " + e.getMessage());
            Assert.fail("'Arrived Safely at This Location' suggestion visibility verification test failed!", e);
        }
    }
    @Test(priority = 35, description = "Verify 'Arrived Safely at This Location' Suggestion Text")
    public void verifyArrivedSafelySuggestionText() {
        test = extent.createTest("Verify 'Arrived Safely at This Location' Suggestion Text");
        try {
            Assert.assertEquals(checkInPage.getArrivedSafelySuggestionText(), 
                "Arrived safely at this location", 
                "❌ 'Arrived Safely at This Location' text mismatch!");
            test.pass("✅ 'Arrived Safely at This Location' suggestion text is correct.");
        } catch (Exception e) {
            test.fail("❌ 'Arrived Safely at This Location' suggestion text verification failed: " + e.getMessage());
            Assert.fail("'Arrived Safely at This Location' suggestion text verification test failed!", e);
        }
    }

    @Test(priority = 36, description = "Verify 'Checked-in at Hotel' Suggestion is Displayed")
    public void verifyCheckedInAtHotelSuggestionDisplayed() {
        test = extent.createTest("Verify 'Checked-in at Hotel' Suggestion is Displayed");
        try {
            Assert.assertTrue(checkInPage.isCheckedInAtHotelSuggestionDisplayed(), 
                "❌ 'Checked-in at Hotel' suggestion is NOT displayed!");
            test.pass("✅ 'Checked-in at Hotel' suggestion is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'Checked-in at Hotel' suggestion visibility verification failed: " + e.getMessage());
            Assert.fail("'Checked-in at Hotel' suggestion visibility verification test failed!", e);
        }
    }
    @Test(priority = 37, description = "Verify 'Checked-in at Hotel' Suggestion Text")
    public void verifyCheckedInAtHotelSuggestionText() {
        test = extent.createTest("Verify 'Checked-in at Hotel' Suggestion Text");
        try {
            Assert.assertEquals(checkInPage.getCheckedInAtHotelSuggestionText(), 
                "Checked-in at hotel", 
                "❌ 'Checked-in at Hotel' text mismatch!");
            test.pass("✅ 'Checked-in at Hotel' suggestion text is correct.");
        } catch (Exception e) {
            test.fail("❌ 'Checked-in at Hotel' suggestion text verification failed: " + e.getMessage());
            Assert.fail("'Checked-in at Hotel' suggestion text verification test failed!", e);
        }
    }

    @Test(priority = 38, description = "Verify 'Done' Button is Displayed")
    public void verifyDoneButtonDisplayed() {
        test = extent.createTest("Verify 'Done' Button is Displayed");
        try {
            Assert.assertTrue(checkInPage.isDoneButtonDisplayed(), 
                "❌ 'Done' button is NOT displayed!");
            test.pass("✅ 'Done' button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'Done' button visibility verification failed: " + e.getMessage());
            Assert.fail("'Done' button visibility verification test failed!", e);
        }
    }
    @Test(priority = 39, description = "Verify 'Done' Button Text")
    public void verifyDoneButtonText() {
        test = extent.createTest("Verify 'Done' Button Text");
        try {
            Assert.assertEquals(checkInPage.getDoneButtonText(), 
                "Done", 
                "❌ 'Done' button text mismatch!");
            test.pass("✅ 'Done' button text is correct.");
        } catch (Exception e) {
            test.fail("❌ 'Done' button text verification failed: " + e.getMessage());
            Assert.fail("'Done' button text verification test failed!", e);
        }
    }

    @Test(priority = 40, description = "Enter Message in Message Input Field")
    public void enterTextInMessageField() {
        test = extent.createTest("Enter Text in Message Field");

        try {
            checkInPage.enterMessageText("I just want to inform you that I have ");
            test.pass("✅ Successfully entered the message in the message input field.");
        } catch (Exception e) {
            test.fail("❌ Failed to enter message in the input field: " + e.getMessage());
            Assert.fail("Message input field test failed!", e);
        }
    }

    @Test(priority = 41, description = "Click on 'Arrived Safely at This Location' Suggestion")
    public void clickArrivedSafelySuggestion() {
        test = extent.createTest("Click on 'Arrived Safely at This Location' Suggestion");
        try {
            checkInPage.clickArrivedSafelySuggestion();
            test.pass("✅ Successfully clicked on 'Arrived Safely at This Location' suggestion.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on 'Arrived Safely at This Location' suggestion: " + e.getMessage());
            Assert.fail("Clicking on 'Arrived Safely at This Location' suggestion test failed!", e);
        }
    }


    @Test(priority = 42, description = "Click on 'Checked-in at Hotel' Suggestion")
    public void appendAndClickCheckedInAtHotelSuggestionWithoutClearing() {
        test = extent.createTest("Click on 'Checked-in at Hotel' Suggestion");
        try {
              // Click on "Checked-in at Hotel" suggestion
            checkInPage.clickCheckedInAtHotelSuggestion();
            test.pass("✅ Successfully clicked on 'Checked-in at Hotel' suggestion.");
        } catch (Exception e) {
            test.fail("❌ Failed to append ' & ' or click on 'Checked-in at Hotel' suggestion: " + e.getMessage());
            Assert.fail("Appending ' & ' without clearing and clicking on 'Checked-in at Hotel' suggestion test failed!", e);
        }
    }
    public String expectedMessage;
    @Test(priority = 43, description = "Verify Appended Message Text in Message Field")
    public void verifyAppendedMessageText() {
        test = extent.createTest("Verify Appended Message Text in Message Field");

        try {
            // Expected message after appending text
            expectedMessage = "I just want to inform you that I have Arrived safely at this locationChecked-in at hotel";

            // Get actual text from the message field
            String actualMessage = checkInPage.getMessageFieldText();

            // Verify the text matches the expected message
            Assert.assertEquals(actualMessage, expectedMessage, "❌ Message text does not match expected value!");
            test.pass("✅ Message text is correctly displayed in the input field.");
        } catch (Exception e) {
            test.fail("❌ Message field text verification failed: " + e.getMessage());
            Assert.fail("Message field text verification test failed!", e);
        }
    }
    @Test(priority = 44, description = "Click on Done Button")
    public void clickDoneButton() {
        test = extent.createTest("Click on Done Button");

        try {
            // Click the Done button
            checkInPage.clickDoneButton();
            test.pass("✅ Successfully clicked on the Done button.");

        } catch (Exception e) {
            test.fail("❌ Clicking on the Done button failed: " + e.getMessage());
            Assert.fail("Done button click test failed!", e);
        }
    }
    @Test(priority = 45, description = "Verify ImageView7 is Visible on Screen")
    public void verifyImageView7IsVisible() {
        test = extent.createTest("Verify ImageView7 is Visible on Screen");

        try {
            Assert.assertTrue(checkInPage.isImageView7Displayed(), "❌ ImageView7 is NOT visible on screen!");
            test.pass("✅ ImageView7 is visible on screen.");
        } catch (Exception e) {
            test.fail("❌ ImageView7 visibility verification failed: " + e.getMessage());
            Assert.fail("ImageView7 visibility test failed!", e);
        }
    }

    @Test(priority = 46, description = "Verify Check-In Comments Section Visibility")
    public void verifyCheckInCommentsVisibility() {
        test = extent.createTest("Verify Check-In Comments Section Visibility");

        try {
            Assert.assertTrue(checkInPage.isCheckInCommentsDisplayed(), "❌ Check-In Comments section is NOT visible!");
            test.pass("✅ Check-In Comments section is visible.");
        } catch (Exception e) {
            test.fail("❌ Check-In Comments section visibility verification failed: " + e.getMessage());
            Assert.fail("Check-In Comments section visibility test failed!", e);
        }
    }
    @Test(priority = 47, description = "Verify Check-In Message Text is Displayed")
    public void verifyCheckInMessageDisplayed() {
        test = extent.createTest("Verify Check-In Message Text is Displayed");

        try {
            Assert.assertTrue(checkInPage.isCheckInMessageDisplayed(), "❌ Check-In message text is NOT visible!");
            test.pass("✅ Check-In message text is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Check-In message text verification failed: " + e.getMessage());
            Assert.fail("Check-In message text verification test failed!", e);
        }
    }

    @Test(priority = 48, description = "Verify Check-In Comments Section is Clickable")
    public void verifyCheckInCommentsClickable() {
        test = extent.createTest("Verify Check-In Comments Section is Clickable");

        try {
            Assert.assertTrue(checkInPage.isCheckInCommentsClickable(), "❌ Check-In Comments section is NOT clickable!");
            test.pass("✅ Check-In Comments section is clickable.");
        } catch (Exception e) {
            test.fail("❌ Check-In Comments section clickability verification failed: " + e.getMessage());
            Assert.fail("Check-In Comments section clickability test failed!", e);
        }
    }

    @Test(priority = 49, description = "Verify Check-In Message Matches Expected Text")
    public void verifyCheckInMessageMatchesExpected() {
        test = extent.createTest("Verify Check-In Message Matches Expected Text");

        try {
            String actualMessage = checkInPage.getCheckInMessageText();
            
            Assert.assertEquals(actualMessage, expectedMessage, "❌ Check-In message text does not match expected value!");
            test.pass("✅ Check-In message text matches expected value: " + expectedMessage);
        } catch (Exception e) {
            test.fail("❌ Check-In message text verification failed: " + e.getMessage());
            Assert.fail("Check-In message text verification test failed!", e);
        }
    }
    @Test(priority = 50, description = "Click on Check-In Comments Section")
    public void clickOnCheckInComments() {
        test = extent.createTest("Click on Check-In Comments Section");

        try {
            checkInPage.clickCheckInComments();
            test.pass("✅ Successfully clicked on Check-In Comments section.");
        } catch (Exception e) {
            test.fail("❌ Clicking on Check-In Comments section failed: " + e.getMessage());
            Assert.fail("Clicking on Check-In Comments section test failed!", e);
        }
    }

    @Test(priority = 51, description = "Verify Appended Message Text in Message Field")
    public void againVerifyAppendedMessageText() {
        test = extent.createTest("Verify Appended Message Text in Message Field");

        try {
            // Get actual text from the message field
            String actualMessage = checkInPage.getMessageFieldText();

            // Verify the text matches the expected message
            Assert.assertEquals(actualMessage, expectedMessage, "❌ Message text does not match expected value!");
            test.pass("✅ Message text is correctly displayed in the input field.");
        } catch (Exception e) {
            test.fail("❌ Message field text verification failed: " + e.getMessage());
            Assert.fail("Message field text verification test failed!", e);
        }
    }
    
    @Test(priority = 52, description = "Click on Back Button")
    public void clickOnBackButton() {
        test = extent.createTest("Click on Back Button");

        try {
            checkInPage.clickBackButton();
            test.pass("✅ Successfully clicked on the Back button.");
        } catch (Exception e) {
            test.fail("❌ Clicking on Back button failed: " + e.getMessage());
            Assert.fail("Clicking on Back button test failed!", e);
        }
    }
    @Test(priority = 53, description = "Verify Click on Nearby Places")
    public void ClickNearbyPlacesAgain() {
        test = extent.createTest("Verify Click on Nearby Places");
        try {
            checkInPage.clickNearbyPlaces();
            test.pass("✅ Successfully clicked on Nearby Places.");
        } catch (Exception e) {
            test.fail("❌ Click on Nearby Places failed: " + e.getMessage());
            Assert.fail("Nearby Places click verification test failed!", e);
        }
    }
    @Test(priority = 54, description = "Scroll to End of the Page Using UiScrollable")
    public void verifyScrollToEnd() {
        test = extent.createTest("Scroll to End of the Page");

        try {
            checkInPage.scrollToEndUsingUiScrollable();
            test.pass("✅ Successfully scrolled to the end of the page.");
        } catch (Exception e) {
            test.fail("❌ Scrolling to the end of the page failed: " + e.getMessage());
            Assert.fail("Scrolling to the end of the page test failed!", e);
        }
    }
    @Test(priority = 55, description = "Select a Random Location from Nearby Places")
    public void verifySelectRandomLocation() {
        test = extent.createTest("Select a Random Location");

        try {
            checkInPage.selectRandomLocation();
            test.pass("✅ Successfully selected a random location from nearby places.");
        } catch (Exception e) {
            test.fail("❌ Selecting a random location failed: " + e.getMessage());
            Assert.fail("Selecting a random location test failed!", e);
        }
    }
    @Test(priority = 56, description = "Click on Check-In Button")
    public void verifyClickOnCheckInButton() {
        test = extent.createTest("Click on Check-In Button");

        try {
            checkInPage.clickCheckInButton();
            test.pass("✅ Successfully clicked on the Check-In button.");
        } catch (Exception e) {
            test.fail("❌ Clicking on Check-In button failed: " + e.getMessage());
            Assert.fail("Check-In button click test failed!", e);
        }
    }

    @Test(priority = 57, description = "Verify Check-In Success Header Exists")
    public void verifyCheckInSuccessHeaderExists() {
        test = extent.createTest("Verify Check-In Success Header Exists");
        try {
            Assert.assertTrue(checkInPage.isCheckInSuccessHeaderDisplayed(), "❌ Check-In Success Header is NOT displayed!");
            test.pass("✅ Check-In Success Header is displayed.");
        } catch (Exception e) {
            test.fail("❌ Check-In Success Header verification failed: " + e.getMessage());
            Assert.fail("Check-In Success Header verification test failed!", e);
        }
    }

    @Test(priority = 58, description = "Verify Check-In Success Header Text")
    public void verifyCheckInSuccessHeaderText() {
        test = extent.createTest("Verify Check-In Success Header Text");
        try {
            Assert.assertEquals(checkInPage.getCheckInSuccessHeaderText(), "You have checked In!", "❌ Check-In Success Header text mismatch!");
            test.pass("✅ Check-In Success Header text is correct.");
        } catch (Exception e) {
            test.fail("❌ Check-In Success Header text verification failed: " + e.getMessage());
            Assert.fail("Check-In Success Header text verification test failed!", e);
        }
    }

    @Test(priority = 59, description = "Verify Check-In Message Exists")
    public void verifyCheckInMessageExists() {
        test = extent.createTest("Verify Check-In Message Exists");
        try {
            Assert.assertTrue(checkInPage.isCheckInMessageDisplayedOnPopUp(), "❌ Check-In Message is NOT displayed!");
            test.pass("✅ Check-In Message is displayed.");
        } catch (Exception e) {
            test.fail("❌ Check-In Message verification failed: " + e.getMessage());
            Assert.fail("Check-In Message verification test failed!", e);
        }
    }

    @Test(priority = 60, description = "Verify Check-In Message Text")
    public void verifyCheckInMessageText() {
        test = extent.createTest("Verify Check-In Message Text");
        try {
            Assert.assertEquals(checkInPage.getCheckInMessageTextOnPopUp(), "Thanks for letting us know where you are!", "❌ Check-In Message text mismatch!");
            test.pass("✅ Check-In Message text is correct.");
        } catch (Exception e) {
            test.fail("❌ Check-In Message text verification failed: " + e.getMessage());
            Assert.fail("Check-In Message text verification test failed!", e);
        }
    }

    @Test(priority = 61, description = "Verify Continue Button Exists")
    public void verifyContinueButtonExists() {
        test = extent.createTest("Verify Continue Button Exists");
        try {
            Assert.assertTrue(checkInPage.isContinueButtonDisplayed(), "❌ Continue button is NOT displayed!");
            test.pass("✅ Continue button is displayed.");
        } catch (Exception e) {
            test.fail("❌ Continue button verification failed: " + e.getMessage());
            Assert.fail("Continue button verification test failed!", e);
        }
    }

    @Test(priority = 62, description = "Verify Continue Button Text")
    public void verifyContinueButtonText() {
        test = extent.createTest("Verify Continue Button Text");
        try {
            Assert.assertEquals(checkInPage.getContinueButtonText(), "Continue", "❌ Continue button text mismatch!");
            test.pass("✅ Continue button text is correct.");
        } catch (Exception e) {
            test.fail("❌ Continue button text verification failed: " + e.getMessage());
            Assert.fail("Continue button text verification test failed!", e);
        }
    }

    @Test(priority = 63, description = "Click on Continue Button")
    public void clickContinueButton() {
        test = extent.createTest("Click on Continue Button");
        try {
            checkInPage.clickContinueButton();
            test.pass("✅ Successfully clicked on the Continue button.");
        } catch (Exception e) {
            test.fail("❌ Clicking on Continue button failed: " + e.getMessage());
            Assert.fail("Continue button click test failed!", e);
        }
    }
    @Test(priority = 64, description = "LogOut")
    public void CityStayUserLogin() {
    	if (extent != null) {
    	    test = extent.createTest("Logout Test");
    	}
        try {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			SignUpTest signUpTest = new SignUpTest(driver, wait, extent);
			signUpTest.Logout();
        	PreReq preReq = new PreReq(extent, wait, driver);
			preReq.CityStayUserSignIn();
        	
            checkInPage.clickCheckIn();
            checkInPage.clickCheckInButton();

        	
        	
         test.pass("LogOut.");
        } catch (Exception e) {
            test.fail("LogOut " + e.getMessage());
            Assert.fail("LogOut", e);
        }
    }
   
    @Test(priority = 64)
    public void verifyCheckInPageElements() {
        // Wait for elements to be visible and verify their text
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.globalrescue.enterprise:id/tvHeader"))).getText(),
                "You have checked In!", "Header text mismatch");

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.globalrescue.enterprise:id/tvMessage"))).getText(),
                "Thanks for letting us know where you are!", "Message text mismatch");

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.globalrescue.enterprise:id/tvMessage2"))).getText(),
                "It looks like you are not currently in your home city, Berlin.", "Message2 text mismatch");

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='How long will you be travelling?']"))).getText(),
                "How long will you be travelling?", "Travel duration text mismatch");

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='I arrived at']"))).getText(),
                "I arrived at", "Arrival text mismatch");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.globalrescue.enterprise:id/tvAutoComplete"))).isDisplayed(),
                "AutoComplete field is not visible");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='on']"))).isDisplayed(),
                "Text 'on' is not visible");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.globalrescue.enterprise:id/days_text"))).isDisplayed(),
                "Days text is not visible");

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.globalrescue.enterprise:id/tv_btnCancel"))).getText(),
                "Skip", "Skip button text mismatch");

        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.id("com.globalrescue.enterprise:id/btnConfirm"))).getText(),
                "Save Travel", "Confirm button text mismatch");
      checkInPage.clickContinueButton();

      
    }
    
    
    @Test(priority = 66)
    public void verifyANDdeleteCityStay() throws InterruptedException {
    	WebPortal webPortal = new WebPortal();
		webPortal.CityStayCheck();
    }
   
}
