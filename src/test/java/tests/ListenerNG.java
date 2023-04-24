package tests;

import java.io.File;
import java.io.IOException;

import org.testng.IReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import base.TestBase;
import extentReportListener.ExtentReporterListener;
import utilties.TestUtil;

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
