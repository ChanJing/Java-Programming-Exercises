//: D:/Code/Source/Java/Think in Java 4th/Chapter_5/E08_ThisMethodCall.java

/****************** Exercise 08 *********************
 * Create a class with two methods. Within the
 * first method call the second method twice to
 * see it work, the first time without using this,
 * and the second time using this.
 * (You should not use this form in practice.)
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/

//package Chapter_5;

public class E08_This MethodCall{
      public void a(){
            b();
            this.b();
      }

      public void b(){
            System.out.println("b() called");
      }

      public static void main(String[] args[]){
            new E08_This MethodCall().a();
      }
}/* Output:
b() called
b() called
*///:~

