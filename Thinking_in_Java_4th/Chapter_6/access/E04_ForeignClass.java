//: access/E04_ForeignClass.java

/****************** Exercise 04 **********************
 * Show that protected methods have package
 * access but are not public.
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/
package access;

public class E04_ForeignClass{
      public static void main(String[] args){
            access.local.E04_PackagedClass.greeting();
}
