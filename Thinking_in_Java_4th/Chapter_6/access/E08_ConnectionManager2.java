//: access/E08_ConnectionManager2.java
// Connections that can be checked in.

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
package access;
import access.connection2.*;

public class E08_ConnectionManager2{
      public static void main(String[] args){
            Connection[] ca = new Connection[10];
            // Use up call the connections
            for(int i = 0; i < 10; i++)
                  ca[i] = ConnectionManager.getConnection();
            // Should produce "null" since there are no
            // more connections:
            System.out.println(ConnectionManager.getConnection());
            //Return connections, then get them out:
            for(int i = 0; i < 5; i++){
                  ca[i].checkIn();
                  // As soon as check in a new connection instance, check it out immediately.
                  // Therefore, c always equal pool[0]!
                  Connection c = Connectionmanager.getConnection();
                  System.out.println(c);
                  c.doSomething();
                  c.checkIn();
            }
      }
}/* Output:
null
Connection 0
Connection 0
Connection 0
Connection 0
Connection 0
*///:~
