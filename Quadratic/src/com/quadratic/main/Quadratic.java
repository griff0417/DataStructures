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
	 * Evaluate this quadratic with the
	 * given value of x.
	 * @param x - the value of x
	 * @return int - the evaluated answer
	 */
	public double evalExpression(double x)
	{
		return (coefA * Math.pow(x, 2)) + (coefB * x) + coefC;
	}
	
	/**
	 * Add the two given quadratics together.
	 * @param q1 - the first quadratic
	 * @param q2 - the second quadratic
	 * @return Quadratic - the result of q1 + q2
	 */
	public static Quadratic sum(Quadratic q1, Quadratic q2)
	{
		return new Quadratic(q1.getCoefA() + q2.getCoefA(), q1.getCoefB() + q2.getCoefB(), q1.getCoefC() + q2.getCoefC());
	}
	
	/**
	 * Scale the given quadratic by the given number.
	 * @param mult - the multiplier to scale by
	 * @param q - the quadratic to scale
	 * @return Quadratic -  the scaled quadratic
	 */
	public static Quadratic scale(double mult, Quadratic q)
	{
		return new Quadratic(q.getCoefA() * mult, q.getCoefB() * mult, q.getCoefC() * mult);
	}
	
	/**
	 * Get how many real roots this quadratic has.
	 * @param rootNum
	 * @return rootNum
	 */
	public double getRootNum()
	{
		return 0;
	}
	
	/**
	 * Get the first root of this quadratic. 
	 * @return rootOne
	 */
	public double getRootOne()
	{
		return (-coefB + (Math.sqrt((coefB * coefB - ((4 * coefA * coefC)))))) / (2 * coefA);
	}
	
	/**
	 * Get the second root of this quadratic.
	 * @return rootTwo
	 */
	public double getRootTwo()
	{
		return (-coefB - (Math.sqrt((coefB * coefB - ((4 * coefA * coefC)))))) / (2 * coefA);
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
	public double getCoefA() 
	{
		return coefA;
	}

	/**
	 * @param coefA the coefA to set
	 */
	public void setCoefA(double coefA) 
	{
		this.coefA = coefA;
	}

	/**
	 * @return the coefB
	 */
	public double getCoefB() 
	{
		return coefB;
	}

	/**
	 * @param coefB the coefB to set
	 */
	public void setCoefB(double coefB) 
	{
		this.coefB = coefB;
	}

	/**
	 * @return the coefC
	 */
	public double getCoefC() 
	{
		return coefC;
	}

	/**
	 * @param coefC the coefC to set
	 */
	public void setCoefC(double coefC) 
	{
		this.coefC = coefC;
	}
}
