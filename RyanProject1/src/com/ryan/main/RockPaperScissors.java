package com.ryan.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * RockPaperScissors is a simple text-based game
 * of rock paper scissors.
 * 
 * @author Ryan Hochmuth
 *
 */
public class RockPaperScissors 
{
	/*************************
	 * Game Variables
	 ************************/
	// Control variable to handle game looping
	private boolean gameRunning = true;
	
	// The player's choice of rock, paper, or scissors
	// as an integer (0, 1, 3)
	private int playerChoice;
	// The player's choice as an input String
	private String playerChoiceStr;
	
	// The randomly picked computer's choice
	private int computerChoice;
	
	// An integer to determine the game's outcome
	// 0 = Tie, 1 = Player wins, 2 = Computer wins, 3 = invalid input
	private int gameOutcome = 3;
	
	/*************************
	 * Game Objects
	 ************************/
	// The random number generator that the computer uses
	private Random rand = new Random();
	// The BufferedReader to read from the console
	private BufferedReader bufRead = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * RockPaperScissors default constructor
	 */
	public RockPaperScissors()
	{
		while(gameRunning)
		{
			// Output the game's greeting message
			System.out.println("Welcome to Rock Paper Scissors!");
			System.out.println("Input your choice: 0 = Rock, 1 = Paper, 2 = Scissors.  Then press 'Enter'.");
			
			try 
			{
				// Wait for console input, then set 
				// the input to playerChoiceStr
				playerChoiceStr = bufRead.readLine();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			if (playerChoiceStr.equals("exit"))
			{
				System.out.println("Goodbye!");
				gameRunning = false;
				System.exit(0);
			}
			
			// Parse the input String to an integer
			playerChoice = Integer.parseInt(playerChoiceStr);
			
			// Generate a number between 0 and 2 for the computer's choice
			computerChoice = rand.nextInt(3);
			
			// Compare the player and computer choice
			switch(playerChoice)
			{
				/*************************
				 * Case 0 : Rock
				 ************************/
				case 0: // Player chose Rock
					
					// Output the player's choice
					System.out.println("\nPlayer chose: Rock");
					
					switch(computerChoice)
					{
						case 0: // Computer chose Rock
							
							// Output the computer's choice
							System.out.println("Computer chose: Rock");
							
							gameOutcome = 0; // Set the game outcome
							break;
						
						case 1: // Computer chose Paper
							
							// Output the computer's choice
							System.out.println("Computer chose: Paper");
							
							gameOutcome = 2; // Set the game outcome
							break;
							
						case 2: // Computer chose Scissors
							
							// Output the computer's choice
							System.out.println("Computer chose: Scissors");
							
							gameOutcome = 1; // Set the game outcome
							break;
					}
					break;
				
				/*************************
				 * Case 1 : Paper
				 ************************/	
				case 1: // Player chose Paper
					
					// Output the player's choice
					System.out.println("\nPlayer chose: Paper");
					
					switch(computerChoice)
					{
						case 0: // Computer chose Rock
							
							// Output the computer's choice
							System.out.println("Computer chose: Rock");
							
							gameOutcome = 1; // Set the game outcome
							break;
						
						case 1: // Computer chose Paper
							
							// Output the computer's choice
							System.out.println("Computer chose: Paper");
							
							gameOutcome = 0; // Set the game outcome
							break;
							
						case 2: // Computer chose Scissors
							
							// Output the computer's choice
							System.out.println("Computer chose: Scissors");
							
							gameOutcome = 2; // Set the game outcome
							break;
					}
					break;
				
				/*************************
				 * Case 2 : Scissors
				 ************************/
				case 2: // Player chose Scissors
					
					// Output the player's choice
					System.out.println("\nPlayer chose: Scissors");
					
					switch(computerChoice)
					{
						case 0: // Computer chose Rock
							
							// Output the computer's choice
							System.out.println("Computer chose: Rock");
							
							gameOutcome = 2; // Set the game outcome
							break;
						
						case 1: // Computer chose Paper
							
							// Output the computer's choice
							System.out.println("Computer chose: Paper");
							
							gameOutcome = 1; // Set the game outcome
							break;
							
						case 2: // Computer chose Scissors
							
							// Output the computer's choice
							System.out.println("Computer chose: Scissors");
							
							gameOutcome = 0; // Set the game outcome
							break;
					}
					break;
			} // End switch(playerChoice)
			
			// Determine game outcome and print result
			switch(gameOutcome)
			{
				case 0: // Tie game
					
					System.out.println("\nTie game");
					break;
				
				case 1: // Player wins
					
					System.out.println("Player wins!");
					break;
					
				case 2: // Computer wins
					
					System.out.println("Computer wins!");
					break;
					
				case 3: // Invalid input
					
					System.out.println("Invalid input");
					break;
			}
			
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args)
	{
		// Create a new RockPaperScissors object
		new RockPaperScissors();
	}
}
