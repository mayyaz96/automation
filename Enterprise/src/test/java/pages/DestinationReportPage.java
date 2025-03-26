package pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class DestinationReportPage {
	 // ✅ Constructor to receive driver and wait
    

    // Example Method: Click on Destination Report Tab
   
	private AndroidDriver driver;
    private WebDriverWait wait;
    
    public DestinationReportPage(AndroidDriver driver, WebDriverWait wait) {
        if (driver == null) {
            throw new IllegalArgumentException("AndroidDriver cannot be null!");
        }
        this.driver = driver;
        this.wait = wait;
    }
    // Encapsulated Expected Card Text Values
    private final String LOW = "Low";
    private final String MODERATE = "Moderate";
    private final String HIGH = "High";
    private final String EXTREME = "Extreme";
    
    public final String DescriptionOfLow = "Destinations classified as Low are generally considered safe for travel and free from major incidents. Authorities maintain adequate security/health/emergency services and enjoy the support of the military. The country has sound and reliable infrastructure. There is no evidence that terrorist groups possess the capacity or capability to sustain operations in the area; attacks are very rare. Instances of violent crime are rare and foreigners are rarely the targets of criminal groups. Kidnapping is a relatively rare occurrence and is not a syndicated activity. Protests are infrequent, normally small-scale, and are rarely accompanied by violence. The political transition is peaceful and occurs in accordance with the constitution.";
    public final String DescriptionOfModerate = "Destinations classified as Moderate are generally considered safe for travel but are subject to bouts of political and civil unrest. Some weaknesses appear in the nation’s security/health/emergency services and infrastructure. Terrorist groups have demonstrated the capability to operate in the area and attack foreign assets but have not yet demonstrated intent. Kidnapping as a means of gaining revenue does occur but foreigners are rarely the targets of kidnappers. There are instances of violent crime, and foreigners are occasionally the targets of violent crime. Protests occur with relative frequency, and normally involve large groups. Protests are sometimes accompanied by violence. There has been some form of armed conflict (war, insurgency, separatism) within the country over the past five years, which has not been finally resolved to the satisfaction of all stakeholders. There are domestic separatist or ethnic groups that have shown the potential to embark on an armed struggle. Political transition is occasionally accompanied by large-scale protest which may involve violence. Transition usually occurs in accordance with the constitution, though some form of coup or assumption of power has occurred in the past five years. The relationship between political parties is typically antagonistic and marked by occasional violence between supporters. Opposition parties are antagonistic to the government of the day and actively promote large-scale protest action when debate fails.";
    public final String DescriptionOfHigh = "Destinations classified as High are generally considered as not safe for travel without stringent security precautions due to common bouts of political instability, civil unrest and violence. There is serious doubt to the reliability of the nation’s security/health/emergency services. Infrastructure is poor and corruption at all levels is common. Foreign interests have previously been the target terrorist attacks and it has been assessed that there is a risk of future attacks. Terrorist groups are actively operating in the area. These groups possess sufficient capability and have demonstrated intent to target similar organizations. Kidnap gangs are known to operate and foreigners are occasionally the targets of kidnappers. Instances of violent crime occur frequently, and foreigners are often the targets of criminal groups. Protests occur with a high level of frequency, and normally involve very large groups. Protests are often accompanied by violence. There is an ongoing low-level conflict with a neighboring country. There is an active insurgency that affects the area. Domestic separatist or ethnic groups routinely target police, government or other groups, not including foreigners. The political situation has been unstable in recent months. Political transition is often accompanied by large-scale protest which usually involves violence. Transition usually involves some form of coup or assumption of power. The relationship between political parties is typically highly antagonistic and marked by frequent violence between supporters. Opposition parties are antagonistic to the government of the day and are actively promoting violent protest action.";
    public final String DescriptionOfExtreme = "Destinations classified as Extreme are not considered safe and need for travel should be thoroughly evaluated against the significant level of threats and security concerns. Extreme destinations are often classified as failed or failing states and unable to provide security/health/emergency services. Infrastructure is deteriorating or destroyed. Terrorist groups are actively operating in the area. These groups possess high-level capability and intent to target foreigners. Kidnapping and violent crime are endemic. Security forces are either unwilling or unable to combat the problem posed by crime. Protests are frequent, and have been accompanied by severe violence. Security forces are unable to maintain control over protests. There is an ongoing conflict. Areas of the country are under the control of insurgent groups who are targeting foreigners. Foreigners cannot move within the area without armed security support. The political situation is extremely unstable. Political transition is usually accompanied by large-scale protest which usually involves violence. Transition usually involves some form of violent coup or assumption of power. There is no effective government in place.";
    // Locators
    private By destinationReportTab = By.xpath("//android.widget.FrameLayout[@resource-id='com.globalrescue.enterprise:id/view_reports']/android.view.ViewGroup");
    private By countrySearchField = By.id("com.globalrescue.enterprise:id/etCountrySearch");
    private By downloadButton = By.xpath("//android.widget.ImageView[@resource-id='com.globalrescue.enterprise:id/ivStatus']");
    private By countryName = By.id("com.globalrescue.enterprise:id/tvCountryName");
    // Locators for Destination Report elements
    private By title = By.id("com.globalrescue.enterprise:id/title");
    private By backButton = By.id("com.globalrescue.enterprise:id/toolbar_back");
    private By DRcountryName = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/countryName']");
    private By overallRiskLabel = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/textView18']");
    private By riskLevel = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/risk_level']");
 
    // Locators
    private By pageTitle = By.id("com.globalrescue.enterprise:id/title");
    private By infoIcon = By.id("com.globalrescue.enterprise:id/eventAlertControllerInfoIcon");
    //private By backButton = By.id("com.globalrescue.enterprise:id/toolbar_back");
    private By eventCard = By.id("com.globalrescue.enterprise:id/event_item_card_container");
    private By eventTitle = By.id("com.globalrescue.enterprise:id/event_item_card_title");
    private By eventSeverity = By.id("com.globalrescue.enterprise:id/eventSeverityText");
    private By eventCategory = By.id("com.globalrescue.enterprise:id/event_item_card_chip_group");
    private By eventCountries = By.id("com.globalrescue.enterprise:id/event_item_card_countries_chip_group");
    private By eventDate = By.id("com.globalrescue.enterprise:id/event_item_card_date");
 // Toolbar Back Button
    @FindBy(id = "com.globalrescue.enterprise:id/toolbar_back")
    private WebElement toolbarBackButton;

    // Page Title
    @FindBy(id = "com.globalrescue.enterprise:id/title")
    private WebElement EventDefinitionPageTitle;

    // Severities Section
    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Severities']")
    private WebElement severitiesSection;

    // Categories Section
    @FindBy(xpath = "//android.widget.TextView[@text='Categories']")
    private WebElement categoriesSection;
    // Scroll View
    @FindBy(id = "com.globalrescue.enterprise:id/risk_rating_def_scrollview")
    private WebElement scrollView;
 // Locators
    private By riskOverviewTitle = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/title']");
    private By cardView = By.id("com.globalrescue.enterprise:id/card_wv");
    private By riskRatingText = By.xpath("//*[contains(@resource-id, 'reportView')]");

    // Constructor
    // Locators
    private By usaLogo = By.xpath("//android.widget.Image[@text=\"PAK\"]");
    private By textView = By.className("android.widget.TextView");
    private By generalOverviewTitle = By.xpath("//android.widget.TextView[@text='General Overview']");

    // Locators
    private By securityAssessmentRows = By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView");
    private By expandCollapseButtons = By.xpath("//android.widget.ScrollView/android.widget.LinearLayout//android.widget.ImageView");
 // Locator Declarations
    private By securityAssessmentTitle = By.id("com.globalrescue.enterprise:id/title");
    private By securityRiskRating = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/ratingText']");
    private By extremeRiskRating = By.id("com.globalrescue.enterprise:id/riskRating");
 
 // Locators
    private By destinationDetailsTitle = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/title']");
    private By webView = By.className("android.webkit.WebView");
 // Locators
    private By entryExitTitle = By.id("com.globalrescue.enterprise:id/title");
 // Locators
    private By importantNumbersTitle = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/title']");

    // Methods
    public boolean isImportantNumbersTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(importantNumbersTitle)).isDisplayed();
    }

    // Method to verify Entry & Exit Requirements title is displayed
    public boolean isEntryExitTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(entryExitTitle)).isDisplayed();
    }

    // Method to scroll down till screen end
    public void scrollToEnd() {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(5)"));
        } catch (Exception e) {
            System.out.println("Scrolling to end failed: " + e.getMessage());
        }
    }

    // Methods
    public boolean isDestinationDetailsTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(destinationDetailsTitle)).isDisplayed();
    }

   

    public boolean isWebViewDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(webView)).isDisplayed();
    }

    

    
    // Method to verify if Security Assessment title is displayed
    public boolean isSecurityAssessmentTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(securityAssessmentTitle)).isDisplayed();
    }
    public boolean verifyRowExpandCollapse(String rowTitle) {
        try {
            if (!isRowTitleDisplayed(rowTitle)) {
                return false;
            }

            expandRow(rowTitle);
            if (!isRowExpanded(rowTitle)) {
                return false;
            }

            collapseRow(rowTitle);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


   

    // Method to verify if Security Risk Rating is displayed
    public boolean isSecurityRiskRatingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(securityRiskRating)).isDisplayed();
    }

    // Method to verify if Extreme Risk Rating is displayed
    public boolean isExtremeRiskRatingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(extremeRiskRating)).isDisplayed();
    }
    public List<String> getExpandableSecurityAssessmentRowTitles() {
        List<WebElement> rowElements = driver.findElements(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView"));
        return rowElements.stream()
            .map(WebElement::getText)
            .filter(title -> !title.equals("Security Risk Rating") && !title.equals("Extreme")) // Skip non-expandable rows
            .collect(Collectors.toList());
    }
 

   

    

    // Method to check if a row is expanded
    public boolean isRowExpanded(String rowTitle) {
        try {
            WebElement expandedElement = driver.findElement(By.xpath("//android.widget.TextView[@text='" + rowTitle + "']/following-sibling::*"));
            return expandedElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    // Method to retrieve all row titles
    public List<String> getSecurityAssessmentRowTitles() {
        List<WebElement> rowElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(securityAssessmentRows));
        return rowElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

 // Method to check if a row title is displayed
    public boolean isRowTitleDisplayed(String rowTitle) {
        try {
            WebElement rowElement = driver.findElement(By.xpath("//android.widget.TextView[@text='" + rowTitle + "']"));
            return rowElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to expand a row based on title
    public void expandRow(String rowTitle) {
        WebElement rowElement = driver.findElement(By.xpath("//android.widget.TextView[@text='" + rowTitle + "']/following-sibling::android.widget.ImageView"));
        rowElement.click();
    }

    // Method to collapse a row based on title
    public void collapseRow(String rowTitle) {
        expandRow(rowTitle); // Since clicking again will collapse
    }

  


   
    // Method to verify if Title is displayed
    public boolean isTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).isDisplayed();
    }

    // Method to click Back Button
   

    // Method to verify if USA Logo is displayed
    public boolean isUSALogoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usaLogo)).isDisplayed();
    }

    // Method to verify if Text View is displayed
    public boolean isTextViewDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textView)).isDisplayed();
    }

    // Method to verify if General Overview title is displayed
    public boolean isGeneralOverviewTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(generalOverviewTitle)).isDisplayed();
    }
    // Method to get Risk Overview Title
    public String getRiskOverviewTitle() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(riskOverviewTitle));
        return element.getText();
    }

    

    // Method to check if Card View is displayed
    public boolean isCardViewDisplayed() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cardView));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getRiskRatingText() {
        try {System.out.println(driver.getContextHandles());
            // Switch to WebView if available
            for (String context : driver.getContextHandles()) {
                if (context.contains("WEBVIEW")) {
                    driver.context(context);
                    break;
                }
            }
            System.out.println(driver.getContextHandles());
            // Wait for the element inside WebView
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.webkit.WebView[@resource-id='com.globalrescue.enterprise:id/reportView']")));
            
            // Get the text
            String text = element.getText().trim();

            // Switch back to Native App
            driver.context("NATIVE_APP");
            System.out.println(driver.getContextHandles());
            return text;
        } catch (Exception e) {
            driver.context("NATIVE_APP");  // Ensure we switch back even if it fails
            return "Element not found: " + e.getMessage();
        }
    }

   

    // Click on the Categories tab
    public void clickCategoriesTab() {
        WebElement categoriesTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@text='Categories']")));
        categoriesTab.click();
    }


    public boolean isCategoriesTabSelected() {
        String selectedValue = categoriesSection.getAttribute("selected");
        return selectedValue != null && selectedValue.equals("true");
    }

    // List of severity containers
    private List<WebElement> getSeverityCards() {
        return driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.globalrescue.enterprise:id/event_definition_card_container']"));
    }

    // Title of severity levels
    private List<WebElement> getSeverityTitles() {
        return driver.findElements(By.id("com.globalrescue.enterprise:id/event_definition_card_title"));
    }

    // Text descriptions of severity levels
    private List<WebElement> getSeverityDescriptions() {
        return driver.findElements(By.id("com.globalrescue.enterprise:id/event_definition_card_text"));
    }
    public String getEventDefinitionCardTitle(int index) {
        try {
            List<WebElement> titles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.id("com.globalrescue.enterprise:id/event_definition_card_title")
            ));

            if (titles.isEmpty()) {
                throw new NoSuchElementException("❌ No elements found for event definition titles.");
            }

            if (index >= titles.size()) {
                throw new NoSuchElementException("❌ Index " + index + " is out of bounds. Found only " + titles.size() + " elements.");
            }

            return titles.get(index).getText().trim();
        } catch (TimeoutException e) {
            throw new TimeoutException("❌ Timed out waiting for event definition titles to load.", e);
        } catch (Exception e) {
            throw new RuntimeException("❌ Unexpected error fetching event definition title: " + e.getMessage(), e);
        }
    }


    public String getEventDefinitionCardDescription(int index) {
        String xpath = "(//android.view.ViewGroup[@resource-id='com.globalrescue.enterprise:id/event_definition_card_container'])[" + index + "]/android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/event_definition_card_text']";
        return driver.findElement(By.xpath(xpath)).getText().trim();
    }

    // Verify the number of severity levels
    public int getSeverityCardCount() {
        return getSeverityCards().size();
    }

    // Get the text of a specific severity level
    public String getSeverityTitle(int index) {
        return getSeverityTitles().get(index).getText();
    }

    public String getSeverityDescription(int index) {
        return getSeverityDescriptions().get(index).getText();
    }

 // 📌 Scroll View Visibility
    public boolean isScrollViewDisplayed() {
        WebElement scrollView = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.globalrescue.enterprise:id/risk_rating_def_scrollview")));
        return scrollView.isDisplayed();
    }

    // 📌 Toolbar Back Button Visibility
    public boolean isToolbarBackButtonVisible() {
        WebElement backButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.globalrescue.enterprise:id/toolbar_back")));
        return backButton.isDisplayed();
    }

    // 📌 Click Toolbar Back Button
    public void clickToolbarBackButton() {
        WebElement toolbarBackButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.globalrescue.enterprise:id/toolbar_back")));
        toolbarBackButton.click();
    }

    // 📌 Page Title Visibility
    public boolean isPageTitleVisible() {
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.globalrescue.enterprise:id/title")));
        return pageTitle.isDisplayed();
    }

    // 📌 Get Page Title Text
    public String getEventDefinitionPageTitleText() {
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.globalrescue.enterprise:id/title")));
        return pageTitle.getText();
    }

    // 📌 Severities Section Visibility
    public boolean isSeveritiesSectionVisible() {
        WebElement severitiesSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.LinearLayout[@content-desc='Severities']")));
        return severitiesSection.isDisplayed();
    }

    // 📌 Get Severities Section Text
    public String getSeveritiesSectionText() {
        WebElement severitiesSection = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//android.widget.LinearLayout[@content-desc='Severities']//android.widget.TextView")
        ));

        return severitiesSection.getText().trim();
    }


    // 📌 Severities Section Clickable
    public boolean isSeveritiesSectionClickable() {
        WebElement severitiesSection = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.LinearLayout[@content-desc='Severities']")));
        return severitiesSection.isEnabled();
    }

    // 📌 Categories Section Visibility
    public boolean isCategoriesSectionVisible() {
        WebElement categoriesSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text='Categories']")));
        return categoriesSection.isDisplayed();
    }

    // 📌 Get Categories Section Text
    public String getCategoriesSectionText() {
        WebElement categoriesSection = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text='Categories']")));
        return categoriesSection.getText();
    }

    // 📌 Categories Section Clickable
    public boolean isCategoriesSectionClickable() {
        WebElement categoriesSection = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@text='Categories']")));
        return categoriesSection.isEnabled();
    }   
    public void clickInfoIcon() {
        WebElement infoIcon = driver.findElement(By.id("com.globalrescue.enterprise:id/eventAlertControllerInfoIcon"));
        infoIcon.click();
    }

    // Methods to verify elements
    public boolean isPageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }
    public String getPageTitleText() {
		// TODO Auto-generated method stub
		return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText().trim();
	}
    public boolean isInfoIconDisplayed() {
        return driver.findElement(infoIcon).isDisplayed();
    }

    public boolean isBackButtonDisplayed() {
        return driver.findElement(backButton).isDisplayed();
    }

    public boolean isEventCardContainerDisplayed() {
        return driver.findElement(eventCard).isDisplayed();
    }

    public String getEventTitle() {
        return driver.findElement(eventTitle).getText();
    }

    public String getEventSeverityText() {
        return driver.findElement(eventSeverity).getText().trim();
    }

    public boolean isEventCategoryDisplayed() {
        return driver.findElement(eventCategory).isDisplayed();
    }

    public boolean isEventCountriesDisplayed() {
        return driver.findElement(eventCountries).isDisplayed();
    }

    public String getEventDate() {
        return driver.findElement(eventDate).getText();
    }
    // Method to get expanded card title
    public String getExpandedCardTitle(int index) {
        List<WebElement> titles = driver.findElements(
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.globalrescue.enterprise:id/event_definition_card_title\")")
        );
        return (index < titles.size()) ? titles.get(index).getText() : null;
    }

    // Method to get expanded card description
    public String getExpandedCardDescription(int index) {
        List<WebElement> descriptions = driver.findElements(
            AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.globalrescue.enterprise:id/event_definition_card_text\")")
        );
        return (index < descriptions.size()) ? descriptions.get(index).getText() : null;
    }

    // Method to get expected text based on index
    public String getExpectedCardText(int index) {
        switch (index) {
            case 0: return LOW;
            case 1: return MODERATE;
            case 2: return HIGH;
            case 3: return EXTREME;
            default: return "Unknown";
        }
    }
 // Locators
    private By healthAssessmentTitle = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/title']");
    private By ratingLayout = By.xpath("//android.widget.FrameLayout[@resource-id='com.globalrescue.enterprise:id/ratingLayout']/android.view.ViewGroup");
    private By ratingText = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/ratingText']");
    private By cardLayout = By.xpath("//android.widget.LinearLayout[@resource-id='com.globalrescue.enterprise:id/cardLayout']");
    private By webViewCard = By.xpath("//android.widget.LinearLayout[@resource-id='com.globalrescue.enterprise:id/cardLayout']/android.webkit.WebView/android.webkit.WebView");
    private By RiskRatingText = By.id("com.globalrescue.enterprise:id/riskRating");
    
    
 // Locator for the country search field
 // Locators
    private By selectDestinationTitle = By.id("com.globalrescue.enterprise:id/title");
    private By regionsTab = By.xpath("//android.widget.LinearLayout[@content-desc='Regions']");
    private By countriesTab = By.xpath("//android.widget.LinearLayout[@content-desc='Countries']");
    private By countryRecyclerView = By.id("com.globalrescue.enterprise:id/rvCountries");
    private By countryViewGroup = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.globalrescue.enterprise:id/rvCountries']/android.view.ViewGroup");
    private By countryNames = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.globalrescue.enterprise:id/rvCountries']/android.view.ViewGroup/android.widget.TextView");
    private By downloadButtons = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.globalrescue.enterprise:id/rvCountries']/android.view.ViewGroup/android.widget.ImageView");

    // Methods
    public boolean isSelectDestinationTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selectDestinationTitle)).isDisplayed();
    }

    public boolean isRegionsTabDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(regionsTab)).isDisplayed();
    }

    public boolean isCountriesTabDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countriesTab)).isDisplayed();
    }

    public boolean isCountryRecyclerViewDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countryRecyclerView)).isDisplayed();
    }

    public boolean isCountryViewGroupDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countryViewGroup)).isDisplayed();
    }

 // Locator for country list in RecyclerView

    // Method to get all country names (scrolls until all elements are captured)
    public List<String> getAllCountryNames() {
        List<String> allCountries = new ArrayList<>();
        
        try {
            // Start scrolling
            boolean canScroll = true;
            while (canScroll) {
                // Get currently visible elements
                List<WebElement> countryElements = driver.findElements(countryNames);

                for (WebElement country : countryElements) {
                    String countryName = country.getText().trim();
                    
                    // Avoid duplicates
                    if (!allCountries.contains(countryName) && !countryName.isEmpty()) {
                        allCountries.add(countryName);
                    }
                }

                // Try to scroll further down
                canScroll = scrollDown();
            }
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to fetch all country names: " + e.getMessage(), e);
        }
        
        return allCountries;
    }

    // Scroll method (returns false when end is reached)
    public boolean scrollDown() {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
            ));
            return true; // Scrolled successfully
        } catch (Exception e) {
            return false; // Can't scroll further
        }
    }


    // Method to verify all countries have download buttons
    public boolean verifyDownloadButtonsForAllCountries() {
        List<WebElement> countryElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(countryViewGroup));
        List<WebElement> downloadElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(downloadButtons));

        return countryElements.size() == downloadElements.size(); // Ensures each country has a download button
    }

    // Method to clear the text from the country search field
 // Method to clear the text from the country search field and close the keyboard
    public void clearCountrySearchField() {
        try {
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearchField));
            searchField.clear(); // Clear the text
            driver.hideKeyboard(); // Close the keyboard
            System.out.println("✅ Country search field cleared and keyboard closed successfully.");
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to clear country search field and close keyboard: " + e.getMessage(), e);
        }
    
    }
