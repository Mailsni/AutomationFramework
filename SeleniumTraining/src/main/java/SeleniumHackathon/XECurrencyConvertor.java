package SeleniumHackathon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XECurrencyConvertor {
	
	     WebDriver driver;
	 	@BeforeTest
	 	public void setUp() throws InterruptedException {
	 		WebDriverManager.chromedriver().setup();
	 		driver = new ChromeDriver();
	 		driver.get("https://www.xe.com/");
	 		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	 		driver.manage().window().maximize();
	 	}


@Test
/**
 * this class is used to convert the currency from USD to INR
 * 
 */

	    public void testCurrencyConversion() {
	       
			try {/*
					 * WebDriverWait wait = new WebDriverWait(driver,20);
					 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(
					 * "//*[@id=\"__next\"]")));
					 */
				switchToIframe(driver, By.xpath("//iframe[@id='tool-iframe']"));
		    //From -DropDown select USD
         WebElement fromDropdown = driver.findElement(By.xpath("//*[@id=\"midmarketFromCurrency-current-selection\"]"));
         Select fromSelect = new Select(fromDropdown);
         fromSelect.selectByValue("USD - US Dollar");

         // To - Dropdown selec inr
         WebElement toDropdown = driver.findElement(By.id("//*[@id=\"midmarketToCurrency-current-selection\"]"));
         Select toSelect = new Select(toDropdown);
         toSelect.selectByValue("INR - Indian Rupee");

         // Click on the "Convert" button
         WebElement convertButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/section/div[2]/div/main/div/div[2]/button"));
         convertButton.click();

         // Wait for the conversion to be displayed
         Thread.sleep(3000);

         // Print the converted amount
         WebElement convertedAmount = driver.findElement(By.id("ucc-container-success"));
         System.out.println("Converted Amount: " + convertedAmount.getText());

     } catch (InterruptedException e) {
         e.printStackTrace();
     } finally {
         // Close the browser
         driver.quit();
     }
 }

public static void switchToIframe(WebDriver driver, By iframeLocator) {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
}
}


