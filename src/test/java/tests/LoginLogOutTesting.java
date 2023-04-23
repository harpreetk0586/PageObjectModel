package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginLogOutPage;
import utilties.TestUtil;

public class LoginLogOutTesting extends TestBase{
	LoginLogOutPage lp;
	public LoginLogOutTesting() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException {
		browserSetUp();
		lp =new LoginLogOutPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {

		Assert.assertEquals(lp.validateLoginPageTitle(),TestUtil.read1.getCellData("LoginData", "Signin page title\n"
				+ "", 2) );
	}

	@Test(priority=2)
	public void logoDisplayedTest() {
		Assert.assertTrue(lp.validateAmazonLogo());
	}

	@Test(priority=3)
	public void sucessfulLoginTest() throws IOException {
		lp.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		Assert.assertEquals( LoginLogOutPage.usermsg,TestUtil.read1.getCellData("LoginData", "usermsg after login\n"
				+ "", 2));
	}

	@Test(priority=4)
	public void LogOutTest() throws IOException {
		lp.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		Assert.assertEquals( lp.logOut(),TestUtil.read1.getCellData("LoginData", "Signin page title\n"
				+ "", 2));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}







}
