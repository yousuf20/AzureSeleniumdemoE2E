package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter{
	
	static ExtentReports extent;
	
	public static ExtentReports getReport() {
		
		String path=System.getProperty("user.dir")+"\\reports\\DetailedhtmlLog.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Extent Report Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Yousuf Syed");
		return extent;
	}

	
	

	

}
