package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC002_RegisterTest extends BaseClass {
	@Test(priority=2)
	public void register() {
		logger.info("**************running register test*************");
		try {
			HomePage homePage = new HomePage(driver);
			homePage.openDropdown();
			homePage.clickRegister();
			RegisterPage registerPage = new RegisterPage(driver);
			registerPage.setFirstName("John");
			registerPage.setLastName("Doe");
			registerPage.setEmail("john.doe.123.pqr@gmail.com");
			registerPage.setPhone("1234567890");
			registerPage.setPassword("SecurePass123");
			registerPage.setConfirmPassword("SecurePass123");
			registerPage.subscribeToNewsletter(true);
			registerPage.acceptTerms();
			registerPage.clickSignUp();

			String result = registerPage.getSuccessMessage();
			Assert.assertEquals(result, "Your Account Has Been Created!");
			logger.info("passed register test");
		}catch(Exception e) {
			e.printStackTrace();
			logger.info("failed register test");
			Assert.fail();
		}
		logger.info("finished register test");
		
		
	}
}
