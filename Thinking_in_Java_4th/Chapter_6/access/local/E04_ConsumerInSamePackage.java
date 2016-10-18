//: access/local/E04_ConsumerInSamePackage.java

/****************** Exercise 04 **********************
 * Show that protected methods have package
 * access but are not public.
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/
package access.local;

public class E04_ConsumerInSamePackage{
      public static void main(String[] args){
            E04_PackagedClass.greeting();
      }
}/* Output:
Hello client programer!
*///:~
