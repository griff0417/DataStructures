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
	 * Get the number of elements in this sequence.
	 * @return size - the number of elements in this sequence
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
	
	/**
	 * Remove the element at the current index of this sequence.
	 * @return boolean - true if successfully removed
	 */
	public boolean removeCurrent()
	{
		return false;
	}
	
	/**
	 * Add all of the elements from the given DoubleArraySeq
	 * to the end of this sequence.
	 * @param seq - the DoubleArraySeq containing the data to add
	 */
	public void addAll(DoubleArraySeq seq)
	{
		
	}
	
	/**
	 * Combine the data of the two given DoubleArraySeq 
	 * and create a new DoubleArraySeq with that data.
	 * @param seq1 - the first DoubleArraySeq containing data
	 * @param seq2 - the second DoubleArraySeq containing data
	 * @return DoubleArraySeq - the new sequence containing the concatenated data
	 */
	public static DoubleArraySeq concatenation(DoubleArraySeq seq1, DoubleArraySeq seq2)
	{
		return null;
	}
	
	/**
	 * Create a clone of this sequence.
	 * @return DoubleArraySeq - the cloned DoubleArraySeq
	 */
	public DoubleArraySeq clone()
	{
		return null;
	}
	
	/**
	 * Get the number of elements this sequence can hold in total.
	 * @param capacity - the total capacity of this sequence
	 */
	public int getCapacity()
	{
		return 0;
	}
	
	/**
	 * Ensure that the capacity of this sequence is greater than
	 * or equal to the given parameter.
	 * @param capacity - the number to ensure capacity of
	 */
	public void getCapacity(int capacity)
	{
		
	}
	
	/**
	 * If there is excess space in this sequence containing
	 * no elements, trim it off.
	 */
	public void trimToSize()
	{
		
	}
	
	/**
	 * Add the specified element to the front of this sequence.
	 * @param element - the element to add to the front
	 */
	public void addToFront(double element)
	{
		
	}
	
	/**
	 * Remove the element at the front of this sequence.
	 */
	public void removeFromFront()
	{
		
	}
	
	/**
	 * Add the specified element to the end of this sequence.
	 * @param element - the element to add to the end
	 */
	public void addToEnd(double element)
	{
		
	}
	
	/**
	 * Remove the element at the end of this sequence.
	 */
	public void removeFromEnd()
	{
		
	}
	
	/**
	 * Change the element at the end of this sequence
	 * to the element located at the current index.
	 */
	public void endToCurrent()
	{
		
	}
	
	/**
	 * Get the element located at the specified index.
	 * @param index - the index to obtain the element from
	 * @return double - the element located at the specified index
	 */
	public double getElement(int index)
	{
		return 0;
	}
	
	/**
	 * Change the element at the specified index
	 * to the element located at the current index.
	 * @param index - the index at which to change the element
	 */
	public void elementToCurrent(int index)
	{
		
	}
}