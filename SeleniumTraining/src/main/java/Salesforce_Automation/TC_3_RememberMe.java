package Salesforce_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_3_RememberMe extends SalesforceLogin {

	public static void main(String[] args) throws Exception {
	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		 driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		 Robot r1 = new Robot();
		 driver.findElement(By.id("username")).sendKeys("mailsni@abc.com");
		 driver.findElement(By.id("password")).sendKeys("abc12345");
		 driver.findElement(By.xpath("//*[@id=\"rememberUn\"]")).click();
			 
		 r1.keyPress(KeyEvent.VK_ENTER);
		 r1.keyRelease(KeyEvent.VK_ENTER);
		 	
	Thread.sleep(5000);
		
		 driver.findElement(By.xpath("//span[@id=\"userNavLabel\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]")).click();
		
		 r1.keyPress(KeyEvent.VK_ENTER);
		 r1.keyRelease(KeyEvent.VK_ENTER);
		
		 
			
			
			
	}
}
