package extentReportListener;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import base.TestBase;
//
import utilties.TestUtil;

public class ExtentReporterListener extends TestBase implements IReporter {
	
public ExtentReporterListener() throws IOException {
		super();
		
	}
  TestUtil tu=new TestUtil();

  public ExtentTest test;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		extent = new ExtentReports(outputDirectory + File.separator
				+ "Extent.html", true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
			
				
					try {
						buildTestNodes(context.getPassedTests(), LogStatus.PASS);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					try {
						buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
						
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				     
					try {
						buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		}

		extent.flush();
		extent.close();
	}

	public void buildTestNodes(IResultMap tests, LogStatus status) throws IOException {
		

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);
				String message = "Test " + status.toString().toLowerCase() + "ed";

			if (result.getThrowable() != null & result.getStatus()==2 ) {
					
					message = result.getThrowable().getMessage();
					
				    String screenshot_Path2= System.getProperty("user.dir") + "/FailedTestsScreenshots/" + result.getName() + ".png";
				
					String image2=test.addScreenCapture(screenshot_Path2);
					test.log(LogStatus.FAIL, message);
			
					 test.log(LogStatus.FAIL,result.getName(),image2);
				} else {
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
				}
				
				
			    extent.endTest(test);
				
			}
		}
				
		
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}




}