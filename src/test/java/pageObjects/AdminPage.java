package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage{
	public AdminPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[@type='button' and text()=' Add ']")
	private WebElement addButtonElement;
	
	@FindBy(xpath="//div[@class='oxd-select-text--after'][1]")
	private WebElement userRoleSelect;
	
	@FindBy(xpath="//div[@class='oxd-select-text--after'][2]")
	private WebElement statusSelect;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	private WebElement employeeNameInput;
	
	@FindBy(xpath="//label[text()='Username']/parent::div/following-sibling::div/input")
	private WebElement usernameInput;
	
	@FindBy(xpath="//input[@type='password'][1]")
	private WebElement passwordInput;
	
	@FindBy(xpath="//input[@type='password'][2]")
	private WebElement confirmPasswordInput;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement saveButtonElement;
	
	public void clickAddButton() {
		addButtonElement.click();
	}
	
	public void selectRole(String role) {
		userRoleSelect.click();
		String rolexpath="//div[@class='oxd-select-text-input' and @tabindex=0 and text()='"+role+"']";
		WebElement roleType = driver.findElement(By.xpath(rolexpath));
		roleType.click();
	}
	
	public void selectStatus(String status) {
		statusSelect.click();
		String statusxpath="//div[@class='oxd-select-text-input' and @tabindex=0 and text()='"+status+"']";
		WebElement statusType = driver.findElement(By.xpath(statusxpath));
		statusType.click();
	}
	
	public void setEmployee(String employeeName) {
		employeeNameInput.sendKeys(employeeName);
	}
	public void setUsername(String username) {
		usernameInput.sendKeys(username);
	}
	public void setPassword(String password) {
		passwordInput.sendKeys(password);
	}
	public void setConfirmPassword(String confirmPassword) {
		confirmPasswordInput.sendKeys(confirmPassword);
	}
	public void clickSave() {
		saveButtonElement.click();
	}
}
