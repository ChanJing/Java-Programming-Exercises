/*
 * Average performance : O(n log n)
 * Worst-case performance 	O(n * n)
 * Space complexity : O(log n)
 */

void quickSort(int arr[], int left, int right){
	int index = partition(arr, left, right);
	if(left < index - 1){ // Sort the left part
		quickSort(arr, left, index - 1);
	}
	if(index < right){ // Sort the right part
		quickSort(arr, index, right);
	}
}

int partition(int arr[], int left, int right){
	int pivot = arr[(left + right) / 2]; // Find out a pivot
	while(left <= right){
		// Find out the elements on left which should be moved to right
		while(arr[left] < pivot) left++;

		// Find out the element on right which should be moved to left
		while(arr[right] < pivot) right--;
		if(left <= right){
			swap(arr, left, right); // swap these two elements
			left++;
			right--;
		}
	}
	return left;
}