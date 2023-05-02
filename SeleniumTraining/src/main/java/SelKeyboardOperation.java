import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelKeyboardOperation {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("username"));
		@SuppressWarnings("deprecation")
		Keyboard keyboard = ((HasInputDevices)driver).getKeyboard();
		keyboard.pressKey("a");
		keyboard.pressKey("b");
		keyboard.pressKey("c");
		keyboard.pressKey(Keys.NUMPAD1);
		keyboard.pressKey(Keys.chord("x","y","x"));
		keyboard.pressKey(Keys.chord("CONTROL", "t"));
	}

}
