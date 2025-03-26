package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class ConfigurationPage {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPage loginpage;

    // Constructor
    public ConfigurationPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        loginpage = new LoginPage(driver, wait);
        PageFactory.initElements(driver, this);
    }
   
    // Locators using PageFactory
    @FindBy(id = "com.globalrescue.enterprise:id/b_settings")
    private WebElement setting;

    @FindBy(id = "com.globalrescue.enterprise:id/cl_text_configuration")
    private WebElement conftext;

    @FindBy(id = "com.globalrescue.enterprise:id/tv_gps_fetch_timeout")
    private WebElement gpsfetch;

    @FindBy(id = "com.globalrescue.enterprise:id/tv_mute_travel_city")
    private WebElement mutetravel;

    @FindBy(id = "com.globalrescue.enterprise:id/tv_change_password")
    private WebElement changepass;

    @FindBy(id = "com.globalrescue.enterprise:id/mute_travel_city_stay_switch")
    private WebElement muteswitch;
    
    @FindBy(id = "android:id/numberpicker_input")
    private WebElement numpicker;
    
    @FindBy(id = "com.globalrescue.enterprise:id/muteTravelCityStaySave")
    private WebElement mutesave;
    
    @FindBy(id = "com.globalrescue.enterprise:id/tv_change_password")
    private WebElement cpass;
    
    @FindBy(id = "com.globalrescue.enterprise:id/textView15")
    private WebElement cpasspoptext;
    
    @FindBy(id = "com.globalrescue.enterprise:id/toolbar_back")
    private WebElement backbutton;
    
    @FindBy(id = "com.globalrescue.enterprise:id/te")
    private WebElement oldpasstext;
    
    @FindBy(id = "com.globalrescue.enterprise:id/textView16")
    private WebElement newpasstext;
    
    @FindBy(xpath = "//android.widget.TextView[@text=\"Confirm Password\"]")
    private WebElement confirmpasstext;
    
    @FindBy(id = "com.globalrescue.enterprise:id/et_old_password")
    private WebElement oldpassfield;
    
    @FindBy(id = "com.globalrescue.enterprise:id/et_new_password")
    private WebElement newpassfield;
    
    @FindBy(id = "com.globalrescue.enterprise:id/et_confirm_password")
    private WebElement confirmpassfield;
    
    @FindBy(id = "com.globalrescue.enterprise:id/b_save_change_password")
    private WebElement updatebutton;
    
    @FindBy(id = "com.globalrescue.enterprise:id/textView17")
    private WebElement compleformval;
    
    @FindBy(id = "com.globalrescue.enterprise:id/notificationText")
    private WebElement successtop;
    
    @FindBy(xpath = "//android.widget.Button[@text=\"2\"]")
    private WebElement clicktwo;

    public void clickSettings() {
        wait.until(ExpectedConditions.elementToBeClickable(setting)).click();
    }


    public String getTitleText() {
        return conftext.getText();
    }


    public String getGpsFetchText() {
        return gpsfetch.getText();
    }

    public String getMutetravelText() {
        return mutetravel.getText();
    }

    public String getChangepassText() {
        return changepass.getText();
    }

    public String getCheckedStatus() {
    	 
        return muteswitch.getAttribute("checked");
    }
    
   
    
    public String getSuccesstopText() {
        return successtop.getText();
    }


    public String getChangePasspopText() {
        return cpasspoptext.getText();
    }
 
    public String getoldpassText() {
        return oldpasstext.getText();
    }

    public String getNewPassText() {
        return newpasstext.getText();
    }

    public String getConfirmpasstext() {
        return confirmpasstext.getText();
    }
    public String getCompleteformText() {
        return compleformval.getText();
    }
    
    
    public void clickMuteTravel() {
        wait.until(ExpectedConditions.elementToBeClickable(mutetravel)).click();
    }
    
    public void clickBack() {
        wait.until(ExpectedConditions.elementToBeClickable(backbutton)).click();
    }
    
    public void clickmutetoggle() {
        wait.until(ExpectedConditions.elementToBeClickable(muteswitch)).click();
    }
    
    
    public void selectnumber() {
    	
    	
    	String numtex = numpicker.getText();
    	
    	if(numtex == "1") {
    	
    	wait.until(ExpectedConditions.elementToBeClickable(clicktwo)).click();
    	
    	}else {
    		
    		wait.until(ExpectedConditions.elementToBeClickable(mutesave)).click();
    		}
    

    	//numpicker.setValue("3");

    }
    
    public void clickCpass() {
        wait.until(ExpectedConditions.elementToBeClickable(cpass)).click();
    }
    
    public void clickUpdate() {
        wait.until(ExpectedConditions.elementToBeClickable(updatebutton)).click();
    }

    
    public void enterOldPass(String Oldpass) {
       // WebElement OPassElement = wait.until(ExpectedConditions.visibilityOfElementLocated(oldpassfield));
        oldpassfield.sendKeys(Oldpass);
    }
    public void enterNewPass(String Newpass) {
        //WebElement NPassElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newpassfield));
        newpassfield.sendKeys(Newpass);
    }

    public void enterConfirmPass(String Confirmpass) {
       // WebElement CPassElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmpassfield));
        confirmpassfield.sendKeys(Confirmpass);
    }



     

}
