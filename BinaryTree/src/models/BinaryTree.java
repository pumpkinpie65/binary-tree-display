/*
 * David Zima
 * created 5.6.14  last updated 5.6.14
 * CS 182 Lab Project 5 Binary Tree Display
 * 
 * This class contains the binary tree data structure.
 */

package models;

import java.util.Stack;

/**
 *
 * @author David
 */
public class BinaryTree {
    
    private DataNode root;
    
    public BinaryTree()
    {
        root = null;
    }
    
    public DataNode getRoot()
    {
        return root;
    }
    
    public DataNode find(int searchKey)
    {
        DataNode current = root;
        
        while (current.key != searchKey)
        {
            if (searchKey < current.key)
            {
                current = (DataNode) current.leftChild;
            }
            else
            {
                current = (DataNode) current.rightChild;
            }
            
            if (current == null)
            {
                return null;
            }
        }
        
        return current;
    }
    
    public void insert(int key, double dd)
    {
        DataNode newNode = new DataNode();
        newNode.key = key;
        newNode.dData = dd;
        if (root == null)
        {
            root = newNode;
        }
        else
        {
            DataNode current = root;
            DataNode parent;
            while (true)
            {
                parent = current;
                
                if (key < current.key)
                {
                    current = (DataNode) current.leftChild;
                    
                    if (current == null)
                    {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else
                {
                    current = (DataNode) current.rightChild;
                    
                    if (current == null)
                    {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
    
    /*
     * don't need this for project.  on page 408
    
    public boolean delete (int key)
    {
        DataNode current = root;
        DataNode parent = root;
        boolean isLeftChild = true;
        
        while (current.key != key)  //search for node
        {
            parent = current;
            if (key < current.key)  //go left?
            {
                isLeftChild = true;
                current = (DataNode) current.leftChild;
            }
            else                    //or go right?
            {
                isLeftChild = false;
                current = (DataNode) current.rightChild;
            }
            
            if (current == null)
            {
                return false;
            }
        }
        //fouund node to delete
        
        //if no children, simply delete it
        if (current.leftChild == null && current.rightChild == null)
        {
            if (current == root)    //if root,
            {
                root = null;        //tree is empty
            }
            else if (isLeftChild)
            {
                parent.leftChild = null;
            }
            else
            {
                parent.rightChild = null;
            }
        }
        //if no right child, replace with left subtree
        else if (current.rightChild == null)
        {
            if (current == root)
            {
                root = (DataNode) current.leftChild;
            }
            else if (isLeftChild)
            {
                
            }
        }
    }*/
    
    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;   //is this the limit of nodes in the tree?
        boolean isRowEmpty = false;
        System.out.println(
        "....................................................................");
        while(isRowEmpty == false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;
            
            for (int j = 0; j < nBlanks; j++)
            {
                System.out.print(' ');
            }
            
            while (globalStack.isEmpty() == false)
            {
                DataNode temp = (DataNode) globalStack.pop();
                if (temp != null)
                {
                    System.out.print(temp.key);
                    localStack.push((DataNode) temp.leftChild);
                    localStack.push((DataNode) temp.rightChild);
                    
                    if (temp.leftChild != null || temp.rightChild != null)
                    {
                        isRowEmpty = false;
                    }
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                {
                    System.out.print(' ');
                }
            }//end while globalStack not empty
            
            System.out.println();
            
            nBlanks /= 2;
            
            while (localStack.isEmpty() == false)
            {
                globalStack.push((DataNode) localStack.pop());
            }
        } //end while isRowEmpty is false
        
        System.out.println(
        "....................................................................");
    }   //end displayTree()
}
