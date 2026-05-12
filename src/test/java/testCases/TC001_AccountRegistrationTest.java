package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		try
		{
			
		logger.info("**** Stating TC001_AccountRegistrationTest ****");
		
		HomePage hp=new HomePage(driver); 
		hp.clickMyAccount();
		logger.info(" Clicked on MyAccount Link ");
		
		hp.clickRegister();
		logger.info(" Clicked on Register Link ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info(" Providing customer detials ");
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com"); //randomly generated the mail
		regpage.setTelephone(randomNumber());
		
		//String password=randamAlphaNumberic();
		
		String password=randomAlphaNumberic();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickcontinue();
		
		logger.info(" Validating expected message ");
		
		String confmsg=regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		}
	catch(Exception e) 
		{
		Assert.fail();
	     }
		logger.info("****Finished TC001_AccountRegistrationTest****");
		}
	
}
	



