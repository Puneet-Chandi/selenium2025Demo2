package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	// constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	//locator
	@FindBy(xpath="//a[@href='/login']")
	WebElement linkSignLogin;
	
	
	//action methods
	public void clickSignLogin() {
		linkSignLogin.click();
	}
	
	

}
