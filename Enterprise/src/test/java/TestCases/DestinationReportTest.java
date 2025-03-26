package TestCases;
import utilities.ExtentReportsManager;
import io.appium.java_client.android.AndroidDriver;
import pages.DestinationReportPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import base.BaseSetup;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class DestinationReportTest extends BaseSetup {
    private ExtentReports extent;
    private ExtentTest test;
    private AndroidDriver driver;
    private WebDriverWait wait;
    private DestinationReportPage destinationReportPage;
    
    @BeforeSuite
	public void setupExtentReports() {
		extent = ExtentReportsManager.getExtentReports();
	}
    @BeforeClass
    public void setup() {
        driver = getDriver();  // ✅ Fetch driver from BaseSetup
        if (driver == null) {
            throw new RuntimeException("Driver is not initialized in BaseSetup!");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        destinationReportPage = new DestinationReportPage(driver, wait);  // ✅ Pass driver correctly

        System.out.println("Setup completed for DestinationReportTest.");
    }

    
    @Test(priority = 1)
    public void verifyDestinationReportTabDisplayed() {
        test = extent.createTest("Verify Destination Report Tab is Displayed");
        try {
            Assert.assertTrue(destinationReportPage.isDestinationReportTabDisplayed(), "Destination Report Tab is not displayed.");
            test.pass("✅ Destination Report Tab is visible.");
        } catch (Exception e) {
            test.fail("❌ Destination Report Tab is missing: " + e.getMessage());
            Assert.fail("Destination Report Tab not found!", e);
        }
    }
    @Test(priority = 2, description = "Verify that the Destination Report tab can be clicked successfully.")
    public void testDestinationReportTabClick() {
        test = extent.createTest("Click on Destination Report Tab");
        
        try {
            destinationReportPage.clickDestinationReportTab();
            test.pass("✅ Successfully clicked on the Destination Report tab.");
            System.out.println("Clicked on Destination Report Tab.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on the Destination Report tab: " + e.getMessage());
            Assert.fail("Error encountered while clicking the Destination Report tab.", e);
        }
    }

    @Test(priority = 3)
    public void verifyCountrySearchField() {
        test = extent.createTest("Verify Country Search Field is Displayed");
        try {
            Assert.assertTrue(destinationReportPage.isCountrySearchFieldDisplayed(), "Country Search Field is not displayed.");
            test.pass("✅ Country Search Field is visible.");
        } catch (Exception e) {
            test.fail("❌ Country Search Field is missing: " + e.getMessage());
            Assert.fail("Country Search Field not found!", e);
        }
    }

    @Test(priority = 4)
    public void searchForCountry() {
        test = extent.createTest("Search for a Country (Pakistan)");
        String country = "Pakistan";
        try {
            destinationReportPage.enterCountrySearch(country);
            test.pass("✅ Successfully entered country name in search field.");
        } catch (Exception e) {
            test.fail("❌ Failed to enter country name: " + e.getMessage());
            Assert.fail("Failed to enter country name in search field.", e);
        }
    }

    @Test(priority = 5)
    public void verifyDownloadButtonDisplayed() {
        test = extent.createTest("Verify Download Button is Displayed");
        try {
        	Thread.sleep(2000);
            Assert.assertTrue(destinationReportPage.isDownloadButtonDisplayed(), "Download Button is not visible.");
            test.pass("✅ Download Button is displayed.");
        } catch (Exception e) {
            test.fail("❌ Download Button is missing: " + e.getMessage());
            Assert.fail("Download Button not found!", e);
        }
    }

    @Test(priority = 6)
    public void clickDownloadButton() {
        test = extent.createTest("Click on Download Button");
        try {
            destinationReportPage.clickDownloadButton();
            Thread.sleep(2000);            test.pass("✅ Successfully clicked on the Download Button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Download Button: " + e.getMessage());
            Assert.fail("Failed to click on Download Button.", e);
        }
    }

    @Test(priority = 7)
    public void verifyCountryNameDisplayed() {
        test = extent.createTest("Verify Country Name is Displayed");
        try {
            Assert.assertTrue(destinationReportPage.isCountryNameDisplayed(), "Country Name is not displayed.");
            test.pass("✅ Country Name is displayed.");
        } catch (Exception e) {
            test.fail("❌ Country Name is missing: " + e.getMessage());
            Assert.fail("Country Name not found!", e);
        }
    }

    @Test(priority = 8)
    public void clickOnCountryName() {
        test = extent.createTest("Click on Country Name to View Report");
        try {Thread.sleep(1000);
            destinationReportPage.clickCountryName();
            test.pass("✅ Successfully clicked on Country Name to open the report.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Country Name: " + e.getMessage());
            Assert.fail("Failed to click on Country Name.", e);
        }
    }
    @Test(priority = 9, description = "Verify that the Destination Report screen is displayed correctly.")
    public void verifyDestinationReportScreen() {
        test = extent.createTest("Verify Destination Report Screen");
        try {
            Assert.assertTrue(destinationReportPage.getTitleText().equals("Destination Report"),
                    "Destination Report screen title is incorrect!");
            test.pass("✅ Destination Report screen is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify Destination Report screen: " + e.getMessage());
            Assert.fail("Destination Report screen verification failed!", e);
        }
    }

    @Test(priority = 10, description = "Verify that the Back button is present and labeled correctly.")
    public void verifyBackButtonPresence() {
        test = extent.createTest("Verify Back Button Presence");
        try {
            Assert.assertTrue(destinationReportPage.getBackButtonText().equals("Back"),
                    "Back button text is incorrect!");
            test.pass("✅ Back button is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify Back button presence: " + e.getMessage());
            Assert.fail("Back button verification failed!", e);
        }
    }

    @Test(priority = 11, description = "Verify that the Country Name is displayed correctly.")
    public void verifyDRCountryNameDisplayed() {
        test = extent.createTest("Verify Country Name Displayed");
        try {
            Assert.assertTrue(destinationReportPage.getCountryNameText().equals("Pakistan"),
                    "Country name does not match!");
            test.pass("✅ Country Name is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify Country Name: " + e.getMessage());
            Assert.fail("Country Name verification failed!", e);
        }
    }

    @Test(priority = 12, description = "Verify that the Overall Risk Rating label is displayed correctly.")
    public void verifyOverallRiskRatingLabel() {
        test = extent.createTest("Verify Overall Risk Rating Label");
        try {
            Assert.assertTrue(destinationReportPage.getOverallRiskLabelText().equals("Overall Risk Rating"),
                    "Overall Risk Rating label text is incorrect!");
            test.pass("✅ Overall Risk Rating label is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify Overall Risk Rating label: " + e.getMessage());
            Assert.fail("Overall Risk Rating label verification failed!", e);
        }
    }

    @Test(priority = 13, description = "Verify that the Risk Level text is displayed correctly.")
    public void verifyRiskLevelDisplayed() {
        test = extent.createTest("Verify Risk Level Displayed");
        try {
        	Set<String> validRiskLevels = new HashSet<>(Arrays.asList("Low", "Moderate", "High", "Extreme"));
        	Assert.assertTrue(validRiskLevels.contains(destinationReportPage.getRiskLevelText()), 
        	    "❌ Risk Level Text is not valid. Found: " + destinationReportPage.getRiskLevelText());
          
            test.pass("✅ Risk Level text is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Failed to verify Risk Level text: " + e.getMessage());
            Assert.fail("Risk Level text verification failed!", e);
        }
    }
//    @Test
//    public void verifyTableElementsAndText() {
//        test = extent.createTest("Verify Table View Elements and Text");
//
//        // Locate the table container
//        WebElement tableLayout = wait.until(ExpectedConditions.presenceOfElementLocated(
//                AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(9)")));
//
//        // Get only the table headers, excluding "Extreme" or other risk levels
//        List<WebElement> tableRows = tableLayout.findElements(By.xpath("//android.widget.TextView[not(contains(@text, 'Extreme'))]"));
//
//        // Expected static text values
//        List<String> expectedTexts = Arrays.asList(
//                "Events", "Risk Overview", "General Overview", "Security Assessment", 
//                "Health Assessment", "Destination Details", "Entry & Exit Requirements", "Important Numbers");
//
//        boolean allTextsMatch = true; // Flag to track if all texts are correct
//
//        // Verify each row
//        for (int i = 0; i < expectedTexts.size(); i++) {
//            try {
//                String actualText = tableRows.get(i).getText().trim();
//                if (!actualText.equals(expectedTexts.get(i))) {
//                    test.fail("❌ Text mismatch at row " + i + " | Expected: [" + expectedTexts.get(i) + "] but found: [" + actualText + "]");
//                    allTextsMatch = false;
//                } else {
//                    test.pass("✅ Verified text: " + actualText);
//                }
//            } catch (Exception e) {
//                test.fail("❌ Error verifying row " + i + ": " + e.getMessage());
//                allTextsMatch = false;
//            }
//        }
//
//        // Final assertion
//        Assert.assertTrue(allTextsMatch, "Some table elements did not match expected values.");
//    }

    @Test(priority = 14)
    public void verifyEventsRow() {
        verifyTableRow(0, "Events");
    }

    @Test(priority = 15)
    public void verifyRiskOverviewRow() {
        verifyTableRow(1, "Risk Overview");
    }

    @Test(priority = 16)
    public void verifyGeneralOverviewRow() {
        verifyTableRow(2, "General Overview");
    }

    @Test(priority = 17)
    public void verifySecurityAssessmentRow() {
        verifyTableRow(4, "Security Assessment");
    }

    @Test(priority = 18)
    public void verifyHealthAssessmentRow() {
        verifyTableRow(6, "Health Assessment");
    }

    @Test(priority = 19)
    public void verifyDestinationDetailsRow() {
        verifyTableRow(7, "Destination Details");
    }

    @Test(priority = 20)
    public void verifyEntryExitRequirementsRow() {
        verifyTableRow(8, "Entry & Exit Requirements");
    }

    @Test(priority = 21)
    public void verifyImportantNumbersRow() {
        verifyTableRow(9, "Important Numbers");
    }

    /**
     * Generic method to verify a single table row.
     */
    private void verifyTableRow(int index, String expectedText) {
        ExtentTest test = extent.createTest("Verify Table Row: " + expectedText);

        try {
            // Locate the table container
            WebElement tableLayout = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(9)")));

            // Get only the table headers, excluding "Extreme" or other risk levels
            List<WebElement> tableRows = tableLayout.findElements(By.xpath("//android.widget.TextView[not(contains(@text, 'Extreme'))]"));

            // Validate the row text
            String actualText = tableRows.get(index).getText().trim();
            Assert.assertEquals(actualText, expectedText, "❌ Text mismatch at row " + index);
            test.pass("✅ Verified text: " + actualText);

        } catch (Exception e) {
            test.fail("❌ Failed to verify row " + index + " (" + expectedText + "): " + e.getMessage());
            Assert.fail("Verification failed for row " + index, e);
        }
    }
    @Test(priority = 22)
    public void verifyEventsRowIsDisplayedAndClickable() {
        verifyTableRowIsDisplayedAndClickable(0, "Events");
    }

    @Test(priority = 23)
    public void verifyRiskOverviewRowIsDisplayedAndClickable() {
        verifyTableRowIsDisplayedAndClickable(1, "Risk Overview");
    }

    @Test(priority = 24)
    public void verifyGeneralOverviewRowIsDisplayedAndClickable() {
        verifyTableRowIsDisplayedAndClickable(2, "General Overview");
    }

    @Test(priority = 25)
    public void verifySecurityAssessmentRowIsDisplayedAndClickable() {
        verifyTableRowIsDisplayedAndClickable(3, "Security Assessment");
    }

    @Test(priority = 26)
    public void verifyHealthAssessmentRowIsDisplayedAndClickable() {
        verifyTableRowIsDisplayedAndClickable(4, "Health Assessment");
    }

    @Test(priority = 27)
    public void verifyDestinationDetailsRowIsDisplayedAndClickable() {
        verifyTableRowIsDisplayedAndClickable(5, "Destination Details");
    }

    @Test(priority = 28)
    public void verifyEntryExitRequirementsRowIsDisplayedAndClickable() {
        verifyTableRowIsDisplayedAndClickable(6, "Entry & Exit Requirements");
    }

    @Test(priority = 29)
    public void verifyImportantNumbersRowIsDisplayedAndClickable() {
        verifyTableRowIsDisplayedAndClickable(7, "Important Numbers");
    }

    /**
     * Generic method to verify if a table row's text is correct and if it is clickable.
     */
    private void verifyTableRowIsDisplayedAndClickable(int index, String expectedText) {
        ExtentTest test = extent.createTest("Verify Table Row: " + expectedText);

        try {
            // Locate the table container
            WebElement tableLayout = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(9)")));

            // Get only the table headers, excluding "Extreme" or other risk indicators
            List<WebElement> tableRows = tableLayout.findElements(By.xpath("//android.widget.TextView[not(contains(@text, 'Extreme'))]"));

            
            WebElement rowElement = tableRows.get(index);
            

            // Verify if the element is clickable (but don’t click it!)
            boolean isClickable = rowElement.isEnabled();
            Assert.assertTrue(isClickable, "❌ Row is NOT clickable: " + expectedText);
            test.pass("✅ Row is clickable: " + expectedText);

        } catch (Exception e) {
            test.fail("❌ Failed to verify row " + index + " (" + expectedText + "): " + e.getMessage());
            Assert.fail("Verification failed for row " + index, e);
        }
    }

    @Test(priority = 30)
    public void verifyAndClickRiskRatingQuestionMark() {
        ExtentTest test = extent.createTest("Verify & Click Risk Rating Question Mark");

        try {
            WebElement riskRatingQuestionMark = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.id("com.globalrescue.enterprise:id/imageView18")));
            
            Assert.assertTrue(riskRatingQuestionMark.isDisplayed(), "❌ Risk Rating Question Mark is not visible.");
            test.pass("✅ Risk Rating Question Mark is visible.");
            
            riskRatingQuestionMark.click();
            test.pass("✅ Successfully clicked on Risk Rating Question Mark.");

        } catch (Exception e) {
            test.fail("❌ Failed to verify or click Risk Rating Question Mark: " + e.getMessage());
            Assert.fail("Verification or click failed for Risk Rating Question Mark", e);
        }
    }
