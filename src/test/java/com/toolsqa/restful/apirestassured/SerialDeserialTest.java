/**
 *   File Name: SerialDeserialTest.java<br>
 *
 *   Yutaka<br>
 *   Created: Feb 12, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import org.testng.annotations.Test;

/**
 * SerialDeserialTest //ADDD (description of class)
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
public class SerialDeserialTest {
		
	@Test(enabled = true, groups = {"ser", "bat", "all"}, priority = 3)
	public void testSerDeserRectangle() {
		Rectangle rt = new Rectangle(4, 5);
		SerializDeserializObj.SerializeObjectToFile(rt, "rt01");
		//Serialization.SerializeToFile(rt, "rt01");		
		Rectangle deSerializedRect = (Rectangle) SerializDeserializObj.deSerializeObjectFromFile("rt01");
		//System.out.println("1 ============= " + deSerializedRect.area());
		System.out.println("2 ============= " + deSerializedRect);
	}
	
	@Test(enabled = true, groups = {"ser", "bat", "all"}, priority = 3)
	public void testSerDeserSquare() {
		Square sq = new Square(5);
		SerializDeserializObj.SerializeObjectToFile(sq, "sq01");
		//Serialization.SerializeToFile(sq, "sq01");
		//Square deSerializedSquare = (Square) SerializDeserializObj.deSerializeObjectFromFile("sq02");
		//Square deSerializedSquare = (Square) serDeser.deSerializeObjectFromFile("sq02");
		Square deSerializedSquare = (Square) SerializDeserializObj.deSerializeObjectFromFile("sq01");
		//System.out.println(deSerializedSquare.area());
		System.out.println(deSerializedSquare);
	}
}
