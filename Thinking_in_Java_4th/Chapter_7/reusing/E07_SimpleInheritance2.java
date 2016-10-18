//: reusing/E07_SimpleInheritance2.java

/****************** Exercise 07 **********************
 * Modify Exercise 5 so A and B have
 * constructors with arguments instead of default
 * constructors. Write a constructor for C and
 * perform all initialization within it.
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/
package reusing;

class A2{
      public A2(String s){ System.out.println("A2( )" + s);}
}

class B2{
      public B2(String s){ System.out.println("B2( )" + s);}
}

class C2 extends A2{
      B2 b;
      public C2(String s){
            super(s);
            System.out.println("C2( )" + s);
            b = new B2(s);
      }
}

public class E07_SimpleInheritance2{
      public static void main(String[] args){
            new C2("Init String");
      }
}  /* Output:
A2(): Init string
C2(): Init string
B2(): Init string
*///:~
