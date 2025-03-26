package TestCases;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.chrome.ChromeOptions;
import io.appium.java_client.android.AndroidDriver;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class WebPortal {

	Dotenv dotenv = Dotenv.load();
	WebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	
	
	
	public void loginPortal() throws InterruptedException {
		
		
		 ChromeOptions options = new ChromeOptions();
	     options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.get(dotenv.get("BASE_URL"));
		

		WebElement emailfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginEmail")));
		
		emailfield.sendKeys(dotenv.get("EMAIL"));
		
		WebElement nextbutton = driver.findElement(By.id("loginEmailNext"));	
		nextbutton.click();	
		
		
		WebElement passwordfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginPassword")));		
		passwordfield.sendKeys(dotenv.get("PASSWORD"));

		
		WebElement loginbutton = driver.findElement(By.id("loginButton"));	
		loginbutton.click();
		
		Thread.sleep(10000);
		
		
		

	}//message traveler end
	
	
	

	@Test
	public void MessageTraveler() throws InterruptedException {
		
		
		loginPortal();
		driver.get(dotenv.get("BASE_URL")+"grid-portal/communication/message-traveler");
		
		Thread.sleep(12000);
		
		WebElement searchfield = driver.findElement(By.cssSelector("[formcontrolname=\"nameOrEmail\"]"));
		
		searchfield.sendKeys(dotenv.get("EMAIL"));
		
		Thread.sleep(8000);
		
		WebElement selectchat = driver.findElement(By.cssSelector("[class=\"text-overflow-ellipsis\"]"));	
		selectchat.click();
		
		Thread.sleep(5000);
		
		WebElement message = driver.findElement(By.id("message"));	
		message.sendKeys("Hello! How are you.");
		
		Thread.sleep(4000);
		message.sendKeys(Keys.RETURN);
		driver.quit();
		
		

	}//message traveler end
	
	
	@Test
	public void CityStayCheck() throws InterruptedException {
		loginPortal();
		
		Thread.sleep(5000);
		//driver.get(dotenv.get("BASE_URL")+"/grid-portal/asset-management/control-center");
		//Thread.sleep(10000);
		//driver.get(dotenv.get("BASE_URL")+"/grid-portal/asset-management/asset-tracking/listing");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		 // Click on span element
        WebElement spanElement = driver.findElement(By.xpath("//i[@class='gri-menu-bars']"));
        spanElement.click();
        Thread.sleep(2000); // Wait for elements to load

        // Click on 'Asset Tracking'
        WebElement assetTracking = driver.findElement(By.xpath("//a[normalize-space()='Asset Tracking']"));
        assetTracking.click();
        Thread.sleep(10000);
        // Click on menu bars icon
        WebElement spanElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Add Filter')]")));
        spanElement2.click();
        Thread.sleep(2000);

        // Enter text in the input field
        WebElement inputField = driver.findElement(By.xpath("//input[@id='keywordInput']"));
        inputField.sendKeys("city stay");
        Thread.sleep(2000);

       
        // Click on 'Apply' button
        WebElement applyButton = driver.findElement(By.xpath("//button[normalize-space()='Apply']"));
        applyButton.click();
        Thread.sleep(2000);
        
        WebElement PNRButton = driver.findElement(By.xpath("//a[@class='pnr-ch-length d-inline-block lh-xs text-overflow-ellipsis text-primary ng-star-inserted']"));
        PNRButton.click();
        Thread.sleep(5000);
      
        // Locate and validate 'Rawalpindi'
        WebElement location = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[@class='d-block']")));
        String locationText = location.getText();
        if (locationText.equals("Rawalpindi")) {
            System.out.println("✅ Location is correctly displayed as 'Rawalpindi'");
        } else {
            System.out.println("❌ Location mismatch! Found: " + locationText);
        }

        // Locate and validate 'City Stay'
        WebElement stayType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='mb-0 text-dark']")));
        String stayTypeText = stayType.getText();
        if (stayTypeText.equals("City Stay")) {
            System.out.println("✅ Stay type is correctly displayed as 'City Stay'");
        } else {
            System.out.println("❌ Stay type mismatch! Found: " + stayTypeText);
        }
        
        Thread.sleep(2000);
     // Click on 'Remove PNR' button
        WebElement removePNRButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Remove PNR']")));
        removePNRButton.click();
        System.out.println("✅ Clicked on 'Remove PNR' button");
        Thread.sleep(4000);
        // Click on 'Remove' button (confirmation)
        WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Remove']")));
        removeButton.click();
        System.out.println("✅ Clicked on 'Remove' button");
        Thread.sleep(2000);
        if (isSuccessMessageDisplayed(driver)) {
            System.out.println("✅ Success message is displayed.");
        } else {
            System.out.println("❌ Success message not found.");
        }

	}
	public boolean isSuccessMessageDisplayed(WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Success']")));
	        return successMessage.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	
	//String severity,String[] categories,String[] locations
	@Test
	public void  EventPublish() throws InterruptedException {
		
		String severity = "Moderate";
		String[] categories = {"Violance","Health"};	
		String[] locations = {"Pakistan","United States"};
		
		loginPortal();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get(dotenv.get("BASE_URL")+"/grid-admin-portal/events");
		
		//((JavascriptExecutor) driver).executeScript("document.body.style.transform='scale(0.5)'; document.body.style.transformOrigin='0 0';");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement EventsTab =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='bi bi-bullseye d-block']")));   
		EventsTab.click();
		WebElement AddEvent =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[@class='text-uppercase']")));   
		AddEvent.click();

		
		WebElement Etitle =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));   

		Etitle.sendKeys("Automation Mobile Event - Beyond Limits: A Journey to Success");
		
		WebElement Esummary = driver.findElement(By.id("summary"));
		
		Esummary.sendKeys("\"Beyond Limits: A Journey to Success\" is an inspiring event designed to empower individuals to break barriers, overcome challenges, and reach their full potential. This event brings together industry leaders, motivational speakers, and success-driven professionals to share insights, strategies, and personal stories of resilience.");
		

		WebElement Eanalysis = driver.findElement(By.cssSelector("[formcontrolname=\"analysis\"]"));
		
		Eanalysis.sendKeys("\"Beyond Limits: A Journey to Success\" has the potential to be a transformative event for attendees looking to push past obstacles and achieve their goals. By combining motivation with actionable strategies, it ensures a meaningful and lasting impact on participants.");
		
		WebElement Eadvice = driver.findElement(By.cssSelector("[formcontrolname=\"advice\"]"));
		
		Eadvice.sendKeys(" Before attending, define what you want to achieve. Are you looking for inspiration, networking, or specific strategies for success? Having clear objectives will help you focus on the most relevant sessions.");

		
		  	if(severity == "Low"){
			  
			  WebElement Slow = driver.findElement(By.id("0"));
				
			  Slow.click();
		       
		      }
		      if(severity == "Moderate"){
		    	  
		    	  WebElement Smod = driver.findElement(By.id("1"));
					
		    	  Smod.click();
		     
		      }
		      if(severity == "High"){
		    	  
		    	  WebElement Shigh = driver.findElement(By.id("2"));
					
		    	  Shigh.click();
		        
		      }
		      if(severity == "Extreme"){
		    	  
		    	  WebElement Sext = driver.findElement(By.id("3"));
					
		    	  Sext.click();
		        
		      }
		
		      
		      
		      for (String str : categories) {
		    	  
		    	 
		    	  
		            if (str.equals("Violance")) { 
		            	
		            	
		            	
		            	 WebElement Cvio = driver.findElement(By.id("Violence-0"));
							
		            	 Cvio.click();
		            	 
		                
		            }
		            
		            if (str.equals("Unrest")) { 
		            	 WebElement Cunr = driver.findElement(By.id("Unrest-1"));
							
		            	 Cunr.click();
		            	
		                
		            }
		            if (str.equals("Environment")) {  
		            	
		            	 WebElement Cenv = driver.findElement(By.id("Enviroment-2"));
							
		            	 Cenv.click();
		            	 
     
		            }
		            if (str.equals("Health")) {  
		            	
		            	 WebElement Chel = driver.findElement(By.id("Health-3"));
							
		            	 Chel.click();
		            	
		            }
		            if (str.equals("Infrastructure")) {  
		            	
		            	 WebElement Cinf = driver.findElement(By.id("Infrastructure-4"));
							
		            	 Cinf.click();
     
		            }
 
		            
		        }
		      
		      WebElement addlocation = driver.findElement(By.xpath("/html/body/grid-admin-portal-root/grid-admin-portal-layout/div/main/events-add-edit-event-form/div/div/form/div/div[2]/div[2]/events-table-event-location/div[1]/button"));
				
         	 addlocation.click();
		      
         	WebElement addlocationfield = driver.findElement(By.cssSelector("[name=\"autocomplete\"]"));
 
         	addlocationfield.sendKeys("Pakistan");
         	
         	//Thread.sleep(3000);
         	
         	WebElement selectlocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("82")));
         	selectlocation.click();
         	Thread.sleep(5000);
		    
         	WebElement addlocationbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/modal-container/div[2]/div/ng-component/div[3]/button[2]")));
         	addlocationbutton.click();
         	Thread.sleep(4000);
         	WebElement saveevent = driver.findElement(By.xpath("/html/body/grid-admin-portal-root/grid-admin-portal-layout/div/main/events-add-edit-event-form/div/div/footer/div/div/button[2]"));
         	saveevent.click();
         	Thread.sleep(4000);
         	
         	WebElement publishevent = driver.findElement(By.xpath("/html/body/grid-admin-portal-root/grid-admin-portal-layout/div/main/events-event-details/div/div[2]/events-detail-event-update/div/footer/div/div[2]/button"));
         	publishevent.click();
         	Thread.sleep(4000);
         	WebElement eventcheckbox = driver.findElement(By.id("name"));
         	eventcheckbox.click();
         	Thread.sleep(3000);
         	WebElement expirycal = driver.findElement(By.xpath("/html/body/modal-container/div[2]/div/ng-component/div[2]/form/div[2]/date-picker-single-v2/div/input"));
         	expirycal.click();
         	Thread.sleep(4000);
         	
        	
         	driver.findElement(By.xpath("//button[@class='next' and @type='button']")).click();
         	System.out.println("✅ Clicked on the 'Next Month' button in the date picker.");

         	Thread.sleep(2000);
         	
         	WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[not(contains(@class,'disabled'))]//span[contains(text(),'16')]")));
         	dateElement.click();
         	System.out.println("✅ Clicked on the date '16' in the date picker.");

         	Thread.sleep(2000);
         	
        	WebElement submitevent = driver.findElement(By.xpath("//button[@type='submit']"));
        	submitevent.click();
        	
        	WebElement ToastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Event has been published successfully']")));

        	Assert.assertTrue(ToastMessage.isDisplayed(), "✅ Event published confirmation is visible.");
        	System.out.println("✅ Verified: 'Event has been published successfully' label is visible.");

        	
         	Thread.sleep(2000);
         	
         	driver.quit();
		
		

	}//Event Publish end
	
	
	@Test
	public void MasscommPublish() throws InterruptedException {
		
		
		
		
		loginPortal();
		
		driver.get(dotenv.get("BASE_URL")+"grid-portal/mass-comm/create");
		
		Thread.sleep(10000);
		
		WebElement Mtitle = driver.findElement(By.id("createTitle"));
		
		Mtitle.sendKeys("Automation Mobile Event - Beyond Limits: A Journey to Success");
		
		WebElement Mdescription = driver.findElement(By.id("description"));
		
		Mdescription.sendKeys("\"Beyond Limits: A Journey to Success\" is an inspiring event designed to empower individuals to break barriers, overcome challenges, and reach their full potential. This event brings together industry leaders, motivational speakers, and success-driven professionals to share insights, strategies, and personal stories of resilience.");
		

		WebElement mobilechannel = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[2]/mass-comm-mass-comm-wizard/div/div[1]/display-stepper/mass-comm-create/div/div/form/div[3]/ui-form-checkbox/span[2]/label"));
		
		mobilechannel.click();
		
		WebElement msubmit = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[2]/mass-comm-mass-comm-wizard/div/div[2]/div/button[2]"));
		
		msubmit.click();
		
		Thread.sleep(3000);
		
		WebElement addrecipientdropdown = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[2]/mass-comm-mass-comm-wizard/div/div[2]/display-stepper/mass-comm-add-recipient/div/div[1]/div[1]/div[2]/div[2]/button"));
		addrecipientdropdown.click();
		Thread.sleep(3000);
		
		WebElement addmanually = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[2]/mass-comm-mass-comm-wizard/div/div[2]/display-stepper/mass-comm-add-recipient/div/div[1]/div[1]/div[2]/div[2]/ul/li[1]/a"));
		addmanually.click();
		Thread.sleep(3000);
        
		
		WebElement searchcontact = driver.findElement(By.id("contactIds"));
		searchcontact.sendKeys(dotenv.get("EMAIL"));
		Thread.sleep(3000);
		
		WebElement selectuser = driver.findElement(By.xpath("/html/body/modal-container/div[2]/div/ui-add-recipients-manually/div/div[2]/div/div[1]/form/div/autocomplete-add-new-user/autocomplete-dropdown/form/div[2]/ul/li[1]/div/strong"));
		selectuser.click();
		Thread.sleep(3000);
		
		WebElement nextaddmanually = driver.findElement(By.xpath("/html/body/modal-container/div[2]/div/ui-add-recipients-manually/div/div[3]/div[2]/button[2]"));
		nextaddmanually.click();
		Thread.sleep(3000);
		
		WebElement nextrecipientstep = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[2]/mass-comm-mass-comm-wizard/div/div[3]/div/button[4]"));
		nextrecipientstep.click();
		Thread.sleep(3000);
		
		WebElement clickquestion = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[2]/mass-comm-mass-comm-wizard/div/div[2]/display-stepper/mass-comm-broadcast-message/div/div[2]/div[3]/div[1]/div/button[4]"));
		clickquestion.click();
		Thread.sleep(3000);
		
		WebElement questiontitle = driver.findElement(By.cssSelector("[formcontrolname=\"question\"]"));   
		questiontitle.sendKeys("Is automation the future?");
		Thread.sleep(3000);
		
		WebElement answer = driver.findElement(By.id("exampleFormControlInput1"));
		answer.sendKeys("Yes");
		Thread.sleep(3000);
		
		
		nextrecipientstep.click();
		Thread.sleep(3000);
		
		nextrecipientstep.click();
		Thread.sleep(3000);
		
		WebElement laststepnext = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[2]/mass-comm-mass-comm-wizard/div/div[3]/div/button[4]"));
		laststepnext.click();
		Thread.sleep(3000);
		
		
		WebElement finalcheckboxmass = driver.findElement(By.id("flexSwitchmasscomm"));
		finalcheckboxmass.click();
		Thread.sleep(2000);
		
		WebElement finalsubmitmasscomm = driver.findElement(By.xpath("/html/body/modal-container/div[2]/div/ui-publish-summary-popup/div/div/div/div/div/div/div/div/form/div[2]/button[2]"));
		finalsubmitmasscomm.click();
		Thread.sleep(3000);
		
		
		
		driver.quit();
		
		

	}//Publish Mass comm
	
	
	@Test
	public void MasscommUnPublish() throws InterruptedException {
		
		
		
		loginPortal();
			
		driver.get(dotenv.get("BASE_URL")+"grid-portal/mass-comm");
		
		Thread.sleep(10000);
		

		WebElement masscommsearch = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[1]/div[1]/mass-comm-listing/div[1]/ui-mass-comm-listing-filters/form/div/div[1]/div/input"));
		
		masscommsearch.sendKeys("Automation Mobile Event - Beyond Limits");
		
		Thread.sleep(3000);
		
		WebElement selectmasscomm = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[1]/div[1]/mass-comm-listing/div[2]/ui-mass-comm-card/div/div[1]/strong"));
		
		selectmasscomm.click();
		
		Thread.sleep(3000);
		
		WebElement responsebyrecipients = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[2]/mass-comm-mass-comm-details/div/div[1]/div[2]/div[1]/a[2]"));
		responsebyrecipients.click();
		Thread.sleep(3000);
		
		WebElement masscommresponse = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[2]/mass-comm-mass-comm-details/div/div[2]/ui-responses-by-recipients/div[3]/div/ui-responses-by-recipients-table/table/tbody/tr/td[3]/label"));
		Assert.assertEquals(masscommresponse.getText(), "Yes", "Answer does not match!");
		Thread.sleep(3000);
        
		
		
		WebElement threedotsmasscomm = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[1]/div[1]/mass-comm-listing/div[2]/ui-mass-comm-card/div/div[1]/div/button/i"));
		threedotsmasscomm.click();
		Thread.sleep(2000);
		
		WebElement masscommdeactivate = driver.findElement(By.xpath("/html/body/grid-portal-root/grid-portal-layout2/main/mass-comm-feature/div/div[1]/div[1]/mass-comm-listing/div[2]/ui-mass-comm-card/div/div[1]/div/ul/li/a"));
		masscommdeactivate.click();
		Thread.sleep(3000);
		
		WebElement confirmdeactivate = driver.findElement(By.xpath("/html/body/modal-container/div[2]/div/popup-confirmation/div[3]/button[2]"));
		confirmdeactivate.click();
		Thread.sleep(3000);
		
		System.out.println("Mass Communication Unpublished!");
		

		
		driver.quit();
		
		

	}//UnPublish Mass comm
	
	


	@Test
	public void OpsPortalVerify() throws InterruptedException, TimeoutException {
		try {
			
			loginPortal();
		
		driver.get(dotenv.get("BASE_URL")+"grid-portal/grid-operations/chat");
		
		Thread.sleep(11000);

		//((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%';");

		WebElement ClickTicket = driver.findElement(By.xpath("//span[@class='text-overflow-ellipsis']"));
		ClickTicket.click();
		//clickElement(By.xpath("//span[@class='text-overflow-ellipsis']"));

        // Check and click Acknowledge button if present
        List<WebElement> acknowledgeButtonList = driver.findElements(By.xpath("//button[contains(@class, 'btn-primary btn-md px-4 rounded-5')]"));
        if (!acknowledgeButtonList.isEmpty()) {
            acknowledgeButtonList.get(0).click();
            System.out.println("✅ Acknowledge Button clicked.");
        } else {
            System.out.println("⚠️ Acknowledge Button not found, skipping.");
        }
        
        Thread.sleep(10000);
        WebElement innerpan = driver.findElement(By.xpath("//*[@id=\"chatWindow\"]"));
        //innerpan.click();
        innerpan.sendKeys(Keys.HOME);
        
        Thread.sleep(1000);
        
        Assert.assertEquals(driver.findElement(By.xpath("//pre[@class='pt-2 border-top mb-1 text-break fs-no msg-pre-format ng-star-inserted']")).getText().trim(), "This emergency is initiated by automation", "❌ Text verification failed!");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chatWindow = driver.findElement(By.xpath("//*[@id='chatWindow']"));
        
        By cameraPictureLocator = By.xpath("//pre[normalize-space()='This Camera Picture is sent by automation script']");
        By GalleryPictureLocator = By.xpath("//pre[normalize-space()='This image is sent by automation']");

        // ✅ Try to find the element inside chatWindow
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cameraPictureLocator));
		Assert.assertTrue(element.isDisplayed(), "✅ Element found: 'This Camera Picture is sent by automation script'");
		for (int i = 0; i < 8; i++) chatWindow.sendKeys(Keys.ARROW_DOWN);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(GalleryPictureLocator));
		Assert.assertTrue(element.isDisplayed(), "✅ Element found: 'This Galerry image is sent by automation'");
        
		
        for (int i = 0; i < 5; i++) chatWindow.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(driver.findElement(By.xpath("//pre[normalize-space()='This image is sent by automation']")).getText().trim(), "This image is sent by automation", "❌ Text verification failed!");
        Thread.sleep(5000);
        for (int i = 0; i < 10; i++) chatWindow.sendKeys(Keys.ARROW_DOWN);
        System.out.println("🔹  Click on Mobile App/Device Information ");
        driver.findElement(By.xpath("//h5[normalize-space()='Mobile App/Device Information']")).click();
        Thread.sleep(3000);
