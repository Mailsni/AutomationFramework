package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {


	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement login;

	public void enterUsername(WebDriver driver, String userName) {

		if (username.isDisplayed()) {
			username.sendKeys(userName);
		} else {
			System.out.println("User name element is not visible");
		}
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
}
