/**
 *   File Name: BooksTest.java<br>
 *
 *   Yutaka<br>
 *   Created: Mar 4, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * BooksTest //ADDD (description of class)
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
public class BooksTest {
	
	@Test(enabled = true, groups = {"books", "json", "all"}, priority = 4)
	public void test01Books() throws MalformedURLException {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/books/getallbooks";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("");
		
		// get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
		

		// Read all the books as a List of String. Each item in the list
		// represent a book node in the REST service Response
		List<String> allBooks = jsonPathEvaluator.getList("books.title");
		
		// Iterate over the list and print individual book item
		for(String book : allBooks) {
			System.out.println(book);
		}
		
	}

	
	
	
}
