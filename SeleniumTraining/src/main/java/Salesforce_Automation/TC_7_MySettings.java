package Salesforce_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_7_MySettings extends SalesforceLogin {

		private static WebElement Test_Reminder = null;

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

			WebElement userlabel = driver.findElement(By.xpath("//span[@id=\"userNavLabel\"]"));//Myprofile
			userlabel.click();
			
			//Personal Info
			WebElement Personal = driver.findElement(By.xpath("//*[@id=\"PersonalInfo_font\"]"));
			Personal.click();
			
			//Login nHist
			WebElement LoginHistory = driver.findElement(By.xpath("//*[@id=\"LoginHistory_font\"]"));
			LoginHistory.click();
			
	
			String dropdownverify=driver.findElement(By.xpath("//div[@id='userNav-menuItems']")).getText();
			System.out.println(dropdownverify);
			
			//MySettings
			WebElement MySettings = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]"));
			MySettings.click();
			String expectedUrl = driver.getCurrentUrl();
			String actualUrl = "https://abccom341-dev-ed.develop.my.salesforce.com/ui/setup/Setup?setupid=PersonalSetup";
			if(actualUrl.equalsIgnoreCase(expectedUrl)) {
				System.out.println("User is on MySettings page");
			}
			
			else {
				System.out.println("MySettings page is not Launched");
			}
			
			
			//SalesForce Chatter
			WebElement dropdown = driver.findElement(By.id("p4"));
			Select dropdownOptions = new Select(dropdown); 
			dropdownOptions.selectByVisibleText("Salesforce Chatter");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			//Display and Layout
			System.out.println("Clicked on DisplayandLayout");
			driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[2]")).getText(); // My Settings
			driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout\"]"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			r1.keyPress(KeyEvent.VK_ENTER);
			r1.keyRelease(KeyEvent.VK_ENTER);
			
		
			dropdown = driver.findElement(By.id("duel_select_0"));
			dropdownOptions = new Select(dropdown); 
			dropdownOptions.selectByVisibleText("Reports");
			WebElement Add_Arrow = driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]/img"));
			Add_Arrow.click();
			
			// if the selected element is in Selected Tabs dropdown
			dropdown = driver.findElement(By.id("duel_select_1"));
			dropdownOptions = new Select(dropdown); 
			List<WebElement> elements = dropdownOptions.getOptions();
			for(int i=0; i<elements.size(); i++) {
				if(elements.get(i).getText().equals("Reports")) {
					System.out.println("Reports Tab are added");	
				}
				else {
					System.out.println("Reports Tabs are not added");
				}
			}
			
			//Email Tab
			WebElement Email = driver.findElement(By.id("EmailSetup"));
			Email.click();
			WebElement MyEmailSettings = driver.findElement(By.id("EmailSettings_font"));
			MyEmailSettings.click();

			WebElement Email_Name = driver.findElement(By.id("sender_name"));
			Email_Name.clear();
			Email_Name.sendKeys("Sni");
			WebElement Email_Address = driver.findElement(By.id("sender_name"));
			Email_Address.clear();
			Email_Address.sendKeys("mailsni@gmail.com");
			WebElement Bcc_radioButton = driver.findElement(By.id("auto_bcc1"));
			Bcc_radioButton.click();
			WebElement Save_button = driver.findElement(By.name("save"));
			Save_button.click();		
			
			
			//Calendersand Reminders
			WebElement Calender_and_Reminders = driver.findElement(By.id("CalendarAndReminders"));
			Calender_and_Reminders.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			WebElement ActivityReminders = driver.findElement(By.xpath("//*[@id=\"Reminders_font\"]"));
			ActivityReminders.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
			Test_Reminder = driver.findElement(By.className("btn"));
			Test_Reminder.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String parentWindow = driver.getWindowHandle();
			for(String handle : driver.getWindowHandles()) { 
				if(handle != parentWindow) {
					driver.switchTo().window(handle);
				String	expectedUrl1 = driver.getCurrentUrl();
				String	actualUrl1 = "https://ap8.salesforce.com/ui/core/activity/ReminderSettingsPage?setupid=Reminders&retURL=%2Fui%2Fsetup%2FSetup%3Fsetupid%3DCalendarAndReminders";
					
				if(actualUrl1.equalsIgnoreCase(expectedUrl1)) {
						System.out.println("MySettings page is not Lunched");
				}
					else {
						System.out.println("User is on MySettings page");
					}	
				}
			}
			driver.close();
			System.out.println("Tc_7_SelectMySettings is completed");
}
				
			
	}


