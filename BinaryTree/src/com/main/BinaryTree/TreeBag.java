package com.main.BinaryTree;

import java.io.PrintWriter;

/**
 * A TreeBag is a binary tree data structure.
 * This tree can store any data type that is comparable.
 * 
 * @author Ryan Hochmuth & Jason Griffith
 *
 */
public class TreeBag implements Cloneable
{
   private BTNode root; // The top node in the tree
   
   /**
    * Add a new object to the tree.  If the object given
    * is the same as an object already in the tree,
    * overwrite the existing one.
    * @param x - the object to add
    */
   public void add(Comparable x)  
   {
      root = addNode (x,root);
   }

   /**
    * Handles the adding of a new object,
    * by adding it as a new node and
    * adding it to the tree recursively.
    * @param x - the object to add
    * @param p - the "head" node of the
    * 			 current branch being checked
    * @return p - the "head" node of the
    * 			  current branch being checked
    */
   private BTNode addNode(Comparable x, BTNode p)
   {
	  // There is no current "head"
      if (p == null)
         p = new BTNode(x, null, null); // Create the node - base case
      
      // The new object is less than the current "head"
      else if (x.compareTo(p.getData()) < 0)
         p.setLeft(addNode(x, p.getLeft())); // Traverse to the next left branch
      
      // The new object is greater than the current "head"
      else if(x.compareTo(p.getData()) > 0)  
         p.setRight(addNode(x, p.getRight())); // Traverse to the next right branch
      
      else // The new object is equal to the current "head"
         p.setData(x); // Update the existing object
      
      return p;
   }

   /**
    * Removes an object from the tree and then shifts any data
    * to fill any gaps while maintaining the trees status as a 
    * Binary search tree.
    * If the object was not found the tree remains the same.
    * @param target - the object to remove
    * @Return
    * 	True - the object was found
    * 	False - the object was not found
    */
   public boolean remove(Comparable target)
   { 
      boolean answer = false;
   
      Object obj = retrieve(target, root); // Find the given object
      
      if(obj != null) // If the object was found, remove it
      {
         root = removeNode(root, target);
         answer = true;
      }
      
      return answer;
   }

   /**
    * Handles the removal of a node in the tree.
    * @param p - the "head" node of the
    * 			 current branch being checked
    * @param target - the object to remove
    * @return - the "head" node of the
    * 			current branch being checked
    */
   private BTNode removeNode(BTNode p, Comparable target)
   {  
      if(p == null)  // The tree is empty / the target is not found 
         return p;
      
      int answer = target.compareTo(p.getData()); // Compare the object to remove 
      											  // to the current "head"
      
      if(answer == -1) // If the object to remove is < the current "head"
  	      p.setLeft(removeNode(p.getLeft(), target));
      
  	  else if(answer == 1) // If the object to remove is > the current "head"
  		  p.setRight(removeNode(p.getRight(), target));
      
      // If the node has two children 
      else if((p.getLeft() != null) && (p.getRight() != null)) 
   	  {      
    	  // Get the data in the right most node in the left subtree 
    	  p.setData(p.getLeft().getRightmostData());
    	  // Delete the right most data in the left subtree
    	  p.setLeft(p.getLeft().removeRightmost() );
  	  }
      
      else if (p.getLeft() ==null)           
         p = p.getRight(); // Only right child
      
      else                                              
		 p = p.getLeft(); // Only left child 
      
      return p;  
   }
   
   /**
    * Retrieve's the object being searched for.
    * The object given in the parameter only needs 
    * the information to compare.
    * @param obj - the object to retrieve
    * @param aNode - the "head" node of the
    * 			     current branch being checked
    * @return
    * 	null if the object wasn't found.
    * 	the object if it was found.
    */
   public Object retrieve(Comparable obj, BTNode aNode)
   {
      Comparable answer = null;
      
      // The node to retrieve = the current "head"
      if(obj.compareTo(aNode.getData()) == 0)
         answer = (Comparable)aNode.getData();
      
   	  // The node to retrieve > current "head"
      else if(obj.compareTo(aNode.getData()) > 0 && !aNode.isLeaf())
         answer = (Comparable)retrieve(obj, aNode.getRight());
      
      // The node to retrieve < current "head"
      else if(obj.compareTo(aNode.getData()) < 0 && !aNode.isLeaf())
         answer = (Comparable)retrieve(obj, aNode.getLeft());
      
      return answer; 
   }
   
   /**
    * Display all of the objects in
    * this tree in ascending order.
    * @param aNode - the root node of the tree
    * @param pw - the print writer to display to
    */
   public void display(BTNode aNode, PrintWriter pw)
   {
      if(aNode.getLeft() != null)
         display(aNode.getLeft(), pw);
      
      pw.println(aNode.getData().toString());
      
      if(aNode.getRight() != null)
         display(aNode.getRight(), pw); 
   }
   
   /**
    * Get the root node of this tree.
    * @return root
    */
   public BTNode getRoot()
   {
      return root;
   }  
} 