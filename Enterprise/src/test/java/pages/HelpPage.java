package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class HelpPage {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPage loginpage;

    // Constructor
    public HelpPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        loginpage = new LoginPage(driver, wait);
        PageFactory.initElements(driver, this);
    }
   
    // Locators using PageFactory
    @FindBy(id = "com.globalrescue.enterprise:id/b_settings")
    private WebElement setting;

    @FindBy(id = "com.globalrescue.enterprise:id/textView")
    private WebElement helptext;

    @FindBy(id = "com.globalrescue.enterprise:id/tv_policy_agreement")
    private WebElement policies;

    @FindBy(id = "com.globalrescue.enterprise:id/tv_emergency_receivers")
    private WebElement emerrecipients;

    @FindBy(id = "com.globalrescue.enterprise:id/tv_app_feature_walkthrough")
    private WebElement walkthrough;

    @FindBy(id = "com.globalrescue.enterprise:id/tv_help")
    private WebElement helptexts;
    
    @FindBy(id = "com.globalrescue.enterprise:id/tv_version")
    private WebElement version;
    
    @FindBy(id = "com.globalrescue.enterprise:id/eulaTextView")
    private WebElement enduser;
    
    @FindBy(id = "com.globalrescue.enterprise:id/eulaTextView2nd")
    private WebElement privacy;
    
    @FindBy(xpath = "//android.widget.TextView[@text=\"Mobile Application End User License Agreement\"]")
    private WebElement enduserpage;
    
    @FindBy(xpath = "(//android.widget.TextView[@text=\"Privacy Policy\"])[2]")
    private WebElement privacypolicypage;
    
    @FindBy(id = "com.globalrescue.enterprise:id/toolbar_back")
    private WebElement backbutton;
    
    @FindBy(id = "com.globalrescue.enterprise:id/notificationText")
    private WebElement emergencynote;
    
    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.globalrescue.enterprise:id/tv_contact_name\" and @text=\"Global Rescue Operations\"]")
    private WebElement ops;
    
    @FindBy(id = "com.globalrescue.enterprise:id/upperText")
    private WebElement walktitle;
    
    @FindBy(id = "com.globalrescue.enterprise:id/lowerText")
    private WebElement walktext;
    
    @FindBy(xpath = "//android.widget.TextView[@text=\"Global Rescue GRID App Help\"]")
    private WebElement helppagetext;
    
    

    public void clickSettings() {
        wait.until(ExpectedConditions.elementToBeClickable(setting)).click();
    }


    public String getTitleText() {
        return helptext.getText();
    }



    public String getPoliciesText() {
        return wait.until(ExpectedConditions.visibilityOf(policies)).getText();
    }

    public String getEmergencyRecipientsText() {
        return emerrecipients.getText();
    }

    public String getWalkthroughText() {
        return walkthrough.getText();
    }

    public String getHelpText() {
        return helptexts.getText();
    }

    public String getVersionText() {
        return version.getText();
    }
    
    public String getEulaText() {
        return enduser.getText();
    }
    
    public String getPrivacyText() {
        return privacy.getText();
    }

    public String getEnduserpageText() {
        return wait.until(ExpectedConditions.visibilityOf(enduserpage)).getText();
    }

    public String getPrivacypolicyText() {
        return privacypolicypage.getText();
    }

    
    public String getEmergencynoteText() {
        return emergencynote.getText();
    }

    public String getopsText() {
        return ops.getText();
    }

    public String getWalktitle() {
        return walktitle.getText();
    }
    public String getWalkText() {
        return walktext.getText();
    }
    public String getHelpPagetext() {
        return wait.until(ExpectedConditions.visibilityOf(helppagetext)).getText();
    }
    
    
    public void clickPolicies() {
        wait.until(ExpectedConditions.elementToBeClickable(policies)).click();
    }
    
    public void clickBack() {
        wait.until(ExpectedConditions.elementToBeClickable(backbutton)).click();
    }
    
    public void clickEula() {
        wait.until(ExpectedConditions.elementToBeClickable(enduser)).click();
    }
    
    
    public void clickPrivacy() {
        wait.until(ExpectedConditions.elementToBeClickable(privacy)).click();
    }
    
    public void clickEmergencyRecipients() {
        wait.until(ExpectedConditions.elementToBeClickable(emerrecipients)).click();
    }
    
    public void clickWalkthrough() {
        wait.until(ExpectedConditions.elementToBeClickable(walkthrough)).click();
    }

    public void clickhelp() {
        wait.until(ExpectedConditions.elementToBeClickable(helptexts)).click();
    }


     

}
