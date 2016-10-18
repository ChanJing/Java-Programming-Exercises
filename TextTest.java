import javax.swing.*;
import javax.swing.event.*;
import javax.awt.*;

public class TestTexts extends JFrame{

	public static void main(String[] args){
		TestTexts tt = new TestTexts();
		tt.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		JTextField textField = new JTextField(20);
		textField.setText("HAHAHA");
		frame.getContentPane().add(BorderLayout.NORTH,textField);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}