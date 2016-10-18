//: D:/Code/Source/Java/Think in Java 4th/Chapter_3/E05_Dogs.java

/****************** Exercise 5 **********************
 * Create a class called Dog with two Strings:
 * name and says. In main(), create two dogs,
 * then display their names and what they says.
****************************************************/

package Chapter_3;

class Dog{
	String name;
	String says;
}
public class E05_Dogs{
	public static void main(String[] args){
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		dog1.name = "spot"; dog1.says = "ruff";
		dog2.name = "scruffy"; dog2.says = "wurf";
		System.out.println();
	}
}/* Output:
*///:~