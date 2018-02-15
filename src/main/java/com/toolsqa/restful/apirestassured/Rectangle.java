/**
 *   File Name: Rectangle.java<br>
 *
 *   Yutaka<br>
 *   Created: Feb 8, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import java.io.Serializable;

/**
 * Rectangle //ADDD (description of class)
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
public class Rectangle implements Serializable {
		
	private double height;
	private double width;
	
	public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	public double area() {
		return height * width;
	}
	
	public double perimeter() {
		return 2 * (height + width);
	}
	
	
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(3, 5);
		Serialization.SerializeToFile(rect, "rectSerialized");
	}
	
	
}
