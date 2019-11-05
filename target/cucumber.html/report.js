$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./src/test/Feature_Files/Customer_API.feature");
formatter.feature({
  "name": "Test Customer API with different functionality",
  "description": "  This features is used to validate Customer API Functionality",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Customer_API"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Validate Create Customer API with valid auth key",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "name": "I have valid auth key",
  "keyword": "Given "
});
formatter.step({
  "name": "I have email \"\u003cemail\u003e\" and description \"\u003cdescription\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "I send post request",
  "keyword": "When "
});
formatter.step({
  "name": "I verify status code is \u003cstatusCode\u003e",
  "keyword": "Then "
});
formatter.step({
  "name": "email in response should be \"\u003cemail\u003e\" description should be \"\u003cdescription\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "I verify \"\u003cfield\u003e\" is present",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "description",
        "statusCode",
        "field"
      ]
    },
    {
      "cells": [
        "name1@gmail.com",
        "name1",
        "200",
        "id"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Validate Create Customer API with valid auth key",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Customer_API"
    },
    {
      "name": "@Regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have valid auth key",
  "keyword": "Given "
});
formatter.match({
  "location": "Create_Customer_Test.i_have_valid_auth_key()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I have email \"name1@gmail.com\" and description \"name1\"",
  "keyword": "And "
});
formatter.match({
  "location": "Create_Customer_Test.i_have_email_and_description(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I send post request",
  "keyword": "When "
});
formatter.match({
  "location": "Create_Customer_Test.i_send_post_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "Create_Customer_Test.i_verify_status_code_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "email in response should be \"name1@gmail.com\" description should be \"name1\"",
  "keyword": "And "
});
formatter.match({
  "location": "Create_Customer_Test.email_in_response_should_be_description_should_be(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify \"id\" is present",
  "keyword": "And "
});
formatter.match({
  "location": "Create_Customer_Test.i_verify_is_present(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});