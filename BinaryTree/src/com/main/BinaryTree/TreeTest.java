package com.main.BinaryTree;

/**
 * TreeTest is the driver class for this program. 
 * It handles the calls to the company menu.
 * 
 * @author Jason Griffith & Ryan Hochmuth
 *
 */
public class TreeTest
{
	/**
	 * Start the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Company company = new Company(); // The company to work with

		// Create a new tree from a text file
		company.menu("1 - Employee.txt");
		
		// Add a new employee
		company.menu("2 - 5290 George  Truman      	16110.68");

		// Remove an employee
		company.menu("3 - 4892");

		// Retrieve an employee and print it's record
		company.menu("4 - 3924");

		// Update an employee record
		company.menu("5 - 3924 20000.00");

		// Print the entire tree
		company.menu("6");

		// Exit the program
		company.menu("7");
	}
}