//: D:/Code/Source/Java/Think in Java 4th/Chapter_5/E15_StringInstanceInitialization.java

/****************** Exercise 15 **********************
 * Create a class with a String that is initialized using
 * "instance initialization."
 * You¡¯ll see that instance initialization occurs before
 * either of the two constructors.
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/

//package Chapter_5;

public class E15_StringInstanceInitialization{
      String s;
      {
            s = "'instance initialization'";
      }
      public E15_StringInstanceInitialization(){
            System.out.println("Default constructor; s = " + s);
      }
      public E15_StringInstanceInitialization(int i){
            System.out.println("int constructor; s = " + s);
      }

      public static void main(String args[]){
            new E15_StringInstanceInitialization();
            new E15_StringInstanceInitialization(1);
      }
}/* Output:
Default constructor; s = 'instance initialization'
int constructor; s = 'instance initialization'
*///:~
