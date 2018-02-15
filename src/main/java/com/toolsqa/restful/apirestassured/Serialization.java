/**
 *   File Name: Serialization.java<br>
 *
 *   Yutaka<br>
 *   Created: Feb 8, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Serialization //ADDD (description of class)
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
public class Serialization {
	
	public static void SerializeToFile(Object classObject, String fileName) {
		try {
			FileOutputStream fileStream = new FileOutputStream(fileName);
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
			objectStream.writeObject(classObject);
			objectStream.close();
			fileStream.close();
			
			
		} catch(FileNotFoundException e) {
			System.out.println("File " + fileName + " not found.");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("IO error");
			e.printStackTrace();
			}
		} 
	


}