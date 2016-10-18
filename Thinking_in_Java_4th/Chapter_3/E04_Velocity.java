//: D:/Code/Source/Java/Think in Java 4th/Chapter_3/E04_Velocity.java

/****************** Exercise 4 **********************
 * Write a program that calculates velocity
 * using a constant distance and a constant time.
 ****************************************************
 * Here we take the distance and time values from the command line. Arguments
 * come in as a String array; if you need a float instead, use the static
 * parseFloat( ) method of class Float. This can be difficult to locate using the
 * JDK HTML documentation; you must remember either “parse” or that it’s part
 * of class Float.
****************************************************/

package Chapter_3;

public class E04_Velocity{
	public static void main(String[] args){
		if(args.length < 2){
			System.err.println("Usage: ");
			System.exit(1);
		}
		float distance = Float.parseFloat(args[0]);
		float time = Float.parseFloat(args[1])
		System.out.print();
		// Change the next line if you want to use a different
		// unit for "distance".
	}
}/* Output:
*///:~
