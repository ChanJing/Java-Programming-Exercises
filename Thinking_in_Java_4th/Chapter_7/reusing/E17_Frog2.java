//: reusing/E17_Frog2.java

/****************** Exercise 17 **********************
 * Modify Exercise 16 so Frog overrides the
 * method definitions from the base class
 * (provides new definitions using the same
 * method signatures). Note what happens in
 * main().
 * @author Caleb Yuan Tian
 * @version 1.0
****************************************************/
package reusing;

class Amphibian{
      public void moveInWater(){
            System.out.println("Moving in Water");
      }
      public void moveOnLand(){
            System.out.println("Moving on Land");
      }
}

class Frog2 extends Amphibian{
      @Override
      public void moveInWater(){
            System.out.println("Frog swimming");
      }
      @Override
      public void moveOnLand(){
            System.out.println("Frog jumping");
      }
}

public class E17_Frog2{
      public static void main(String[] args){
            Amphibian a = new Frog2();
            a.moveInWater();
            a.moveOnLand();
      }
} /* Output:
Moving in Water
Moving on Land
*///:~


