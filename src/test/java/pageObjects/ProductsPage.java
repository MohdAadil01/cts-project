package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Men Yellow Stripe Polo Collar Half Sleeve T-Shirt']")
	private WebElement selectFirstProduct;
	
	@FindBy(xpath="//a[text()='Polo Tshirt For Men']")
	private WebElement verificationText;
	
	public void goToSpecificProduct() {
		selectFirstProduct.click();
	}
	
	public String getVerificationText() {
		return verificationText.getText();
	}
}
