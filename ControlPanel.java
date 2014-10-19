// Assignment #: 12
//         Name: Sishir Mohan
//    StudentID: 1204721903
//      Lecture: T Th 4:30-5:45
//  Description: 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ControlPanel extends JPanel
 {
	//instance variables and components of Applet
   private FanPanel fan;
   private FanPanel fan1;
   private int width;
   private int height;
   private JButton startRed;
   private JButton startBlue;
   private JButton stopRed;
   private JButton stopBlue;
   private JButton reverseRed;
   private JButton reverseBlue;   
   private JLabel labelRed, labelBlue;   
   private JSlider sliderRed, sliderBlue;
      
   //constructor for ControlPanel
   public ControlPanel(int width, int height)
    {
	   //set width and height with parameter values
       this.width = width;
       this.height = height;

       //create two fan panels, one with read, another with blue
       fan = new FanPanel(Color.red, width/2);
       fan1 = new FanPanel(Color.blue, width/2);
                     
       //layout buttons and connect to ButtonListener
       startRed = new JButton("Start Red");
       stopRed = new JButton("Stop Red");
       reverseRed = new JButton("Reverse Red");
       startRed.addActionListener(new ButtonListener());
       stopRed.addActionListener(new ButtonListener());
       reverseRed.addActionListener(new ButtonListener());
       
       JPanel redbuttons = new JPanel();
       redbuttons.setLayout(new GridLayout(3,1));
       //add buttons to Panel
       redbuttons.add(startRed);
       redbuttons.add(stopRed);
       redbuttons.add(reverseRed);
       
       sliderRed = new JSlider(JSlider.VERTICAL, 0, 50, 20);
       sliderRed.setMajorTickSpacing(10);
       sliderRed.setPaintTicks(true);
       sliderRed.setPaintLabels(true);
       sliderRed.addChangeListener(new SliderListener());
       
       labelRed = new JLabel("Red Fan Delay");
       
       JPanel red2 = new JPanel();
       red2.setLayout(new GridLayout(2,1));
       red2.add(labelRed);
       red2.add(sliderRed);
       
       JPanel panelRed = new JPanel();
       panelRed.setLayout(new GridLayout(1,2));
       panelRed.add(redbuttons);
       panelRed.add(red2);
       
       startBlue = new JButton("Start Blue");
       stopBlue = new JButton("Stop Blue");
       reverseBlue = new JButton("Reverse Blue");
       startBlue.addActionListener(new ButtonListener());
       stopBlue.addActionListener(new ButtonListener());
       reverseBlue.addActionListener(new ButtonListener());
       
       JPanel buttonBlue = new JPanel();
       buttonBlue.setLayout(new GridLayout(3,1));
       buttonBlue.add(startBlue);
       buttonBlue.add(stopBlue);
       buttonBlue.add(reverseBlue);
       
       sliderBlue = new JSlider(JSlider.VERTICAL, 0, 50, 20);
       sliderBlue.setMajorTickSpacing(10);
       sliderBlue.setPaintTicks(true);
       sliderBlue.setPaintLabels(true);
       sliderBlue.addChangeListener(new SliderListener());
       
       labelBlue = new JLabel("Blue Fan Delay");
       
       JPanel blue2 = new JPanel();
       blue2.setLayout(new GridLayout(2,1));
       blue2.add(labelBlue);
       blue2.add(labelBlue);
       
       JPanel bluePanel = new JPanel();
       bluePanel.setLayout(new GridLayout(1,2));
       bluePanel.add(buttonBlue);
       bluePanel.add(blue2);
       
       //add panels to upperPanel
       JPanel upperPanel = new JPanel();
       upperPanel.setLayout(new GridLayout(1,2));
       upperPanel.add(panelRed);
       upperPanel.add(bluePanel);
       
       //add fans to the pans
       JPanel fans = new JPanel();
       fans.setLayout(new GridLayout(1,2));
       fans.add(fan);
       fans.add(fan1);
       
       //add panels
       setLayout(new GridLayout(2,1));
       add(upperPanel);
       add(fans);
                  
       
       //set preferred size of this panel
       setPreferredSize(new Dimension(width,height));
    }


   private class ButtonListener implements ActionListener
    {
       public void actionPerformed(ActionEvent event)
         {
            Object action = event.getSource();
            //if statement to dictate action of fans
           if (event.getSource() == startRed)
        	   fan.resume();
           if (event.getSource() == startBlue)
        	   fan1.resume();
           if (event.getSource() == stopRed)
        	   fan.suspend();
           if (event.getSource() == stopBlue)
        	   fan1.suspend();
           if (event.getSource() == reverseRed)
        	   fan.reverse();
           if (event.getSource() == reverseBlue)
        	   fan1.reverse();
         }
    } //end of ButtonListener class

   private class SliderListener implements ChangeListener
    {
       public void stateChanged(ChangeEvent event)
         {
            int speed = sliderRed.getValue();
            int speed2 = sliderBlue.getValue();
            
            //for loop that keeps fan going
            for (int i = 0; i < 50; i++)
            {
            	if (speed == i)
            		fan.setDelay(i);
            	if (speed2 == i)
            		fan1.setDelay(i);
            }
            
         }
     } //end of SliderListener class

} //end of ControlPanel class
