package com.toolsqa.restful.apirestassured;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

import java.util.Arrays;
import java.util.List;

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
		Assert.assertEquals(statusCode/*actual value*/, 400/*expected value*/, "Status code for wrong city doesn't match to expected");
	}
	
	@Test(enabled = true, groups = {"weather", "get", "status", "city", "all"}, priority = 0)
	public void getWeatherResponseStatusLine() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine/*actual*/, "HTTP/1.1 200 OK"/*expected*/, "Status line doesn't match to expected"/*error message*/);
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseStatus() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String statusLine = response.getStatusLine();
		int statusCode = response.getStatusCode();
	    assertThat(statusLine, containsString("200"));
	    assertThat(statusLine, containsString("HTTP/1.1"));
	    assertThat(statusLine, containsString("OK"));
	    List<String> items = Arrays.asList(statusLine.split(" "));
		assertThat(items, hasItem("200"));
	    assertThat(items, hasItems("200", "OK"));
	    assertThat(statusLine, endsWith("OK"));
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseStatusOK() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String statusLine = response.getStatusLine();
		List<String> items = Arrays.asList(statusLine.split(" "));
		assertThat(items, hasItem("OK"));
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseStatus200() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String statusLine = response.getStatusLine();
		List<String> items = Arrays.asList(statusLine.split(" "));
		assertThat(items, hasItem("200"));
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseStatusHTTP1_1() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String statusLine = response.getStatusLine();
		List<String> items = Arrays.asList(statusLine.split(" "));
		assertThat(items, hasItem("HTTP/1.1"));
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseStatusEndsOK() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	RequestSpecification httpRequest = RestAssured.given();
	Response response = httpRequest.request(Method.GET, "/Hyderabad");
	String statusLine = response.getStatusLine();
	assertThat(statusLine, endsWith("OK"));
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseHeadercontentType() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String contentType = response.header("Content-Type");
		assertThat(contentType, containsString("qqq"));
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseHeaderserverType() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String serverType = response.header("Server");
		Assert.assertEquals(serverType, "", "Server-Type doesn't match to expected");
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseHeaderAcceptLanguage() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String acceptLanguage = response.header("Content-Endcoding");
		assertThat(acceptLanguage, containsString("qqqq"));
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseAllHeaders() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String contentType = response.header("Content-Type");
		String serverType = response.header("Server");
		String acceptLanguage = response.header("Content-Endcoding");
		assertThat(contentType, containsString("qqq"));
		Assert.assertEquals(serverType, "", "Server-Type doesn't match to expected");
		assertThat(acceptLanguage, containsString("qqqq"));		 
	}
	
}
