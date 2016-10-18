public class QuizCard{
	String question;
	String answer;

	public QuizCard(){}

	public QuizCard(String Q, String A){
		question = Q;
		answer = A;
	}
	String getQuestion(){
		return question;
	}
	
	String getAnswer(){
		return answer;
	}

	void setQuestion(String Q){
		question = Q;
	}

	void setAnswer(String A){
		answer = A;
	}
}