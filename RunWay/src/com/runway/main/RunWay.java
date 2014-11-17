package com.runway.main;

class Runway{
	private  int timeForLanding;
	private  int timeForTakeoff;
	private int runwayTimeLeft; 
	private char operation; // operation can be: I - Idle, L-Landing, T-takeoff
	
	public Runnway ( int time_takeofff, int time_landing)
	{
		
	}
	//set the time for landing, time for takeoff, and the operation to idle. 
	
	public boolean isBusy() 
	{
		
	}
	
	public reduceRemainingTime()
	{
		
	}
	
	public void startUsingRunway(char typeOfUse)
	{
		
		
	}

	// if typeOfUse is 'T' - then the operation is take off  and set the runway time left 
	// to the time it takes for take off.
	// if typeOfUse is 'L' - then the operation is landing and set the runway time left 
	// to the time it takes for landing
	// if typrofUse is 'I' - then the runway is idle, set the runway time left to zero
	
	public char kindOf Operation() 
	{
		 
	}
	// returns the type of operation the runway is used for. 
	// returns  'L' if the runway is used for is landing. 
	// returns  'T' if the runway is used for taking off. 
	// returns  'I' if the runway is idle 

}

class Plane {
	static private int  planeCount = 0;       	// the plane number arrived to the queue 
	                        					// should be in incrementing order
	private int time;	                        // the time the plane arrived to the queue
	private char operation;                     // the kind of operation the plane is doing 'L" 
												// is  for landing 'T' is for taking off 
	private int planeNo;	                    // plane number
	
	public Plane( int aTime, char landingOrTakeOff)
	// operation  is the type of operation the plane is doing. 
	// If landingOrTakeOff is 'L' // it means the plane is landing, 
	// if landingOrTakeOff is 'T' it means the plane is 
	// Taking off. 
	{
		time = aTime;
		operation =  landingOrTakeOff;
	    planeNo = ++planeCount;
	}
	
	public int getTime()  
	{
		return time;
	}
	static public int getPlaneNo () 
	{ 
		return planeNo;
	}
	public char getOperation ()
	{ 
		return operation;
	}
	           
	private static int getPlaneCount()
	{
		return planeCount;
	}


}

