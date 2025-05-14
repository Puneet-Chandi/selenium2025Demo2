package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage {
	
	public AccountLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//ul[contains(@class,'navbar-nav')]//a[contains(text(),'Logged in as')]")
    WebElement msgLoggedUser;
	
	@FindBy(xpath="//ul[contains(@class,'navbar-nav')]//a[contains(text(),'Logout')]")
	WebElement linkLogout;
	
	public boolean isUserLogged() {
		try {
			return msgLoggedUser.isDisplayed();
		}catch(Exception e) {
			return false;
		}		
	}
	
	public String getLoggedUserInfo() {
		return msgLoggedUser.getText();
	}
	public void clickLogout() {
		linkLogout.click();
	}
	
}
