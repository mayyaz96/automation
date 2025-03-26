package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class EventsPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    // Constructor
    public EventsPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    private By alertsTab = By.id("com.globalrescue.enterprise:id/event_alerts_constraint"); // Alert tab
    // 📌 Elements on Events Page
    private By eventsTab = By.id("com.globalrescue.enterprise:id/events");
    private By backButton = By.id("com.globalrescue.enterprise:id/toolbar_back");
    private By pageTitle = By.id("com.globalrescue.enterprise:id/title"); // Should be "Events"
    private By infoIcon = By.id("com.globalrescue.enterprise:id/eventAlertControllerInfoIcon");
    private By filterIcon = By.id("com.globalrescue.enterprise:id/iconEventFilterSheet");
    private By searchBar = By.id("com.globalrescue.enterprise:id/searchBar");

    // 📌 Event Card Elements
    private By eventCard = By.id("com.globalrescue.enterprise:id/event_item_card_container");
    private By eventTitle = By.id("com.globalrescue.enterprise:id/event_item_card_title");
    private By eventSeverity = By.id("com.globalrescue.enterprise:id/eventSeverityText"); // Low/Moderate/High/Extreme
    private By eventCategory = By.id("com.globalrescue.enterprise:id/event_item_card_chip_group"); // Health, Unrest, etc.
    private By eventCountries = By.id("com.globalrescue.enterprise:id/event_item_card_countries_chip_group");
    private By eventDate = By.id("com.globalrescue.enterprise:id/event_item_card_date");
    private By assetsText = By.id("com.globalrescue.enterprise:id/ll_assets_count_n_word"); // Contains "assets"
    private By emptyScreenTitle = By.id("com.globalrescue.enterprise:id/events_empty_view");
    
    private By emptyScreenTitle2 = By.id("com.globalrescue.enterprise:id/events_empty_view_title");
    private By emptyDescription = By.id("com.globalrescue.enterprise:id/events_empty_view_description");
    private By emptyDescription2 = By.id("com.globalrescue.enterprise:id/events_empty_view_description_accountBased");

    
    // 📌 Click on the Events Tab
    public void clickEventsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(eventsTab)).click();
    }

    // 📌 Verify if Page Title is Displayed
    public boolean isPageTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
    }

    // 📌 Get Page Title Text
    public String getPageTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
    }

    // 📌 Verify if Info Icon is Displayed
    public boolean isInfoIconDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(infoIcon)).isDisplayed();
    }

    // 📌 Verify if Filter Icon is Displayed
    public boolean isFilterIconDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(filterIcon)).isDisplayed();
    }

    // 📌 Verify if Search Bar is Displayed
    public boolean isSearchBarDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar)).isDisplayed();
    }

    // 📌 Verify Event List is Displayed
    public boolean isEventListDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(eventCard)).isDisplayed();
    }

    // 📌 Get All Event Titles
    public List<String> getAllEventTitles() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(eventTitle))
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // 📌 Get All Event Severities
    public List<String> getAllEventSeverities() {
        return driver.findElements(eventSeverity)
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // 📌 Get All Event Categories
    public List<String> getAllEventCategories() {
        return driver.findElements(eventCategory)
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // 📌 Get All Event Countries
    public List<String> getAllEventCountries() {
        return driver.findElements(eventCountries)
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // 📌 Get All Event Dates
    public List<String> getAllEventDates() {
        return driver.findElements(eventDate)
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // 📌 Verify if "Assets" Text is Present
    public boolean isAssetsTextDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(assetsText)).isDisplayed();
    }

    // 📌 Click on Back Button
    public void clickBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }

    // 📌 Click on a Specific Event by Index
    public void clickEventByIndex(int index) {
        List<WebElement> eventElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(eventTitle));

        if (index >= eventElements.size()) {
            throw new IndexOutOfBoundsException("❌ Index out of range. Found only " + eventElements.size() + " events.");
        }

        eventElements.get(index).click();
    }

    // 📌 Scroll Down Method
    public boolean scrollDown() {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
            ));
            Thread.sleep(1000); // Allow scrolling to complete
            return true;
        } catch (Exception e) {
            return false; // End of scrollable area reached
        }
    }
    public String getEventTitleByIndex(int index) {
        List<WebElement> eventTitles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.id("com.globalrescue.enterprise:id/event_item_card_title")
        ));

        if (index >= eventTitles.size()) {
            throw new IndexOutOfBoundsException("❌ Index " + index + " is out of bounds. Found only " + eventTitles.size() + " events.");
        }

        return eventTitles.get(index).getText().trim();
    }
