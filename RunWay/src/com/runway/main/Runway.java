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
	private int runwayTimeLeft = 0; 
	private char operation; // Operation can be: I - Idle, L-Landing, T-takeoff
	private String descString = "";

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
		return runwayTimeLeft > 0;
	}
	
	/**
	 * Reduce the time remaining in the simulation.
	 */
	public void reduceRemainingTime()
	{
		if (runwayTimeLeft > 0 )
		{
			runwayTimeLeft --;
		}
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
		if (isBusy())
		{
			throw new IllegalStateException("Runway is already busy!");
		}
		else
		{
			operation = typeOfUse;
			
			switch (typeOfUse)
			{
				case 'T':
					runwayTimeLeft = timeForTakeoff;
					break;
					
				case 'L':
					runwayTimeLeft = timeForLanding;
					break;
					
				case 'I':
					runwayTimeLeft = 0;
					break;
			}
		}
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
	
	/**
	 * Simulate the runway.
	 * @param runtime
	 * @param probTakeoff
	 * @param probLanding
	 * @param timeForTakeoff
	 * @param timeForLanding
	 */
	public static void simulateRunway(int runtime, double probTakeoff, 
			double probLanding, int timeForTakeoff, int timeForLanding,
			int maxTimeInDaAir)
	{
		// Check to see if the given parameters are valid
		if (runtime < 0 || probTakeoff > 1 || probLanding > 1 || timeForTakeoff <=0 || timeForLanding <=0)
		{
			throw new IllegalArgumentException("Values out of range");
		}
		
		// The runway object
		Runway runway = new Runway(timeForTakeoff , timeForLanding);
		
		// The data structures used for the runway
		ObjectLinkedQueue takeoffQ = new ObjectLinkedQueue();
		ObjectLinkedQueue landingQ = new ObjectLinkedQueue();
		ObjectLinkedStack crashStack = new ObjectLinkedStack();
		
		// Boolean generators to determine plane arrivals
		BooleanSource boolTakeoff = new BooleanSource(probTakeoff);
		BooleanSource boolLanding = new BooleanSource(probLanding);
		
		// Planes used to hold the place of a plane in use
		Plane currentPlane = null;
		Plane newTakeoff = null;
		Plane newLanding = null;
		
		// Averagers to track runway usage statistics
		Averager avgTakeoff = new Averager();
		Averager avgLanding = new Averager();
		Averager avgNewTakeoff = new Averager();
		Averager avgNewLanding = new Averager();
		
		int lastArrivedTakeoff = 0; // The second the last plane 
									// arrived to takeoff
		int lastArrivedLanding = 0; // The second the last plane 
									// arrived to land
		int currentSecond = 0;		// The exact second that the simulator is on
		int currentMin = 0;			// The exact minute that the simulator is on
		int next;					// Used to track time in a queue
		int takeoffCount = 0;		// The total number of planes that took off
		int landCount = 0;			// The total number of planes that landed
		
		/*
		 * Format the output displaying the constants
		 */
		System.out.println("Total time of simulation: " + runtime + " minutes.");
		System.out.println("");
		System.out.println("The amount of time that is needed for one plane to take off is: "
				+ timeForTakeoff + " minutes.");
		System.out.println("The amount of time that is needed for one plane to land is: "
				+ timeForLanding + " minutes.");
		System.out.println("The maximum time a plane can stay in the landing queue before crashing is: " 
				+ (int)(maxTimeInDaAir) + " minutes.");
		System.out.println("");
		
		// Loop to simulate the entire runtime one second at a time
		for (currentSecond = 0; currentSecond < runtime; currentSecond++)
		{
			if (boolTakeoff.query()) // If a plane arrives to takeoff
			{
				newTakeoff = new Plane(currentSecond, 'T');
				takeoffQ.insert(newTakeoff); // Add the new plane to the queue
				
				avgNewTakeoff.addNumber(currentSecond - lastArrivedTakeoff);
				lastArrivedTakeoff = currentSecond;
			}
			
			if (boolLanding.query()) // If a plane arrives to land
			{
				newLanding = new Plane (currentSecond, 'L');
				landingQ.insert(newLanding); // Add the new plane to the queue
				
				avgNewLanding.addNumber(currentSecond - lastArrivedLanding);
				lastArrivedLanding = currentSecond;
			}
			
			// Check to see if the runway isn't busy, and either the takeoff
			// or landing queue is not empty.
			if (!runway.isBusy() && (!takeoffQ.isEmpty() || !landingQ.isEmpty()))
			{
				// If the landing queue is empty,
				// allow a plane to take off.
				if (landingQ.isEmpty())
				{
					currentPlane = (Plane)takeoffQ.getFront();
					next = currentPlane.getTime();
					avgTakeoff.addNumber(currentSecond - next);
					
					runway.startUsingRunway('T');
					takeoffCount++;
				}
				// If there is a plane in the landing queue,
				// it takes priority and is allowed to land.
				else
				{
					currentPlane = (Plane)landingQ.getFront();
					next = currentPlane.getTime();
					
					// If the next landing plane isn't out of fuel,
					// let it land.
					if ((currentSecond - next) <= maxTimeInDaAir)
					{
						runway.startUsingRunway('L');
						avgLanding.addNumber(currentSecond - next);
						landCount++;
					}
					// If the next plane has been in the air too long,
					// it has crashed.
					else
					{
						crashStack.push(new Plane(currentSecond, currentPlane.getOperation()));
						
						// After the plane has crashed,
						// check if another is available to land.
						if(!landingQ.isEmpty())
			            {
							currentPlane = (Plane)landingQ.getFront();
							next = currentPlane.getTime();
							runway.startUsingRunway('L');
							avgLanding.addNumber(currentSecond - next);
							landCount++;
			            }
					}
				}
			}
			// Check to see if the runway isn't busy and both queues are empty.
			// If so, the runway is idle.
			else if (!runway.isBusy() && takeoffQ.isEmpty() &&  landingQ.isEmpty())
				runway.startUsingRunway('I');
			
			currentMin++;
			
			// Form this minute's specific output
			printTimeUnit(runway, currentPlane, newTakeoff, newLanding, currentMin);
			
			newTakeoff = null;
			newLanding = null;
			
			runway.reduceRemainingTime();
		}
		
		// After the simulation, print the remaining information
		System.out.println("The average amount of time between arrival of planes to the takeoff queue is: " 
				+ (int)(avgNewTakeoff.average()) + " minutes.");
		System.out.println("The average amount of time between arrival of panes to the landing queue is: " 
				+ (int)(avgNewLanding.average()) + " minutes.");
		System.out.println("The average time a plane spent on the takeoff queue is: "
				+ (int)(avgTakeoff.average()) + " minutes.");
		System.out.println("The average time a plane spent on the landing queue is: "
				+ (int)(avgLanding.average()) + " minutes.");
		System.out.println("");
		System.out.println("Number of planes that came to the runway for takeoff: " 
				+ avgNewTakeoff.howManyNumbers());
		System.out.println("Number of planes that came to the runway for landing: " 
				+ avgNewLanding.howManyNumbers());
		System.out.println("");
		System.out.println("Number of planes that took off: " + takeoffCount);
		System.out.println("Number of planes that landed: " + landCount);
		System.out.println("Number of planes that crashed: " + crashStack.size());
		System.out.println("");
		
		printCrashedPlanes(runway, crashStack);
		
		// Output the minute by minute breakdown
		System.out.println(runway.descString);
	}
	
	/**
	 * Format an output for a specific minute of the simulation.
	 * @param runway
	 * @param currentPlane
	 * @param newTakeoff
	 * @param newLanding
	 * @param currentMin
	 */
	public static void printTimeUnit(Runway runway, Plane currentPlane, Plane newTakeoff,
			Plane newLanding, int currentMin)
	{
		runway.descString 
		+= "Minute " + currentMin + ":\n";
		
		runway.descString
		+= "\tArrived for Takeoff: ";
		
		if (newTakeoff != null)
			runway.descString
			+= "Plane #" + newTakeoff.getPlaneNo();
		else
			runway.descString
			+= "None";
		
		runway.descString += "\n";
		
		runway.descString
		+= "\tArrived for Landing: ";
		
		if (newLanding != null)
			runway.descString
			+= "Plane #" + newLanding.getPlaneNo();
		else
			runway.descString
			+= "None";
		
		runway.descString += "\n";
		
		switch(runway.kindOfOperation())
		{
			case 'T':
				runway.descString
				+= "\tRunway: "
				+ "Plane #" + currentPlane.getPlaneNo()
				+ " is taking off.";
				break;
				
			case 'L':
				runway.descString
				+= "\tRunway: "
				+ "Plane #" + currentPlane.getPlaneNo()
				+ " is landing.";
				break;
				
			case 'I':
				runway.descString
				+= "\tRunway: Idle";
				break;
		}
		
		runway.descString += "\n\n";
	}
	
	/**
	 * Form the output report for the crashed planes.
	 * @param runway
	 * @param crashStack
	 */
	public static void printCrashedPlanes(Runway runway, ObjectLinkedStack crashStack)
	{
		if (!crashStack.isEmpty()) // If planes crashed during the simulation
		{
			runway.descString
			+= "Crashed Planes: \n";
			
			// Iterate through every crashed plane
			for(int x = crashStack.size(); x > 0; x--)
			{
				Plane plane = (Plane)crashStack.pop();
				
				runway.descString
				+= "Plane #" + plane.getPlaneNo()
				+ " crashed at minute "
				+ plane.getTime() + "\n";
			}
		}
		else // If no planes crashed during the simulation
		{
			runway.descString
			+= "No planes crashed during the simulation!\n";
		}
	}
}