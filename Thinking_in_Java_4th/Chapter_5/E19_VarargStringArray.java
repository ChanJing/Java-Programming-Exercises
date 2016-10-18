//: D:/Code/Source/Java/Think in Java 4th/Chapter_5/E19_VarargStringArray.java

/****************** Exercise 19 **********************
 * Write a method that takes a vararg String array.
 * Verify that you can pass either a comma-separated
 * list of Strings or a String[] into this method.
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/
//package Chapter_5;

public class E19_VarargStringArray{
      static void printStrings(String... strs){
            for(String s : strs)
                  System.out.println(s);
      }

      public static void main(String args[]){
            printStrings("These", "are", "some", "strings");
            printStrings(
                         new String[]{"These", "are", "some", "strings"}
            );
      }
}/* Output:
These
are
some
strings
These
are
some
strings
*///:~
