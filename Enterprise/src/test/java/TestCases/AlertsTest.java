package TestCases;

import pages.AlertsPage;
import pages.ContactYourOrganizationPage;
import pages.DestinationReportPage;
import pages.EventsPage;
import utilities.ExtentReportsManager;
import base.BaseSetup;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
// publish an event first
public class AlertsTest extends BaseSetup {
    private EventsPage eventsPage;
    private DestinationReportPage destinationReportPage;
    private AndroidDriver driver;
    private WebDriverWait wait;
    private ExtentReports extent;
    private ExtentTest test;
    private AlertsPage alertsPage;
    
    private WebDriver webDriver;
    private WebPortal webPortal;
    
    private String expectedTitle;
    private String expectedSeverity;
    private String expectedCategory;
    private String expectedCountry;
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
    @BeforeSuite
    public void setupExtentReports() {
        extent = ExtentReportsManager.getExtentReports(); // Ensure this is returning a valid ExtentReports instance
        if (extent == null) {
            throw new RuntimeException("❌ ExtentReports instance is null. Check ExtentReportsManager.");
        }
    }
    @BeforeClass
    public void setup() {
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        eventsPage = new EventsPage(driver, wait);
        destinationReportPage = new DestinationReportPage(driver, wait);
        alertsPage = new AlertsPage(driver, wait);
    }

    @Test(priority = 1, description = "Verify clicking on the Alerts tab navigates to the Alerts page")
    public void verifyClickingAlertsTab() {
        test = extent.createTest("Verify Clicking Alerts Tab");
        try {
            eventsPage.clickAlertsTab();
            Thread.sleep(2000);
            Assert.assertTrue(eventsPage.isPageTitleDisplayed(), "❌ Alerts Page Title not displayed.");
            test.pass("✅ Successfully navigated to Alerts page.");
        } catch (Exception e) {
            test.fail("❌ Failed to navigate to Alerts Page: " + e.getMessage());
            Assert.fail("Navigation to Events Page failed!", e);
        }
    }

    @Test(priority = 2, description = "Verify the title of the Event Alerts Page")
    public void verifyEventAlertsPageTitle() {
        test = extent.createTest("Verify Event Alerts Page Title");
        try {
            Assert.assertEquals(eventsPage.getPageTitleText(), "Event Alerts", "❌ Page title mismatch!");
            test.pass("✅ Event Alerts Page title is displayed correctly.");
        } catch (Exception e) {
            test.fail("❌ Event Alerts Page title verification failed: " + e.getMessage());
            Assert.fail("Event Alerts Page title is incorrect!", e);
        }
    }


    @Test(priority = 3)
    public void verifyEmptyScreen() {
        test = extent.createTest("Verify if empty screen elements are present when there are no active events");

        try {
            if (eventsPage.emptyScreen()) {
                test.info("🟡 No active events detected. Verifying empty screen elements...");

                Assert.assertEquals(eventsPage.emptyTitle(), "No active event alerts.", "❌ Title mismatch!");
                Assert.assertEquals(eventsPage.emptyTitle2(), "How do I get alerts?", "❌ Subtitle mismatch!");
                Assert.assertEquals(eventsPage.emptyDescription(), 
                    "You receive alerts from Global Rescue's GRID platform based on the alert profiles setup either by you or by your employer.", 
                    "❌ Description mismatch!");
                Assert.assertEquals(eventsPage.emptyDescription2(), 
                    "To manage or setup alerts that your organization's eligible employees will receive, please login to GRID web portal and click on Administration ➔ Alert Profiles.", 
                    "❌ Additional description mismatch!");

                test.pass("✅ Empty screen elements verified successfully.");
            } else {
                test.info("✅ Active events detected. Skipping empty screen verification.");
            }
        } catch (Exception e) {
            test.fail("❌ Failed to verify empty screen elements: " + e.getMessage());
            Assert.fail("Error occurred while verifying empty screen!", e);
        }
    }




    @Test(priority = 5, description = "Verify Event List is displayed on Events Page")
    public void verifyPublishedEvent() {
        test = extent.createTest("Verify Event List Displayed");
        try {
        	driver.runAppInBackground(Duration.ofSeconds(-1)); // This keeps the app in the background indefinitely

        	webPortal = new WebPortal();
        	
        	webPortal.EventPublish(); //web portal called
      	
            
        	ContactYourOrganizationPage CYO = new ContactYourOrganizationPage(driver, wait);
        	CYO.AlertsNotificationtext();
        	test.pass("✅ Event list is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Event list verification failed: " + e.getMessage());
            Assert.fail("Event list is missing!", e);
        }
    }
    @Test(priority = 6, description = "Verify Search Bar is displayed on Event Alerts Page")
    public void verifySearchBarDisplayed() {
        test = extent.createTest("Verify Search Bar Displayed");
        try {
            Assert.assertTrue(eventsPage.isSearchBarDisplayed(), "❌ Search bar is missing.");
            test.pass("✅ Search bar is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Search bar verification failed: " + e.getMessage());
            Assert.fail("Search bar is missing!", e);
        }
    }
    @Test(priority = 7, description = "Verify event titles are present")
    public void verifyEventTitles() {
        test = extent.createTest("Verify Event Titles");
        try {
            List<String> eventTitles = eventsPage.getAllEventTitles();
            Assert.assertFalse(eventTitles.isEmpty(), "❌ No event titles found!");
            test.pass("✅ Event titles are displayed: " + eventTitles);
        } catch (Exception e) {
            test.fail("❌ Event titles verification failed: " + e.getMessage());
            Assert.fail("Event titles not found!", e);
        }
    }

    @Test(priority = 8, description = "Verify event severities are correctly displayed")
    public void verifyEventSeverities() {
        test = extent.createTest("Verify Event Severities");
        try {
            List<String> severities = eventsPage.getAllEventSeverities();
            List<String> validSeverities = List.of("Low", "Moderate", "High", "Extreme");
            Assert.assertTrue(validSeverities.containsAll(severities), "❌ Invalid severity levels detected!");
            test.pass("✅ Event severities displayed correctly: " + severities);
        } catch (Exception e) {
            test.fail("❌ Event severity verification failed: " + e.getMessage());
            Assert.fail("Event severities not found!", e);
        }
    }

    @Test(priority = 9, description = "Verify event categories are displayed correctly")
    public void verifyEventCategories() {
        test = extent.createTest("Verify Event Categories");
        try {
            List<String> categories = eventsPage.getAllEventCategories();
            Assert.assertFalse(categories.isEmpty(), "❌ No event categories found!");
            test.pass("✅ Event categories displayed correctly: " + categories);
        } catch (Exception e) {
            test.fail("❌ Event category verification failed: " + e.getMessage());
            Assert.fail("Event categories not found!", e);
        }
    }

