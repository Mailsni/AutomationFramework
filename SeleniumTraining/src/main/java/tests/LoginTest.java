package tests;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import constants.FileConstants;
import file.utils.CommonUtils;
import file.utils.PropertiesFileUtils;
import listeners.SfdcListeners;
import pages.LoginPage;
import pages.UserMenuPage;

@Listeners(SfdcListeners.class)
public class LoginTest extends BaseTest {

	
	@Test()
	public void loginTest() throws IOException, InterruptedException {
		WebDriver driver =  BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
//		extent.createtest()
		Assert.assertTrue(lp.launchApp(driver, "https://login.salesforce.com/"), "Actual URL should match the expected URL");
		test.log(Status.INFO, "App is launched");
		lp.enterUsername(driver, PropertiesFileUtils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		test.log(Status.INFO, "Username is entered");
//		Assert.assertEquals(lp.getUsername(driver), PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		lp.enterPassword(driver, PropertiesFileUtils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.password"));
		test.info("Password is entered");
		Assert.assertTrue(lp.selectRememberMeCheckbox(), "Remember me checkbox should be selected");
		test.info("Remember me checkbox selected");
		lp.clickLoginButton(driver);
		test.info("Login button clicked");
		Assert.assertTrue(lp.isHomePageDisplayed(), "Home page should be displayed");
		test.info("Home page is displayed");
		Assert.assertTrue(ump.logOut(driver), "Failed to logout");
		test.info("Logout is successfull");
		Assert.assertTrue(lp.isLoginPageDisplayed(driver), "Login page should be displayed");
		test.info("Login page is diaplayed");
		Assert.assertEquals(lp.getSavedUserName(driver), PropertiesFileUtils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		test.info("Saved username is seen");
	}
	

//	@Test(groups = {"regression"}, dependsOnGroups = {"smoke"}, successPercentage = 10 )
	public void loginTest1() {
		WebDriver driver =  BaseTest.getDriver();
		driver.get("https://google.com");
	}
	
//	@Test(dependsOnMethods = "loginTest1", alwaysRun = true)
	public void loginTest2() {
		WebDriver driver =  BaseTest.getDriver();
		driver.get("https://google.com");
		throw new NoSuchElementException();
	}
	
//	@Test(dataProvider = "userCreds")
	public void loginTest3(String user, String pass) {
//		WebDriver driver =  BaseTest.getDriver();
//		driver.get("https://google.com");
		System.out.println("username: "+user);
		System.out.println("Pass: "+pass);
	}
	
	@DataProvider( parallel = true)
	public Object[][] userCreds(){
//		Write a logic here to read all the username and passwords from excel
		
		return new Object[][] {{"mithun.r@tekarch.com","1234Sam"},{"Chandra@gmail.com","12345Chandra"},{"deekshith", "1234deekshith"}};
		
	}
	
	

}
