package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.AccountLoginSignupPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_AccountLoginDDT1 extends BaseClass {
	@Test(dataProvider="dp", dataProviderClass=DataProviders.class, groups= "DataDriven")
	public void VerifyLoginDDT(String email, String pwd, String name, String status) {
		
	try {
		HomePage hp = new HomePage(driver);
		hp.clickSignLogin();
		
		AccountLoginSignupPage lsp = new AccountLoginSignupPage(driver);
		lsp.setLoginEmail(email);
		lsp.setLoginPassword(pwd);
		lsp.clickLogin();
		
		AccountLoginPage lp = new AccountLoginPage(driver);
		boolean islogged = lp.isUserLogged();
		
		if(islogged) {
			if(status.equalsIgnoreCase("valid")) {
				logger.info("TC PASSED - Valid user logged - "+lp.getLoggedUserInfo());
				lp.clickLogout();
				Assert.assertTrue(islogged);
			}
			else if(status.equalsIgnoreCase("invalid")) {
				logger.info("TC FAILED - Invalid user logged in - "+lp.getLoggedUserInfo());
				lp.clickLogout();
				Assert.fail();
			}
		}
		else if(!islogged) {
			if(status.equalsIgnoreCase("invalid")) {
				logger.info("TC PASSED - Invalid user failed to log in - "+lsp.getMsgInvalidCredentials());
				Assert.assertFalse(islogged);
			}
			else if(status.equalsIgnoreCase("valid")) {
				logger.info("TC FAILED - Valid user failed to log in");
				Assert.fail();
			}
			
		}
	}catch(Exception e) {
		Assert.fail(e.getMessage());
	}
		
		
		
		
	}

}
