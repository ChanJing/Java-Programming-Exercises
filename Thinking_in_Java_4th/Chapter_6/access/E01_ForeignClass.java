//: access/E01_ForeignClass.java

/****************** Exercise 01 **********************
 * Create a class in a package. Create an
 * instance of your class outside of that package.
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/

package access;

public class E01_ForeignClass {
      public static void main(String[] args) {
            new access.local.E01_PackagedClass();
            System.out.println("Success!");
      }
} ///:~
