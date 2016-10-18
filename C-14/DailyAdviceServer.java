import java.io.*;
import java.net.*;

public class DailyAdviceServer{

	String[] adviceList={"1","2","3","4","5"};
	public void go(){
		try{
			ServerSocket serverSocket = new ServerSocket(4242);
			while(true){
				Socket sock =serverSocket.accept();

				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String advice = getAdvice();
				writer.println(advice);
				writer.close();
				System.out.println(advice);
			}

		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	private String getAdvice(){
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}
	public static void main(String[] args){
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}
}