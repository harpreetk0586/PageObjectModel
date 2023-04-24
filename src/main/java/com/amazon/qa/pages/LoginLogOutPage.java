package com.amazon.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginLogOutPage extends TestBase{

	public LoginLogOutPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
public static	String usermsg;
	//Page Factory -ObjectRepo
	@FindBy(name="email")
	WebElement email;
	@FindBy(id="continue")
	WebElement continueButton;

	@FindBy(name="password")
	WebElement password;


	@FindBy(id="signInSubmit")
	WebElement signinButton;

	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement username;

	@FindBy(xpath="//i[@aria-label='Amazon']")
	WebElement logo;

	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement sigininLink;

	@FindBy(linkText="Sign Out")
	WebElement signOutLink;

	public String validateLoginPageTitle() {
		sigininLink.click();
		return driver.getTitle();
	}
	public Boolean validateAmazonLogo() {
		 sigininLink.click();
		return logo.isDisplayed();
	}
	public HomePagePage login(String useremail, String pwd) throws IOException {
		sigininLink.click();
		email.sendKeys(useremail);
		continueButton.click();
		password.sendKeys(pwd);
		signinButton.click();
		usermsg= username.getText();
		return new HomePagePage();
		//return new HomePagePage();

	}

	public String logOut() throws IOException {
		Actions action = new Actions(driver);
	    action.moveToElement(username).build().perform();
	    signOutLink.click();
		return driver.getTitle();
		//return new HomePagePage();

	}






}
