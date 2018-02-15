/**
 *   File Name: Square.java<br>
 *
 *   Yutaka<br>
 *   Created: Feb 9, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import java.io.Serializable;

/**
 * Square //ADDD (description of class)
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
public class Square implements Serializable {
	
	private double side;
	
	public Square(double side) {
		this.side = side;
	}
	
	public double area() {
		return side * side;
	}
	
	public double perimeter() {
		return side * 4;
	}
	
	public static void main(String[] args) {
		Square sq = new Square(5);
		Rectangle rt = new Rectangle(4, 5);
		SerializDeserializObj.SerializeObjectToFile(sq, "sq01");
		SerializDeserializObj.SerializeObjectToFile(rt, "rt01");
		Serialization.SerializeToFile(sq, "sq02");
		Serialization.SerializeToFile(rt, "rt02");
		
		Rectangle deSerializedRect = (Rectangle) SerializDeserializObj.deSerializeObjectFromFile("rt02");
		Square deSerializedSquare = (Square) SerializDeserializObj.deSerializeObjectFromFile("sq02");
		
	}
}
