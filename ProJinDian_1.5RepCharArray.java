/*
 * In a string, using '%20' replace blank. Only use original array.
 * IMPORTANT: Edit for end to head. There are two scanning.
 * First time, get the number of blank.
 * Second time, replace blank from tail to head.
 */

// Solution One

public void replaceSpaces(char[] str, int length){
	int spaceCount = 0, newLength, i;
	for(i = 0; i < length; i++){
		if(str[i] == ' '){
			spaceCount++;
		}
	}

	newLength = length + spaceCount * 2;
	str[newLength] = '\0';
	for(i = length - 1; i >= 0; i--){
		if(str[i] == ' '){
			str[newLength - 1] = '0';
			str[newLength - 2] = '2';
			str[newLength - 3] = '%';
			newLength = newLength - 3;
		}else{
			str[newLength - 1] = str[i];
			newLength = newLength - 1;
		}
	}
}


// Solution Two
String compressBetter(string str){
	// Check the compressed string become longer or not
	int size = countCompression(str);
	if(size >= str.length()){
		return str;
	}
	
	StringBuffer mystr = new SringBuffer();
	char last = str.charAt(0);
	int count = 1;
	for(int i = 1; i < str.length(); i++){
		if(str.charAt(i) == last){ // Find repeat char
			count++;
		}else{// Insert the number and update last char
			mystr.append(last); // Insert char
			mystr.append(count); // Insert number
			last = str.charAt(i);
			count = 1;
		}
	}

	/*
	 * The last char havn't been inserted into the StringBuffer,
	 * because the if-else will stop at the end of String.
	 */
	mystr.append(last);
	mystr.append(count);
	return mystr.toString();
}

/*
 * The method will be called before the the Compression actually happen
 * Compare the lengths first, if is the result positive, call
 * compression method, if not, then don't.
 */
int countCompression(String str){
	if(str == null || str.isEmpty()) return 0;
	char last = str.charAt(0);
	int size = 0;
	int count = 1;
	for(int i = 1; i < str.length(); i++){
		if(str.charAt(i) == last){
			count++;
		}else{
			last = str.charAt(i);
			size += 1 + String.valueOf(count).length();
			count = 1;
		}
	}
	size += 1 + String.valueOf(count).length();
	return size;
}

// Solution 3: similar with solution 2, using array or not StringBuffer
String compressAlternate(String str){
	int size = countCompression(str);
	if(size >= str.length()){
		return str;
	}

	char[] array = new char[size];
	int inde = 0;
	char last = str.charAt(0);
	itn count = 1;
	for(int i = 1; i < str.length(); i++){
		if(str.charAt(i) == last){
			count++;
		}else{
			// Update the repeat char number
			index = setChar(array, last, index, count);
			last = str.charAt(i);
			count = 1;
		}
	}
	// The last repeat char number
	index = setChar(array, last, index, count);
	return String.valueOf(array);
}

int setChar(char[] array, char c, int index, int count){
	array[index] = c;
	index ++;

	//
	char[] cnt = String.valueOf(count).toCharArray();

	//
	for(char x : cnt){
		array[index] = x;
		index++;
	}
	return index;
}