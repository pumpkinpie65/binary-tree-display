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
    
    int CIRCLE_DIAMETER = 26;
    
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

         if (bTree != null && bTree.getRoot() != null)
         {
             print("width: " + getWidth());
            int x = getWidth() / 2;
            int y =  getHeight() - (getHeight() - CIRCLE_DIAMETER);
             
             displayBTree(g, bTree.getRoot(), x, y, 1);
         }
         
  }
  
  public void displayBTree(Graphics g, DataNode node, int x, int y, int level)
  {

      //print("node dData: " + node.dData);
      print("node key: " + node.key);
      print("level: " + level);
      print("x: " + x + " y: " + y);
      //print("leftChild is null: " + (node.leftChild == null));
      //print("rightChild is null: " + (node.rightChild == null));
      
      drawCenteredCircle(g, x, y, CIRCLE_DIAMETER);
      drawDataInCircle(g, "" + node.key, x, y, CIRCLE_DIAMETER);
      
      if (node.leftChild != null)
      {   
          int newCenterX;
          
          if (x > getWidth() / 2)
          {
              double divisor = Math.pow(2.0, ((double)level));
              int dividend = x - (getWidth() / 2);
              int xOffset = (int) (dividend / divisor);
              
              newCenterX = x - xOffset; 
          }
          else
          {
              newCenterX = x - ((int) (x /Math.pow(2.0, ((double)level))));
          }
          
          int newCenterY = y + 60;
          drawLeftChildLine(g, x, y, newCenterX, newCenterY);
          displayBTree(g, (DataNode) node.leftChild, newCenterX, newCenterY, (level + 1));
      }
      
      if (node.rightChild != null)
      {          
          int newCenterX;
          if (x > getWidth() / 2)
          {
              double divisor = Math.pow(2.0, ((double)level));
              int dividend = x - (getWidth() / 2);
              int xOffset = (int) (dividend / divisor);
              
              newCenterX = x + xOffset; 
          }
          else
          {
              newCenterX = x + ((int) (x /Math.pow(2.0, ((double)level))));
          }
          
          int newCenterY = y + 60;
          drawRightChildLine(g, x, y, newCenterX, newCenterY);
          displayBTree(g, (DataNode) node.rightChild, newCenterX, newCenterY, (level + 1));
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
        g.fillOval(x, y, d, d);
    }
  
  public void drawLeftChildLine(Graphics g, int circleCenterX, int circleCenterY, int circle2CenterX, int circle2CenterY)
  {
      g.setColor(Color.BLUE);
      g.drawLine(circleCenterX, circleCenterY, circle2CenterX, circle2CenterY);
  }
  
   public void drawRightChildLine(Graphics g, int circleCenterX, int circleCenterY, int circle2CenterX, int circle2CenterY)
  {
      g.setColor(Color.BLUE);
      g.drawLine(circleCenterX, circleCenterY, circle2CenterX, circle2CenterY);
  }
   
   public void drawDataInCircle(Graphics g, String string, int x, int y, int d)
   {
       x = x - (d / 4);
       y = y + (d / 4);
       g.setColor(Color.BLACK);
       g.drawString(string, x, y);
   }
   
   private void print(String message)
   {
       System.out.println(message);
   }
}
