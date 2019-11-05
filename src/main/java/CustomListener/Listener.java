package CustomListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Setup.TestSetup;
import Util.ExtentReportListener;

//Whenever runner class is executed this class will be called

public class Listener extends ExtentReportListener implements ITestListener {

	public void onFinish(ITestContext arg0) {
		extent.flush();

	}

	public void onStart(ITestContext arg0) {
		
		
		TestSetup.setup();
		extent = ExtentReportListener.setUp();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {


	}

	public void onTestFailure(ITestResult arg0) {
		

	}

	public void onTestSkipped(ITestResult arg0) {
	

	}

	// Whenever runner class is executed this method will be called
	public void onTestStart(ITestResult arg0) {

		
	}

	public void onTestSuccess(ITestResult arg0) {
	

	}

}
