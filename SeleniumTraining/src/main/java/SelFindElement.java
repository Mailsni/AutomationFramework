import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SelFindElement {

	public static void main(String[] args) throws InterruptedException {
	
			WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("abc@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("password123");
		
		WebElement login = driver.findElement(By.id("Login"));
		login.click();
		
	}

}
