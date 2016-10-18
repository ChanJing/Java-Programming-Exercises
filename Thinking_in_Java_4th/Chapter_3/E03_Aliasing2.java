//: D:/Code/Source/Java/Think in Java 4th/Chapter_3/E03_Aliasing2.java

/************ Exercise 3 **********************
 * Create a class containing a float and use it to
 * demonstrate aliasing during method calls.
**********************************************/

package Chapter_3;

public class E03_Aliasing2{
	static void f(Integral y){y.f = 1.0f;}
	public static void main(String[] args){
		Integral x = new Integral();
		x.f = 2.0f;
		print();
		f(x);
		print();
	}
}/*Output:

*///:~