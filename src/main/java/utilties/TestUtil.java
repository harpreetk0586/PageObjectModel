package utilties;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.TestBase;

public class TestUtil extends TestBase {
public TestUtil() throws IOException {
		super();

	}
public static String destination ;
public static File finalDestination;
public static long Page_load_Timeout=30;
public static long Implicit_Wait=15;
public static Xls_Reader read1 =new Xls_Reader("/Users/hsrag/Desktop/QAThingsToDo/POM_Amazon/src/main/java/testdata/pageTitleAndMsgs.xlsx");
public static Xls_Reader read2=new Xls_Reader("/Users/hsrag/Desktop/QAThingsToDo/POM_Amazon/src/main/java/testdata/TestInputData.xlsx");
static String filePath="/Users/hsrag/Desktop/QAThingsToDo/POM_Amazon/screensshots";


public static  void getScreenshot(WebDriver driver, String screenshotName) throws IOException{
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	
	destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
			+ ".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	
}
}
