package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.FileConstants;
import file.utils.PropertiesFileutils;
import pages.AccountPage;
import pages.LoginPage;

/**
 * @author mailsni
 * This class contains all the Test cases on AccountPage
 *
 */


public class AccountTest extends BaseTest{
	
	WebDriver driver;
	@BeforeMethod
		public void loginTest() throws IOException {
		WebDriver driver =  BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver);
			Assert.assertTrue(lp.launchApp(driver, "https://login.salesforce.com"), "Actual URL should match the expected URL");
			lp.enterUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
			lp.enterPassword(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.password"));
			lp.clickLoginButton(driver);
			Assert.assertTrue(lp.isHomePageDisplayed(), "Home page should be displayed");
	}
	
	
	@Test
	public void accountTest() throws IOException {
		WebDriver dr =  BaseTest.getDriver();
		AccountPage ap = new AccountPage(this.getDriver());
		Assert.assertTrue(ap.launchAccountPage(getDriver(), "AccountPage "));
}
}