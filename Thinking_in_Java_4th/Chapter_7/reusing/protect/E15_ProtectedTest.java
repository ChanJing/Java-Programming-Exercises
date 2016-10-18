//: reusing/E15_ProtectedTest.java

/****************** Exercise 15 **********************
 * Create a class with a protected method inside
 * a package. Try to call the protect method
 * outside the package, and explain the results.
 * Now inherit from your class and call the
 * protected method from inside a method of your derived class.
 * @author Caleb Yuan Tian
 * @version 1.0
****************************************************/
package reusing;
import reusing.protect.*;

class Derived extends E15_Protected{
      public void g(){
            f(); // Accessible in derived class
      }
}

public class E15_ProtectedTest{
      public static void main(String[] args){
            //! new E15_Protected().f(); // Cannot access
            new Derived().g();
      }
}///:~