    @Test(priority = 10, description = "Verify event dates are present")
    public void verifyEventDates() {
        test = extent.createTest("Verify Event Dates");

        try {
            List<String> dates = eventsPage.getAllEventDates();
            Assert.assertFalse(dates.isEmpty(), "❌ No event dates found!");
            test.pass("✅ Event dates are displayed correctly: " + dates);
        } catch (Exception e) {
            test.fail("❌ Event dates verification failed: " + e.getMessage());
            Assert.fail("Event dates not found!", e);
        }
    }

    @Test(priority = 11, description = "Verify event assets section is displayed")
    public void verifyEventAssetsSection() {
        test = extent.createTest("Verify Event Assets Section");

        try {
            Assert.assertTrue(eventsPage.isAssetsTextDisplayed(), "❌ Assets text is missing.");
            test.pass("✅ Assets text is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Event assets section verification failed: " + e.getMessage());
            Assert.fail("Assets section not found!", e);
        }
    }


    @Test(priority = 13, description = "Click on first event and verify navigation")
    public void clickFirstEvent() {
        test = extent.createTest("Click First Event");
        try {
            eventsPage.clickEventByIndex(0);
            test.pass("✅ Clicked first event successfully.");
        } catch (Exception e) {
            test.fail("❌ Failed to click first event: " + e.getMessage());
            Assert.fail("Clicking first event failed!", e);
        }
    }

    @Test(priority = 14, description = "Scroll down and return to home")
    public void scrollAndBack() {
        test = extent.createTest("Scroll Down & Return to Home");
        try {
            eventsPage.scrollDown();
            eventsPage.clickBackButton();
            test.pass("✅ Scrolled down and returned to home successfully.");
        } catch (Exception e) {
            test.fail("❌ Failed to scroll or return to home: " + e.getMessage());
            Assert.fail("Scroll or back action failed!", e);
        }
    }
    
    @Test(priority = 15)
    public void verifyEvent() {
        test = extent.createTest("Store First Event Details Before Click");

    	 try {
    	Assert.assertEquals(eventsPage.getEventTitleByIndex(0), "Automation Mobile Event - Beyond Limits: A Journey to Success");
    	Assert.assertEquals(eventsPage.getEventSeverityByIndex(0), "Moderate");
    	Assert.assertEquals(eventsPage.getEventCategory(), "Health");
    	Assert.assertEquals(eventsPage.getEventCountry(0), "Pakistan");
    	 } catch (Exception e) {
             test.fail("❌ Failed to store first event details: " + e.getMessage());
             Assert.fail("Failed to store first event details!", e);
         }
    }
    
    @Test(priority = 16, description = "Store first event details before clicking")
    public void storeFirstEventDetailsBeforeClick() {
        test = extent.createTest("Store First Event Details Before Click");

        try {
            expectedTitle = eventsPage.getEventTitleByIndex(0);
            expectedSeverity = eventsPage.getEventSeverityByIndex(0);
            expectedCategory = eventsPage.getEventCategoryByIndex(0);
            expectedCountry = eventsPage.getEventCountryByIndex(0);

            test.pass("✅ Stored first event details: \n" +
                      "Title: " + expectedTitle + " | Severity: " + expectedSeverity +
                      " | Category: " + expectedCategory + " | Country: " + expectedCountry);
        } catch (Exception e) {
            test.fail("❌ Failed to store first event details: " + e.getMessage());
            Assert.fail("Failed to store first event details!", e);
        }
    }

    @Test(priority = 17, description = "Click on first event and navigate to details page")
    public void clickFirstEventAndNavigate() {
        test = extent.createTest("Click First Event and Navigate");

        try {
            eventsPage.clickEventByIndex(0);
            Thread.sleep(1000); // Small delay to allow transition (if needed)
            test.pass("✅ Clicked on first event successfully.");
        } catch (Exception e) {
            test.fail("❌ Failed to click on first event: " + e.getMessage());
            Assert.fail("First event click failed!", e);
        }
    }

    @Test(priority = 18, description = "Verify first event title after navigation")
    public void verifyFirstEventTitleAfterNavigation() {
        test = extent.createTest("Verify First Event Title After Navigation");

        try {
            String actualTitle = eventsPage.getEventDetailsTitle();
            Assert.assertEquals(actualTitle, expectedTitle, "❌ Event title mismatch after navigation!");
            test.pass("✅ Event title verified after navigation: " + actualTitle);
        } catch (Exception e) {
            test.fail("❌ Event title verification failed after navigation: " + e.getMessage());
            Assert.fail("Event title verification after navigation failed!", e);
        }
    }

    @Test(priority = 19, description = "Verify first event severity after navigation")
    public void verifyFirstEventSeverityAfterNavigation() {
        test = extent.createTest("Verify First Event Severity After Navigation");

        try {
            String actualSeverity = eventsPage.getEventDetailsSeverity();
            Assert.assertEquals(actualSeverity, expectedSeverity, "❌ Event severity mismatch after navigation!");
            test.pass("✅ Event severity verified after navigation: " + actualSeverity);
        } catch (Exception e) {
            test.fail("❌ Event severity verification failed after navigation: " + e.getMessage());
            Assert.fail("Event severity verification after navigation failed!", e);
        }
    }

    @Test(priority = 20, description = "Verify first event category after navigation")
    public void verifyFirstEventCategoryAfterNavigation() {
        test = extent.createTest("Verify First Event Category After Navigation");

        try {
            String actualCategory = eventsPage.getEventDetailsCategory();
            Assert.assertEquals(actualCategory, expectedCategory, "❌ Event category mismatch after navigation!");
            test.pass("✅ Event category verified after navigation: " + actualCategory);
        } catch (Exception e) {
            test.fail("❌ Event category verification failed after navigation: " + e.getMessage());
            Assert.fail("Event category verification after navigation failed!", e);
        }
    }

    @Test(priority = 21, description = "Verify first event country after navigation")
    public void verifyFirstEventCountryAfterNavigation() {
        test = extent.createTest("Verify First Event Country After Navigation");

        try {
            String actualCountry = eventsPage.getEventDetailsCountry();
            Assert.assertEquals(actualCountry, expectedCountry, "❌ Event country mismatch after navigation!");
            test.pass("✅ Event country verified after navigation: " + actualCountry);
        } catch (Exception e) {
            test.fail("❌ Event country verification failed after navigation: " + e.getMessage());
            Assert.fail("Event country verification after navigation failed!", e);
        }
    }
    @Test(priority = 22, description = "Verify event date is displayed on Event Details page")
    public void verifyEventDetailDate() {
        test = extent.createTest("Verify Event Detail Date");

        try {
            Assert.assertTrue(eventsPage.isEventDetailDateDisplayed(), "❌ Event detail date is missing.");
            test.pass("✅ Event detail date is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Event detail date verification failed: " + e.getMessage());
            Assert.fail("Event detail date verification failed!", e);
        }
    }

