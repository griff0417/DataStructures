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
	private static final double PROB_TAKEOFF = 7;
	private static final double PROB_LANDING = 5;
	private static final int TIME_FOR_TAKEOFF = 2;
	private static final int TIME_FOR_LANDING = 3;
	private static final int MAX_TIME_IN_DA_AIR = 1;

	/**
	 * The main method to start the program.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Runway.simulateRunway(RUNTIME, 
				(double)PROB_TAKEOFF / (double)RUNTIME, 
				(double)PROB_LANDING / (double)RUNTIME,
				TIME_FOR_TAKEOFF,
				TIME_FOR_LANDING,
				MAX_TIME_IN_DA_AIR);
	}
}
