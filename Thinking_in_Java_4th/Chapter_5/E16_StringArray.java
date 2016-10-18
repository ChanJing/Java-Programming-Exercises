//: D:/Code/Source/Java/Think in Java 4th/Chapter_5/E16_StringArray.java

/****************** Exercise 16 **********************
 * Assign a string to each element of an array of
 * String objects. Print the array using a for loop.
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/
//package Chapter_5;

public class E16_StringArray{
      public static void main(String[] args){
            // Using aggregate initialization to make it easier:
            String[] sa = {"These","are","some","strings","!",};
            for( String s : sa){
                  System.out.print(s + " ");
            }
      }
}/* Output:
These are some strings !
*///:~
