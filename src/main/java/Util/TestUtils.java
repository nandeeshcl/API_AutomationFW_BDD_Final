package Util;

import org.json.JSONObject;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;

import Setup.TestSetup;
import io.restassured.response.Response;




public class TestUtils extends TestSetup {

	
	//To check ID is present method
			public static boolean checkJsonHasKey(String key,Response response)
			{
				JSONObject json=new JSONObject(response.asString());     //store response in json
				return json.has(key); //check this key is present in response
			}
			
			
			//Extent Report
			public static  void logExtentTest(ExtentTest stepLevelExtentTestObject, ExtentTest ScenarioLevelExtentTestObject,
					String stepDefinationAnnotation, String stepDefination, String successMessage) {
				try {

					stepLevelExtentTestObject = ScenarioLevelExtentTestObject
							.createNode(new GherkinKeyword(stepDefinationAnnotation), stepDefination);

					stepLevelExtentTestObject.info(successMessage);
					// Assert.assertTrue(false);

				} catch (AssertionError | Exception e) {
					testStepHandle("FAIL", stepLevelExtentTestObject, e);
				}
			}	
}
