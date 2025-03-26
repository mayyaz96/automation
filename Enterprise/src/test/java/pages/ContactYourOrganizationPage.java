package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ContactYourOrganizationPage {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPage loginpage;

    // Constructor
    public ContactYourOrganizationPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        loginpage = new LoginPage(driver, wait);
        PageFactory.initElements(driver, this);
    }
   
    // Locators using PageFactory
    @FindBy(id = "com.globalrescue.enterprise:id/tvContactorganization")
    private WebElement CYOtext;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Message with your organization's internal point of contact\"]")
    private WebElement subtext;

    @FindBy(id = "com.globalrescue.enterprise:id/text")
    private WebElement eymh;

    @FindBy(id = "com.globalrescue.enterprise:id/b_send_message")
    private WebElement sendbutton;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.globalrescue.enterprise:id/message_text\"])[6]")
    private WebElement message;

    @FindBy(id = "com.globalrescue.enterprise:id/tv_help")
    private WebElement helptexts;
    
    @FindBy(id = "com.globalrescue.enterprise:id/tv_version")
    private WebElement version;
    
    @FindBy(id = "com.globalrescue.enterprise:id/toolbar_back")
    private WebElement backbutton;

    


    public String getTitleText() {
        return CYOtext.getText();
    }



    public String getEnterMessageText() {
        return wait.until(ExpectedConditions.visibilityOf(eymh)).getText();
    }

    public String getSubText() {
        return subtext.getText();
    }

    public void SendMessage() {
         eymh.sendKeys("Hello How are you!");
    }

    public String getMessageText() {
        return message.getText();
    }
    public String getNotificationMessageText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//android.widget.TextView[contains(@text, 'Pakistan - Automation Mobile Event')]")
	        )).getText().trim();
    }
    public String getVersionText() {
        return version.getText();
    }
    
   

  
    
    public void clickContactyourorganization() {
        wait.until(ExpectedConditions.elementToBeClickable(CYOtext)).click();
    }
    
    public void clickBack() {
        wait.until(ExpectedConditions.elementToBeClickable(backbutton)).click();
    }
    
    public void clickSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sendbutton)).click();
    }
    
    


    public void Checknotificationtext() throws InterruptedException {
    	// Open notification shade
    	driver.openNotifications();
    	Thread.sleep(2000);

    	
    	
    	Thread.sleep(2000);
    	List<WebElement> notificationTitles = driver.findElements(AppiumBy.id("android:id/title"));
    	List<WebElement> notificationTexts = driver.findElements(AppiumBy.id("android:id/text"));
    	
    	// Print all notifications
    	for (int i = 0; i < notificationTitles.size(); i++) {
    	    String title = notificationTitles.get(i).getText();
    	    String text = (i < notificationTexts.size()) ? notificationTexts.get(i).getText() : "No message";

    	    System.out.println("Notification Title: " + title);
    	    System.out.println("Notification Message: " + text);
    	    if (title.contains("Global Rescue") && text.contains("Hello! How are you.")) {
    	       
    	    	
    	    	System.out.println("✅ Expected notification found!");
    	    	notificationTitles.get(i).click();
    	        break; // Exit the loop after clicking
    	    	    	    	
    	    }

   	    
    	    else if (title.contains("GRID") && text.contains("Hello! How are you.")) {
     	       
    	    	
     	    	System.out.println("✅ Expected notification found!");
     	    	notificationTitles.get(i).click();
     	        break; // Exit the loop after clicking
     	    	
     	    }
    	}

    	// Assert if no notifications found
    	//Assert.assertFalse(notificationTitles.isEmpty(), "❌ No notifications found!");

    }
    public void AlertsNotificationtext() throws InterruptedException {
    	// Open notification shade
    	driver.openNotifications();
    	Thread.sleep(2000);

    	
    	WebDriverWait waitTillEventDisplayed = new WebDriverWait(driver, Duration.ofSeconds(300));
    	// Locate notification titles
    	
    	WebElement EventnotificationText = waitTillEventDisplayed.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//android.widget.TextView[contains(@text, 'Pakistan - Automation Mobile Event')]")
	        ));
    	
    	Thread.sleep(2000);
    	List<WebElement> notificationTitles = driver.findElements(AppiumBy.id("android:id/title"));
    	List<WebElement> notificationTexts = driver.findElements(AppiumBy.id("android:id/text"));
    	
    	 System.out.println("Notification message: " + EventnotificationText.getText());
    	// Print all notifications
    	for (int i = 0; i < notificationTitles.size(); i++) {
    	    String title = notificationTitles.get(i).getText();
    	    String text = (i < notificationTexts.size()) ? notificationTexts.get(i).getText() : "No message";

    	    System.out.println("Notification Title: " + title);
    	    System.out.println("Notification Message: " + text);
    	 

   	    // Verify if published event is present on screen
    	    if (title.contains("GRID") && EventnotificationText.getText().contains("Pakistan - Automation Mobile Event - Beyond Limits: A Journey to Success")) {
   	    	

    	        // Expected text from the notification
    	        String expectedText = "Pakistan - Automation Mobile Event - Beyond Limits: A Journey to Success";
    	        String actualText = EventnotificationText.getText();
    	    	
    	    	System.out.println("✅ Expected notification found!");
    	    	notificationTitles.get(i).click();
    	        break; // Exit the loop after clicking
    	    	
    	    	
    	    }
    	   
    	}

    	// Assert if no notifications found
    	//Assert.assertFalse(notificationTitles.isEmpty(), "❌ No notifications found!");

    }

     

}
