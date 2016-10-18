//: access/connection/Connection.java

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
package access.connection;

public class Connection{
      // Variable counter is static, means only one counter variable for all Connection instance!!!
      private static int counter = 0;
      // Different Connection instances have different id. counter is increasing!!!
      private int id = counter++;

      // toString() will be called. print(connection instance)
      public String toString()
            return "Connection " + id;
      public void doSomething(){}
}///:~
