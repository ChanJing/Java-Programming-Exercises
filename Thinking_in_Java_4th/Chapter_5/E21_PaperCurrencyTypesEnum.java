//: D:/Code/Source/Java/Think in Java 4th/Chapter_5/E21_PaperCurrencyTypesEnum.java

/****************** Exercise 21 **********************
 * Create an enum of the six lowest denominations
 * of paper currency. Loop through the values()
 * and print each value and its ordinal().
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/
//package Chapter_5;

enum PaperCurrencyTypes{
      ONE, TWO, FIVE, TEN, TWENTY, FIFTY
}

public class E21_PaperCurrencyTypesEnum{
      public static void main(String args[]){
            for(PaperCurrencyTypes s : PaperCurrencyTypes.values())
                  System.out.println(s + ", ordinal " + s.ordinal());
      }
}/* Output:
ONE, ordinal 0
TWO, ordinal 1
FIVE, ordinal 2
TWENTY, ordinal 4
FIFTY, ordinal 5
*///:~
