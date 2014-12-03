package com.main.BinaryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Company 
{
	private TreeBag bt = new TreeBag();
	
	public Company()
	{
		
	}
	
	public void menu(String inputString)
	{
		// Remove spaces, commas, and hyphens from the input line
		String[] tokens = inputString.split("[\\s\\,\\-]+"); 
		
		switch (Integer.parseInt(tokens[0]))
		{
			case 1: // Read from file
				
				// Attempt to create the scanner by finding the input File
				Scanner scanner = null;
				try 
				{
					scanner = new Scanner(new File("src/"+tokens[1]));
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
					return;
				}	
				
				// Read through the input file while
				// there is still information in it
				while(scanner.hasNextLine())
				{
					// Remove spaces, commas, and hyphens from the input line
					String[] fileTokens = scanner.nextLine().split("[\\s\\,\\-]+");
					
					bt.add(new Employee(
							Integer.parseInt(fileTokens[0]),
							fileTokens[1],
							fileTokens[2],
							Double.parseDouble(fileTokens[3])));
				}
				
				break;
				
			case 2: // Add new employee
				bt.add(new Employee(
						Integer.parseInt(tokens[1]),
						tokens[2],
						tokens[3],
						Double.parseDouble(tokens[4])));
				break;
				
			case 3: // Remove Employee
				bt.remove(new Employee(Integer.parseInt(tokens[1])));
				break;
				
			case 4: // Retrieve employee
				Employee emp = (Employee)bt.retrieve(
						new Employee(Integer.parseInt(tokens[1])),
						bt.getRoot());
				
				if (emp != null)
					System.out.println(emp.toString());
				break;
				
			case 5: // Update employee
				Employee emp2 = (Employee)bt.retrieve(
						new Employee(Integer.parseInt(tokens[1])),
						bt.getRoot());
				
				emp2.setSalary(Double.parseDouble(tokens[2]));
				
				if (emp2 != null)
					System.out.println(emp2.toString());
				break;
				
			case 6: // Print all employees
				PrintWriter pw = null;
				
				try 
				{
					pw = new PrintWriter(new File("src/output.txt"));
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
			
				bt.display(bt.getRoot(), pw);
				
				pw.close();
				break;
				
			case 7: // Exit
				System.exit(0);
				break;	
		}
		
	}
}
