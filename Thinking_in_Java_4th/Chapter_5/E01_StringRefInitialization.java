//: D:/Code/Source/Java/Think in Java 4th/Chapter_5/E01_StringRefInitialization.java

/****************** Exercise 01 **********************
 * Create a class with an uninitialized
 * String reference. Demonstrate that this
 * reference is initialized by Java to null.
****************************************************/

//package Chapter_5;

public class E01_StringRefInitialization{
      String s;
      public static void main(String[] args){
            E01_StrignRefInitialization sri = new E01_StrignRefInitialization();
            System.out.println(sri.s);
      }
}/* Output:
sri.s = null
*///:~