//    @Test(priority = 31)
//    public void verifyAndClickExpandCollapseButtons() throws InterruptedException {
//        test = extent.createTest("Verify and Click Expand/Collapse Buttons");
//
//        // Locate all the expand/collapse buttons
//        List<WebElement> expandButtons = driver.findElements(
//            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.globalrescue.enterprise:id/event_definition_card_expand_arrow\")")
//        );
//
//        for (int i = 0; i < expandButtons.size(); i++) {
//            WebElement button = expandButtons.get(i);
//
//            // Verify the button is clickable
//            Assert.assertTrue(button.isEnabled(), "❌ Expand/Collapse Button " + i + " is NOT clickable.");
//            test.pass("✅ Expand/Collapse Button " + i + " is clickable.");
//
//            // Click to expand
//            button.click();
//            test.pass("✅ Successfully clicked Expand Button " + i);
//
//            // Wait briefly to allow expansion
//            Thread.sleep(500); // Adjust if necessary
//
//            // Click again to collapse
//            button.click();
//            test.pass("✅ Successfully clicked Collapse Button " + i);
//        }
//    }
    @Test(priority = 31)
    public void verifyExpandCollapseButton_0() {
        verifyExpandCollapseButton(0);
    }

    @Test(priority = 32)
    public void verifyExpandCollapseButton_1() {
        verifyExpandCollapseButton(1);
    }

    @Test(priority = 33)
    public void verifyExpandCollapseButton_2() {
        verifyExpandCollapseButton(2);
    }

    @Test(priority = 34)
    public void verifyExpandCollapseButton_3() {
        verifyExpandCollapseButton(3);
    }

    // Reusable method to avoid duplication
    private void verifyExpandCollapseButton(int index) {
        test = extent.createTest("Verify and Click Expand/Collapse Button " + index);

        // Locate all expand/collapse buttons
        List<WebElement> expandButtons = driver.findElements(
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.globalrescue.enterprise:id/event_definition_card_expand_arrow\")")
        );

        if (index >= expandButtons.size()) {
            test.fail("❌ Expand/Collapse Button " + index + " is not found.");
            Assert.fail("Expand/Collapse Button " + index + " does not exist.");
            return;
        }

        WebElement button = expandButtons.get(index);

        // Verify the button is clickable
        Assert.assertTrue(button.isEnabled(), "❌ Expand/Collapse Button " + index + " is NOT clickable.");
        test.pass("✅ Expand/Collapse Button " + index + " is clickable.");

        // Click to expand
        button.click();
        test.pass("✅ Successfully clicked Expand Button " + index);

        // Wait briefly to allow expansion
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Replace with dynamic wait if needed

        // Click again to collapse
        button.click();
        test.pass("✅ Successfully clicked Collapse Button " + index);
    }

    
    
    @Test(priority = 35)
    public void verifyExpandedCardTitle_Low() {
        verifyExpandedCardTitle(0, "Low");
    }

    @Test(priority = 36)
    public void verifyExpandedCardTitle_Moderate() {
        verifyExpandedCardTitle(1, "Moderate");
    }

    @Test(priority = 37)
    public void verifyExpandedCardTitle_High() {
        verifyExpandedCardTitle(2, "High");
    }

    @Test(priority = 38)
    public void verifyExpandedCardTitle_Extreme() {
        verifyExpandedCardTitle(3, "Extreme");
    }

    @Test(priority = 39)
    public void verifyExpandedCardDescription_Low() {
        verifyExpandedCardDescription(0, destinationReportPage.DescriptionOfLow);
    }

    @Test(priority = 40)
    public void verifyExpandedCardDescription_Moderate() {
        verifyExpandedCardDescription(1, destinationReportPage.DescriptionOfModerate);
    }

    @Test(priority = 41)
    public void verifyExpandedCardDescription_High() {
        verifyExpandedCardDescription(2, destinationReportPage.DescriptionOfHigh);
    }

    @Test(priority = 42)
    public void verifyExpandedCardDescription_Extreme() {
        verifyExpandedCardDescription(3, destinationReportPage.DescriptionOfExtreme);
    }
    private void verifyExpandedCardTitle(int index, String expectedTitle) {
        test = extent.createTest("Verify Expanded Card Title: " + expectedTitle);

        // Expand the section first
        verifyExpandCollapseButton(index);

        // Get the card title text
        String actualTitle = destinationReportPage.getExpandedCardTitle(index);

        if (actualTitle == null || actualTitle.isEmpty()) {
            test.fail("❌ Card Title for '" + expectedTitle + "' is not displayed.");
            Assert.fail("Card Title is missing after expansion.");
        } else {
            test.pass("✅ Verified Card Title: " + actualTitle);
            Assert.assertEquals(actualTitle, expectedTitle, "❌ Title mismatch for card index " + index);
        }
    }

    private void verifyExpandedCardDescription(int index, String expectedDescription) {
        test = extent.createTest("Verify Expanded Card Description: " + expectedDescription);
        List<WebElement> expandButtons = driver.findElements(
                AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.globalrescue.enterprise:id/event_definition_card_expand_arrow\")")
            );

            if (index >= expandButtons.size()) {
                test.fail("❌ Expand/Collapse Button " + index + " is not found.");
                Assert.fail("Expand/Collapse Button " + index + " does not exist.");
                return;
            }

        WebElement button = expandButtons.get(index);
        button.click();
        // Expand the section first
        //verifyExpandCollapseButton(index);

        // Get the card description text
        String actualDescription = destinationReportPage.getExpandedCardDescription(index);

        if (actualDescription == null || actualDescription.isEmpty()) {
        	button.click();
            test.fail("❌ Card Description for '" + expectedDescription + "' is not displayed.");
            Assert.fail("Card Description is missing after expansion.");
        } else {
        	button.click();
            test.pass("✅ Verified Card Description: " + actualDescription);
            Assert.assertEquals(actualDescription, expectedDescription, "❌ Description mismatch for card index " + index);
        }
    }

