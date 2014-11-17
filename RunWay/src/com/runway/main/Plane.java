package com.runway.main;

/**
 * Plane is an object used to represent a
 * plane in the runway simulation.  A plane
 * is either in a takeoff or landing queue.
 * 
 * @author Ryan Hochmuth & Jason Griffith
 *
 */
public class Plane 
{
	private static int planeCount = 0;       	// The plane number arrived to the queue 
	                        					// should be in incrementing order
	
	private int time;	                        // The time the plane arrived to the queue
	
	private char operation;                     // The kind of operation the plane 
												// is doing 'L' is  for landing 'T' 
												// is for taking off 
	
	private static int planeNo;	                // Plane number
	
	// Operation  is the type of operation the plane is doing. 
	// If landingOrTakeOff is 'L' it means the plane is landing, 
	// if landingOrTakeOff is 'T' it means the plane is 
	// Taking off.
	public Plane(int aTime, char landingOrTakeOff) 
	{
		time = aTime;
		operation =  landingOrTakeOff;
	    planeNo = ++planeCount;
	}
	
	/**
	 * Get the time this plane arrived to the queue.
	 * @return time
	 */
	public int getTime()  
	{
		return time;
	}
	
	/**
	 * Get the number of this plane.
	 * @return planeNo
	 */
	public static int getPlaneNo() 
	{ 
		return planeNo;
	}
	
	/**
	 * Get the operation of this plane.
	 * L = landing
	 * T = Taking off
	 * I = idle
	 * @return operation
	 */
	public char getOperation ()
	{ 
		return operation;
	}
	
	/**
	 * Get the total number of planes in the queue.
	 * @return planeCount
	 */
	public static int getPlaneCount()
	{
		return planeCount;
	}
}