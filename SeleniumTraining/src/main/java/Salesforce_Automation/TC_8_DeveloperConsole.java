package Salesforce_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_8_DeveloperConsole {

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

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		driver.manage().window().maximize();
		

		WebElement menu=driver.findElement(By.xpath("//*[@id='userNav-arrow']"));
		menu.click();
		
		
		WebElement developerconsole=driver.findElement(By.linkText("Developer Console"));
		developerconsole.click();
		Set<String> getAllWindows=driver.getWindowHandles();
		String[] window=getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(window[1]).close();
		System.out.println("Developer console Test case passed");
	}
}
