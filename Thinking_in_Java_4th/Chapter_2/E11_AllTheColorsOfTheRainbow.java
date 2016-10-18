//: D:/Code/Source/Java/Think in Java 4th/Chapter_2/E11_AllTheColorsOfTheRainbow.java

/****************** Exercise 11 **********************
 * Turn the AllTheColorsOfTheRainbow example into
 * a program that compiles and runs.
****************************************************/

package Chapter_2;

public class E11_AllTheColorsOfTheRainbow{
	int anIntegerRepresentingColors;
	void changeTheHueOfTheColor(int newHue){
		anIntegerRepresentingColors = newHue;
	}
	public static void main(String[] args){
		E11_AllTheColorsOfTheRainbow all = new E11_AllTheColorsOfTheRainbow();
		all.changeTheHueOfTheColor(27);
	}
}///:~