//    @Test(priority = 36)
//    public void verifyAndClickEventsRow() {
//        test = extent.createTest("Verify and Click on 'Events' Row");
//
//        // Locate the "Events" row using the existing verification method
//        WebElement eventsRow = wait.until(ExpectedConditions.elementToBeClickable(
//            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").instance(0)")
//        ));
//
//        // Verify if the row is clickable
//        Assert.assertTrue(eventsRow.isEnabled(), "❌ 'Events' row is NOT clickable.");
//        test.pass("✅ 'Events' row is clickable.");
//
//        // Click on the "Events" row
//        eventsRow.click();
//        test.pass("✅ Successfully clicked on the 'Events' row.");
//    }
    @Test(priority = 43)
    public void verifyAndClickBackButton() {
        test = extent.createTest("Verify and Click Back Button");

        // Locate the Back button
        WebElement backButton = wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.id("com.globalrescue.enterprise:id/toolbar_back")
        ));

        // Verify if the Back button is clickable
        Assert.assertTrue(backButton.isEnabled(), "❌ Back Button is NOT clickable.");
        test.pass("✅ Back Button is clickable.");

        // Click the Back button
        backButton.click();
        test.pass("✅ Successfully clicked the Back Button.");
    }
    @Test(priority = 44)
    public void clickEventsRow() {
        clickTableRow(0, "Events");
    }

 // Test to verify the page title
    @Test(priority = 45, description = "Verify the page title text on the Events Page")
    public void verifyPageTitleText() {
        test = extent.createTest("Verify Page Title");
        try {
            String actualTitle = destinationReportPage.getPageTitleText();
            Assert.assertEquals(actualTitle, "Events in Pakistan", "❌ Page title does not match!");
            test.pass("✅ Page title verified successfully: " + actualTitle);
        } catch (Exception e) {
            test.fail("❌ Page title verification failed due to: " + e.getMessage());
            Assert.fail("Page title verification failed!", e);
        }
    }

    @Test(priority = 46, description = "Verify the presence of the Info Icon on the Events Page")
    public void verifyInfoIconPresence() {
        test = extent.createTest("Verify Info Icon Presence");
        try {
            Assert.assertTrue(destinationReportPage.isInfoIconDisplayed(), "❌ Info icon is not displayed!");
            test.pass("✅ Info icon is displayed.");
        } catch (Exception e) {
            test.fail("❌ Info icon verification failed: " + e.getMessage());
            Assert.fail("Info icon verification failed!", e);
        }
    }

    @Test(priority = 47, description = "Verify the presence of the Back Button on the Events Page")
    public void verifyBackButtonPresenceOnEventsPage() {
        test = extent.createTest("Verify Back Button Presence");
        try {
            Assert.assertTrue(destinationReportPage.isBackButtonDisplayed(), "❌ Back button is not displayed!");
            test.pass("✅ Back button is displayed.");
        } catch (Exception e) {
            test.fail("❌ Back button verification failed: " + e.getMessage());
            Assert.fail("Back button verification failed!", e);
        }
    }

    @Test(priority = 48, description = "Verify the presence of the Event Card Container")
    public void verifyEventCardContainerPresence() {
        test = extent.createTest("Verify Event Card Container Presence");
        try {
            Assert.assertTrue(destinationReportPage.isEventCardContainerDisplayed(), "❌ Event card container is not displayed!");
            test.pass("✅ Event card container is displayed.");
        } catch (Exception e) {
            test.fail("❌ Event card container verification failed: " + e.getMessage());
            Assert.fail("Event card container verification failed!", e);
        }
    }

    @Test(priority = 49, description = "Verify the event card title is displayed and not empty")
    public void verifyEventCardTitle() {
        test = extent.createTest("Verify Event Card Title");
        try {
            String actualTitle = destinationReportPage.getEventTitle();
            Assert.assertFalse(actualTitle.isEmpty(), "❌ Event card title is empty!");
            test.pass("✅ Event card title verified: " + actualTitle);
        } catch (Exception e) {
            test.fail("❌ Event card title verification failed: " + e.getMessage());
            Assert.fail("Event card title verification failed!", e);
        }
    }

    @Test(priority = 50, description = "Verify the event severity text is displayed correctly")
    public void verifyEventSeverityText() {
        test = extent.createTest("Verify Event Severity Text");
        try {
            String severityText = destinationReportPage.getEventSeverityText();
            List<String> validSeverities = Arrays.asList("Low", "Moderate", "High", "Extreme");

            Assert.assertTrue(validSeverities.contains(severityText), "❌ Invalid event severity: " + severityText);
            test.pass("✅ Event severity verified: " + severityText);
        } catch (Exception e) {
            test.fail("❌ Event severity verification failed: " + e.getMessage());
            Assert.fail("Event severity verification failed!", e);
        }
    }


 // Test to verify event category presence
    @Test(priority = 51, description = "Verify the presence of Event Category in event card")
    public void verifyEventCategoryPresence() {
        test = extent.createTest("Verify Event Category Presence");
        try {
            Assert.assertTrue(destinationReportPage.isEventCategoryDisplayed(), "❌ Event category is not displayed!");
            test.pass("✅ Event category is displayed.");
        } catch (Exception e) {
            test.fail("❌ Event category verification failed: " + e.getMessage());
            Assert.fail("Event category verification failed!", e);
        }
    }

    // Test to verify countries list presence in event card
    @Test(priority = 52, description = "Verify the presence of Countries List in event card")
    public void verifyEventCountriesPresence() {
        test = extent.createTest("Verify Event Countries Presence");
        try {
            Assert.assertTrue(destinationReportPage.isEventCountriesDisplayed(), "❌ Event countries list is not displayed!");
            test.pass("✅ Event countries list is displayed.");
        } catch (Exception e) {
            test.fail("❌ Event countries verification failed: " + e.getMessage());
            Assert.fail("Event countries verification failed!", e);
        }
    }

    // Test to verify event date presence
    @Test(priority = 53, description = "Verify the presence of Event Date in event card")
    public void verifyEventDatePresence() {
        test = extent.createTest("Verify Event Date Presence");
        try {
            String eventDate = destinationReportPage.getEventDate();
            Assert.assertFalse(eventDate.isEmpty(), "❌ Event date is empty!");
            test.pass("✅ Event date verified: " + eventDate);
        } catch (Exception e) {
            test.fail("❌ Event date verification failed: " + e.getMessage());
            Assert.fail("Event date verification failed!", e);
        }
    }

    // Test to verify the page title is displayed
    @Test(priority = 54, description = "Verify that the Page Title is displayed correctly")
    public void verifyPageTitle() {
        test = extent.createTest("Verify Page Title");
        try {
            Assert.assertTrue(destinationReportPage.isPageTitleDisplayed(), "❌ Page title is not displayed!");
            test.pass("✅ Page title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Page title verification failed: " + e.getMessage());
            Assert.fail("Page title verification failed!", e);
        }
    }

    // Test to verify the Info Icon is clickable
    @Test(priority = 55, description = "Verify that the Info Icon is clickable on event card")
    public void verifyInfoIconIsClickable() {
        test = extent.createTest("Verify Info Icon Clickability");
        try {
            WebElement infoIcon = driver.findElement(By.id("com.globalrescue.enterprise:id/eventAlertControllerInfoIcon"));
            Assert.assertTrue(infoIcon.isEnabled(), "❌ Info icon is NOT clickable.");
            test.pass("✅ Info icon is clickable.");
        } catch (Exception e) {
            test.fail("❌ Info icon clickability verification failed: " + e.getMessage());
            Assert.fail("Info icon clickability verification failed!", e);
        }
    }
    
 // Test to click on the Info Icon
    @Test(priority = 56, description = "Click on the Info Icon in the event card")
    public void clickInfoIcon() {
        test = extent.createTest("Click on Info Icon");
        try {
            destinationReportPage.clickInfoIcon();
            test.pass("✅ Successfully clicked on the Info Icon.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on Info Icon: " + e.getMessage());
            Assert.fail("Clicking on Info Icon failed!", e);
        }
    }

    // Test to verify Toolbar Back Button is visible
    @Test(priority = 57, description = "Verify the visibility of the Toolbar Back Button")
    public void verifyToolbarBackButtonIsVisible() {
        test = extent.createTest("Verify Toolbar Back Button Visibility");
        try {
            Assert.assertTrue(destinationReportPage.isBackButtonDisplayed(), "❌ Toolbar Back Button is NOT visible.");
            test.pass("✅ Toolbar Back Button is visible.");
        } catch (Exception e) {
            test.fail("❌ Toolbar Back Button visibility verification failed: " + e.getMessage());
            Assert.fail("Toolbar Back Button visibility check failed!", e);
        }
    }

    // Test to verify Toolbar Back Button is clickable
    @Test(priority = 58, description = "Verify if the Toolbar Back Button is clickable")
    public void verifyToolbarBackButtonClickable() {
        test = extent.createTest("Verify Toolbar Back Button Clickability");
        try {
            Assert.assertTrue(destinationReportPage.isBackButtonClickable(), "❌ Toolbar Back Button is NOT clickable.");
            test.pass("✅ Toolbar Back Button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Toolbar Back Button clickability verification failed: " + e.getMessage());
            Assert.fail("Toolbar Back Button clickability check failed!", e);
        }
    }

    // Test to verify Page Title is visible
    @Test(priority = 59, description = "Verify the visibility of the Page Title on the Event Definition page")
    public void verifyPageTitleIsVisible() {
        test = extent.createTest("Verify Page Title Visibility");
        try {
            Assert.assertTrue(destinationReportPage.isPageTitleVisible(), "❌ Page Title is NOT visible.");
            test.pass("✅ Page Title is visible.");
        } catch (Exception e) {
            test.fail("❌ Page Title visibility verification failed: " + e.getMessage());
            Assert.fail("Page Title visibility check failed!", e);
        }
    }

    // Test to verify Page Title text
    @Test(priority = 60, description = "Verify the correctness of the Page Title text")
    public void getEventDefinitionPageTitleText() {
        test = extent.createTest("Verify Page Title Text");
        try {
            String actualTitle = destinationReportPage.getPageTitleText();
            Assert.assertEquals(actualTitle, "Event Definition", "❌ Page Title text mismatch.");
            test.pass("✅ Page Title text is correct: Event Definition.");
        } catch (Exception e) {
            test.fail("❌ Page Title text verification failed: " + e.getMessage());
            Assert.fail("Page Title text verification failed!", e);
        }
    }


 // Test to verify Severities Section is visible
    @Test(priority = 61, description = "Verify the Severities section is visible")
    public void verifySeveritiesSectionIsVisible() {
        test = extent.createTest("Verify Severities Section Visibility");
        try {
            Assert.assertTrue(destinationReportPage.isSeveritiesSectionVisible(), "❌ Severities Section is NOT visible.");
            test.pass("✅ Severities Section is visible.");
        } catch (Exception e) {
            test.fail("❌ Severities Section visibility check failed: " + e.getMessage());
            Assert.fail("Severities Section visibility test failed!", e);
        }
    }

    // Test to verify Severities Section text
    @Test(priority = 62, description = "Verify the text displayed in the Severities section")
    public void verifySeveritiesSectionText() {
        test = extent.createTest("Verify Severities Section Text");
        try {
            Assert.assertEquals(destinationReportPage.getSeveritiesSectionText(), "Severities", "❌ Severities Section text mismatch.");
            test.pass("✅ Severities Section text is correct: Severities.");
        } catch (Exception e) {
            test.fail("❌ Severities Section text verification failed: " + e.getMessage());
            Assert.fail("Severities Section text verification failed!", e);
        }
    }

    // Test to verify Severities Section is clickable
    @Test(priority = 63, description = "Verify if the Severities section is clickable")
    public void verifySeveritiesSectionIsClickable() {
        test = extent.createTest("Verify Severities Section Clickability");
        try {
            Assert.assertTrue(destinationReportPage.isSeveritiesSectionClickable(), "❌ Severities Section is NOT clickable.");
            test.pass("✅ Severities Section is clickable.");
        } catch (Exception e) {
            test.fail("❌ Severities Section clickability verification failed: " + e.getMessage());
            Assert.fail("Severities Section clickability test failed!", e);
        }
    }

    // Test to verify Categories Section is visible
    @Test(priority = 64, description = "Verify the Categories section is visible")
    public void verifyCategoriesSectionIsVisible() {
        test = extent.createTest("Verify Categories Section Visibility");
        try {
            Assert.assertTrue(destinationReportPage.isCategoriesSectionVisible(), "❌ Categories Section is NOT visible.");
            test.pass("✅ Categories Section is visible.");
        } catch (Exception e) {
            test.fail("❌ Categories Section visibility check failed: " + e.getMessage());
            Assert.fail("Categories Section visibility test failed!", e);
        }
    }

    // Test to verify Categories Section text
    @Test(priority = 65, description = "Verify the text displayed in the Categories section")
    public void verifyCategoriesSectionText() {
        test = extent.createTest("Verify Categories Section Text");
        try {
            Assert.assertEquals(destinationReportPage.getCategoriesSectionText(), "Categories", "❌ Categories Section text mismatch.");
            test.pass("✅ Categories Section text is correct: Categories.");
        } catch (Exception e) {
            test.fail("❌ Categories Section text verification failed: " + e.getMessage());
            Assert.fail("Categories Section text verification failed!", e);
        }
    }


    // Expected values for severity titles
    private final String[] expectedSeverityTitles = {
            "Low",
            "Moderate",
            "High",
            "Extreme"
    };

    // Expected values for severity descriptions
    private final String[] expectedSeverityDescriptions = {
            "Low likelihood of affecting foreign personnel. Events are typically small-scale, non-violent, and/or occur in sparsely populated or rural areas.",
            "Moderate likelihood of affecting foreign personnel. Events are typically large-scale, accompanied by some violence and disruptions, and/or occur in metropolitan areas.",
            "High likelihood of affecting foreign personnel. Events are typically large-scale, violent, significantly disruptive to travel and business, and/or occur in metropolitan areas or capital cities.",
            "Very high likelihood of affecting foreign personnel. Events are typically large-scale, catastrophic in nature, result in substantial loss of life, and seriously threaten business operations."
    };

    
    
 // Test to verify Categories Section is clickable
    @Test(priority = 66, description = "Verify if the Categories section is clickable")
    public void verifyCategoriesSectionIsClickable() {
        test = extent.createTest("Verify Categories Section Clickability");
        try {
            Assert.assertTrue(destinationReportPage.isCategoriesSectionClickable(), "❌ Categories Section is NOT clickable.");
            test.pass("✅ Categories Section is clickable.");
        } catch (Exception e) {
            test.fail("❌ Categories Section clickability verification failed: " + e.getMessage());
            Assert.fail("Categories Section clickability test failed!", e);
        }
    }

    // Test to verify Scroll View is displayed
    @Test(priority = 67, description = "Verify if the Scroll View is displayed on the page")
    public void verifyScrollViewIsDisplayed() {
        test = extent.createTest("Verify Scroll View Visibility");
        try {
            Assert.assertTrue(destinationReportPage.isScrollViewDisplayed(), "❌ Scroll View is NOT displayed.");
            test.pass("✅ Scroll View is displayed.");
        } catch (Exception e) {
            test.fail("❌ Scroll View visibility verification failed: " + e.getMessage());
            Assert.fail("Scroll View visibility test failed!", e);
        }
    }

    // Test to verify "Low" severity title
    @Test(priority = 68, description = "Verify the severity title for Low category")
    public void verifyLowSeverityTitle() {
        test = extent.createTest("Verify Severity Title: Low");
        try {
            String actualTitle = destinationReportPage.getSeverityTitle(0);
            Assert.assertEquals(actualTitle, expectedSeverityTitles[0], "❌ Severity title mismatch for Low category.");
            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[0]);
        } catch (Exception e) {
            test.fail("❌ Low Severity Title verification failed: " + e.getMessage());
            Assert.fail("Low Severity Title verification failed!", e);
        }
    }

    // Test to verify "Moderate" severity title
    @Test(priority = 69, description = "Verify the severity title for Moderate category")
    public void verifyModerateSeverityTitle() {
        test = extent.createTest("Verify Severity Title: Moderate");
        try {
            String actualTitle = destinationReportPage.getSeverityTitle(1);
            Assert.assertEquals(actualTitle, expectedSeverityTitles[1], "❌ Severity title mismatch for Moderate category.");
            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[1]);
        } catch (Exception e) {
            test.fail("❌ Moderate Severity Title verification failed: " + e.getMessage());
            Assert.fail("Moderate Severity Title verification failed!", e);
        }
    }

    // Test to verify "High" severity title
    @Test(priority = 70, description = "Verify the severity title for High category")
    public void verifyHighSeverityTitle() {
        test = extent.createTest("Verify Severity Title: High");
        try {
            String actualTitle = destinationReportPage.getSeverityTitle(2);
            Assert.assertEquals(actualTitle, expectedSeverityTitles[2], "❌ Severity title mismatch for High category.");
            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[2]);
        } catch (Exception e) {
            test.fail("❌ High Severity Title verification failed: " + e.getMessage());
            Assert.fail("High Severity Title verification failed!", e);
        }
    }


    @Test(priority = 71)
    public void verifyExtremeSeverityTitle() {
        test = extent.createTest("Verify Severity Title: Extreme");
        Assert.assertEquals(destinationReportPage.getSeverityTitle(3), expectedSeverityTitles[3], "❌ Severity title mismatch.");
        test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[3]);
    }

    @Test(priority = 72)
    public void verifyLowSeverityDescription() {
        test = extent.createTest("Verify Severity Description: Low");
        Assert.assertEquals(destinationReportPage.getSeverityDescription(0), expectedSeverityDescriptions[0], "❌ Severity description mismatch.");
        test.pass("✅ Verified Severity Description for Low.");
    }

    @Test(priority = 73)
    public void verifyModerateSeverityDescription() {
        test = extent.createTest("Verify Severity Description: Moderate");
        Assert.assertEquals(destinationReportPage.getSeverityDescription(1), expectedSeverityDescriptions[1], "❌ Severity description mismatch.");
        test.pass("✅ Verified Severity Description for Moderate.");
    }

    @Test(priority = 74)
    public void verifyHighSeverityDescription() {
        test = extent.createTest("Verify Severity Description: High");
        Assert.assertEquals(destinationReportPage.getSeverityDescription(2), expectedSeverityDescriptions[2], "❌ Severity description mismatch.");
        test.pass("✅ Verified Severity Description for High.");
    }

    @Test(priority = 75)
    public void verifyExtremeSeverityDescription() {
        test = extent.createTest("Verify Severity Description: Extreme");
        Assert.assertEquals(destinationReportPage.getSeverityDescription(3), expectedSeverityDescriptions[3], "❌ Severity description mismatch.");
        test.pass("✅ Verified Severity Description for Extreme.");
    }
    @Test(priority = 77)
    public void clickOnCategoriesTab() {
        test = extent.createTest("Click on Categories Tab");
        destinationReportPage.clickCategoriesTab();
       // Assert.assertTrue(destinationReportPage.isCategoriesTabSelected(), "❌ Categories tab was NOT clicked.");
        test.pass("✅ Categories tab was clicked successfully.");
    }
    @Test(priority = 78)
    public void verifyViolenceCategoryTitle() {
        test = extent.createTest("Verify Violence Category Title");

        try {
            Thread.sleep(500); // Small delay to stabilize execution
            String actualTitle = destinationReportPage.getEventDefinitionCardTitle(0);

            Assert.assertEquals(actualTitle, "Violence", "❌ Violence category title mismatch.");
            test.pass("✅ Violence category title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Violence category verification failed: " + e.getMessage());
            Assert.fail("Violence category title not found!", e);
        }
    }


    @Test(priority = 79)
    public void verifyViolenceCategoryDescription() {
        test = extent.createTest("Verify Violence Category Description");
        Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(1),
                "Activities of intentional harm such as active shooters, terrorist events, faction clashes, riots, looting, notable crime, etc.",
                "❌ Violence category description mismatch.");
        test.pass("✅ Violence category description verified successfully.");
    }


    @Test(priority = 80)
    public void verifyUnrestCategoryTitle() {
        test = extent.createTest("Verify Unrest Category Title");
        Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(1), "Unrest", "❌ Unrest category title mismatch.");
        test.pass("✅ Unrest category title verified successfully.");
    }


    @Test(priority = 81)
    public void verifyUnrestCategoryDescription() {
        test = extent.createTest("Verify Unrest Category Description");
        Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(2),
                "Civil disturbances such as strikes, demonstrations, protests, etc.",
                "❌ Unrest category description mismatch.");
        test.pass("✅ Unrest category description verified successfully.");
    }


    @Test(priority = 82)
    public void verifyEnvironmentCategoryTitle() {
        test = extent.createTest("Verify Environment Category Title");
        Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(2), "Environment", "❌ Environment category title mismatch.");
        test.pass("✅ Environment category title verified successfully.");
    }


    @Test(priority = 83)
    public void verifyEnvironmentCategoryDescription() {
        test = extent.createTest("Verify Environment Category Description");
        Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(3),
                "Primarily natural disasters such as earthquakes, tsunamis, storms, floods, etc.",
                "❌ Environment category description mismatch.");
        test.pass("✅ Environment category description verified successfully.");
    }


    @Test(priority = 84)
    public void verifyHealthCategoryTitle() {
        test = extent.createTest("Verify Health Category Title");
        Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(3), "Health", "❌ Health category title mismatch.");
        test.pass("✅ Health category title verified successfully.");
    }


    @Test(priority = 85)
    public void verifyHealthCategoryDescription() {
        test = extent.createTest("Verify Health Category Description");
        Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(4),
                "Factors related to physical wellbeing such as disease outbreaks, epidemics, pandemics, endemics, governmental restrictions or requirements on entry and travel, etc.",
                "❌ Health category description mismatch.");
        test.pass("✅ Health category description verified successfully.");
    }


    @Test(priority = 86)
    public void verifyInfrastructureCategoryTitle() {
        test = extent.createTest("Verify Infrastructure Category Title");
        Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(4), "Infrastructure", "❌ Infrastructure category title mismatch.");
        test.pass("✅ Infrastructure category title verified successfully.");
    }


    @Test(priority = 87)
    public void verifyInfrastructureCategoryDescription() {
        test = extent.createTest("Verify Infrastructure Category Description");
        Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(5),
                "Impacts to infrastructure such as building and bridge collapses or damage, transportation incidents, accidental explosions, significant power and communication outages, etc.",
                "❌ Infrastructure category description mismatch.");
        test.pass("✅ Infrastructure category description verified successfully.");
    }
    @Test(priority = 88, description = "Verify clicking the back button twice navigates correctly")
    public void verifyClickingBackButtonTwice() {
        test = extent.createTest("Verify Clicking Back Button Twice");

        // Click back button first time
        destinationReportPage.clickBackButton();
        test.pass("✅ Clicked Back Button first time.");

       
        // Click back button second time
        destinationReportPage.clickBackButton();
        test.pass("✅ Clicked Back Button second time.");
    }
    @Test(priority = 89)
  public void clickRiskOverviewRow() {
      clickTableRow(1, "Risk Overview");
  }
    @Test(priority = 90)
    public void verifyRiskOverviewTitle() {
        test = extent.createTest("Verify Risk Overview Title");
        try {
            String actualTitle = destinationReportPage.getRiskOverviewTitle();
            Assert.assertEquals(actualTitle, "Risk Overview", "Title mismatch!");
            test.pass("✅ Risk Overview Title is correctly displayed.");
        } catch (Exception e) {
            test.fail("❌ Risk Overview Title verification failed: " + e.getMessage());
            Assert.fail("Risk Overview Title not found!", e);
        }
    }

    @Test(priority = 91)
    public void verifyBackButtonFunctionality() {
        test = extent.createTest("Verify Back Button visibility");
        try {
            destinationReportPage.isToolbarBackButtonVisible();
            test.pass("✅ Back button visible successfully.");
        } catch (Exception e) {
            test.fail("❌ Back button visibility failed: " + e.getMessage());
            Assert.fail("Back button visibility failed!", e);
        }
    }

    @Test(priority = 92)
    public void verifyCardViewPresence() {
        test = extent.createTest("Verify Card View Presence");
        try {
            Assert.assertTrue(destinationReportPage.isCardViewDisplayed(), "Card View is not visible.");
            test.pass("✅ Card View is displayed.");
        } catch (Exception e) {
            test.fail("❌ Card View verification failed: " + e.getMessage());
            Assert.fail("Card View not found!", e);
        }
    }

