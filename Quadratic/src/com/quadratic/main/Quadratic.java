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
	 * @return Quadratic - the scaled quadratic
	 */
	public static Quadratic scale(double mult, Quadratic q)
	{
		return new Quadratic(q.getCoefA() * mult, q.getCoefB() * mult, q.getCoefC() * mult);
	}
	
	/**
	 * Get how many real roots this quadratic has.
	 * @return int - the number of roots this quadratic has
	 */
	public double getRootNum()
	{
		
		if (coefA == 0 && coefB == 0 && coefC == 0)
			return 3;
		else if (coefA == 0 && coefB == 0 && coefC != 0)
			return 0;
		else if (coefA == 0 && coefB != 0)
			return 1;
		else if (coefA != 0 && Math.pow(coefB, 2) < 4 * coefA * coefC)
			return 0;
		else if (coefA != 0 && Math.pow(coefB, 2) == 4 * coefA * coefC)
			return 1;
		else if (coefA != 0 && Math.pow(coefB, 2) > 4 * coefA * coefC)
			return 2;
		else
			return 0;
	}
	
	/**
	 * Get the first root of this quadratic.
	 * @return int - the first root
	 */
	public double getRootOne()
	{
		double posRoot = (-coefB + (Math.sqrt((coefB * coefB - ((4 * coefA * coefC)))))) / (2 * coefA);
		double negRoot = (-coefB - (Math.sqrt((coefB * coefB - ((4 * coefA * coefC)))))) / (2 * coefA);
		
		if (getRootNum() > 0)
		{
			if (posRoot < negRoot)
				return posRoot;
			else
				return negRoot;
		}
		else
			return 0;
	}
	
	/**
	 * Get the second root of this quadratic. 
	 * @return int - the second root
	 */
	public double getRootTwo()
	{
		double posRoot = (-coefB + (Math.sqrt((coefB * coefB - ((4 * coefA * coefC)))))) / (2 * coefA);
		double negRoot = (-coefB - (Math.sqrt((coefB * coefB - ((4 * coefA * coefC)))))) / (2 * coefA);
		
		if (getRootNum() > 0)
		{
			if (posRoot > negRoot)
				return posRoot;
			else
				return negRoot;
		}
		else
			return 0; 
	}
	
	/**
	 * Returns the String equivalent
	 * of this quadratic.
	 * @return String - the quadratic as a String
	 */
	public String toString()
	{
		if (coefB > 0)
		{
			if (coefC > 0)
				return (int)coefA + "x^2 + " + (int)coefB + "x + " + (int)coefC;
			else
				return (int)coefA + "x^2 + " + (int)coefB + "x - " + (int)coefC * -1;
		}
		else if (coefB < 0)
		{
			if (coefC > 0)
				return (int)coefA + "x^2 - " + (int)coefB * -1 + "x + " + (int)coefC;
			else
				return (int)coefA + "x^2 - " + (int)coefB * -1 + "x - " + (int)coefC * -1;
		}
		else
		{
			return "0";
		}
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
