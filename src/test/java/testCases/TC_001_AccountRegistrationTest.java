package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void test_account_Registration() {
		
		//logging.debug("Applicagtion logs....");
		logging.info("*** Stating TC_001_AccountRegistrationTest ***");
	try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logging.info("Clicked on My Account link");
		hp.clickRegister();
		logging.info("Clicked on Register link");
		
		AccountRegistrationPage accpage = new AccountRegistrationPage(driver);
		
		logging.info("Providing customer data");
		accpage.setFirstName(randomeString().toUpperCase());
		accpage.setLastName(randomeString().toUpperCase());
		
		accpage.setEmail(randomeString()+"@gmail.com");
		accpage.setTelephone(randomeNumber());
		
		String randPassword = randomeAlphaNumeric();
		accpage.setPassword(randPassword);
		accpage.setConfirmPassword(randPassword);
		
		accpage.clickradioSubscribe();
		accpage.clickPolicy();
		accpage.clickContinueButton();
		
		String confmsg= accpage.getConfirmationMsg();
		logging.info("Validating expected Message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		
	}catch (Exception e) {
		logging.error("Tc_001 TC is failed ");
			Assert.fail();
		}
	logging.info("*** Finished TC_001_AccountRegistrationTest ***");
	
	}
	


}
