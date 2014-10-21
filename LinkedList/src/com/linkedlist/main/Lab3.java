package com.linkedlist.main;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Lab2.java
 * 
 * @author Ryan Hochmuth & Jason Griffith
 * 
 * Description:
 * 	Lab2 is the driver class to run SequenceTest and 
 *  use DoubleArraySeq.  It takes input through a text
 *  file and sends the data to SequenceTest.menu()
 *
 */
public class Lab3
{
	// The scanner to read from the text file
	private static Scanner scanner;
	
	/**
	 * The main method to start the program.
	 * @param args
	 */
	public static void main(String args[])
	{
		SequenceTest seqTest = new SequenceTest();

		// Attempt to create the scanner by finding the input File
		try 
		{
			scanner = new Scanner(new File("src/Lab3.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		// Read through the input file while
		// there is still information in it
		while(scanner.hasNextLine())
		{
			seqTest.menu(scanner.nextLine());
		}
	}
}