    @Test(priority = 23, description = "Verify 'Summary' section is displayed on Event Details page")
    public void verifySummarySectionDisplayed() {
        test = extent.createTest("Verify 'Summary' Section");

        try {
            Assert.assertTrue(eventsPage.isSummarySectionDisplayed(), "❌ 'Summary' section is missing.");
            test.pass("✅ 'Summary' section is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'Summary' section verification failed: " + e.getMessage());
            Assert.fail("'Summary' section verification failed!", e);
        }
    }

    @Test(priority = 24, description = "Verify 'Assets' section is displayed on Event Details page")
    public void verifyAssetsSectionDisplayed() {
        test = extent.createTest("Verify 'Assets' Section");

        try {
            Assert.assertTrue(eventsPage.isAssetsSectionDisplayed(), "❌ 'Assets' section is missing.");
            test.pass("✅ 'Assets' section is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ 'Assets' section verification failed: " + e.getMessage());
            Assert.fail("'Assets' section verification failed!", e);
        }
    }

    @Test(priority = 25, description = "Verify the presence of the third ViewGroup instance")
    public void verifyViewGroupInstance() {
        test = extent.createTest("Verify ViewGroup Instance");

        try {
            Assert.assertTrue(eventsPage.isViewGroupInstanceDisplayed(), "❌ ViewGroup instance is missing.");
            test.pass("✅ ViewGroup instance is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ ViewGroup instance verification failed: " + e.getMessage());
            Assert.fail("ViewGroup instance verification failed!", e);
        }
    }

    @Test(priority = 26, description = "Verify Event Details ScrollView is present")
    public void verifyEventDetailsScrollView() {
        test = extent.createTest("Verify Event Details ScrollView");

        try {
            Assert.assertTrue(eventsPage.isEventDetailsScrollViewDisplayed(), "❌ Event details scroll view is missing.");
            test.pass("✅ Event details scroll view is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Event details scroll view verification failed: " + e.getMessage());
            Assert.fail("Event details scroll view verification failed!", e);
        }
    }

    @Test(priority = 27, description = "Verify the presence of the toolbar icon on Event Details page")
    public void verifyToolbarIconDisplayed() {
        test = extent.createTest("Verify Toolbar Icon");

        try {
            Assert.assertTrue(eventsPage.isToolbarIconDisplayed(), "❌ Toolbar icon is missing.");
            test.pass("✅ Toolbar icon is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Toolbar icon verification failed: " + e.getMessage());
            Assert.fail("Toolbar icon verification failed!", e);
        }
    }
    
    
    @Test(priority = 28, description = "Click on Info Icon on Event Details Page")
    public void clickInfoIconOnEventDetailsPage() {
        test = extent.createTest("Click Info Icon on Event Details Page");

        try {
            // Step 1: Verify the info icon is displayed before clicking
            Assert.assertTrue(eventsPage.isToolbarIconDisplayed(), "❌ Info icon is missing.");
            test.pass("✅ Info icon is displayed successfully.");

            // Step 2: Click on the info icon
            eventsPage.clickInfoIconOnEventDetails();
            test.pass("✅ Clicked on the Info Icon successfully.");
        } catch (Exception e) {
            test.fail("❌ Clicking on Info Icon failed: " + e.getMessage());
            Assert.fail("Clicking on Info Icon failed!", e);
        }
    }
    @Test(priority = 29, description = "Verify the Events Page Title is Displayed Correctly")
    public void verifyPageTitleText() {
        test = extent.createTest("Verify Page Title");

        try {
            String actualTitle = destinationReportPage.getPageTitleText();
            Assert.assertEquals(actualTitle, "Event Definition", "❌ Page title does not match!");
            test.pass("✅ Page title verified successfully: " + actualTitle);
        } catch (Exception e) {
            test.fail("❌ Page title verification failed: " + e.getMessage());
            Assert.fail("Page title verification failed!", e);
        }
    }

    @Test(priority = 30, description = "Verify the Presence of the Back Button on the Events Page")
    public void verifyBackButtonPresenceOnEventsPage() {
        test = extent.createTest("Verify Back Button Presence");

        try {
            Assert.assertTrue(destinationReportPage.isBackButtonDisplayed(), "❌ Back button is not displayed!");
            test.pass("✅ Back button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Back button verification failed: " + e.getMessage());
            Assert.fail("Back button verification failed!", e);
        }
    }
    @Test(priority = 31, description = "Verify Toolbar Back Button is Clickable")
    public void verifyToolbarBackButtonClickable() {
        test = extent.createTest("Verify Toolbar Back Button is Clickable");

        try {
            Assert.assertTrue(destinationReportPage.isBackButtonClickable(), "❌ Toolbar Back Button is NOT clickable.");
            test.pass("✅ Toolbar Back Button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Toolbar Back Button clickability verification failed: " + e.getMessage());
            Assert.fail("Toolbar Back Button verification failed!", e);
        }
    }

    @Test(priority = 32, description = "Verify Event Definition Page Title Text")
    public void getEventDefinitionPageTitleText() {
        test = extent.createTest("Verify Event Definition Page Title Text");

        try {
            Assert.assertEquals(destinationReportPage.getPageTitleText(), "Event Definition", "❌ Page Title text mismatch.");
            test.pass("✅ Page Title text is correct: Event Definition.");
        } catch (Exception e) {
            test.fail("❌ Event Definition Page Title verification failed: " + e.getMessage());
            Assert.fail("Event Definition Page Title verification failed!", e);
        }
    }

    @Test(priority = 33, description = "Verify Severities Section is Visible")
    public void verifySeveritiesSectionIsVisible() {
        test = extent.createTest("Verify Severities Section is Visible");

        try {
            Assert.assertTrue(destinationReportPage.isSeveritiesSectionVisible(), "❌ Severities Section is NOT visible.");
            test.pass("✅ Severities Section is visible.");
        } catch (Exception e) {
            test.fail("❌ Severities Section visibility verification failed: " + e.getMessage());
            Assert.fail("Severities Section visibility verification failed!", e);
        }
    }

    @Test(priority = 34, description = "Verify Severities Section Text")
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

    @Test(priority = 35, description = "Verify Severities Section is Clickable")
    public void verifySeveritiesSectionIsClickable() {
        test = extent.createTest("Verify Severities Section is Clickable");

        try {
            Assert.assertTrue(destinationReportPage.isSeveritiesSectionClickable(), "❌ Severities Section is NOT clickable.");
            test.pass("✅ Severities Section is clickable.");
        } catch (Exception e) {
            test.fail("❌ Severities Section clickability verification failed: " + e.getMessage());
            Assert.fail("Severities Section clickability verification failed!", e);
        }
    }

