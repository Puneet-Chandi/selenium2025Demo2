package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.AccountLoginSignupPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass {
	@Test(groups= {"Regression","Master"})
	public void verifyLogin() {
		try {
		HomePage hp = new HomePage(driver);
		hp.clickSignLogin();
		
		AccountLoginSignupPage lsp = new AccountLoginSignupPage(driver);
		lsp.setLoginEmail("L6wpYkwItw@gm.com");
		lsp.setLoginPassword("password");
		lsp.clickLogin();
			
		AccountLoginPage lp = new AccountLoginPage(driver);
		boolean loggedIn = lp.isUserLogged();
		if(!loggedIn)
			{
			if(lsp.isInvalidCredentials())
			logger.info(lsp.getMsgInvalidCredentials());			
			}
		Assert.assertEquals(loggedIn, true,"User logged in");
		Assert.assertEquals(lp.getLoggedUserInfo(),"Logged in as EWGKhjeZEC", "User Info Not Matched");
		logger.info("User " +lp.getLoggedUserInfo());	
		lp.clickLogout();
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail();
		}
	}
}
