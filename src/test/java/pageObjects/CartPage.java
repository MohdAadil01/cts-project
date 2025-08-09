package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CartPage extends BasePage {
	public CartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@class='product-item-meta__title hidden-phone'][normalize-space()='Men Yellow Stripe Polo Collar Half Sleeve T-Shirt']")
	private WebElement product;
	
	
	public String getProduct() {
		Wait<WebDriver> fluentwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10)).ignoring(Exception.class);
		fluentwait.until(ExpectedConditions.visibilityOf(product));
		return product.getText();
	}
}
