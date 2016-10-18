//: D:/Code/Source/Java/Think in Java 4th/Chapter_5/E04_OverloadedConstructor.java

/****************** Exercise 04 *********************
 * Add an overloaded constructor to Exercise 3 that
 * takes a String argument and prints it along with
 * your message.
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/

//package Chapter_5;

public class E04_OverloadedConstructor{
      E04_OverloadedConstructor(){
            System.out.print("Default constructor");
      }
      E04_OverloadedConstructor(String s){
            System.out.println("String arg constructor");
            System.out.println(s);
      }

      public static void main(String[] args){
            //Call default version;
            new E04_OverloadedConstructor();
            // Call overloaded version:
            new E04_OverloadedConstructor("Overloaded");
      }
} /* Output:
Default constructor
String arg constructor
Overloaded
*///:~
