

import java.util.*;
import java.io.*;

/**
 * An implementation of a Node Class.
 * <p>
 * Uses an int value to store the key and two Node objects to store the left and right children.
 * @author Noah Rodal
 *
 */
class Node{
   int value;
   Node left, right;
   /**
     * Initializes an empty node with the specified value.
     * @param value Key of the node.
     */
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}
/**
 * An implementation of a Binary Search Tree.
 * <p>
 * Uses a node to store the root from the Node Class.
 * @author Noah Rodal
 *
 */

class BinarySearchTree{

   Node root = new Node(32);
   
   
   /**
    * Inserts a new node with the specified value starting from a root node.
    * @param root Root node of the tree/subtree.
    * @param value Value of the new node.
    * @return The new root node.
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /**
    * Traverses the tree printing an array of the values in the tree starting from the root.
    * @param root Root node of the tree.
   */
   public void preOrderTraversal(Node root){
      
      //check if root's children are null
      if (root.left!= null) {
         //if not, print the value of left child
         System.out.print(root.left.value + ", ");
         }
         if (root.left != null) {
            //then traverse left
            inOrderTraversal(root.left);
         }
         if (root.right != null) {
         //then print the value of right child
         System.out.print(root.right.value + ", ");
         }
         if (root.right != null) {
            //then traverse right
            inOrderTraversal(root.right);
         }
   }

   
   
   /**
    * Traverses the tree printing an array of values starting from the min value in the tree.
    * @param root Root node of the tree.
   */
   public void inOrderTraversal(Node root){
      
      //create stack of type node
      Stack<Node> stack = new Stack<Node>();
      //create an arraylist of type int
        ArrayList<Integer> orderList = new ArrayList<Integer>();
         //for loop to traverse the tree
        for (Node node = root;;)
        {
            //check if the current node is null
            if (node == null)
            {
               //check if the stack is empty
                if (stack.empty()) break;
               // set node to the top of the stack
                node = stack.pop();
                //add the value of the node to the array
                orderList.add(node.value);
                //set node to the right child
                node = node.right;
            }
            else
            {
               //add the node to the stack
                stack.push(node);
                //set node to the left child
                node = node.left;
            }
        }
        //convert the arraylist to an array
        int[] order = new int[orderList.size()];
        for (int i = 0; i < order.length; i++)
        {
            order[i] = orderList.get(i);
        }
        
        //print the array
        for (int i =0; i < order.length; i++){
         System.out.print(order[i] + ", ");
     }

   }
   
   
   
   /**
    * Traverses the tree printing an array of values starting from the max value in the tree.
    * @param root Root node of the tree.
   */
   public void postOrderTraversal(Node root){
      //implement me
   
      //create stack of type node
        Stack<Node> stack = new Stack<Node>();
        //create stack of type int
        Stack<Integer> stackCtr = new Stack<Integer>();
        //create an arraylist of type int
        ArrayList<Integer> orderList = new ArrayList<Integer>();
         //push the root into the stack
        stack.push(root);
        //push 0 into the stack
        stackCtr.push(0);

        //while loop to traverse the tree
        while (!stack.empty())
        {
            //create a counter using the counter stack
            int ctr = stackCtr.pop();
            //create a node using the node stack
            Node node = stack.peek();
            
            if (ctr == 0)
            {
                // First visit.
                stackCtr.push(1);

                if (node.left != null)
                {
                    stack.push(node.left);
                    stackCtr.push(0);
                }else{

                }
                
            }
            else if (ctr == 1)
            {
                // Second visit.
                // Left subtree done.
                stackCtr.push(2);

                if (node.right != null)
                {
                    stack.push(node.right);
                    stackCtr.push(0);
                }
            }
            else // ctr >= 2
            {
                // Third visit.
                // Right subtree done.
                stack.pop();
                orderList.add(node.value);
            }
         
        }
        //convert the arraylist to an array
        int[] order = new int[orderList.size()];
        for (int i = 0; i < order.length; i++)
        {
            order[i] = orderList.get(i);
        }
        //print the array
        for (int i =0; i < order.length; i++){
            System.out.print(order[i] + ", ");
        }
        
   }
   
   
   
   /**
    * Finds the node in the tree with the specified key.
    * @param root Root node of the tree.
    * @param key Value of the node to find.
    * @return True if the node is found, false otherwise.
   */
   public boolean find(Node root, int key){
      
      //check if the root is null
      if(root == null) {
         //if the root is null return false
         return false;
      
      }
      //check if the root value is equal to the key
      if (root.value == key){
         //if the root value is equal to the key return true
         return true;
      }
      //check if the key is less than the root value
      if (key < root.value){
         //if the key is less than the root value recursively call the function using the left child
         return find(root.left, key);
      } else {
         //if the key is greater than the root value recursively call the function using the right child
         return find(root.right, key);
      }
      
             
   }
   
   
   
   /**
    * Finds the node in the tree with the smallest key
    * @param root Root node of the tree
    * @return The value of the smallest key
   */
   public int getMin(Node root){
      //create a variable to store the value of the smallest key
      int min = 0;
      //check if the root is null
      if (root.left == null) {
         //if the root is null return the value of the smallest key
         min = root.value;
         return min;
      }
      //check if the value of the smallest key is less than the root value
      if (min > root.value) {
         //if the value of the smallest key is less than the root value return the value of the smallest key
         return min;

      } else {
         //if the value of the smallest key is greater than or equal to the root value recursively call the function using the left child
         return getMin(root.left);
      }

      
   }
  
  
  
   /**
    * Finds the node in the tree with the largest key
    * @param root Root node of the tree
    * @return the value of the largest key
   */
   public int getMax(Node root){
      //create a variable to store the value of the largest key
	  int max = 0;
     //check if the root is null
      if (root.right == null) {
         //if the root is null return the value of the largest key
         max = root.value;
         return max;
      }
      //check if the value of the largest key is greater than the root value
      if (max > root.value) {
         //if the value of the largest key is greater than the root value return the value of the largest key
         return max;

      } else {
         //if the value of the largest key is less than or equal to the root value recursively call the function using the right child
         return getMax(root.right);
      }
      
      
      
      

     
   }
   
   
   
   /**
    * Deletes the node in the tree with the specified key
    * @param root Root node of the tree
    * @param key Value of the node to delete
    * @return The new root of the tree
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}


/**
 * A Demo of the Binary Search Tree Class Methods
 * <p>
 * 
 * @author Noah Rodal
 *
 */
public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(t1.root,24);
      t1.insert(t1.root,80);
      t1.insert(t1.root,18);
      t1.insert(t1.root,9);
      t1.insert(t1.root,90);
      t1.insert(t1.root,22);
      

      
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.print("\npost-order : ");
      t1.postOrderTraversal(t1.root);
      System.out.print("\npre-order : " + t1.root.value + ",");
      t1.preOrderTraversal(t1.root);
      System.out.println();
      
      
      
   }  
}