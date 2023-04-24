package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class AddressPage extends TestBase{
@FindBy(linkText="Add Address")
WebElement addAddresslink;

@FindBy(xpath="//body[@class='a-aui_72554-c a-aui_accordion_a11y_role_354025-t1 a-aui_killswitch_csa_logger_372963-c a-aui_pci_risk_banner_210084-c a-aui_preload_261698-c a-aui_rel_noreferrer_noopener_309527-c a-aui_template_weblab_cache_333406-c a-aui_tnr_v2_180836-c a-meter-animate']/div[@id='a-page']/div[@class='a-section']/div[@class='a-section a-spacing-medium a-text-left address-narrow-container-desktop']/div[2]/h2")
WebElement addNewAddressmsg;

@FindBy(name="address-ui-widgets-countryCode")
WebElement selectCountry;

@FindBy(name="address-ui-widgets-enterAddressFullName")
WebElement fullName;

@FindBy(name="address-ui-widgets-enterAddressPhoneNumber")
WebElement phoneNumber;

@FindBy(name="address-ui-widgets-enterAddressLine1")
WebElement streetAddress;
@FindBy(name="address-ui-widgets-enterAddressLine2")
WebElement aptNo;
@FindBy(name="address-ui-widgets-enterAddressCity")
WebElement city;
@FindBy(name="address-ui-widgets-enterAddressPostalCode")
WebElement postalCode;

@FindBy(name="address-ui-widgets-enterAddressStateOrRegion")
WebElement province;
@FindBy(xpath="//span[@class='a-button-inner']//input[@type='submit']")
WebElement submitButton;
@FindBy(name="address-ui-widgets-suggested-address-selection")
WebElement confirmAddress;
@FindBy(name="address-ui-widgets-saveOriginalOrSuggestedAddress")
WebElement saveAddress;
@FindBy(xpath="//h4[@class='a-alert-heading']")
WebElement successOrErrMsg;
@FindBy(xpath="//a[@id='ya-myab-address-delete-btn-2']")
WebElement removeAddress;
@FindBy(xpath="//span[@id='deleteAddressModal-2-submit-btn']//span[@class='a-button-inner']//input[@type='submit']")
WebElement confirmRemove;

	public AddressPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}


	public String addressBookPageTitle() {
		return driver.getTitle();
	}

	public boolean addNewAddressMsg() {
		addAddresslink.click();
		return addNewAddressmsg.isDisplayed();
	}
	public String addAddress(String country, String fullname, String phoneno, String streetadd,String unit,
			String town, String zipCode, String state) throws InterruptedException {
		addAddresslink.click();
		Select s=new Select(selectCountry);
		s.selectByVisibleText(country);
		fullName.sendKeys(fullname);
		phoneNumber.sendKeys(phoneno);
		streetAddress.sendKeys(streetadd);
		aptNo.sendKeys(unit);
		city.sendKeys(town);
		postalCode.sendKeys(zipCode);
		Select s1=new Select(province);
		s1.selectByValue(state);
		submitButton.click();
		confirmAddress.click();
		saveAddress.click();
		return successOrErrMsg.getText();
	}

	public String deleteAddress() {
		removeAddress.click();
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", confirmRemove);
		//confirmRemove.click();
		//Actions action = new Actions(driver);
	   // action.moveToElement(confirmRemove).moveToElement(driver.findElement(By.xpath("//span[@id='deleteAddressModal-2-submit-btn']//span[@class='a-button-inner']//input[@type='submit']"))).click().build().perform();
	   driver.findElement(By.xpath("//form[@method='post']//span[@id='deleteAddressModal-2-submit-btn']//span[@class='a-button-inner']//input[@type='submit']")).click();
		return successOrErrMsg.getText();

	}


}
