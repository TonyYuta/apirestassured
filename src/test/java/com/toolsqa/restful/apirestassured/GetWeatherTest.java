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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
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
public class GetWeatherTest{
		
	@Test(enabled = false, groups = {"weather", "get", "city", "all"}, priority = 0)
	public void getWeatherDetails(){
		
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
		// we have received from the server
		String responseBody = response.getBody().asString();
		System.out.println("ResponseBody: " + responseBody);	
	}

	@Test(description="get Weather Details in Hyderabad",
	enabled=true,
	groups={"all","get","city","all"},
	dependsOnGroups={},
	dependsOnMethods={},
	priority=0)
	public void testGetWeatherDetails(){
		String expected = "{\n" +
				"    \"City\": \"Hyderabad\",\n" +
				"    \"Temperature\":";
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains(expected), "mismatch in weather response");
	}
	
	@Test(enabled = false, groups = {"weather", "get", "city", "bat", "all"}, priority = 0)
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

	@Test(description="get Weather Details Response Status",
			enabled=true,
			groups={"weather","get","city","bat","all"},
			dependsOnGroups={},
			dependsOnMethods={},
			priority=0)
	public void testGetWeatherDetailsRespStatus(){
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /*actual value*/,200/*expected*/,"returned incorrect status code");
	}

	
	@Test(enabled = true, groups = {"weather", "get", "city", "all"}, priority = 0)
	public void getWeatherWrongCityRespStatus(){
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hiderabad");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode/*actual value*/, 400/*expected value*/, "Status code for wrong city doesn't match to expected");
	}

	@Test(description="get Weather Wrong City Response Status",
			enabled=true,
			groups={"weather", "get", "city", "all"},
			dependsOnGroups={},
			dependsOnMethods={},
			priority=0)
	public void testGetWeatherWrongCityRespStatus(){
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/Hiderabad");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,400/*expected*/,"mismatch in status code for wrong city");
	}

	@Test(description="Get Weather Wrong City Response Body",
			enabled=true,
			groups={"weather", "get", "city", "all"},
			dependsOnGroups={},
			dependsOnMethods={},
			priority=0)
	public void testGetWeatherWrongCityResponseBody(){
		String expected = "{\n" +
				"    \"FaultId\": \"FAULT_INTERNAL\",\n" +
				"    \"fault\": \"An internal error occured while servicing the request\"\n" +
				"}";
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification  httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/San-Francisco");
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody,expected,"mismatch in responce for wrong city");
	}

	@Test(enabled = false, groups = {"weather", "get", "status", "city", "all"}, priority = 0)
	public void getWeatherResponseStatusLine() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine/*actual*/, "HTTP/1.1 200 OK"/*expected*/, "Status line doesn't match to expected"/*error message*/);
	}

	@Test(description="get Weather Response Status Line",
			enabled=true,
			groups = {"weather", "get", "status", "city", "all"},
			dependsOnGroups={},
			dependsOnMethods={},
			priority=0)
	public void testGetWeatherResponseStatusLine(){
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/San Francisco");
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine,"HTTP/1.1 200 OK", "mismatch in status line");
	}
	
	@Test(enabled = false, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseStatusQQQ() {
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

	@Test(description="testGetWeatherResponseStatus",
			enabled=true,
			groups = {"weather", "get", "city", "status", "all"},
			dependsOnGroups={},
			dependsOnMethods={},
			priority=0)
	public void testGetWeatherResponseStatus(){
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/San Francisco");
		String statusLine = response.getStatusLine();
		assertThat(statusLine, containsString("200"));
		assertThat(statusLine, containsString("HTTP/1.1"));
		assertThat(statusLine, containsString("OK"));
		List<String> items = Arrays.asList(statusLine.split(" "));
		assertThat(items, hasItem("200"));
		assertThat(items, hasItems("200","OK"));
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
		assertThat(contentType, containsString("application/json"));
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseHeaderserverType() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String serverType = response.header("Server");
		Assert.assertEquals(serverType, "nginx/1.12.2", "Server-Type doesn't match to expected");
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseHeaderAcceptLanguage() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String acceptLanguage = response.header("Content-Encoding");
		assertThat(acceptLanguage, containsString("gzip"));
	}
	
	@Test(enabled = true, groups = {"weather", "get", "city", "status", "all"}, priority = 0)
	public void testGetWeatherResponseAllHeaders() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		String contentType = response.header("Content-Type");
		String serverType = response.header("Server");
		String acceptLanguage = response.header("Content-Encoding");
		assertThat((contentType + " | " + serverType + " | " + acceptLanguage), containsString("application/json | nginx/1.12.2 | gzip"));		 
	}
	
	@Test(enabled = true, groups = {"weather", "city", "get", "body", "all"}, priority = 1)
	public void testGetWeatherBody() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		assertThat(body.asString(), containsString("\"Hyderabad\""));
		Assert.assertEquals(body.asString().toLowerCase().contains("hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
	}
	
	@Test(enabled = true, groups = {"weather", "city", "get", "body", "all"}, priority = 1)
	public void testVerifyCityInJsonResponse() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		
		// get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String city = jsonPathEvaluator.get("City");
		
		// print the city variable to see what we got
		System.out.println("City received from Response: " + city);
		
		// Validate the response
		Assert.assertEquals(city, "Hyderabad", "Incorrect city name received in the Response");
	}

	// reads all the nodes and prints them to the Console
	@Test(enabled = true, groups = {"weather", "city", "get", "body", "json", "all"}, priority = 1)
	public void testDisplayAllNodesInWeatherAPI() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("Response City: " + jsonPathEvaluator.get("City"));
		System.out.println("Response Humidity: " + jsonPathEvaluator.get("Humidity"));
		System.out.println("Response Weather: " + jsonPathEvaluator.get("Weather"));
		System.out.println("Response Wind Speed: " + jsonPathEvaluator.get("WindSpeed"));
		System.out.println("Response Wind Direction Degree: " + jsonPathEvaluator.get("WindDirectionDegree"));
	}
	
	@Test(enabled = true, groups = {"weather", "city", "get", "body", "json", "all"}, priority = 1)
	public void testDisplayCityNodeInWeatherAPI() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		JsonPath jsonPathEvaluator = response.jsonPath();
		String city = jsonPathEvaluator.get("City");
		assertThat(city, containsString("Hyderabad"));
	}
	
	@Test(enabled = true, groups = {"weather", "city", "get", "body", "json", "all"}, priority = 1)
	public void testDisplayHumidityNodeInWeatherAPI() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		JsonPath jsonPathEvaluator = response.jsonPath();
		String Humidity = jsonPathEvaluator.getString("Humidity");
		Assert.assertEquals(Humidity, "87 Percent");
	}
	
	@Test(enabled = true, groups = {"weather", "city", "get", "body", "json", "all"}, priority = 1)
	public void testDisplayWeatherNodeInWeatherAPI() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		JsonPath jsPE = response.jsonPath();
		String weather = jsPE.getString("Weather");
		Assert.assertEquals(weather, "");
	}
	
	@Test(enabled = true, groups = {"weather", "city", "get", "body", "json", "all"}, priority = 1)
	public void testDisplayWindSpeedNodeInWeatherAPI() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		JsonPath pathResp = response.jsonPath();
		String windSpeed = pathResp.getString("WindSpeed");
		Assert.assertEquals(windSpeed, "2.1 Km per hour");
	}

	@Test(enabled = true, groups = {"weather", "city", "get", "body", "json", "all"}, priority = 1)
	public void testDisplayWindDirectionDegreeNodeInWeatherAPI() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");
		JsonPath respJson = response.jsonPath();
		String windDirectionDegree = respJson.getString("WindDirectionDegree");
		Assert.assertEquals(windDirectionDegree, "150 Degree");
		
	}

	
}
