package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ProductPage extends BasePage {
	public ProductPage(WebDriver driver){
		super(driver);
	}
	@FindBy(id="AddToCart")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//a[text()='Go to Bag']")
	private WebElement goToBag;
	
	public void addToCart() {
		Wait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.visibilityOf(addToCartButton));
		addToCartButton.click();
	}
	
	public void goToBagSection() {
		Wait<WebDriver> fluentwait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
		fluentwait.until(ExpectedConditions.visibilityOf(goToBag));
		goToBag.click();
	}
}
