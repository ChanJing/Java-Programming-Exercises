import java.io.*;

public class QuizCard implements Serializable{

	String question;
	String answer;

	public QuizCard(String q, String a){
		question = q;
		answer = a;
	}
	public void getAnswer(){
		return answer;
	}
	public void getQuestion(){
		return question;
	}
}