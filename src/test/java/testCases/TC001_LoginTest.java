package testCases;


import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC001_LoginTest extends BaseClass{

	
	@Test(priority=1, dataProvider="loginData", dataProviderClass=DataProviders.class, groups={"login"})
	public void verify_login(String email, String password, String result) {
		logger.info("*********STARTING LOGIN TEST*********");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.openDropdown();
			homePage.clickLogin();
			logger.info("************Opening Login page************");
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(email);
			loginPage.setPassword(password);
			loginPage.clickLogin();
			
			if(result.equalsIgnoreCase("valid")) {
				Assert.assertTrue(loginPage.isLoggedIn());
				loginPage.openDrowpdown();
				loginPage.clickLogout();
			}else if(result.equalsIgnoreCase("invalid")) {
				Assert.fail();
				logger.info("************invalid login test************");
			}
			logger.info("************Submitted Login details************");
		}catch(Exception e) {
			e.printStackTrace();
			logger.error("Error in login test");
			logger.debug("Debug log...");
			Assert.fail();
		}
		logger.info("*********FINISHED LOGIN TEST*********");
		
	}
	
}
