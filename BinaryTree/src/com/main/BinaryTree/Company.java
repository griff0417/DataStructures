package com.main.BinaryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A company is the class that contains
 * the employee database and handles
 * the menu to interact with the database.
 * 
 * @author Ryan Hochmuth & Jason Griffith
 *
 */
public class Company 
{
	private TreeBag bt = new TreeBag(); // The employee binary tree
	
	/**
	 * The menu that contains options for interacting
	 * with the binary tree.
	 * @param inputString
	 */
	public void menu(String inputString)
	{
		// Remove spaces, commas, and hyphens from the input line
		String[] tokens = inputString.split("[\\s\\,\\-]+"); 
		
		switch (Integer.parseInt(tokens[0]))
		{
			case 1: // Read from file
				System.out.println
				("----------------------------------------------------------------------------");
				System.out.println("Create a binary tree from an input file.");
				System.out.println
				("----------------------------------------------------------------------------");
				
				// Attempt to create the scanner by finding the input File
				Scanner scanner = null;
				try 
				{
					scanner = new Scanner(new File("src/" + tokens[1]));
				} 
				catch (FileNotFoundException e) 
				{
					System.out.println("File: " + tokens[1] + " not found.");
					return;
				}
				
				System.out.println("File: " + tokens[1]);
				
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
				
				System.out.println("");
				break;
				
			case 2: // Add new employee
				System.out.println
				("----------------------------------------------------------------------------");
				System.out.println("Add a new employee to the tree.");
				System.out.println
				("----------------------------------------------------------------------------");
				
				bt.add(new Employee(
						Integer.parseInt(tokens[1]),
						tokens[2],
						tokens[3],
						Double.parseDouble(tokens[4])));
				
				System.out.println("");
				break;
				
			case 3: // Remove Employee
				System.out.println
				("----------------------------------------------------------------------------");
				System.out.println("Remove an employee from the tree.");
				System.out.println
				("----------------------------------------------------------------------------");
				
				bt.remove(new Employee(Integer.parseInt(tokens[1])));
				
				System.out.println("");
				break;
				
			case 4: // Retrieve employee
				System.out.println
				("----------------------------------------------------------------------------");
				System.out.println("Retrieve an employee from the tree and print the employee record.");
				System.out.println
				("----------------------------------------------------------------------------");
				
				Employee emp = (Employee)bt.retrieve(
						new Employee(Integer.parseInt(tokens[1])),
						bt.getRoot());
				
				if (emp != null)
				{
					System.out.println("Employee Found:");
					System.out.println(emp.toString());
				}
				else
					System.out.println("Employee not found.");
				
				System.out.println("");
				break;
				
			case 5: // Update employee
				System.out.println
				("----------------------------------------------------------------------------");
				System.out.println("Update an employee and print the new record.");
				System.out.println
				("----------------------------------------------------------------------------");
				
				Employee emp2 = (Employee)bt.retrieve(
						new Employee(Integer.parseInt(tokens[1])),
						bt.getRoot());
				
				if (emp2 != null)
				{
					emp2.setSalary(Double.parseDouble(tokens[2]));
					
					System.out.println("Employee Updated:");
					System.out.println(emp2.toString());
				}
				else
					System.out.println("Employee not found");
				
				System.out.println("");
				break;
				
			case 6: // Print all employees
				System.out.println
				("----------------------------------------------------------------------------");
				System.out.println("Display the entire tree.");
				System.out.println
				("----------------------------------------------------------------------------");
				
				PrintWriter pw = null;
				
				try 
				{
					pw = new PrintWriter(new File("src/output.txt"));
				} 
				catch (FileNotFoundException e) 
				{
					System.out.println("Output file issue.");
				}
			
				bt.display(bt.getRoot(), pw);
				
				pw.close();
				
				try
				{
					Scanner outScan = new Scanner(new File("src/output.txt"));
					
					System.out.println("Company Tree:");
					while (outScan.hasNextLine())
					{
						System.out.println(outScan.nextLine());
					}
					
					outScan.close();
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				
				System.out.println("");
				break;
				
			case 7: // Exit
				System.out.println
				("----------------------------------------------------------------------------");
				System.out.println("Goodbye.");
				System.out.println
				("----------------------------------------------------------------------------");
				System.out.println("");
				
				System.exit(0);
				break;	
		}
	}
}
