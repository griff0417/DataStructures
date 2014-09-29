package com.quadratic.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class used to test the
 * functionality of the Quadratic class.
 * 
 * Date: 9-22-14
 * 
 * @author Ryan Hochmuth & Jason Griffith
 *
 */
public class QuadTest 
{
	/***********************
	 * Quadratics
	 **********************/
	private static Quadratic quad1 = new Quadratic();
	private static Quadratic quad2 = new Quadratic();
	// quad3 is the sum of quad1 and quad2
	private static Quadratic quad3 = new Quadratic();
	
	/***********************
	 * Output Variables
	 **********************/
	private static int testNum = 0;
	private static String output = "";
	
	/**
	 * Gives a description of what
	 * the program is doing.
	 */
	public static void intro()
	{
		System.out.println("This program is used to read data "
						   + "from a text file and use that data "
						   + "to create new Quadratics, then do "
						   + "various calculations with them.\n\n");
	}
	
	/**
	 * Does the required calculation, 
	 * creates a clone of the first quadratic,
	 * checks if they are aliases, then checks 
	 * if the two quadratics have the same coefficients. 
	 */
	public static void calculations(double xVal, double scale, boolean wrongInput)
	{
		// Do calculations and set up the output
		if (!wrongInput)
		{
			output += "*************************************************************"
					+ "\n"
					+ "Test # " + testNum
					+ "\n"
					+ "-----------"
					+ "\n\n"
					+ "The first quadratic is: " + quad1.toString()
					+ "\n\n"
					+ "The value of the first quadratic expression when x = " + xVal + " is: " + (int)quad1.evalExpression(xVal)
					+ "\n\n"
					+ "The first quadratic after scaling with a multiplier of " + scale + " is: " + Quadratic.scale(scale, quad1).toString()
					+ "\n\n";
					 
			switch ((int)quad1.getRootNum()){
				
				case 0:
					output += "The number of roots for the first quadratic is: 0";
					break;
					
				case 1:
					output += "The number of roots for the first quadratic is: "+(int)quad1.getRootNum()
					+ "\nThe value of the root is: "
					+ "\n"
					+ "\tValue of root 1: " + (int)quad1.getRootOne();
					break;
					
				case 3:
					output += "The number of roots for the first quadratic is infinite.";
					break;
					
				default:
					output += "The number of roots for the first quadratic is: "+(int)quad1.getRootNum()
							+ "\nThe values of those roots are: "
							+ "\n"
							+ "\tValue of root 1: " + (int)quad1.getRootOne()
							+ "\n"
							+ "\tValue of root 2: " + (int)quad1.getRootTwo();
					break;
					
			}
			output += "\n\n"
					+ "The second quadratic is: " + quad2.toString()
					+ "\n\n"
					+ "The quadratic which is the sum of the first and the second quadratics is: " + quad3.toString()
					+ "\n\n"
					+ "A clone of the first quadratic is: " + quad1.clone(quad1).toString()
					+ "\n\n";
		
			if (quad1.equals(quad1.clone(quad1)))
				output += "The first quadratic and the clone are not aliases, but are equal to each other."
						+ "\n\n";
			else
				output += "The first quadratic and the clone are not aliases, and are not equal to each other."
						+ "\n\n";
		}
		else
		{
			output += "*************************************************************"
					+ "\n"
					+ "Test # " + testNum
					+ "\n"
					+ "-----------"
					+ "\n\n"
					+ "Improper data entered for this test."
					+ "\n\n";
		}
	}
	
	
	/**
	 * Parses a String line into
	 * Separate tokens.
	 * @param line - The input String
	 */
	public static void parse(String line)
	{
		double xVal = 0.0;
		double scale = 0.0;
		
		String[] tokens = line.split("\\s+"); // Splits line by consecutive spaces
		
		testNum++; // Increment the number of tests (used for output)
		
		if (tokens.length != 8) // Returns if input line has too few digits
		{
			calculations(xVal, scale, true); // Run the calculations method
			return;
		}
		
		// Increment through all 8 input digits
		for(int x = 0; x < 8; x++)
		{
			try
			{
				// Depending on which input character is being
				// processed, set the values for the quadratics
				switch (x)
				{
					case 0:
						quad1.setCoefA(Double.parseDouble(tokens[x]));
						break;
					case 1:
						quad1.setCoefB(Double.parseDouble(tokens[x]));
						break;
					case 2:
						quad1.setCoefC(Double.parseDouble(tokens[x]));
						break;
					case 3:
						xVal= Double.parseDouble(tokens[x]);
						break;
					case 4:
						scale= Double.parseDouble(tokens[x]);
						break;
					case 5:
						quad2.setCoefA(Double.parseDouble(tokens[x]));
						break;
					case 6:
						quad2.setCoefB(Double.parseDouble(tokens[x]));
						break;
					case 7:
						quad2.setCoefC(Double.parseDouble(tokens[x]));
						break;
				} // End switch
			} // End try
			catch (NumberFormatException e) 
			{
			    e.printStackTrace();
			    
			    calculations(xVal, scale, true); // Run the calculations method
				return;
			}
		} // End for loop
		
		// Set quad3 to the sum of quad1 and quad2
		quad3 = Quadratic.sum(quad1, quad2);
		
		calculations(xVal, scale, false); // Run the calculations method
	}
	
	/**
	 * Create the output of information
	 * generated by this program.
	 */
	public static void output()
	{
		// The BufferedWrite to write the text file
		BufferedWriter writer = null;
		// The file to write to
		File outputFile = new File("src/output.txt");
		
		// Attempt to write to the file
		try 
		{
			// Pair the BufferedWriter with the proper file
			writer = new BufferedWriter(new FileWriter(outputFile));
			
			// Write the prepared output String to the file
			writer.write(output);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
            try 
            {
                // Close the BufferedWriter
                writer.close();
            } 
            catch(Exception e) 
            {
            	e.printStackTrace();
            }
		}
	}
}
