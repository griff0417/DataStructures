package com.doublearraysequence.main;

/**
 * SequenceTest.java
 * 
 * @author Ryan Hochmuth & Jason Griffith
 * 
 * Description:
 * 	SequenceTest is a class used to test the functionality
 * of DoubleArraySeq.
 *
 */
public class SequenceTest
{
	DoubleArraySeq sq1 = null;
	DoubleArraySeq sq2 = null;
	DoubleArraySeq sq3 = null;
	
	DoubleArraySeq currentSeq = null;
	
	final String [] MENU_CHOICE = {"",
							"Create a sequence","Delete a number",
							"Delete the first number from the sequence",
							"Add a number before another number",
							"Add a number after a number",
							"Add a number to the end of the sequence",
							"Display a number at a certain index",
							"Display the last element in the sequence",
							"Replace a number with another number",
							"Append another sequence to the first sequence",
							"Create a clone sequence",
							"Print the sequence",
							"Quit"};
	
	
	private int findIndex(double element){
		int index = 0;
		for (currentSeq.start();currentSeq.isCurrent();currentSeq.advance()){
			index++;
			if (currentSeq.getCurrent()==element)
				return index;
		
		}
		return -1;
	}
	
	private DoubleArraySeq createSequence(double [] doubleTokens)
	{
		if (sq1 == null && sq2 == null)
		{
			sq1 = new DoubleArraySeq(doubleTokens.length - 1);
			return sq1;
		}
		else if (sq1 != null && sq2 == null)
		{
			sq2 = new DoubleArraySeq(doubleTokens.length - 1);
			return sq2;
		}
		else
		{
			return sq1;
		}
	}
	
	public void menu (String line)
	{
		String[] tokens = line.split("[\\s\\,\\-]+");
		double [] doubleTokensArray = new double[tokens.length];
		for(int a=0;a<tokens.length;a++){
			try{
				doubleTokensArray[a] = Double.parseDouble(tokens[a]);
				
			}
			catch (NumberFormatException e) 
			{
			    e.printStackTrace();
			    System.out.println("Invalid char on line");
			    return;
			}
		}

		if (doubleTokensArray[0]==3 || doubleTokensArray[0]==8 || doubleTokensArray[0]==10 ||
			doubleTokensArray[0]==11){
			switch((int)doubleTokensArray[0]){
				case 3:
					currentSeq.removeFromFront();
					printOutput(line, doubleTokensArray, false, "");
					break;
					
				case 8:
					printOutput(line, doubleTokensArray, false, "");
					break;
					
				case 10:
					sq1.addAll(sq2);
					currentSeq = sq1;
					printOutput(line, doubleTokensArray, false, "");
					break;
					
				case 11:
					if (sq1 != null)
					{
						sq3 = sq1.clone();
						currentSeq = sq3;
						printOutput(line, doubleTokensArray, false, "");
					}
					else
						printOutput(line, doubleTokensArray, true, "Sequence 1 has not been initialized.");
					break;
			}
		}
			
		else if (doubleTokensArray.length > 1)
		{
			switch((int)doubleTokensArray[0])
			{
				default:
					break;
					
				case 1:
					currentSeq = createSequence(doubleTokensArray);
					
					for (int b = 1; b < doubleTokensArray.length; b++)
					{
						currentSeq.addAfter(doubleTokensArray[b]);
					}
					printOutput(line, doubleTokensArray, false, "");
					break;
					
				case 2:
					if (findIndex(doubleTokensArray[1]) != -1)
					{
						currentSeq.start();
						for(int b = 0;b!=findIndex(doubleTokensArray[1]);b++){
							currentSeq.advance();
							
						}
						currentSeq.removeCurrent();
						printOutput(line,doubleTokensArray,false, "");
					}
					else
						printOutput(line,doubleTokensArray,true, "Exception - Number not found.");
					
					break;
				
				case 4:
					if (findIndex(doubleTokensArray[2]) != -1)
					{
						currentSeq.start();
						for(int b = 0;b!=findIndex(doubleTokensArray[2]);b++){
							currentSeq.advance();
							
						}
						currentSeq.addBefore(doubleTokensArray[1]);
						printOutput(line,doubleTokensArray,false, "Exception - Number not found.");
					}
					else
						printOutput(line,doubleTokensArray,true, "Exception - Number not found.");
						
					break;
				case 5:
					if (findIndex(doubleTokensArray[2]) != -1)
					{
						currentSeq.start();
						for(int b = 0;b!=findIndex(doubleTokensArray[2]);b++){
							currentSeq.advance();
							
						}
						currentSeq.addAfter(doubleTokensArray[1]);
						printOutput(line,doubleTokensArray,false, "Exception - Number not found.");
					}
					else
						printOutput(line,doubleTokensArray,true, "Exception - Number not found.");
					break;
					
				case 6:
					currentSeq.addToEnd(doubleTokensArray[1]);
					printOutput(line,doubleTokensArray,false, "");
					break;
					
				case 7:
					currentSeq.getElement((int)doubleTokensArray[1]);
					printOutput(line,doubleTokensArray,false, "");
					break;
				
				case 9:
					if (findIndex(doubleTokensArray[1]) != -1)
					{
						currentSeq.changeElementAtIndex(findIndex(doubleTokensArray[1]) - 1, doubleTokensArray[2]);
						printOutput(line, doubleTokensArray, false, "");
					}
					else
						printOutput(line, doubleTokensArray, true, "Exception - Number not found.");
					break;
			
				case 12:
					switch ((int)doubleTokensArray[1])
					{
						case 1:
							currentSeq = sq1;
							printOutput(line, doubleTokensArray, false, "");
							break;
							
						case 2:
							currentSeq = sq2;
							printOutput(line, doubleTokensArray, false, "");
							break;
							
						case 3:
							currentSeq = sq3;
							printOutput(line, doubleTokensArray, false, "");
							break;
							
						default:
							printOutput(line, doubleTokensArray, true, "Sequence does not exist.");
							break;
					}
					break;
					
				case 13:
					
					break;
			}
		}
		
		else
		{
			printOutput(line,doubleTokensArray,true, "Exception - No data was created.");
		}
	}
	
