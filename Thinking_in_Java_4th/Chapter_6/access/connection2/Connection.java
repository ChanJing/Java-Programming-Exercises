//: access/connection2/Connection.java

/****************** Exercise 08 **********************
 * Following the form of the example Lunch.java
 * create a class called ConnectionManager that
 * manages a fixed array of Connection objects.
 * The client programmer must not be able to
 * via a static method in ConnectionManager.
 * ConnectionManager returns a null reference when
 * it runs out of objects. Test the classes in main().
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/
package access.connection2;

public class Connection{
      private static int counter = 0;
      private int id = counter++;
      Connection(){}
      public String toString(){
            return "Connection " + id;
      }
      public void doSomething(){}
      public void checkIn(){
            ConnectionManager.checkIn(this);
      }
}///:~
