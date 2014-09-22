package com.quadratic.main;

/**
 * An object to represent a basic quadratic
 * polynomial.  Contains information on
 * the quadratic's coefficients and has
 * methods to obtain the sum and roots
 * of a quadratic.
 * 
 * Date: 9-22-14
 * 
 * @author Jason Griffith & Ryan Hochmuth
 *
 */
public class Quadratic implements Cloneable
{
	// The coefficients of this quadratic
	private double coefA;
	private double coefB;
	private double coefC;
	
	/**
	 * Default Constructor
	 */
	public Quadratic()
	{
		this.coefA = 0;
		this.coefB = 0;
		this.coefC = 0;
	}
	
	/**
	 * Creates a new Quadratic with set coefficients.
	 * @param coefA
	 * @param coefB
	 * @param coefC
	 */
	public Quadratic(double coefA, double coefB, double coefC)
	{
		this.coefA = coefA;
		this.coefB = coefB;
		this.coefC = coefC;
	}
	
	/**
	 * 
	 * @param q1
	 * @param q2
	 * @return
	 */
	public static Quadratic sum(Quadratic q1, Quadratic q2)
	{
		/*
		 * Postcondition: The return value is the quadratic 
		 * expression obtained by adding q1 and q2. For 
		 * example, the c coefficient of the return value
		 * is the sum of q1's c coefficient and q2's c 
		 * coefficient
		 */
		
		return null;
	}
	
	/**
	 * 
	 * @param r
	 * @param q
	 * @return
	 */
	public static Quadratic scale(double r, Quadratic q){
		
		
		
		/*
		 * Postcondition: The return value is the quadratic
		 * expression obtained by multiplying each of q's
		 * coefficients by the number r.
		 */
		return null;
	}
	
	/**
	 * 
	 * @param rootNum
	 * @return rootNum
	 */
	public double getRootNum(double rootNum){
		
		return rootNum;
	}
	
	/**
	 * 
	 * @param rootOne
	 * @return rootOne
	 */
	public double getRootOne(double rootOne){
		
		return rootOne;
	}
	
	/**
	 * 
	 * @param rootTwo
	 * @return rootTwo
	 */
	public double getRootTwo(double rootTwo){
		
		return rootTwo;
	}
	
	/**
	 * Checks to see if the given Object
	 * is of type Quadratic.
	 */
	public boolean equals(Object obj)
	{
		if (obj instanceof Quadratic)
			return true;
		else
			return false;
	}
	
	/**
	 * Creates a clone of the given Quadratic.
	 * @param quad - The Quadratic to clone
	 * @return clone - The new cloned Quadratic
	 */
	public Quadratic clone(Quadratic quad)
	{
		Quadratic clone = null;
		
		try 
		{
			clone = (Quadratic)quad.clone();
		} 
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
		
		return clone;
	}
	
	/**
	 * @return the coefA
	 */
	public double getCoefA() {
		return coefA;
	}

	/**
	 * @param coefA the coefA to set
	 */
	public void setCoefA(double coefA) {
		this.coefA = coefA;
	}

	/**
	 * @return the coefB
	 */
	public double getCoefB() {
		return coefB;
	}

	/**
	 * @param coefB the coefB to set
	 */
	public void setCoefB(double coefB) {
		this.coefB = coefB;
	}

	/**
	 * @return the coefC
	 */
	public double getCoefC() {
		return coefC;
	}

	/**
	 * @param coefC the coefC to set
	 */
	public void setCoefC(double coefC) {
		this.coefC = coefC;
	}

	
}
