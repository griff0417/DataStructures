package com.main.BinaryTree;

/**
 * The employee class is an object that
 * represents an employee in a company.
 * 
 * @author Ryan Hochmuth & Jason Griffith
 *
 */
public class Employee implements Cloneable, Comparable<Object>
{	
	private int acctID;
	private String firstName;
	private String lastName;
	private double salary;
	
	/**
	 * Create a new employee with an id, first name, last name,
	 * and salary.
	 * @param acctID
	 * @param firstName
	 * @param lastName
	 * @param salary
	 */
	public Employee(int acctID, String firstName, String lastName, double salary) 
	{
		this.acctID = acctID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
	/**
	 * Create a new employee with an id.
	 * @param id
	 */
	public Employee(int id)
	{
		this.acctID = id;
	}
	
	/**
	 * Get the id of this employee.
	 * @return acctID
	 */
	public int getId()
	{
		return acctID;
	}
	
	/**
	 * Get the last name of this employee.
	 * @return lastName
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Get the first name of this employee.
	 * @return firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Get the salary of this employee.
	 * @return salary
	 */
	public double getSalary()
	{
		return salary;
	}
	
	/**
	 * Set the salary of this employee.
	 * @param amount
	 */
	public void setSalary(double amount)
	{
		this.salary = amount;
	}
	
	/**
	 * Return the information for this
	 * employee as a string.
	 * @return String - the concatenated info
	 * of this employee
	 */
	@Override
	public String toString()
	{
		String output = "";
		
		output += acctID
				+ " "
				+ firstName
				+ " "
				+ lastName
				+ " "
				+ salary;
		
		return output;
	}
	
	/**
	 * Compare this employee to the given
	 * employee by their ids.
	 * @param obj
	 * @return
	 * If this id < the given, return -1.
	 * If this id = the given, return 0.
	 * If this id > the given, return 1.
	 */
	@Override
	public int compareTo(Object obj) 
	{
		Employee emp = (Employee)obj;
		
		if (acctID < emp.getId())
			return -1;
		else if (acctID == emp.getId())
			return 0;
		else 
			return 1;
	}
}