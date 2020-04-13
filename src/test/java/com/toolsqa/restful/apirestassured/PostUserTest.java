/**
 *   File Name: PostUser.java<br>
 *
 *   Yutaka<br>
 *   Created: Feb 5, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

/**
 * PostUser //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 * 
 * @author      Yutaka
 * @version     1.0.0
 * @since       1.0
 *
 */
public class PostUserTest {

	@Test(enabled = true, groups = {"post", "user", "bat", "all"})
	public void testCreateUser01() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "cj19vplm"+Helper.rndNum());
		requestParams.put("LastName", "cj19vplm"+Helper.rndNum());
		requestParams.put("UserName",  "cj19vplm"+Helper.rndNum());
		requestParams.put("Password", "cj19vplm"+Helper.rndNum());
		requestParams.put("Email", "cj19vplm"+Helper.rndNum()+"@gmail.com");

		//JSONObject.toJSONString(requestParams);
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		// Post the request and check the response
		Response response = request.post("/register");

		//RequestSpecification.body(JsonString);
		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 201);
		String successCode = response.jsonPath().getString("SuccessCode");
		assertEquals(successCode, "OPERATION_SUCCESS");
		}
	
	@Test(enabled = true, groups = {"post", "user", "bat", "all"})
	public void RegistrationSuccessful() {		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "cj19vplm"+Helper.rndNum());
		requestParams.put("LastName", "cj19vplm"+Helper.rndNum());
		requestParams.put("UserName",  "cj19vplm"+Helper.rndNum());
		requestParams.put("Password", "cj19vplm"+Helper.rndNum());
		requestParams.put("Email", "cj19vplm"+Helper.rndNum()+"@gmail.com");
		request.body(requestParams.toJSONString());

		Response response = request.post("/register");

		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 201);
		String successCode = response.jsonPath().get("SuccessCode");
		assertEquals(successCode, "OPERATION_SUCCESS");
	}
	
	@Test(enabled = true, groups = {"post", "user", "bat", "all"})
	public void testRegistrationSuccessful() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "cj19vplm"+Helper.rndNum());
		requestParams.put("LastName", "cj19vplm"+Helper.rndNum());
		requestParams.put("UserName",  "cj19vplm"+Helper.rndNum());
		requestParams.put("Password", "cj19vplm"+Helper.rndNum());
		requestParams.put("Email", "cj19vplm"+Helper.rndNum()+"@gmail.com");
		request.body(requestParams.toJSONString());

		Response response = request.post("/register");

		int statusCode = response.getStatusCode();
		assertEquals(statusCode,  201);
		String successCode = response.jsonPath().getString("SuccessCode");
		assertEquals(successCode, "OPERATION_SUCCESS");
	}
	
	@Test(enabled = true, groups = {"post", "user", "bat", "all"})
	public void testRegistrationError() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "cj19vplm"+Helper.rndNum());
		requestParams.put("LastName", "cj19vplm"+Helper.rndNum());
		requestParams.put("UserName",  "cj19vplm"+Helper.rndNum());
		requestParams.put("Password", "cj19vplm"+Helper.rndNum());
		requestParams.put("Email", "cj19vplm"+Helper.rndNum()+"@gmail.com");
		request.body(requestParams.toJSONString());

		Response response = request.put("/register");

		int statusCode = response.getStatusCode();
		System.out.println("statusCode: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
		assertEquals(statusCode, 405);
	}
	
	@Test
	public void test08RegistrationSuccessful(){
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "cj19vplm"+Helper.rndNum());
		requestParams.put("LastName", "cj19vplm"+Helper.rndNum());
		requestParams.put("UserName",  "cj19vplm"+Helper.rndNum());
		requestParams.put("Password", "cj19vplm"+Helper.rndNum());
		requestParams.put("Email", "cj19vplm"+Helper.rndNum()+"@gmail.com");
		request.body(requestParams.toJSONString());

		Response response = request.post("/register");

		int statusCode = response.getStatusCode();
		assertEquals(statusCode, 201);
		String successCode = response.jsonPath().get("SuccessCode");
		assertEquals("OPERATION_SUCCESS", successCode);
	}

    @Test
    public void testPostSubmitForm() {
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";

    // use org.json JSONObject to define your json
    JSONObject userCredentials = new JSONObject();
		userCredentials.put("FirstName", "user42dedewfdwdfw@site.com"+Helper.rndNum());
		userCredentials.put("LastName", "user5d2de3421wdwqfwdwfwq"+Helper.rndNum());
		userCredentials.put("UserName", "users32dedevesqw545"+Helper.rndNum());
		userCredentials.put("Password", "Pas53423dedewdwqfqwdfwq"+Helper.rndNum());
		userCredentials.put("Email", "user454532vdede2sq23@gmail.com"+Helper.rndNum());

    given()
      .contentType("application/json")  //another way to specify content type
      .body(userCredentials.toString())   // use jsonObj toString method
	.when()
      .post("/register")
   .then()
		.statusCode(201);
	}

	@Test(description = "Post",
			enabled = true,
			groups = {"user","get", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 1)
	public void validateResponseHeadersTest() {
		String expected = "{\n" +
				"    \"SuccessCode\": \"OPERATION_SUCCESS\",\n" +
				"    \"Message\": \"Operation completed successfully\"\n" +
				"}";

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification httpRequest = given();
		httpRequest.header("Content-Type", "application/json");
		// Create new JSON Object
		JSONObject userCredentials = new JSONObject();
		userCredentials.put("FirstName", "user42dedewfdwdfw@site.com"+Helper.rndNum());
		userCredentials.put("LastName", "user5d2de3421wdwqfwdwfwq"+Helper.rndNum());
		userCredentials.put("UserName", "users32dedevesqw545"+Helper.rndNum());
		userCredentials.put("Password", "Pas53423dedewdwqfqwdfwq"+Helper.rndNum());
		userCredentials.put("Email", "user454532vdede2sq23@gmail.com"+Helper.rndNum());
		httpRequest.body(userCredentials.toString());
		Response response = httpRequest.post("/register");

		String responseBody = response.getBody().asString();
		assertEquals(responseBody, expected, "mismatch in response");
	}

	@Test(description = "create user",
			enabled = true,
			groups = {"post", "user", "body", "json", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 1)
	public void testCreateUser02() {
		String payLoad = "{\"FirstName\":\"cj143412\",\n" +
				"\"LastName\":\"cj19vpl23\",\n" +
				"\"UserName\":\"cj19vp345\",\n" +
				"\"Password\":\"cj1lm4576\",\n" +
				"\"Email\":\"cj1lm7676@gmail.com\"}";

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		Response response = given()
				.contentType("application/json")
				.accept("application/json")
				.body(payLoad)
				.when()
				.post("/register")
				.then()
				.statusCode(200)
				.contentType("application/json")
				.extract()
				.response();
		String resp = response.jsonPath().getString("FaultId");
		Assert.assertTrue(resp.contains("User already exists"), "mismatch in FaultId");
	}

	@Test(description = "create duplicate user",
			enabled = true,
			groups = {"post", "user", "body", "json", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 1)
	public void testCreateNonUniqueUser03() {
		String payLoad = "{\"FirstName\":\"cj143412\",\n" +
				"\"LastName\":\"cj19vpl23\",\n" +
				"\"UserName\":\"cj19vp345\",\n" +
				"\"Password\":\"cj1lm4576\",\n" +
				"\"Email\":\"cj1lm7676@gmail.com\"}";

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		given()
				.contentType("application/json")
				.accept("application/json")
				.body(payLoad)
				.when()
				.post("/register")
				.then()
				.assertThat()
				.statusCode(200)
				.body("FaultId",containsString("User already exists"));
	}

	@Test
	public void testUserExists() {
		String payload = "{\"FirstName\":\"cj143412\",\n" +
				"\"LastName\":\"cj19vpl23\",\n" +
				"\"UserName\":\"cj19vp345\",\n" +
				"\"Password\":\"cj1lm4576\",\n" +
				"\"Email\":\"cj1lm7676@gmail.com\"}";
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		given()
				.contentType("application/json")
				.accept("application/json")
				.body(payload)
				.when()
				.post("/register")
				.then()
				.assertThat()
				.statusCode(200)
				.body("FaultId", containsString("User already exists"));
	}

	@Test(description="create unique user",
	enabled=true,
	groups={"all","post","body","payLoad"},
			dependsOnGroups={},
			dependsOnMethods={},
			priority=1
	)
	public void testCreateNonUniqueUser04(){
		String payLoad = "{\n\"FirstName\":\"aabbccdd"+Helper.rndNum()+"\",\n" +
				"\"LastName\":\"aabbccdd"+Helper.rndNum()+"\",\n" +
				"\"UserName\":\"aabbccdd"+Helper.rndNum()+"\",\n" +
				"\"Password\":\"aabbccdd"+Helper.rndNum()+"\",\n" +
				"\"Email\":\"aabbccdd"+Helper.rndNum()+"@gmail.com\"\n}";
		//System.out.println("payLoad: \n"+payLoad);
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		given()
				.contentType("application/json")
				.accept("application/json")
				.body(payLoad)
				.when()
				.post("/register")
				.then()
				.assertThat()
				.statusCode(201)
				.body("Message",containsString("Operation completed successfully")
						, "SuccessCode",containsString("OPERATION_SUCCESS"));
	}

	@Test(description="create user using payLoad from Helper",
	enabled=true,
	groups={"all","helper","post","json","body"},
	dependsOnGroups={},
	dependsOnMethods={},
	priority=1)
	public void testCreateNonUniqueUser05(){
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		given()
				.contentType("application/json")
				.accept("application/json")
				.body(Helper.payLoad())
				.when()
				.post("/register")
				.then()
				.assertThat()
				.statusCode(201)
				.body("Message",containsString("Operation completed successfully")
						,"SuccessCode",containsString("OPERATION_SUCCESS"));
	}

	@Test(description="create user using Basic Authentication",
	enabled=true,
	groups={"all","Basic Authentication","post","json"},
			dependsOnGroups={},
			dependsOnMethods={},
			priority=1
	)
	public void testCreateNonUniqueUser06(){
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		given().auth()
				.basic("ToolsQA","TestPassword")
				.contentType("application/json")
				.accept("application/Json")
				//.header("Authorization","Basic VG9vbHNRQTpUZXN0UGFzc3dvcmQ=")
				.body(Helper.payLoad())
				.when()
				.post("/register")
				.then()
				.assertThat()
				.statusCode(201)
				.body("Message",containsString("Operation completed successfully")
						,"SuccessCode", containsString("OPERATION_SUCCESS"));
	}

	@Test(description = "Create user, Basic Authentication",
			enabled = true,
			groups = {"all", "Basic", "post", "user"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 3)
	public void testCreateDummyUser() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		given().auth()
				.basic("ToolsQA", "ThePassword")
				.contentType("application/json")
				.accept("application/json")
				.body(Helper.payLoad())
				.when()
				.post("/register")
				.then()
				.assertThat()
				.statusCode(201)
				.body("Message", containsString("Operation completed successfully")
				,"SuccessCode", containsString("OPERATION_SUCCESS"));
	}

	@Test
	public void testBasicAuth03() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		given().auth()
				.basic("ToolsQA", "ThePassword")
				.contentType("application/json")
				.accept("application/json")
				.body(Helper.payLoad())
				.when()
				.post("/register")
				.then()
				.assertThat()
				.statusCode(201)
				.body("Message", containsString("Operation completed successfully")
				,"SuccessCode", containsString("OPERATION_SUCCESS"));
	}

	/*
	Dummy api example
	1	/employee		GET		JSON	http://dummy.restapiexample.com/api/v1/employees	Get all employee data
	2	/employee/{id}	GET		JSON	http://dummy.restapiexample.com/api/v1/employee/1	Get a single employee data
	3	/create			POST	JSON	http://dummy.restapiexample.com/api/v1/create		Create new record in database
		Details: Sample Json: {"name":"test","salary":"123","age":"23"}
	4	/update/{id}	PUT		JSON	http://dummy.restapiexample.com/api/v1/update/21	Update an employee record
		Details: sample Json: {"name":"test1","salary":"1123","age":"23"}
	5	/delete/{id}	DELETE	JSON	http://dummy.restapiexample.com/api/v1/update/2		Delete an employee record
	*/

	@Test
	public void givenUrl_whenJsonResponseHasArrayWithGivenValuesUnderKey_thenCorrect02() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee/82187";
		Response response = given()
				.get();
		JsonPath jp = response.jsonPath();
		String emp_age = jp.get("employee_age");
		Assert.assertTrue(emp_age.contains("2147483647"), "mismatch in age response");
	}

	@Test(description="create user using Basic Authentication",
			enabled=true,
			groups={"all","post","json"},
			dependsOnGroups={},
			dependsOnMethods={},
			priority=1
	)
	public void testGetUserName08(){
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee/82187";
		Response response = given()
				.contentType("application/json")
				.accept("application/json")
				.when()
				.get();
		JsonPath jp = response.jsonPath();
		assertThat(jp.get("employee_name"),equalTo("neeeeegggg"));
	}

	@Test(description="get age",
	enabled=true,
	groups={"all","get","age"},
	dependsOnGroups={},
	dependsOnMethods={},
	priority=1)
	public void test(){
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee/82187";
		Response response = given()
				.contentType("application/json")
				.accept("application/json")
				.when()
				.get();
		String name = response.jsonPath().getString("employee_name");
		String salary = response.jsonPath().getString("employee_salary");

		assertThat(name,containsString("neeeeegggg"));
		Assert.assertTrue(name.contains("neeeeegggg"), "mismatch salary");

		assertThat(salary,containsString("6666335"));
		Assert.assertTrue(salary.contains("6666335"), "mismatch salary");


	}



	}
