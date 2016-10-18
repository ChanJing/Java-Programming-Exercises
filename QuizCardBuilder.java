java demo

import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardBuilder{
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private JFrame frame;

	public static void main(String[] args){
		QuizCardBuilder builder = new QuizCardBuilder();
		builder.go();
	}

	public void go(){
		//Create GUI
		frame = new JFrame("Quiz Card Builder");
		JPanel mainPanel = new JPanel();
		question = new JTextArea(6,20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(bigFont);

		JScrollpane qScroller = new JScrollpane(question);
		qScroller.setVerticalScrollBarPolicy(ScrollpaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollpaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		answer = new JTextArea(6,20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(bigFont);

		JScrollpane aScroller = new JScrollpane(answer);
		aScroller.setVerticalScrollBarPolicy(ScrollpaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollpaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JButton nextButton - new JButton("Next Card");
		JLabel qLabel = new JLabel("Question:");
		JLabel aLabel = new JLabel("Answer:");

		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		JMenuItem saveMenuItem = new JMenuItem("Save");
		newMenuItem.addActionListener(new NewMenuListener());
		saveMenuItem.addActionListener(new SaveMenuListener());

		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);

		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(500,600);
		frame.setVisible(true);
	}

	public class NextCardListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			QuizCard card = new QuizCard(question.getText(),answer.getText());
			cardList.add(card);
			clearCard();
		}
	}

	public class SaveMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			QuizCard card = new QuizCard(question.getText(), answer.getText());
			cardList.add(card);

			//调出存盘dialog等待用户决定,都是靠JFileChooser完成的
			JFileChooser fileSave = new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectedFile());
		}
	}

	public class NewMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			cardList.clear();
			clearCard();
		}
	}

	private void clearCard(){
		question.setText("");
		answer.setText("");
		question.requestFocus();
	}

	//实际编写文件的方法由SaveMenuListener的事件处理程序所调用
	private void saveFile(File file){
		try{
			//将Buffered Writer链接到Filewriter
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			//将ArrayList中的card逐个写到文件中,一行一张card,问题和答案由"/"分开
			for(QuizCard card:cardLis){
				writer.write(card.getQuestion() + "/");
				writer.write(card.getAnswer() + "\n");
			}
			writer.close();
		}catch(IOException ex){
			System.out.println("couldn't write the cardList out");
			ex.printStackTrace();
		}
	}
}