/*
 * David Zima
 * created 5.6.14  last updated 5.6.14
 * CS 182 Lab Project 5 Binary Tree Display
 * 
 * This class extends Node to create a node with data for a binary tree.
 */

package models;

/**
 *
 * @author David
 */
public class DataNode extends Node {
    public int key;
    public double dData;
    
    public void displayNode()
    {
        System.out.println("{");
        System.out.println(key);
        System.out.println(", ");
        System.out.println(dData);
        System.out.println("} ");
    }
}
