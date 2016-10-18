//: D:/Code/Source/Java/Think in Java 4th/Chapter_3/E01_PrintStatements.java

/************ Exercise 1 **********************
 * Write a program that uses the "short" and
 * normal form of print statement.
**********************************************/

package Chapter_3;
import java.util.Date;
import static net.mindview.util.Print.*;

public class E01_PrintStatements{
	public static void main(String[] args){
		Date currDate = new Date();
		Syste,.out.println("Hello, it's: " + currDate);
		print("Hello, its: " + currDate);
	}
}/* Output: 
*///:~