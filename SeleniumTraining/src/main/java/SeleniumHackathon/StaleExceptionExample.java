package SeleniumHackathon;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author mails
 *This class is to run an example for stale exception
 */
public class StaleExceptionExample {

	WebDriver driver;

	
	public void launchPage() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		//driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	}

	/*@Test
	// Searching "mouse" on the searchbox
	public void addToAmazonCart() {

		try {
			WebElement element = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
			element.click();
		} catch (StaleElementReferenceException e) {
			System.out.print("Element is stale: " + e.getMessage());
		}
		driver.quit();*/

	}

