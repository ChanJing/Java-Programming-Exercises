import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public class BeatBoxTemp{
	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame theFrame;

	String[] instrumentNames = {"Bass Brum","Closed Hi-Hat",
		"Open Hi-Hat","Acoustic Snare","Crash Cymbl","Hand Clap","High Tom",
		"Hi Bongo","Maracas","Whistle","Low Conga","Cowbell","Vibraslap",
		"Low-mid Tom","High Agogo","Open Hi Conga"};
	int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};

	public static void main(String[] args){
		new BeatBoxTemp().buildGUI();
	}

	public void buildGUI(){
		theFrame = new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		//设定面板上摆设组件时的空白边缘
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		checkboxList = new ArrayList<JCheckBox>();

		//BoxLayout 可以指定在容器中是否对控件进行水平或者垂直放置
		//Y_AXIS-组件从上到下纵向排列
		//按钮的Layout
		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);

		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);

		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);

		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);

		//乐器的名字的Layout
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i = 0; i<16; i++){
			nameBox.add(new Label(instrumentNames[i]));
		}

		//添加组件到背景的Panel
		background.add(BorderLayout.EAST,buttonBox);
		background.add(BorderLayout.WEST,nameBox);

		//添加Panel到Frame
		theFrame.getContentPane().add(background);

		//GridLayout 将整个容器划分成一定的行和一定的列，可以指定控件放在某行某列上 
		//设置复选框
		GridLayout grid = new GridLayout(16,16);
		//设置布局的垂直间隙
		grid.setVgap(1);
		//设置布局的水平间隙
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER,mainPanel);

		//创建checkbox组,设定成未勾选的为false并加到ArrayList和面板上
		for(int i = 0;i<256; i++){
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}

		setUpMidi();

		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
	}

	//一般的MIDI程序代码
	public void setUpMidi(){
		try{
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			//PPQ-基于速度的定时类型，其精度用每四分音符的拍子数（节拍）表示。
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			//setTempoInBPM
			//设置速度，以每四分音符的微秒数为单位。 
			sequencer.setTempoInBPM(120);
		}catch(Exception e){e.printStackTrace();}
	}

	//将复选框状态转换为MIDI事件并加到track上
	public void buildTrackAndStart(){
		//创建出16个元素的来存储一项乐器的值,
		//如果该节应该要演奏,其值会是关键字值,否则值为零
		int[] trackList = null;

		//清除掉旧的track做一个新的
		sequence.deleteTrack(track);
		track = sequence.createTrack();

		//对每个乐器都执行一次
		for(int i = 0; i<16;i++){
			trackList = new int[16];
			//instruments-乐器的代码
			int key = instruments[i];

			for(int j = 0; j<16;j++){
				JCheckBox jc = (JCheckBox) checkboxList.get(j+(16*i));
				//如果有勾选,将关键字值放到数组的该位置上,不然就补零
				if(jc.isSelected()){
					trackList[j] = key;
				}else{
					trackList[j] = 0;
				}
			}//关闭内部循环
			//创建此乐器的事件并加到track上
			makeTracks(trackList);
			track.add(makeEvent(176,1,127,0,16));
		}//关闭外部循环

		//确保第16拍有事件,否则BeatBox不会重复播放
		track.add(makeEvent(192,9,1,0,15));
		try{
			sequencer.setSequence(sequence);
			//指定无穷的重复次数
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			//开始播放
			sequencer.start();
			sequencer.setTempoInBPM(120);
		}catch(Exception e){e.printStackTrace();}
	}//关闭buildTrackAndStart方法

	//按钮的监听者
	public class MyStartListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			buildTrackAndStart();
		}
	}//关闭内部类

	public class MyStopListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			sequencer.stop();
		}
	}//关闭内部类

	//节奏因子,每次调整3%
	public class MyUpTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor * 1.03));
		}
	}//关闭内部类

	public class MyDownTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor * 0.97));
		}
	}//关闭内部类

	//创建某项乐器的所有事件
	public void makeTracks(int[] list){
		for(int i = 0; i <16; i++){
			int key = list[i];

			// 创建NOTE On和NOTE OFF事件并加入到track上
			if(key != 0){
				track.add(makeEvent(144,9,key,100,i));
				track.add(makeEvent(128,9,key,100,i+1));
			}
		}
	}

	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event = null;
		try{
			ShortMessage a = new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event = new MidiEvent(a,tick);
		}catch(Exception e){e.printStackTrace();}
		return event;
	}

}//关闭类