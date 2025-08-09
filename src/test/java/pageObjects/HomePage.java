package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	



	@FindBy(xpath="//li[@class='dropdown'][1]")
	private WebElement dropdownButton;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[2]")
	private WebElement loginButton;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[1]")
	private WebElement registerButton;
	
	public void openDropdown() {
		dropdownButton.click();
	}
	public void clickLogin() {
		loginButton.click();
	}
	public void clickRegister() {
		registerButton.click();
	}
	
}
