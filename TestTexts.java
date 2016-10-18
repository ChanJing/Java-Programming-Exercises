import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TestTexts extends JFrame{

	public static void main(String[] args){
		TestTexts tt = new TestTexts();
		tt.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JTextField textField = new JTextField(40);

		panel.setBackground(Color.darkGray);
		textField.setText("HAHAHA");
		panel.add(textField);

		frame.getContentPane().add(BorderLayout.NORTH,panel);
		frame.setSize(600,600);
		frame.setVisible(true);
	}
}