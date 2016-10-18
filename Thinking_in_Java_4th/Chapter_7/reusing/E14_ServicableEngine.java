//: reusing/E14_ServicableEngine.java

/****************** Exercise 14 **********************
 * In Car.java add a service() method to Engine
 * and call this method in main().
 * @author Caleb Yuan Tian
 * @version 1.0
****************************************************/
package reusing;

class Engine{
      public final void start(){}
      public final void rev(){}
      public final void stop(){}
}

class Wheel{
      public final void inflate(int psi){}
}

class Window{
      public final void rollup(){}
      public final void rolldown(){}
}

class Door{
      public Window window = new Window();
      public final void open(){}
      public final void close(){}
}

class ServicableEngine extends Engine{
      public final void service(){}
}

class ServicableCar{
      public ServicableEngine engine = new ServicableEngine();
      public Wheel[] wheel = new Wheel[4];
      public Door
            left = new Door(),
            right = new Door(); // 2 - door
      public ServicableCar(){
            for(int i = 0; i < 4; i ++)
                  wheel[i] = new Wheel();
      }
}

public class E14_ServicableEngine{
      public static void main(String[] args){
            ServicableCar car = new ServicableCar();
            car.left.window.rollup();
            car.wheel[0].inflate(36);
            car.engine.service();
      }
} ///:~
