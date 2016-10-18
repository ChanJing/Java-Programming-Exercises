//: access/debug/E03_Debug.java

/****************** Exercise 03 **********************
 * Create two packages: debug and debugoff,
 * containing an identical class with a debug()
 * method. The first version displays its String
 * argument to the console, the second does nothing.
 * Import the class into a test program
 * using a static import line, and demonstrate
 * the conditional compilation effect.
 * @author Caleb Yuan Tian
 * @author com.wordpress.chanjingblog
 * @version 1.0
****************************************************/

package access.debug;

public class E03_Debug{
      public static void debug(String msg){
            System.out.println("Message: " + msg);
      }
}///:~
