package CommonUtils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig.ExtentSparkReporterConfigBuilder;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerimplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		//Reporter.log(methodname+"testscrpit execution started",true);
		test=report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		//Reporter.log(methodname+"testscrpit is passed",true);
		test.log(Status.PASS, methodname+"TestScript is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		Throwable message = result.getThrowable();
		//Reporter.log(methodname+"testscrpit is failed"+message,true);
		test.log(Status.FAIL, methodname+"TestScript is failed");
		WebDriverUtils wutils = new WebDriverUtils();
		JavaUtils jutils = new JavaUtils();
		String Screenshotname = methodname+jutils.getRandomnumber();
		try {
			String path = wutils.screenshot(BaseClass.sdriver, Screenshotname);
			//To add screenshot to my extent reports
			test.addScreenCaptureFromPath(path);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+"TestScrpit is skipped");
		//Reporter.log(methodname+"testscrpit is skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		JavaUtils jutils = new JavaUtils();
		//Configuration of extent report 
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReports/report"+jutils.getRandomnumber()+".html");
		htmlreport.config().setDocumentTitle("framework batch vtiger");
		htmlreport.config().setReportName("Vtigercrm");
		htmlreport.config().setTheme(Theme.DARK);
		
		//To add information to the report
		 report = new ExtentReports();
		//To attach all data to the report
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("author", "supriya");
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//all data which is written in onstart method will be configured to report
		report.flush();
	}

	
}
