// Assignment #: 12
//         Name: Sishir Mohan
//    StudentID: 1204721903
//      Lecture: T Th 4:30-5:457
//  Description: The Assignment 12 class creates a controlpanel and
//               adds it as its Applet content and also sets its size.

import javax.swing.*;

public class Assignment12 extends JApplet
 {
  private final int WIDTH = 450;
  private final int HEIGHT = 340;

  public void init()
   {
       ControlPanel panel = new ControlPanel(WIDTH,HEIGHT);
       getContentPane().add(panel);
       setSize(WIDTH,HEIGHT);
   }
 }
