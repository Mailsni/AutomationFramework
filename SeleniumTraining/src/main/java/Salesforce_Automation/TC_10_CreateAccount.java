
	package Salesforce_Automation;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


	public class TC_10_CreateAccount {

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
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			driver.manage().window().maximize();

			//Opening Accounts page
			WebElement Accounts_Tab = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
			Accounts_Tab.click();
			System.out.println("Selected Accounts Tab:");

			//Creating New Account
			WebElement New = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
			New.click();
			System.out.println("Clicked on New tab..");
			WebElement AccountName = driver.findElement(By.id("acc2"));
			AccountName.clear();
			AccountName.sendKeys("Accounts");
			WebElement selecttype = driver.findElement(By.xpath("//select[@id='acc6']"));
			Select select = new Select(selecttype);
			select.selectByVisibleText("Technology Partner");
			WebElement  customerpriority = driver.findElement(By.xpath("//*[@id=\"00N3x00000CmLmi\"]/option[2]"));
			Select select1 = new Select(customerpriority);
			select1.selectByVisibleText("High");
			WebElement Save = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
			Save.click();
			System.out.println("Clicked on Save button..");
			System.out.println("TestCase 10 passed");
		}

	}
