package com.amazon.qa.tests;

import java.io.File;
import java.io.IOException;

import org.testng.IReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.extentReportListener.ExtentReporterListener;
import com.amazon.qa.utilties.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ListenerNG extends TestBase implements ITestListener, IReporter {

	public ListenerNG() throws IOException {
		super();

	}

@Override
public void onTestFailure(ITestResult result) {
	
	 try {
		 TestUtil.getScreenshot(driver, result.getName());
	} catch (IOException e) {
	
		e.printStackTrace();
	}

	 

}


}
