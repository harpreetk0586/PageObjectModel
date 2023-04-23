package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import base.TestBase;
import extentReportListener.ExtentReporterNG;
import pages.HomePagePage;
import pages.LoginLogOutPage;
import utilties.TestUtil;
public class HomePageTesting extends TestBase {
	LoginLogOutPage lp;
	HomePagePage hp;
	
	public HomePageTesting() throws IOException {
		super();

	}
	

	@BeforeMethod
	public void setUp() throws IOException {
		browserSetUp();
		lp =new LoginLogOutPage();
		hp=lp.login(prop.getProperty("UserName"), prop.getProperty("Password"));
	}

	@Test
	public void verifyHomePageTitleTest() {
		;
		Assert.assertEquals( hp.validateHomePageTitle(),TestUtil.read1.getCellData("HomePageData", "homepage title", 2));
	}

	@Test
	public void verifyUserNameTest() {
		Assert.assertEquals( hp.verifyUserName(),TestUtil.read1.getCellData("HomePageData", "username msg", 2));
	}

	@Test
	public void addressBoxTest() {
		Assert.assertTrue(hp.addressBox());
	}
	@Test(priority=5)
	public void selectAddressHomePageTest() throws InterruptedException {
	
		Assert.assertEquals(hp.selectAddress(1), TestUtil.read2.getCellData("SelectAddressData","Message\n"
						+ "" , 2));
	}

	
	@AfterMethod
	public void tearDown() throws IOException {
		
		driver.quit();
	}

}
