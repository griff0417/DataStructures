package com.jr.main;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
	int userChoice;
	int computerChoice;
	int userWinCount=0;
	int computerWinCount=0;
	int tieCount=0;
	boolean whileQuestion=true;
	public Main() {
		
		while(whileQuestion==true){
			System.out.print("Enter 1 for Paper, 2 for Rock, 3 for Scissors, and 9(Exit):");
	        try {
	            userChoice = System.in.read();
	           // System.out.println(userChoice);
	        }
	        catch (IOException e){
	            System.out.println("Error reading from user");
	        }
			Random random = new Random();
			
			
			switch (userChoice) {
		
				case 10:
					
					break;
				case 49:
					computerChoice = random.nextInt(3)+1;
					System.out.println("Computer's Choice is:"+computerChoice);
					if(userChoice==49 && computerChoice==2){
						System.out.println("Paper Wins");
						userWinCount+=1;
						
					}
					else if (userChoice==49 && computerChoice==3){
						System.out.println("Scissors Wins");
						computerWinCount+=1;
					}
					else{
						System.out.println("Tie");
						tieCount+=1;
					}
					break;
	
		
				case 50:
					computerChoice = random.nextInt(3)+1;
					System.out.println("Computer's Choice is:"+computerChoice);
					if (userChoice==50 && computerChoice==1){
						System.out.println("Paper Wins");
						computerWinCount+=1;
						
					}
					else if (userChoice==50 && computerChoice==3){
						System.out.println("Rock Wins");
						userWinCount+=1;
					}
					else{
						System.out.println("Tie");
						tieCount+=1;
					}
					break;
			
			
				case 51:
					computerChoice = random.nextInt(3)+1;
					System.out.println("Computer's Choice is:"+computerChoice);
					if(userChoice==51 && computerChoice==1){
						System.out.println("Scissors Wins");
						userWinCount+=1;
					}
					else if (userChoice==51 && computerChoice==2){
						System.out.println("Rock Wins");
						computerWinCount+=1;
					}
					else{
						System.out.println("Tie");
						tieCount+=1;
					}
					break;
				
				case 57:
					whileQuestion=false;
					break;
					
				default:
					System.out.println("Incorrect entry");
					break;
	
			}//Ends Switch
			
		}//while end
		System.out.println("Your Wins:"+userWinCount);
		System.out.println("Computer Wins:"+computerWinCount);
		System.out.println("Ties :"+tieCount);
	}	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Main();
	}

}
