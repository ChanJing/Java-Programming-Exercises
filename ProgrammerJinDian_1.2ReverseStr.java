/*
 * Reverse a string
 */

import java.io.*;
import java.util.*;

public class reverseString{
	String reverseStr(String str){
		try{
			String revStr = new StringBuilder(str).reverse().toString();
			return revStr;
		}catch (IOException e){
			//e.printStackTrace();
		}
	}
}