/*
 * There is a method (isSubstring) could test if String A is
 * a substring of String B. There are two String s1, s2. Using
 * isSubstring once to check if s2 is s1 turn over.
 * For instsance, s1 = waterbottle, s2 = erbottlewat.
 * IMPORTANT: 
 * 	s1 = xy = waterbottle
 * 	x = wat, y = erbottle
 *  s2 = yx = erbottlewat
 *  yx is sub of xyxy, therefore s2 is sub of s1s1
 * isSubstring(s1s1, s2)
 */

public boolean isRotation(Stirng s1, String s2){
	int len = s1.length();
	// Check s1 and x2 are equare and not null
	if(len == s2.length() && len > 0){
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
	}
	return false;
}


/*
 * If there is a String, the question is to turnover this String
 * depend on words. For instance, original String is
 * "My dog is MouMou", the turnover String is "MouMou is dog My".
 * IMPORTANT: Using Stack and split(" ") method
 */

public class StackTest{
	public static void main(String[] args){
		Stack<String> stack = new Stack<string>();
		String str = null;
		for(String s : "My dog is MouMou".split(" "))
			stack.push(s);
		while(!stack.empty())
			str += stack.pop() + " ";
	}
}