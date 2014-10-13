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
		try
		{
			data = new double[capacity];
			System.out.println("Created array");
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
		if (currentIndex >= getCapacity() || currentIndex < 0)
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
		// Instance variables
		double[] newArray = null;
		int x = 0;
		int addIndex;
		
		// Check if there is a current element
		if (isCurrent())
			addIndex = currentIndex;
		else
			addIndex = 0;
		
		// If this is the first element added to the
		// sequence, add it to the beginning only
		if (manyItems == 0)
		{
			manyItems++;
			data[0] = element;
			currentIndex = 0;
		}
		else
		{
			manyItems++;
			
			try
			{
				if (getCapacity() < manyItems)
					newArray = new double[manyItems];
				else
					newArray = new double[getCapacity()];
			}
			catch(OutOfMemoryError e)
			{
				manyItems--;
				e.printStackTrace();
			}
			
			// Shift all elements and add the new one
			for (; x < manyItems; x++)
			{
				if (x < addIndex)
				{
					newArray[x] = data[x];
				}
				else if (x == addIndex)
				{
					newArray[x] = element;
					currentIndex = x;
				}
				else if (x > addIndex)
				{
					newArray[x] = data[x - 1];
				}
			}
			
			// Update data
			data = newArray.clone();
		}
	}
	
	/**
	 * Add the specified element to the sequence after the current index.
	 * If there is no current index, it gets added to the end of
	 * the sequence.
	 * @param element - the element to add after the current index
	 */
	public void addAfter(double element)
	{
		// Instance variables
		double[] newArray = null;
		int x = 0;
		int addIndex;
		
		// Check if there is a current element
		if (isCurrent())
			addIndex = currentIndex + 1;
		else
			addIndex = manyItems;
		
		// If this is the first element added to the
		// sequence, add it to the end only
		if (manyItems == 0)
		{
			manyItems++;
			data[0] = element;
			currentIndex = 0;
		}
		else
		{
			manyItems++;
			
			try
			{
				if (getCapacity() < manyItems)
					newArray = new double[manyItems];
				else
					newArray = new double[getCapacity()];
			}
			catch(OutOfMemoryError e)
			{
				manyItems--;
				e.printStackTrace();
			}
			
			// Shift all elements and add the new one
			for (; x < manyItems; x++)
			{
				if (x < addIndex)
				{
					newArray[x] = data[x];
				}
				else if (x == addIndex)
				{
					newArray[x] = element;
					currentIndex = x;
				}
				else if (x > addIndex)
				{
					newArray[x] = data[x];
				}
			}
			
			// Update data
			data = newArray.clone();
		}
	}
	
	/**
	 * Remove the element at the current index of this sequence.
	 * @return boolean - true if successfully removed
	 */
	public boolean removeCurrent()
	{
		try
		{
			if (isCurrent())
			{
				int index = 0;
				int skipIndex = currentIndex;
				double[] newArray = data;
				int oldSize = size();
				
				// Wipe the data
				data = new double[getCapacity()];
				
				manyItems = 0;
				
				// Add the remaining elements
				for (; index < oldSize; index++)
				{
					if (index != skipIndex)
						addAfter(newArray[index]);
				}
			}
			
			return true;
		}
		catch(IllegalStateException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Add all of the elements from the given DoubleArraySeq
	 * to the end of this sequence.
	 * @param seq - the DoubleArraySeq containing the data to add
	 */
	public void addAll(DoubleArraySeq seq)
	{
		try
		{
			if (seq != null)
			{
				// Size the new sequence appropriately
				try
				{
					ensureCapacity(size() + seq.size());
					
					// Add the second sequence's elements
					for (seq.start(); seq.isCurrent(); seq.advance())
					{
						addAfter(seq.getCurrent());
					}
				}
				catch(OutOfMemoryError e)
				{
					e.printStackTrace();
				}
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
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
		DoubleArraySeq newSeq = new DoubleArraySeq();
		
		try
		{
			if (seq1 != null && seq2 != null)
			{
				// Size the new sequence appropriately
				try
				{
					newSeq.ensureCapacity(seq1.size() + seq2.size());
					
					// Add the first sequence's elements
					for (seq1.start(); seq1.isCurrent(); seq1.advance())
					{
						newSeq.addAfter(seq1.getCurrent());
					}
					
					// Add the second sequence's elements
					for (seq2.start(); seq2.isCurrent(); seq2.advance())
					{
						newSeq.addAfter(seq2.getCurrent());
					}
				}
				catch(OutOfMemoryError e)
				{
					e.printStackTrace();
				}
			}
			
			return newSeq;
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
			return null;
		}
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
		
		if (data.length < capacity)
		{
			try 
			{
				newArray = new double[capacity];
			}
			catch(OutOfMemoryError e)
			{
				e.printStackTrace();
			}
			
			System.arraycopy( data, 0, newArray, 0, data.length );
			
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
		// Instance variables
		double[] newArray = null;
		int x = 0;
		int addIndex = 0;
		
		// If this is the first element added to the
		// sequence, add it to the beginning only
		if (manyItems == 0)
		{
			manyItems++;
			data[0] = element;
			currentIndex = 0;
		}
		else
		{
			manyItems++;
			
			try
			{
				if (getCapacity() < manyItems)
					newArray = new double[manyItems];
				else
					newArray = new double[getCapacity()];
			}
			catch(OutOfMemoryError e)
			{
				manyItems--;
				e.printStackTrace();
			}
			
			// Shift all elements and add the new one
			for (; x < manyItems; x++)
			{
				if (x < addIndex)
				{
					newArray[x] = data[x];
				}
				else if (x == addIndex)
				{
					newArray[x] = element;
					currentIndex = x;
				}
				else if (x > addIndex)
				{
					newArray[x] = data[x - 1];
				}
			}
			
			// Update data
			data = newArray.clone();
		}
	}
	
	/**
	 * Remove the element at the front of this sequence.
	 */
	public void removeFromFront()
	{
		start();
		removeCurrent();
	}
	
	/**
	 * Add the specified element to the end of this sequence.
	 * @param element - the element to add to the end
	 */
	public void addToEnd(double element)
	{
		// If this is the first element added to the
		// sequence, add it to the end only
		if (manyItems == 0)
		{
			manyItems++;
			data[0] = element;
			currentIndex = 0;
		}
		else
		{
			try
			{
				ensureCapacity(manyItems + 1);
			}
			catch(OutOfMemoryError e)
			{
				e.printStackTrace();
			}
			
			currentIndex = size();
			addAfter(element);
		}
	}
	
	/**
	 * Remove the element at the end of this sequence.
	 */
	public void removeFromEnd()
	{
		currentIndex = size() - 1;
		removeCurrent();
	}
	
	/**
	 * Change the element at the end of this sequence
	 * to the element located at the current index.
	 */
	public void endToCurrent()
	{
		data[size() - 1] = getCurrent();
	}
	
	/**
	 * Get the element located at the specified index.
	 * @param index - the index to obtain the element from
	 * @return double - the element located at the specified index
	 */
	public double getElement(int index)
	{
		return data[index];
	}
	
	/**
	 * Change the element at the specified index
	 * to the element located at the current index.
	 * @param index - the index at which to change the element
	 */
	public void elementToCurrent(int index)
	{
		data[index] = getCurrent();
	}
}