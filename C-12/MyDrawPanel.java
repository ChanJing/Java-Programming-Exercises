import java.awt.*;
import javax.swing.*;

class MyDrawPanel extends JPanel{
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		int myRed = (int)(Math.random() * 255);
		int myGreen = (int)(Math.random() * 255);
		int myBlue = (int)(Math.random() * 255);
		Color startColor = new Color(myRed,myGreen,myBlue);

		myRed = (int)(Math.random() * 255);
		myGreen = (int)(Math.random() * 255);
		myBlue = (int)(Math.random() * 255);
		Color endColor = new Color(myRed,myGreen,myBlue);

		GradientPaint gradient = new GradientPaint(70,70,startColor,150,150,endColor);


		g2d.setPaint(gradient);
		g2d.fillOval(70,70,100,100);
	}
}