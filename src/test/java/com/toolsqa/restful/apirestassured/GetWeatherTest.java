package com.toolsqa.restful.apirestassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/**
 *   File Name: GetWeatherTest.java<br>
 *
 *   Yutaka<br>
 *   Created: Jan 24, 2018
 *   
 */
/**
 * GetWeatherTest //ADDD (description of class)
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
public class GetWeatherTest {
	
	@Test(enabled = true, groups = {"weather", "get", "city", "all"}, priority = 0)
	public void getWeatherDetails() {
		
		// specify the base url to the RESTFul web services
		RestAssured.baseURI  = "http://restapi.demoqa.com/utilities/weather/city";
		
		// get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		
		// make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody: " + responseBody);	
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "bat", "all"}, priority = 0)
	public void getWeatherDetailsRespStatus() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		// Get the status code from the Response. In case of 
		// a successfull interaction with the web service, we
		// should get a status code of 200.
		int statusCode = response.getStatusCode();
		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "all"}, priority = 0)
	public void getWeatherWrongCityRespStatus() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hiderabad");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 400, "Status code for wrong city doesn't match to expected");
	}
	
	
	
	
}
