//Author Harpree Kaur 
//This file contains automation tests for different address functions of Amazon Web App


package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AddressPage;
import pages.HomePagePage;
import pages.LoginLogOutPage;
import utilties.TestUtil;

public class AddressTesting  extends TestBase{
	LoginLogOutPage lp;
	HomePagePage hp;
	AddressPage ap;

	public AddressTesting() throws IOException {
		super();

	}

	@BeforeMethod
	public void setUp() throws IOException {
		browserSetUp();
		lp =new LoginLogOutPage();
		hp=lp.login(prop.getProperty("UserName"), prop.getProperty("Password"));
		ap=hp.manageAddress();
	}
	@Test(priority=1)
	public void addressBookPageTitleTest() {
		Assert.assertEquals(ap.addressBookPageTitle(),TestUtil.read1.getCellData("AddressData", "Address page title\n"
				+ "", 2));
	}

	@Test(priority=2)
	public void addNewAddressPageTest() {
		Assert.assertTrue(ap.addNewAddressMsg());
	}
	@Test(priority=3)
	public void addNewAddressTest() throws InterruptedException {

		String savedmsg=	ap.addAddress(TestUtil.read2.getCellData("AddAddressTestData","country\n"
				+ "" , 2), TestUtil.read2.getCellData("AddAddressTestData","fullname\n"
						+ "" , 2),TestUtil.read2.getCellData("AddAddressTestData","phoneno.\n"
								+ "" , 2) , TestUtil.read2.getCellData("AddAddressTestData","streetaddress\n"
										+ "" , 2), TestUtil.read2.getCellData("AddAddressTestData","unitno.\n"
												+ "" , 2),  TestUtil.read2.getCellData("AddAddressTestData","city\n"
														+ "" , 2),  TestUtil.read2.getCellData("AddAddressTestData","postalcode\n"
																+ "" , 2), "Ontario") ;


		Assert.assertEquals(savedmsg,TestUtil.read1.getCellData("AddressData", "Success Address saved msg", 2));
		Thread.sleep(2000);
	}
	@Test(priority=4)
	public void addSameAddressTest() throws InterruptedException {
		driver.navigate().refresh();
		String errmsg=	ap.addAddress(TestUtil.read2.getCellData("AddAddressTestData","country\n"
				+ "" , 2), TestUtil.read2.getCellData("AddAddressTestData","fullname\n"
						+ "" , 2),TestUtil.read2.getCellData("AddAddressTestData","phoneno.\n"
								+ "" , 2) , TestUtil.read2.getCellData("AddAddressTestData","streetaddress\n"
										+ "" , 2), TestUtil.read2.getCellData("AddAddressTestData","unitno.\n"
												+ "" , 2),  TestUtil.read2.getCellData("AddAddressTestData","city\n"
														+ "" , 2),  TestUtil.read2.getCellData("AddAddressTestData","postalcode\n"
																+ "" , 2),"Ontario") ;



		Assert.assertEquals(errmsg,"You've submitted an address that is already in your address book");
	}
	@Test(priority=5)
	public void deleteAddressTest() throws InterruptedException {
		Assert.assertEquals(ap.deleteAddress(),TestUtil.read1.getCellData("AddressData", "Success Address del msg\n"
				+ "", 2));
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}








}

