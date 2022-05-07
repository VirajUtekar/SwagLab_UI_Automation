package Resources;

import java.io.FileNotFoundException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports extent;
	
	public static ExtentReports getReportObject() throws FileNotFoundException {
		
		String file = System.getProperty("user.dir")+"/reports/index.html";
	
		ExtentSparkReporter reporter = new ExtentSparkReporter(file);
	
		reporter.config().setDocumentTitle("Web-Automation Result");
		
		reporter.config().setReportName("Test Result");
		
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Software Test Engineer","Viraj D. Utekar");
		
		return extent;
	}	
}
