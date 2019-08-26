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

import java.util.Random;

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

/*	public int rndNum(){
		Random rand = new Random();
		int rnd = (int)(Math.random() * 50 + 1);
		returm rnd;
	}*/


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
		Assert.assertEquals(statusCode, 201);
		String successCode = response.jsonPath().getString("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
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
		Assert.assertEquals(statusCode, 201);
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
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
		Assert.assertEquals(statusCode,  201);
		String successCode = response.jsonPath().getString("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
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
		Assert.assertEquals(statusCode, 405);
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
		Assert.assertEquals(statusCode, 201);
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals("OPERATION_SUCCESS", successCode);
	}

	
}
