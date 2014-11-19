package com.runway.main;

/**
 * Lab 4 is the main driver class for the runway program.
 * @author Ryan Hochmuth & Jason Griffith
 *
 */

public class Lab4 
{
	// Simulation constants in minutes
	private static final int RUNTIME = 30;
	private static final double PROB_TAKEOFF = 3;
	private static final double PROB_LANDING = 2;
	private static final int TIME_FOR_TAKEOFF = 2;
	private static final int TIME_FOR_LANDING = 3;
	private static final int MAX_TIME_IN_DA_AIR = 9;

	/**
	 * The main method to start the program.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Runway.simulateRunway(RUNTIME, 
				1 / (double)PROB_TAKEOFF, 
				1 / (double)PROB_LANDING,
				TIME_FOR_TAKEOFF,
				TIME_FOR_LANDING,
				MAX_TIME_IN_DA_AIR);
		
	}
}