//        System.out.println("🔹 Scrolling further down in Mobile info");
       driver.findElement(By.xpath("//accordion[@role='tablist']")).sendKeys(Keys.END);
       Thread.sleep(2000);
       String[] xpaths = {
    		    "//span[normalize-space()='Auto Location Sharing']",
    		    "//li[normalize-space()='App Name: Global Rescue GRID']",
    		    "//li[normalize-space()='App Version: 2.2.4']",
    		    "//span[normalize-space()='Attachments']"
    		};

    		for (String xpath : xpaths) {
    		    Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed(), "❌ Element not found: " + xpath);
    		    System.out.println("✅ Verified: " + xpath);
    		}
    		
    	Thread.sleep(2000);
    	innerpan.sendKeys(Keys.END);
    	
    	
    	
    	driver.findElement(By.xpath("//a[@class='bg-primary text-white rounded-5 py-2 px-3 fw-bold ng-star-inserted']")).click();
    	System.out.println("✅ Clicked on Primary Action Button");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//button[normalize-space()='Close Ticket']")).click();
    	System.out.println("✅ Clicked on 'Close Ticket' Button");
    	Thread.sleep(2000);
    	  driver.quit();
		}catch (Exception e) {throw e;}
	
	}// ops portal
	
	@Test
	public void OpsPortalForContactGRVerify() throws InterruptedException, TimeoutException {
		try {
			
			loginPortal();
		
		driver.get(dotenv.get("BASE_URL")+"grid-portal/grid-operations/chat");
		
		Thread.sleep(11000);

		//((JavascriptExecutor) driver).executeScript("document.body.style.zoom='70%';");

		WebElement ClickTicket = driver.findElement(By.xpath("//span[@class='text-overflow-ellipsis']"));
		ClickTicket.click();
		//clickElement(By.xpath("//span[@class='text-overflow-ellipsis']"));

        // Check and click Acknowledge button if present
        List<WebElement> acknowledgeButtonList = driver.findElements(By.xpath("//button[contains(@class, 'btn-primary btn-md px-4 rounded-5')]"));
        if (!acknowledgeButtonList.isEmpty()) {
            acknowledgeButtonList.get(0).click();
            System.out.println("✅ Acknowledge Button clicked.");
        } else {
            System.out.println("⚠️ Acknowledge Button not found, skipping.");
        }
        
        Thread.sleep(10000);
        WebElement innerpan = driver.findElement(By.xpath("//*[@id=\"chatWindow\"]"));
        //innerpan.click();
        innerpan.sendKeys(Keys.HOME);
        
        Thread.sleep(1000);
        
       // Assert.assertEquals(driver.findElement(By.xpath("//pre[@class='pt-2 border-top mb-1 text-break fs-no msg-pre-format ng-star-inserted']")).getText().trim(), "This emergency is initiated by automation", "❌ Text verification failed!");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chatWindow = driver.findElement(By.xpath("//*[@id='chatWindow']"));
        
        By cameraPictureLocator = By.xpath("//pre[normalize-space()='This image is sent by automation']");
        By GalleryPictureLocator = By.xpath("//pre[normalize-space()='This Document is sent by automation']");

        // ✅ Try to find the element inside chatWindow
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(cameraPictureLocator));
		Assert.assertTrue(element.isDisplayed(), "✅ Element found: 'This image is sent by automation'");
		for (int i = 0; i < 8; i++) chatWindow.sendKeys(Keys.ARROW_DOWN);
		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(GalleryPictureLocator));
		Assert.assertTrue(element.isDisplayed(), "✅ Element found: 'This Galerry image is sent by automation'");
        
		
        for (int i = 0; i < 5; i++) chatWindow.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(driver.findElement(By.xpath("//pre[normalize-space()='This image is sent by automation']")).getText().trim(), "This image is sent by automation", "❌ Text verification failed!");
        Thread.sleep(5000);
        for (int i = 0; i < 10; i++) chatWindow.sendKeys(Keys.ARROW_DOWN);
        System.out.println("🔹  Click on Mobile App/Device Information ");
        driver.findElement(By.xpath("//h5[normalize-space()='Mobile App/Device Information']")).click();
        Thread.sleep(3000);
//        System.out.println("🔹 Scrolling further down in Mobile info");
       driver.findElement(By.xpath("//accordion[@role='tablist']")).sendKeys(Keys.END);
       Thread.sleep(2000);
       String[] xpaths = {
    		    "//span[normalize-space()='Auto Location Sharing']",
    		    "//li[normalize-space()='App Name: Global Rescue GRID']",
    		    "//li[normalize-space()='App Version: 2.2.4']",
    		    "//span[normalize-space()='Attachments']"
    		};

    		for (String xpath : xpaths) {
    		    Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed(), "❌ Element not found: " + xpath);
    		    System.out.println("✅ Verified: " + xpath);
    		}
    		
    	Thread.sleep(2000);
    	innerpan.sendKeys(Keys.END);
    	
    	
    	
    	driver.findElement(By.xpath("//button[@class='btn btn-sm btn-danger rounded-5 ng-star-inserted']")).click();
    	System.out.println("✅ Clicked on Primary Action Button");
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//button[normalize-space()='Close Ticket']")).click();
    	System.out.println("✅ Clicked on 'Close Ticket' Button");
    	Thread.sleep(2000);
    	  driver.quit();
		}catch (Exception e) {throw e;}
	
	}// ops portal
	
	
	

}// main class
