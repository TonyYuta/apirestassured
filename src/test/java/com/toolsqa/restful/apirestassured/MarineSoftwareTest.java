/**
 *   File Name: MarineSoftwareTest.java<br>
 *
 *   Yutaka<br>
 *   Created: Feb 16, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * MarineSoftwareTest //ADDD (description of class)
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
public class MarineSoftwareTest {
	
	MarineSoftware ms;
	ArrayList ls;
	
	@Test(enabled = true, groups = {"marine", "all", "list"}, priority = 3)
	public void test001PrintUniqueWords() {
		ms = new MarineSoftware();
		ls = new ArrayList();
		ls.add("abc");
		ls.add("def");
		ls.add("ghi");
		ls.add("def");
		ls.add("def");
		ls.add("abc");
		ls.add("def");

	//System.out.println(ls);
		ms.printUniqueWords(ls);
	}
	
	@Test(enabled = true, groups = {"marine", "all", "list"}, priority = 3)
	public void test002PrintUniqueWords() {
		ms = new MarineSoftware();
		ls = new ArrayList();
		ls.add("a");
		ls.add("c");
		ls.add("b");
		ls.add("c");
		ls.add("d");
		ls.add("b");
		ls.add("e");

	//System.out.println(ls);
		ms.printUniqueWords(ls);
	}
	
	@Test(enabled = true, groups = {"marine", "all", "list"}, priority = 3)
	public void test003PrintUniqueWords() {
		ms = new MarineSoftware();
		ls = new ArrayList();
		ls.add("a");
		ls.add("c");
		ls.add("b");
		ls.add("c");
		ls.add("d");
		ls.add("b");
		ls.add("e");
		String expected = "[a, d, e]";

		//System.out.println("Unique words: " + ms.uniqueWords(ls));
		Assert.assertEquals(expected, ms.uniqueWords02(ls).toString(), "unique words don't match to expected");
	}
}
