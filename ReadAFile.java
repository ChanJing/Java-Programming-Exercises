import java.io.*;

class ReadAFile{
	public static void main(String[] args){
		try{
			File myFile = new File("MyText.txt");
			//FileReader是字符连接到文本文件的串流
			FileReader fileReader = new FileReader(myFile);

			//将FileReader链接到BufferedReader以获取更高的效率,.
			//它只会在缓冲区读空的时候才会回头去磁盘读取
			BufferedReader reader = new BufferedReader(fileReader);

			String line = null;
			while((line = reader.readLine()) != null){
				System.out.println(line);
			} 
			reader.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}