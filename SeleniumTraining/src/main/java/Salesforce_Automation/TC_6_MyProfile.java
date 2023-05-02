package Salesforce_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveMouseAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_6_MyProfile extends SalesforceLogin{
	public static void main(String[] args) throws AWTException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		Robot r1 = new Robot();
		driver.findElement(By.id("username")).sendKeys("mailsni@abc.com");
		driver.findElement(By.id("password")).sendKeys("abc12345");//logged in
		
		r1.keyPress(KeyEvent.VK_ENTER);
		r1.keyRelease(KeyEvent.VK_ENTER);
		
		//Myprofile
		driver.findElement(By.xpath("//span[@id=\"userNavLabel\"]")).click();
		WebElement images= driver.findElement((By.xpath("//*[@id=\"photoSection\"]/span[2]/img[1]")));
		Actions action = new Actions(driver);
		action.moveToElement(images).build().perform();
	
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Contact
		driver.findElement(By.xpath("//li[@id=\"Contact_Tab\"]")).click(); 
		driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]")).click(); //edit
		WebElement profileIframe = driver.findElement(By.id("contactInfoContentId"));
		switchFrame(driver, profileIframe);
		
		
		
	//	driver.findElement(By.id("aboutTab")).click();
		WebDriverWait w = new WebDriverWait(driver, 20);

		//WebElement home = driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a")).click(); 
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"publisherAttachTextPost\"]/span[1]")).click(); //post

		WebElement Editprofile = driver.findElement(By.xpath("//a[contains(@class,'contactInfoLaunch editLink')]//img"));
		clickObj(Editprofile, "Editlink");
		 driver.findElement(By.xpath("//body[@class=\"chatterPublisherRTE cke_editable cke_editable_themed cke_contents_ltr cke_show_borders placeholder\"]"
		  )).sendKeys("Testing");
		  
		  driver.findElement(By.xpath("//*[@id=\"cke_43_contents\"]/iframe")).sendKeys(
		  "Testing"); //driver.switchTo().frame(myFrame);
		  
		  
		  //driver.findElement(By.xpath("//*[@id=\"publishersharebutton\"]")).click();/
		  
		 		
		driver.findElement(By.xpath("//*[@id=\"home_Tab\"]/a")).click(); //Home
		
		
		
	}
}