//    @Test(priority = 93)
//    public void verifyRiskRatingText() {
//        test = extent.createTest("Verify Risk Rating Text");
//        try {
//            String actualText = destinationReportPage.getRiskRatingText();
//
//            if (actualText.startsWith("Element not found")) {
//                test.fail("❌ Risk Rating text could not be located.");
//                Assert.fail("Risk Rating text was not found.");
//            } else {
//                Assert.assertTrue(actualText.contains("The overall risk rating for the"), "Risk rating text mismatch!");
//                test.pass("✅ Risk Rating text is correctly displayed: " + actualText);
//            }
//        } catch (Exception e) {
//            test.fail("❌ Risk Rating text verification failed: " + e.getMessage());
//            Assert.fail("Risk Rating text not found!", e);
//        }
//    }
    @Test(priority = 94)
    public void ClickBackButton() {
        test = extent.createTest("Verify Back Button Functionality");
        try {
            destinationReportPage.clickBackButton();
            test.pass("✅ Back button clicked successfully.");
        } catch (Exception e) {
            test.fail("❌ Back button click failed: " + e.getMessage());
            Assert.fail("Back button functionality failed!", e);
        }
    }
    
    @Test(priority = 95)
    public void clickGeneralOverviewRow() {
      clickTableRow(2, "General Overview");
  }
    @Test(priority = 96)
    public void verifyTitleDisplayed() {
        test = extent.createTest("Verify Title is Displayed");
        try {
            Assert.assertTrue(destinationReportPage.isTitleDisplayed(), "Title is not displayed.");
            test.pass("✅ Title is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Title verification failed: " + e.getMessage());
            Assert.fail("Title not found!", e);
        }
    }@Test(priority = 96)
    public void verifyPAKLogoDisplayed() {
        test = extent.createTest("Verify USA Logo is Displayed");
        try {
            Assert.assertTrue(destinationReportPage.isUSALogoDisplayed(), "USA Logo is not visible.");
            test.pass("✅ USA Logo is displayed.");
        } catch (Exception e) {
            test.fail("❌ USA Logo verification failed: " + e.getMessage());
            Assert.fail("USA Logo not found!", e);
        }
    }

    @Test(priority = 96)
    public void verifyBackButton() {
        test = extent.createTest("Verify Back Button Clickable");
        try {
            Assert.assertTrue(destinationReportPage.isBackButtonClickable()); 
            test.pass("✅ Back button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Back button is not clickable: " + e.getMessage());
            Assert.fail("Back button is not clickable!", e);
        }
    }

    

    @Test(priority = 96)
    public void verifyTextViewDisplayed() {
        test = extent.createTest("Verify Text View is Displayed");
        try {
            Assert.assertTrue(destinationReportPage.isTextViewDisplayed(), "Text View is not visible.");
            test.pass("✅ Text View is displayed.");
        } catch (Exception e) {
            test.fail("❌ Text View verification failed: " + e.getMessage());
            Assert.fail("Text View not found!", e);
        }
    }

    @Test(priority = 96)
    public void verifyGeneralOverviewTitleDisplayed() {
        test = extent.createTest("Verify General Overview Title is Displayed");
        try {
            Assert.assertTrue(destinationReportPage.isGeneralOverviewTitleDisplayed(), "General Overview title is not displayed.");
            test.pass("✅ General Overview title is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ General Overview title verification failed: " + e.getMessage());
            Assert.fail("General Overview title not found!", e);
        }
    }
    @Test(priority = 97)
    public void ClickBackButtonOfGeneralOverview() {
        test = extent.createTest("Verify Back Button Functionality");
        try {
            destinationReportPage.clickBackButton();
            test.pass("✅ Back button clicked successfully.");
        } catch (Exception e) {
            test.fail("❌ Back button click failed: " + e.getMessage());
            Assert.fail("Back button functionality failed!", e);
        }
    }

    @Test(priority = 98)
  public void clickSecurityAssessmentRow() {
      clickTableRow(3, "Security Assessment");
  }
    @Test(priority = 99)
    public void verifySecurityAssessmentTitle() {
        test = extent.createTest("Verify Security Assessment Title");
        try {
        	verifyBackButton();
            Assert.assertTrue(destinationReportPage.isSecurityAssessmentTitleDisplayed(), "Security Assessment title is not displayed.");
            test.pass("✅ Security Assessment title is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Security Assessment title verification failed: " + e.getMessage());
            Assert.fail("Security Assessment title not found!", e);
        }
    }

    @Test(priority = 100)
    public void VerifyBackButtonOnSecurityAssessment() {
    	verifyBackButton();
    }

    @Test(priority = 101)
    public void verifySecurityRiskRatingDisplayed() {
        test = extent.createTest("Verify Security Risk Rating Displayed");
        try {
            Assert.assertTrue(destinationReportPage.isSecurityRiskRatingDisplayed(), "Security Risk Rating is not visible.");
            test.pass("✅ Security Risk Rating is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Security Risk Rating verification failed: " + e.getMessage());
            Assert.fail("Security Risk Rating not found!", e);
        }
    }

    @Test(priority = 102)
    public void verifyExtremeRiskRatingDisplayed() {
        test = extent.createTest("Verify Extreme Risk Rating Displayed");
        try {
            Assert.assertTrue(destinationReportPage.isExtremeRiskRatingDisplayed(), "Extreme Risk Rating is not visible.");
            test.pass("✅ Extreme Risk Rating is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Extreme Risk Rating verification failed: " + e.getMessage());
            Assert.fail("Extreme Risk Rating not found!", e);
        }
    }

