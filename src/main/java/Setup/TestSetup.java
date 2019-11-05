package Setup;

import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import StepDefnitions.Create_Customer_Test;
import Util.ConfigProperties;
import Util.ExtentReportListener;
import cucumber.api.Scenario;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestSetup extends ExtentReportListener {
	

	// To create Request
		public static RequestSpecification requestSpecs;

		// To store response
		public static Response response;
		
		//JsonPath 
		public static JsonPath  responseJson;
		
	// Owner API
		public static ConfigProperties configProperty;
		
		//Logger
		public static Logger log;
		
		//For extent report
		public static ExtentTest logInfo = null;
		
		public static void setup() {

			//Load logger file
			//LOG4J PROPERTY FILE LOAD
			//log=Logger.getLogger("Practise");
			
			PropertyConfigurator.configure("./src/test/PropertyFile/log4j.properties");
			
			
			// Owner API Config Property
			configProperty = ConfigFactory.create(ConfigProperties.class);

			// Keep Base URI and Base Path
			RestAssured.baseURI = configProperty.getBaseURI();
			RestAssured.basePath = configProperty.getBasePath();
			
		}
		

		
}
