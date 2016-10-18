//: D:/Code/Source/Java/Think in Java 4th/Chapter_3/E02_Aliasing.java

/************ Exercise 2 **********************
 * Create a class containing a float and use it to
 * demonstrate aliasing.
**********************************************/

package Chapter_3;

class Integral{
	float f;
}

public class E02_Aliasing{
	public static void main{String[] args}{
		Integral n1 = new Integral();
		Integral n2 = new Integral();
		n1.f = 9f;
		n2.f = 47f;
		System.output.println();
	}
}/* Output:
*///:~