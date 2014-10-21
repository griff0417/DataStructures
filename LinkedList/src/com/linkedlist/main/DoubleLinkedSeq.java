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
   public DoubleLinkedSeq()
   {
   Hello   
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
   public void addAfter(int element)
   {
      
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
   public void addBefore(int element)
   {
      
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
   public Object clone( )
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
   public double isCurrent( )
   {
      return 0;
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
}