package tests;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.FileConstants;
import file.utils.PropertiesFileUtils;

import pages.LoginPage;
import pages.UserMenuPage;

public class UserMenuTest extends BaseTest {
	
	@Test
	public void userMenu_TC06() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		//verify Actual URL should match the expected URL
		Assert.assertTrue(lp.launchApp(driver, "https://login.salesforce.com/"), "Actual URL should match the expected URL");
		lp.enterUsername(driver, PropertiesFileUtils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));// error 
		lp.enterPassword(driver, PropertiesFileUtils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.password"));
		lp.clickLoginButton(driver);
		Assert.assertTrue(lp.isHomePageDisplayed(), "Home page should be displayed");
		ump.clickOnUserMenu();
		Assert.assertTrue(ump.verifyUserMenuItems()," Failed to verify user menu options");
		Assert.assertTrue(ump.selectMyprofile(driver),"Failed to select my profile");
		Assert.assertTrue(ump.isProfilePageVisible(), "Profile page should be visible");
		ump.clickEditProfile(driver);
		Assert.assertTrue(ump.verifyProfilePopUpWindow(driver),"Failed to verify profile pop up");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, PropertiesFileUtils.readUserMenuTestData("usermenu.profile.lastname")),"Failed to verify lastname");
		Assert.assertTrue(ump.verifyCreatePost(driver, PropertiesFileUtils.readUserMenuTestData("usermenu.post.message")), "Failed to verify create post");
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.USER_MENU_FILE_UPLOAD_PATH), "Failed to upload file upload");
		Assert.assertTrue(ump.uploadPhoto(driver, FileConstants.USER_MENU_PHOTO_UPLOAD_PATH ), "Failed to verify phot upload");
	}

}
