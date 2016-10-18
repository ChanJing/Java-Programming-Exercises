//: reusing/E02_NewDetergent.java
// Connections that can be checked in.

/****************** Exercise 02 **********************
 * Inherit a new class from class Detergent.
 * Override scrub() and add a new method called
 * sterilize().
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/
package reusing;

class NewDetergent extends Detergent{
      public void scrub(){
            append(" NewDetergent.scrub()");
            super.scrub(); // Doesn't have to be first
      }
      public void sterilize(){append("sterilize()");}
}

public class E02_NewDetergent{
      public static void main(String args[]){
            NewDetergent nd = new NewDetergent();
            nd.dilute();
            nd.scrub();
            nd.sterilize();
            System.out.println(nd);
      }
}
