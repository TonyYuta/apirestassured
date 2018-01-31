/**
 *   File Name: Helper.java<br>
 *
 *   Yutaka<br>
 *   Created: Jan 30, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import java.util.UUID;

import org.testng.annotations.Test;

/**
 * Helper //ADDD (description of class)
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
public class Helper {

    public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
	
	@Test(enabled = true, groups = {"string", "memory", "unmutuble", "speed", "all"}, priority = 1)
	public void updatingJumboUnmutableString() {
		long startTime = System.currentTimeMillis();

		int qty = 1_000; // 1 thousand
		//int qty = 1_000_000; // 1 mln
		//int qty = 100_000_000; // 100 mln

		String str = "abc";
		for(int i = 0; i < qty; i++) {
			str = generateString();
		}
		
		long stopTime = System.currentTimeMillis();
		System.out.println("Execution time: " + (stopTime - startTime) + " ms");
	}
	
	@Test(enabled = true, groups = {"string", "memory", "unmutuble", "speed", "all"}, priority = 1)
	public void updatingJumboMutableString() {
		long startTime = System.currentTimeMillis();
		
		int qty = 1_000; // 1 thousand
		//int qty = 1_000_000; // 1 mln
		//int qty = 100_000_000; // 100 mln

		StringBuffer sb = new StringBuffer("abc");
		for(int i = 0; i < qty; i++) {
			sb.setLength(0);
			sb.append(generateString());
		}
		
		long stopTime = System.currentTimeMillis();
		System.out.println("Execution time: " + (stopTime - startTime) + " ms");
	}
}
