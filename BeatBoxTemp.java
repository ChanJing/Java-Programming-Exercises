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
		//�趨����ϰ������ʱ�Ŀհױ�Ե
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		checkboxList = new ArrayList<JCheckBox>();

		//BoxLayout ����ָ�����������Ƿ�Կؼ�����ˮƽ���ߴ�ֱ����
		//Y_AXIS-������ϵ�����������
		//��ť��Layout
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

		//���������ֵ�Layout
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for(int i = 0; i<16; i++){
			nameBox.add(new Label(instrumentNames[i]));
		}

		//��������������Panel
		background.add(BorderLayout.EAST,buttonBox);
		background.add(BorderLayout.WEST,nameBox);

		//���Panel��Frame
		theFrame.getContentPane().add(background);

		//GridLayout �������������ֳ�һ�����к�һ�����У�����ָ���ؼ�����ĳ��ĳ���� 
		//���ø�ѡ��
		GridLayout grid = new GridLayout(16,16);
		//���ò��ֵĴ�ֱ��϶
		grid.setVgap(1);
		//���ò��ֵ�ˮƽ��϶
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER,mainPanel);

		//����checkbox��,�趨��δ��ѡ��Ϊfalse���ӵ�ArrayList�������
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

	//һ���MIDI�������
	public void setUpMidi(){
		try{
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			//PPQ-�����ٶȵĶ�ʱ���ͣ��侫����ÿ�ķ������������������ģ���ʾ��
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			//setTempoInBPM
			//�����ٶȣ���ÿ�ķ�������΢����Ϊ��λ�� 
			sequencer.setTempoInBPM(120);
		}catch(Exception e){e.printStackTrace();}
	}

	//����ѡ��״̬ת��ΪMIDI�¼����ӵ�track��
	public void buildTrackAndStart(){
		//������16��Ԫ�ص����洢һ��������ֵ,
		//����ý�Ӧ��Ҫ����,��ֵ���ǹؼ���ֵ,����ֵΪ��
		int[] trackList = null;

		//������ɵ�track��һ���µ�
		sequence.deleteTrack(track);
		track = sequence.createTrack();

		//��ÿ��������ִ��һ��
		for(int i = 0; i<16;i++){
			trackList = new int[16];
			//instruments-�����Ĵ���
			int key = instruments[i];

			for(int j = 0; j<16;j++){
				JCheckBox jc = (JCheckBox) checkboxList.get(j+(16*i));
				//����й�ѡ,���ؼ���ֵ�ŵ�����ĸ�λ����,��Ȼ�Ͳ���
				if(jc.isSelected()){
					trackList[j] = key;
				}else{
					trackList[j] = 0;
				}
			}//�ر��ڲ�ѭ��
			//�������������¼����ӵ�track��
			makeTracks(trackList);
			track.add(makeEvent(176,1,127,0,16));
		}//�ر��ⲿѭ��

		//ȷ����16�����¼�,����BeatBox�����ظ�����
		track.add(makeEvent(192,9,1,0,15));
		try{
			sequencer.setSequence(sequence);
			//ָ��������ظ�����
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			//��ʼ����
			sequencer.start();
			sequencer.setTempoInBPM(120);
		}catch(Exception e){e.printStackTrace();}
	}//�ر�buildTrackAndStart����

	//��ť�ļ�����
	public class MyStartListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			buildTrackAndStart();
		}
	}//�ر��ڲ���

	public class MyStopListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			sequencer.stop();
		}
	}//�ر��ڲ���

	//��������,ÿ�ε���3%
	public class MyUpTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor * 1.03));
		}
	}//�ر��ڲ���

	public class MyDownTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempoFactor * 0.97));
		}
	}//�ر��ڲ���

	//����ĳ�������������¼�
	public void makeTracks(int[] list){
		for(int i = 0; i <16; i++){
			int key = list[i];

			// ����NOTE On��NOTE OFF�¼������뵽track��
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

}//�ر���