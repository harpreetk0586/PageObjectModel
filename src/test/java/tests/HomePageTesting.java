package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import base.TestBase;
import pages.HomePagePage;
import pages.LoginLogOutPage;
import utilties.TestUtil;
public class HomePageTesting extends TestBase {
	LoginLogOutPage lp;
	HomePagePage hp;
	public ExtentTest extentTest;
	
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