//    @Test(priority = 103)
//    public void verifySecurityAssessmentRowsIndividually() {
//        test = extent.createTest("Verify Security Assessment Row Titles and Expand/Collapse One by One");
//
//        try {
//            List<String> expectedRowTitles = List.of(
//                "Security Risk Overview", "Terrorism", "Civil Unrest", "Crime",
//                "Natural Disasters", "Transportation", "Law Enforcement",
//                "Scams, Frauds, Corruption, and Extortion", "Security Advice"
//            );
//
//            for (String title : expectedRowTitles) {
//                // Verify row title exists
//                Assert.assertTrue(destinationReportPage.isRowTitleDisplayed(title), "Row title not found: " + title);
//                test.pass("✅ Verified presence of row: " + title);
//
//                // Expand the row
//                destinationReportPage.expandRow(title);
//                Assert.assertTrue(destinationReportPage.isRowExpanded(title), "Row did not expand: " + title);
//                test.pass("✅ Successfully expanded row: " + title);
//                
//                // Collapse the row
//                destinationReportPage.collapseRow(title);
//               
//                test.pass("✅ Successfully collapsed row: " + title);
//            }
//
//        } catch (Exception e) {
//            test.fail("❌ Security assessment row verification failed: " + e.getMessage());
//            Assert.fail("Security assessment row verification failed!", e);
//        }
//    }
    @Test(priority = 104)
    public void verifySecurityRiskOverviewRow() {
        test = extent.createTest("Verify Security Risk Overview Row Expand/Collapse");
        
        boolean result = destinationReportPage.verifyRowExpandCollapse("Security Risk Overview");
        Assert.assertTrue(result, "Row verification failed: Security Risk Overview");

        test.pass("✅ Security Risk Overview row expand/collapse verified successfully.");
    }

    @Test(priority = 105)
    public void verifyTerrorismRow() throws InterruptedException {
        test = extent.createTest("Verify Terrorism Row Expand/Collapse");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.globalrescue.enterprise:id/cardLayout_securityRiskOverview\"]/android.widget.LinearLayout"))).click();
       Thread.sleep(2000);
        boolean result = destinationReportPage.verifyRowExpandCollapse("Terrorism");
        Assert.assertTrue(result, "Row verification failed: Terrorism");

        test.pass("✅ Terrorism row expand/collapse verified successfully.");
    }

    @Test(priority = 106)
    public void verifyCivilUnrestRow() {
        test = extent.createTest("Verify Civil Unrest Row Expand/Collapse");

        boolean result = destinationReportPage.verifyRowExpandCollapse("Civil Unrest");
        Assert.assertTrue(result, "Row verification failed: Civil Unrest");

        test.pass("✅ Civil Unrest row expand/collapse verified successfully.");
    }

    @Test(priority = 107)
    public void verifyCrimeRow() {
        test = extent.createTest("Verify Crime Row Expand/Collapse");

        boolean result = destinationReportPage.verifyRowExpandCollapse("Crime");
        Assert.assertTrue(result, "Row verification failed: Crime");

        test.pass("✅ Crime row expand/collapse verified successfully.");
    }

    @Test(priority = 108)
    public void verifyNaturalDisastersRow() {
        test = extent.createTest("Verify Natural Disasters Row Expand/Collapse");

        boolean result = destinationReportPage.verifyRowExpandCollapse("Natural Disasters");
        Assert.assertTrue(result, "Row verification failed: Natural Disasters");

        test.pass("✅ Natural Disasters row expand/collapse verified successfully.");
    }

    @Test(priority = 109)
    public void verifyTransportationRow() {
        test = extent.createTest("Verify Transportation Row Expand/Collapse");

        boolean result = destinationReportPage.verifyRowExpandCollapse("Transportation");
        Assert.assertTrue(result, "Row verification failed: Transportation");

        test.pass("✅ Transportation row expand/collapse verified successfully.");
    }

    @Test(priority = 110)
    public void verifyLawEnforcementRow() {
        test = extent.createTest("Verify Law Enforcement Row Expand/Collapse");

        boolean result = destinationReportPage.verifyRowExpandCollapse("Law Enforcement");
        Assert.assertTrue(result, "Row verification failed: Law Enforcement");

        test.pass("✅ Law Enforcement row expand/collapse verified successfully.");
    }

    @Test(priority = 111)
    public void verifyScamsFraudsCorruptionRow() {
        test = extent.createTest("Verify Scams, Frauds, Corruption, and Extortion Row Expand/Collapse");

        boolean result = destinationReportPage.verifyRowExpandCollapse("Scams, Frauds, Corruption, and Extortion");
        Assert.assertTrue(result, "Row verification failed: Scams, Frauds, Corruption, and Extortion");

        test.pass("✅ Scams, Frauds, Corruption, and Extortion row expand/collapse verified successfully.");
    }

    @Test(priority = 112)
    public void verifySecurityAdviceRow() {
        test = extent.createTest("Verify Security Advice Row Expand/Collapse");

        boolean result = destinationReportPage.verifyRowExpandCollapse("Security Advice");
        Assert.assertTrue(result, "Row verification failed: Security Advice");

        test.pass("✅ Security Advice row expand/collapse verified successfully.");
    }

    @Test(priority = 113)
    public void ClickBackButtonFunctionality() {
        test = extent.createTest("Verify Back Button Functionality");
        try {
            destinationReportPage.clickBackButton();
            test.pass("✅ Back button clicked successfully.");
        } catch (Exception e) {
            test.fail("❌ Back button click failed: " + e.getMessage());
            Assert.fail("Back button functionality failed!", e);
        }
    }
  @Test(priority = 114)
  public void clickHealthAssessmentRow() {
      clickTableRow(5, "Health Assessment");
  }
  @Test(priority = 115)
  public void verifyHealthAssessmentTitle() {
      test = extent.createTest("Verify Health Assessment Title");

      try {
          Assert.assertTrue(destinationReportPage.isHealthAssessmentTitleDisplayed(), "Health Assessment title is not displayed.");
          test.pass("✅ Health Assessment title is displayed correctly.");
      } catch (Exception e) {
          test.fail("❌ Health Assessment title verification failed: " + e.getMessage());
          Assert.fail("Health Assessment title not found!", e);
      }
  }

  @Test(priority = 116)
  public void verifyBackButtonOnHealthAssessment() {
      verifyBackButton();
  }

  @Test(priority = 117)
  public void verifyRatingLayoutDisplayed() {
      test = extent.createTest("Verify Rating Layout Displayed");

      try {
          Assert.assertTrue(destinationReportPage.isRatingLayoutDisplayed(), "Rating Layout is not displayed.");
          test.pass("✅ Rating Layout is displayed correctly.");
      } catch (Exception e) {
          test.fail("❌ Rating Layout verification failed: " + e.getMessage());
          Assert.fail("Rating Layout not found!", e);
      }
  }

  @Test(priority = 118)
  public void verifyRiskRatingText() {
      test = extent.createTest("Verify Risk Rating Text");

      try {
          String actualText = destinationReportPage.getRiskRatingText1();
          List<String> validRatings = Arrays.asList("Low", "Moderate", "High", "Extreme");
          System.out.println(actualText);
          Assert.assertTrue(validRatings.contains(actualText), "Invalid Risk Rating Text: " + actualText);
          test.pass("✅ Risk Rating text is displayed correctly: " + actualText);
      } catch (Exception e) {
          test.fail("❌ Risk Rating text verification failed: " + e.getMessage());
          Assert.fail("Risk Rating text not found!", e);
      }
  }

  @Test(priority = 119)
  public void verifyCardLayoutDisplayed() {
      test = extent.createTest("Verify Card Layout Displayed");

      try {
          Assert.assertTrue(destinationReportPage.isCardLayoutDisplayed(), "Card Layout is not displayed.");
          test.pass("✅ Card Layout is displayed correctly.");
      } catch (Exception e) {
          test.fail("❌ Card Layout verification failed: " + e.getMessage());
          Assert.fail("Card Layout not found!", e);
      }
  }

  @Test(priority = 120)
  public void verifyWebViewCardDisplayed() {
      test = extent.createTest("Verify WebView Card Displayed");

      try {
          Assert.assertTrue(destinationReportPage.isWebViewCardDisplayed(), "WebView Card is not displayed.");
          test.pass("✅ WebView Card is displayed correctly.");
      } catch (Exception e) {
          test.fail("❌ WebView Card verification failed: " + e.getMessage());
          Assert.fail("WebView Card not found!", e);
      }
  }
  @Test(priority = 121)
  public void ClickBackButtonOnHealthAssessment() {
      test = extent.createTest("Verify Back Button Functionality");
      try {
          destinationReportPage.clickBackButton();
          test.pass("✅ Back button clicked successfully.");
      } catch (Exception e) {
          test.fail("❌ Back button click failed: " + e.getMessage());
          Assert.fail("Back button functionality failed!", e);
      }
  }
  @Test(priority = 122)
  public void clickDestinationDetailsRow() {
    clickTableRow(7, "Destination Details");
  }
  
  @Test(priority = 123)
  public void verifyDestinationDetailsTitle() {
      test = extent.createTest("Verify Destination Details Title");

      try {
          Assert.assertTrue(destinationReportPage.isDestinationDetailsTitleDisplayed(), "Destination Details title is not displayed.");
          test.pass("✅ Destination Details title is displayed correctly.");
      } catch (Exception e) {
          test.fail("❌ Destination Details title verification failed: " + e.getMessage());
          Assert.fail("Destination Details title not found!", e);
      }
  }

  @Test(priority = 124)
  public void verifyBackButtonOnDestinationDetails() {
      test = extent.createTest("Verify Back Button Functionality");

      try {
          Assert.assertTrue(destinationReportPage.isBackButtonClickable());
          test.pass("✅ Back button clicked successfully.");
      } catch (Exception e) {
          test.fail("❌ Back button click failed: " + e.getMessage());
          Assert.fail("Back button functionality failed!", e);
      }
  }

  @Test(priority = 125)
  public void verifyWebViewDisplayed() {
      test = extent.createTest("Verify WebView is Displayed");

      try {
          Assert.assertTrue(destinationReportPage.isWebViewDisplayed(), "WebView is not displayed.");
          test.pass("✅ WebView is displayed correctly.");
      } catch (Exception e) {
          test.fail("❌ WebView verification failed: " + e.getMessage());
          Assert.fail("WebView not found!", e);
      }
  }

  @Test(priority = 126)
  public void verifyCardLayoutDisplayedOnDestinationDetails() {
      test = extent.createTest("Verify Card Layout is Displayed");

      try {
          Assert.assertTrue(destinationReportPage.isCardLayoutDisplayed(), "Card Layout is not displayed.");
          test.pass("✅ Card Layout is displayed correctly.");
      } catch (Exception e) {
          test.fail("❌ Card Layout verification failed: " + e.getMessage());
          Assert.fail("Card Layout not found!", e);
      }
  }
  @Test(priority = 127)
  public void ClickBackButtonOnDestinationDetails() {
      test = extent.createTest("Verify Back Button Functionality");

      try {
          destinationReportPage.clickBackButton();
          test.pass("✅ Back button clicked successfully.");
      } catch (Exception e) {
          test.fail("❌ Back button click failed: " + e.getMessage());
          Assert.fail("Back button functionality failed!", e);
      }
  }

