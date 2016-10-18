import java.io.*;

class ReadFile{
	public static void main(String[] args){
		try{
			File myFile = new File("MyText.txt");
			FileReader fileReader = new FileReader(myFile);

			BufferedReader reader = new BufferedReader(fileReader);

			String line = null;

			while((line = reader.readLine()) != null){
				//println
			}
			reader.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}