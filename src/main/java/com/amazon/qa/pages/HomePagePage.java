package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePagePage extends TestBase{

	public HomePagePage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement username;
	@FindBy(linkText="Beauty & Personal Care")
	WebElement beautylink;

	@FindBy(linkText="Health & Household")
	WebElement healthlink;

	@FindBy(linkText="Buy Again")
	WebElement buyagainlink;

	@FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[4]")
	WebElement product;

	@FindBy(xpath="//div[@id='nav-global-location-slot']")
	WebElement addressbox;

	@FindBy(linkText="Manage address book")
	WebElement addressbook;


	public String validateHomePageTitle() {
		return driver.getTitle(); //Amazon.ca: Low Prices – Fast Shipping – Millions of Items

	}


	public String verifyUserName() {

		return username.getText();

	}

   public void beatutyLink() {

	   beautylink.click();

	}

   public Boolean addressBox() {
	 return  addressbox.isDisplayed();
   }

   public AddressPage manageAddress() throws IOException {
		 addressbox.click();
		 addressbook.click();
		 return new AddressPage();
	   }
	//Amazon.ca: Beauty & Personal Care
   public String selectAddress(int listno) throws InterruptedException {
	   addressbox.click();
		//driver.findElement(By.xpath("//ul[@id='GLUXAddressList']//span[contains(text(),'"+name+"')]")).click();
		driver.findElement(By.xpath("//ul[@id='GLUXAddressList']/li["+listno+"]//input[@type='submit']")).click();
		Thread.sleep(2000);
	return	driver.findElement(By.xpath("//span[@id='glow-ingress-line1']")).getText();
	}

}
