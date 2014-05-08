/*
 * David Zima
 * created 5.6.14  last updated 5.6.14
 * CS 182 Lab Project 5 Binary Tree Display
 * 
 * This class will draw the binary tree to the screen.
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
         
         //g.drawOval(getWidth() / 2, getHeight() - (getHeight() - 10), 20, 20);
         int x = getWidth() / 2;
         int y =  getHeight() - (getHeight() - 20);
         int diameter = 20;
         drawCenteredCircle(g, x, y, diameter);
         drawLeftChildLine(g, x, y);
         drawRightChildLine(g, x, y);
  }
  
  public void drawCenteredCircle(Graphics g, int x, int y, int d) {
        x = x-(d/2);
        y = y-(d/2);
        g.drawOval(x,y,d,d);
    }
  
  public void drawLeftChildLine(Graphics g, int circleCenterX, int circleCenterY)
  {
      g.drawLine(circleCenterX, circleCenterY, circleCenterX - (getWidth() / 4), circleCenterY + (getHeight() / 4));
  }
  
   public void drawRightChildLine(Graphics g, int circleCenterX, int circleCenterY)
  {
      g.drawLine(circleCenterX, circleCenterY, circleCenterX + (getWidth() / 4), circleCenterY + (getHeight() / 4));
  }
}
