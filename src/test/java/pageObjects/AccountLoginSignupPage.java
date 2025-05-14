package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginSignupPage extends BasePage {
	//constructor
	public AccountLoginSignupPage(WebDriver driver) {
		super(driver);		
	}
	//locator
	
	//----signup elements ---
		
	@FindBy(xpath="//input[@name='name']")
	WebElement txtFirstName;
		
	@FindBy(xpath="//form[@action='/signup']/input[@name='email']")
	WebElement txtSignUpEmail;
	
	@FindBy(xpath="//button[text()='Signup']")
	WebElement btnSignup;
	
	//---login elements ---
	
	@FindBy(xpath="//form[@action='/login']/input[@name='email']")
	WebElement txtLoginEmail;
	
	@FindBy(xpath="//form[@action='/login']/input[@name='password']")
	WebElement txtLoginPassword;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//p[text()=\"Your email or password is incorrect!\"]")
	WebElement msgInvalidEmailPassword;
	
	
	//action methods
	
	public void setName(String fname) {
		txtFirstName.sendKeys(fname);
	}	
	
	public void setEmail(String email) {
		txtSignUpEmail.sendKeys(email);
	}
	
	public void clickSignup() {
		btnSignup.click();
	}
	
	public void setLoginEmail(String email) {
		txtLoginEmail.sendKeys(email);
	}	
	
	public void setLoginPassword(String password) {
		txtLoginPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	public boolean isInvalidCredentials() {
		return msgInvalidEmailPassword.isDisplayed();
	}
	
	public String getMsgInvalidCredentials() {
		return msgInvalidEmailPassword.getText();
	}
}
