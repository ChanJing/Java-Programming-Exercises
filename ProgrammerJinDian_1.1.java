/*
 * Check the elements in a array are differect which means no repeat.
 * Only use array.
 */

// First, confirm that the elements are ASCII or Unicode
public boolean inUniqueChar2(String str){
	int strLength = str.length();
	if(strLength > 256) return false;

	boolean[] char_set = new boolean[256];
	for(int i = 0; i < strLength; i++){
		int var = str.charAt[i];
		if(char_set[val]){ //This element is found before
			return false;
		}
		char_set[val] = true;
	}
	return true;
}


/*
 * Only for a - z
 */
public boolean inUniqueChar2(String str){
	int strLength = str.length();
	int varA = (int) 'a';
	if(strLength > 26) return false;

	boolean[] char_set = new boolean[26];
	for(int i = 0; i < strLength; i++){
		int var = str.charAt[i] - varA;
		if(char_set[val]){ //This element is found before
			return false;
		}
		char_set[val] = true;
	}
	return true;
}