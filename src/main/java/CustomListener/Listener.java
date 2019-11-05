package CustomListener;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Setup.TestSetup;
import Util.ConfigProperties;
import Util.ExtentReportListener;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	//// Whenever runner class is executed this method will be called
	public void onTestStart(ITestResult arg0) {

		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
