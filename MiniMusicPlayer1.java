import javax.sound.midi.*;

public class MiniMusicPlayer1{
	public static void main(String[] args){
		try{
			//Create the Sequencer and Open it
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			//Create a Object of Sequencer and track
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();

			//Create a queue of note
			for(int i = 5; i < 61; i += 4){
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(128,1,i,100,i + 2));
			}

			//Play the queue of note
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
		}catch (Exception ex){ex.printStackTrace();}
	}

	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		 MidiEvent event = null;
		 try{
		 	ShortMessage a = new ShortMessage();
		 	a.setMessage(comd,chan,one,two);
		 	event = new MidiEvent(a, tick);
		 }catch (Exception e){}
		 return event;
	}
}