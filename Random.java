public class random{
	public static void main(String[] args){
		String[] wordlist = {"12","23","34","45","56"};
		int Length = wordlist.length;
		while(Length > 2){
			//if(((int) (Math.random()* Length)) == 5)
				//System.out.println("Wrong");
			System.out.println(Math.random());
			//Math.random()的值在0到1之间,不包括0和1.
		}
	}
}