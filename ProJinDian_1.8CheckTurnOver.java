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
