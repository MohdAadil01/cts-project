package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;
import testBase.BaseClass;

public class TC004_AddToCart extends BaseClass {
	@Test(priority=4)
	public void testAddToCart() {
		logger.info("*****starting add to cart test case**********");
		logger.info("*****go to products page**********");
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.goToSpecificProduct();
		
		logger.info("*****go to specific product page**********");
		ProductPage product = new ProductPage(driver);
		product.addToCart();
		
		logger.info("*****go to bag section**********");
		product.goToBagSection();
		
		logger.info("*****get product**********");
		CartPage cartPage = new CartPage(driver);
		String result = cartPage.getProduct();
		logger.info("*****verfying the product**********");
		Assert.assertEquals("Men Yellow Stripe Polo Collar Half Sleeve T-Shirt", result);
		logger.info("*****end teh add to cart test case**********");
	}
}
