package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage{
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@type='text' and @name='firstname']")
	private WebElement first_nameInput;
	
	@FindBy(xpath="//input[@type='text' and @name='lastname']")
	private WebElement last_nameInput;
	
	@FindBy(xpath="//input[@type='email' and @name='email']")
	private WebElement emailInput;
	
	@FindBy(xpath="//input[@type='tel' and @name='telephone']")
	private WebElement phoneInput;
	
	
	@FindBy(xpath="//input[@type='password' and @name='password']")
	private WebElement passwordInput;
	
	@FindBy(xpath="//input[@type='password' and @name='confirm']")
	private WebElement confirmPasswordInput;
	
	@FindBy(xpath="//input[@type='radio' and @name='newsletter' and @value=0]")
	private WebElement acceptNewsLetter;
	
	@FindBy(xpath="//input[@type='radio' and @name='newsletter' and @value=1]")
	private WebElement declineNewsLetter;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='agree']")
	private WebElement termAgree;
	
	@FindBy(xpath="//input[@type='submit' and @value='Continue']")
	private WebElement signUpButton;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement successMessage;
	
    public void setFirstName(String firstName) {
        first_nameInput.clear();
        first_nameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        last_nameInput.clear();
        last_nameInput.sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void subscribeToNewsletter(boolean subscribe) {
        if (subscribe) {
            if (!acceptNewsLetter.isSelected()) {
                acceptNewsLetter.click();
            }
        } else {
            if (!declineNewsLetter.isSelected()) {
                declineNewsLetter.click();
            }
        }
    }

    public void acceptTerms() {
        if (!termAgree.isSelected()) {
            termAgree.click();
        }
    }

    public void clickSignUp() {
        signUpButton.click();
    }
    
    public String getSuccessMessage() {
    	return successMessage.getText();
    }
}
