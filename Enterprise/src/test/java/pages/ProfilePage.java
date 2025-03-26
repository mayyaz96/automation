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

public class ProfilePage {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPage loginpage;

    // Constructor
    public ProfilePage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        loginpage = new LoginPage(driver, wait);
        PageFactory.initElements(driver, this);
    }
   
    // Locators using PageFactory
    @FindBy(id = "com.globalrescue.enterprise:id/b_settings")
    private WebElement settings;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Message with your organization's internal point of contact\"]")
    private WebElement subtext;

    @FindBy(id = "com.globalrescue.enterprise:id/ll_intro")
    private WebElement introname;

    @FindBy(id = "com.globalrescue.enterprise:id/b_send_message")
    private WebElement sendbutton;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id=\"com.globalrescue.enterprise:id/message_text\"])[6]")
    private WebElement message;

    @FindBy(id = "com.globalrescue.enterprise:id/tv_username")
    private WebElement username;
    
    @FindBy(id = "com.globalrescue.enterprise:id/email_id")
    private WebElement emailid;
    
    @FindBy(id = "com.globalrescue.enterprise:id/phone_id")
    private WebElement phoneid;
    
    @FindBy(id = "com.globalrescue.enterprise:id/gender_id")
    private WebElement gender;
    
    @FindBy(id = "com.globalrescue.enterprise:id/dob_id")
    private WebElement dob;
    
    @FindBy(id = "com.globalrescue.enterprise:id/city_id")
    private WebElement home;
    
    @FindBy(id = "com.globalrescue.enterprise:id/toolbar_back")
    private WebElement backbutton;
    
    @FindBy(id = "com.globalrescue.enterprise:id/ic_edit")
    private WebElement editprofile;
    
    @FindBy(id = "com.globalrescue.enterprise:id/save")
    private WebElement saveprofile;
    
    @FindBy(id = "com.globalrescue.enterprise:id/notificationText")
    private WebElement notificationtext;
    
    @FindBy(id = "com.globalrescue.enterprise:id/radio_gender_female")
    private WebElement femalegender;
    
    @FindBy(id = "com.globalrescue.enterprise:id/homeCity")
    private WebElement homecityfield;
    
    @FindBy(id = "com.globalrescue.enterprise:id/tvAutoComplete")
    private WebElement searchcity;
    
    @FindBy(id = "com.globalrescue.enterprise:id/errorCancelNotification")
    private WebElement closenoti;
    
    @FindBy(id = "com.globalrescue.enterprise:id/radio_gender_male")
    private WebElement malegender;


    public String getSubText() {
        return subtext.getText();
    }



    public String getMessageText() {
        return message.getText();
    }

    public String getUsernameText() {
        return username.getText();
    }
    
    public String getEmailText() {
        return emailid.getText();
    }
    
    public String getPhoneText() {
        return phoneid.getText();
    }
    
    public String getGenderText() {
        return gender.getText();
    }
    
    public String getDOBText() {
        return dob.getText();
    }
    
    public String getHomeText() {
        return home.getText();
    }
   
    public String getNotificationtext() {
        return notificationtext.getText();
    }

  
    
    public void clickSetings() {
        wait.until(ExpectedConditions.elementToBeClickable(settings)).click();
    }
    
    public void clickBack() {
        wait.until(ExpectedConditions.elementToBeClickable(backbutton)).click();
    }
    
    public void clickSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sendbutton)).click();
    }
    
    
    public void clickIntroname() {
        wait.until(ExpectedConditions.elementToBeClickable(introname)).click();
    }
    
    public void clickEditprofile() {
        wait.until(ExpectedConditions.elementToBeClickable(editprofile)).click();
    }
    
    public void clickSaveprofile() {
        wait.until(ExpectedConditions.elementToBeClickable(saveprofile)).click();
    }

    public void clickFemale() {
        wait.until(ExpectedConditions.elementToBeClickable(femalegender)).click();
    }
    
    public void clickMale() {
        wait.until(ExpectedConditions.elementToBeClickable(malegender)).click();
    }
    
    
    public void clickHomecity() {
        wait.until(ExpectedConditions.elementToBeClickable(homecityfield)).click();
    }

    public void enterHomeCity(String city) {
        searchcity.sendKeys(city);
    }

    public void clickClosenotification() {
        wait.until(ExpectedConditions.elementToBeClickable(closenoti)).click();
    }
     

}
