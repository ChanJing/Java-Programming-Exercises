//: D:/Code/Source/Java/Think in Java 4th/Chapter_5/E17_ObjectReferences.java

/****************** Exercise 17 **********************
 * Create a class with a constructor that takes
 * a String argument. During construction, print
 * the argument. Create an array of object
 * references to this class, but don't create objects
 * to assign into the array. When you run the
 * program, notice whether the initialization
 * messages from the constructor calls are printed.
 * @author Caleb Yuan Tian
 * @author www.CalebBlog.com
 * @version 1.0
****************************************************/
//package Chapter_5;

class Test{
      static int i = 0;
      Test(String s){
            System.out.println("String constructor; s = " + s);
      }
      Test(){
            System.out.println("String constructor; i = " + i++);
      }
}

public class E17_ObjectReferences{
      // You can define the array as a field in the class:
      static Test[] array1 = new Test[5];
      public static void main(String[] args){
            // Or as a temporary inside main:
            Test[] array2 = new Test[5];
            for(int i = 0; i < array2.length; i++){
                  array1[i] = new Test(Integer.toString(i));
                  array2[i] = new Test();
            }
      }
}

// 无法从静态上下文中引用非静态
