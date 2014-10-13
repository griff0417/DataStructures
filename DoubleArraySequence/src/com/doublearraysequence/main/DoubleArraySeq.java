package com.doublearraysequence.main;


public class DoubleArraySeq implements Cloneable
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
		try
		{
			data = new double[10];
		}
		catch(OutOfMemoryError e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Create a new empty sequence with
	 * a specified size.
	 */
	public DoubleArraySeq(int capacity)
	{
		if(capacity <= 0)
			throw new IllegalArgumentException("InitialCapacity is negative: " + capacity);
		
		try
		{
			data = new double[capacity];
		}
		catch(OutOfMemoryError e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the number of elements in this sequence.
	 * @return size - the number of elements in this sequence
	 */
	public int size()
	{
		return manyItems;
	}
	
	/**
	 * Reset the current index to the beginning of this sequence.
	 */
	public void start()
	{
		currentIndex = 0;
	}
	
	/**
	 * Advance the current index to the next element in this sequence.
	 */
	public void advance()
	{
		try
		{
			if (isCurrent())
				currentIndex ++;
		}
		catch(IllegalStateException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Check if there is an element at the current index.
	 * @return boolean - true if there is a current element
	 */
	public boolean isCurrent()
	{
		// Check if the current index is outside of the array bounds
		if (currentIndex >= manyItems || currentIndex < 0)
		{
			return false;
		}
		else
		{
			if (manyItems > 0 && currentIndex <= (manyItems - 1))
				return true;
			else
				return false;
		}
	}
	
	/**
	 * Get the element at the current index of this sequence.
	 * @return double - the element at the current index
	 */
	public double getCurrent()
	{
		try
		{
			// If there is an element at the current index, return it
			if (isCurrent())
				return data[currentIndex];
			else
				return -1;
		}
		catch (IllegalStateException e)
		{
			e.printStackTrace();
			
			return -1;
		}
	}
	
	/**
	 * Add the specified element to the sequence before the current index.
	 * If there is no current index, it gets added to the beginning
	 * of the sequence.
	 * @param element - the element to add before the current index
	 */
	public void addBefore(double element)
	{
		// Ensure the array is big enough for the new element
		if(manyItems == data.length)
			ensureCapacity(manyItems + 1);
		
		// If there is no current element, add this element
		// to the front of the sequence at index 0
		if(!isCurrent())
			currentIndex = 0;
		
		// Shift all the data to the right
		for(int i = manyItems; i > currentIndex; i--)
			data[i] = data[i-1];
		
		// Add the new element
		data[currentIndex] = element;
		manyItems++;
	}
	
	/**
	 * Add the specified element to the sequence after the current index.
	 * If there is no current index, it gets added to the end of
	 * the sequence.
	 * @param element - the element to add after the current index
	 */
	public void addAfter(double element)
	{
		// Ensure the array is big enough for the new element
		if(manyItems == data.length)
			ensureCapacity(manyItems + 1);
		
		// If there is no current element, add this element
		// to the end of the sequence at index 0
		if(!isCurrent())
			currentIndex = 0;
		else
			currentIndex++;
		
		// Shift all the data after the current index to the right
		for(int i = currentIndex; i < manyItems; i++)
			data[i+1] = data[i];
		
		// Add the new element
		data[currentIndex] = element;
		manyItems++;
	}
	
	/**
	 * Remove the element at the current index of this sequence.
	 * @return boolean - true if successfully removed
	 */
	public boolean removeCurrent()
	{
		// Shift all the data after the current index to the right
		for(int i = currentIndex; i < manyItems; i++)
		{
			try
			{
				data[i] = data[i + 1];
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				e.printStackTrace();
			}
		}
		
		data[manyItems-- - 1] = 0;
		currentIndex++;
		
		if (isCurrent())
			return true;
		else
			return false;
	}
	
	/**
	 * Add all of the elements from the given DoubleArraySeq
	 * to the end of this sequence.
	 * @param seq - the DoubleArraySeq containing the data to add
	 */
	public void addAll(DoubleArraySeq seq)
	{
		if(seq == null)
			throw new NullPointerException("The DoubleArraySeq to add is null.");
		
		// Resize the array to include both sets of data
		try
		{
			ensureCapacity(manyItems + seq.size());
		}
		catch(OutOfMemoryError e)
		{
			e.printStackTrace();
		}
		
		// Copy the new data into the first array
		System.arraycopy(seq.data, 0, this.data, this.manyItems, seq.size());
		manyItems += seq.size();
	}
	
	/**
	 * Combine the data of the two given DoubleArraySeq 
	 * and create a new DoubleArraySeq with that data.
	 * @param seq1 - the first DoubleArraySeq containing data
	 * @param seq2 - the second DoubleArraySeq containing data
	 * @return DoubleArraySeq - the new sequence containing the concatenated data
	 */
	public static DoubleArraySeq concatenate(DoubleArraySeq seq1, DoubleArraySeq seq2)
	{
		if(seq1 == null || seq2 == null)
			throw new NullPointerException("seq1(" + seq1 +") or seq2(" + seq2 + ") is null.");
		
		// The new bigger sequence to return
		DoubleArraySeq newDoubleArraySeq = new DoubleArraySeq(seq1.getCapacity() + seq2.getCapacity());
		
		// Copy all the data into the new sequence
		System.arraycopy(seq1.data, 0, newDoubleArraySeq.data, 0, seq1.size());
		System.arraycopy(seq2.data, 0, newDoubleArraySeq.data, seq1.size(), seq2.size());
		
		newDoubleArraySeq.manyItems = seq1.size() + seq2.size();
		
		newDoubleArraySeq.trimToSize();
		
		return newDoubleArraySeq;
	}
	
	/**
	 * Create a clone of this sequence.
	 * @return DoubleArraySeq - the cloned DoubleArraySeq
	 */
	public DoubleArraySeq clone()
	{
		// Clone a DoubleArraySeq object.
	    DoubleArraySeq answer;
	      
	    try
	    {
	       answer = (DoubleArraySeq) super.clone( );
	    }
	    catch (CloneNotSupportedException e)
	    {
	    	
	        // This exception should not occur. But if it does, it would probably
	        // indicate a programming error that made super.clone unavailable.
	        // The most common error would be forgetting the "Implements Cloneable"
	        // clause at the start of this class.
	        throw new RuntimeException
	        ("This class does not implement Cloneable");
	    }
	      
	    answer.data = data.clone( );
	      
	    return answer;
	}
	
	/**
	 * Get the number of elements this sequence can hold in total.
	 * @param capacity - the total capacity of this sequence
	 */
	public int getCapacity()
	{
		return data.length;
	}
	
	/**
	 * Ensure that the capacity of this sequence is greater than
	 * or equal to the given parameter.
	 * @param capacity - the number to ensure capacity of
	 */
	public void ensureCapacity(int capacity)
	{
		double[] newArray = null;
		
		// If the array is already big enough, do nothing
		if (data.length < capacity)
		{
			try 
			{
				// Try and resize the array
				newArray = new double[capacity];
			}
			catch(OutOfMemoryError e)
			{
				e.printStackTrace();
			}
			
			// Copy over the existing data
			System.arraycopy(data, 0, newArray, 0, manyItems);
			
			// Update the data array
			data = newArray.clone();
		}
	}
	
	/**
	 * If there is excess space in this sequence containing
	 * no elements, trim it off.
	 */
	public void trimToSize()
	{
		double[] trimmedArray;
	      
	    if (data.length != manyItems)
	    {
	       trimmedArray = new double[manyItems];
	       System.arraycopy(data, 0, trimmedArray, 0, manyItems);
	       data = trimmedArray.clone();
	    }
	}
	
	/**
	 * Add the specified element to the front of this sequence.
	 * @param element - the element to add to the front
	 */
	public void addToFront(double element)
	{
		// Ensure the array is big enough for the new element
		if(manyItems == data.length)
			ensureCapacity(manyItems + 1);
		
		// Set the index to the beginning of the sequence
		currentIndex = 0;
		
		// Shift all the data to the right
		for(int i = manyItems; i > currentIndex; i--)
			data[i] = data[i-1];
		
		// Add the new element
		data[currentIndex] = element;
		manyItems++;
		currentIndex = 0;
	}
	
	/**
	 * Remove the element at the front of this sequence.
	 */
	public void removeFromFront()
	{
		if (manyItems == 0)
			throw new IndexOutOfBoundsException("The sequence is empty.");
		
		// Shift all the data after the current index to the right
		for(int i = 0; i < manyItems; i++)
		{
			try
			{
				data[i] = data[i + 1];
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				e.printStackTrace();
			}
		}
		
		data[manyItems-- - 1] = 0;
		currentIndex = 0;
	}
	
	/**
	 * Add the specified element to the end of this sequence.
	 * @param element - the element to add to the end
	 */
	public void addToEnd(double element)
	{
		// Ensure the array is big enough for the new element
		if(manyItems == data.length)
			ensureCapacity(manyItems + 1);
		
		// Add the new element
		data[manyItems] = element;
		manyItems++;
		currentIndex = manyItems - 1;
	}
	
	/**
	 * Remove the element at the end of this sequence.
	 */
	public void removeFromEnd()
	{
		if (manyItems == 0)
			throw new IndexOutOfBoundsException("The sequence is empty.");
		
		// Shift all the data after the current index to the right
		for(int i = manyItems - 1; i < manyItems; i++)
		{
			try
			{
				data[i] = data[i + 1];
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				e.printStackTrace();
			}
		}
		
		data[manyItems-- - 1] = 0;
		currentIndex = manyItems;
	}
	
	/**
	 * Change the element at the end of this sequence
	 * to the element located at the current index.
	 */
	public void endToCurrent()
	{
		if (isCurrent())
			data[size() - 1] = getCurrent();
		else
			throw new IllegalStateException("There is no current element.");
	}
	
	/**
	 * Get the element located at the specified index.
	 * @param index - the index to obtain the element from
	 * @return double - the element located at the specified index
	 */
	public double getElement(int index)
	{
		if (isCurrent())
			return data[index];
		else
			throw new IllegalStateException("There is no element at " + index + ".");
	}
	
	/**
	 * Change the element at the specified index
	 * to the element located at the current index.
	 * @param index - the index at which to change the element
	 */
	public void elementToCurrent(int index)
	{
		if (isCurrent())
			data[index] = getCurrent();
		else
			throw new IllegalStateException("There is no current element.");
	}
}