package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class MassCommPage {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPage loginpage;

    // Constructor
    public MassCommPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        loginpage = new LoginPage(driver, wait);
        PageFactory.initElements(driver, this);
    }
   
    // Locators using PageFactory
    @FindBy(id = "com.globalrescue.enterprise:id/masscomm_creation_subject")
    private WebElement masscommpopuptitle;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Mass Communication\"]")
    private WebElement masscommtext;

    @FindBy(id = "com.globalrescue.enterprise:id/masscomm_positive_button")
    private WebElement viewmasscomm;

    @FindBy(id = "com.globalrescue.enterprise:id/title")
    private WebElement pagetitle;

    @FindBy(xpath = "//android.widget.TextView[@text=\"View and respond to Mass Comm\"]")
    private WebElement subtextmasscomm;

    @FindBy(id = "com.globalrescue.enterprise:id/tv_help")
    private WebElement helptexts;
    
    @FindBy(id = "com.globalrescue.enterprise:id/response_option_text")
    private WebElement answer;
    
    @FindBy(id = "com.globalrescue.enterprise:id/toolbar_back")
    private WebElement backbutton;

    @FindBy(id = "com.globalrescue.enterprise:id/b_save_change_password")
    private WebElement submitanswer;
    
    @FindBy(id = "com.globalrescue.enterprise:id/success_text")
    private WebElement answersucessmessage;

    @FindBy(id = "com.globalrescue.enterprise:id/close_success_popup")
    private WebElement answersucessok;
    

    public String getTitleText() {
        return masscommtext.getText();
    }



    public String getPagetitleText() {
        return wait.until(ExpectedConditions.visibilityOf(pagetitle)).getText();
    }

    public String getSubText() {
        return subtextmasscomm.getText();
    }


    public String gePopuptitleText() {
        return masscommpopuptitle.getText();
    }

    public String geAnswersuccessText() {
        return answersucessmessage.getText();
    }


  
    
    public void clickMassComm() {
        wait.until(ExpectedConditions.elementToBeClickable(masscommtext)).click();
    }
    
    public void clickBack() {
        wait.until(ExpectedConditions.elementToBeClickable(backbutton)).click();
    }
    
    public void clickViewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(viewmasscomm)).click();
    }
    
    
    public void clickAnswer() {
        wait.until(ExpectedConditions.elementToBeClickable(answer)).click();
    }
    
    public void clickSubmitAnswer() {
        wait.until(ExpectedConditions.elementToBeClickable(submitanswer)).click();
    }
    
    public void clickAnswerOk() {
        wait.until(ExpectedConditions.elementToBeClickable(answersucessok)).click();
    }
    
    
    

    public void Checknotificationtext() throws InterruptedException {
    	// Open notification shade
    	driver.openNotifications();
    	Thread.sleep(2000);

    	// Locate notification titles
    	List<WebElement> notificationTitles = driver.findElements(AppiumBy.id("android:id/title"));
    	List<WebElement> notificationTexts = driver.findElements(AppiumBy.id("android:id/text"));

    	// Print all notifications
    	for (int i = 0; i < notificationTitles.size(); i++) {
    	    String title = notificationTitles.get(i).getText();
    	    String text = (i < notificationTexts.size()) ? notificationTexts.get(i).getText() : "No message";

    	    System.out.println("Notification Title: " + title);
    	    System.out.println("Notification Message: " + text);

    	    // Verify if expected notification is present
    	    if (title.contains("Global Rescue") && text.contains("Hello! How are you.")) {
    	       
    	    	
    	    	System.out.println("✅ Expected notification found!");
    	    	notificationTitles.get(i).click();
    	        break; // Exit the loop after clicking
    	    	
    	    	
    	    }
    	}

    	// Assert if no notifications found
    	//Assert.assertFalse(notificationTitles.isEmpty(), "❌ No notifications found!");

    }


     

}
