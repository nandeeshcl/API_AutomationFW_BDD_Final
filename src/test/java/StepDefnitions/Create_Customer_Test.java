package StepDefnitions;


import org.apache.log4j.Logger;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Feature;

import Setup.TestSetup;
import Util.TestUtils;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static io.restassured.RestAssured.*;



public class Create_Customer_Test extends TestSetup{

	/*// To create Request
	RequestSpecification requestSpecs;

	// To store response
	Response response;
	
	//JsonPath 
	JsonPath  responseJson;*/
	
	//before the specified tag in @Before annotation execute this method
	
	//For customer API
		public static ExtentTest Create_Customer_Test = null;
		
		
	@Before("@Customer_API")  //tag used in FF ,Test name can be anything
	public void beforeCustomerAPIScenario(Scenario scenario) {
		
		
		
		//Steps: Obtain feature file name /obtain scenario name/ create lhs node with that feature name (extent)
		//   create seperate middle node for each scenario with obtained scenario name (test)
		
		//System.out.println("Scenario.getId()-->" + scenario.getId());
		//returns complete path of feature file
		String[] splitedName = scenario.getId().split("/"); 
		// scenario.getId():-Return complete path of feature file

		
		//obtain name of feature file from path
		String featureName = splitedName[splitedName.length - 1];  
		featureName = featureName.substring(0, featureName.indexOf("."));

		 //obtain name of scenario
		String scenarioName = scenario.getName();  //obtain name of scenario
		
		//using extent variable we create node in LHS for that specific feature 
		if (Create_Customer_Test == null) {
			//System.out.println("Extent report-->" + extent);
			Create_Customer_Test = extent.createTest(Feature.class, featureName);  //create LHS Node for that feature
		}

		// test = extent.createTest(Feature.class, featureName);

		//using test variable we create node in middle for each scenario in that feature file
		//create Middle node for each scenario in that feature file with the scenario name
		
		test = Create_Customer_Test.createNode(scenarioName);
		
		
		
		//System.out.println("Feature Name-->" + featureName);
	}
	
	
	@Given("I have valid auth key")
	public void i_have_valid_auth_key() {
		
		
		test.assignAuthor("Nandeesh");
		test.assignCategory("Regression Test Cases");
		
		
		log=Logger.getLogger(Create_Customer_Test.class);
		
		//Authentication using basic auth
		//requestSpecs=given().auth().basic(configProperty.getValidAuthKey(),"");
		
		//Authentication using header
		requestSpecs=given().header("Authorization","Bearer "+configProperty.getValidAuthKey());
		
		TestUtils.logExtentTest(logInfo, test, "Given", "i_set_the_valid_auth_key", "I set the auth key successFully");
		
		
		log.info("Auth Key Entered");

	}

	@Given("I have email {string} and description {string}")
	public void i_have_email_and_description(String string, String string2) {
		requestSpecs=requestSpecs.formParam("email",string).formParam("description",string2);      
		
		TestUtils.logExtentTest(logInfo, test, "Given", "i_set_as_the_email_in_parameter", "I set the email successfullyy");
		
		
	}

	@When("I send post request")
	public void i_send_post_request() {
		response=requestSpecs.post(configProperty.getcreateCustomerAPIEndPoint());
		
		TestUtils.logExtentTest(logInfo, test, "Given", "I send post request", "I send the POST Request successfully");
		
		
		//To print response on console
		//response.prettyPrint();
	}

	@Then("I verify status code is {int}")
	public void i_verify_status_code_is(int int1) {
		Assert.assertEquals(response.statusCode(),int1);
		
		TestUtils.logExtentTest(logInfo, test, "Given", "I verify status code is {int}", "Status code verified successfully");
	}

	@Then("email in response should be {string} description should be {string}")
	public void email_in_response_should_be_description_should_be(String string, String string2) {
               responseJson=response.jsonPath();
              // System.out.println(responseJson.get("email"));
               Assert.assertEquals(responseJson.getString("email"),string);
               Assert.assertEquals(responseJson.getString("description"),string2);
               
          TestUtils.logExtentTest(logInfo, test, "Given", "email in response should be {string} description should be {string}", "Email verified successfully");
               
	}

	@Then("I verify {string} is present")
	public void i_verify_is_present(String string) {
		
		//Check id field is not null
		Assert.assertNotNull(response.jsonPath().get("id"));
		TestUtils.logExtentTest(logInfo, test, "Given", "I verify {string} is present", "ID Field verified successfully");
	}
	
	
	@Given("I have in-valid auth key")
	public void i_have_in_valid_auth_key() {
		requestSpecs=given().auth().basic(configProperty.getInvalidAuthKey(),"");
	}

	@Then("the response contains the message {string}")
	public void the_response_contains_the_message(String string) {
		response.prettyPrint();
		responseJson=response.jsonPath();
		//responseJson=response.jsonPath();
         System.out.println(response.jsonPath().getString("error.message"));
        Assert.assertEquals(responseJson.getString("error.message"),string);
	   
	}

	
	
	
	
	


}
