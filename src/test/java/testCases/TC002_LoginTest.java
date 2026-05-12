package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"sanity","Master"})
	public void verify_login() 
	{
		logger.info("***** Starting TC_002_LoginTest *****");
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		

		Assert.assertTrue(targetPage); //Assert.assertEquals(targetPage, true,"Login Failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***** Finised TC_002_LoginTest *****");
		
	}
	
}
