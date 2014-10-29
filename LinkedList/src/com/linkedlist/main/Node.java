package com.linkedlist.main;

/******************************************************************************
* A DoubleNode provides a node for a linked list with 
* double data in each node.
* 
* Lists of nodes can be made of any length, limited only by the amount of
* free memory in the heap. But beyond Integer.MAX_VALUE (2,147,483,647),
* the answer from listLength is incorrect because of arithmetic
* overflow. 
*
* @author Ryan Hochmuth & Jason Griffith
*
* @version Oct. 21, 2014
******************************************************************************/
public class Node implements Cloneable
{
   private double data;
   private Node link;   

   /**
   * Initialize a node with a specified initial data and link to the next
   * node. Note that the initialLink may be the null reference, 
   * which indicates that the new node has nothing after it.
   * @param initialData
   *   the initial data of this new node
   * @param initialLink
   *   a reference to the node after this new node--this reference may be null
   *   to indicate that there is no node after this new node.
   * @postcondition
   *   This node contains the specified data and link to the next node.
   **/   
   public Node(double initialData, Node initialLink)
   {
      data = initialData;
      link = initialLink;
   }          
   
   /**
   * Accessor method to get the data from this node.
   * @return data - the data from this node
   **/
   public double getData()   
   {
      return data;
   }
   
   /**
   * Accessor method to get a reference to the next node after this node.
   * @return
   *   a reference to the node after this node (or the null reference if there
   *   is nothing after this node)
   **/
   public Node getLink()
   {
      return link;                                               
   } 
   
   /**
    * Modification method to set the data in this node.   
    * @param newData
    *   the new data to place in this node
    * @postcondition
    *   The data of this node has been set to newData.
    **/
    public void setData(double newData)   
    {
       data = newData;
    }                                                               
    
    /**
    * Modification method to set the link to the next node after this node.
    * @param newLink
    *   a reference to the node that should appear after this node in the linked
    *   list (or the null reference if there is no node after this node)
    * @postcondition
    *   The link to the node after this node has been set to newLink.
    *   Any other node (that used to be in this link) is no longer connected to
    *   this node.
    **/
    public void setLink(Node newLink)
    {                    
       link = newLink;
    }
}