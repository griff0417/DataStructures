/**
 * 
 */
package com.quadratic.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The "driver" class for this program.
 * Contains the main method to start the program
 * and interact with the Quadratic and QuadTest classes.
 * 
 * Date: 9-22-14
 * 
 * @author Jason Griffith & Ryan Hochmuth
 *
 */
public class Lab1 
{
	/********************
	 * Input Variables
	 *******************/
	private static Scanner scanner;
	
	/**
	 * Initializes the necessary objects
	 * used in this class.
	 */
	private static void init()
	{
		
		// Attempt to create the scanner by finding the input File
		try 
		{
			scanner = new Scanner(new File("src/inputCoef.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * The main method to start the program.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		init(); // Run the init method
		
		// Read through the input file while
		// there is still information in it
		while(scanner.hasNextLine())
		{
			QuadTest.parse(scanner.nextLine());
		}
		
		
	}
}
