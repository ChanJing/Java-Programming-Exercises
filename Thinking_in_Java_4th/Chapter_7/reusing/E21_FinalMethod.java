//: reusing/E21_FinalMethod.java
// {CompileTimeError}
/****************** Exercise 21 **********************
 * Create a class with a final method. Inherit
 * from that class and attempt to override that
 * method.
 * @author Caleb Yuan Tian
 * @version 1.0
****************************************************/
package reusing;

class WithFinalMethod{
      final void f(){}
}

public class E21_FinalMethod extends WithFinalMethod{
      void f(){}
      public static void main(String[] args){}
}///:~
