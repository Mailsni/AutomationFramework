package Salesforce_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_5_SelUserMenuDropDown {

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

		driver.findElement(By.xpath("//span[@id=\"userNavLabel\"]")).click();
		Thread.sleep(5000);
		
		 String orgTitle = driver.getTitle();
			driver.manage().window().maximize();
			String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
			
			if(orgTitle.equalsIgnoreCase(expectedTitle))
				System.out.println("User is on home page");
			else
				System.out.println("home page is not Lunched");
			WebElement UserMenu = driver.findElement(By.xpath("//*[@id='userNavButton']"));
			UserMenu.click();
		
	}

}
