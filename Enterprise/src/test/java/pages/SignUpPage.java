package pages;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.interactions.PointerInput.Origin;

import java.awt.Point;
import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.bytebuddy.description.modifier.Visibility;
public class SignUpPage {

    // Locators
    private By emailTextField = By.id("com.globalrescue.enterprise:id/email_text");
    private By firstNameTextField = By.id("com.globalrescue.enterprise:id/first_name");
    private By lastNameTextField = By.id("com.globalrescue.enterprise:id/last_name");
    private By genderMaleRadioButton = By.id("com.globalrescue.enterprise:id/radio_gender_male");
    private By genderFemaleRadioButton = By.id("com.globalrescue.enterprise:id/radio_gender_female");
    private By dobTextField = By.id("com.globalrescue.enterprise:id/dob_text");
    private By homeCityTextField = By.id("com.globalrescue.enterprise:id/homeCity");
    private By homeCitySearchField = By.id("com.globalrescue.enterprise:id/tvAutoComplete");
    private By phoneNumberTextField = By.id("com.globalrescue.enterprise:id/phone_number");
    private By RegisterButton = By.id("com.globalrescue.enterprise:id/signup_continue");
    private By nextButton = By.id("com.globalrescue.enterprise:id/btn_next");
    private By companyCodeTextField = By.id("com.globalrescue.enterprise:id/et_company_code");
    private By companyCodeContinueButton = By.id("com.globalrescue.enterprise:id/btn_country_code_continue");
    private By backButton = By.id("com.globalrescue.enterprise:id/toolbar_back");
    private By heading = By.id("com.globalrescue.enterprise:id/heading");
    private By emailLabel = By.xpath("//android.widget.TextView[@text='Email']");
    private By emailPlaceholder = By.id("com.globalrescue.enterprise:id/email_text");
    private By companyCodeLabel = By.xpath("//android.widget.TextView[@text='Company Code']");
    private By companyCodePlaceholder = By.id("com.globalrescue.enterprise:id/et_company_code");
    private By continueButton = By.id("com.globalrescue.enterprise:id/btn_country_code_continue");
    private By alreadyHaveAccountText = By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/detail']");
    static private By loginHereText = By.id("com.globalrescue.enterprise:id/register_now");
    private AndroidDriver driver;
    private WebDriverWait wait;
 // Element locators
    private By SelfRegistrationTitle = By.id("com.globalrescue.enterprise:id/title");
   
    private By firstNameLabel = By.xpath("//android.widget.TextView[@text='First Name']");
    private By lastNameLabel = By.xpath("//android.widget.TextView[@text='Last Name']");
    private By genderLabel = By.xpath("//android.widget.TextView[@text='Gender']");
    private By maleRadioButton = By.id("com.globalrescue.enterprise:id/radio_gender_male");
    private By femaleRadioButton = By.id("com.globalrescue.enterprise:id/radio_gender_female");
    private By dobLabel = By.xpath("//android.widget.TextView[@text='Date of Birth']");
    private By addressLabel = By.xpath("//android.widget.TextView[@text=\"Address\"]");
    private By addressTextField = By.id("com.globalrescue.enterprise:id/sign_address");
    private By homeCityLabel = By.xpath("//android.widget.TextView[@text='Home City']");
    private By phoneNumberLabel = By.xpath("//android.widget.TextView[@text='Phone Number']");
    private By countryCodeTextField = By.id("com.globalrescue.enterprise:id/countryCode");
    private By registerButton = By.id("com.globalrescue.enterprise:id/signup_continue");
    private By setttingsicon = By.id("com.globalrescue.enterprise:id/b_settings");
    private By logout = By.id("com.globalrescue.enterprise:id/tv_logout");
    private By logoutpopup = By.id("com.globalrescue.enterprise:id/logout_btn");
    
    public SignUpPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public boolean isKeyboardOpen(AppiumDriver driver) {
        String output = driver.executeScript("mobile: shell", ImmutableMap.of("command", "dumpsys input_method | grep mInputShown")).toString();
        return output.contains("mInputShown=true");
    }
    
    public boolean isHeadingVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(heading)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    public boolean isEmailLabelVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(emailLabel)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isEmailPlaceholderVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(emailPlaceholder)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isAlreadyHaveAccountTextVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(alreadyHaveAccountText)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isLoginHereTextVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(loginHereText)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isCompanyCodeLabelVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(companyCodeLabel)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isRegisterHeadingVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(heading)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isCompanyCodePlaceholderVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(companyCodePlaceholder)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isContinueButtonVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isSelfRegisterTitleVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(SelfRegistrationTitle)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    
    
