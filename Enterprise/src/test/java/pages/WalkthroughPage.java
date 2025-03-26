package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

public class WalkthroughPage {
    private AndroidDriver driver;
    private WebDriverWait wait;
    public WalkthroughPage(AndroidDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public boolean isDXLogoDisplayed() {
        return driver.findElement(By.id("com.globalrescue.enterprise:id/dxLogo")).isDisplayed();
    }
    public boolean isSkipButtonClickable() {
        return driver.findElement(By.id("com.globalrescue.enterprise:id/toolbar_skip")).isEnabled();
    }

    public String getSkipButtonText() {
        return driver.findElement(By.id("com.globalrescue.enterprise:id/toolbar_skip")).getText();
    }
    public boolean isUpperTextDisplayed() {
        return driver.findElement(By.id("com.globalrescue.enterprise:id/upperText")).isDisplayed();
    }

    public String getUpperText() {
        return driver.findElement(By.id("com.globalrescue.enterprise:id/upperText")).getText();
    }
    public boolean isLowerTextDisplayed() {
        return driver.findElement(By.id("com.globalrescue.enterprise:id/lowerText")).isDisplayed();
    }

    public String getLowerText() {
        return driver.findElement(By.id("com.globalrescue.enterprise:id/lowerText")).getText();
    }
    public boolean isFrameLayoutDisplayed() {
        return driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.view.ViewGroup")).isDisplayed();
    }
    public boolean isImageVisible() {
        return driver.findElement(By.id("com.globalrescue.enterprise:id/imageView")).isDisplayed();
    }

    public boolean isImageSwipeable() {
        try {
            WebElement image = driver.findElement(By.id("com.globalrescue.enterprise:id/imageView"));
            
            // Check if the element is inside a ViewPager (which allows swiping)
            WebElement viewPager = driver.findElement(By.id("com.globalrescue.enterprise:id/viewPagerWalkthrough"));

            return viewPager.isDisplayed() && image.isDisplayed();
        } catch (NoSuchElementException e) {
            return false; // If ViewPager is not found, assume it's not swipeable
        }
    }
    public boolean isIndicatorDisplayed() {
        try {
            WebElement indicatorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.globalrescue.enterprise:id/indicator")));
            return indicatorElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isIndicatorClickable() {
        try {
            WebElement indicatorElement = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("com.globalrescue.enterprise:id/indicator")));
            return indicatorElement.isDisplayed() && indicatorElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }


    public void swipeLeft() {
        
        	WebElement element = new WebDriverWait(driver, Duration.ofSeconds(30))
        		    .until(ExpectedConditions.presenceOfElementLocated(By.id("com.globalrescue.enterprise:id/imageView")));

            int startX = element.getLocation().getX() + element.getSize().getWidth() - 10;
            int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
            int endX = element.getLocation().getX() + 10;
            int endY = startY;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 0);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(800), Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(swipe));
        
    }
}
