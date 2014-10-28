package com.linkedlist.main;

/**
 * SequenceTest.java
 * 
 * @author Ryan Hochmuth & Jason Griffith
 * 
 * Description:
 * 	SequenceTest is a class used to test the functionality
 * of DoubleLinkedSeq.
 *
 */
public class SequenceTest
{
	/****************************
	 * Sequences 
	 ***************************/
	private DoubleLinkedSeq sq1 = null;
	private DoubleLinkedSeq sq2 = null;
	private DoubleLinkedSeq sq3 = null;
	
	// A pointer variable 
	private DoubleLinkedSeq currentSeq = null;
	
	// Menu prints for ease of use
	private final String [] MENU_CHOICE = {"",
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
	
	/**
	 * Find the index of the given element in a sequence.
	 * @param element - the element to find the index of
	 * @return int - the index
	 */
	private int findIndex(double element)
	{
		int index = 0;

		// Increment through the sequence testing each element for the one
		// you're looking for
		for (currentSeq.start(); currentSeq.isCurrent(); currentSeq.advance())
		{
			index++;
			
			if (currentSeq.getCurrent() == element) // If found, return the index
			{
				return index;
			}
		}
		
		return -1; // If the element wasn't found, return -1
	}
	
	/**
	 * Create a new sequence and handle which one is current.
	 * @param doubleTokens - the array of sequence data
	 * @return DoubleLinkedSeq - the new sequence
	 */
	private DoubleLinkedSeq createSequence(double[] doubleTokens)
	{
		if (sq1 == null && sq2 == null) // If there are no sequences yet created, create sq1
		{
			sq1 = new DoubleLinkedSeq();
			return sq1;
		}
		else if (sq1 != null && sq2 == null) // If sq1 is created but sq2 is not, create sq2
		{
			sq2 = new DoubleLinkedSeq();
			return sq2;
		}
		else
		{
			return sq1;
		}
	}
	
	/**
	 * Parses the input line and performs commands
	 * based on the input.
	 * @param line - the String input line
	 */
	public void menu(String line)
	{
		String[] tokens = line.split("[\\s\\,\\-]+"); // Remove spaces, commas, and hyphens from the input line
		double[] doubleTokensArray = new double[tokens.length];
		
		// Parse the String elements to doubles
		for(int a = 0; a < tokens.length; a++)
		{
			try
			{
				doubleTokensArray[a] = Double.parseDouble(tokens[a]);
			}
			catch (NumberFormatException e) 
			{
			    e.printStackTrace();
			    System.out.println("Invalid char on line");
			    return;
			}
		}
		
		/*******************************************
		 * NOTE:
		 * The first element (element 0) of the
		 * doubleTokensArray is the choice of
		 * menu option.  All remaining elements
		 * are data elements for use with
		 * certain menu options.
		 ******************************************/

		// If the menu choice is one that requires no other data elements
		if (doubleTokensArray[0] == 3 || doubleTokensArray[0] == 8 || 
			doubleTokensArray[0] == 10 || doubleTokensArray[0] == 11)
		{
			switch((int)doubleTokensArray[0])
			{
				case 3: // Delete the first number from the sequence
					currentSeq.removeFromFront();
					printOutput(line, doubleTokensArray, false, "");
					break;
					
				case 8: // Display the last element in the sequence
					printOutput(line, doubleTokensArray, false, "");
					break;
					
				case 10: // Append another sequence to the first sequence
					sq1.addAll(sq2);
					currentSeq = sq1;
					printOutput(line, doubleTokensArray, false, "");
					break;
					
				case 11: // Create a clone sequence
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
		// If the menu choice is one that requires more data, and that data is present	
		else if (doubleTokensArray.length > 1)
		{
			switch((int)doubleTokensArray[0])
			{	
				case 1: // Create a sequence
					currentSeq = createSequence(doubleTokensArray);
					
					for (int b = 1; b < doubleTokensArray.length; b++)
					{
						currentSeq.addAfter(doubleTokensArray[b]);
					}
					printOutput(line, doubleTokensArray, false, "");
					break;
					
				case 2: // Delete a number
					if (findIndex(doubleTokensArray[1]) != -1)
					{
						currentSeq.start();
						for(int b = 0; b != findIndex(doubleTokensArray[1]); b++)
						{
							currentSeq.advance();
						}
						currentSeq.removeCurrent();
						printOutput(line, doubleTokensArray, false, "");
					}
					else
						printOutput(line, doubleTokensArray, true, "Exception - Number not found.");
					break;
				
				case 4: // Add a number before another number
					if (findIndex(doubleTokensArray[2]) != -1)
					{
						currentSeq.start();
						for(int b = 0; b != findIndex(doubleTokensArray[2]); b++)
						{
							currentSeq.advance();
						}
						currentSeq.addBefore(doubleTokensArray[1]);
						printOutput(line, doubleTokensArray, false, "Exception - Number not found.");
					}
					else
						printOutput(line, doubleTokensArray, true, "Exception - Number not found.");
					break;
					
				case 5: // Add a number after a number
					if (findIndex(doubleTokensArray[2]) != -1)
					{
						currentSeq.start();
						for(int b = 0; b != findIndex(doubleTokensArray[2]); b++)
						{
							currentSeq.advance();
						}
						currentSeq.addAfter(doubleTokensArray[1]);
						printOutput(line, doubleTokensArray, false, "Exception - Number not found.");
					}
					else
						printOutput(line, doubleTokensArray, true, "Exception - Number not found.");
					break;
					
				case 6: // Add a number to the end of the sequence
					currentSeq.addToEnd(doubleTokensArray[1]);
					printOutput(line, doubleTokensArray, false, "");
					break;
					
				case 7: // Display a number at a certain index
					currentSeq.getElement((int)doubleTokensArray[1]);
					printOutput(line, doubleTokensArray, false, "");
					break;
				
				case 9: // Replace a number with another number
					double currentElement = currentSeq.getCurrent();
					int count = 0;
					int oldIndex = 0;
					
					for (currentSeq.start(); currentSeq.isCurrent(); currentSeq.advance())
					{
						count++;
						
						if (currentSeq.getCurrent() == currentElement) // If found, return the index
						{
							oldIndex = count;
						}
					}
					
					int index = findIndex(doubleTokensArray[1]);
					
					if (index != -1)
					{
						currentSeq.changeElementAtIndex(findIndex(doubleTokensArray[1]) - 1, doubleTokensArray[2]);
						printOutput(line, doubleTokensArray, false, "");
						
						currentSeq.start();
						// Increment through the sequence and get all of the elements
						for (int x = 0; x < index; x++)
						{
							currentSeq.advance();
						}
					}
					else
					{
						currentSeq.start();
						// Increment through the sequence and get all of the elements
						for (int x = 0; x < oldIndex; x++)
						{
							currentSeq.advance();
						}
						printOutput(line, doubleTokensArray, true, "Exception - Number not found.");
					}
					break;
			
				case 12: // Print the sequence
					switch ((int)doubleTokensArray[1])
					{
						case 1:
							currentSeq = sq1;
							printOutput(line, doubleTokensArray, false, "");
							break;
							
						case 2:
							currentSeq = sq3;
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
					
				case 13: // Quit
					System.out.println("\nGoodbye.");
					System.exit(0);
					break;
					
				default:
					break;
			}
		}
		// If there was improper data in the input line
		else
		{
			printOutput(line, doubleTokensArray, true, "Exception - No data was created.");
		}
	}
	
	/**
	 * Print information to the console regarding
	 * which menu choice was ran and then call printSequence().
	 * @param line - the String input line
	 * @param doubleTokensArray - the array of double data elements
	 * @param exception - a boolean to determine if this was a successful run
	 * @param exceptionMessage - A message to display only if this was a failed run
	 */
	private void printOutput(String line, double[] doubleTokensArray, 
							 boolean exception, String exceptionMessage)
	{
		if (exception) // If this run failed
		{
			// Output the exception message
			System.out.println("\nLine Input: " + line +
							   "\n" + MENU_CHOICE[(int)doubleTokensArray[0]] +
							   "\n" + "-------------------------" +
							   "\n" + exceptionMessage);
		}
		else // If this run succeeded
		{
			// Output the proper information and call printSequence()
			System.out.println("\nLine Input: " + line +
							   "\n" + MENU_CHOICE[(int)doubleTokensArray[0]] +
							   "\n" + "-------------------------");
			printSequence(currentSeq, doubleTokensArray);
		}
			
	}
	
	/**
	 * Print information regarding a sequence and which menu
	 * choice was run.
	 * @param seq - the sequence to print about
	 * @param doubleTokensArray - the array of double data elements
	 */
	public void printSequence(DoubleLinkedSeq seq, double[] doubleTokensArray)
	{
		// Print a custom message depending on the menu choice
		switch((int)doubleTokensArray[0])
		{
			case 2: // Delete a number
				System.out.println("Deleted " + 
								   doubleTokensArray[1] + 
								   " from the sequence.");
				break;
				
			case 4: // Add a number before another number
				System.out.println("Added element " + 
								   (int)doubleTokensArray[1] + 
								   " before " + 
								   (int)doubleTokensArray[2]);
				break;
				
			case 5: // Add a number after a number
				System.out.println("Added element " + 
								   (int)doubleTokensArray[1] + 
								   " after " + 
								   (int)doubleTokensArray[2]);
				break;
				
			case 6: // Add a number to the end of the sequence
				System.out.println("Added element " + 
								   (int)doubleTokensArray[1] + 
								   " to end of sequence");
				break;
				
			case 7: // Display a number at a certain index
				System.out.println("Number " + 
								   currentSeq.getElement((int)doubleTokensArray[1]) + 
								   " is at index location " + 
								   ((int)doubleTokensArray[1]));
				break;

			case 8: // Display the last element in the sequence
				System.out.println("The last element in the sequence is " + 
								   currentSeq.getElement(currentSeq.size() - 1));
				break;
				
			case 9: // Replace a number with another number
				System.out.println("Replaced " + 
								   (int)doubleTokensArray[1] + 
								   " with " + 
								   (int)doubleTokensArray[2]);
				break;
		}
		
		double currentElement = currentSeq.getCurrent();
		String output = "";
		
		// Increment through the sequence and get all of the elements
		for (currentSeq.start(); currentSeq.isCurrent(); currentSeq.advance())
		{
			output += currentSeq.getCurrent() + " ";
		}
		
		// Print the sequence
		if (currentSeq == sq1)
			System.out.println("The Sequence #1: " + output);
		else if (currentSeq == sq2)
			System.out.println("The Sequence #2: " + output);
		else if (currentSeq == sq3)
			System.out.println("The Sequence #3: " + output);
		System.out.println("Number of elements: " + currentSeq.size());
		System.out.println("Current element: " + currentElement);
		
		// Reset the current index of the sequence
		currentSeq.start();
		for (int x = 0; x < findIndex(currentElement); x++)
		{
			currentSeq.advance();
		}
		
		// Reset the current sequence appropriately
		switch((int)doubleTokensArray[0])
		{
			case 10: 
				currentSeq = sq2;
				break;
				
			case 11:
				currentSeq = sq3;
				break;
				
			case 12:
				currentSeq = sq3;
				break;
		}
	}
}