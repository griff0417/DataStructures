package com.main.BinaryTree;

public class Employee implements Cloneable, Comparable<Object>
{	
	private int acctID;
	private String firstName;
	private String lastName;
	private double salary;
	
	public Employee(int acctID, String firstName, String lastName, double salary) 
	{
		this.acctID = acctID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
	public Employee(int id)
	{
		this.acctID = id;
	}
	
	public int getId()
	{
		return acctID;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public void setSalary(double amount)
	{
		this.salary = amount;
	}
	
	// A method to print information about the employee
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
	
	// A method to compare if object that invokes this method is greater then, equal or less 
	// then obj. 
	// the method returns an integer that is less than, equal to, or greater then zero if the 
	//executing object is less than, equal to, or greater than the parameter, respectively.
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