// Method to verify if Health Assessment title is displayed
    public boolean isHealthAssessmentTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(healthAssessmentTitle)).isDisplayed();
    }

   

    // Method to verify if Rating Layout is displayed
    public boolean isRatingLayoutDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ratingLayout)).isDisplayed();
    }

    // Method to get Risk Rating Text
    public String getRiskRatingText1() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(RiskRatingText)).getText();
    }

    // Method to verify if Card Layout is displayed
    public boolean isCardLayoutDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardLayout)).isDisplayed();
    }

    // Method to verify if WebView Card is displayed
    public boolean isWebViewCardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(webViewCard)).isDisplayed();
    }

  

    // Methods
    public void clickDestinationReportTab1() {
        WebElement reportTab = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='com.globalrescue.enterprise:id/view_reports']/android.view.ViewGroup"));
        reportTab.click();
    }
    public boolean isDestinationReportTabDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(destinationReportTab)).isDisplayed();
    }

    public void clickDestinationReportTab() {
        wait.until(ExpectedConditions.elementToBeClickable(destinationReportTab)).click();
    }

    public boolean isCountrySearchFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearchField)).isDisplayed();
    }

    public void enterCountrySearch(String country) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(countrySearchField));
        searchField.clear();
        searchField.sendKeys(country);
    }

    public boolean isDownloadButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(downloadButton)).isDisplayed();
    }

    public void clickDownloadButton() {
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton)).click();
    }

    public boolean isCountryNameDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countryName)).isDisplayed();
    }

    public void clickCountryName() {
        wait.until(ExpectedConditions.elementToBeClickable(countryName)).click();
    }
    //
    // Methods to get text from elements
 // Methods to get text from elements with explicit wait
    public String getTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }

    public String getBackButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(backButton)).getText();
    }

    public String getCountryNameText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DRcountryName)).getText();
    }

    public String getOverallRiskLabelText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(overallRiskLabel)).getText();
    }
    public boolean isBackButtonClickable() {
        WebElement backButton1 = driver.findElement(backButton);
        return backButton1.isDisplayed() && backButton1.isEnabled();
    }

    public String getRiskLevelText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(riskLevel)).getText();
    }

    // Click methods with explicit wait
    public void clickBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }

	public void clickQuestionMarkIcon() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/containerEventFilterIcons"))).click();
		
	}

	
}

