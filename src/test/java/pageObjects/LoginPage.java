package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.PropertiesUtility;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@type='text' and @name='email']")
	private WebElement emailInput;
	
	@FindBy(xpath="//input[@type='password' and @name='password']")
	private WebElement passwordInput;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement successMessage;
	
	@FindBy(xpath="//li[@class='dropdown'][1]/parent::ul[@class='list-inline']/li[2]")
	private WebElement dropdownButton;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li/a[text()='Logout']")
	private WebElement logoutButton;
	
	public void setEmail(String username) {
		emailInput.clear();
		emailInput.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public boolean isLoggedIn() {
		if(successMessage.getText().equalsIgnoreCase("My Account")){
			return true;
		}else {
			return false;
		}
	}
	
	public void openDrowpdown() {
		dropdownButton.click();
	}
	public void clickLogout() {
		logoutButton.click();
	}
}
