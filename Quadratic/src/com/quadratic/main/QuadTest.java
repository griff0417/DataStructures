package com.quadratic.main;

import java.util.ArrayList;
import java.util.List;

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
	private static Quadratic quad1;
	private static Quadratic quad2;
	// quad3 is the sum of quad1 and quad2
	private static Quadratic quad3;
	
	private static List<String> tokenList = new ArrayList<String>();
	
	private static boolean done = false;
	
	/**
	 * Gives a description of what
	 * the program is doing.
	 */
	public void intro()
	{
		
	}
	
	/**
	 * 
	 * Does the required calculation, 
	 * creates a clone of the first quadratic,
	 * checks if they are aliases, then checks 
	 * if the two quadratics have the same coefficients. 
	 */
	public static void calculations()
	{
		
		quad3 = Quadratic.sum(quad1,quad2);
		
		while (true) //for print testing  TO BE REMOVED
		{
			if (done)//for print testing  TO BE REMOVED
			{
				for (int x = 0; x < tokenList.size() / 8; x++)//for print testing  TO BE REMOVED
				{
					
					System.out.println(tokenList.get((x * 8)) + " " +//for print testing  TO BE REMOVED
									   tokenList.get((x * 8) + 1) + " " +//for print testing  TO BE REMOVED
									   tokenList.get((x * 8) + 2) + " " +//for print testing  TO BE REMOVED
									   tokenList.get((x * 8) + 3) + " " +//for print testing  TO BE REMOVED
									   tokenList.get((x * 8) + 4) + " " +//for print testing  TO BE REMOVED
									   tokenList.get((x * 8) + 5) + " " +//for print testing  TO BE REMOVED
									   tokenList.get((x * 8) + 6) + " " +//for print testing  TO BE REMOVED
									   tokenList.get((x * 8) + 7));
					
				}
				
				done = false;//for print testing  TO BE REMOVED
			}
		}
	}
	
	/**
	 * Parses a String line into
	 * Separate tokens.
	 * @param line - The input String
	 */
	public static void parse(String line)
	{
		String[] tokens = line.split("\\s+"); //Splits line by consecutive tokens " "
		
		if (tokens.length<8){ //Returns before recording bad entries in List
			return;
		}
		for(int x = 0; x < 8; x++)
		{
			switch (x){
				case 0:
					quad1.setCoefA((double)
			}
			tokenList.add(tokens[x]);
		
		}

		done = true;//for print testing  TO BE REMOVED
	}
	
	/**
	 * Create the output of information
	 * generated by this program.
	 */
	public void output()
	{
		
	}
}
