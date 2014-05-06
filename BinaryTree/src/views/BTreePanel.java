/*
 * David Zima
 * created 5.6.14  last updated 5.6.14
 * CS 182 Lab Project 5 Binary Tree Display
 * 
 * This class extends Node to create a node with data for a binary tree.
 */

package views;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author David
 */
public class BTreePanel extends JPanel {

 ////////////    PAINT   ////////////////////////////////
  public void paintComponent (Graphics g) {
    //
         g.setFont(Fonts.plainfont);
         g.drawString("I am paint",20,30);
         /*   UNCOMMENT WHEN YOU WANT TO DISPLAY TREE TO DOS SCREEN
         theTree.displayTree();
        */

        /*   UNCOMMENT WHEN YOU HAVE THE GUI TREE CODE
         theTree.displayTree(g,theTree.getRoot(),WINWIDTH/2,80, 1);
        */
  }
}
