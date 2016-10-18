import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextAreal implements ActionListener, ItemListener {
	JTextArea text;
	JCheckBox check;

	public static void main(String[] args){
		TextAreal gui = new TextAreal();
		gui.go();
	}

	public void go(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton("Just click it");
		check = new JCheckBox("Gogogo");

		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		button.addActionListener(this);
		text = new JTextArea(10,20);
		text.setLineWrap(true);

		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		panel.add(scroller);
		panel.add(check);

		frame.getContentPane().add(BorderLayout.CENTER,panel);
		frame.getContentPane().add(BorderLayout.SOUTH,button);

		frame.setSize(350,300);
		frame.setVisible(true);

		check.addItemListener(this);
	}

	public void actionPerformed(ActionEvent ev){
		text.append("Button clicked\n");
	}

	public void itemStateChanged(ItemEvent ev){
		String onOrOff = "off";
		if(check.isSelected()) onOrOff = "on";
		text.append("check box is "+onOrOff + "\n");
	}
}