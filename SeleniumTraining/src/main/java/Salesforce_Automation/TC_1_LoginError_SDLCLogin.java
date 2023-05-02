package Salesforce_Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_1_LoginError_SDLCLogin extends SalesforceLogin {
	public void SDLCLogin() throws AWTException {

SalesforceLogin loginSF = new TC_1_LoginError_SDLCLogin();
		loginSF.login();

		if (driver.getTitle().contains("Salesforce - Home Page")) {
			System.out.println("Login successful. Test Passed");
		} else {
			System.out.println("Please check your username and password. If you still can't log in, contact your Salesforce administrator.");
		}
	}

}
