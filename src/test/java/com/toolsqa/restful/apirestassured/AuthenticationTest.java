/**
 *   File Name: AuthenticationTest.java<br>
 *
 *   Yutaka<br>
 *   Created: Mar 4, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * AuthenticationTest //ADDD (description of class)
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
public class AuthenticationTest {
	
	@Test
	public void AuthenticationBasics()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RequestSpecification request = RestAssured.given();
	 
		Response response = request.get();
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("Status message " + response.body().asString());
	}
}
