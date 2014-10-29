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
   private Node head;
   private Node tail;
   private Node cursor;
	
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
		   if (cursor == tail)
		   {
			   addNodeAfter(tail, element);
			   tail = tail.getLink();
			   cursor = tail;
			   manyNodes++;
		   }
		   else
		   {
			   addNodeAfter(cursor, element);
			   cursor = cursor.getLink();
			   manyNodes++;
		   }
	   }
	   else if (tail == null)
	   {
		   head = new Node(0, null);
		   tail = new Node(element, null);
		   cursor = tail;
		   head.setLink(cursor);
		   manyNodes++;
	   }
	   else
	   {
		   tail.setLink(new Node(element, null));
		   tail = tail.getLink();
		   manyNodes++;
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
	  // If there is a current element
      if (isCurrent())
      {
    	 addNodeAfter(precursorReturn(), element);
    	 cursor = precursorReturn();
    	 manyNodes++;
      }
      else
      {
    	  head.setLink(new Node(element, head.getLink()));
    	  cursor = head.getLink();
    	  manyNodes++;
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
      if (addend != null)
      {
    	  Node addHead = listCopy(addend.head);
    	  tail.setLink(addHead.getLink());
    	  manyNodes += addend.size();
    	  while(cursor.getLink() != null){
    		advance();  
    	  }
      tail = cursor;
      }
      else
    	  throw new NullPointerException("The sequence to add is null.");
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
	   if (isCurrent())
		   cursor = cursor.getLink();
	   else
		   throw new IllegalStateException();
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
   public DoubleLinkedSeq clone()
   {  
		// Clone a DoubleLinkedSeq object.
	    DoubleLinkedSeq answer;
	      
	    try
	    {
	       answer = (DoubleLinkedSeq) super.clone();
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
	    
	    // If the original sequence has no current element
	    if (!isCurrent())
	    {
	    	 try
	 	    {
	 	    	Node[] nodes = listCopyWithTail(head);
	 	    	answer.head = nodes[0];
	 		    answer.tail = nodes[1];
	 		    answer.cursor = null;
	 		    answer.manyNodes = manyNodes;
	 	    }
	 	    catch (OutOfMemoryError e)
	 	    {
	 	    	throw new OutOfMemoryError
	 	        ("Out of memory");
	 	    }
	    }
	    // If the original sequence's current element is the first element
	    else if (cursor == head.getLink())
	    {
	    	 try
	 	    {
	 	    	Node[] nodes = listCopyWithTail(head);
	 	    	answer.head = nodes[0];
	 		    answer.tail = nodes[1];
	 		    answer.cursor = nodes[0].getLink();
	 		    answer.manyNodes = manyNodes;
	 	    }
	 	    catch (OutOfMemoryError e)
	 	    {
	 	    	throw new OutOfMemoryError
	 	        ("Out of memory");
	 	    }
	    }
	    // If the current element equals tail
	    else if (cursor == tail)
	    {
	    	Node[] nodes = listCopyWithTail(head);
	    	answer.head = nodes[0];
	    	answer.tail = nodes[1];
	    	answer.cursor = nodes[0].getLink();
	    	answer.manyNodes = manyNodes;
	    }
	    // If the original sequence's current element is after the first element
	    else if (cursor != head 
	    		&& cursor != head.getLink()
	    		&& cursor != tail)
	    {
	    	 try
	 	    {
	 	    	Node[] part1 = listPart(head, cursor);
	 	    	Node[] part2 = listPart(cursor.getLink(), tail);
	 	    	answer.head = part1[0];
	 	    	part1[1].setLink(part2[0]);
	 	    	answer.tail = part2[1];
	 	    	answer.cursor = part1[1];
	 	    	answer.manyNodes = manyNodes;
	 	    }
	 	    catch (OutOfMemoryError e)
	 	    {
	 	    	throw new OutOfMemoryError
	 	        ("Out of memory");
	 	    }
	    }
	      
	    return answer;
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
	   DoubleLinkedSeq objReturn;
	   
	  try
	  {
		  if (s1.isCurrent() && s2.isCurrent())
		  {
			  try
			  {
				  objReturn = new DoubleLinkedSeq();
			  }
			  catch (OutOfMemoryError e)
			  {
				  throw new OutOfMemoryError();
			  }
			   
			  Node[] s1Nodes;
			   
			  Node copyHead;
		      Node copyTail;
		      Node[] answer = new Node[3];
		      Node source = s1.head;
		     
		      // Handle the special case of the empty list.   
		      if (source == null)
		         return null; 
		      
		      // Make the first node for the newly created list.
		      copyHead = new Node(source.getData(), null);
		      copyTail = copyHead;
		      
		      // Make the rest of the nodes for the newly created list.
		      while (source.getLink() != null)
		      {
		          source = source.getLink();
		          copyTail.setLink(new Node(source.getData(), copyTail.getLink()));
		          copyTail = copyTail.getLink();
		      }
		      
		      // Return the head and tail references.
		      answer[0] = copyHead;
		      answer[1] = copyTail;
		      
			  s1Nodes = answer; 
		      
			   Node[] s2Nodes;
			  
			  Node copyHead2;
		      Node copyTail2;
		      Node[] answer2 = new Node[3];
		      Node source2 = s2.head;
		     
		      // Handle the special case of the empty list.   
		      if (source2 == null)
		         return null; 
		      
		      // Make the first node for the newly created list.
		      copyHead2 = new Node(source2.getData(), null);
		      copyTail2 = copyHead2;
		      
		      // Make the rest of the nodes for the newly created list.
		      while (source2.getLink() != null)
		      {
		          source2 = source2.getLink();
		          copyTail2.setLink(new Node(source2.getData(), copyTail2.getLink()));
		          copyTail2 = copyTail2.getLink();
		      }
		      
		      // Return the head and tail references.
		      answer2[0] = copyHead2;
		      answer2[1] = copyTail2;
		      
		      s2Nodes = answer2;
			  
			   s1Nodes[1].setLink(s2Nodes[0].getLink());
			   
			   objReturn.head = s1Nodes[0];
			   objReturn.tail = s2Nodes[1];
			   objReturn.cursor = s1Nodes[0];
			   objReturn.manyNodes = s1.manyNodes + s2.manyNodes;
			   
			   return objReturn;
		  }
	  }
	  catch (NullPointerException e)
	  {
		  System.out.println(e);
	  }
	  
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
	   if (isCurrent())
	   {
		   return cursor.getData();
	   }
	   else
		   throw new IllegalStateException();
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
	   if (cursor != null && cursor.getLink() != head)
		   return true;
	   
       return false;
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
	   if (isCurrent())
	   {
		   Node preCursor = precursorReturn();
		   preCursor.setLink(cursor.getLink());
		   cursor = cursor.getLink();
		   manyNodes--;
	   }
	   else
		   throw new IllegalStateException();
   }
                 
   /**
   * Determine the number of elements in this sequence.
   * @return the number of elements in this sequence
   **/ 
   public int size( )
   { 
       return manyNodes;
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
	   cursor = head.getLink(); 
   }
   
	/**
	 * Add the specified element to the front of this sequence.
	 * @param element - the element to add to the front
	 */
	public void addToFront(double element)
	{
		head.setLink(new Node(element, head.getLink()));
  	  	cursor = head.getLink();
  	  	manyNodes++;
	}
	
	/**
	 * Remove the element at the front of this sequence.
	 */
	public void removeFromFront()
	{
	    head.setLink(head.getLink().getLink());
	    cursor = head.getLink();
	    manyNodes--;
	}
	
	/**
	 * Add the specified element to the end of this sequence.
	 * @param element - the element to add to the end
	 */
	public void addToEnd(double element)
	{
		tail.setLink(new Node(element, null));
		tail = tail.getLink();
		cursor = tail;
		manyNodes++;
	}
	
	/**
	 * Change the element at the end of this sequence
	 * to the element located at the current index.
	 */
	public void endToCurrent()
	{
		if (isCurrent())
			tail.setData(getCurrent());
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
		Node tempNode = head.getLink();
		
		for (int x = 0; x < index; x++)
		{
			try
			{
				tempNode = tempNode.getLink();
				
			}
			catch (IllegalStateException e)
			{
				throw new IllegalStateException();
			}
		}
		cursor = tempNode;
		return tempNode.getData();
	}
	
	/**
	 * Change the element at the specified index
	 * to the element located at the current index.
	 * @param index - the index at which to change the element
	 */
	public void elementToCurrent(int index)
	{
		if (isCurrent())
		{
			Node tempNode = head.getLink();
		
			for (int x = 0; x < index; x++)
			{
				try
				{
					tempNode = tempNode.getLink();
				}
				catch (IllegalStateException e)
				{
					throw new IllegalStateException();
				}
			}
			
			tempNode.setData(cursor.getData());
		}
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
		if (isCurrent())
		{
			Node tempNode = head.getLink();
		
			for (int x = 0; x < index; x++)
			{
				try
				{
					tempNode = tempNode.getLink();
				}
				catch (IllegalStateException e)
				{
					throw new IllegalStateException();
				}
			}
			
			tempNode.setData(element);
		}
		else
			throw new IllegalStateException("There is no current element.");
	}
	
	/**
	 * Get the precursor of this sequence.
	 * @return DoubleNode - the precursor
	 */
	public Node precursorReturn()
	{
		Node savedCursor = cursor;
		Node savedPreCursor = null;
		
		for (start(); isCurrent(); advance())
		{
			if (cursor == savedCursor)
			{
				return savedPreCursor;
			}
			savedPreCursor = cursor;
		}
		
		return null;
	}
	
	 /**
     * Modification method to add a new node after this node.   
     * @param item
     *   the data to place in the new node
     * @postcondition
     *   A new node has been created and placed after this node.
     *   The data for the new node is item. Any other nodes
     *   that used to be after this node are now after the new node.
     * @exception OutOfMemoryError
     *   Indicates that there is insufficient memory for a new 
     *   DoubleNode. 
     **/
     public void addNodeAfter(Node node, double item)   
     {
        node.setLink(new Node(item, node.getLink()));
     } 
     
   /**
   * Copy a list.
   * @param source
   *   the head of a linked list that will be copied (which may be
   *   an empty list in where source is null)
   * @return
   *   The method has made a copy of the linked list starting at 
   *   source. The return value is the head reference for the
   *   copy. 
   * @exception OutOfMemoryError
   *   Indicates that there is insufficient memory for the new list.   
   **/ 
   public Node listCopy(Node source)
   {
      Node copyHead;
      Node copyTail;
      
      // Handle the special case of the empty list.
      if (source == null)
         return null;
         
      // Make the first node for the newly created list.
      copyHead = new Node(source.getData(), null);
      copyTail = copyHead;
      
      // Make the rest of the nodes for the newly created list.
      while (source.getLink() != null)
      {
         source = source.getLink();
         addNodeAfter(copyTail, source.getData());
         copyTail = copyTail.getLink();
      }
 
      // Return the head reference for the new list.
      return copyHead;
   }
   
   /**
   * Copy a list, returning both a head and tail reference for the copy.
   * @param source
   *   the head of a linked list that will be copied (which may be
   *   an empty list in where source is null)
   * @return
   *   The method has made a copy of the linked list starting at 
   *   source.  The return value is an
   *   array where the [0] element is a head reference for the copy and the [1]
   *   element is a tail reference for the copy.
   * @exception OutOfMemoryError
   *   Indicates that there is insufficient memory for the new list.   
   **/
   public Node[] listCopyWithTail(Node source)
   {
      Node copyHead;
      Node copyTail;
      Node[] answer = new Node[3];
     
      // Handle the special case of the empty list.   
      if (source == null)
         return answer; // The answer has two null references .
      
      // Make the first node for the newly created list.
      copyHead = new Node(source.getData(), null);
      copyTail = copyHead;
      
      // Make the rest of the nodes for the newly created list.
      while (source.getLink() != null)
      {
          source = source.getLink();
          addNodeAfter(copyTail, source.getData());
          copyTail = copyTail.getLink();
      }
      
      // Return the head and tail references.
      answer[0] = copyHead;
      answer[1] = copyTail;
      return answer;
   }
   
   /**
   * Compute the number of nodes in a linked list.
   * @param head
   *   the head reference for a linked list (which may be an empty list
   *   with a null head)
   * @return
   *   the number of nodes in the list with the given head    
   **/   
   public int listLength(Node head)
   {
      Node cursor;
      int answer;
      
      answer = 0;
      for (cursor = head; cursor != null; cursor = cursor.getLink())
         answer++;
        
      return answer;
   }
   
   /**
   * Copy part of a list, providing a head and tail reference for the new copy. 
   * @param start/end
   *   references to two nodes of a linked list
   * @param copyHead/copyTail
   *   the method sets these to refer to the head and tail node of the new
   *   list that is created
   * @precondition
   *   start and end are non-null references to nodes
   *   on the same linked list,
   *   with the start node at or before the end node. 
   * @return
   *   The method has made a copy of the part of a linked list, from the
   *   specified start node to the specified end node. The return value is an
   *   array where the [0] component is a head reference for the copy and the
   *   [1] component is a tail reference for the copy.
   * @exception IllegalArgumentException
   *   Indicates that start and end are not references
   *   to nodes on the same list.
   * @exception NullPointerException
   *   Indicates that start is null.
   * @exception OutOfMemoryError
   *   Indicates that there is insufficient memory for the new list.    
   **/   
   public Node[ ] listPart(Node start, Node end)
   {
      Node copyHead;
      Node copyTail;
      Node cursor;
      Node[] answer = new Node[2];
      
      // Make the first node for the newly created list. Notice that this will
      // cause a NullPointerException if start is null.
      copyHead = new Node(start.getData(), null);
      copyTail = copyHead;
      cursor = start;
      
      // Make the rest of the nodes for the newly created list.
      while (cursor != end)
      {
         cursor = cursor.getLink();
         if (cursor == null)
            throw new IllegalArgumentException
            ("end node was not found on the list");
         addNodeAfter(copyTail, cursor.getData());
         copyTail = copyTail.getLink();
      }
      
      // Return the head and tail references
      answer[0] = copyHead;
      answer[1] = copyTail;
      return answer;
   }        
   
   /**
   * Find a node at a specified position in a linked list.
   * @param head
   *   the head reference for a linked list (which may be an empty list in
   *   which case the head is null)
   * @param position
   *   a node number
   * @precondition
   *   position > 0.
   * @return
   *   The return value is a reference to the node at the specified position in
   *   the list. (The head node is position 1, the next node is position 2, and
   *   so on.) If there is no such position (because the list is too short),
   *   then the null reference is returned.
   * @exception IllegalArgumentException
   *   Indicates that position is not positive.    
   **/   
   public Node listPosition(Node head, int position)
   {
      Node cursor;
      int i;
      
      if (position <= 0)
           throw new IllegalArgumentException("position is not positive");
      
      cursor = head;
      for (i = 1; (i < position) && (cursor != null); i++)
         cursor = cursor.getLink();

      return cursor;
   }

   /**
   * Search for a particular piece of data in a linked list.
   * @param head
   *   the head reference for a linked list (which may be an empty list in
   *   which case the head is null)
   * @param target
   *   a piece of data to search for
   * @return
   *   The return value is a reference to the first node that contains the
   *   specified target. If there is no such node, the null reference is 
   *   returned.     
   **/   
   public Node listSearch(Node head, double target)
   {
      Node cursor;
      
      for (cursor = head; cursor != null; cursor = cursor.getLink())
         if (target == cursor.getData())
            return cursor;
        
      return null;
   }

   /**
   * Modification method to remove the node after this node.
   * @precondition
   *   This node must not be the tail node of the list.
   * @postcondition
   *   The node after this node has been removed from the linked list.
   *   If there were further nodes after that one, they are still
   *   present on the list.
   * @exception NullPointerException
   *   Indicates that this was the tail node of the list, so there is nothing
   *   after it to remove.
   **/
   public void removeNodeAfter(Node node)   
   {
      node.setLink(node.getLink().getLink());
   }  
}