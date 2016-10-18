import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimpleGui1B implements ActionListener{
	//JButton button;
	public static void main(String[] args){
		SimpleGui1B gui = new SimpleGui1B();
		//gui.go();
	}
	/*
	public void go(){

		JFrame frame = new JFrame();
		button = new JButton("click me");

		button.addActionListener(this);

		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event){
		button.setText("I've been clicked");
	}
*/
	public void paintComponent(Graphics g){
		//g.setColor(Color.blue);
		g.fillRect(0,0,this.getWidth(),this.getHeight());

		int red = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);

		Color randomColor = new Color(red,green,blue);
		g.setColor(randomColor);
		g.fillOval(70,70,100,100);
	}
}