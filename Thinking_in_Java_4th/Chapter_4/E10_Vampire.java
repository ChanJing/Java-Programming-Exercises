//: D:/Code/Source/Java/Think in Java 4th/Chapter_4/E10_Vampire.java

/****************** Exercise 9 **********************
 * A vampire number has an even number of digits and
 * is formed by multiplying a pair of numbers containing
 * half the number of digits of the result. The digits
 * are taken from the original number in any order.
 * Pairs of trailing zeros are not allowed. Examples
 * include:
 * 1260 = 21 * 60
 * 1827 = 21 * 87
 * 2187 = 27 * 81
 * Write a program that finds all the 4-digit vampire
 * numbers. (Suggested by Dan Forhan.)
****************************************************/

/****************** Pete Hartley **********************
An important theoretical rp9esult found by Pete Hartley:
          If x，y is a vampire number then x，y == x+y (mod 9)
Proof:
Let mod be the binary modulo operator and d(x) the sum of the decimal digits of x.
It is well-known that d(x) mod 9 = x mod 9, for all x.
Assume x，y is a vampire. Then it contains the same digits as x and y, and in particular d(x，y) = d(x)+d(y). This leads to:
          (x，y) mod 9 = d(x，y) mod 9 = (d(x)+d(y)) mod 9 = (d(x) mod 9 + d(y) mod 9) mod 9
            = (x mod 9 + y mod 9) mod 9 = (x+y) mod 9
****************************************************/

//package Chapter_4;

public class E10_Vampire{
      public static void main(String[] args){
            int[] startDigit = new int[4];
            int[] productDigit = new int[4];
            for(int num1 = 10; num1 <= 99; num1++){
                  for(int num2 = num1; num2 <=99; num2++){
                        // Pete Hartley's theoretical result:
                        // If x*y is a vampire number then
                        // x*y == x+y (mod 9)
                        if((num1 * num2) % 9 != (num1 + num2) % 9)
                              continue;
                        int product = num1 * num2;
                        startDigit[0] = num1 / 10;
                        startDigit[1] = num1 % 10;
                        startDigit[2] = num2 / 10;
                        startDigit[3] = num2 % 10;
                        productDigit[0] = product / 1000;
                        productDigit[1] = (product % 1000) / 100;
                        productDigit[2] = product % 1000 % 100 / 10;
                        productDigit[3] = product % 1000 % 100 % 10;
                        int count = 0;
                        for(int x = 0; x < 4; x++){
                              for(int y = 0; y < 4; y++){
                                    if(productDigit[x] == startDigit[y]){
                                          count++;
                                          productDigit[x] = -1;
                                          startDigit[y] = -2;
                                          if(count == 4)
                                                System.out.println(num1 + " * " + num2 + " : " + product);
                                    }
                              }
                        }
                  }
            }
      }
}/* Output:
15 * 93 : 1395
21 * 60 : 1260
21 * 87 : 1827
27 * 81 : 2187
30 * 51 : 1530
35 * 41 : 1435
80 * 86 : 6880
*///:~

