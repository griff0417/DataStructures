package com.doublearraysequence.main;

import java.io.IOException;

import javax.swing.JOptionPane;

public class SequenceTest
{
	DoubleArraySeq sq1;
	DoubleArraySeq sq2;
	DoubleArraySeq sq3;
	
	
	
	
	public void menu (String menuChoice){
		String[] tokens = menuChoice.split("\\s+|\\,+|\\-+");
		double [] doubleTokensArray = new double[tokens.length-1];
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
		//System.out.println("");		
		/*
		int messageChoice = 0;
		String output=	"1. Create a sequence \n"+
						"2. Delete a number \n"+ 
						"3. Delete the first number from the sequence \n"+
						"4. Add a number before another number \n"+
						"5. Add a number after a number \n"+
						"6. Add a number to the end of the sequence \n"+
						"7. Display a number at a certain index \n"+
						"8. Display the last element in the sequence \n"+
						"9. Replace a number with another number \n"+
						"10. Append another sequence to the first sequence \n"+
						"11. Create a clone sequence \n"+
						"12 Print the sequence \n"+
						"13. Quit \n";
		*/
		switch((int)doubleTokensArray[0]){
			default:

				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				
				break;
			case 7:
				
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;
			case 11:
				
				break;
			case 12:
				
				break;
			case 13:
				
				break;
		}
		
	}
	
	public void printSequence(DoubleArraySeq seq){
		
	}
	
	public int findIndex(double element){
		
		return 0;
	}
	


}