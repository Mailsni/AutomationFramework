package Salesforce_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.security.PublicKey;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class SalesforceLogin {
	    protected WebDriver driver;

	    public void setupChromeDriver() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    }

	    public void maximizeWindow() {
	        driver.manage().window().maximize();
	    }

	    public void enterCredentials(String username, String password) {
	        driver.findElement(By.id("username")).sendKeys(username);
	        driver.findElement(By.id("password")).sendKeys(password);
	    }
	    
	    public void login() throws AWTException {
	        setupChromeDriver();
	        driver.get("https://login.salesforce.com/");
	        maximizeWindow();
	        Robot r = new Robot();
	   	
	        enterCredentials("mailsni@abc.com", "abc12345");
	        driver.findElement(By.xpath("//*[@id=\"rememberUn\"]")).click();
	        r.keyPress(KeyEvent.VK_ENTER);
		   	 r.keyRelease(KeyEvent.VK_ENTER);
	        
	         }
	    
	    public static void clickObj(WebElement obj,String objName){
			if(obj.isDisplayed())
			{
				obj.click();
				System.out.println("pass :" +objName + "button is clicked");
				//logger.log(LogStatus.PASS, objName+ "button is displayed ,please check the application");
			}
			else
			{
				System.out.println("Fail:" +objName+"button is not displayed ,please check the application");
			//logger.log(LogStatus.FAIL, objName+ "button is not displayed ,please check the application");
			}
		}
	    
	    public static void switchFrame( WebDriver driver,WebElement obj) {
	   	 
	        if(obj.isDisplayed()) {
	         driver.switchTo().frame(obj);
	         System.out.println("Pass: we can switch to the "+obj+ " frame");
//	         logger.log(LogStatus.PASS,  "Switch to frame" );
	         
	        }else {
	         System.out.println("fail: we can't switch to the "+obj+ " frame");
//	         logger.log(LogStatus.FAIL,  "Cannot Switch to frame" );
	        }
	    }
	    
	    public static void selectDropdown(WebElement obj, String objName) {
			
			if(obj.isDisplayed()) {
				System.out.println("Pass: "+objName+" is  selected");
				obj.click();
			}else
			{
			
				System.out.println("Fail:"+objName+" is not present.Please chk application");	
//			
		    }}
	    public static void validateErrormsg(String actualmsg, String errormsg) {
			
			if(actualmsg.equals(errormsg))
			{
				System.out.println("TestCase is passed");
//				logger.log(LogStatus.PASS,  "TestCase is passed" );
			}else
		    {
			System.out.println("TestCase is failed");
//			logger.log(LogStatus.FAIL,  "TestCase is failed" );
		    }
		}

	    
	}
	