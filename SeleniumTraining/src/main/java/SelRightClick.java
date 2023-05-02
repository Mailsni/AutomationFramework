import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelRightClick {
	
	//failed

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
	
	WebElement right_click = driver.findElement(By.linkText("Forgot your password?"));
	Actions action = new Actions(driver);
	action.contextClick(right_click).sendKeys(Keys.ARROW_DOWN)
	.sendKeys(Keys.ARROW_DOWN)
	.sendKeys(Keys.ENTER)
	.build()
	.perform();
	
	}

}
