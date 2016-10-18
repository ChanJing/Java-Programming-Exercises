//: reusing/E20_OverrideAnnotation.java
// {CompileTimeError}
/****************** Exercise 20 **********************
 * Show that the @Override annotation solves the
 * problem from the "final and private" section/
 * @author Caleb Yuan Tian
 * @version 1.0
****************************************************/
package reusing;

class WithFinals{
      // Identical to "private" alone:
      private final void f() { System.out.println("WithFinals.f()");}
      // Also automatically "final":
      private void g() { System.out.println("WithFinals.g()");}
}

class OverridingPrivateE20 extends WithFinals{
      @Override private final void f(){
            System.out.println("OverrideingPrivateE20.f()");
      }
      @Override private void g(){
            System.out.println("OverrideingPrivateE20.g()");
      }
}

class OverridingPrivate2E20 extends OverridingPrivateE20{
      @Override public final void f(){
            System.out.println("OverridingPrivate2E20.f()");
      }
      @Override public void g(){
            System.out.println("OverridingPrivate2E20.g()");
      }
}

public class E20_OverrideAnnotation{
      public static void main(String[] args){
            OverridingPrivate2E20 op2 = new OverridingPrivate2E20();
            op2.f();
            op2.g();
      }
}
