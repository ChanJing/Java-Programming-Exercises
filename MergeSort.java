void mergesort(int[] array, int low, int high){
	if(low < high){
		int middle = (low + high) / 2;
		mergesort(array, low, middle); // Sort the left part
		mergesort(array, middle + 1, high); // Sort the right part
		merge(array, low, middle, high); // Merge
	}
}

void merge(int[] array, int low, int middle, int high){
	int[] helper = new int[array.length];
	/*
	 * Copy the array into helper
	*/
	for(int i = low; i <= high; i++){
		helper[i] = array[i];
	}

	int helperLeft = low;
	int helperRight = middle + 1;
	int current = low;

	/*
	 * Iterate helper. Compare the elements in left part and
	 * right part, copy the smaller elements into the
	 * original array.
	*/
	while(helperLeft <= middle && helperRight <= high){
		if(helper[helperLeft] <= helper[helperRight]){
			array[current] = helper[helperLeft];
			helperLeft++;
		}else{ // the right element is smaller than the left one
			array[current] = helper[helperRight];
			helperRight++;
		}
		current++;
	}

	/*
	 * Copy the rest left elements into target array
	 * (if these elements are larger than the all right elements)
	 */
	int remaining = middle - helperLeft;
	for(int i = 0; i <= remaining; i++){
		array[current + i] = helper[helperLeft + i]''
	}
}

public static void mergesort(int[] array){
	int[] helper = new int[array.length];
	mergesort(array, helper, 0, array.length - 1);
}