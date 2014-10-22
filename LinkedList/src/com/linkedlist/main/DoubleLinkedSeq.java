package com.linkedlist.main;

/******************************************************************************
* A DoubleLinkedSeq is a collection of double numbers.
* The sequence can have a special "current element," which is specified and 
* accessed through four methods that are not available in the sequence class 
* (start, getCurrent, advance and isCurrent).
*
*@author Ryan Hochmuth & Jason Griffith
*
* @version Oct 20, 2014
******************************************************************************/
public class DoubleLinkedSeq implements Cloneable
{ 
   /**
   * Initialize an empty sequence.
   * Postcondition:
   *   This sequence is empty.
   **/ 
   
   private int manyNodes;
   private DoubleNode head;
   private DoubleNode tail;
   private DoubleNode cursor;
	
   public DoubleLinkedSeq()
   { 
	   this.manyNodes = 0;
	   this.head = null;
	   this.tail = null;
	   this.cursor = null;
   }
 
   /**
   * Add a new element to this sequence, after the current element. 
   * @param element - the new element that is being added
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed after the current
   *   element. If there was no current element, then the new element is placed
   *   at the end of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addAfter(double element)
   {
	   // If there is a current element
	   if (isCurrent())
	   {
		   cursor.addNodeAfter(element);
		   cursor = cursor.getLink();
	   }
	   else
	   {
		   tail.setLink(new DoubleNode(element, null));
		   tail = tail.getLink();
	   }
   }

   /**
   * Add a new element to this sequence, before the current element. 
   * @param element - the new element that is being added
   * <dt><b>Postcondition:</b><dd>
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed before the current
   *   element. If there was no current element, then the new element is placed
   *   at the start of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for a new node.
   **/
   public void addBefore(double element)
   {
      if (isCurrent()){
    	 precursorReturn().addNodeAfter(element);
    	 cursor = precursorReturn().getLink();
      }
   
      else{
    	  head.setLink(new DoubleNode(element,head.getLink()));
    	  cursor = head.getLink();
      }
   }
   
   
   /**
   * Place the contents of another sequence at the end of this sequence.
   * @param addend - a sequence whose contents will be placed at the 
   * 				 end of this sequence
   * <dt><b>Precondition:</b><dd>
   *   The parameter, addend, is not null. 
   * <dt><b>Postcondition:</b><dd>
   *   The elements from addend have been placed at the end of 
   *   this sequence. The current element of this sequence remains where it 
   *   was, and the addend is also unchanged.
   * @exception NullPointerException
   *   Indicates that addend is null. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of this sequence.
   **/
   public void addAll(DoubleLinkedSeq addend)
   {
      
   }   
   
   /**
   * Move forward, so that the current element is now the next element in
   * this sequence.
   * <dt><b>Precondition:</b><dd>
   *   isCurrent() returns true. 
   * <dt><b>Postcondition:</b><dd>
   *   If the current element was already the end element of this sequence 
   *   (with nothing after it), then there is no longer any current element. 
   *   Otherwise, the new element is the element immediately after the 
   *   original current element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   advance may not be called.
   **/
   public void advance( )
   {
      
   }
   
   /**
   * Generate a copy of this sequence.
   * @return
   *   The return value is a copy of this sequence. Subsequent changes to the
   *   copy will not affect the original, nor vice versa. Note that the return
   *   value must be type cast to a DoubleLinkedSeq before it can be used.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public DoubleLinkedSeq clone( )
   {  
      return null;
   }
   
   /**
   * Create a new sequence that contains all the elements from one sequence
   * followed by another.
   * @param s1 - the first of two sequences
   * @param s2 - the second of two sequences
   * <dt><b>Precondition:</b><dd>
   *   Neither s1 nor s2 is null.
   * @return
   *   a new sequence that has the elements of s1 followed by the
   *   elements of s2 (with no current element)
   * @exception NullPointerException.
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new sequence.
   **/   
   public static DoubleLinkedSeq catenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2)
   {
      return null;
   }

   /**
   * Accessor method to get the current element of this sequence.
   * <dt><b>Precondition:</b><dd>
   *   isCurrent() returns true.
   * @return double - the current element of this sequence
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   getCurrent may not be called.
   **/
   public double getCurrent( )
   {
      return 0;
   }
   
   /**
   * Accessor method to determine whether this sequence has a specified 
   * current element that can be retrieved with the 
   * getCurrent method.
   * @return
   *   true (there is a current element) or false (there is no current element at the moment)
   **/
   public boolean isCurrent( )
   {
      return true;
   }
              
   /**
   * Remove the current element from this sequence.
   * <dt><b>Precondition:</b><dd>
   *   isCurrent() returns true.
   * <dt><b>Postcondition:</b><dd>
   *   The current element has been removed from this sequence, and the 
   *   following element (if there is one) is now the new current element. 
   *   If there was no following element, then there is now no current 
   *   element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   removeCurrent may not be called. 
   **/
   public void removeCurrent( )
   {
      
   }
                 
   /**
   * Determine the number of elements in this sequence.
   * @return the number of elements in this sequence
   **/ 
   public int size( )
   {
      return 0;
   }
   
   /**
   * Set the current element at the front of this sequence.
   * <dt><b>Postcondition:</b><dd>
   *   The front element of this sequence is now the current element (but 
   *   if this sequence has no elements at all, then there is no current 
   *   element).
   **/ 
   public void start( )
   {
      
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
		for(int i = 0; i < manyItems - 1; i++)
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
		currentIndex = index;
		
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
	
	/**
	 * Change the element at the specified index
	 * to the specified element.
	 * @param index - the index at which to change the element
	 * @param element - the element to change to
	 */
	public void changeElementAtIndex(int index, double element)
	{
		if (index < manyItems)
			data[index] = element;
		else
			throw new IllegalStateException("There is no current element.");
	}
	
	public DoubleNode precursorReturn(){
		DoubleNode savedCursor = cursor;
		DoubleNode savedPreCursor = null;
		for (start();isCurrent();advance()){
			if (cursor == savedCursor){
				return savedPreCursor;
			}
			savedPreCursor=cursor;
		}		
		return null;
	}
}