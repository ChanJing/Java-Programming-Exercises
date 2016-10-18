public class AnimalTestDrive{
	public static void main(String[] args){
		MyAnimalList list = new MyAnimalList();
		Dog a = new Dog();
		Cat b = new Cat();
		list.add(a);
		list.add(b);
	}
}

abstract class Report{
	void renReport(){
		
	}
}

class BuzzwordsReport extends Report{
	void renReport(){
		super.runReport();
	}
}