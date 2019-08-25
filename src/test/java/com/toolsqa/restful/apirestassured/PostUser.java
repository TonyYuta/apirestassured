/**
 *   File Name: PostUser.java<br>
 *
 *   Yutaka<br>
 *   Created: Feb 5, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

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
public class PostUser {
	
	@Test(enabled = true, groups = {"post", "user", "bat", "all"})
	public void testCreateUser01() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender");
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName",  "simpleuser001");
		requestParams.put("Password", "simpleuser001");
		requestParams.put("Email", "someuser@gmail.com");
		//JSONObject.toJSONString(requestParams);
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		// Add the Json to the body of the request
		request.body(requestParams.toJSONString());
		// Post the request and check the response
		Response response = request.post("/register");
		//RequestSpecification.body(JsonString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().getString("SuccessCode");
		Assert.assertEquals("Correct Success code was returned", successCode, "OPERATION_SUCCESS");	
		}
	
	@Test(enabled = true, groups = {"post", "user", "bat", "all"})
	public void RegistrationSuccessful() {		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");

		requestParams.put("Email",  "sample2ee26d9@gmail.com");
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
	
	@Test(enabled = true, groups = {"post", "user", "bat", "all"})
	public void testRegistrationSuccessful() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender02");
		requestParams.put("LastName", "Singh02");
		requestParams.put("UserName", "sdimpleuser2dd201102");
		requestParams.put("Password", "password102");
		requestParams.put("Email", "sample2ee26d902@gmail.com");
		
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,  "201");
		String successCode = response.jsonPath().getString("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}
	
	@Test(enabled = true, groups = {"post", "user", "bat", "all"})
	public void testRegistrationError() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender03");
		requestParams.put("LastName", "Singh03");
		requestParams.put("UserName", "sdimpleuser2dd201103");
		requestParams.put("Email", "sample2ee26d903@gmail.com");
		requestParams.put("Password", "password103");
		
		request.body(requestParams.toJSONString());
		Response response = request.put("/register");
		
		int statusCode = response.getStatusCode();
		System.out.println("statusCode: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void test08RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		
		requestParams.put("FirstName", "Virender08"); // Cast
		requestParams.put("LastName", "Singh08");
		requestParams.put("UserName", "sdimpleuser08dd2011");
		requestParams.put("Password", "password08");
		requestParams.put("Email",  "sample2ee26d908@gmail.com");
		
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals("OPERATION_SUCCESS", successCode);
	}
	
	@Test(enabled = true, groups = {"post", "deser", "all"}, priority = 3)
	public void test10DeserializingJsonResponse() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender10"); 
		requestParams.put("LastName", "Singh10");
		requestParams.put("UserName", "sdimpleuser10dd2011");
		requestParams.put("Password", "password10");
		requestParams.put("Email",  "sample2ee26d910@gmail.com");
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
		ResponseBody body = response.getBody();
		RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
		Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
		Assert.assertEquals("Operation completed successfully", responseBody.Message);
	}
	
	@Test
	public void test11RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender11"); // Cast
		requestParams.put("LastName", "Singh11");
		requestParams.put("UserName", "63userf2d3d112011");
		requestParams.put("Password", "password11");	
		requestParams.put("Email",  "ed26dff3911@gmail.com");

		request.body(requestParams.toJSONString());
		Response response = request.post("/register");

		ResponseBody body = response.getBody();
		System.out.println(response.body().asString());

		if(response.statusCode() == 200)
		{
			// Deserialize the Response body into RegistrationFailureResponse
			RegistrationFailureResponse responseBody = body.as(RegistrationFailureResponse.class);

			// Use the RegistrationFailureResponse class instance to Assert the values of 
			// Response.
			Assert.assertEquals("User already exists", responseBody.FaultId);
			Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault);	
		}
		else if (response.statusCode() == 201)
		{
			// Deserialize the Response body into RegistrationSuccessResponse
			RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
			// Use the RegistrationSuccessResponse class instance to Assert the values of 
			// Response.
			Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
			Assert.assertEquals("Operation completed successfully", responseBody.Message);	
		}	
	}
	
}
