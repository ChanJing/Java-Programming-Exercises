import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardPlayer{
	private JTextArea display;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private QuizCard currentCard;
	private int currentCardIndex;
	private JFrame frame;
	private JButton nextButton;
	private boolean isShowAnswer;

	public static void main(String[] args){
		QuizCardPlayer reader = new QuizCardPlayer();
		reader.go();
	}

	public void go(){
		//Create GUI
		frame = new JFrame("Quiz Card Plalyer");
		JPanel mainPanel = new JPanel();
		Font bigFont = new Font("sanserif", Font.BOLD, 24);

		display = new JTextArea(10, 20);
		display.setFont(bigFont);

		//自动换行
		display.setLineWrap(true);
		//能否编辑
		display.setEditablt(false);

		JScrollPane qScroller = new JScrollPane(display);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		nextButton = new JButton("Show Question");
		mainPanel.add(qScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem loadMenuItem = new JMenuItem("Load card set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(640, 500);
		frame.setVisible(true);
	}

	public class NextCardListener implements ActionListener{
		//如果是个问题,显示答案,否则显示下一个问题
		//改一个标识表明我们已经浏览了问题或答案

		//这个是发生操作时程序监听到然后自动调用的
		public void actionPerformed(ActionEvent ev){
			//检查isShowAnswer来判断现在看的是问题还是答案,并根据回答来执行适当的工作
			if(isShowAnswer){
				//Show Answer
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer = false;
			}else{
				//Show Question
				if(currentCardIndex < cardList.size()){
					showNextCard();
				}else{
					//No more cards
					display.setText("That was last card");
					nextButton.setEnabled(false);
				}
			}
		}
	}

	public class OpenMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			//JFileChooser() - Java Swing提供的文件选择对话框
			JFileChooser fileOpen = new JFileChooser();
			fileOpen.showOpenDialog(frame);
			//打开文件的对话框让用户选择文件
			loadFile(fileOpen.getSelectedFile());
		}
	}

	private void loadFile(File file){
		//生成一个文件对话框
		//让用户把一个卡片设置打开

		cardList = new ArrayList<QuizCard>();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			//读取一行数据, 传给makeCard()来吧字符串解析成卡片加到ArrayList中
			while((line = reader.readLine()) != null){
				makeCard(line);
			}
			reader.close();
		}catch(Exception ex){
			System.out.println("couldn't read the card file");
			ex.printStackTrace();
		}
	}

	private void makeCard(String lineToParse){
		//创建卡片的ArrayList,并从文本文件中读取它们
		//调用OpenMenuListener事件处理器,每次从文件中读取一行
		//告诉makeCard()方法创建一个新卡片

		//每一行都是一张卡片,分解成问题和答案
		String[] result = lineToParse.split("/");
		QuizCard card = new QuizCard(result[0], result[1]);
		cardList.add(card);
		System.out.println("made a card")''
	}

	private void showNextCard(){
		//调用LoadFile方法,从文本文件中读取一行
		//创建一个新的QuizCard,通过调用CardList把它jiaruArrayList中
		
		currentCard = cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show Answer");
		isShowAnswer = true;
	}
}