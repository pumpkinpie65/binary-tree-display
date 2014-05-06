/*
 * David Zima
 * created 5.6.14  last updated 5.6.14
 * CS 182 Lab Project 5 Binary Tree Display
 * 
 * This class contains the binary tree data structure.
 */

package models;

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
}
