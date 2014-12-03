package com.main.BinaryTree;

import java.io.PrintWriter;

public class TreeBag
{
   private BTNode root;
   
   //Adds a new object to the tree sorted by their object id
   //if the object number is already stored in the tree then that object
   //is overwriten
   //@Post-Condition
   //    a new object has been added to the tree
   //    at the next available place while maintaining order
   //    of object id.
   public void add(Comparable x)  
   {
      root = addNode (x,root);
   }

   
   private BTNode addNode(Comparable x, BTNode p)
   {
      if (p == null)
         //create the node  - base case
         p = new BTNode(x,null,null);
      else if (x.compareTo(p.getData())<0)
         p.setLeft(addNode(x,p.getLeft()));
      else if(x.compareTo(p.getData())>0)  
         p.setRight(addNode(x,p.getRight()));
      else // keys are equal - replace with new data
         p.setData(x);
      return p;
   }

   
   //Removes an object from the tree and then shifts any data
   //to fill any gaps while maintaining the trees status as a 
   //bianary search tree
   //If the object was not found the tree remains the same
   //@Precondition
   //    The tree must be a bianary search tree
   //@Postcondition
   //    If the object was found it has been removed 
   //@Return
   //    True - the object was found
   //    False - the object was not found  
   public boolean remove(Comparable target)
   { 
      boolean answer = false;
   
      Object obj = retrieve(target, root);
      
      if(obj != null)
      {
         root = removeNode(root, target);
         answer = true;
      }
      
      return answer;
   }

   private BTNode removeNode(BTNode p, Comparable target)
   {  
      if(p == null)  // tree is empty, target is not found 
         return p;
      
      int answer = target.compareTo(p.getData());
      
   		if(answer == -1) 
  	      p.setLeft( removeNode( p.getLeft(), target));
  	   else if(answer == 1)
         p.setRight( removeNode(p.getRight(), target));
          
         //found the node to be removed

         //if the node has two children 
      else if((p.getLeft() != null) && (p.getRight() != null)) 
   	{      
 		   // get the data in the right most node in the left subtree 
         p.setData(p.getLeft().getRightmostData());
        	// delete the right most data in the left subtree
         p.setLeft(p.getLeft().removeRightmost() );
  	   }

      else if (p.getLeft() ==null)           
      //only right child
         p = p.getRight();
      else                                              
      // only left child 
		   p = p.getLeft();
      return p;  
   }
   
   //Retrieve's the object being searched for.
   //The object given in the parameter only needs the information to compare
   //@Return
   //    if found the object being searched for is returned
   //    if not found the return is null
   public Object retrieve(Comparable obj, BTNode aNode)
   {
      Comparable answer = null;
      
      if(obj.compareTo(aNode.getData()) == 0)
         answer = (Comparable)aNode.getData();
      else if(obj.compareTo(aNode.getData())>0 && !aNode.isLeaf())
         answer = (Comparable)retrieve(obj, aNode.getRight());
      else if(obj.compareTo(aNode.getData())<0 && !aNode.isLeaf())
         answer = (Comparable)retrieve(obj, aNode.getLeft());
      
      return answer; 
   }
   
   // Display all the objects in the tree
   public void display(BTNode aNode, PrintWriter pw)
   {
      if(aNode.getLeft() != null)
         display(aNode.getLeft(), pw);
      pw.println(aNode.getData().toString());
      if(aNode.getRight() != null)
         display(aNode.getRight(), pw); 
   }
   
   //method to return the root of the tree
   public BTNode getRoot()
   {
      return root;
   }  
} 