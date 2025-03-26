package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseSetup;
import io.appium.java_client.android.AndroidDriver;

public class CitySelection extends BaseSetup {

    private AndroidDriver driver;
    private WebDriverWait wait;

    // Constructor
    public CitySelection(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    // Locators
    private By autoCompleteTextView = By.id("com.globalrescue.enterpriseid/tvAutoComplete");
    private By dropdownItem = By.xpath("//android.widget.TextView[@text='Islamabad']"); // Replace 'Islamabad' with the desired city
    private By confirmButton = By.id("com.globalrescue.enterpriseid/btnConfirm"); // Locator for "Confirm" button, if required

    // Method to select city
    public void selectCity(String cityName) {
        // Step 1: Input text into the AutoCompleteTextView
        WebElement textView = wait.until(ExpectedConditions.visibilityOfElementLocated(autoCompleteTextView));
        textView.sendKeys(cityName);

        // Step 2: Wait for the dropdown and select the desired item
        WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='" + cityName + "']")));
        dropdownOption.click();

        // Step 3 (Optional): Click the "Confirm" button if needed
        WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmButton));
        confirm.click();
    }
    public void selectCityUsingKeys(String cityName) {
        // Input text into the AutoCompleteTextView
        WebElement autoCompleteField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.globalrescue.enterpriseid/tvAutoComplete")));
        autoCompleteField.sendKeys(cityName);

        // Send the "down" key event to highlight the first item
      //  driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

        // Send the "enter" key event to select the highlighted item
        //driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

}
