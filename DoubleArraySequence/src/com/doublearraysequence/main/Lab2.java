package com.doublearraysequence.main;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Lab2
{
	private static Scanner scanner;
	public static void main(String args[]){
		
		SequenceTest seqTest = new SequenceTest();
		//testing.menu();

		// Attempt to create the scanner by finding the input File
		try 
		{
			scanner = new Scanner(new File("src/test.txt"));
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
	
