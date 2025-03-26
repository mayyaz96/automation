package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class CheckInPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    // Constructor
    public CheckInPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Locators
    private By checkInHomeScreenButton = By.id("com.globalrescue.enterprise:id/b_checkin");
    private By toolbarBack = By.id("com.globalrescue.enterprise:id/toolbar_back");
    private By pageTitle = By.id("com.globalrescue.enterprise:id/title");
    private By latitudeView = By.id("com.globalrescue.enterprise:id/latitudemapCoordinates");
    private By longitudeView = By.id("com.globalrescue.enterprise:id/longitudemapCoordinates");
    private By accuracyImage = By.id("com.globalrescue.enterprise:id/accuracyImageView");
    private By accuracyText = By.id("com.globalrescue.enterprise:id/accuracyView");
    private By nearbyPlacesText = By.id("com.globalrescue.enterprise:id/textView2");
    private By mapAddress = By.id("com.globalrescue.enterprise:id/mapAddress");
    private By optionalMessage = By.id("com.globalrescue.enterprise:id/optional_message_view");
    private By finalCheckInButton = By.id("com.globalrescue.enterprise:id/checkInNew");
    private By messageComments = By.id("com.globalrescue.enterprise:id/gridComments");
    private By checkinComments = By.id("com.globalrescue.enterprise:id/checkinComments");
    
    // ✅ Elements Declaration
    private By checkInSuccessHeader = By.id("com.globalrescue.enterprise:id/tvHeader");
    private By checkInMessage = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/tvMessage']");
    private By continueButton = By.id("com.globalrescue.enterprise:id/btnConfirm");

    // ✅ Constructor
    public CheckInPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // ✅ Methods to verify elements visibility
    public boolean isCheckInSuccessHeaderDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkInSuccessHeader)).isDisplayed();
    }

    public boolean isCheckInMessageDisplayedOnPopUp() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkInMessage)).isDisplayed();
    }

    public boolean isContinueButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).isDisplayed();
    }

    // ✅ Methods to get text
    public String getCheckInSuccessHeaderText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkInSuccessHeader)).getText().trim();
    }

    public String getCheckInMessageTextOnPopUp() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkInMessage)).getText().trim();
    }

    public String getContinueButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).getText().trim();
    }

    // ✅ Click on Continue Button
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
    
    public boolean isCheckInMessageTitleDisplayed() { return isElementDisplayed(By.id("com.globalrescue.enterprise:id/title")); }
    public String getCheckInMessageTitleText() { return getElementText(By.id("com.globalrescue.enterprise:id/title")); }

    public boolean isBackButtonDisplayed() { return isElementDisplayed(By.id("com.globalrescue.enterprise:id/toolbar_back")); }

    public boolean isMessageLabelDisplayed() { return isElementDisplayed(By.id("com.globalrescue.enterprise:id/textView6")); }
    public String getMessageLabelText() { return getElementText(By.id("com.globalrescue.enterprise:id/textView6")); }

    public boolean isOptionalLabelDisplayed() { return isElementDisplayed(By.id("com.globalrescue.enterprise:id/textView7")); }
    public String getOptionalLabelText() { return getElementText(By.id("com.globalrescue.enterprise:id/textView7")); }
    public boolean isElementDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            return false; // If element is not found, return false instead of throwing an error
        }
    }
    public boolean isImageView7Displayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.globalrescue.enterprise:id/imageView7"))).isDisplayed();
    }

    public boolean isCheckInCommentsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkinComments)).isDisplayed();
    }

    public boolean isCheckInMessageDisplayed() {
        WebElement commentSection = wait.until(ExpectedConditions.visibilityOfElementLocated(checkinComments));
        return !commentSection.getText().isEmpty();
    }

    public boolean isCheckInCommentsClickable() {
        WebElement commentsSection = wait.until(ExpectedConditions.elementToBeClickable(checkinComments));
        return commentsSection.isEnabled();
    }

    public boolean isMessageInputFieldDisplayed() {
        return isElementDisplayed(messageComments);
    }
    public String getMessageInputPlaceholder() {
        return getElementText(messageComments);
    }
    public void enterMessageText(String message) {
        WebElement messageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(messageComments));
        messageInput.clear();
        messageInput.sendKeys(message);
    }
    public void clickArrivedSafelySuggestion() {
        WebElement arrivedSafelyOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/checkInMessageText' and @text='Arrived safely at this location']")));
        arrivedSafelyOption.click();
    }
    public String getCheckInMessageText() {
        try {
            WebElement checkInMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/checkinComments")));
            return checkInMessageElement.getText().trim();
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to retrieve Check-In message text: " + e.getMessage());
        }
    }
    public void clickCheckInComments() {
        try {
            WebElement checkInComments = wait.until(ExpectedConditions.elementToBeClickable(checkinComments));
            checkInComments.click();
            System.out.println("✅ Successfully clicked on Check-In Comments.");
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to click on Check-In Comments: " + e.getMessage());
        }
    }
    public void scrollToEndUsingUiScrollable() {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)"
            ));
            System.out.println("✅ Successfully scrolled to the end.");
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to scroll to the end: " + e.getMessage());
        }
    }

    public void selectRandomLocation() {
        try {
            List<WebElement> locations = driver.findElements(By.id("com.globalrescue.enterprise:id/addressView"));

            if (locations.isEmpty()) {
                throw new NoSuchElementException("❌ No locations found!");
            }

            // Select a random location
            Random rand = new Random();
            int randomIndex = rand.nextInt(locations.size());

            WebElement randomLocation = locations.get(randomIndex);
            String selectedLocation = randomLocation.getText();

            randomLocation.click();
            System.out.println("✅ Random location selected: " + selectedLocation);

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to select a random location: " + e.getMessage());
        }
    }
    public String getMessageFieldText() {
        WebElement messageField = wait.until(ExpectedConditions.visibilityOfElementLocated(messageComments));
        
        return messageField.getText().trim();
    }


    public void clickCheckedInAtHotelSuggestion() {
        WebElement checkedInHotelOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/checkInMessageText' and @text='Checked-in at hotel']")));
        checkedInHotelOption.click();
    }
    public void clickDoneButton() {
        WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.globalrescue.enterprise:id/checkInnew")));
        doneButton.click();
    }


    public boolean isCheckedInAtHotelSuggestionDisplayed() {
        return isElementDisplayed(By.xpath("//android.widget.TextView[@text='Checked-in at hotel']"));
    }
    public boolean isSuggestionsLabelDisplayed() {
        return isElementDisplayed(By.id("com.globalrescue.enterprise:id/textView11"));
    }
    public String getSuggestionsLabelText() {
        return getElementText(By.id("com.globalrescue.enterprise:id/textView11"));
    }
    public boolean isArrivedSafelySuggestionDisplayed() {
        return isElementDisplayed(By.xpath("//android.widget.TextView[@text='Arrived safely at this location']"));
    }
    public String getArrivedSafelySuggestionText() {
        return getElementText(By.xpath("//android.widget.TextView[@text='Arrived safely at this location']"));
    }

    public String getCheckedInAtHotelSuggestionText() {
        return getElementText(By.xpath("//android.widget.TextView[@text='Checked-in at hotel']"));
    }

    public boolean isDoneButtonDisplayed() {
        return isElementDisplayed(By.id("com.globalrescue.enterprise:id/checkInnew"));
    }
    public String getDoneButtonText() {
        return getElementText(By.id("com.globalrescue.enterprise:id/checkInnew"));
    }


    public String getElementText(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText().trim();
        } catch (Exception e) {
            return ""; // If element is not found, return empty string
        }
    }

    // Actions
    public void clickCheckIn() {
        wait.until(ExpectedConditions.elementToBeClickable(checkInHomeScreenButton)).click();
    }

    public boolean isPageTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).isDisplayed();
    }

    public String getPageTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText().trim();
    }

    public boolean isLatitudeDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(latitudeView)).isDisplayed();
    }

    public boolean isLongitudeDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(longitudeView)).isDisplayed();
    }

    public boolean isAccuracyImageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accuracyImage)).isDisplayed();
    }

    public boolean isAccuracyTextDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accuracyText)).isDisplayed();
    }

    public boolean isNearbyPlacesDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(nearbyPlacesText)).isDisplayed();
    }

    public boolean isMapAddressDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mapAddress)).isDisplayed();
    }

    public boolean isOptionalMessageButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(optionalMessage)).isDisplayed();
    }
    public String getNearbyPlacesText() {
        WebElement nearbyPlacesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/textView2")));
        return nearbyPlacesElement.getText().trim();
    }

    public boolean isFinalCheckInButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(finalCheckInButton)).isDisplayed();
    }
    public void clickNearbyPlaces() {
        try {
            WebElement nearbyPlaces = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.globalrescue.enterprise:id/textView2")));
            nearbyPlaces.click();
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to click on Nearby Places: " + e.getMessage());
        }
    }

    public boolean isBackButtonClickable() {
        try {
            WebElement backButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.globalrescue.enterprise:id/toolbar_back")));
            return backButton.isDisplayed() && backButton.isEnabled(); // Ensures it is visible and clickable
        } catch (Exception e) {
            return false;
        }
    }

    public void clickBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(toolbarBack)).click();
    }

	public void clickCheckInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(finalCheckInButton)).click();
		
	}
	public boolean isNearbyPlacesModalDisplayed() {
	    try {
	        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.LinearLayout")));
	        return modal.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	public boolean isNearbyPlacesHeaderDisplayed() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/textView10"))).isDisplayed();
	}

	public boolean isPlacesRecyclerViewDisplayed() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/places_detection_recycler_view"))).isDisplayed();
	}

	public boolean isAddressViewDisplayed() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/addressView"))).isDisplayed();
	}

	public boolean isAddressTextViewDisplayed() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/address_text_view"))).isDisplayed();
	}

	public boolean isMileViewDisplayed() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/mileView"))).isDisplayed();
	}

	public boolean isCloseButtonDisplayed() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/close_image_view"))).isDisplayed();
	}
	public void clickCloseButton() {
	    try {
	        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.globalrescue.enterprise:id/close_image_view")));
	        closeButton.click();
	    } catch (Exception e) {
	        throw new RuntimeException("❌ Failed to click on Close button: " + e.getMessage());
	    }
	}
	public boolean isAddMessageButtonDisplayed() {
	    try {
	        WebElement addMessageButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//android.widget.Button[@resource-id='com.globalrescue.enterprise:id/optional_message_view']")));
	        return addMessageButton.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public void clickAddMessageButton() {
	    try {
	        WebElement addMessageButton = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//android.widget.Button[@resource-id='com.globalrescue.enterprise:id/optional_message_view']")));
	        addMessageButton.click();
	    } catch (Exception e) {
	        throw new RuntimeException("❌ Failed to click on 'Add Message' button: " + e.getMessage());
	    }
	}
	public void closeKeyboardIfOpen() {
	    try {
	        driver.hideKeyboard();
	        System.out.println("✅ Keyboard was open and is now closed.");
	    } catch (Exception e) {
	        System.out.println("ℹ️ Keyboard was not open, no action taken.");
	    }
	}


}