//    public String getEventDetailsTitle() {
//        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//            By.id("com.globalrescue.enterprise:id/event_detail_title") // Ensure this ID is correct for event details title
//        ));
//        return titleElement.getText().trim();
//    }
 // 📌 Get Event Severity by Index (Before Clicking)
    public String getEventSeverityByIndex(int index) {
        List<WebElement> severities = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.id("com.globalrescue.enterprise:id/eventSeverityText")
        ));

        if (index >= severities.size()) {
            throw new IndexOutOfBoundsException("❌ Index " + index + " is out of bounds. Found only " + severities.size() + " events.");
        }

        return severities.get(index).getText().trim();
    }

    // 📌 Get Event Category by Index (Before Clicking)
    public String getEventCategoryByIndex(int index) {
        List<WebElement> categories = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.id("com.globalrescue.enterprise:id/event_item_card_chip_group")
        ));

        if (index >= categories.size()) {
            throw new IndexOutOfBoundsException("❌ Index " + index + " is out of bounds. Found only " + categories.size() + " events.");
        }

        return categories.get(index).getText().trim();
    }

    // 📌 Get Event Country Name by Index (Before Clicking)
    public String getEventCountryByIndex(int index) {
        List<WebElement> countries = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.id("com.globalrescue.enterprise:id/event_item_card_countries_chip_group")
        ));

        if (index >= countries.size()) {
            throw new IndexOutOfBoundsException("❌ Index " + index + " is out of bounds. Found only " + countries.size() + " events.");
        }

        return countries.get(index).getText().trim();
    }

    // 📌 Get Event Title from Details Page (After Clicking)
    public String getEventDetailsTitle() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("com.globalrescue.enterprise:id/event_detail_title")
        ));
        return titleElement.getText().trim();
    }

    // 📌 Get Event Severity from Details Page
    public String getEventDetailsSeverity() {
        WebElement severityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("com.globalrescue.enterprise:id/eventSeverityText")
        ));
        return severityElement.getText().trim();
    }

    // 📌 Get Event Category from Details Page
    public String getEventDetailsCategory() {
        WebElement categoryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("com.globalrescue.enterprise:id/event_detail_chip_group")
        ));
        return categoryElement.getText().trim();
    }

    // 📌 Get Event Country from Details Page
    public String getEventDetailsCountry() {
        WebElement countryElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.id("com.globalrescue.enterprise:id/event_item_card_countries_chip_group")
        ));
        return countryElement.getText().trim();
    }
 // Wait for Event Details Page to Load Before Fetching Title
 // Verify if Event Detail Date is displayed
    public boolean isEventDetailDateDisplayed() {
        try {
            return driver.findElement(By.id("com.globalrescue.enterprise:id/event_detail_date")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if 'Summary' section is displayed
    public boolean isSummarySectionDisplayed() {
        try {
            return driver.findElement(By.xpath("//android.widget.TextView[@text='Summary']")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if 'Assets' section is displayed
    public boolean isAssetsSectionDisplayed() {
        try {
            return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Assets\").instance(1)")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if the third ViewGroup instance is present
    public boolean isViewGroupInstanceDisplayed() {
        try {
            return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(2)")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Event Details ScrollView is displayed
    public boolean isEventDetailsScrollViewDisplayed() {
        try {
            return driver.findElement(By.id("com.globalrescue.enterprise:id/event_details_scrollview")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Verify if Toolbar Icon is displayed
    public boolean isToolbarIconDisplayed() {
        try {
            return driver.findElement(By.id("com.globalrescue.enterprise:id/toolbar_icon")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void clickAssetsSection() {
        try {
            WebElement assetsSection = wait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.androidUIAutomator("new UiSelector().text(\"Assets\").instance(1)")));
            assetsSection.click();
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to click on 'Assets' section: " + e.getMessage(), e);
        }
    }

    // Wait for Event Details Page to Load Before Fetching Severity
    
 // 📌 Verify if Info Icon is Displayed
    public boolean isTravelersListDisplayed() {
        try {
            WebElement travelersList = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.globalrescue.enterprise:id/travelersListRV")));
            return travelersList.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isShareButtonDisplayed() {
        try {
            WebElement shareButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.globalrescue.enterprise:id/share")));
            return shareButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    // 📌 Click on Info Icon
   
    public void clickInfoIcon() {
        WebElement infoIcon = driver.findElement(By.id("com.globalrescue.enterprise:id/eventAlertControllerInfoIcon"));
        infoIcon.click();
    }

	public boolean isInfoIconDisplayedOnEventDetails() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/toolbar_icon"))).isDisplayed();

	}

	public void clickInfoIconOnEventDetails() {
		WebElement infoIcon = driver.findElement(By.id("com.globalrescue.enterprise:id/toolbar_icon"));
        infoIcon.click();
		
	}

	public void clickAlertsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(alertsTab)).click();

		
	}

	public boolean emptyScreen() {
	    try {
	        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3)); // Reduce timeout
	        WebElement emptyScreenElement = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/events_empty_view_title")));
	        return emptyScreenElement.isDisplayed();
	    } catch (TimeoutException e) {
	        return false;  // Return false if empty screen is not found
	    }
	}


	public String emptyTitle() {	
		return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyScreenTitle)).getText().trim();
	}

	public String emptyTitle2() {
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyScreenTitle2)).getText().trim();
	}

	public String emptyDescription() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyDescription)).getText().trim();
	}

	public String emptyDescription2() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyDescription2)).getText().trim();
	}

	public void putAppInBackground(int seconds) {
	    driver.runAppInBackground(Duration.ofSeconds(seconds));
	}

	public void openNotifications() {
	    driver.openNotifications();
	}

	public String getEventCategory() {
		// TODO Auto-generated method stub
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.Button[@text='Health'])[1]"))).getText().trim();

	}

	public String getEventCountry(int i) {
		        WebElement country = wait.until(ExpectedConditions.presenceOfElementLocated(
		            By.xpath("(//android.widget.Button[@text=\"Pakistan\"])[1]")
		        ));

		       

		        return country.getText().trim();
		    }


    

}
