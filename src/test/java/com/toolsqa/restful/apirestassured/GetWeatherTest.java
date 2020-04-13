package com.toolsqa.restful.apirestassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import net.sourceforge.pmd.properties.IntegerProperty;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
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
public class GetWeatherTest {

	@Test(description = "get Weather Details in Hyderabad",
			enabled = true,
			groups = {"all", "get", "city"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherDetails() {
		String expected = "{\n" +
				"    \"City\": \"San Francisco\",\n" +
				"    \"Temperature\":";
		// specify the base url to the RESTFul web services
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		// get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = given();
		// make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.get("/San Francisco");
		// Now let us print the body of the message to see what response
		// we have received from the server
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains(expected), "mismatch in weather response");
	}

	@Test
	public void testWeatherSF() {
		String expected = "    \"City\": \"San Francisco\",\n" +
				"    \"Temperature\"";
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		//System.out.println("response: " + response);
		String responseBody = response.getBody().asString();
		//System.out.println("responseBody: " + responseBody);
		Assert.assertTrue(responseBody.contains(expected), "Mismatch in SF weather response");
	}

	@Test(description = "get Weather Details Response Status",
			enabled = true,
			groups = {"weather", "get", "city", "bat", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherDetailsRespStatus() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /*actual value*/, 200/*expected*/, "returned incorrect status code");
	}

	@Test
	public void testGetWeatherDetailsFromResponse() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		int statusCode = response.getStatusCode();
		//System.out.println("statusCode: " + statusCode);
		Assert.assertEquals(statusCode, 200, "Mismatch in status code for SF weather");
	}