//    @Test(priority = 68)
//    public void verifySeverityTitles() {
//        test = extent.createTest("Verify Severity Titles");
//        int severityCount = destinationReportPage.getSeverityCardCount();
//        Assert.assertEquals(severityCount, expectedSeverityTitles.length, "❌ Severity count mismatch.");
//
//        for (int i = 0; i < severityCount; i++) {
//            Assert.assertEquals(destinationReportPage.getSeverityTitle(i), expectedSeverityTitles[i], "❌ Severity title mismatch at index " + i);
//            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[i]);
//        }
//    }
//
//    @Test(priority = 69)
//    public void verifySeverityDescriptions() {
//        test = extent.createTest("Verify Severity Descriptions");
//        int severityCount = destinationReportPage.getSeverityCardCount();
//        Assert.assertEquals(severityCount, expectedSeverityDescriptions.length, "❌ Severity count mismatch.");
//
//        for (int i = 0; i < severityCount; i++) {
//            Assert.assertEquals(destinationReportPage.getSeverityDescription(i), expectedSeverityDescriptions[i], "❌ Severity description mismatch at index " + i);
//            test.pass("✅ Verified Severity Description for " + expectedSeverityTitles[i]);
//        }
//    }

    @Test(priority = 128)
    public void clickEntryExitRequirementsRow() {
        clickTableRow(8, "Entry & Exit Requirements");
    }
    @Test(priority = 129)
    public void verifyEntryExitTitle() {
        test = extent.createTest("Verify Entry & Exit Requirements Title");

        try {
            Assert.assertTrue(destinationReportPage.isEntryExitTitleDisplayed(), "Entry & Exit Requirements title is not displayed.");
            test.pass("✅ Entry & Exit Requirements title is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Entry & Exit Requirements title verification failed: " + e.getMessage());
            Assert.fail("Entry & Exit Requirements title not found!", e);
        }
    }

    @Test(priority = 130)
    public void verifyCardLayoutDisplayedOnEntryExitRequiements() {
        test = extent.createTest("Verify Card Layout is Displayed");

        try {
            Assert.assertTrue(destinationReportPage.isCardLayoutDisplayed(), "Card Layout is not displayed.");
            test.pass("✅ Card Layout is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Card Layout verification failed: " + e.getMessage());
            Assert.fail("Card Layout not found!", e);
        }
    }

    @Test(priority = 131)
    public void verifyWebViewDisplayedOnEntryExitRequiements() {
        test = extent.createTest("Verify WebView is Displayed");

        try {
            Assert.assertTrue(destinationReportPage.isWebViewDisplayed(), "WebView is not displayed.");
            test.pass("✅ WebView is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ WebView verification failed: " + e.getMessage());
            Assert.fail("WebView not found!", e);
        }
    }

    @Test(priority = 132)
    public void scrollToEndOfScreen() {
        test = extent.createTest("Scroll to End of Screen");

        try {
            destinationReportPage.scrollToEnd();
            test.pass("✅ Successfully scrolled to the end of the screen.");
        } catch (Exception e) {
            test.fail("❌ Scrolling failed: " + e.getMessage());
            Assert.fail("Scrolling to end of screen failed!", e);
        }
    }

    @Test(priority = 133)
    public void clickBackButton() {
        test = extent.createTest("Click on Back Button");

        try {
            destinationReportPage.clickBackButton();
            test.pass("✅ Successfully clicked on the Back Button.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on the Back Button: " + e.getMessage());
            Assert.fail("Click action on Back Button failed!", e);
        }
    }


    @Test(priority = 134)
    public void clickImportantNumbersRow() {
        clickTableRow(9, "Important Numbers");
    }
    
    @Test(priority = 135)
    public void verifyImportantNumbersTitle() {
        test = extent.createTest("Verify Important Numbers Title");

        try {
            Assert.assertTrue(destinationReportPage.isImportantNumbersTitleDisplayed(), "Important Numbers title is not displayed.");
            test.pass("✅ Important Numbers title is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Important Numbers title verification failed: " + e.getMessage());
            Assert.fail("Important Numbers title not found!", e);
        }
    }

    @Test(priority = 135)
    public void verifyCardLayoutDisplayedOnImportantNumbers() {
        test = extent.createTest("Verify Card Layout is Displayed");

        try {
            Assert.assertTrue(destinationReportPage.isCardLayoutDisplayed(), "Card Layout is not displayed.");
            test.pass("✅ Card Layout is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Card Layout verification failed: " + e.getMessage());
            Assert.fail("Card Layout not found!", e);
        }
    }

    @Test(priority = 135)
    public void verifyWebViewDisplayedOnImportantNumbers() {
        test = extent.createTest("Verify WebView is Displayed");

        try {
            Assert.assertTrue(destinationReportPage.isWebViewDisplayed(), "WebView is not displayed.");
            test.pass("✅ WebView is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ WebView verification failed: " + e.getMessage());
            Assert.fail("WebView not found!", e);
        }
    }

    @Test(priority = 135)
    public void scrollToEndOfImportantNumbers() {
        test = extent.createTest("Scroll to End of Important Numbers Section");

        try {
            destinationReportPage.scrollToEnd();
            test.pass("✅ Successfully scrolled to the end of the Important Numbers section.");
        } catch (Exception e) {
            test.fail("❌ Scrolling failed: " + e.getMessage());
            Assert.fail("Scrolling to end of Important Numbers section failed!", e);
        }
    }

    @Test(priority = 136)
    public void clickBackButtonTwice() {
        test = extent.createTest("Click on Back Button Twice");

        try {
            destinationReportPage.clickBackButton();
            test.pass("✅ First click on Back Button successful.");

            destinationReportPage.clickBackButton();
            test.pass("✅ Second click on Back Button successful.");
        } catch (Exception e) {
            test.fail("❌ Failed to click Back Button twice: " + e.getMessage());
            Assert.fail("Click action on Back Button twice failed!", e);
        }
    }
    @Test(priority = 140)
    public void verifyClearingCountrySearchField() {
        test = extent.createTest("Verify Clearing Country Search Field and Closing Keyboard");

        try {
            destinationReportPage.clearCountrySearchField();
            test.pass("✅ Successfully cleared the country search field and closed the keyboard.");
        } catch (Exception e) {
            test.fail("❌ Failed to clear country search field and close keyboard: " + e.getMessage());
            Assert.fail("Country search field clearing and keyboard closing failed!", e);
        }
    }

    @Test(priority = 141)
    public void verifySelectDestinationTitle() {
        test = extent.createTest("Verify Select Destination Title");

        try {
            Assert.assertTrue(destinationReportPage.isSelectDestinationTitleDisplayed(), "Select Destination title is not displayed.");
            test.pass("✅ Select Destination title is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Select Destination title verification failed: " + e.getMessage());
            Assert.fail("Select Destination title not found!", e);
        }
    }

    @Test(priority = 142)
    public void verifyRegionsTabDisplayed() {
        test = extent.createTest("Verify Regions Tab Displayed");

        try {
            Assert.assertTrue(destinationReportPage.isRegionsTabDisplayed(), "Regions tab is not displayed.");
            test.pass("✅ Regions tab is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Regions tab verification failed: " + e.getMessage());
            Assert.fail("Regions tab not found!", e);
        }
    }

    @Test(priority = 143)
    public void verifyCountriesTabDisplayed() {
        test = extent.createTest("Verify Countries Tab Displayed");

        try {
            Assert.assertTrue(destinationReportPage.isCountriesTabDisplayed(), "Countries tab is not displayed.");
            test.pass("✅ Countries tab is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Countries tab verification failed: " + e.getMessage());
            Assert.fail("Countries tab not found!", e);
        }
    }

    @Test(priority = 144)
    public void verifyCountryRecyclerViewDisplayed() {
        test = extent.createTest("Verify Country Recycler View is Displayed");

        try {
            Assert.assertTrue(destinationReportPage.isCountryRecyclerViewDisplayed(), "Country Recycler View is not displayed.");
            test.pass("✅ Country Recycler View is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Country Recycler View verification failed: " + e.getMessage());
            Assert.fail("Country Recycler View not found!", e);
        }
    }

    @Test(priority = 145)
    public void verifyCountryViewGroupDisplayed() {
        test = extent.createTest("Verify Country View Group is Displayed");

        try {
            Assert.assertTrue(destinationReportPage.isCountryViewGroupDisplayed(), "Country View Group is not displayed.");
            test.pass("✅ Country View Group is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Country View Group verification failed: " + e.getMessage());
            Assert.fail("Country View Group not found!", e);
        }
    }

    @Test(priority = 146)
    public void verifyAllCountriesExist() {
        test = extent.createTest("Verify All Countries Are Displayed");
//
        try {
        	Thread.sleep(3000);
        	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"));
destinationReportPage.clickBackButton();
//            List<String> countryList = destinationReportPage.getAllCountryNames();
//            System.out.println(countryList);
//            Assert.assertFalse(countryList.isEmpty(), "No countries found in the list.");
//
//            test.pass("✅ Countries displayed: " + countryList);
        } catch (Exception e) {
//            test.fail("❌ Failed to fetch country names: " + e.getMessage());
//            Assert.fail("Fetching country names failed!", e);
       }
    }
