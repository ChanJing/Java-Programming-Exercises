import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public class BeatBox{
	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxList;
	Sequencer sequencer;
	Sequence sequence;

	Track track;
	JFrame theFrame;

	String[] instrumentNames = {"B","C",""""""""""""""""""""""};
	int[] instruments = {};

	public static void main(String[] args){
		new BeatBox2().buildGUI();
	}

	public void buildGUI(){
		theFrame = new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();

		//Setting Background Panel
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		checkboxList = new ArrayList<JCheckBox>();

		//Setting Four Function Buttons and The Layout
		
		//The button layout, vertical
		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		//Start Buttons
		JButton start = new JButton("Start");
		// Add lisntener, using inner class
		start.addActionListener(new MyStartListener());
		// Add button on layout
		buttonBox.add(start);

		//Stop Buttons
		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);

		//Tempo Up Buttons
		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);

		//Tempo Down Buttons
		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);

		// Setting Name Layout vertical
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i = 0; i < 16; i++){
			nameBox.add(new Label(instrumentNames[i]));
		}

		//Locate name Layout and button Layout
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);

		// Add background to contentpane
		theFrame.getContentPane().add(background);

		//
		GridLayout grid = new GridLayout(16,16);
		grid.setVgap(1);
		grid.setHgap(2);

		// Add grid into mainPanel and Locate mainPanel
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER, mainPanel);

		for(int i = 0; i < 256; i++){
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

	Public void setUpMidi(){
		try{
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
		}catch(Exception e){e.printStackTrace();}
	}

	public void buildTrackAndStart(){
		// 清空上次记录  Clean the last record
		int[] trackList = null;
		sequence.deleteTrack(track);
		track = sequence.createTrack();

		//loop the track
		// One instrument(16 instruments for all), 16 beats
		for(int i = 0; i < 16; i++){
			trackList = new int[16];
			//Add instrument key
			int key = instruments[i];

			//Beats
			for(int j = 0; j < 16; j++){
				JCheckBox jc = (JCheckBox) checkboxList.get(j + (16*i));
				//Add key
				if(jc.isSelected()){
					trackList[j] = key;
				}else{
					trackList[j] = 0;
				}
			}
			makeTracks(trackList);
			track.add(makeEvent(176,1,127,0,16));
		}
		//确保第16拍有事件,否则BeatBox不会重复播放
		track.add(makeEvent(192,9,1,0,15));

		try{
			sequencer.setSequence(sequence);
			//制定无穷重复次数
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			//开始播放
			sequencer.start();
			sequencer.setTempoInBPM(120);
		}catch(Exception e){e.printStackTrace();}
	}

	public class MyStartListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			buildTrackAndStart();
		}
	}

	public class MyStopListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			sequencer.stop();
		}
	}

	public class MyUpTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor * 1.03));
		}
	}

	public class MyDownTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor *  0.97));
		}
	}

	public void maeTracks(int[] list){
		for(int i = 0; i < 16; i++){
			int key = list[i];

			if(key !=0){
				//创建NOTE ON和NOTE OFF事件加入到track上
				track.add(makeEvent(144,9,key,100,i));
				track.add(makeEvent(144,9,key,100,i+1));
			}
		}
	}

	public MidiEvent makeEvent(){
		return event;
	}
}

