// Author Harpreet Kaur 
//Compiled on 04/22/2023


package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.amazon.qa.utilties.TestUtil;
import com.amazon.qa.utilties.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;


public class TestBase {
public static WebDriver driver;
public static Properties prop;
public static WebDriverListener webEventListener;
public static WebDriver eventFireDec;
public static ExtentReports extent;
//constructor to initialize the properties file
public TestBase() throws IOException  {

	try {

	prop=new Properties();
	FileInputStream file=new FileInputStream("/Users/hsrag/Desktop/QAThingsToDo/POM_Amazon/src/main/java/config/config.properties");

	prop.load(file);

	}
	catch (FileNotFoundException e) {
		e.printStackTrace();

	} catch(IOException e) {
		e.printStackTrace();

	}

}
// initialize the driver

public static void browserSetUp() throws IOException {
	String browser=prop.getProperty("Browser");
	if(browser.equals("Chrome")) {
		driver= new ChromeDriver();
	} else if(browser.equals("Firefox")) {
		driver= new FirefoxDriver();

	}else if(browser.equals("Safari")) {
		driver= new SafariDriver();
	}else {
		driver=new InternetExplorerDriver();
	}


     webEventListener =new WebEventListener();
	 eventFireDec = new EventFiringDecorator(webEventListener).decorate(driver);

     //  WrapsDriver wrapperAccess = (WrapsDriver) eventFireDec;

	 //   driver =  (RemoteWebDriver) wrapperAccess.getWrappedDriver();


	driver=eventFireDec;
	//(RemoteWebDriver) wrapperAccess.getWrappedDriver();

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.Page_load_Timeout));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.Implicit_Wait));
			//Duration.ofSeconds(TestUtil.Implicit_Wait));
	driver.get(prop.getProperty("URL"));

}

 public void setExtent(){
	extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
	extent.addSystemInfo("Host Name", "Harpreet Mac");
	extent.addSystemInfo("User Name", "Automation Test");
	extent.addSystemInfo("Environment", "QA");
	
}
 
 public void endReport(){
		extent.flush();
		extent.close();
	}
}

