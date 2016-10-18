//: D:/Code/Source/Java/Think in Java 4th/Chapter_4/E09_FibonacciBinetFormula.java
//: Using The Golden Ratio to Calculate Fibonacci Numbers

/****************** Exercise 9 **********************
 * https://www.youtube.com/watch?v=nDqis5X0oPc
 * 38斐波那契数列Fibonacci Sequence的除法性质
 * https://www.youtube.com/watch?v=BvG6gMP0G9I
 * 40斐波那契数列Fibonacci Sequence的Binet Formula证法一
 * Take any two successive (one after the other) Fibonacci Numbers,
 * their ratio is very close to the Golden Ratio "φ" which
 * is approximately 1.618034... The bigger the pair
 * of Fibonacci Numbers, the closer the approximation.
 * Using The Golden Ratio to Calculate Fibonacci Numbers:
 * double goldRatio = (1 + sqrt(5))/2; fib(n) = (pow(goldRatio, n) - pow(1-goldRatio, n)) / sqrt(5);
****************************************************/

//package Chapter_4;
import java.lang.Math.*;

public class E09_FibonacciBinetFormula{

      static double fib(int n){
            double goldRatio = (1 + Math.sqrt(5))/2;
            return ( Math.pow(goldRatio, n) -  Math.pow(1-goldRatio, n)) / Math.sqrt(5);
      }

      public static void main(String[] args){
            int n = Integer.parseInt(args[0]);
            if(n < 0) {
                  System.out.println("Cannot use negative numbers");
                  return ;
            }


            for(int i = 1; i <= n; i++)
                  System.out.println((int)fib(i) + ", ");
      }
}
