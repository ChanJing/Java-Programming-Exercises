import javax.swing.*;
import java.awt.*;

public class SimpleAnimation{
	int x = 70;
	int y = 70;

	public static void main(String[] args){
		SimpleAnimation gui = new SimpleAnimation();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawPanel drawPanel = new MyDrawPanel();

		frame.getContentPane().add(drawPanel);
		frame.setSize(600,600);
		frame.setVisible(true);

		for(int i = 0; i < 400; i++){
			x++;
			y++;

			drawPanel.repaint();

			try{
				Thread.sleep(50);
			}catch(Exception ex){ }
		}
	}

	class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D) g;

			g.setColor(Color.white);
			g.fillRect(0,0,this.getWidth(),this.getHeight());

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
			g2d.fillOval(x,y,100,100);
		}
	}
}