//: D:/Code/Source/Java/Think in Java 4th/Chapter_5/OrderOfInitialization.java
//Demonstrates initialization order.

// When the constructor is called to create a
// Window object, you 'll see a message.

class Window{
      Window(int marker) {print("Window(" + marker + ")");}
}

class House{
      Window w1 = new Window(1);
      House(){
            // Show that we're in the constructor;
            print("House()");
            w3 = new Window(33); // Reinitialize w3
      }
      w2 = new Window(2);
      void f(){ print("f()");}
      w3 = new Window(3); // At end
}

public class OrderOfInitialization{
      public static void main(String[] args){
            House h = new House();
            h.f(); // Shows that construction is done
      }
}/* Output:
Window(1)
Window(2)
Window(3)
House()
Window(33)
f()
*///:~
