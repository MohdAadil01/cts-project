package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.ProductsPage;
import testBase.BaseClass;

public class TC003_DisplayProducts extends BaseClass {
	@Test(priority=3, dependsOnMethods= {"testCases.TC001_LoginTest.verify_login"})
	public void displayProducts() {
		
		logger.info("*******go to men section*********");
		DashboardPage dbPage = new DashboardPage(driver);
		dbPage.goToMenSection();
		
		ProductsPage productsPage = new ProductsPage(driver);
		logger.info("*******get verification text*********");
		
		String result = productsPage.getVerificationText();
		logger.info("*******verifying the result*********");
		
		Assert.assertEquals("Polo Tshirt For Men", result);
		logger.info("*******completed display products*********");
	}
}
