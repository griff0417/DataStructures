package com.runway.main;

/**
 * The runway class simulates an airport runway.  It
 * handles planes waiting to take off and land in
 * separate queues.
 * 
 * @author Jason Griffith & Ryan Hochmuth
 *
 */
public class Runway
{
	private int timeForLanding;
	private int timeForTakeoff;
	private int runwayTimeLeft; 
	private char operation; // Operation can be: I - Idle, L-Landing, T-takeoff
	
	private ObjectLinkedQueue takeoffQ = new ObjectLinkedQueue();
	private ObjectLinkedQueue landingQ = new ObjectLinkedQueue();
	
	// Set the time for landing, time for takeoff, and the operation to idle. 
	public Runway(int timeTakeoff, int timeLanding)
	{
		timeForTakeoff = timeTakeoff;
		timeForLanding = timeLanding;
		operation = 'I';
	}
	
	/**
	 * Is the runway currently busy.
	 * ie. Is there a plane currently landing
	 * or taking off.
	 * @return boolean
	 */
	public boolean isBusy() 
	{
		return false;
	}
	
	/**
	 * Reduce the time remaining in the simulation.
	 */
	public void reduceRemainingTime()
	{
		
	}
	
	/**
	 * Start the runway simulation.
	 * if typeOfUse is 'T' - then the operation is take off  and set the runway time left 
	 * to the time it takes for take off.
	 * if typeOfUse is 'L' - then the operation is landing and set the runway time left 
	 * to the time it takes for landing
	 * if typrofUse is 'I' - then the runway is idle, set the runway time left to zero
	 * @param typeOfUse
	 */
	public void startUsingRunway(char typeOfUse)
	{
			
	}

	/**
	 * Returns the type of operation the runway is used for. 
	 * returns  'L' if the runway is used for is landing. 
	 * returns  'T' if the runway is used for taking off. 
	 * returns  'I' if the runway is idle.
	 * @return operation
	 */
	public char kindOfOperation() 
	{
		return operation;
		 
	}
	
	public static void simulateRunway(int runtime, double probTakeoff, double probLanding,)
}
