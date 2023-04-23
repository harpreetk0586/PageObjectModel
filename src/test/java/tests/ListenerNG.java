package tests;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.TestBase;
import utilties.TestUtil;

public class ListenerNG extends TestBase implements ITestListener {
static String filePath="/Users/hsrag/Desktop/QAThingsToDo/POM_Amazon/screensshots";

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