	@Test(description = "get Weather Wrong City Response Status",
			enabled = true,
			groups = {"weather", "get", "city", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherWrongCityRespStatus() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San-Francisco");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 400/*expected*/, "mismatch in status code for wrong city");
	}

	@Test(enabled = true,
			description = "get Weather Wrong City Response Status",
			groups = {"weather", "get", "city", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0
	)
	public void test400forWrongCity() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/SanFrancisco");
		int responseStatusCode = response.getStatusCode();
		Assert.assertEquals(responseStatusCode, 400, "Mismatch in status code for wrong city");
	}

	@Test(description = "Get Weather Wrong City Response Body",
			enabled = true,
			groups = {"weather", "get", "city", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherWrongCityResponseBody() {
		String expected = "{\n" +
				"    \"FaultId\": \"FAULT_INTERNAL\",\n" +
				"    \"fault\": \"An internal error occured while servicing the request\"\n" +
				"}";
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San-Francisco");
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody, expected, "mismatch in response for wrong city");
	}

	@Test(description = "get Weather Response Status Line",
			enabled = true,
			groups = {"weather", "get", "status", "city", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherResponseStatusLine() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "mismatch in status line");
	}

	@Test(description = "get Weather Response Status Line",
	enabled = true,
	groups = {"all", "get", "status", "city", "weather"},
	dependsOnGroups = {},
	dependsOnMethods = {},
	priority = 0)
	public void testWeatherRespStatLine() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Mismatch in status line");
	}

	@Test(description = "Get Weather Response Status - hamcrest Assert",
			enabled = true,
			groups = {"weather", "get", "city", "status", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherResponseStatus() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String statusLine = response.getStatusLine();
		assertThat(statusLine, containsString("200"));
		assertThat(statusLine, containsString("HTTP/1.1"));
		assertThat(statusLine, containsString("OK"));
		List<String> items = Arrays.asList(statusLine.split(" "));
		assertThat(items, hasItem("200"));
		assertThat(items, hasItems("200", "OK"));
		assertThat(statusLine, endsWith("OK"));
	}

	@Test(description = "Get Weather Response Status OK",
			enabled = true,
			groups = {"weather", "get", "city", "status", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0
	)
	public void testGetWeatherResponseStatusHamcrest() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String statusLine = response.getStatusLine();
		Assert.assertTrue(statusLine.contains("HTTP/1.1"));
		Assert.assertTrue(statusLine.contains("200"), "Mismatch in status code");
		Assert.assertTrue(statusLine.contains("OK"), "OK was expected");
	}

	public void testGetWeatherResponseStatusOK() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String statusLine = response.getStatusLine();
		List<String> items = Arrays.asList(statusLine.split(" "));
		assertThat(items, hasItem("200"));
	}

	@Test(description = "Get Weather Response Status 200",
			enabled = true,
			groups = {"weather", "get", "city", "status", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherResponseStatus200() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String statusLine = response.getStatusLine();
		List<String> items = Arrays.asList(statusLine.split(" "));
		assertThat(items, hasItem("OK"));
	}

	@Test(description = "Get Weather Response Status HTTP/1.1",
			enabled = true,
			groups = {"weather", "get", "city", "status", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherResponseStatusHTTP1_1() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String statusLine = response.getStatusLine();
		List<String> items = Arrays.asList(statusLine.split(" "));
		assertThat(items, hasItem("HTTP/1.1"));
	}

	@Test(description = "Get Weather Response Status Ends OK",
			enabled = true,
			groups = {"weather", "get", "city", "status", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0
	)
	public void testGetWeatherResponseStatusEndsOK() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String statusLine = response.getStatusLine();
		assertThat(statusLine, endsWith("OK"));
	}

	@Test(description = "Get Weather Response Header Content-Type",
			enabled = true,
			groups = {"weather", "get", "city", "status", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherResponseHeadercontentType() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String contentType = response.header("Content-Type");
		assertThat(contentType, containsString("application/json"));
	}

	@Test
	public void testContentType() {
	RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	RequestSpecification req = given();
	Response resp = req.get("/San Francisco");
	Assert.assertTrue(resp.header("Content-Type").contains("application/json"), "Mismatch in Content-Type");
	}

	@Test(description = "Get Weather Response Header server Type",
			enabled = true,
			groups = {"weather", "get", "city", "status", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherResponseHeaderserverType() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String serverType = response.header("Server");
		Assert.assertEquals(serverType, "nginx", "Server-Type doesn't match to expected");
	}

	@Test
	public void testServerResponse() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpReq = given();
		Response resp = httpReq.get("/San Francisco");
		Assert.assertEquals(resp.header("Server"), "nginx", "Mismatch in server response");
	}

	@Test(description = "Get Weather Response Header Accept Language",
			enabled = true,
			groups = {"weather", "get", "city", "status", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherResponseHeaderAcceptLanguage() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String acceptLanguage = response.header("Content-Encoding");
		assertThat(acceptLanguage, containsString("gzip"));
	}

	@Test
	public void testContentEncoding() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Frasncisco");
		Assert.assertEquals(response.header("Content-Encoding"), "gzip", "Mismatch in Content-Encoding");
	}

	@Test(description = "Get Weather Response All Headers",
			enabled = true,
			groups = {"weather", "get", "city", "status", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0)
	public void testGetWeatherResponseAllHeaders() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		String contentType = response.header("Content-Type");
		String serverType = response.header("Server");
		String acceptLanguage = response.header("Content-Encoding");
		assertThat((contentType + " | " + serverType + " | " + acceptLanguage), containsString("application/json | nginx | gzip"));
	}

	@Test(description = "Get Weather Body",
			enabled = true,
			groups = {"weather", "city", "get", "body", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 0
	)
	public void testGetWeatherBody() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		assertThat(body.asString(), containsString("San Francisco"));
		Assert.assertTrue(body.asString().contains("Degree celsius"), "mismatch in contains body");
	}

	@Test
	public void testBody() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/San Francisco");
		ResponseBody body = response.getBody();
		//System.out.println("body: " + body.asString());
		//System.out.println("Humidity value: " + body.jsonPath().get("Humidity").toString().substring(0, 2));
		int humInt = Integer.parseInt(body.jsonPath().get("Humidity").toString().substring(0,2));
		Assert.assertEquals(body.jsonPath().get("City"), "San Francisco", "Mismatch in city from body");
		Assert.assertTrue(humInt > 10 && humInt < 120, "Mismatch in Humidity value");
	}

	@Test(description = "Verify City In Json Response",
			enabled = true,
			groups = {"weather", "city", "get", "body", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 1)
	public void testVerifyCityInJsonResponse() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		// get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String city = jsonPathEvaluator.get("City");
		Assert.assertEquals(city, "San Francisco", "mismatch in city's name");
	}

	@Test(description = "Display All Nodes In Weather API: reads all the nodes and prints them to the Console",
			enabled = true,
			groups = {"weather", "city", "get", "body", "json", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 1)
	public void testDisplayAllNodesInWeatherAPI() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println("Response City: " + jsonPathEvaluator.get("City"));
		System.out.println("Response Temperature: " + jsonPathEvaluator.get("Temperature"));
		System.out.println("Response Humidity: " + jsonPathEvaluator.get("Humidity"));
		System.out.println("Response WeatherDescription: " + jsonPathEvaluator.get("WeatherDescription"));
		System.out.println("Response WindSpeed: " + jsonPathEvaluator.get("WindSpeed"));
		System.out.println("Response WindDirectionDegree: " + jsonPathEvaluator.get("WindDirectionDegree"));
	}

	@Test(description = "Display City Node In Weather API",
			enabled = true,
			groups = {"all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 1)
	public void test() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		JsonPath jsonPathEvaluator = response.jsonPath();
		String city = jsonPathEvaluator.get("City");
		assertThat(city, containsString("San Francisco"));
	}

	@Test(description = "Display Humidity Node In Weather API",
			enabled = true,
			groups = {"weather", "city", "get", "body", "json", "all"}, dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 1)
	public void testDisplayHumidityNodeInWeatherAPI() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		JsonPath jsonPathEvaluator = response.jsonPath();
		String humidity = jsonPathEvaluator.get("Humidity");
		assertThat(humidity, containsString("Percent"));
	}

	@Test(description = "Display Weather Node In Weather API: Temperature",
			enabled = true,
			groups = {"weather", "city", "get", "body", "json", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 1)
	public void testDisplayWeatherNodeInWeatherAPITemperature() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = given();
		Response response = httpRequest.get("/San Francisco");
		JsonPath jpe = response.jsonPath();
		String temperature = jpe.get("Temperature");
		Assert.assertTrue(temperature.contains("Degree"));
	}

	@Test(description = "Display Wind Speed Node In Weather API: Wind Speed",
			enabled = true,
			groups = {"weather", "city", "get", "body", "json", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 1)
	public void testDisplayWindSpeedNodeInWeatherAPIWindSpeed() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification request = given();
		Response resp = request.get("/San Francisco");
		JsonPath jp = resp.jsonPath();
		String windSpeed = jp.get("WindSpeed");
		Assert.assertTrue(windSpeed.contains("Km per hour"), "mismatch in wind speed response");
	}

	@Test(description = "Display Wind Direction Degree Node In Weather API",
			enabled = true,
			groups = {"weather", "city", "get", "body", "json", "all"},
			dependsOnGroups = {},
			dependsOnMethods = {},
			priority = 1)
	public void testDisplayWindDirectionDegreeNodeInWeatherAPI() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification request = given();
		Response resp = request.get("/San Francisco");
		System.out.println("resp: "+resp.asString());
		JsonPath jp = resp.jsonPath();
		String windDirection = jp.get("WindDirectionDegree");
		Assert.assertTrue(windDirection.contains("Degree"), "mismatch in wind direction response");
	}

	@Test(description = "Display Wind Direction Degree Node In Weather API",
			enabled=true,
			groups={"all","post","json"},
			dependsOnGroups={},
			dependsOnMethods={},
			priority=1
	)
	public void testDisplayWindDirectionDegreeNodeInWeatherAPIv02(){
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		Response response = given()
				.contentType("application/json")
				.accept("application/json")
				.when()
				.get("/San Francisco");
		JsonPath jp = response.jsonPath();
		assertThat(jp.get("WindDirectionDegree"),containsString("Degree"));
	}

	@Test
	public void testWindSpeed() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/San Francisco");
		ResponseBody body = response.getBody();
		float windSpeed = Float.parseFloat(body.jsonPath().get("WindSpeed").toString().substring(0, 3));
		//System.out.println("windSpeed:|" + windSpeed + "|");
		Assert.assertTrue(windSpeed > 0 && windSpeed < 100, "Out of wind speed range");
	}



}
