import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowserChrome {

	
	public static void main(String[] args) throws InterruptedException {
		
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");

		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("abcd");
		search.click();
		Thread.sleep(5000);
		
        List<WebElement> opts = driver.findElements(By.xpath("//li[@class='sbct']")); 
        for (WebElement option : opts) {
        	System.out.println(option.getText());
        }
        		
		}

	}

