import java.io.*;

public class GameSaverTest{
	public static void main(String[] args){
		GameCharacter one = new GameCharacter(50, "");
		GameCharacter two = new GameCharacter(200,"");
		GameCharacter three = new GameCharacter(120,"");

		try{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
			os.writeObject(one);
			os.writeObject(two);
			os.writeObject(three);

			os.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		one = null;
		two = null;
		three = null;

		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
			GameCharacter oneRestore = (GameCharacter) is.readObject();
			GameCharacter twoRestore = (GameCharacter) is.readObject();
			GameCharacter threeRestore = (GameCharacter) is.readObject();

			System.out.println();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}