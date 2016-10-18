//: D:/Code/Source/Java/Think in Java 4th/Chapter_2/E10_ShowArgs.java
// {Args: A B C}
/****************** Exercise 10 **********************
 * Write a program that prints three arguments
 * taken from the command line.
 * You'll need to index into the command-line
 * array of Strings.
 * Arguments are provided in a String array.
****************************************************/

package Chapter_2;

public class E10_ShowArgs{
	public static void main(String[] args){
		if(args.length < 3){
			//Typically, you send error messages to System.err.
			System.err.println("Need 3 arguments");
			//System.exit( ) terminates the program and passes its argument back to the
			//operating system as a status code.
			System.exit(1);
		}
		print(args[0]);
		print(args[1]);
		print(args[2]);
	}
}/* Output:

*///:~