	public void printSequence(DoubleArraySeq seq,double [] doubleTokensArray)
	{
		switch((int)doubleTokensArray[0])
		{
			case 2:
				System.out.println("Deleted "+doubleTokensArray[1]+" from the sequence.");
				
				break;
			case 4:
				System.out.println("Added element "+(int)doubleTokensArray[1]+" before "+(int)doubleTokensArray[2]);
				
				break;
			case 5:
				System.out.println("Added element "+(int)doubleTokensArray[1]+" after "+(int)doubleTokensArray[2]);
				
				break;
			case 6:
				System.out.println("Added element "+(int)doubleTokensArray[1]+" to end of sequence");
				
				break;
			case 7:
				System.out.println("Number "+currentSeq.getElement((int)doubleTokensArray[1])+" is at index location "+((int)doubleTokensArray[1]));
				break;

			case 8:
				System.out.println("The last element in the sequence is " + currentSeq.getElement(currentSeq.size() - 1));
				break;
				
			case 9:
				System.out.println("Replaced "+(int)doubleTokensArray[1]+" with "+(int)doubleTokensArray[2]);
				break;
		}
		
		double currentElement = currentSeq.getCurrent();
		String output = "";
		for (currentSeq.start();currentSeq.isCurrent();currentSeq.advance())
		{
			output += currentSeq.getCurrent()+" ";
		}
		
		if (currentSeq == sq1)
			System.out.println("The Sequence #1: " + output);
		else if (currentSeq == sq2)
			System.out.println("The Sequence #2: " + output);
		else if (currentSeq == sq3)
			System.out.println("The Sequence #3: " + output);
		System.out.println("Number of elements: "+currentSeq.size());
		System.out.println("Current elements: "+currentElement);
		
		switch((int)doubleTokensArray[0])
		{
			case 10:
				currentSeq = sq2;
				break;
				
			case 11:
				currentSeq = sq2;
				break;
				
			case 12:
				currentSeq = sq2;
				break;
		}
	}
	
	private void printOutput(String line, double [] doubleTokensArray, boolean exception, String exceptionMessage){
		
		if (exception){
			
			System.out.println( "\nLine Input: " +line +
								"\n"+ MENU_CHOICE[(int)doubleTokensArray[0]] +
								"\n"+"-------------------------"+
								"\n"+ exceptionMessage);


		
		}
		else{
			System.out.println( "\nLine Input: " +line +
								"\n"+ MENU_CHOICE[(int)doubleTokensArray[0]] +
								"\n"+"-------------------------");
			printSequence(currentSeq,doubleTokensArray);
		}
			
	}
	
	


}