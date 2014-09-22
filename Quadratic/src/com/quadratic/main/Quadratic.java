package com.quadratic.main;
/**
 * 
 * @author Jason Griffith & Ryan Hochmuth
 *
 */
public class Quadratic 
{
	private double coefA;
	private double coefB;
	private double coefC;
	
	public Quadratic(){
		coefA=0;
		coefB=0;
		coefC=0;
	}
	
	public Quadratic(double coefA, double coefB, double coefC){
		this.coefA=coefA;
		this.coefB=coefB;
		this.coefC=coefC;
		
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