    @Test(priority = 36, description = "Verify Categories Section is Visible")
    public void verifyCategoriesSectionIsVisible() {
        test = extent.createTest("Verify Categories Section is Visible");

        try {
            Assert.assertTrue(destinationReportPage.isCategoriesSectionVisible(), "❌ Categories Section is NOT visible.");
            test.pass("✅ Categories Section is visible.");
        } catch (Exception e) {
            test.fail("❌ Categories Section visibility verification failed: " + e.getMessage());
            Assert.fail("Categories Section verification failed!", e);
        }
    }

    @Test(priority = 37, description = "Verify Categories Section Text")
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

    @Test(priority = 38, description = "Verify Categories Section is Clickable")
    public void verifyCategoriesSectionIsClickable() {
        test = extent.createTest("Verify Categories Section is Clickable");

        try {
            Assert.assertTrue(destinationReportPage.isCategoriesSectionClickable(), "❌ Categories Section is NOT clickable.");
            test.pass("✅ Categories Section is clickable.");
        } catch (Exception e) {
            test.fail("❌ Categories Section clickability verification failed: " + e.getMessage());
            Assert.fail("Categories Section clickability verification failed!", e);
        }
    }

    @Test(priority = 39, description = "Verify Low Severity Title is Displayed")
    public void verifyLowSeverityTitle() {
        test = extent.createTest("Verify Severity Title: Low");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityTitle(0), expectedSeverityTitles[0], "❌ Low Severity title mismatch.");
            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[0]);
        } catch (Exception e) {
            test.fail("❌ Low Severity title verification failed: " + e.getMessage());
            Assert.fail("Low Severity title verification failed!", e);
        }
    }

    @Test(priority = 40, description = "Verify Moderate Severity Title is Displayed")
    public void verifyModerateSeverityTitle() {
        test = extent.createTest("Verify Severity Title: Moderate");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityTitle(1), expectedSeverityTitles[1], "❌ Moderate Severity title mismatch.");
            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[1]);
        } catch (Exception e) {
            test.fail("❌ Moderate Severity title verification failed: " + e.getMessage());
            Assert.fail("Moderate Severity title verification failed!", e);
        }
    }

    @Test(priority = 41, description = "Verify High Severity Title is Displayed")
    public void verifyHighSeverityTitle() {
        test = extent.createTest("Verify Severity Title: High");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityTitle(2), expectedSeverityTitles[2], "❌ High Severity title mismatch.");
            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[2]);
        } catch (Exception e) {
            test.fail("❌ High Severity title verification failed: " + e.getMessage());
            Assert.fail("High Severity title verification failed!", e);
        }
    }

    @Test(priority = 42, description = "Verify Extreme Severity Title is Displayed")
    public void verifyExtremeSeverityTitle() {
        test = extent.createTest("Verify Severity Title: Extreme");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityTitle(3), expectedSeverityTitles[3], "❌ Extreme Severity title mismatch.");
            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[3]);
        } catch (Exception e) {
            test.fail("❌ Extreme Severity title verification failed: " + e.getMessage());
            Assert.fail("Extreme Severity title verification failed!", e);
        }
    }

    @Test(priority = 43, description = "Verify Low Severity Description")
    public void verifyLowSeverityDescription() {
        test = extent.createTest("Verify Severity Description: Low");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityDescription(0), expectedSeverityDescriptions[0], "❌ Low Severity description mismatch.");
            test.pass("✅ Verified Severity Description for Low.");
        } catch (Exception e) {
            test.fail("❌ Low Severity description verification failed: " + e.getMessage());
            Assert.fail("Low Severity description verification failed!", e);
        }
    }

    @Test(priority = 44, description = "Verify Moderate Severity Description")
    public void verifyModerateSeverityDescription() {
        test = extent.createTest("Verify Severity Description: Moderate");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityDescription(1), expectedSeverityDescriptions[1], "❌ Moderate Severity description mismatch.");
            test.pass("✅ Verified Severity Description for Moderate.");
        } catch (Exception e) {
            test.fail("❌ Moderate Severity description verification failed: " + e.getMessage());
            Assert.fail("Moderate Severity description verification failed!", e);
        }
    }

    @Test(priority = 45, description = "Verify High Severity Description")
    public void verifyHighSeverityDescription() {
        test = extent.createTest("Verify Severity Description: High");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityDescription(2), expectedSeverityDescriptions[2], "❌ High Severity description mismatch.");
            test.pass("✅ Verified Severity Description for High.");
        } catch (Exception e) {
            test.fail("❌ High Severity description verification failed: " + e.getMessage());
            Assert.fail("High Severity description verification failed!", e);
        }
    }

    @Test(priority = 46, description = "Verify Extreme Severity Description")
    public void verifyExtremeSeverityDescription() {
        test = extent.createTest("Verify Severity Description: Extreme");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityDescription(3), expectedSeverityDescriptions[3], "❌ Extreme Severity description mismatch.");
            test.pass("✅ Verified Severity Description for Extreme.");
        } catch (Exception e) {
            test.fail("❌ Extreme Severity description verification failed: " + e.getMessage());
            Assert.fail("Extreme Severity description verification failed!", e);
        }
    }
    @Test(priority = 47, description = "Click on Categories Tab")
    public void clickOnCategoriesTab() {
        test = extent.createTest("Click on Categories Tab");

        try {
            destinationReportPage.clickCategoriesTab();
            test.pass("✅ Successfully clicked on the Categories tab.");
        } catch (Exception e) {
            test.fail("❌ Clicking on Categories tab failed: " + e.getMessage());
            Assert.fail("Categories tab click failed!", e);
        }
    }

    @Test(priority = 48, description = "Verify Violence Category Title")
    public void verifyViolenceCategoryTitle() {
        test = extent.createTest("Verify Violence Category Title");

        try {
            Thread.sleep(500); // Small delay to stabilize execution
            String actualTitle = destinationReportPage.getEventDefinitionCardTitle(0);

            Assert.assertEquals(actualTitle, "Violence", "❌ Violence category title mismatch.");
            test.pass("✅ Violence category title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Violence category title verification failed: " + e.getMessage());
            Assert.fail("Violence category title verification failed!", e);
        }
    }

    @Test(priority = 49, description = "Verify Violence Category Description")
    public void verifyViolenceCategoryDescription() {
        test = extent.createTest("Verify Violence Category Description");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(1),
                    "Activities of intentional harm such as active shooters, terrorist events, faction clashes, riots, looting, notable crime, etc.",
                    "❌ Violence category description mismatch.");
            test.pass("✅ Violence category description verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Violence category description verification failed: " + e.getMessage());
            Assert.fail("Violence category description verification failed!", e);
        }
    }

    @Test(priority = 50, description = "Verify Unrest Category Title")
    public void verifyUnrestCategoryTitle() {
        test = extent.createTest("Verify Unrest Category Title");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(1), "Unrest", "❌ Unrest category title mismatch.");
            test.pass("✅ Unrest category title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Unrest category title verification failed: " + e.getMessage());
            Assert.fail("Unrest category title verification failed!", e);
        }
    }

    @Test(priority = 51, description = "Verify Unrest Category Description")
    public void verifyUnrestCategoryDescription() {
        test = extent.createTest("Verify Unrest Category Description");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(2),
                    "Civil disturbances such as strikes, demonstrations, protests, etc.",
                    "❌ Unrest category description mismatch.");
            test.pass("✅ Unrest category description verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Unrest category description verification failed: " + e.getMessage());
            Assert.fail("Unrest category description verification failed!", e);
        }
    }

    @Test(priority = 52, description = "Verify Environment Category Title")
    public void verifyEnvironmentCategoryTitle() {
        test = extent.createTest("Verify Environment Category Title");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(2), "Environment", "❌ Environment category title mismatch.");
            test.pass("✅ Environment category title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Environment category title verification failed: " + e.getMessage());
            Assert.fail("Environment category title verification failed!", e);
        }
    }

    @Test(priority = 53, description = "Verify Environment Category Description")
    public void verifyEnvironmentCategoryDescription() {
        test = extent.createTest("Verify Environment Category Description");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(3),
                    "Primarily natural disasters such as earthquakes, tsunamis, storms, floods, etc.",
                    "❌ Environment category description mismatch.");
            test.pass("✅ Environment category description verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Environment category description verification failed: " + e.getMessage());
            Assert.fail("Environment category description verification failed!", e);
        }
    }

    @Test(priority = 54, description = "Verify Health Category Title")
    public void verifyHealthCategoryTitle() {
        test = extent.createTest("Verify Health Category Title");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(3), "Health", "❌ Health category title mismatch.");
            test.pass("✅ Health category title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Health category title verification failed: " + e.getMessage());
            Assert.fail("Health category title verification failed!", e);
        }
    }

    @Test(priority = 55, description = "Verify Health Category Description")
    public void verifyHealthCategoryDescription() {
        test = extent.createTest("Verify Health Category Description");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(4),
                    "Factors related to physical wellbeing such as disease outbreaks, epidemics, pandemics, endemics, governmental restrictions or requirements on entry and travel, etc.",
                    "❌ Health category description mismatch.");
            test.pass("✅ Health category description verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Health category description verification failed: " + e.getMessage());
            Assert.fail("Health category description verification failed!", e);
        }
    }

    @Test(priority = 56, description = "Verify Infrastructure Category Title")
    public void verifyInfrastructureCategoryTitle() {
        test = extent.createTest("Verify Infrastructure Category Title");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(4), "Infrastructure", "❌ Infrastructure category title mismatch.");
            test.pass("✅ Infrastructure category title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Infrastructure category title verification failed: " + e.getMessage());
            Assert.fail("Infrastructure category title verification failed!", e);
        }
    }

    @Test(priority = 57, description = "Verify Infrastructure Category Description")
    public void verifyInfrastructureCategoryDescription() {
        test = extent.createTest("Verify Infrastructure Category Description");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(5),
                    "Impacts to infrastructure such as building and bridge collapses or damage, transportation incidents, accidental explosions, significant power and communication outages, etc.",
                    "❌ Infrastructure category description mismatch.");
            test.pass("✅ Infrastructure category description verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Infrastructure category description verification failed: " + e.getMessage());
            Assert.fail("Infrastructure category description verification failed!", e);
        }
    }

    @Test(priority = 58, description = "Click on Back Button and Verify Navigation")
    public void clickOnBackButton() {
        test = extent.createTest("Click on Back Button and Verify Navigation");
        try {
            destinationReportPage.clickBackButton();
            test.pass("✅ Successfully clicked on the Back Button and navigated to the previous screen.");
        } catch (Exception e) {
            test.fail("❌ Clicking Back Button failed: " + e.getMessage());
            Assert.fail("Back Button click action failed!", e);
        }
    }
    @Test(priority = 59, description = "Click on the 'Assets' Section")
    public void clickOnAssetsSection() {
        test = extent.createTest("Click on the 'Assets' Section");

        try {
            eventsPage.clickAssetsSection();
            test.pass("✅ Successfully clicked on the 'Assets' section.");
        } catch (Exception e) {
            test.fail("❌ Clicking on 'Assets' section failed: " + e.getMessage());
            Assert.fail("Failed to click on 'Assets' section!", e);
        }
    }
    @Test(priority = 60, description = "Verify Travelers List Section is Displayed")
    public void verifyTravelersListSection() {
        test = extent.createTest("Verify Travelers List Section");

        try {
            Assert.assertTrue(eventsPage.isTravelersListDisplayed(), "❌ Travelers List Section is NOT displayed.");
            test.pass("✅ Travelers List Section is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Travelers List Section verification failed: " + e.getMessage());
            Assert.fail("Travelers List Section verification failed!", e);
        }
    }
    @Test(priority = 61, description = "Verify Share Button is Displayed")
    public void verifyShareButtonPresence() {
        test = extent.createTest("Verify Share Button Presence");

        try {
            Assert.assertTrue(eventsPage.isShareButtonDisplayed(), "❌ Share Button is NOT displayed.");
            test.pass("✅ Share Button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Share Button verification failed: " + e.getMessage());
            Assert.fail("Share Button verification failed!", e);
        }
    }

    @Test(priority = 62, description = "Click on Back Button and Verify Navigation")
    public void clickOnBackButtonAgain() {
        test = extent.createTest("Click on Back Button and Verify Navigation");

        try {
            destinationReportPage.clickBackButton();
            test.pass("✅ Successfully clicked on the Back Button and navigated to the previous screen.");
        } catch (Exception e) {
            test.fail("❌ Clicking Back Button failed: " + e.getMessage());
            Assert.fail("Back Button click action failed!", e);
        }
    }
    
    @Test(priority = 63, description = "Click on the Info Icon")
    public void clickOnQuestionMarkIcon() {
        test = extent.createTest("Click on the Info Icon");

        try {
            destinationReportPage.clickQuestionMarkIcon();
            test.pass("✅ Successfully clicked on the Info Icon.");
        } catch (Exception e) {
            test.fail("❌ Clicking on the Info Icon failed: " + e.getMessage());
            Assert.fail("Failed to click on the Info Icon!", e);
        }
    }

    @Test(priority = 64, description = "Verify the Events Page Title is Displayed Correctly")
    public void verifyEventsPageTitleText() {
        test = extent.createTest("Verify Page Title");

        try {
            String actualTitle = destinationReportPage.getPageTitleText();
            Assert.assertEquals(actualTitle, "Event Definition", "❌ Page title does not match!");
            test.pass("✅ Page title verified successfully: " + actualTitle);
        } catch (Exception e) {
            test.fail("❌ Page title verification failed: " + e.getMessage());
            Assert.fail("Page title verification failed!", e);
        }
    }

   

    @Test(priority = 65, description = "Verify the Presence of the Back Button on the Events Page")
    public void verifyEventsBackButtonPresenceOnEventsPage() {
        test = extent.createTest("Verify Back Button Presence");

        try {
            Assert.assertTrue(destinationReportPage.isBackButtonDisplayed(), "❌ Back button is not displayed!");
            test.pass("✅ Back button is displayed successfully.");
        } catch (Exception e) {
            test.fail("❌ Back button verification failed: " + e.getMessage());
            Assert.fail("Back button verification failed!", e);
        }
    }
    @Test(priority = 66, description = "Verify Toolbar Back Button is Clickable")
    public void verifyEventsToolbarBackButtonClickable() {
        test = extent.createTest("Verify Toolbar Back Button is Clickable");

        try {
            Assert.assertTrue(destinationReportPage.isBackButtonClickable(), "❌ Toolbar Back Button is NOT clickable.");
            test.pass("✅ Toolbar Back Button is clickable.");
        } catch (Exception e) {
            test.fail("❌ Toolbar Back Button clickability verification failed: " + e.getMessage());
            Assert.fail("Toolbar Back Button verification failed!", e);
        }
    }

    @Test(priority = 67, description = "Verify Event Definition Page Title Text")
    public void verifyEventDefinitionPageTitleText() {
        test = extent.createTest("Verify Event Definition Page Title Text");

        try {
            Assert.assertEquals(destinationReportPage.getPageTitleText(), "Event Definition", "❌ Page Title text mismatch.");
            test.pass("✅ Page Title text is correct: Event Definition.");
        } catch (Exception e) {
            test.fail("❌ Event Definition Page Title verification failed: " + e.getMessage());
            Assert.fail("Event Definition Page Title verification failed!", e);
        }
    }

    @Test(priority = 68, description = "Verify Severities Section is Visible")
    public void verifyEventsSeveritiesSectionIsVisible() {
        test = extent.createTest("Verify Severities Section is Visible");

        try {
            Assert.assertTrue(destinationReportPage.isSeveritiesSectionVisible(), "❌ Severities Section is NOT visible.");
            test.pass("✅ Severities Section is visible.");
        } catch (Exception e) {
            test.fail("❌ Severities Section visibility verification failed: " + e.getMessage());
            Assert.fail("Severities Section visibility verification failed!", e);
        }
    }

    @Test(priority = 69, description = "Verify Severities Section Text")
    public void verifyEventsSeveritiesSectionText() {
        test = extent.createTest("Verify Severities Section Text");

        try {
            Assert.assertEquals(destinationReportPage.getSeveritiesSectionText(), "Severities", "❌ Severities Section text mismatch.");
            test.pass("✅ Severities Section text is correct: Severities.");
        } catch (Exception e) {
            test.fail("❌ Severities Section text verification failed: " + e.getMessage());
            Assert.fail("Severities Section text verification failed!", e);
        }
    }

    @Test(priority = 70, description = "Verify Severities Section is Clickable")
    public void verifyEventsSeveritiesSectionIsClickable() {
        test = extent.createTest("Verify Severities Section is Clickable");

        try {
            Assert.assertTrue(destinationReportPage.isSeveritiesSectionClickable(), "❌ Severities Section is NOT clickable.");
            test.pass("✅ Severities Section is clickable.");
        } catch (Exception e) {
            test.fail("❌ Severities Section clickability verification failed: " + e.getMessage());
            Assert.fail("Severities Section clickability verification failed!", e);
        }
    }

    @Test(priority = 71, description = "Verify Categories Section is Visible")
    public void verifyEventsCategoriesSectionIsVisible() {
        test = extent.createTest("Verify Categories Section is Visible");

        try {
            Assert.assertTrue(destinationReportPage.isCategoriesSectionVisible(), "❌ Categories Section is NOT visible.");
            test.pass("✅ Categories Section is visible.");
        } catch (Exception e) {
            test.fail("❌ Categories Section visibility verification failed: " + e.getMessage());
            Assert.fail("Categories Section verification failed!", e);
        }
    }

    @Test(priority = 72, description = "Verify Categories Section Text")
    public void verifyEventsCategoriesSectionText() {
        test = extent.createTest("Verify Categories Section Text");

        try {
            Assert.assertEquals(destinationReportPage.getCategoriesSectionText(), "Categories", "❌ Categories Section text mismatch.");
            test.pass("✅ Categories Section text is correct: Categories.");
        } catch (Exception e) {
            test.fail("❌ Categories Section text verification failed: " + e.getMessage());
            Assert.fail("Categories Section text verification failed!", e);
        }
    }

    @Test(priority = 73, description = "Verify Categories Section is Clickable")
    public void verifyEventsCategoriesSectionIsClickable() {
        test = extent.createTest("Verify Categories Section is Clickable");

        try {
            Assert.assertTrue(destinationReportPage.isCategoriesSectionClickable(), "❌ Categories Section is NOT clickable.");
            test.pass("✅ Categories Section is clickable.");
        } catch (Exception e) {
            test.fail("❌ Categories Section clickability verification failed: " + e.getMessage());
            Assert.fail("Categories Section clickability verification failed!", e);
        }
    }

    @Test(priority = 74, description = "Verify Low Severity Title is Displayed")
    public void verifyEventsLowSeverityTitle() {
        test = extent.createTest("Verify Severity Title: Low");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityTitle(0), expectedSeverityTitles[0], "❌ Low Severity title mismatch.");
            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[0]);
        } catch (Exception e) {
            test.fail("❌ Low Severity title verification failed: " + e.getMessage());
            Assert.fail("Low Severity title verification failed!", e);
        }
    }

    @Test(priority = 75, description = "Verify Moderate Severity Title is Displayed")
    public void verifyEventsModerateSeverityTitle() {
        test = extent.createTest("Verify Severity Title: Moderate");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityTitle(1), expectedSeverityTitles[1], "❌ Moderate Severity title mismatch.");
            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[1]);
        } catch (Exception e) {
            test.fail("❌ Moderate Severity title verification failed: " + e.getMessage());
            Assert.fail("Moderate Severity title verification failed!", e);
        }
    }

    @Test(priority = 76, description = "Verify High Severity Title is Displayed")
    public void verifyEventsHighSeverityTitle() {
        test = extent.createTest("Verify Severity Title: High");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityTitle(2), expectedSeverityTitles[2], "❌ High Severity title mismatch.");
            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[2]);
        } catch (Exception e) {
            test.fail("❌ High Severity title verification failed: " + e.getMessage());
            Assert.fail("High Severity title verification failed!", e);
        }
    }

    @Test(priority = 77, description = "Verify Extreme Severity Title is Displayed")
    public void verifyEventsExtremeSeverityTitle() {
        test = extent.createTest("Verify Severity Title: Extreme");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityTitle(3), expectedSeverityTitles[3], "❌ Extreme Severity title mismatch.");
            test.pass("✅ Verified Severity Title: " + expectedSeverityTitles[3]);
        } catch (Exception e) {
            test.fail("❌ Extreme Severity title verification failed: " + e.getMessage());
            Assert.fail("Extreme Severity title verification failed!", e);
        }
    }

    @Test(priority = 78, description = "Verify Low Severity Description")
    public void verifyEventsLowSeverityDescription() {
        test = extent.createTest("Verify Severity Description: Low");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityDescription(0), expectedSeverityDescriptions[0], "❌ Low Severity description mismatch.");
            test.pass("✅ Verified Severity Description for Low.");
        } catch (Exception e) {
            test.fail("❌ Low Severity description verification failed: " + e.getMessage());
            Assert.fail("Low Severity description verification failed!", e);
        }
    }

    @Test(priority = 79, description = "Verify Moderate Severity Description")
    public void verifyEventsModerateSeverityDescription() {
        test = extent.createTest("Verify Severity Description: Moderate");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityDescription(1), expectedSeverityDescriptions[1], "❌ Moderate Severity description mismatch.");
            test.pass("✅ Verified Severity Description for Moderate.");
        } catch (Exception e) {
            test.fail("❌ Moderate Severity description verification failed: " + e.getMessage());
            Assert.fail("Moderate Severity description verification failed!", e);
        }
    }

    @Test(priority = 80, description = "Verify High Severity Description")
    public void verifyEventsHighSeverityDescription() {
        test = extent.createTest("Verify Severity Description: High");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityDescription(2), expectedSeverityDescriptions[2], "❌ High Severity description mismatch.");
            test.pass("✅ Verified Severity Description for High.");
        } catch (Exception e) {
            test.fail("❌ High Severity description verification failed: " + e.getMessage());
            Assert.fail("High Severity description verification failed!", e);
        }
    }

    @Test(priority = 81, description = "Verify Extreme Severity Description")
    public void verifyEventsExtremeSeverityDescription() {
        test = extent.createTest("Verify Severity Description: Extreme");

        try {
            Assert.assertEquals(destinationReportPage.getSeverityDescription(3), expectedSeverityDescriptions[3], "❌ Extreme Severity description mismatch.");
            test.pass("✅ Verified Severity Description for Extreme.");
        } catch (Exception e) {
            test.fail("❌ Extreme Severity description verification failed: " + e.getMessage());
            Assert.fail("Extreme Severity description verification failed!", e);
        }
    }
    @Test(priority = 82, description = "Click on Categories Tab")
    public void clickOnEventsCategoriesTab() {
        test = extent.createTest("Click on Categories Tab");

        try {
            destinationReportPage.clickCategoriesTab();
            test.pass("✅ Successfully clicked on the Categories tab.");
        } catch (Exception e) {
            test.fail("❌ Clicking on Categories tab failed: " + e.getMessage());
            Assert.fail("Categories tab click failed!", e);
        }
    }

    @Test(priority = 83, description = "Verify Violence Category Title")
    public void verifyEventsViolenceCategoryTitle() {
        test = extent.createTest("Verify Violence Category Title");

        try {
            Thread.sleep(500); // Small delay to stabilize execution
            String actualTitle = destinationReportPage.getEventDefinitionCardTitle(0);

            Assert.assertEquals(actualTitle, "Violence", "❌ Violence category title mismatch.");
            test.pass("✅ Violence category title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Violence category title verification failed: " + e.getMessage());
            Assert.fail("Violence category title verification failed!", e);
        }
    }

    @Test(priority = 84, description = "Verify Violence Category Description")
    public void verifyEventsViolenceCategoryDescription() {
        test = extent.createTest("Verify Violence Category Description");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(1),
                    "Activities of intentional harm such as active shooters, terrorist events, faction clashes, riots, looting, notable crime, etc.",
                    "❌ Violence category description mismatch.");
            test.pass("✅ Violence category description verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Violence category description verification failed: " + e.getMessage());
            Assert.fail("Violence category description verification failed!", e);
        }
    }

    @Test(priority = 85, description = "Verify Unrest Category Title")
    public void verifyEventsUnrestCategoryTitle() {
        test = extent.createTest("Verify Unrest Category Title");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(1), "Unrest", "❌ Unrest category title mismatch.");
            test.pass("✅ Unrest category title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Unrest category title verification failed: " + e.getMessage());
            Assert.fail("Unrest category title verification failed!", e);
        }
    }

    @Test(priority = 86, description = "Verify Unrest Category Description")
    public void verifyEventsUnrestCategoryDescription() {
        test = extent.createTest("Verify Unrest Category Description");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(2),
                    "Civil disturbances such as strikes, demonstrations, protests, etc.",
                    "❌ Unrest category description mismatch.");
            test.pass("✅ Unrest category description verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Unrest category description verification failed: " + e.getMessage());
            Assert.fail("Unrest category description verification failed!", e);
        }
    }

    @Test(priority = 87, description = "Verify Environment Category Title")
    public void verifyEventsEnvironmentCategoryTitle() {
        test = extent.createTest("Verify Environment Category Title");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(2), "Environment", "❌ Environment category title mismatch.");
            test.pass("✅ Environment category title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Environment category title verification failed: " + e.getMessage());
            Assert.fail("Environment category title verification failed!", e);
        }
    }

    @Test(priority = 88, description = "Verify Environment Category Description")
    public void verifyEventsEnvironmentCategoryDescription() {
        test = extent.createTest("Verify Environment Category Description");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(3),
                    "Primarily natural disasters such as earthquakes, tsunamis, storms, floods, etc.",
                    "❌ Environment category description mismatch.");
            test.pass("✅ Environment category description verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Environment category description verification failed: " + e.getMessage());
            Assert.fail("Environment category description verification failed!", e);
        }
    }

    @Test(priority = 89, description = "Verify Health Category Title")
    public void verifyEventsHealthCategoryTitle() {
        test = extent.createTest("Verify Health Category Title");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(3), "Health", "❌ Health category title mismatch.");
            test.pass("✅ Health category title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Health category title verification failed: " + e.getMessage());
            Assert.fail("Health category title verification failed!", e);
        }
    }

    @Test(priority = 90, description = "Verify Health Category Description")
    public void verifyEventsHealthCategoryDescription() {
        test = extent.createTest("Verify Health Category Description");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(4),
                    "Factors related to physical wellbeing such as disease outbreaks, epidemics, pandemics, endemics, governmental restrictions or requirements on entry and travel, etc.",
                    "❌ Health category description mismatch.");
            test.pass("✅ Health category description verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Health category description verification failed: " + e.getMessage());
            Assert.fail("Health category description verification failed!", e);
        }
    }

    @Test(priority = 91, description = "Verify Infrastructure Category Title")
    public void verifyEventsInfrastructureCategoryTitle() {
        test = extent.createTest("Verify Infrastructure Category Title");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardTitle(4), "Infrastructure", "❌ Infrastructure category title mismatch.");
            test.pass("✅ Infrastructure category title verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Infrastructure category title verification failed: " + e.getMessage());
            Assert.fail("Infrastructure category title verification failed!", e);
        }
    }
    

    @Test(priority = 92, description = "Verify Infrastructure Category Description")
    public void verifyEventsInfrastructureCategoryDescription() {
        test = extent.createTest("Verify Infrastructure Category Description");

        try {
            Assert.assertEquals(destinationReportPage.getEventDefinitionCardDescription(5),
                    "Impacts to infrastructure such as building and bridge collapses or damage, transportation incidents, accidental explosions, significant power and communication outages, etc.",
                    "❌ Infrastructure category description mismatch.");
            test.pass("✅ Infrastructure category description verified successfully.");
        } catch (Exception e) {
            test.fail("❌ Infrastructure category description verification failed: " + e.getMessage());
            Assert.fail("Infrastructure category description verification failed!", e);
        }
    }
   
    @Test(priority = 93, description = "Click Back Button Twice and Verify Navigation")
    public void clickBackButtonOnce() {
        test = extent.createTest("Click Back Button Twice and Verify Navigation");

        try {
            // Click back button the first time
            destinationReportPage.clickBackButton();
            test.pass("✅ Successfully clicked the Back Button (1st time).");

            // Wait briefly before clicking again to ensure UI is stable
            Thread.sleep(1000);

//            // Click back button the second time
//            destinationReportPage.clickBackButton();
//            test.pass("✅ Successfully clicked the Back Button (2nd time).");

        } catch (Exception e) {
            test.fail("❌ Clicking Back Button twice failed: " + e.getMessage());
            Assert.fail("Failed to navigate back twice!", e);
        }
    }
    
    @Test(priority = 94)
    public void verifyUnreadEventCard() {
        try {
            Assert.assertTrue(alertsPage.isUnreadEventCardPresent(),
                    "❌ FAIL: Unread Event Card is NOT present on the page!");
            System.out.println("✅ PASS: Unread Event Card is present.");
        } catch (AssertionError e) {
            System.err.println("❌ Test Failed: Unread Event Card verification failed! " + e.getMessage());
            Assert.fail("Unread Event Card test failed.");
        } catch (Exception e) {
            System.err.println("❌ Unexpected Error in verifyUnreadEventCard: " + e.getMessage());
            Assert.fail("Unexpected failure in verifyUnreadEventCard.");
        }
    }

    /**
     * Verify and click on the alert info icon
     */
    @Test(priority = 95, dependsOnMethods = "verifyUnreadEventCard")
    public void verifyAndClickAlertInfoIcon() {
        try {
        	alertsPage.clickAlertInfoIcon();
            System.out.println("✅ PASS: Clicked on Alert Info Icon successfully.");
        } catch (AssertionError e) {
            System.err.println("❌ Test Failed: Alert Info Icon Click Failed! " + e.getMessage());
            Assert.fail("Alert Info Icon Click test failed.");
        } catch (Exception e) {
            System.err.println("❌ Unexpected Error in verifyAndClickAlertInfoIcon: " + e.getMessage());
            Assert.fail("Unexpected failure in verifyAndClickAlertInfoIcon.");
        }
    }

    /**
     * Verify alert dialog title
     */
    @Test(priority = 96, dependsOnMethods = "verifyAndClickAlertInfoIcon")
    public void verifyAlertDialogTitle() {
        try {
            String expectedTitle = "How do I get alerts?";
            String actualTitle = alertsPage.getAlertDialogTitle();
            Assert.assertEquals(actualTitle, expectedTitle,
                    "❌ FAIL: Alert Dialog Title does NOT match expected value!");
            System.out.println("✅ PASS: Alert Dialog Title verified successfully.");
        } catch (AssertionError e) {
            System.err.println("❌ Test Failed: Alert Dialog Title verification failed! " + e.getMessage());
            Assert.fail("Alert Dialog Title test failed.");
        } catch (Exception e) {
            System.err.println("❌ Unexpected Error in verifyAlertDialogTitle: " + e.getMessage());
            Assert.fail("Unexpected failure in verifyAlertDialogTitle.");
        }
    }

    /**
     * Verify alert dialog message
     */
    @Test(priority = 97, dependsOnMethods = "verifyAlertDialogTitle")
    public void verifyAlertDialogMessage() {
        try {
            String expectedMessage = "You receive alerts from Global Rescue's GRID platform based on the alert profiles setup either by you or by your employer.\n\n"
                    + "To manage or setup alerts that your organization's eligible employees will receive, please login to GRID web portal and click on Administration ➔ Alert Profiles.";

            String actualMessage = alertsPage.getAlertDialogMessage();
            Assert.assertEquals(actualMessage, expectedMessage,
                    "❌ FAIL: Alert Dialog Message does NOT match expected value!");
            System.out.println("✅ PASS: Alert Dialog Message verified successfully.");
        } catch (AssertionError e) {
            System.err.println("❌ Test Failed: Alert Dialog Message verification failed! " + e.getMessage());
            Assert.fail("Alert Dialog Message test failed.");
        } catch (Exception e) {
            System.err.println("❌ Unexpected Error in verifyAlertDialogMessage: " + e.getMessage());
            Assert.fail("Unexpected failure in verifyAlertDialogMessage.");
        }
    }

    /**
     * Verify and click the close button
     */
    @Test(priority = 98, dependsOnMethods = "verifyAlertDialogMessage")
    public void verifyAndClickCloseButton() {
        try {
            alertsPage.clickCloseButton();
            System.out.println("✅ PASS: Close Button clicked successfully.");
        } catch (AssertionError e) {
            System.err.println("❌ Test Failed: Close Button Click Failed! " + e.getMessage());
            Assert.fail("Close Button test failed.");
        } catch (Exception e) {
            System.err.println("❌ Unexpected Error in verifyAndClickCloseButton: " + e.getMessage());
            Assert.fail("Unexpected failure in verifyAndClickCloseButton.");
        }
    }
    @Test(priority = 99, description = "Click Back Button Twice and Verify Navigation")
    public void clickBackButtonAgain() {
        test = extent.createTest("Click Back Button Twice and Verify Navigation");

        try {
            // Click back button the first time
            destinationReportPage.clickBackButton();
            test.pass("✅ Successfully clicked the Back Button (1st time).");

            // Wait briefly before clicking again to ensure UI is stable
            Thread.sleep(1000);


        } catch (Exception e) {
            test.fail("❌ Clicking Back Button twice failed: " + e.getMessage());
            Assert.fail("Failed to navigate back twice!", e);
        }
    }



   

    @AfterMethod
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
}
