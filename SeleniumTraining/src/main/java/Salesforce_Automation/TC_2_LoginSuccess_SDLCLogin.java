package Salesforce_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_2_LoginSuccess_SDLCLogin {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		Robot r1 = new Robot();
		driver.findElement(By.id("username")).sendKeys("mailsni@abc.com");
		driver.findElement(By.id("password")).sendKeys("abc12345");

		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		driver.manage().window().maximize();

		
		  String expectedTitle = "Home Page ~ Salesforce - Developer Edition";// actual and expected are different 
		  if(actualTitle.equalsIgnoreCase(expectedTitle))
		  System.out.println("User is on home page."+ "Test Passed"); else
		  System.out.println("home page is not Launched."+ " Test Failed");
		 
	}

}
