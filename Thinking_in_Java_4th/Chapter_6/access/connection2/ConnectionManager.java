//: access/connection2/ConnectionManager.java

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

public class ConnectionManager{
      private static Connection[] pool = new Connection[10];
      static {
            for(int i = 0; i < pool.length; i++)
                  pool[i] = new Connection();
      }

      // Produce the first available connection:
      public static Connection getConnection(){
            for(int i = 0; i < pool.length; i++)
                  if(pool[i] != null){
                        Connection c = pool[i];
                        pool[i] = null; // Indicates "in use"
                        return c;
                  }
            return null; // None left
      }
      public static void checkIn(Connection c){
            for(int i = 0; i < pool.length; i++)
                  if(pool[i] == null){
                        pool[i] = c; // Check it back in
                        return;
                  }
      }
}
