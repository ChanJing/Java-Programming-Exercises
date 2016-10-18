//: access/connection/ConnectionManager.java

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

public class ConnectionManager{
      private static Connection[] pool = new Connection[10];
      private static int counter = 0;
      static{
            // Create Connection array
            for(int i = 0; i < pool.length; i++)
                  // Increase the counter by create connection instance
                  pool[i] = new Connection();
      }
      // Very simple -- just hands out each one once:
      public static Connection getConnection(){
            if(counter < pool.length){
                  return pool[counter++];
            }
            return null;
      }
}///:~
