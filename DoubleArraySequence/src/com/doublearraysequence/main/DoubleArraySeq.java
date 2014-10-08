package com.doublearraysequence.main;

public class DoubleArraySeq 
{
	private double[] data; // The contents of this sequence
	private int manyItems; // The number of elements in this sequence
	private int currentIndex;
	
	/**
	 * Create a new empty sequence with
	 * a size of 10.
	 */
	public DoubleArraySeq()
	{
		data = new double[10];
	}
	
	/**
	 * Create a new empty sequence with
	 * a specified size.
	 */
	public DoubleArraySeq(int capacity)
	{
		data = new double[capacity];
	}
	
	/**
	 * Get the size of this sequence.
	 * @return size - the size of this sequence
	 */
	public int size()
	{
		return 0;
	}
	
	/**
	 * Rest the current index to the beginning of this sequence.
	 */
	public void start()
	{
		
	}
	
	/**
	 * Advance the current index to the next element in this sequence.
	 */
	public void advance()
	{
		
	}
	
	/**
	 * Check if there is an element at the current index.
	 * @return boolean - true if there is a current element
	 */
	public boolean isCurrent()
	{
		return false;
	}
	
	/**
	 * Get the element at the current index of this sequence.
	 * @return double - the element at the current index
	 */
	public double getCurrent()
	{
		return 0;
	}
	
	/**
	 * Add the specified element to the sequence before the current index.
	 * @param element - the element to add before the current index
	 */
	public void addBefore(double element)
	{
		
	}
	
	/**
	 * Add the specified element to the sequence after the current index.
	 * @param element - the element to add after the current index
	 */
	public void addAfter(double element)
	{
		
	}
}