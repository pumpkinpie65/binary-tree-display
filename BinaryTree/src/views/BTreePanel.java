/*
 * David Zima
 * created 5.6.14  last updated 5.6.14
 * CS 182 Lab Project 5 Binary Tree Display
 * 
 * This class will draw the binary tree to the screen.
 */

package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import models.BinaryTree;
import models.DataNode;

/**
 *
 * @author David
 */
public class BTreePanel extends JPanel {

    BinaryTree bTree;
    
    public static void main(String[] args) {
            Window tpo = new Window();

            tpo.addWindowListener(new WindowAdapter() {   // this exits the program when X box clicked
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
    }
    
    public void setBinaryTree(BinaryTree newBTree)
    {
        bTree = newBTree;
    }
    
 ////////////    PAINT   ////////////////////////////////
  public void paintComponent (Graphics g) {
    //
         g.setFont(Fonts.plainfont);
         //g.drawString("I am paint",20,30);    //I think I'm done with this
         /*   UNCOMMENT WHEN YOU WANT TO DISPLAY TREE TO DOS SCREEN
         theTree.displayTree();
        */

        /*   UNCOMMENT WHEN YOU HAVE THE GUI TREE CODE
         theTree.displayTree(g,theTree.getRoot(),WINWIDTH/2,80, 1);
        */
         
         //g.drawOval(getWidth() / 2, getHeight() - (getHeight() - 10), 20, 20);
         
         /*
         MY STUFF
         
         int x = getWidth() / 2;
         int y =  getHeight() - (getHeight() - 20);
         int diameter = 20;
         drawCenteredCircle(g, x, y, diameter);
         drawLeftChildLine(g, x, y);
         drawRightChildLine(g, x, y);
         */
         if (bTree != null)
         {
            int x = getWidth() / 2;
            int y =  getHeight() - (getHeight() - 20);
             
             displayBTree(g, bTree.getRoot(), x, y, 1);
         }
         
  }
  
  public void displayBTree(Graphics g, DataNode node, int x, int y, int level)
  {
      /*if (level == 1)
      {
          drawCenteredCircle(g, x, y, 24);
          drawLeftChildLine(g, x, y);
          drawRightChildLine(g, x, y);
          drawDataInCircle(g, "" + node.dData, x, y, 24);
      }*/

      print("leftChild is null: " + (node.leftChild == null));
      
      if (node.leftChild != null)
      {
          print("in leftChild loop");
          drawCenteredCircle(g, x, y, 60);
          drawLeftChildLine(g, x, y);
          drawRightChildLine(g, x, y);
          drawDataInCircle(g, "" + node.dData, x, y, 60);
          displayBTree(g, (DataNode) node.leftChild, x / 2, y + 30, ++level);
      }
      
      if (node.rightChild != null)
      {
          print("in rightChild loop");
          drawCenteredCircle(g, x, y, 24);
          drawLeftChildLine(g, x, y);
          drawRightChildLine(g, x, y);
          drawDataInCircle(g, "" + node.dData, x, y, 24);
          displayBTree(g, (DataNode) node.rightChild, x / 2, y + 30, ++level);
      }
  }
  
  /**
   * 
   * @param g
   * @param x x coordinate of center of circle
   * @param y y coordinate of center of circle
   * @param d diameter of circle
   */
  public void drawCenteredCircle(Graphics g, int x, int y, int d) {
        x = x-(d/2);
        y = y-(d/2);
        g.setColor(Color.BLUE);
        //g.drawOval(x,y,d,d);
        g.fillOval(x, y, d, d);
    }
  
  public void drawLeftChildLine(Graphics g, int circleCenterX, int circleCenterY)
  {
      g.drawLine(circleCenterX, circleCenterY, circleCenterX - (getWidth() / 4), circleCenterY + (getHeight() / 4));
  }
  
   public void drawRightChildLine(Graphics g, int circleCenterX, int circleCenterY)
  {
      g.drawLine(circleCenterX, circleCenterY, circleCenterX + (getWidth() / 4), circleCenterY + (getHeight() / 4));
  }
   
   public void drawDataInCircle(Graphics g, String string, int x, int y, int d)
   {
       x = x - (d / 2);
       //y = y - d;
       y = y + (d / 4);
       g.setColor(Color.BLACK);
       g.drawString(string, x, y);
   }
   
   private void print(String message)
   {
       System.out.println(message);
   }
}
