package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import file.utils.CommonUtils;

/**
 * @author mailsni
 * 
 *
 */
public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
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

	@FindBy(id = "Account_Tab")
	public WebElement account;//acct tab
	
	@FindBy(xpath = "//*[@]//*[@class=\"btn\"]/table/tbody/tr/td[2]/input")//new button
	public WebElement newButton;
	
	@FindBy(id="ep")//editpage
	public WebElement acctEditPage;
	
	
	public boolean selectAccountTab(WebDriver driver, String sAcc) {
	boolean isAccountClicked = false;
	WebElement accountTab = driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
	if (accountTab.isDisplayed()) {
			accountTab.click();
			isAccountClicked = true;
	}else
	{
		System.out.println("Account Tab is not visible");}
	 return isAccountClicked;
}

	public boolean launchAccountPage(WebDriver driver, String sAcctURL) throws IOException {
		boolean isAcctPageLaunched = false;
		driver.get(sAcctURL);
		String actualURL = driver.getCurrentUrl();

		if (actualURL.equals(sAcctURL)) {
			isAcctPageLaunched = true;
		} else {
			CommonUtils.captureScreenShot(driver);
		}

		return isAcctPageLaunched;
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

	public boolean isAccountPageDisplayed(WebDriver driver) {
		return CommonUtils.waitForElement(driver, account);
	}
	
	/*
	 * public boolean clickNewButton(WebDriver driver){ boolean isNewButtonClicked =
	 * false; WebElement newButton = driver.findElement(By.xpath("")); }
	 */
}