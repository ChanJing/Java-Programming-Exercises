//: reusing/E08_CallBaseConstructor.java

/****************** Exercise 08 **********************
 * Create a base class with only a non-default
 * constructor, and a derived class with both a
 * default (no-arg) and non-default constructor.
 * Call the base-class constructor in the
 * derived-class constructors.
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/
package reusing;

class BaseNonDefault{
      public BaseNonDefault(int i){}
}

class DerivedTwoConstructors extends BaseNonDefault{
      public DerivedTwoConstructors(){ super(28); }
      public DerivedTwoConstructors(int i) { super(i); }
}

public class E08_CallBaseConstructor{
      public static void main(String[] args){
            new DerivedTwoConstructors();
            new DerivedTwoConstructor(82);
      }
}///:~