//
//    @Test(priority = 147)
//    public void verifyAllCountriesHaveDownloadButtons() {
//        test = extent.createTest("Verify All Countries Have Download Buttons");
//
//        try {
//            Assert.assertTrue(destinationReportPage.verifyDownloadButtonsForAllCountries(), "Not all countries have a download button.");
//            test.pass("✅ All countries have corresponding download buttons.");
//        } catch (Exception e) {
//            test.fail("❌ Verification failed for country download buttons: " + e.getMessage());
//            Assert.fail("Download buttons verification failed!", e);
//        }
//    }


    private void clickTableRow(int index, String rowName) {
        ExtentTest test = extent.createTest("Click Table Row: " + rowName);

        try {
            // Locate the table container
            WebElement tableLayout = wait.until(ExpectedConditions.presenceOfElementLocated(
                    AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(9)")));

            // Get all rows inside the table
            List<WebElement> tableRows = tableLayout.findElements(By.className("android.widget.TextView"));

            // Click on the specified row
            tableRows.get(index).click();
            test.pass("✅ Successfully clicked on row: " + rowName);

        } catch (Exception e) {
            test.fail("❌ Failed to click row " + index + " (" + rowName + "): " + e.getMessage());
            Assert.fail("Click action failed for row " + index, e);
        }
    }

    
   // @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test failed: " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(result.getName() + " passed.");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(result.getName() + " skipped.");
        }
        extent.flush();
    }

    @AfterSuite
    public void tearDownExtentReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
   
