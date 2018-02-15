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
		requestParams.put("FirstName", "Virender02");
		requestParams.put("LastName", "Singh02");
		requestParams.put("UserName", "sdimpleuser2dd201102");
		requestParams.put("Email", "sample2ee26d902@gmail.com");
		requestParams.put("Password", "password102");
		
		request.body(requestParams.toJSONString());
		Response response = request.put("/register");
		
		int statusCode = response.getStatusCode();
		System.out.println("statusCode: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
	}
	
	
}