    public boolean isEmailTextFieldVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextField)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isFirstNameLabelVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameLabel)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isFirstNameFieldVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameTextField)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isLastNameLabelVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameLabel)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    public boolean isLastNameFieldVisible() {
    	try {
       	 return wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameTextField)).isDisplayed();
       	}
       	catch(Exception e) {
       		return false;
       	}
	}
    
    public boolean isGenderLabelVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(genderLabel)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isMaleRadioButtonVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(maleRadioButton)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public boolean isFemaleRadioButtonVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(femaleRadioButton)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    public boolean isDateOfBirthLabelVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(dobLabel)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    public boolean isDateOfBirthFieldVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(dobTextField)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    public boolean isAddressLabelVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(addressLabel)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    public boolean isAddressFieldVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(addressTextField)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    public boolean isHomeCityLabelVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(homeCityLabel)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    public boolean isHomeCityFieldVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(homeCityTextField)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    public boolean isPhoneNumberLabelVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberLabel)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    public boolean isPhoneNumberFieldVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberTextField)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    public boolean isRegisterButtonVisible() {
    	try {
    	 return wait.until(ExpectedConditions.visibilityOfElementLocated(registerButton)).isDisplayed();
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
   
    
    public static void closeKeyboardIfOpen(AppiumDriver driver) {
        try {
            if (driver instanceof AndroidDriver) {
                AndroidDriver androidDriver = (AndroidDriver) driver;

                // Check if the keyboard is open before attempting to close it
                if (isKeyboardOpen(androidDriver)) {
                    androidDriver.hideKeyboard();
                    System.out.println("Keyboard was open and has been closed (Android).");
                } else {
                    System.out.println("Keyboard is not open. No action needed.");
                }
            } else {
                System.out.println("Unsupported driver type. Cannot close keyboard.");
            }
        } catch (Exception e) {
            System.err.println("Error while closing keyboard: " + e.getMessage());
        }
    }

    /**
     * Checks if the keyboard is open on an Android device.
     */
    private static boolean isKeyboardOpen(AndroidDriver driver) {
        try {
            return driver.isKeyboardShown(); // Returns true if the keyboard is open
        } catch (Exception e) {
            return false; // If an exception occurs, assume the keyboard is not open
        }
    }


    // Method to check if text fields are clickable
    public boolean isTextFieldClickable() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextField));
            
            // Check if the field is disabled
            if (!element.isEnabled()) {
                return false; // Field is disabled
            }
            
            // Check if the field is read-only
            String readOnlyAttribute = element.getAttribute("readonly");
            return readOnlyAttribute == null || !readOnlyAttribute.equals("true");
            
        } catch (NoSuchElementException e) {
            return false; // If the element is not found, return false
        }
    }

    
    public boolean isFirstNameFieldClickable() {
        try {
            WebElement element = driver.findElement(firstNameTextField);
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isLastNameFieldClickable() {
        try {
            WebElement element = driver.findElement(lastNameTextField);
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isAddressFieldClickable() {
        try {
            WebElement element = driver.findElement(addressTextField);
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isDOBFieldClickable() {
        try {
            WebElement element = driver.findElement(dobTextField);
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isHomeCityFieldClickable() {
        try {
            WebElement element = driver.findElement(homeCityTextField);
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isPhoneNumberFieldClickable() {
        try {
            WebElement element = driver.findElement(phoneNumberTextField);
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Method to get text of elements
    public String getAlreadyHaveAccountText() {
        return driver.findElement(alreadyHaveAccountText).getText();
    }
    public String getLoginHereText() {
        return driver.findElement(loginHereText).getText();
    }
    public String getRegisterHeadingText() {
        return driver.findElement(heading).getText();
    }
    public String getEmailLabelText() {
        return driver.findElement(emailLabel).getText();
    }
    public String getBackButtonText() {
        return driver.findElement(backButton).getText();
    }
    public String getCompanyCodeLabelText() {
        return driver.findElement(companyCodeLabel).getText();
    }
    public String getContinueButtonText() {
        return driver.findElement(continueButton).getText();
    }
    public String getSelfRegistrationTitleText() {
        return driver.findElement(SelfRegistrationTitle).getText();
    }
   
    public String getFirstNameLabelText() {
        return driver.findElement(firstNameLabel).getText();
    }
    public String getLastNameLabelText() {
        return driver.findElement(lastNameLabel).getText();
    }
    public String getGenderLabelText() {
        return driver.findElement(genderLabel).getText();
    }
    public String getDateOfBirthLabelText() {
        return driver.findElement(dobLabel).getText();
    }
    public String getAddressLabelText() {
        return driver.findElement(addressLabel).getText();
    }
    public String getHomeCityLabelText() {
        return driver.findElement(homeCityLabel).getText();
    }
    public String getPhoneNumberLabelText() {
        return driver.findElement(phoneNumberLabel).getText();
    }
    // Method to click on an element
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }
    
    


    

    public String getcompanyCodePlaceholderAttribute() {
        return driver.findElement(companyCodePlaceholder).getAttribute("hint");
    }
    public String getEmailPlaceholderAttribute() {
        return driver.findElement(emailPlaceholder).getAttribute("hint");
    }
    
    
    public void enterEmail(String email) {
        WebElement emailElement;
		emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextField));
        emailElement.sendKeys(email);
    }
 // Method to handle Next Button click and conditional behavior
   
    
    public void enterFirstName(String firstName) {
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameTextField));
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameTextField));
        lastNameElement.sendKeys(lastName);
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            WebElement maleRadioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(genderMaleRadioButton));
            maleRadioButton.click();
        } else if (gender.equalsIgnoreCase("female")) {
            WebElement femaleRadioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(genderFemaleRadioButton));
            femaleRadioButton.click();
        } else {
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }

    public void enterDob(String dob) {
        WebElement dobElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dobTextField));
        dobElement.click();
        dobElement.sendKeys(dob);
    }

    public void enterHomeCity(String city) {
        WebElement homeCityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(homeCityTextField));
        homeCityElement.sendKeys(city);
    }

    public void selectCityFromSearchResults(String city) {
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(homeCitySearchField));
        searchField.sendKeys(city);
    }

    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberTextField));
        phoneElement.sendKeys(phoneNumber);
    }

    public void clickRegisterButton() {
        WebElement continueElement = wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterButton));
        continueElement.click();
    }
    public void clickNextButton() {
        WebElement NextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
        NextElement.click();
    }
    
    public void clickSetttings() {
        WebElement settingsclick = wait.until(ExpectedConditions.visibilityOfElementLocated(setttingsicon));
        settingsclick.click();
    }
    
    public void clicklogout() {
        WebElement logoutclick = wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
        logoutclick.click();
    }
    
    public void clicklogoutpopup() {
        WebElement logoutpopclick = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutpopup));
        logoutpopclick.click();
    }
    
    
    public void clickNextAndHandleCompanyCode() throws TimeoutException {
        try {
            // Wait for the company code text field and continue button to appear
            WebElement companyCodeTextFieldElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(companyCodeTextField)
            );
            WebElement companyCodeContinueButtonElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(companyCodeContinueButton)
            );

            // If both elements are visible, enter the company code and proceed
            if (companyCodeTextFieldElement.isDisplayed() && companyCodeContinueButtonElement.isDisplayed()) {
                companyCodeTextFieldElement.sendKeys("gr2012");
                companyCodeContinueButtonElement.click();
            }
        } catch (Exception e) {
            System.err.println("An unexpected error occurred while handling the company code: " + e.getMessage());
            throw e; // Rethrow exception for proper logging and debugging
        }
    }

	public void clickNext() {
		WebElement nextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
        nextElement.click();
        System.out.println("Next button clicked.");
		
	}
	//@SuppressWarnings("deprecation")
		public void swipeUp() {
			Dimension screenSize = driver.manage().window().getSize();
		    int screenWidth = screenSize.getWidth();
		    int screenHeight = screenSize.getHeight();

		    // Starting point (near the bottom center of the screen)
		    int startX = screenWidth / 2;
		    int startY = (int) (screenHeight * 0.8); // 80% of screen height

		    // Ending point (near the top center of the screen)
		    int endX = startX;
		    int endY = (int) (screenHeight * 0.2); // 20% of screen height

		    // Create a swipe action using the correct origin type
		    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		    Sequence swipe = new Sequence(finger, 0);

		    // Use Origin.device() instead of viewport()
		    swipe.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), startX, startY));
		    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		    swipe.addAction(finger.createPointerMove(Duration.ofMillis(800), Origin.viewport(), endX, endY));
		    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    // Perform the swipe action
		    driver.perform(Collections.singletonList(swipe));
		}
		public By getCountryCodeTextField() {
			return countryCodeTextField;
		}
		public void setCountryCodeTextField(By countryCodeTextField) {
			this.countryCodeTextField = countryCodeTextField;
		}
		
}

