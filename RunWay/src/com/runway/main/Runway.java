package com.runway.main;

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
	
	public boolean isBusy() 
	{
		return false;
	}
	
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
}
