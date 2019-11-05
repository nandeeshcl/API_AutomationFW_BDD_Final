package StepDefnitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	
	//@Before: execute before each scenario
	@Before
	public void beforeScenarion(Scenario scenario) {
	
		//Scenario is a Reflection, contains details of the scenario
	
	//	TestSetup.setup();
		System.out.println(scenario.getName()+" Started Execution");
	}

	//@After: execute after each scenario
	@After
	public void afterScenario(Scenario scenario) {
		
		
		System.out.println(scenario.getName()+" Finished Execution");
		System.out.println("STATUS is: "+scenario.getStatus());
	}

}
