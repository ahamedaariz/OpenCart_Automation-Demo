package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass  {
	
	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void test_login()
	{
		try {
		logging.info("*** Starting TC_002_LoginTest ***");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logging.info("Clicked on My Account");
		
		hp.clickLogin();
		logging.info("Clicked on login");
		
		LoginPage lp = new LoginPage(driver);
		logging.info("Provide username and password for login");
		lp.setEmailLogin(rb.getString("email"));
		lp.setEmailPassword(rb.getString("password"));
		
		lp.clickLoginButton();
		logging.info("Clicked on Login button");
		
		
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean targetpage= myacc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true, "Invalid Login data");
		}
		catch (Exception e) {
			Assert.fail();
		}
		logging.info("*** finished TC_002_LoginTest ***");
	}

}
