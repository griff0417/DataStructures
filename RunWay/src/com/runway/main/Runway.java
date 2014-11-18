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
	
	public static void simulateRunway(int runtime, double probTakeoff, double probLanding, int timeForTakeoff, int timeForLanding)
	{
		if (runtime < 0 || probTakeoff > 1 || probLanding > 1 || timeForTakeoff <=0 || timeForLanding <=0)
		{
			throw new IllegalArgumentException("Values out of range");
		}
		
		ObjectLinkedQueue takeoffQ = new ObjectLinkedQueue();
		ObjectLinkedQueue landingQ = new ObjectLinkedQueue();
		ObjectLinkedStack crashStack = new ObjectLinkedStack();
		BooleanSource boolTakeoff = new BooleanSource(probTakeoff);
		BooleanSource boolLanding = new BooleanSource(probLanding);
		Runway runway = new Runway(timeForTakeoff , timeForLanding);
		Plane currentPlane;
		Plane newTakeoff;
		Plane newLanding;
		Averager avgTakeoff = new Averager();
		Averager avgLanding = new Averager();
		Averager avgNewTakeoff = new Averager();
		Averager avgNewLanding = new Averager();
		int lastArrivedTakeoff = 0;
		int lastArrivedLanding = 0;
		int maxTimeInDaAir = 540;
		int currentSecond = 0;
		int currentMin = 0;
		int next;
		int takeoffCount = 0;
		int landCount = 0;
		String descString = "";
		
		System.out.println("Total time of simulation: "+runtime/60+" minutes.");
		System.out.println("");
		System.out.println("The amount of time that is needed for one plane to take off is: "+timeForTakeoff/60+" minutes.");
		System.out.println("The amount of time that is needed for one plane to land is: "+timeForLanding/60+" minutes.");
		System.out.println("The maximum time a plane can stay in the landing queue before crashing is: " 
				+ (int)(maxTimeInDaAir / 60) + " minutes.");
		System.out.println("");
		
		for (currentSecond = 0; currentSecond < runtime; currentSecond++)
		{
			currentPlane = null;
			newTakeoff = null;
			newLanding = null;
			
			if ((currentSecond % 60) == 0)
			{
				currentMin++;
				
				if (boolTakeoff.query())
				{
					newTakeoff = new Plane(currentSecond, 'T');
					takeoffQ.insert(newTakeoff);
					
					avgNewTakeoff.addNumber(currentSecond - lastArrivedTakeoff);
					lastArrivedTakeoff = currentSecond;
				}
				
				if (boolLanding.query())
				{
					newLanding = new Plane (currentSecond, 'L');
					landingQ.insert(newLanding);
					
					avgNewLanding.addNumber(currentSecond - lastArrivedLanding);
					lastArrivedLanding = currentSecond;
				}
			}
			
			if (!runway.isBusy() && (!takeoffQ.isEmpty() || !landingQ.isEmpty()))
			{
				if (!landingQ.isEmpty())
				{
					currentPlane = (Plane)landingQ.getFront();
					next = currentPlane.getTime();
					avgLanding.addNumber(currentSecond - next);
					
					if ((currentSecond - currentPlane.getTime()) >= maxTimeInDaAir)
					{
						crashStack.push(currentPlane);
					}
					else
					{
						runway.startUsingRunway('L');
						landCount++;
					}
				}
				else if (!takeoffQ.isEmpty())
				{
					currentPlane = (Plane)takeoffQ.getFront();
					next = currentPlane.getTime();
					avgTakeoff.addNumber(currentSecond - next);
					
					runway.startUsingRunway('T');
					takeoffCount++;
				}
			}
			else if (!runway.isBusy() && takeoffQ.isEmpty() &&  landingQ.isEmpty())
				runway.startUsingRunway('I');
			
			if ((currentSecond % 60) == 0)
			{
				descString 
				+= "Minute " + currentMin + ":\n";
				
				descString
				+= "\tArrived for Takeoff: ";
				
				if (newTakeoff != null)
					descString
					+= "Plane #" + newTakeoff.getPlaneNo();
				else
					descString
					+= "None";
				
				descString += "\n";
				
				descString
				+= "\tArrived for Landing: ";
				
				if (newLanding != null)
					descString
					+= "Plane #" + newLanding.getPlaneNo();
				else
					descString
					+= "None";
				
				descString += "\n";
				
				switch(runway.kindOfOperation())
				{
					case 'T':
						descString
						+= "\tRunway: "
						+ "Plane #" + currentPlane.getPlaneNo()
						+ " is taking off.";
						break;
						
					case 'L':
						descString
						+= "\tRunway: "
						+ "Plane #" + currentPlane.getPlaneNo()
						+ " is landing.";
						break;
						
					case 'I':
						descString
						+= "\tRunway: Idle";
						break;
				}
				
				descString += "\n\n";
			}
			
			runway.reduceRemainingTime();
		}
		
		System.out.println("The average amount of time between arrival of planes to the takeoff queue is: " 
				+ (int)(avgNewTakeoff.average() / 60) + " minutes.");
		System.out.println("The average amount of time between arrival of panes to the landing queue is: " 
				+ (int)(avgNewLanding.average() / 60) + " minutes.");
		System.out.println("The average time a plane spent on the takeoff queue is: "
				+ (int)(avgTakeoff.average() / 60) + " minutes.");
		System.out.println("The average time a plane spent on the landing queue is: "
				+ (int)(avgLanding.average() / 60) + " minutes.");
		System.out.println("");
		System.out.println("Number of planes that came to the runway for takeoff: " + avgNewTakeoff.howManyNumbers());
		System.out.println("Number of planes that came to the runway for landing: " + avgNewLanding.howManyNumbers());
		System.out.println("");
		System.out.println("Number of planes that took off: " + takeoffCount);
		System.out.println("Number of planes that landed: " + landCount);
		System.out.println("Number of planes that crashed: " + crashStack.size());
		System.out.println("");
		System.out.println(descString);
	}
}
