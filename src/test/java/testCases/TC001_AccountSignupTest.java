package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginSignupPage;
import pageObjects.AccountSignupPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountSignupTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void verify_account_signup() throws InterruptedException {
		try {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		HomePage hp= new HomePage(driver);
		logger.info("Home Page is launched");
		hp.clickSignLogin();
		
		AccountLoginSignupPage sglogpg= new AccountLoginSignupPage(driver);
		logger.info("Login/Signup Page is launched");
		String name=getRandomAlphabetic(10);
		String email= getRandomAlphanumric(10)+"@gm.com";
		logger.info("email "+email);
		sglogpg.setName(name);
		sglogpg.setEmail(email);
		sglogpg.clickSignup();
		
		AccountSignupPage signpg = new AccountSignupPage(driver);
		logger.info("SignUp Page is launched");
		signpg.setTitleMale();
		signpg.setPassword("password");
		signpg.setDay(getRandomNumberInRange(1,29));
		signpg.setMonth(getRandomNumberInRange(1,13));
		signpg.setYear(getRandomNumberInRange(1950,2020));
		scrollToElement(signpg.chkNewsLetter);
		signpg.chkNewsLetter();		
		signpg.setFname(getRandomAlphabetic(6));
		signpg.setLname(getRandomAlphabetic(5));
		signpg.setCompany(getRandomAlphabetic(5)+".LCC");
		//logger.info("All good");
		signpg.setAddress1(getRandomNumber(4));
		signpg.setAddress2(getRandomAlphabetic(10));
		signpg.setCountry(2);
		signpg.setState("Arizona");
		signpg.setCity("phoenix");
		signpg.setZip("84323");
		signpg.setMobile(getRandomNumber(10));
		//scrollToBottom();
		
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		//scrollToElement(signpg.btnCreateAccount);
		signpg.clickCreateAccount();	
		System.out.println(signpg.getMsgAccountCreated());
		Assert.assertEquals("ACCOUNT CREATED!", signpg.getMsgAccountCreated());
		logger.info("Account Created is confirmed");
		Assert.assertEquals("Congratulations! Your new account has been successfully created!", signpg.getMsgCongrats());
		Thread.sleep(2000);
		
		}catch(Exception e) {
			logger.error("Error Occured");
			logger.debug("Debug log...");
			logger.info(e.getMessage());
			Assert.fail();		
		}
   }
}
