// Assignment #: 12
//         Name: Sishir Mohan
//    StudentID: 1204721903
//      Lecture: T Th 4:30-5:45
//  Description: FanPanel is a subclass of JPanel. It is used to define
//               a panel where a fan is moving.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class FanPanel extends JPanel
{
	private Color color;
	private int width; 
	private int delay;
	private int step;
	private int centerX;
	private int centerY;
	private int diameter;
	private int currentAngle;
	private Timer timer;
	
	public FanPanel(Color color, int width)
	{
		this.color = color;
		step = 3;
		centerX = width/2;
		centerY = width/2;
		diameter = (width-10)/2;
		currentAngle = 0;
		delay = 20;
		timer = new Timer(delay, new MoveListener());
		timer.start();
	}
	
	//starts timer
	public void resume()
	{
		timer.start();
	}
	//stops timer
	public void suspend()
	{
		timer.stop();			
	}
	
	//class to reverse direction of fan
	public void reverse()
	{
		step = -step;
		timer.restart();
	}
	
	//sets delay of timer using the parameter
	public void setDelay(int delayValue)
	{
		timer.setDelay(delayValue);
	}
	
	//
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		//sets color of fan arc
		page.setColor(color);
		page.fillArc(centerX, centerY, diameter, diameter, currentAngle, 90);
		
		page.fillArc(centerX, centerY, diameter, diameter, currentAngle+180, 90);
		
		//perimeter of fan
		page.setColor(Color.black);
		//draws fan
		page.drawOval(centerX, centerY, diameter, diameter);
	}
	
	//class to define how the fan should move 
	private class MoveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
    	{
			currentAngle += step;
			
			repaint();
    	}
	}

	
	
	
}
