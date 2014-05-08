/*
 * David Zima
 * created 5.6.14  last updated 5.6.14
 * CS 182 Lab Project 5 Binary Tree Display
 * 
 * This class creates a window to display the binary tree
 */

package views;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import models.BinaryTree;

/**
 *
 * @author David
 */
public class Window extends JFrame implements ActionListener {

    private static int winxpos=0,winypos=0;// place window here

    // Private state variables.

    private JButton insertbutton,exitbutton;
    private JTextField infield;
    private JPanel northPanel;
    private BTreePanel centerPanel;
    private static final int WINWIDTH = 700;
    private static final int WINHEIGHT = 500;
    /*   UNCOMMENT WHEN YOU HAVE THE TREE CODE */
    private BinaryTree theTree = new BinaryTree();


    ////////////MAIN////////////////////////

    public static void main(String[] args) {
            Window tpo = new Window();

            tpo.addWindowListener(new WindowAdapter() {   // this exits the program when X box clicked
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
    }



    ////////////CONSTRUCTOR/////////////////////

    public Window ()
    {
           northPanel = new JPanel();
           northPanel.add(new Label("Enter a number to insert: "));
           infield = new JTextField("",20);
           northPanel.add(infield);
           insertbutton = new JButton("Insert");
           northPanel.add(insertbutton);
           insertbutton.addActionListener(this);
           exitbutton = new JButton("Exit");
           northPanel.add(exitbutton);
           exitbutton.addActionListener(this);
           getContentPane().add("North",northPanel);

           centerPanel = new BTreePanel();
           getContentPane().add("Center",centerPanel);



    /*   UNCOMMENT WHEN YOU HAVE THE TREE CODE*/
          theTree.insert(50, 1.5);
          theTree.insert(25, 1.2);
          theTree.insert(75, 1.7);
          theTree.insert(12, 1.5);
          theTree.insert(37, 1.2);
          theTree.insert(43, 1.7);
          theTree.insert(30, 1.5);
          theTree.insert(33, 1.2);
          theTree.insert(87, 1.7);
          theTree.insert(93, 1.5);
          theTree.insert(97, 1.5);
          theTree.displayTree();
    
          setSize(WINWIDTH,WINHEIGHT);
          setLocation(winxpos,winypos);
          setVisible(true);

    }


    ////////////BUTTON CLICKS ///////////////////////////

    public void actionPerformed(ActionEvent e) {

              if (e.getSource()== exitbutton) {
             dispose(); System.exit(0);

             }



             if (e.getSource()== insertbutton) {
                    /*   UNCOMMENT WHEN YOU HAVE THE TREE CODE
                    theTree.insert(Integer.parseInt(infield.getText()),2.1);
                    */
                    repaint();
             }


    }
}
