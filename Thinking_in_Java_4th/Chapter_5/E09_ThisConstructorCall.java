//: D:/Code/Source/Java/Think in Java 4th/Chapter_5/E09_ThisConstructorCall.java

/****************** Exercise 09 *********************
 * Create a class with two (overloaded)
 * constructors. Using this, call the second
 * constructor inside the first one.
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/

//package Chapter_5;

public class E09_ThisConstructorCall{
      public E09_ThisConstructorCall(String s){
            print("s = " + s);
      }
      public E09_ThisConstructorCall(int i){
            this("i = " + i); // Call the first constructor and pass "'i = ' i" as a parameter
      }
      public static void main(String[] args[]){
            new E09_ThisConstructorCall("String call");
            new E09_ThisConstructorCall(28);
      }
}/* Output:
s = String call
s = i = 47
*///:~
