package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class AccountSignupPage extends BasePage{
	
	//constructor
	public AccountSignupPage(WebDriver driver) {
		super(driver);
	}
	//locator
	@FindBy(xpath="//input[@id='id_gender1']")
	WebElement chkTitleMr;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	WebElement chkTitleMrs;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement txtName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement selectDay;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement selectMonth;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement selectYear;
	
	@FindBy(xpath="//input[@id='newsletter']")
	public WebElement chkNewsLetter;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement txtFname;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement txtLname;
	
	@FindBy(xpath="//input[@id='company']")
	WebElement txtCompany;
	
	@FindBy(xpath="//input[@id='address1']")
	WebElement txtAddress1;
	
	@FindBy(xpath="//input[@id='address2']")
	WebElement txtAddress2;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement selectCountry;
	
	@FindBy(xpath="//input[@id='state']")
	WebElement txtState;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement txtCity;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement txtZipCode;
	
	@FindBy(xpath="//input[@id='mobile_number']")
	WebElement txtMobile;
	
	@FindBy(xpath="//button[text()='Create Account']")
	public WebElement btnCreateAccount;
	
	@FindBy(xpath="//b[text()='Account Created!']")
	WebElement msgAccountCreated;
	
	@FindBy(xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
	WebElement msgCongrats;
		
	
	//action method
	public void setTitleMale() {
		chkTitleMr.click();
	}
	public void setTitleFemale() {
		chkTitleMrs.click();
	}
	public void getName() {
		txtName.getAttribute("value");
	}
	public void getEmail() {
		txtEmail.getAttribute("value");
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void setDay(String day) {
	BaseClass.SelectByValue(selectDay, day);
	}
	public void setMonth(String month) {
	BaseClass.SelectByValue(selectMonth, month);
	}
	public void setYear(String year) {
	BaseClass.SelectByValue(selectYear, year);
	}
	public void chkNewsLetter() {
		chkNewsLetter.click();
	}	
	public void setFname(String fname) {
		txtFname.sendKeys(fname);
	}	
	public void setLname(String lname) {
		txtLname.sendKeys(lname);
	}
	public void setCompany(String company) {
		txtCompany.sendKeys(company);
	}
	public void setAddress1(String address1) {
		txtAddress1.sendKeys(address1);
	}
	public void setAddress2(String address2) {
		txtAddress2.sendKeys(address2);
	}
	public void setCountry(int index) {
	BaseClass.SelectByIndex(selectCountry,index);;
	}
	public void setState(String state) {
		txtState.sendKeys(state);
	}
	public void setCity(String city) {
		txtCity.sendKeys(city);
	}
	public void setZip(String zip) {
		txtZipCode.sendKeys(zip);
	}
	public void setMobile(String mobile) {
		txtMobile.sendKeys(mobile);
	}
	public void clickCreateAccount() {
		btnCreateAccount.click();
	}
	public String getMsgAccountCreated() {
		return msgAccountCreated.getText();
	}
	public String getMsgCongrats() {
		return msgCongrats.getText();
	}

}
