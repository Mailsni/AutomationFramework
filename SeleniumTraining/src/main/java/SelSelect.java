

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelSelect {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			
			
			driver.get("https://amazon.com/");
			driver.manage().window().maximize();
			
			WebElement selectMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
			Select select = new Select(selectMenu);
			
			select.selectByVisibleText("Baby");
			//select.selectByValue(null)
			
WebElement account = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span]"));
Actions action = new Actions(driver);
action.moveToElement(account).build().perform();
	}

}


