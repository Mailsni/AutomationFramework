package Salesforce_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_4_ForgotPassword extends SalesforceLogin {

	public static void main(String[] args) throws AWTException, InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			
	
			 driver.get("https://login.salesforce.com/");
			driver.manage().window().maximize();
			 Robot r1 = new Robot();
			 driver.findElement(By.xpath("//*[@id=\"forgot_password_link\"]")).click();
			 
			 Thread.sleep(3000);
		
			 driver.findElement(By.xpath("//*[@id=\"un\"]")).sendKeys("mailsni@abc.com");
			
		
			 r1.keyPress(KeyEvent.VK_ENTER);
			 r1.keyRelease(KeyEvent.VK_ENTER);
			 	
			Thread.sleep(5000);
			
			  WebElement contnue=driver.findElement(By.xpath("//*[@id='continue']"));
			   clickObj(contnue,"Continue");
			
	}

}
