/*
 * Compare two Strings, verify one string equal
 * another one after be reformatted.
 * Capital? Blank? 
 * IMPORTANT: they have same length
 */

// Solution One: they have same order if they are sorted by Alphabet
public String sort(String s){
	char[] content = s.toCharArray();
	java.util.Arrays.sort(content);
	return new string(content);
}

public boolean permutation(String s, String t){
	if(s.length() != t.length()){
		return false;
	}
	return sort(s).equals(sort(t));
}

// Solution Two: They have same number of char, so we can calculate it.
public boolean permutation(String s, String t){
	if(s.length != t.length()){
		return false;
	}

	int[] letters = new int[256]; //ASCII

	char[] s_array = s.toCharArray();
	for(char c : s_array){// Calculate the number of each char in String
		letters[c]++;
	}

	for(int i = 0; i < t.length(); i++){
		int c = (int) t.charAt(i);
		if(--letters[c] < 0){
			return false;
		}
	}
	return true;
}