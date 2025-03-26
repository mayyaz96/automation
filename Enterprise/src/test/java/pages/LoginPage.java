package pages;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
    
	private AndroidDriver driver;
    private WebDriverWait wait;

    public LoginPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    private static By CopyrightLabel = By.id("com.globalrescue.enterprise:id/tvCopyRight");
    public static String wrongPasswordErrorText = "You have entered an incorrect email address or password.";
    public static String EmptyPasswordErrorText= "Password is mandatory. Please enter a value.";
    public static String EmptyEmailErrorText = "Email is mandatory. Please enter a value.";
    public String InvalidEmailErrorText = "You have entered an invalid email address";
    public static String NonRegisterEmailErrorText = "We could not find the account associated with the entered email address. Consider registering with an alternative email address. If the problem persists, contact your Account POC or reach us at +1 (617) 459-4200.";
    private By termsOfServiceButton =By.id("com.globalrescue.enterprise:id/tv_login_terms_of_service");
    String globalRescueText = "Global Rescue members receive the finest medical advisory, evacuation, security extraction, and intelligence services available.";
    private static By emailField = By.id("com.globalrescue.enterprise:id/email_text");
    private By nextButton = By.id("com.globalrescue.enterprise:id/btn_next");
    private By passwordField = By.id("com.globalrescue.enterprise:id/password_text"); // Password field locator
    private By maskToggleButton = By.id("com.globalrescue.enterprise:id/text_input_end_icon"); // Mask/unmask button
    private By rescueText = By.id("com.globalrescue.enterprise:id/globalrescue_text_view");
    private By loginButton = By.id("com.globalrescue.enterprise:id/sign_in_button");
    private By errorMessage = By.id("com.globalrescue.enterprise:id/error_message");
    private By dashboardElement = By.id("com.globalrescue.enterprise:id/dashboard");
    private By errorBanner = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.globalrescue.enterprise:id/customNotificationLayout\"]/android.view.ViewGroup");
    private By closeErrorIcon = By.id("com.globalrescue.enterprise:id/errorCancelNotification"); // Adjusted locator for the close icon
    private By errorMessageText = By.id("com.globalrescue.enterprise:id/notificationText");
    public By RegisterNowButton = By.id("com.globalrescue.enterprise:id/register_now");
    
    private By GRlogo = By.id("com.globalrescue.enterprise:id/dxLogo");
    private By userImage = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.globalrescue.enterprise:id/ll_avatar_layout\"]/android.widget.ImageView");
    private By emailavatarField = By.id("com.globalrescue.enterprise:id/tv_avatar_email");
    private By passwordLabel = By.xpath("//android.widget.TextView[@text='Password']");
    private By rememberMeCheckbox = By.id("com.globalrescue.enterprise:id/rememberMe");
    
    private By backButton= By.xpath("//android.widget.TextView[@resource-id='com.globalrescue.enterprise:id/toolbar_back']");
    // Actions/Methods
    public boolean isBackButtonDisplayed() {
    	try {
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(backButton)).isDisplayed();
    	}
    	catch(Exception e) {return false;}
    }

    public boolean isUserImageDisplayed() {
        try {
     
            return wait.until(ExpectedConditions.visibilityOfElementLocated(userImage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmailAvatarFieldDisplayed() {
        try {
            WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailavatarField));
            return emailElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    

    public void clickRememberMeCheckbox() {
        try {
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
            checkbox.click();
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to click 'Remember Me' checkbox: " + e.getMessage(), e);
        }
    }

    public boolean isEmailFieldNonEditable() {
        try {
            WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailavatarField));

            boolean isClickable = emailElement.getAttribute("clickable").equals("true");
            boolean isFocusable = emailElement.getAttribute("focusable").equals("true");

            System.out.println("Clickable: " + isClickable);
            System.out.println("Focusable: " + isFocusable);

            return !isClickable && !isFocusable; // Must be all three to be editable
        } catch (Exception e) {
            System.out.println("Exception while checking email field editability: " + e.getMessage());
            return false;
        }
    }


    public boolean isPasswordLabelDisplayed() {
        try {
            WebElement passwordLabelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLabel));
            return passwordLabelElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPasswordFieldPlaceholder() {
        try {
            WebElement passwordFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
            return passwordFieldElement.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isRememberMeCheckboxDisplayed() {
        try {
            WebElement rememberMeCheckboxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(rememberMeCheckbox));
            return rememberMeCheckboxElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isRememberMeCheckboxClickable() {
        try {
            WebElement rememberMeCheckboxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(rememberMeCheckbox));
            return rememberMeCheckboxElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLoginButton() {
        try {
            WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            loginButtonElement.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public static WebElement GetEmail() {
//    	static wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
//    	return wait1.until(ExpectedConditions.visibilityOfElementLocated(emailField));
//		
//    }
    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailElement.sendKeys(email);
    }
    
    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLoginSuccessful() {
        try {
            // Wait for the home screen element (Android) to become visible
            By homeScreenElement = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout");
            return wait.until(ExpectedConditions.visibilityOfElementLocated(homeScreenElement)) != null;
        } catch (Exception e) {
            // If element is not found or not visible, login failed
            return false;
        }
    }
 // Method to simulate pressing the Back button
    public void pressBackButton() {
        WebElement backButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.globalrescue.enterprise:id/toolbar_back")));
        backButton.click();
    }

 // Method to check if the password field is visible
    public boolean isPasswordFieldVisible() {
        try {
            WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
            return passwordElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
 // Method to check if the password is masked
    public boolean isPasswordMasked() {
        try {
            // Locate the password field
            WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.EditText")));

            // Use getDomAttribute to check if the password is masked
            String passwordType = passwordElement.getDomAttribute("password"); // Modern replacement for getAttribute
            System.out.println("Password DOM attribute value: " + passwordType);

            // Return true if the password field is masked
            return passwordType != null && passwordType.equalsIgnoreCase("true");
        } catch (Exception e) {
            System.err.println("Error while checking if password is masked: " + e.getMessage());
            return false;
        }
    }





    // Method to toggle password masking (click the eye icon)
    public boolean verifyPasswordMaskToggle() {
        try {
            // Locate the password field and toggle button
            WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.EditText")));
            WebElement toggleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.ImageButton")));

            // Initially check if password is masked
            String initialMaskState = passwordElement.getDomAttribute("password");
            System.out.println("Initial mask state: " + initialMaskState);

            // Click the toggle button to unmask
            toggleButton.click();

            // Check if the password is now unmasked
            String unmaskedState = passwordElement.getDomAttribute("password");
            System.out.println("Unmasked state: " + unmaskedState);

            // Revert the toggle state
            toggleButton.click();

            // Final check if password masking is restored
            String finalMaskState = passwordElement.getDomAttribute("password");
            System.out.println("Final mask state: " + finalMaskState);

            // Verify the toggle changes the mask state
            return initialMaskState != null && initialMaskState.equalsIgnoreCase("true") &&
                   unmaskedState != null && unmaskedState.equalsIgnoreCase("false") &&
                   finalMaskState != null && finalMaskState.equalsIgnoreCase("true");
        } catch (Exception e) {
            System.err.println("Error while verifying password masking toggle: " + e.getMessage());
            return false;
        }
    }


 
    // Method to check if the error banner is displayed
    public String getErrorMessage() {
        try {
        	System.out.println(driver.findElement(errorMessageText).getText());
            return driver.findElement(errorMessageText).getText();
           // Returns the text of the banner
        } catch (NoSuchElementException e) {
            return ""; // Return an empty string if the banner is not found
        }
    }
    public boolean isErrorDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorBanner)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // Return false if the banner is not found
        }
    }

    // Method to close the error banner
    public void closeErrorBanner() throws TimeoutException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement closeIcon = wait.until(ExpectedConditions.elementToBeClickable(closeErrorIcon));
            closeIcon.click();
        } catch (NoSuchElementException e) {
            System.err.println("Error banner close icon not found: " + e.getMessage());
        }
    }
 // Method to verify if the error message is displayed
    public boolean isBackenedErrorDisplayed() {
        try {
            // Wait for the notification layout to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.LinearLayout[@resource-id='com.globalrescue.enterprise:id/customNotificationLayout']/android.view.ViewGroup"))
            );

            // Ensure that the error message layout is displayed
            return driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.globalrescue.enterprise:id/customNotificationLayout']/android.view.ViewGroup"))
                    .isDisplayed();
        } catch (Exception e) {
            System.out.println("Error locating the error message: " + e.getMessage());
            return false;
        }
    }

    // Method to close the error banner by clicking on the cross icon
    public void closeBackenedErrorBanner() {
        try {
            // Wait for the cancel button to be clickable and close the error message
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("com.globalrescue.enterprise:id/errorCancelNotification"))
            );
            driver.findElement(By.id("com.globalrescue.enterprise:id/errorCancelNotification")).click();
        } catch (Exception e) {
            System.out.println("Error cancel icon not found: " + e.getMessage());
        }
    }
 // Method to verify the presence of the "Sign in to your account" heading
    public boolean isSignInHeadingDisplayed() {
        try {
            By heading = By.id("com.globalrescue.enterprise:id/heading");
            WebElement headingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(heading));
            return headingElement.getText().equals("Sign in to your account");
        } catch (Exception e) {
            return false;
        }
    }

    // Method to verify the presence of the "Email" text
    public boolean isEmailLabelDisplayed() {
        try {
            By emailLabel = By.xpath("//android.widget.TextView[@text='Email']");
            return wait.until(ExpectedConditions.visibilityOfElementLocated(emailLabel)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to verify the presence of the "Next" button
    public boolean isNextButtonDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/btn_next"))).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to verify the presence of the "Don't have an account?" text
    public boolean isDontHaveAccountTextDisplayed() {
        try {
            By dontHaveAccount = By.id("com.globalrescue.enterprise:id/detail");
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(dontHaveAccount));
            return element.getText().equals("Don't have an account?");
        } catch (Exception e) {
            return false;
        }
    }

    // Method to verify the presence of the "Register Now" button
    public boolean isRegisterNowButtonDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterNowButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isScrollLayoutDisplayed() {
        try {
            WebElement scrollLayout = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.ScrollView/android.widget.LinearLayout")));
            return scrollLayout.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isForgotPasswordTextDisplayed() {
        try {
            WebElement forgotPasswordText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.globalrescue.enterprise:id/tv_detail")));
            return forgotPasswordText.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isResetPasswordButtonDisplayed() {
        try {
            WebElement resetPasswordButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.globalrescue.enterprise:id/forget_password")));
            return resetPasswordButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isViewGroupContainerDisplayed() {
        try {
            WebElement viewGroupContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("android.view.ViewGroup")));
            return viewGroupContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to verify the "Global Rescue members receive..." text
    public boolean isGlobalRescueTextDisplayed() {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(rescueText));
            return element.getText().equals(globalRescueText);
        } catch (Exception e) {
            return false;
        }
    }

    
    public boolean verifyEmailPlaceholder() {
    	// Locate the element
    	WebElement emailTextField = driver.findElement(emailField);

    	// Fetch the placeholder or hint text
    	@SuppressWarnings("deprecation")
		String placeholderText = emailTextField.getAttribute("hint");

    	// Verify the placeholder text
    	if (placeholderText.equals("Enter your email")) {
    	    return true;
    	} else {
    	    System.out.println("Email Text feild's Placeholder text is incorrect: " + placeholderText);
    	    return false;
    	}
		
    }


    public boolean verifyPrivacyPolicyLink() {
        try {
            // Wait for the Privacy Policy element and click it
            WebElement privacyPolicy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/tv_login_privacy_policy")));
            privacyPolicy.click();
            WebElement Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"MOBILE APPLICATIONS AND PLATFORMS\"]")));
            return Title.getText().trim().equals("MOBILE APPLICATIONS AND PLATFORMS");
             
            // Switch to WebView context
//            String webViewContext = driver.getContextHandles().stream()
//                .filter(ctx -> ctx.contains("WEBVIEW"))
//                .findFirst()
//                .orElseThrow(() -> new Exception("WebView context not found"));
//            driver.context(webViewContext);
//
//            // Switch to the latest tab if multiple are open
//            Set<String> windowHandles = driver.getWindowHandles();
//            String latestWindowHandle = windowHandles.stream()
//                .reduce((first, second) -> second)
//                .orElseThrow(() -> new Exception("No window handles found"));
//            driver.switchTo().window(latestWindowHandle);
//
//            // Verify the URL
//            String expectedUrl = "https://www.globalrescue.com/grid/mobile/privacy_policy/";
//            boolean urlMatches = wait.until(ExpectedConditions.urlToBe(expectedUrl));
//
//            System.out.println("Current URL: " + driver.getCurrentUrl());
//            return urlMatches;
        } catch (Exception e) {
            System.out.println("Error verifying 'Learn More' link: " + e.getMessage());
            return false;
        } finally {
            try {
                // Navigate back to the native app
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                driver.context("NATIVE_APP");
                System.out.println("Successfully navigated back to the app.");
            } catch (Exception e) {
                System.out.println("Warning: Failed to switch back to the native app - " + e.getMessage());
            }
        }
          
    }


    public boolean verifyPrivacyPolicyText() {
        try {
            // Wait for the Privacy Policy element and verify text
            WebElement privacyPolicy = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/tv_login_privacy_policy")));
            return privacyPolicy.getText().equals("Privacy Policy");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    public boolean verifyTermsOfServiceLink() {
        
         
            try {
                // Wait for the "Learn More" element and click it
            	WebElement termsOfService = wait.until(ExpectedConditions.visibilityOfElementLocated(termsOfServiceButton));
                termsOfService.click();
                WebElement Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Mobile Application End User License Agreement\"]")));
                return Title.getText().trim().equals("Mobile Application End User License Agreement");
                 
//                // Wait for WebView context to be available and switch to the latest WebView
//                Set<String> contexts = driver.getContextHandles();
//                Optional<String> latestWebView = contexts.stream()
//                    .filter(ctx -> ctx.contains("WEBVIEW"))
//                    .reduce((first, second) -> second); // Get the latest WebView
//
//                if (latestWebView.isPresent()) {
//                    driver.context(latestWebView.get());
//                } else {
//                    throw new Exception("WebView context not found");
//                }

                // Verify the URL
//                String expectedUrl = "https://www.globalrescue.com/grid/mobile/eula/";
//                boolean urlMatches = wait.until(ExpectedConditions.urlToBe(expectedUrl));
              
               // return urlMatches;
            } catch (Exception e) {
                System.out.println("Error verifying 'Learn More' link: " + e.getMessage());
                return false;
            } finally {
                try {
                    // Navigate back to the native app
                    driver.pressKey(new KeyEvent(AndroidKey.BACK));
                    driver.context("NATIVE_APP");
                    System.out.println("Successfully navigated back to the app.");
                } catch (Exception e) {
                    System.out.println("Warning: Failed to switch back to the native app - " + e.getMessage());
                }
            }
            
    }

    public boolean verifyTermsOfServiceText() {
    	try {
    		WebElement TermsOfService = wait.until(ExpectedConditions.visibilityOfElementLocated(termsOfServiceButton));
            return TermsOfService.getText().equals("Terms of Service");
    	
    	}catch (Exception e){
    		System.out.println("Error verifying Terms of Service text:" + e.getMessage());
    		return false;
    	}
    	  // Wait for the Privacy Policy element and verify text
        
    }
    

    public boolean isLearnMoreTextCorrect() {
        try {
            // Wait for the "Learn More" element
            WebElement learnMore = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/learn_more_text_view")));
            // Check if the text matches "Learn More"
            return learnMore.getText().equals("Learn More");
        } catch (Exception e) {
            System.out.println("Error verifying 'Learn More' text: " + e.getMessage());
            return false;
        }
    }
    public boolean isLearnMoreLinkCorrect() {
        try {
            // Wait for the "Learn More" element and click it
            WebElement learnMore = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterprise:id/learn_more_text_view")));
            learnMore.click();

            // Wait for WebView context to be available and switch to the latest WebView
            Set<String> contexts = driver.getContextHandles();
            Optional<String> latestWebView = contexts.stream()
                .filter(ctx -> ctx.contains("WEBVIEW"))
                .reduce((first, second) -> second); // Get the latest WebView

            if (latestWebView.isPresent()) {
                driver.context(latestWebView.get());
            } else {
                throw new Exception("WebView context not found");
            }

            // Verify the URL
            String expectedUrl = "https://www.globalrescue.com/?source=mobilelearnmore";
            boolean urlMatches = wait.until(ExpectedConditions.urlToBe(expectedUrl));

            return urlMatches;
        } catch (Exception e) {
            System.out.println("Error verifying 'Learn More' link: " + e.getMessage());
            return false;
        } finally {
            try {
                // Navigate back to the native app
                driver.pressKey(new KeyEvent(AndroidKey.BACK));
                driver.context("NATIVE_APP");
                System.out.println("Successfully navigated back to the app.");
            } catch (Exception e) {
                System.out.println("Warning: Failed to switch back to the native app - " + e.getMessage());
            }
        }
    }

    public boolean verifyCopyrightText() {
        String expectedText = "Copyright © 2025 Global Rescue LLC.  All Rights Reserved.";

        WebElement copyrightTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CopyrightLabel));
        String actualText = copyrightTextElement.getText().trim().replaceAll("\\r\\n|\\r|\\n", " "); // Normalize line breaks

        System.out.println("Actual Copyright Text: " + actualText); // Debugging purpose

        return actualText.contains(expectedText); // Use contains for flexible matching
    }


	public boolean ErrorText(String ErrorText) {
		try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageText)).getText().equals(ErrorText);
        } catch (Exception e) {
        	System.out.println("Displayed Error Message:" + e);
            return false; 
        }
	}


}







