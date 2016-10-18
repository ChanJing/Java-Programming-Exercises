class DogTestDrive{
	public static void main (String[] args){
		Dog one = new Dog();
		one.size = 80;
		Dog two = new Dog();
		two.size = 8;
		Dog three = new Dog();
		three.size = 34;
		
		one.bark();
		two.bark();
		three.bark();
	}
}