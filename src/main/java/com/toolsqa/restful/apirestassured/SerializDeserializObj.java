/**
 *   File Name: SerializDeserializObj.java<br>
 *
 *   Yutaka<br>
 *   Created: Feb 9, 2018
 *   
 */

package com.toolsqa.restful.apirestassured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * SerializDeserializObj //ADDD (description of class)
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
public class SerializDeserializObj {
	
	public static void SerializeObjectToFile(Object classObject, String fileName) {
		try {
			FileOutputStream fileStream = new FileOutputStream(fileName);
			ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
			objectStream.writeObject(classObject);
			objectStream.close();
			fileStream.close();
		} catch(FileNotFoundException e) {
			System.out.println("file " + fileName + " not found");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("IO error");
			e.printStackTrace();
		}
	}
	
	public static Object deSerializeObjectFromFile(String fileName) {
		try {
			FileInputStream fileStream = new FileInputStream(fileName);
			ObjectInputStream objectStream = new ObjectInputStream(fileStream);
			Object deserializeObject = objectStream.readObject();
			objectStream.close();
			fileStream.close();
		} catch(FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch(IOException e) {
			System.out.println("IO error");
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		}
		return null;
	}
	
}
