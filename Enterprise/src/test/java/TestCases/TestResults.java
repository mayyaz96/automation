package TestCases;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.openqa.selenium.chrome.ChromeOptions;
import io.appium.java_client.android.AndroidDriver;
import io.github.cdimascio.dotenv.Dotenv;
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

public class TestResults {
	
	@Test
    public void SendEmail() throws InterruptedException {
		Dotenv dotenv = Dotenv.load();
		
		Thread.sleep(5000);
		
		System.out.println(dotenv.get("SMTP_USERNAME"));
		System.out.println(dotenv.get("SMTP_PASSWORD"));
		System.out.println(dotenv.get("SMTP_HOST"));
		System.out.println(dotenv.get("SMTP_PORT"));
		
	
        // Sender email credentials
        final String senderEmail = dotenv.get("SMTP_USERNAME");
    	final String senderPassword = dotenv.get("SMTP_PASSWORD").replace("\"", "").trim();

//		// Handle double quotes if present
//		if (senderPassword != null) {
//		    senderPassword = senderPassword.replace("\"", "").trim();
//		}

        // Receiver email
        String recipientEmail = "grid2.nonprod@gridsystems.pk";

        // SMTP server settings
        Properties properties = new Properties();
        properties.put("mail.smtp.host", dotenv.get("SMTP_HOST"));
        properties.put("mail.smtp.port", dotenv.get("SMTP_PORT"));
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
        	
            // Create email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject("Android Enterprise - Automation Test Results");
            message.setText("Hello, Please find the result as attached!");
            
           // String htmlContent = readHtmlFile("test-output/emailable-report.html");
            //message.setContent(htmlContent, "text/html; charset=UTF-8");

            Multipart multipart = new MimeMultipart();

            // Part 1: Email body (plain text)
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Please find the attached HTML report.", "utf-8");
            multipart.addBodyPart(textPart);

            // Part 2: Attach the HTML file
            MimeBodyPart attachmentPart = new MimeBodyPart();
            try {
				attachmentPart.attachFile(new File("test-output/ExtentReport.html"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Attach the file
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);
            // Send email
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    
    
}//test email
