import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssSelector {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		
		driver.get("https://amazon.com/");
		driver.manage().window().maximize();

	//	WebElement login = driver.findElement(By.cssSelector("button-login"));
		WebElement login1 = driver.findElement(By.cssSelector("a#button_login"));
		login1.click();
		
		//WebElement login = driver.findElement(By.cssSelector("a#button_login"));
		WebElement	username = driver.findElement(By.cssSelector("input.head"));
		username.sendKeys("Sni");
		
	}

}
