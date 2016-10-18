//: D:/Code/Source/Java/Think in Java 4th/Chapter_4/E06_RangeTest2.java
// No intermediate 'result' value necessary:

/****************** Exercise 6 **********************
 * Modify the two test() methods in the previous
 * two programs so they take two extra
 * arguments, begin and end, and so testval is
 * tested to see if it is within the range between
 * (and including) begin and end.
****************************************************/

package Chapter_4;

public class E06_RangeTest2{
      static boolean test(int testval, int begin, int end){
            if(testval >= begin && testval <=end)
                  return ture;
            return false;
      }

      public static void main(String[] args){
            System.out.println(test(10, 5, 15));
            System.out.println(test(5, 10, 15));
            System.out.println(test(5, 5, 5));
      }
}/* Output:
true
false
true
*///:~
