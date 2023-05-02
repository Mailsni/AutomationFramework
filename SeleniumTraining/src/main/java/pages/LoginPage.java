package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import file.utils.CommonUtils;



public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement login;

	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;

	@FindBy(css = "#error")
	public WebElement loginErrorMsg;

	@FindBy(id = "un")
	public WebElement forgotUsername;

	@FindBy(partialLinkText = "Forgot Your")
	public WebElement forgotPassword;
	
	@FindBy(id = "continue")
	public WebElement continueButton;

	@FindBy(id = "forgotPassForm")
	public WebElement passwordResetScreen;

	@FindBy(xpath = "//a[text()='Return to Login']")
	public WebElement returnToLoginButton;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;
	
	@FindBy(id = "userNavLabel")
	public WebElement homeUserMenu;

	public void enterUsername(WebDriver driver, String userName) {

		if (username.isDisplayed()) {
			username.sendKeys(userName);
		} else {
			System.out.println("User name element is not visible");
		}
	}
	
	public String getUsername(WebDriver driver) {
		return username.getText();
	}
	
	public String getSavedUserName(WebDriver driver) {
		return savedUsername.getText();
	}

	public void enterPassword(WebDriver driver, String pass) {
		if (password.isDisplayed()) {
			password.sendKeys(pass);
		} else {
			System.out.println("password element is not visible");
		}
	}
	
	public void clickLoginButton(WebDriver driver) {
		if (login.isDisplayed()) {
			login.click();
		} else {
			System.out.println("login button is not visible");
		}
	}
	
	/**
	 * @param driver
	 * @param sURL
	 * @return
	 * @throws IOException 
	 */
	public boolean launchApp(WebDriver driver, String sURL) throws IOException {
		boolean isAppLaunched = false;
		driver.get(sURL);
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equals(sURL)) {
			isAppLaunched = true;
		} else { CommonUtils.captureScreenShot(driver); }
			 
		return isAppLaunched;
	}
	
	
	public boolean selectRememberMeCheckbox() {
		boolean bIsCheckBoxSelected = false; 
		if(rememberMe.isSelected()) {
			bIsCheckBoxSelected = true;
		} else {
			rememberMe.click();
			bIsCheckBoxSelected = true;
		}
		return bIsCheckBoxSelected;
	}
	
	public boolean isHomePageDisplayed() {
		return homeUserMenu.isDisplayed();
	}
	public boolean isLoginPageDisplayed(WebDriver driver) {
		return CommonUtils.waitForElement(driver, login);
	}
}
