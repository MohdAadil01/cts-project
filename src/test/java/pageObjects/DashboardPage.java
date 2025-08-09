package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	

	
	@FindBy(xpath="//div[@class='customer_info']/p[3]")
	private WebElement emailText;
	
	@FindBy(xpath="//ul[@role='list']/li/a[text()='MEN']")
	private WebElement goToMenSection;
	
	@FindBy(xpath="//ul[@role='list']/li/a[text()='Polo T-Shirts'][1]")
	private WebElement goToPoloTshirts;
	
	public String getEmailText() {
		return emailText.getText()
;	}
	public void goToMenSection() {
		System.out.println(emailText.getText());
		System.out.println("hi");
		Actions action = new Actions(driver);
		action.moveToElement(goToMenSection).build().perform();
		System.out.println("hi");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(goToPoloTshirts));
		goToPoloTshirts.click();
	}
}
