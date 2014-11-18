package com.runway.main;

/**
 * Lab 4 is the main driver class for the runway program.
 * @author Ryan Hochmuth & Jason Griffith
 *
 */

public class Lab4 
{
	private static final int runtime = 1800;
	private static final double probTakeoff = .07;
	private static final double probLanding = .05;
	private static final int timeForTakeoff = 120;
	private static final int timeForLanding = 180;

	/**
	 * The main method to start the program.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Runway.simulateRunway(runtime, probTakeoff, probLanding,timeForTakeoff,timeForLanding);
	}
}
